package domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Residence {

	
	long id;
	int noChambre;
	int noSurface;
	Person proprio ;
	List <Chauffage> chauffages;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getNoChambre() {
		return noChambre;
	}
	public void setNoChambre(int noChambre) {
		this.noChambre = noChambre;
	}
	
	public int getNoSurface() {
		return noSurface;
	}
	public void setNoSurface(int noSurface) {
		this.noSurface = noSurface;
	}
	
	@ManyToOne
	@JoinColumn(name="proprio",referencedColumnName="id")
	public Person getProprio() {
		return proprio;
	}
	public void setProprio(Person proprio) {
		this.proprio = proprio;
	}
	
	
	@OneToMany(mappedBy="residence" , cascade=CascadeType.PERSIST)
	public List<Chauffage> getChauffages() {
		return chauffages;
	}
	public void setChauffages(List<Chauffage> chauffages) {
		this.chauffages = chauffages;
	}
	@Override
	public String toString() {
		return "Residence [id=" + id + ", noChambre=" + noChambre + ", noSurface=" + noSurface + ", proprio=" + proprio
				+ ", chauffages=" + chauffages + "]";
	}
	
	
	
	
	
	
}
