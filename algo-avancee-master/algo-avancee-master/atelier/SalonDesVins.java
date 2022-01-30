package SalonDesVins;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
	
public class SalonDesVins {
	static int tailleNomMax;
	static int tailleAppelationMax;
	static int tailleLocalisationMax;
	static int tailleCodeProprioMax;
	static int tailleSurfaceMax;
	static int tailleStandMax;
	static int j;
	static int nbElements;
	static RandomAccessFile fichierStructure;
	static FileReader fichier;
	static BufferedReader fichier2;
	static String nomVin = "";
	static int tailleElement =0;
	
	public static void main(String[] args) {
		try {
			// On compte le nombre d'éléments du fichier
			fichier = new FileReader("c:/TpVin/VINStp.DON");
			fichier2 = new BufferedReader(fichier);
			while(fichier2.ready()) {
				nbElements += 1;
				fichier2.readLine();
			}
			//1. Créer un fichier structuré 
			//1.1 Déterminer la taille des différents champs
			tailleMax();
			//System.out.println("On obtient les tailles max par type de données : " + tailleNomMax + " " + tailleAppelationMax + " " + tailleLocalisationMax + " " + tailleCodeProprioMax + " " + tailleSurfaceMax + " " + tailleStandMax);
			tailleElement = tailleNomMax + tailleAppelationMax + tailleLocalisationMax + tailleCodeProprioMax + tailleSurfaceMax + tailleStandMax;
			//1.2 Créer un fichier selon une taille standard par champs
			fichierStructure();
			
			//2. Trier le fichier (par ordre alphabétique)
			//2.1 Méthode recupererString(), qui enregistre les éléments sous forme de String afin de pouvoir les comparer;
			//System.out.println(recupererString(12));
			//2.2 Méthode recupererTab(), qui enregistre les éléments sous forme de tableaux de caracteres afin de pouvoir les écrires 
			//System.out.println(recupererTab(1));
			//2.3 Méthode permuter(int a, int b), pour permuter deux éléments
			//2.4 Méthode tri() qui classe les élèments 
			//System.out.println("Le fichier source comprend " + nbElements + " élements.");
			//tri();
			
			//3. Faire un algo de recherche par dichotomie
			//3.1 Déterminer le début et la fin de la recherche	
			char[] infosVin = new char[tailleElement];
			System.out.println("Informations sur le vin :");
			infosVin = dichotomie("Cave Des Vignerons De Liergues");
			for(int i =0; i < 98; i++) {
				System.out.print(infosVin[i]);
			}
			//4. Créer l'application
			//4.1 Demander le vin 
			//4.2 Utiliser la méthode de recherche
			//4.3 Luire tourner les infos sur ce vin
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fichier.close();
				fichier2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void tailleMax() {
		String ligne = null;
		try {
			fichier = new FileReader("c:/TpVin/VINStp.DON");
			fichier2 = new BufferedReader(fichier);
			while (fichier2.ready()) {
				ligne = fichier2.readLine();
				int taille = 0;
				int nbTabullations = 0;
				char caractere =' ';
				for(int i = 0; i < ligne.length(); i++) {
					caractere = ligne.charAt(i);
					if(caractere != '\t') {
						taille++;
					}
					else {
						nbTabullations ++;
						switch(nbTabullations) {
						case 1:
							if(taille > tailleNomMax) {
								tailleNomMax = taille;
							}
							break;
						case 2:
							if(taille > tailleAppelationMax) {
								tailleAppelationMax = taille;
							}
							break;
						case 3:
							if(taille > tailleLocalisationMax) {
								tailleLocalisationMax = taille;
							}
							break;
						case 4:
							if(taille > tailleCodeProprioMax) {
								tailleCodeProprioMax = taille;
							}
							break;
						case 5:
							if(taille > tailleSurfaceMax) {
								tailleSurfaceMax = taille;
							}
							break;
						}
						taille = 0;
					}
				}
				if(taille > tailleStandMax) {
					tailleStandMax = taille;
				} 		
			}
			int tailleLigne = tailleNomMax + tailleAppelationMax + tailleLocalisationMax + tailleCodeProprioMax + tailleSurfaceMax + tailleStandMax;
		}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {		
		try {
			fichier2.close();
			fichier.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

	public static void fichierStructure(){
		try {
				fichierStructure = new RandomAccessFile("c:/TpVin/fichierStructure.txt", "rw");
				fichier = new FileReader("c:/TpVin/VINStp.DON");
				fichier2 = new BufferedReader(fichier);
				while (fichier2.ready()) {
					String ligne;
					ligne = fichier2.readLine();
					char[] tableauLigne = new char[ligne.length()];
					int nbTabulations = 0;
					int nbCaracteres = 0;
					int nbEspaces = 0;
					for (int i = 0; i < ligne.length(); i++) {
						tableauLigne[i] = ligne.charAt(i);
						if(tableauLigne[i] != '\t') {
							fichierStructure.writeChar(tableauLigne[i]);
							nbCaracteres ++;
						}
						else {
							nbTabulations++;
							switch(nbTabulations) {
							case 1:
								nbEspaces = tailleNomMax - nbCaracteres; 
								break;
							case 2:
								nbEspaces = tailleAppelationMax - nbCaracteres; 
								break;
							case 3:
								nbEspaces = tailleLocalisationMax - nbCaracteres; 
								break;
							case 4:
								nbEspaces = tailleCodeProprioMax - nbCaracteres; 
								break;
							case 5:
								nbEspaces = tailleSurfaceMax - nbCaracteres; 
								break;
							}
							for(int j = 0; j < nbEspaces; j++) {
								fichierStructure.writeChar(' ');
							}
							nbCaracteres = 0;
						}
					}
				}	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					fichier.close();
					fichier2.close();
					fichierStructure.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
	}
	
	public static char[] recupererTab(int j) {
		int tailleElement = tailleNomMax + tailleAppelationMax + tailleLocalisationMax + tailleCodeProprioMax + tailleSurfaceMax + tailleStandMax;
		char[] element = new char[tailleElement];
		try {
			fichierStructure = new RandomAccessFile("c:/TpVin/fichierStructure.txt", "rw");
			fichierStructure.seek((tailleElement*(j - 1))*2);
			for(int i = 0; i < tailleElement; i++) {
				element[i] = fichierStructure.readChar();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fichierStructure.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(element);
		return element;	
	}
	
	public static String recupererString(int j) {
		int tailleElement = tailleNomMax + tailleAppelationMax + tailleLocalisationMax + tailleCodeProprioMax + tailleSurfaceMax + tailleStandMax;
		String element = "";
		try {
			fichierStructure = new RandomAccessFile("c:/TpVin/fichierStructure.txt", "rw");
			fichierStructure.seek((tailleElement*(j - 1))*2);
			for(int i = 0; i < tailleNomMax; i++) {
				element += fichierStructure.readChar();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fichierStructure.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println(element);
		return element;
	}
	
	public static void tri() {
		for(int n = nbElements; n > 1; n--) {
			for(int i = 1; i < n; i++) {
				if(recupererString(i).compareTo(recupererString(i+1)) > 0) {
					permuter(i, i+1);
					System.out.println("en cour de traitement");
				}
			}
		}
	}
		
	public static void permuter(int a, int b){
		int tailleElement = tailleNomMax + tailleAppelationMax + tailleLocalisationMax + tailleCodeProprioMax + tailleSurfaceMax + tailleStandMax;
		char[] buffer = recupererTab(b);
		char[] elementA = recupererTab(a);
		try {
		//On écrit l'élément a à la place de l'élément b
			fichierStructure = new RandomAccessFile("c:/TpVin/fichierStructure.txt", "rw");
			fichierStructure.seek((tailleElement*(b - 1))*2);
			for(int i = 0; i < tailleElement; i++) {
				fichierStructure.write(' ');
				fichierStructure.write(elementA[i]);
			}
		//On écrit l'élément b à la place de a 
			fichierStructure.seek((tailleElement*(a - 1))*2);
			for(int i = 0; i < tailleElement; i++) {
				fichierStructure.write(' ');
				fichierStructure.write(buffer[i]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fichierStructure.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static char[] dichotomie(String nomVin) {
		int debut = 1;
		int fin = nbElements;
		boolean trouve = false;
		int nbCaracteres = nomVin.length();
		char[] infosVin = new char[tailleElement]; 
		//Ajout des espaces pour avoir un nom recherché au même format que les noms dans le fichierStructure
		while(nbCaracteres < tailleNomMax) {
			nomVin += ' ';
			nbCaracteres++;
		}
		while(trouve == false) {
			int milieu = ((debut + fin) / 2);
			if(nomVin.equals(recupererString(milieu))) {
				trouve = true;
				infosVin = recupererTab(milieu);
				break;
			}
			if(recupererString(milieu).compareTo(nomVin) < 0) {
				debut = milieu + 1;
			}
			if(recupererString(milieu).compareTo(nomVin) > 0) {
				fin = milieu;
			}
			if (fin == -1 || debut == nbElements || debut == fin) {
				trouve = true;
				System.out.println("pas trouvé");
			}
		}	
		return infosVin;	
	}

 	public static void fichierStructure2(){
		FileReader fichier = null;
		RandomAccessFile fichierStructure = null;
		BufferedReader fichier2 = null;

				try {
					fichierStructure = new RandomAccessFile("c:/TpVin/fichierStructure.txt", "rw");
					fichier = new FileReader("c:/TpVin/VINStp.DON");
					fichier2 = new BufferedReader(fichier);
					while (fichier2.ready()) {
						String ligne;
						
						ligne = fichier2.readLine();
						byte[] tableauLigne = new byte[ligne.length()*2];
						fichierStructure.read(tableauLigne);
						ligne = new String(tableauLigne);
						String s = new String(tableauLigne);
						System.out.println(s);
						
						int nbTabulations = 0;
						int nbCaracteres = 0;
						int nbEspaces = 0;
							
					}	
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}	
}

