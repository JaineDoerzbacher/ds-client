package com.ds.client.services;

import com.ds.client.dtos.ClientDTO;
import com.ds.client.entities.Client;
import com.ds.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {

            Page<Client> list = repository.findAll(pageRequest);
            return list.map(ClientDTO::new);
    }

}
