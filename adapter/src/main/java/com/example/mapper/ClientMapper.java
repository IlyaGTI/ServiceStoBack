package com.example.mapper;

import com.example.dto.request.NewClientRequestDto;
import com.example.model.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client newClientRequestDtoToClient(NewClientRequestDto requestDto);
}
