package com.example.app.services;

import com.example.model.Client;

public interface ClientService {

    Client createNewClient(Client client);

    Client findById(Long id);

    Client findByPhoneNumber(String phoneNumber);
}
