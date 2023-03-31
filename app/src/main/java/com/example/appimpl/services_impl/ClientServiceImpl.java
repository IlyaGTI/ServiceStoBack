package com.example.appimpl.services_impl;

import com.example.app.repositories.ClientRepository;
import com.example.app.services.ClientService;
import com.example.exception.ClientNotFoundException;
import com.example.model.Client;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    @Override
    @Transactional
    public Client createNewClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
    }
}
