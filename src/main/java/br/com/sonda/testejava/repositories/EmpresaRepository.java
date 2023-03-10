package br.com.sonda.testejava.repositories;

import br.com.sonda.testejava.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findByCnpj(String cnpj);
}