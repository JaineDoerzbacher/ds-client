package com.ds.client.resourses;

import com.ds.client.entities.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientResourse {

    @GetMapping // Para indicar que o método responde a requisição do tipo GET do HTTP
    public ResponseEntity<List<Client>> findAll() {
        List<Client> list = List.of(new Client(1L, "Maria", "12345678901", 6500.0, null, 3),
                new Client(2L, "João", "12345678902", 3500.0, null, 2));
        return ResponseEntity.ok().body(list);
    }
}
