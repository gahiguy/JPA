package testjpa;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import domain.Person;
import jpa.JpaTest;

@WebServlet(name="userInfo" ,
urlPatterns={"/UserInfo"})
public class UserInfo extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String nom = request.getParameter("name");
		String mail =  request.getParameter("mail");
		
		JpaTest jpa = new JpaTest();
		jpa.createPerson(nom, mail);
		List<Person> p = jpa.listPerson();
	
		for(Person result : p ){
			out.print(result.toString());
		}
		
		
		
	}





}
