package com.example.cursorestfulspringboot.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ClienteController {

    List <Cliente> clientes;

    @PostConstruct
    public void criarClientes(){
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();
        Cliente c4 = new Cliente();

        c1.codigo = 1;
        c1.nome = "Anna";
        c1.endereco = "Rua A, 01";
        c1.saldo = 111;

        c2.codigo = 2;
        c2.nome = "Bruno";
        c2.endereco = "Rua B, 02";
        c2.saldo = 222;

        c3.codigo = 3;
        c3.nome = "Carlos";
        c3.endereco = "Rua C, 03";
        c3.saldo = 333;

        c4.codigo = 4;
        c4.nome = "Dani";
        c4.endereco = "Rua D, 04";
        c4.saldo = 444;

        clientes = Arrays.asList(c1,c2,c3,c4);
    }

    @GetMapping("/clientes")
    public List <Cliente> getClientes(){
        return clientes;
    }

    @GetMapping("/clientes/{codigo}")
    public Cliente getCliente(@PathVariable int codigo){
        Cliente cli = null;
        for(Cliente aux : clientes){
            if(aux.codigo == codigo){
                cli = aux;
                break;
            }
        }
        return cli;
    }
}