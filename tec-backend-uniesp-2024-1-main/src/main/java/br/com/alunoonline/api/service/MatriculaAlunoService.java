package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.AtualizarNotasRequest;
import br.com.alunoonline.api.dtos.DisciplinasAlunoResponse;
import br.com.alunoonline.api.dtos.HistoricoAlunoResponse;
import br.com.alunoonline.api.enums.MatriculaAlunoStatusEnum;
import br.com.alunoonline.api.model.MatriculaAluno;
import br.com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaAlunoService {

    public static final double GRADE_AVG_TO_APPROVE = 7.0;

    private final MatriculaAlunoRepository matriculaAlunoRepository;

    @Autowired
    public MatriculaAlunoService(MatriculaAlunoRepository matriculaAlunoRepository) {
        this.matriculaAlunoRepository = matriculaAlunoRepository;
    }

    public void create(MatriculaAluno matriculaAluno) {
        matriculaAluno.setStatus(MatriculaAlunoStatusEnum.MATRICULADO);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public void updateGrades(Long matriculaAlunoId, AtualizarNotasRequest atualizarNotasRequest) {
        MatriculaAluno matriculaAluno = findMatriculaAlunoById(matriculaAlunoId);
        updateStudentGrades(matriculaAluno, atualizarNotasRequest);
        updateStudentStatus(matriculaAluno);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public void updateStudentGrades(MatriculaAluno matriculaAluno, AtualizarNotasRequest atualizarNotasRequest) {
        if (atualizarNotasRequest.getGrade1() != null) {
            matriculaAluno.setGrade1(atualizarNotasRequest.getGrade1());
        }
        if (atualizarNotasRequest.getGrade2() != null) {
            matriculaAluno.setGrade2(atualizarNotasRequest.getGrade2());
        }
    }

    public void updateStudentStatus(MatriculaAluno matriculaAluno) {
        if (matriculaAluno.getGrade1() != null && matriculaAluno.getGrade2() != null) {
            double average = calculateAverage(matriculaAluno.getGrade1(), matriculaAluno.getGrade2());
            matriculaAluno.setStatus(average >= GRADE_AVG_TO_APPROVE ? MatriculaAlunoStatusEnum.APROVADO : MatriculaAlunoStatusEnum.REPROVADO);
        }
    }

    private double calculateAverage(Double grade1, Double grade2) {
        return (grade1 + grade2) / 2.0;
    }

    public void updateStatusToBreak(Long matriculaAlunoId) {
        MatriculaAluno matriculaAluno = findMatriculaAlunoById(matriculaAlunoId);

        if (!MatriculaAlunoStatusEnum.MATRICULADO.equals(matriculaAluno.getStatus())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é possível trancar uma matrícula com o status MATRICULADO");
        }

        changeStatus(matriculaAluno, MatriculaAlunoStatusEnum.TRANCADO);
    }

    public void changeStatus(MatriculaAluno matriculaAluno, MatriculaAlunoStatusEnum matriculaAlunoStatusEnum) {
        matriculaAluno.setStatus(matriculaAlunoStatusEnum);
        matriculaAlunoRepository.save(matriculaAluno);
    }

    public HistoricoAlunoResponse getAcademicTranscript(Long alunoId) {
        List<MatriculaAluno> matriculasDoAluno = matriculaAlunoRepository.findByStudentId(alunoId);

        if (matriculasDoAluno.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Esse aluno não possui matrículas");
        }

        HistoricoAlunoResponse historico = new HistoricoAlunoResponse();
        historico.setStudentName(matriculasDoAluno.get(0).getStudent().getName());
        historico.setStudentEmail(matriculasDoAluno.get(0).getStudent().getEmail());

        List<DisciplinasAlunoResponse> disciplinasList = buildDisciplinasList(matriculasDoAluno);
        historico.setStudentSubjectsResponseList(disciplinasList);

        return historico;
    }

    private List<DisciplinasAlunoResponse> buildDisciplinasList(List<MatriculaAluno> matriculasDoAluno) {
        List<DisciplinasAlunoResponse> disciplinasList = new ArrayList<>();
        for (MatriculaAluno matricula : matriculasDoAluno) {
            DisciplinasAlunoResponse disciplinasAlunoResponse = new DisciplinasAlunoResponse();
            disciplinasAlunoResponse.setSubjectName(matricula.getSubject().getName());
            disciplinasAlunoResponse.setProfessorName(matricula.getSubject().getProfessor().getName());
            disciplinasAlunoResponse.setGrade1(matricula.getGrade1());
            disciplinasAlunoResponse.setGrade2(matricula.getGrade2());
            disciplinasAlunoResponse.setAverage(calculateAverageIfBothGradesExist(matricula));
            disciplinasAlunoResponse.setStatus(matricula.getStatus());
            disciplinasList.add(disciplinasAlunoResponse);
        }
        return disciplinasList;
    }

    private Double calculateAverageIfBothGradesExist(MatriculaAluno matricula) {
        if (matricula.getGrade1() != null && matricula.getGrade2() != null) {
            return calculateAverage(matricula.getGrade1(), matricula.getGrade2());
        }
        return null;
    }

    private MatriculaAluno findMatriculaAlunoById(Long matriculaAlunoId) {
        return matriculaAlunoRepository.findById(matriculaAlunoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Matrícula não encontrada"));
    }
}

