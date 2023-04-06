package com.example.appimpl.services_impl;

import com.example.app.repositories.ClientRepository;
import com.example.app.services.ClientService;
import com.example.exception.ClientNotFoundException;
import com.example.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
    @Transactional(readOnly = true)
    public Client findById(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotFoundException(clientId));
    }

    @Override
    @Transactional(readOnly = true)
    public Client findByPhoneNumber(String phoneNumber) {
        return clientRepository.findClientByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new ClientNotFoundException(phoneNumber));
    }
}
