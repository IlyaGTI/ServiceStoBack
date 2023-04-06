package com.example.facade;

import com.example.app.services.JobService;
import com.example.dto.request.CreateNewRepairJobRequestDto;
import com.example.dto.response.RepairJobResponseDto;
import com.example.mapper.RepairJobMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JobFacade {
    private final JobService jobService;
    private final RepairJobMapper repairJobMapper;

    public void createNewJob(CreateNewRepairJobRequestDto dto){
        jobService.createNewRepairJob(repairJobMapper.repairJobResponseDtoToRepairJob(dto));
    }

    public List<RepairJobResponseDto> getAllRepairJob(){
        return repairJobMapper.repairJobsToRepairJobResponseDtos(jobService.allRepairJob());
    }



}
