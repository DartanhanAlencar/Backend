package br.com.alunoonline.api.service;

import br.com.alunoonline.api.dtos.CriarAlunoRequest;
import br.com.alunoonline.api.enums.FinanceiroStatusEnum;
import br.com.alunoonline.api.model.Aluno;
import br.com.alunoonline.api.model.Curso;
import br.com.alunoonline.api.model.FinanceiroAluno;
import br.com.alunoonline.api.repository.AlunoRepository;
import br.com.alunoonline.api.repository.CursoRepository;
import br.com.alunoonline.api.repository.FinanceiroAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private FinanceiroAlunoRepository financeiroAlunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public void create(CriarAlunoRequest criarAlunoRequest) {
        Curso curso = findCursoById(criarAlunoRequest.getCourseId());
        Aluno alunoSaved = saveAluno(criarAlunoRequest, curso);
        createFinanceiroInformation(alunoSaved, criarAlunoRequest);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado"));
    }

    public void update(Long id, Aluno aluno) {
        Aluno alunoFromDb = findById(id);
        updateAlunoDetails(alunoFromDb, aluno);
        alunoRepository.save(alunoFromDb);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

    private Curso findCursoById(Long courseId) {
        return cursoRepository.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));
    }

    private Aluno saveAluno(CriarAlunoRequest criarAlunoRequest, Curso curso) {
        Aluno aluno = new Aluno(null, criarAlunoRequest.getName(), criarAlunoRequest.getEmail(), curso);
        return alunoRepository.save(aluno);
    }

    private void createFinanceiroInformation(Aluno aluno, CriarAlunoRequest criarAlunoRequest) {
        FinanceiroAluno financeiroAluno = new FinanceiroAluno(
                null,
                aluno,
                criarAlunoRequest.getDiscount(),
                criarAlunoRequest.getDueDate(),
                FinanceiroStatusEnum.EM_DIA
        );
        financeiroAlunoRepository.save(financeiroAluno);
    }

    private void updateAlunoDetails(Aluno alunoFromDb, Aluno aluno) {
        alunoFromDb.setName(aluno.getName());
        alunoFromDb.setEmail(aluno.getEmail());
    }
}

