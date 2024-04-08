package com.jobportal.JobPortal.Model;

import java.net.URL;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String companyName;
	String jobDesc;
	String deadline;	
	URL link;
}
