package com.example.appimpl.services_impl;

import com.example.app.repositories.JobRepository;
import com.example.app.services.JobService;
import com.example.exception.JobAlreadyExistsException;
import com.example.model.RepairJob;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    @Transactional
    public RepairJob createNewRepairJob(RepairJob repairJob) {
        String jobName = repairJob.getName();

        if (jobRepository.findByName(jobName).isPresent()) {
            throw new JobAlreadyExistsException(jobName);
        }

        return jobRepository.save(repairJob);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RepairJob> allRepairJob() {
        return jobRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(RepairJob::getName))
                .collect(Collectors.toList());
    }

}
