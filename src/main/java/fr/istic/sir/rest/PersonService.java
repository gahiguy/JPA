package fr.istic.sir.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PersonDao;
import databaseHelper.DatabaseHelper;
import domain.Chauffage;
import domain.Person;

@Path("/humain")
public class PersonService 
{

	public PersonService(){
		DatabaseHelper.getInstance();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Person add(Person person)
	{
		System.out.println(person);
		PersonDao personDao = new PersonDao();
		return personDao.create(person);
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Collection<Person> listPerson(){
		PersonDao dao = new PersonDao();
		return dao.findAll();
	}
}
