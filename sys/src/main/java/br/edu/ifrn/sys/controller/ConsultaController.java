package br.edu.ifrn.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.edu.ifrn.sys.domain.consulta.Consulta;
import br.edu.ifrn.sys.repository.ConsultaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("consultas")
@CrossOrigin(origins = "*")
public class ConsultaController {

    @Autowired
    private ConsultaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrar(@RequestBody @Valid Consulta consulta,
        UriComponentsBuilder uriBuilder) {
        Consulta consultaLocal = repository.save(consulta);
        var uri = uriBuilder.path("/consultas/{id}").buildAndExpand(consultaLocal.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> detalhar(@PathVariable Long id) {
        Consulta consulta = repository.getReferenceById(id);
        return ResponseEntity.ok(consulta);
    }

    @GetMapping
    public ResponseEntity<Page<Consulta>> listar(@PageableDefault(size = 30, sort = { "nome" }) Pageable paginacao) {
        var consultas = repository.findAll(paginacao);
        return ResponseEntity.ok(consultas);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Consulta> atualizar(@RequestBody @Valid Consulta consulta) {
        Consulta consultaLocal = repository.findById(
            consulta.getId()).get();

            consultaLocal.setData_consulta(consulta.getData_consulta());
            consultaLocal.setDiagnostico(consulta.getDiagnostico());
            consultaLocal.setPrescricao(consulta.getPrescricao());
            consultaLocal.setMedico(consulta.getMedico());
            consultaLocal.setPaciente(consulta.getPaciente());

        return ResponseEntity.ok(consultaLocal);
    }

}