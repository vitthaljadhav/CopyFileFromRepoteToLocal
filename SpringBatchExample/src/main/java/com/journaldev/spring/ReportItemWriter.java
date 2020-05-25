package com.journaldev.spring;

import java.util.List;

import org.hibernate.Session;
import org.springframework.batch.item.ItemWriter;

import com.info.batch.util.HibernateUtil;
import com.journaldev.spring.model.Report;

public class ReportItemWriter implements ItemWriter<Report>{

	@Override
	public void write(List<? extends Report> item) throws Exception {

		try {
			Report report = item.get(0);
			Session session = HibernateUtil.getSessionFactroy().openSession();
			session.getTransaction().begin();
			session.persist(report);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
