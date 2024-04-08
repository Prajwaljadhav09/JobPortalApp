package com.jobportal.JobPortal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.JobPortal.Model.Jobs;
@Repository
public interface JobRepository extends JpaRepository<Jobs, Integer>{

}
