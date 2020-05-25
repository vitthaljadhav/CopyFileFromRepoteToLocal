package com.info.batch.writer;

import java.util.List;

import org.hibernate.Session;
import org.springframework.batch.item.ItemWriter;

import com.info.batch.util.HibernateUtil;
import com.journaldev.spring.model.Settlement;

public class SettlementItemWriter implements ItemWriter<Settlement> {

	@Override
	public void write(List<? extends Settlement> items) throws Exception {
		Session session = HibernateUtil.getSessionFactroy().openSession();
		try {
			session.getTransaction().begin();
			session.save(items.get(0));
			session.getTransaction().commit();
		} catch (Exception e) {
			// System.out.println("Exception Ocuured in Settlement Writer");
		}
	}
}
