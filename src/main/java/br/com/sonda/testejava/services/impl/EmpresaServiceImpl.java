package br.com.sonda.testejava.services.impl;

import br.com.sonda.testejava.entities.Empresa;
import br.com.sonda.testejava.repositories.EmpresaRepository;
import br.com.sonda.testejava.services.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {
    private final EmpresaRepository empresaRepository;

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }
}