package com.swwager.cliente.repositories;

import org.springframework.data.repository.CrudRepository;

import com.swwager.cliente.repositories.entities.Cliente;

public interface RepositoryCliente  extends CrudRepository<Cliente,Long>{

    Cliente findByEmail(String email);
    
}
