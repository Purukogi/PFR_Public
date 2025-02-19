package bo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "horaires")
public class Horaire {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 8)
	private String jour;
	
	private LocalDateTime ouverture;
	private LocalDateTime fermeture;
	
	public Horaire(int id, String jour, LocalDateTime ouverture, LocalDateTime fermeture) {
		this.id = id;
		this.jour = jour;
		this.ouverture = ouverture;
		this.fermeture = fermeture;
	}
	
	public Horaire(String jour, LocalDateTime ouverture, LocalDateTime fermeture) {
		this.jour = jour;
		this.ouverture = ouverture;
		this.fermeture = fermeture;
	}
	
	public Horaire() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public LocalDateTime getOuverture() {
		return ouverture;
	}

	public void setOuverture(LocalDateTime ouverture) {
		this.ouverture = ouverture;
	}

	public LocalDateTime getFermeture() {
		return fermeture;
	}

	public void setFermeture(LocalDateTime fermeture) {
		this.fermeture = fermeture;
	}
	
}
