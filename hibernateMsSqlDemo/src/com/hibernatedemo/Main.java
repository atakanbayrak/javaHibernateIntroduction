package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//Unit of Work ----> Design Pattern // Baþarýsýz bir iþlem öncekini de iptal ettirir
			session.beginTransaction();
			
			//HQL ----> Hibernate Query Language
			//Select * from city
			//from City c where c.countryCode='TUR' AND c.district='Ankara'
			//from City c where c.name LIKE '%kar%' 
			//ASC- Ascending
			//DESC- Descending
			
			//SELECT
			/*
			 * List<String> countryCodes=
			 * session.createQuery("select c.countryCode from City c GROUP BY c.countryCode"
			 * ).getResultList();
			 * 
			 * for (String countryCode : countryCodes) { System.out.println(countryCode); }
			 */
			
			//INSERT
			/*
			 * City city = new City(); city.setName("Düzce 10"); city.setCountryCode("TUR");
			 * city.setDistrict("Düzce"); city.setPopulation(10000);
			 * 
			 * session.save(city);
			 * System.out.println("Þehir Eklendi");
			 */
			
			//UPDATE
			/*
			 * City city = session.get(City.class, 4086); city.setPopulation(150000);
			 * session.save(city);
			 * System.out.println("Þehir Güncellendi");
			 */
			
			//DELETE
			/*
			 * City city = session.get(City.class, 4086); session.delete(city);
			 * System.out.println("Þehir Silindi");
			 */
			
			session.getTransaction().commit();
			
		}
		finally{
			factory.close();
		}
	}

}
