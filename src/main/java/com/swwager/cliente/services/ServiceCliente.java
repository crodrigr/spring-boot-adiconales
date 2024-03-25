package com.swwager.cliente.services;

import java.net.UnknownHostException;
import java.util.List;

import com.swwager.cliente.exception.BussinesRuleException;
import com.swwager.cliente.repositories.entities.Cliente;

public interface ServiceCliente {

    List<Cliente> findAll();

    Cliente findById(Long id)throws BussinesRuleException;

    Cliente save(Cliente cliente);

    Cliente update(Long id,Cliente cliente);

    void delete(Long id);

    Cliente findByEmail(String email);
    
}
