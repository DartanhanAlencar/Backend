package br.com.alunoonline.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarNotasRequest {
    private Double grade1;
    private Double grade2;
}

