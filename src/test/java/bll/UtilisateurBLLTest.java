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
			
			UtilisateurException e = assertThrows(UtilisateurException.class, () -> {
				bll.checkUtilisateur(invalide);
			});	
			
			assertEquals(1, e.getMessages().size());
			assertEquals("Le prénom ne peut pas être laissé vide !", e.getMessages().get(0));
	}
	
	@Test
	void checkUtilisateurSansNom_renvoieUtilisateurException() {
			Utilisateur invalide = new Utilisateur();
			invalide.setPrenom("Etienne");
			invalide.setEmail("e.cassin@email.fr");
			
			UtilisateurException e = assertThrows(UtilisateurException.class, () -> {
				bll.checkUtilisateur(invalide);
			});		
			
			assertEquals(1, e.getMessages().size());
			assertEquals("Le nom ne peut pas être laissé vide !", e.getMessages().get(0));
	}
	
	@Test
	void checkUtilisateurEmailInvalide_renvoieUtilisateurException() {
			Utilisateur invalide = new Utilisateur();
			invalide.setPrenom("Etienne");
			invalide.setNom("Cassin");
			invalide.setEmail("e.cassin@email.");
			
			UtilisateurException e = assertThrows(UtilisateurException.class, () -> {
				bll.checkUtilisateur(invalide);
			});	
			
			assertEquals(1, e.getMessages().size());
			assertEquals("L'adresse e-mail n'est pas valide !", e.getMessages().get(0));
	}
	
	@Test
	void checkUtilisateurEmailInvalide2_renvoieUtilisateurException() {
		Utilisateur invalide = new Utilisateur();
		invalide.setPrenom("Etienne");
		invalide.setNom("Cassin");
		invalide.setEmail("e\".cassin@e-mail.co.uk");
		
		UtilisateurException e = assertThrows(UtilisateurException.class, () -> {
			bll.checkUtilisateur(invalide);
		});
		
		assertEquals(1, e.getMessages().size());
		assertEquals("L'adresse e-mail n'est pas valide !", e.getMessages().get(0));
	}
	
	@Test
	void checkUtilisateurInvalideCombo_renvoieUtilisateurException() {
		Utilisateur invalide = new Utilisateur();
		invalide.setEmail("e-cassin@-email.com");
		
		UtilisateurException e = assertThrows(UtilisateurException.class, () -> {
			bll.checkUtilisateur(invalide);
		});	
		
		assertEquals(3, e.getMessages().size());
		assertEquals("Le nom ne peut pas être laissé vide !", e.getMessages().get(0));
		assertEquals("Le prénom ne peut pas être laissé vide !", e.getMessages().get(1));
		assertEquals("L'adresse e-mail n'est pas valide !", e.getMessages().get(2));
	}
	
	/*
	 * doesn't appear to work
	 * -> Unable to locate entity descriptor: bo.Utilisateur
	 * -> No query is registered under the name 'selectByEmail'
	 */
	/*
	@Test
	void selectById_renvoieUtilisateur() {
		Random rand = new Random();
		int randIndex = rand.nextInt(1, 4);
		Utilisateur select = bll.selectById(randIndex);
		
		switch (randIndex) {
			case 1 -> assertEquals("Jean", select.getPrenom());
			case 2 -> assertEquals("Clara", select.getPrenom());
			case 3 -> assertEquals("Quentin", select.getPrenom());
			default -> fail("unexpected select");
		}		
	}
	
	@Test
	void selectById_renvoieNull() {
		Utilisateur select = bll.selectById(12354);
		
		assertNull(select);	
	}
	
	@Test
	void selectByLogin_renvoieClara() {
		Utilisateur select = bll.selectByLogin("Clara");
		
		assertEquals("Clara", select.getPrenom());	
		assertEquals("Laviale", select.getNom());
		assertEquals("clara.laviale@email.fr", select.getEmail());
	}
	
	@Test
	void selectByLogin_renvoieNull() {
		Utilisateur select = bll.selectByLogin("Punk");
		
		assertNull(select);
	}
	
	@Test
	void selectByEmail_renvoieClara() {
		Utilisateur select = bll.selectByEmail("clara.laviale@email.fr");
		
		assertEquals("Clara", select.getPrenom());	
		assertEquals("Laviale", select.getNom());
		assertEquals("Clara", select.getLogin());
	}
	
	@Test
	void selectByEmail_renvoieNull() {
		Utilisateur select = bll.selectByEmail("punk-is-dead@mail.co.uk");
		
		assertNull(select);
	}
	*/
	

}
