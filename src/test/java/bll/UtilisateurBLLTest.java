package bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import bo.Utilisateur;
import exceptions.UtilisateurException;

class UtilisateurBLLTest {
	
	private static UtilisateurBLL bll;
	
	@BeforeAll
	static void beforeAllInit() {
		bll = new UtilisateurBLL();
	}

	@Test
	void checkUtilisateurValide_neFaitRien() {
		try {
			Utilisateur valide = new Utilisateur();
			valide.setPrenom("Etienne");
			valide.setNom("Cassin");
			valide.setEmail("e.cassin@email.fr");
			
			bll.checkUtilisateur(valide);
		} catch (UtilisateurException e){
			fail("L'utilisateur devrait etre validé.");
		}
	}
	
	@Test
	void checkUtilisateurSansEmail_renvoieUtilisateurException() {
			Utilisateur invalide = new Utilisateur();
			invalide.setPrenom("Etienne");
			invalide.setNom("Cassin");
			
			UtilisateurException e = assertThrows(UtilisateurException.class, () -> {
				bll.checkUtilisateur(invalide);
			});	
			
			assertEquals(1, e.getMessages().size());
			assertEquals("L'e-mail ne peut pas être laissé vide !", e.getMessages().get(0));
	}
	
	@Test
	void checkUtilisateurSansPrenom_renvoieUtilisateurException() {
			Utilisateur invalide = new Utilisateur();
			invalide.setNom("Cassin");
			invalide.setEmail("e.cassin@email.fr");
			
			assertThrows(UtilisateurException.class, () -> {
				bll.checkUtilisateur(invalide);
			});		
	}
	
	@Test
	void checkUtilisateurSansNom_renvoieUtilisateurException() {
			Utilisateur invalide = new Utilisateur();
			invalide.setPrenom("Etienne");
			invalide.setEmail("e.cassin@email.fr");
			
			assertThrows(UtilisateurException.class, () -> {
				bll.checkUtilisateur(invalide);
			});		
	}
	
	@Test
	void checkUtilisateurEmailInvalide_renvoieUtilisateurException() {
			Utilisateur invalide = new Utilisateur();
			invalide.setPrenom("Etienne");
			invalide.setNom("Cassin");
			invalide.setEmail("e.cassin@email.");
			
			assertThrows(UtilisateurException.class, () -> {
				bll.checkUtilisateur(invalide);
			});		
	}
	
	@Test
	void checkUtilisateurEmailInvalide2_renvoieUtilisateurException() {
		Utilisateur invalide = new Utilisateur();
		invalide.setPrenom("Etienne");
		invalide.setNom("Cassin");
		invalide.setEmail("e\".cassin@e-mail.co.uk");
		
		assertThrows(UtilisateurException.class, () -> {
			bll.checkUtilisateur(invalide);
		});		
	}
	
	

}
