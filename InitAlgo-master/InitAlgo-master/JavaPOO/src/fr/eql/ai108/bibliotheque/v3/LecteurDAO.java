package fr.eql.ai108.bibliotheque.v3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LecteurDAO {

	public boolean creerCompte(String nom, String prenom,
			String adresse, String login, String password) {
		
		File bibliotheque = new File("Bibliotheque");
		//Si le dossier n'existe pas, il sera créé
		if(!bibliotheque.exists()) {
			bibliotheque.mkdir();
		}
		boolean cree;
		//Je déclare le fichier utilisateur
		File fichierUtilisateur = new File("Bibliotheque/" + login + ".bib");
		FileWriter out = null;
		BufferedWriter bw = null;
		try {
			cree = fichierUtilisateur.createNewFile();
			if(cree) {
				out = new FileWriter(fichierUtilisateur, true);
				bw = new BufferedWriter(out);
				
				//Ecrire dans mon fichier
				bw.write(nom);
				bw.newLine();
				bw.write(prenom);
				bw.newLine();
				bw.write(adresse);
				bw.newLine();
				bw.write(login);
				bw.newLine();
				bw.write(password);
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			cree = false;
		}finally {
			try {
				bw.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return cree;
	}
	
	public Lecteur seConnecter(String login, String password) {
		File fichierUtilisateur = new File("Bibliotheque/" + login + ".bib");
		FileReader in = null;
		BufferedReader br = null;
		Lecteur lecteur = null;
		//Si l'utilisateur n'existe pas, on retourne null
		if(!fichierUtilisateur.exists()) {
			return null;
		}else {
			try {
				//S'il existe, on va lire ses informations dans le fichier correpondant
				in = new FileReader(fichierUtilisateur);
				br = new BufferedReader(in);
				String nomUtilisateur = br.readLine();
				String prenomUtilisateur = br.readLine();
				String adresseUtilisateur = br.readLine();
				String loginUtilisateur = br.readLine();
				String passwordUtilisateur = br.readLine();
				lecteur = new Lecteur(nomUtilisateur, prenomUtilisateur,
						adresseUtilisateur, loginUtilisateur, passwordUtilisateur);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					br.close();
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//Si le password est correct, on retourne l'instance de Lecteur
			if(lecteur.getPassword().equals(password)) {
				return lecteur;
				//Autrement, on retourne null
			}else {
				return null;
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
