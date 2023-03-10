package br.com.sonda.testejava.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpresaRequest {
    private Long id;
    private String nome;
    private String empresa;
    @Email
    private String email;
    @CNPJ
    private String cnpj;
}
