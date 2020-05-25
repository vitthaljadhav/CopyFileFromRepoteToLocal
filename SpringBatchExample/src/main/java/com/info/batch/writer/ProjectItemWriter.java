package com.info.batch.writer;

import java.util.List;

import org.hibernate.Session;
import org.springframework.batch.item.ItemWriter;

import com.info.batch.util.HibernateUtil;
import com.info.batch.util.HibernateUtilProject;
import com.journaldev.spring.model.Project;
import com.journaldev.spring.model.Report;

public class ProjectItemWriter implements ItemWriter<Project> {

	@Override
	public void write(List<? extends Project> item) throws Exception {
		try {
			Project project = item.get(0);
			Session session = HibernateUtilProject.getSessionFactroy().openSession();
			session.getTransaction().begin();
			session.persist(project);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
