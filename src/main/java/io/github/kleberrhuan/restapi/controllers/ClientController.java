package io.github.kleberrhuan.restapi.controllers;

import io.github.kleberrhuan.restapi.entities.Client;
import io.github.kleberrhuan.restapi.records.client.ClientData;
import io.github.kleberrhuan.restapi.records.client.ClientListData;
import io.github.kleberrhuan.restapi.records.client.ClientPutData;
import io.github.kleberrhuan.restapi.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {


    private final ClientRepository repository;

    @Autowired
    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public void create(@RequestBody ClientData body) {
        repository.save(new Client(body));
    }

    @GetMapping
    public Page<ClientListData> getAll(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        return repository.findAllByInactiveFalse(pageable).map(ClientListData::new);
    }

    @GetMapping("/{id}")
    public ClientListData getById(@PathVariable Long id) {
       try{
            var client = repository.findById(id).stream().map(ClientListData::new).toList();
            return client.get(0);
            } catch(Exception e){
                return null;
            }
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid ClientPutData body) {
        var client = repository.getReferenceById(body.id());
        client.update(body);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var client = repository.getReferenceById(id);
        client.delete();
    }

}
