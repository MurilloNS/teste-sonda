package br.com.sonda.testejava.services.impl;

import br.com.sonda.testejava.components.NullAwareBeanUtilsBean;
import br.com.sonda.testejava.dto.EmpresaRequest;
import br.com.sonda.testejava.dto.EmpresaUpdate;
import br.com.sonda.testejava.entities.Empresa;
import br.com.sonda.testejava.repositories.EmpresaRepository;
import br.com.sonda.testejava.services.EmpresaService;
import br.com.sonda.testejava.services.exceptions.CnpjAlreadyExist;
import br.com.sonda.testejava.services.exceptions.EmpresaNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;
    private final NullAwareBeanUtilsBean beanUtils;

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    @Override
    @Transactional
    public Empresa saveEmpresa(EmpresaRequest empresaRequest) {
        if(empresaRepository.findByCnpj(empresaRequest.getCnpj()) == null) {
            Empresa emprea = Empresa.builder().nome(empresaRequest.getNome())
                    .empresa(empresaRequest.getNome()).email(empresaRequest.getEmail())
                    .cnpj(empresaRequest.getCnpj()).build();

            return empresaRepository.save(emprea);
        } else {
            throw new CnpjAlreadyExist("Esse CNPJ já está cadastrado!");
        }
    }

    @Override
    @Transactional
    public EmpresaUpdate atualizarEmpresa(Long id, EmpresaUpdate empresaUpdate) throws InvocationTargetException, IllegalAccessException {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new EmpresaNotFoundException("Empresa não encontrada!"));
        beanUtils.copyProperties(empresa, empresaUpdate);
        empresaRepository.save(empresa);
        return empresaUpdate;
    }

    @Override
    public void deletarEmpresa(Long id) {
        empresaRepository.deleteById(id);
    }
}