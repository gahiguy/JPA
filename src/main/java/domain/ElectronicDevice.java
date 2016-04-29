package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="ElectronicDevice")
public class ElectronicDevice extends InteligentDevice{

	String type;
	Person proprio;

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne
	@JoinColumn(name="proprio",referencedColumnName="id")
	public Person getProprio() {
		return proprio;
	}
	public void setProprio(Person proprio) {
		this.proprio = proprio;
	}
	
	
	
	
	
	
	
}
