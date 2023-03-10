package br.com.sonda.testejava.services;

import br.com.sonda.testejava.dto.EmpresaRequest;
import br.com.sonda.testejava.dto.EmpresaUpdate;
import br.com.sonda.testejava.entities.Empresa;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface EmpresaService {
    public List<Empresa> listarEmpresas();

    Empresa saveEmpresa(EmpresaRequest empresaRequest);

    EmpresaUpdate atualizarEmpresa(Long id, EmpresaUpdate empresaUpdate) throws InvocationTargetException, IllegalAccessException;

    void deletarEmpresa(Long id);
}
