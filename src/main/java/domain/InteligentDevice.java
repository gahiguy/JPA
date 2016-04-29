package domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Device_typ")
public abstract class InteligentDevice {
	
	long id;
	String marque;
	int conso;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;}
	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	
	
	public int getConso() {
		return conso;
	}
	public void setConso(int conso) {
		this.conso = conso;
	}
	
	
	
	
	
	
	

}
