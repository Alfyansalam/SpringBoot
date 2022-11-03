package com.ust.hib.Dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ust.hib.Entity.Person;

public class PersonDao {
	@Autowired
	private SessionFactory factory;
	@SuppressWarnings("unchecked")
	public List<Person> getPersons() {
		
		
		return getSession().createCriteria(Person.class).list();
	}

	private Session getSession() {
		Session session =factory.getCurrentSession();
		if(session==null) {
			session=factory.openSession();
		}
		return session;
	}

	public void savePerson(Person person) {
		getSession().save(person);
		
	}

}
