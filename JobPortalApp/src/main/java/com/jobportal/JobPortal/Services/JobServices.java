package com.jobportal.JobPortal.Services;

import java.util.List;

import com.jobportal.JobPortal.Model.Jobs;


public interface JobServices {
	
	Jobs createJobs(Jobs jobs);
	List<Jobs> getJobs();
//	Jobs getById(int id);
	Jobs updateJobs(Jobs jobs, int id);
	void deleteJobs(int id);


}
