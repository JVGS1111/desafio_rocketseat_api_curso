package br.com.dev.guerber.desafio_rocketseat_api_curso.modules.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private String message;
    private String field;
}
