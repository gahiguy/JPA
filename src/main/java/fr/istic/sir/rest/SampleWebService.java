package fr.istic.sir.rest;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PersonDao;
import domain.Chauffage;
import domain.Person;

@Path("/hello")
public class SampleWebService {
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello, how are you?";
    }


	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getHome() {
		Person h = new Person();
		h.setName("toto");
		Chauffage h1 = new Chauffage();
		h1.setConso(500);
		Chauffage h2 = new Chauffage();
		h2.setConso(600);
		
	
		
		return h;
	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Person add(Person person)
//	{
//		System.out.println(person);
//		PersonDao personDao = new PersonDao();
//		return personDao.create(person);
//	}
//
//	@GET
//	@Produces({MediaType.APPLICATION_JSON})
//	public Collection<Person> listPerson(){
//		PersonDao dao = new PersonDao();
//		return dao.findAll();
//	}

	
	
}
