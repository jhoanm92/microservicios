package com.user.service.impl;

import com.user.entity.Client;
import com.user.exception.ModeloNotFoundException;
import com.user.repository.ClientRepository;
import com.user.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public Client register(Client client) {
        return repository.save(client);
    }

    @Override
    public Client update(Client client) {
        this.getById(client.getIdClient());
        return repository.save(client);
    }

    @Override
    public List<Client> getAll() {
        return repository.findAll();
    }

    @Override
    public Client getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ModeloNotFoundException("ID NOT FOUND " + id));
    }

    @Override
    public void delete(Integer id) {
        this.getById(id);
        repository.deleteById(id);
    }
}
