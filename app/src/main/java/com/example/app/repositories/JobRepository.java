package com.example.app.repositories;

import com.example.model.RepairJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<RepairJob, Long> {
    @Query(value = "SELECT * FROM services WHERE id IN (:serviceIds)",
            nativeQuery = true)
    List<RepairJob> findAllById(@Param("jobsIds") List<Long> jobsIds);

    Optional<RepairJob> findByName(String name);

}
