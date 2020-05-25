package com.info.batch.processor;

import org.springframework.batch.item.ItemProcessor;

import com.journaldev.spring.model.Project;

public class ProjectItemProcessor implements ItemProcessor<Project, Project> {

	@Override
	public Project process(Project project) throws Exception {
		project.getTitle().toUpperCase();
		project.getDescription().toUpperCase();
		return project;
	}

}
