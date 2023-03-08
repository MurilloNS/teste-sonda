package br.com.sonda.testejava.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "tb_empresas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String empresa;
    @Email
    private String email;
    @CNPJ
    private String cnpj;
}