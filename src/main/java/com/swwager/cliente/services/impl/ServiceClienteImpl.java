package com.swwager.cliente.services.impl;

import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swwager.cliente.exception.BussinesRuleException;
import com.swwager.cliente.repositories.RepositoryCliente;
import com.swwager.cliente.repositories.entities.Cliente;
import com.swwager.cliente.services.ServiceCliente;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServiceClienteImpl implements ServiceCliente {

    private RepositoryCliente repositoryCliente;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) repositoryCliente.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id)throws BussinesRuleException, UnknownHostException {
        Optional<Cliente> clienteOptional=repositoryCliente.findById(id);
        if(!clienteOptional.isPresent()){
            BussinesRuleException exception= new BussinesRuleException("1025","Error no existe cliente",HttpStatus.PRECONDITION_FAILED);
            throw exception; 
        }
        return clienteOptional.get();
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return repositoryCliente.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Optional<Cliente> clienteOptinal=repositoryCliente.findById(id);
        if(clienteOptinal.isPresent()){
            repositoryCliente.delete(clienteOptinal.get());
        }       
    }

    @Override
    public Cliente update(Long id, Cliente cliente) {
       Optional<Cliente> clienteCurrentOptional=repositoryCliente.findById(id);

       if(clienteCurrentOptional.isPresent()){
          Cliente clienteCurrent=clienteCurrentOptional.get();
          clienteCurrent.setNombre(cliente.getNombre());
          clienteCurrent.setApellido(cliente.getApellido());
          clienteCurrent.setEmail(cliente.getEmail()); 
          repositoryCliente.save(clienteCurrent);
          return clienteCurrent;         
       }

       return null;
       
       
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findByEmail(String email) {
        return repositoryCliente.findByEmail(email);
    }

}
