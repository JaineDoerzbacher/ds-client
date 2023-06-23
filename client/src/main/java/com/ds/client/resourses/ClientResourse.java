package com.ds.client.resourses;

import com.ds.client.dtos.ClientDTO;
import com.ds.client.entities.Client;
import com.ds.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResourse {

    @Autowired
    private ClientService service;

    @GetMapping // Para indicar que o método responde a requisição do tipo GET do HTTP
    public ResponseEntity<Page<ClientDTO>> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page, // Para indicar o parâmetro da requisição
                                                   @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage, // Para indicar o parâmetro da requisição
                                                   @RequestParam(value = "direction", defaultValue = "ASC") String direction, // Para indicar o parâmetro da requisição
                                                   @RequestParam(value = "orderBy", defaultValue = "name") String orderBy) { // Para indicar o parâmetro da requisição)

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<ClientDTO> list = service.findAllPaged(pageRequest); // Para acessar o serviço

        return ResponseEntity.ok().body(list); // Para retornar a resposta com sucesso do HTTP
    }
}
