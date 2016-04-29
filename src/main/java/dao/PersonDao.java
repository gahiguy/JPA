package dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import databaseHelper.DatabaseHelper;
import domain.Person;

public class PersonDao implements GenericDao<Person> {

	private EntityManager em;
	private EntityTransaction et;

	public PersonDao() {
		super();
		em = DatabaseHelper.getInstance();
		et = em.getTransaction();
	}

	public Person create(Person person) {
		if(person != null);
		{
			et.begin();
			em.persist(person);
			et.commit();
		}
		return person;
	}

	public Person delete(Object id) {
		Person p = em.getReference(Person.class, id);
		if(p != null)
		{
			et.begin();
			em.remove(p);
			et.commit();
		}
		return p;
	}

	public Person find(Object id) {  
		return (Person)(em.find(Person.class, id));
	}

	public Person update(Person entity) {
		if(entity != null)
		{
			et.begin();
			em.merge(entity);
			et.commit();
		}
		return entity;
	}

	public Collection<Person> findAll() {
		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<Person> query = criteria.createQuery(Person.class);
		Root<Person> pers = query.from(Person.class);
		CriteriaQuery<Person> q = query.select(pers);
		return em.createQuery(q).getResultList();
	}
}
