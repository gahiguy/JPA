package jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sun.jersey.server.impl.managedbeans.ManagedBeanComponentProviderFactoryInitilizer;

import domain.Chauffage;
import domain.ElectronicDevice;
import domain.Person;
import domain.Residence;

public class JpaTest {

	/**
	 * @param args
	 */


	private static EntityManager manageR;
	private static  EntityTransaction tx;
	private static EntityManagerFactory factory;

	public JpaTest() {
		factory = Persistence.createEntityManagerFactory("mysql");
		manageR = factory.createEntityManager();
		this.tx = manageR.getTransaction();
		this.tx.begin();
	}

	public static void main(String[] args) {




		try {

			JpaTest test = new JpaTest();

			Person p1 = new Person();

			p1.setName("dupond");
			p1.setMail("dupond@gmail.com");
			
			List<Residence> re = new ArrayList<Residence>();

			Residence residence1 = new Residence();
			residence1.setNoChambre(2);
			residence1.setNoSurface(300);
			residence1.setProprio(p1);
			re.add(residence1);

			
			Chauffage ch1 = new Chauffage();
			ch1.setConso(300);
			ch1.setMarque("A/C");
			ch1.setResidence(residence1);

			ElectronicDevice ed1 = new ElectronicDevice();
			ed1.setConso(200);
			ed1.setMarque("Galaxy");
			ed1.setProprio(p1);
			ed1.setType("SmartPhone");
			Person p2 = new Person();

			p1.setName("franc");
			p1.setMail("francd@gmail.com");

			manageR.persist(p1);
			manageR.persist(residence1);
			manageR.persist(ch1);
			manageR.persist(ed1);

			test.listPerson();



		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manageR.close();
		factory.close();
	}




	public void createPerson(String name , String mail){

		Person p = new Person();
		p.setName(name);
		p.setMail(mail);

		manageR.persist(p);
		tx.commit();

	}


	public List<Person> listPerson(){

		List<Person> result = manageR.createQuery("select p from Person p left join p.residence").getResultList();
		
		
		return result;
	}


	public List<Residence> listResidence(){

		List<Residence> resultHomes = manageR.createQuery("select r from Residence r ").getResultList();
		for(int y = 0 ; y < resultHomes.size() ; y++){
			System.out.println(resultHomes.get(y).toString());
		}

		return resultHomes;


	}



}
