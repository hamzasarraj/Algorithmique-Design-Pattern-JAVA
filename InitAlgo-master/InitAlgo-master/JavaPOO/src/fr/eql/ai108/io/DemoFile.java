package fr.eql.ai108.io;

import java.io.File;
import java.io.IOException;

public class DemoFile {

	public static void main(String[] args) {
		// Instancier un File
		File file = new File("c:/DossierAI108");
		
		//mkdir permet de créer un dossier
		//cette méthode renvoie true si le dossier a bien été créé
		boolean create = file.mkdir();
		if(create) {
			System.out.println("dossier créé");
		}else {
			System.out.println("Ou pas");
		}
		
		System.out.println("Est ce que ce file existe? :" + file.exists());
		
		//Créer un fichier
		File file2 = new File("c:/DossierAI108/file.ai108");
		
		//createNewFile() permet de créer un fichier
		//Elle renvoie un booléen true si le fichier a bien été créé
		
		try {
			boolean createFile = file2.createNewFile();
			if (createFile) {
				System.out.println("Fichier créé");
			}else {
				System.out.println("Fichier non créé");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Création d'un fichier avec un chemin relatif
		File file3 = new File("file.titi");
		try {
			file3.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Obtenir le chemin absolu d'un fichier:
		System.out.println("Chemin absolu de mon file3: " + file3.getAbsolutePath());
		
		
		
		//Vérifier mon droit de lecture ou d'écriture dans un fichier
		System.out.println(file2.canWrite());
		System.out.println(file2.canRead());
		
		//Créer une arbo de dossiers
		File folders = new File("c:/DossierAI108/toto/titi/tata");
		boolean createFolders = folders.mkdirs();
		System.out.println(createFolders ? "dossiers bien crées" : "ou pas");
		
		//Renommer un fichier
		File fileNew = new File("c:/DossierAI108/nouveauNom.txt");
		boolean rename = file2.renameTo(fileNew);
		System.out.println(rename ? "Success" : "Fail");
		
		//Supprimer un fichier
		boolean delete = fileNew.delete();
		System.out.println(delete ? "Fichier bien supprimé" : "Fichier non supprimé");
		
		//Connaître le contenu d'un dossier
		File root = new File("c:/");
		File[] content = root.listFiles();
		String type = "";
		for (File f : content) {
			if(f.isDirectory()) {
				type = "Dossier";
			}else if (f.isFile()) {
				type = "Fichier";
			}
			System.out.println(f.getName() + " : " + type);
		}
	}

}
