package com.example.mapper;

import com.example.dto.request.CreateNewRepairJobRequestDto;
import com.example.dto.response.RepairJobResponseDto;
import com.example.model.RepairJob;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RepairJobMapper {

    RepairJobMapper INSTANCE = Mappers.getMapper(RepairJobMapper.class);

    RepairJobResponseDto repairJobToRepairJobResponseDto(RepairJob repairJob);

    List<RepairJobResponseDto> repairJobsToRepairJobResponseDtos(List<RepairJob> repairJobs);

    RepairJob repairJobResponseDtoToRepairJob(CreateNewRepairJobRequestDto dto);
}
