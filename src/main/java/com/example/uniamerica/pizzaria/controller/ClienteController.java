package com.example.uniamerica.pizzaria.controller;

import com.example.uniamerica.pizzaria.dto.ClienteDTO;
import com.example.uniamerica.pizzaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoa")
@CrossOrigin(origins="http://localhost:4200")

public class ClienteController {
    @Autowired
    ClienteService service;
    @GetMapping("/id/{id}")
    public ResponseEntity<ClienteDTO>findById(@PathVariable("id") final Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/todos")
    public ResponseEntity<List<ClienteDTO>>getAll(){

        return ResponseEntity.ok(service.getAll());
    }
    @GetMapping("/todos/clientes")
    public ResponseEntity<List<ClienteDTO>>getAllClientes(){
        return ResponseEntity.ok(service.getAllClientes());
    }
    @GetMapping("/todos/funcionarios")
    public ResponseEntity<List<ClienteDTO>>getAllFuncionarios(){
        return ResponseEntity.ok(service.getAllFuncionarios());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<ClienteDTO>cadastrar(@RequestBody @Validated ClienteDTO pessoa){
        return ResponseEntity.ok(service.post(pessoa));
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<ClienteDTO>atualizar(@RequestBody @Validated ClienteDTO pessoa, @PathVariable long id){
        return ResponseEntity.ok(service.put(pessoa, id));
    }
    @DeleteMapping("/desativar/{id}")
    public ResponseEntity<ClienteDTO>desativar(@PathVariable ("id") final long id){
        return ResponseEntity.ok(service.desativar(id));
    }
    @DeleteMapping("/ativar/{id}")
    public ResponseEntity<ClienteDTO>ativar(@PathVariable ("id") final long id){
        return ResponseEntity.ok(service.ativar(id));
    }
}