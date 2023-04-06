package com.example.app.services;

import com.example.model.RepairJob;

import java.util.List;

public interface JobService {

    RepairJob createNewRepairJob(RepairJob repairJob);

    List<RepairJob> allRepairJob();

}
