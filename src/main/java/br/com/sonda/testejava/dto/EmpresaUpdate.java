package br.com.sonda.testejava.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaUpdate {
    private String nome;
    private String empresa;
    private String email;
    private String cnpj;
}
