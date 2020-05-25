package com.journaldev.spring.mapper;

import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.journaldev.spring.model.Project;

public class ProjectFieldSetMapper implements FieldSetMapper<Project> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public Project mapFieldSet(FieldSet fieldset) throws BindException {

		Project project = new Project();
		try {
			/*project.setTitle(fieldset.readString(0));
			project.setAuthor(fieldset.readString(1));
			project.setDescription(fieldset.readString(2));
			String sdate = fieldset.readString(3);
			String edate = fieldset.readString(4);
			project.setEndDate(dateFormat.parse(sdate));
			project.setStartDate(dateFormat.parse(edate));*/
			
			
			project.setTitle(fieldset.readString("title"));
			project.setAuthor(fieldset.readString("author"));
			project.setDescription(fieldset.readString("description"));
			String sdate = fieldset.readString("startDate");
			String edate = fieldset.readString("endDate");
			project.setEndDate(dateFormat.parse(sdate));
			project.setStartDate(dateFormat.parse(edate));
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		return project;
	}

}
