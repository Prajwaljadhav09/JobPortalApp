package com.jobportal.JobPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jobportal.JobPortal.Model.Jobs;
import com.jobportal.JobPortal.Services.JobServices;
import org.springframework.web.bind.annotation.PathVariable;




@Controller
public class JobController {
	@Autowired
	JobServices jobServices;
	
	@GetMapping("/")
	public String jobs() {
		return "index";
	}
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/applicable/")
	public ModelAndView getApplicables() {
		//TODO: process POST request
		List<Jobs>list=jobServices.getJobs();
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("Application");
//		mv.addObject("Jobs",list);
		return new ModelAndView("Application","jobs",list);
	}
	@GetMapping("/Welcome")
	public String job() {
		return "index";
	}
	@GetMapping("/available_jobs")
	public ModelAndView getAllJobs() {
		//TODO: process POST request
		List<Jobs>list=jobServices.getJobs();
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName("Available");
//		mv.addObject("Jobs",list);
		return new ModelAndView("Available","jobs",list);
	}
//	@GetMapping("/available")
//	public String availableJobs() {
//		return "Available";
//	}
	@GetMapping("/add_jobs")
	public String jobPortal() {
		return "add_jobs";
	}

	@PostMapping("/save")
	public String creatJobs(@ModelAttribute Jobs jobs) {
		//TODO: process POST request
		jobServices.createJobs(jobs);
		return "redirect:/available_jobs";
	}
	@GetMapping("/update/{id}")
	public ModelAndView updateJob(@PathVariable int id) {
		//TODO: process PUT request	
		Jobs jobs = new Jobs();
		jobs=jobServices.updateJobs(jobs, id);
		
		ModelAndView mV=new ModelAndView("update");
		
		mV.addObject("job", jobs);		
		return mV;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteJob(@PathVariable int id) {
		jobServices.deleteJobs(id);
		return "redirect:/available_jobs";
	}

}
