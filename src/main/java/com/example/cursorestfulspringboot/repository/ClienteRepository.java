package com.example.cursorestfulspringboot.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.cursorestfulspringboot.model.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteRepository {
    
    private List <Cliente> clientes;

    @PostConstruct
    public void criarClientes(){
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();
        Cliente c3 = new Cliente();
        Cliente c4 = new Cliente();

        c1.setCodigo(1);
        c1.setNome("Anna");
        c1.setEndereco("Rua A, 01");
        c1.setSaldo(111);

        c2.setCodigo(2);
        c2.setNome("Bruno");
        c2.setEndereco("Rua B, 02");
        c2.setSaldo(222);

        c3.setCodigo(3);
        c3.setNome("Carlos");
        c3.setEndereco("Rua C, 03");
        c3.setSaldo(333);

        c4.setCodigo(4);
        c4.setNome("Dani");
        c4.setEndereco("Rua D, 04");
        c4.setSaldo(444);

        clientes = new ArrayList<Cliente>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);

    }

    public List <Cliente> getAllClientes() {
        return clientes;
    }

    public Cliente getClienteByCodigo(int codigo) {
        for(Cliente aux : clientes){
            if(aux.getCodigo() == codigo){
                return aux;
            }
        }
        return null;
    }

    public Cliente save(Cliente cliente) {
        cliente.setCodigo(clientes.size() + 1);
        clientes.add(cliente);
        return cliente;
    }
}
