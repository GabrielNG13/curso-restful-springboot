package com.example.cursorestfulspringboot.controller;

import java.util.Arrays;
import java.util.List;

import com.example.cursorestfulspringboot.model.Cliente;
import com.example.cursorestfulspringboot.repository.ClienteRepository;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository repositorio;

    @GetMapping("/clientes")
    public List <Cliente> getClientes(){
        return repositorio.getAllClientes();
    }

    @GetMapping("/clientes/{codigo}")
    public Cliente getCliente(@PathVariable int codigo) {
        return repositorio.getClienteByCodigo(codigo);
    }

    @PostMapping("/clientes")
    public Cliente salvar(@RequestBody Cliente cliente) {
        return repositorio.save(cliente);
    }
}