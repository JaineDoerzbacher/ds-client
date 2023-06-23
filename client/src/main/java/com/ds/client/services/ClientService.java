package com.ds.client.services;

import com.ds.client.dtos.ClientDTO;
import com.ds.client.entities.Client;
import com.ds.client.repositories.ClientRepository;
import com.ds.client.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {

            Page<Client> list = repository.findAll(pageRequest);
            return list.map(ClientDTO::new);
    }

    public ClientDTO findById(Long id) {
        Optional<Client> obj = repository.findById(id);
        Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ClientDTO(entity);
    }
}
