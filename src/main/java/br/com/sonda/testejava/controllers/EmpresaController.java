package br.com.sonda.testejava.controllers;

import br.com.sonda.testejava.dto.EmpresaRequest;
import br.com.sonda.testejava.dto.EmpresaUpdate;
import br.com.sonda.testejava.entities.Empresa;
import br.com.sonda.testejava.services.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/listaEmpresas")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> salvarEmpresa(@Valid @RequestBody EmpresaRequest empresaRequest) {
        Empresa newEmpresa = empresaService.saveEmpresa(empresaRequest);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(newEmpresa.getId())
                .toUri();

        return ResponseEntity.created(location).body(newEmpresa);
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        return ResponseEntity.ok(empresaService.listarEmpresas());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmpresaUpdate> atualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaUpdate empresaUpdate) throws InvocationTargetException, IllegalAccessException {
        return ResponseEntity.ok(empresaService.atualizarEmpresa(id, empresaUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEmpresa(@PathVariable Long id) {
        empresaService.deletarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}