package com.example.facade;

import com.example.app.services.ClientService;
import com.example.dto.request.NewClientRequestDto;
import com.example.mapper.ClientMapper;
import com.example.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientFacade {

    private final ClientMapper clientMapper;
    private final ClientService clientService;
    public void registerNewClient(NewClientRequestDto dto) {
        Client client = clientMapper.newClientRequestDtoToClient(dto);
        clientService.createNewClient(client);
    }
}
