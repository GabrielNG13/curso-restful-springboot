package com.example.cursorestfulspringboot.controller;

import java.net.URI;
import java.util.List;

import com.example.cursorestfulspringboot.model.Cliente;
import com.example.cursorestfulspringboot.repository.ClienteRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repositorio;

    @GetMapping()
    public List <Cliente> getClientes(){
        return repositorio.getAllClientes();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity <Cliente> getCliente(@PathVariable int codigo) {
        Cliente cliente = repositorio.getClienteByCodigo(codigo);

        if(cliente != null){
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity <Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente novoCliente = repositorio.save(cliente);
        URI uri = URI.create("http://localhost:8080/clientes/" + novoCliente.getCodigo());
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity <Void> remover(@PathVariable int codigo) {
        Cliente cliente = repositorio.getClienteByCodigo(codigo);

        if(cliente != null){
            repositorio.remove(cliente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }

    @PutMapping("/{codigo}")
    public ResponseEntity <Cliente> atualizar(@PathVariable int codigo, @RequestBody Cliente cliente) {

        if(repositorio.getClienteByCodigo(codigo) != null){
            cliente.setCodigo(codigo);
            cliente = repositorio.update(cliente);
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
        
    }

}