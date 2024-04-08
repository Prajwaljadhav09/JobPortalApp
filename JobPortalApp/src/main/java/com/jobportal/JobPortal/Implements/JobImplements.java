package com.jobportal.JobPortal.Implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.JobPortal.Model.Jobs;
import com.jobportal.JobPortal.Repository.JobRepository;
import com.jobportal.JobPortal.Services.JobServices;
@Service
public class JobImplements implements JobServices{
	@Autowired
	JobRepository jobRepo;
	
	@Override
	public Jobs createJobs(Jobs user) {
		return jobRepo.save(user);
	}
	public List<Jobs> getJobs() {
		return jobRepo.findAll();
	}
//	public Jobs getById(int id) {
//		return jobRepo.findById(id).get();
//	}
	@Override
	public Jobs updateJobs(Jobs jobs, int id) {
		// TODO Auto-generated method stub
		Jobs updatedJob= jobRepo.findById(id).get();
		if(updatedJob!=null) {
			updatedJob.setId(id);
			updatedJob.setCompanyName(jobs.getCompanyName());
			updatedJob.setJobDesc(jobs.getJobDesc());
			updatedJob.setDeadline(jobs.getDeadline());
			updatedJob.setLink(jobs.getLink());
			return jobRepo.save(updatedJob);
		}
		else return updatedJob;
	}
	@Override
	public void deleteJobs(int id) {
		jobRepo.deleteById(id);
	}
	
	
	
}
