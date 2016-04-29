package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="chauffage")

public class Chauffage extends InteligentDevice {
	
	boolean fix;
	Residence residence;

	public boolean isFix() {
		return fix;
	}

	public void setFix(boolean fix) {
		this.fix = fix;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name="residence",referencedColumnName="id")
	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}
	
	
	
	
	

}
