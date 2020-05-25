package com.info.batch.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	public static SessionFactory sessionFactory = null;
	public static StandardServiceRegistry standardServiceRegistry = null;
	static {
		try {
			if (sessionFactory == null) {
				standardServiceRegistry = new StandardServiceRegistryBuilder().configure().build();

				MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

				Metadata metadata = metadataSources.getMetadataBuilder().build();

				sessionFactory = metadata.getSessionFactoryBuilder().build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (standardServiceRegistry != null) {
				StandardServiceRegistryBuilder.destroy(standardServiceRegistry);
			}
		}
	}
	public static SessionFactory getSessionFactroy() {
		return sessionFactory;
	}
}
