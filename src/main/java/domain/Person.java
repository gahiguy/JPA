package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Person {
	
	long id;
	String name;
	String mail;
	List<Residence> residence ;
	List<ElectronicDevice> devices;
	
	
	
	
	
	
	public Person() {
		super();
	}
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}


	@OneToMany(mappedBy ="proprio", cascade = CascadeType.PERSIST)
	public List<Residence> getResidence() {
		return residence;
	}
    public void setResidence(List<Residence> residence) {
		this.residence = residence;
	}


    @OneToMany(mappedBy ="proprio" , cascade = CascadeType.PERSIST)
	public List<ElectronicDevice> getDevices() {
		return devices;
	}
	public void setDevices(List<ElectronicDevice> devices) {
		this.devices = devices;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", mail=" + mail + ", residence=" + residence + ", devices="
				+ devices + "]";
	}
	
	
	
	
	
	

}
