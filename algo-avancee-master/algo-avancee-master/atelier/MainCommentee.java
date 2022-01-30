package tpvin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class MainCommentee {
	
	final static String NOMFICHIER = "C:/Users/formation/git/algo-avancee/cours/tp vins/VINStp.DON";    		//nom du fichier en entrée
	static int nbCarNom=0;  		//Nombre max de caractères pour l'information "nom du vin"
	static int nbCarAppel=0;		//Nombre max de caractères pour l'information "appellation du vin"
	static int nbCarRegion=0;		//Nombre max de caractères pour l'information "région du vin"
	static int nbCarProprio=0;		//Nombre max de caractères pour l'information "propriétaire du vin"
	static int nbCarSurf=0;			//Nombre max de caractères pour l'information "surface"
	static int nbCarNumStand=0;		//Nombre max de caractères pour l'information "numéro du stand"
	
	public static void main(String[] args) {
		
		//determinerNbMaxCaracteres();
		String fichierCree = "C:/Users/formation/git/algo-avancee/cours/tp vins/VinsNouveau";  //creerFichierStructure();
		//trier(fichierCree);
		System.out.println("Entrez le nom d'un vin pour lequel vous souhaitez avoir plus d'informations");
		Scanner scan = new Scanner(System.in);
		String valeurEntree = scan.nextLine();
		recherche(valeurEntree, fichierCree);
		scan.close();
	}
	
	
	
	/**
	 * Cette méthode détermine le nombre maximal de caractères par colonne dans le fichier : 
	 * "C:/Users/formation/git/algo-avancee/cours/tp vins/VINStp.DON" et modifie la valeur des variables de classe 
	 * nbCarNom, nbCarAppel, nbCarRegion, nbCarProprio, nbCarSurf, nbCarNumStand
	 */
	public static void determinerNbMaxCaracteres() {
		
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(NOMFICHIER);
			br = new BufferedReader(fr);
			String ligne = br.readLine();
			//lecture ligne à ligne du fichier
			while(ligne!=null) {
				//initialisation de la variable nbTab (représente le nombre de tabulations déjà parcourues) à 0
				int nbTab=0;
				//boucle sur tous les caractères de la ligne
				for(int i=0;i<ligne.length();i++){
					int j=i;
					int nbCar=0;
					//à partir du caractère j, boucle sur tous les caractères jusqu'à trouver une tabulation
					while(j<ligne.length()&&ligne.charAt(j)!='\t') {
						j=j+1;
						nbCar+=1;
					}
					nbTab+=1;
					//en fonction du nombre de tabulations déjà rencontrées, le programme détermine si les caractères lus
					//sont ceux du nom du vin, de l'appellation, de la région, du propriétaire, de la surface ou du numéro 
					//du stand. Compare le nombre de caractères lus avec le nombre max de caractères.
					switch(nbTab) {
						case 1:
							if(nbCarNom<nbCar) nbCarNom=nbCar;
							break;
						case 2:
							if(nbCarAppel<nbCar) nbCarAppel=nbCar;
							break;
						case 3:
							if(nbCarRegion<nbCar) nbCarRegion=nbCar;
							break;
						case 4:
							if(nbCarProprio<nbCar) nbCarProprio=nbCar;
							break;
						case 5:
							if(nbCarSurf<nbCar) nbCarSurf=nbCar;
							break;
						case 6:
							if(nbCarNumStand<nbCar) nbCarNumStand=nbCar;
							break;
					}
					i=j;
					//après le passage d'une tabulation, rénitialisation du nombre de caractères à 0
					nbCar=0;
				}
				//à la fin de la boucle sur une ligne, réinitialisation du nombre de tabulations à 0
				nbTab=0;
				ligne=br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Cette méthode crée un fichier structuré à partir du fichier de départ et en fonction du nombre max de caractères par colonne
	 * déterminé dans la méthode determinerNbMaxCaracteres
	 * @return une variable de type String qui représente le chemin du fichier créé.
	 */
	public static String creerFichierStructure() {
		
		String nomFichierCree="C:/Users/formation/git/algo-avancee/cours/tp vins/VinsNouveau";
		FileReader fr = null;
		BufferedReader br = null;
		File file = new File(nomFichierCree);
		RandomAccessFile raf = null;
		try {
			//création du fichier
			file.createNewFile();
			//instanciation d'un RandomAccessFile pour écrire le fichier structuré
			raf= new RandomAccessFile(file,"rw");
			//instanciation d'un FileReader et d'un BufferedReader pour lire le fichier de départ
			fr = new FileReader(NOMFICHIER);
			br = new BufferedReader(fr);
			String ligne = br.readLine();
			//lecture ligne à ligne du fichier de départ
			while(ligne!=null) {
				int nbTab=0;
				////boucle sur tous les caractères de la ligne
				for(int i=0;i<ligne.length();i++){
					int j=i;
					//initialisation de la variable nbTab (représente le nombre de tabulations déjà parcourues) à 0
					int nbCar=0;
					//à partir du caractère j, boucle sur tous les caractères jusqu'à trouver une tabulation
					while (j < ligne.length() && ligne.charAt(j) != '\t') {
						raf.writeChar(ligne.charAt(j));
						j = j + 1;
						nbCar += 1;
					}
					nbTab += 1;
					//index = différence entre le nombre max de caractères et le nombre de 
					//caractères (=nombre d'espaces à créer)
					int index = 0;  
					switch (nbTab) {
						case 1:
							if (nbCar < nbCarNom) index = nbCarNom - nbCar;
							break;
						case 2:
							if (nbCar < nbCarAppel) index = nbCarAppel - nbCar;
							break;
						case 3:
							if (nbCar < nbCarRegion) index = nbCarRegion - nbCar;
							break;
						case 4:
							if (nbCar < nbCarProprio) index = nbCarProprio - nbCar;
							break;
						case 5:
							if (nbCar < nbCarSurf) index = nbCarSurf - nbCar;
							break;
						case 6:
							if (nbCar < nbCarNumStand) index = nbCarNumStand - nbCar;
							break;
					}
					for (int k = 0; k < index; k++) {
						raf.writeChar(' ');
					}
					i=j;
				}	
				ligne = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return nomFichierCree;
	}
	
	/**
	 * Cette méthode trie par ordre alphabétique le fichier dont le chemin a été passé en argument.
	 * @param nomFichier une String qui représente le chemin du fichier à trier.
	 */
	public static void trier(String nomFichier) {
		RandomAccessFile raf=null;
		try {
			//instanciation d'un objet RandomAccessFile
			raf = new RandomAccessFile(nomFichier, "rw");
			
			//choix d'un algorithme de tri à bulle
			for(int k=0;k<raf.length()-196;k+=196) {
				//le programme boucle tous les 196 caractères
				for(int i=0;i<raf.length()-196;i+=196) {
					String nomVin1 ="";
					String nomVin2 ="";
					//le programme se place avant le premier octet
					raf.seek(i);
					//le programme lit les 92 octets suivants (46 caractères suivants=>le nom du 1er vin)
					for(int j=0;j<=92;j++) {
						nomVin1+=raf.readChar();
					}
					//le programme se place avant le premier octet du vin suivant et lit les 92 caractères 
					//suivants (nom du 2ème vin)
					raf.seek(i+196);
					for(int j=0;j<=92;j++) {
						nomVin2+=raf.readChar();
					}
					//compare le nom du 1er vin avec le nom du 2ème vin. Si nomVin1>nomVin2, on inverse 
					//les 196 caractères avec les 196 caractères suivants
					if (nomVin1.compareTo(nomVin2)>0) {
						for(int j=0;j<196;j+=2) {
							raf.seek(i+j);
							char car1 = raf.readChar();
							raf.seek(i+j+196);
							char car2 = raf.readChar();
							raf.seek(i+j);
							raf.writeChar(car2);
							raf.seek(i+j+196);
							raf.writeChar(car1);
						}
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				raf.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	/** 
	 * Cette méthode affiche les informations (appellation, région, nom du propriétaire, surface et numéro du stand)
	 * pour le vin passé en argument.
	 * @param valeurCherchee : le nom du vin pour lequel on souhaite connaitre les caractéristiques.
	 * @param nomFichier : le nom du fichier dans lequel chercher les informations.
	 */
	
	public static void recherche(String valeurCherchee, String nomFichier) {
		RandomAccessFile raf=null;
		int position=0;
		try {
			raf = new RandomAccessFile(nomFichier, "r");
			int deb=0;
			int fin=(int) raf.length();
			boolean trouve=false;
			
			//implémentation de la méthode de recherche dichotomique
			while((trouve==false)&&(fin>=deb))
			{	
				int milieu = ((fin+deb)/2)/196;
				raf.seek(milieu*196);
				String nomVin="";
				for(int i=0;i<92;i+=2) {
					nomVin+=raf.readChar();
				}
				nomVin=nomVin.trim();
				if(valeurCherchee.equals(nomVin)) 
					{
						trouve=true;
						position=milieu*196;
					}
				else if(valeurCherchee.compareTo(nomVin)<0) 	
					{
						fin=(fin+deb)/2-196;
					}
				else if (valeurCherchee.compareTo(nomVin)>0)
					{
						deb=(fin+deb)/2+196;
					}
			}
			
			//si le programme a trouvé la valeur cherchée, on extrait du fichier le bloc d'informations se rapportant au vin trouvé
			//et on affiche les résultats
			if (trouve==true) 
				{
					raf.seek(position);
					char[] infosVin = new char[196];
					for(int i=0;i<196;i+=2) {
						infosVin[i]=raf.readChar();
					}
				afficherResultats(infosVin);
				}
			//sinon on affiche que le vin n'a pas été trouvé
			else 
				{
					System.out.print("Le vin "+valeurCherchee+" n'a pas été trouvé");
				}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Cette méthode lit le tableau passé en argument, en extrait le nom du vin, l'appellation, la région, le propriétaire
	 * la surface et le numéro du stand et affiche ces informations.
	 * @param infosVin : un tableau de caractères
	 */
	public static void afficherResultats(char[] infosVin) {	
		String nomVin="";
		String appelVin="";
		String regionVin="";
		String proprioVin="";
		String surfVin="";
		String numStand="";
		
		//le programme boucle sur tous les caractères du tableau passé en argument et, en fonction de la position des caractères, 
		//reconstitue le nom du vin, son appellation, sa région, son propriétaire, sa surface et le numéro du stand.
		for(int i=0;i<infosVin.length;i+=2) {
			if(i<92 && infosVin[i]!=' ') nomVin+=infosVin[i];
			else if(i>=92 && i<138 && infosVin[i]!=' ') appelVin+=infosVin[i];
			else if(i>=138 && i<178 && infosVin[i]!=' ') regionVin+=infosVin[i];
			else if(i>=178 && i<184 && infosVin[i]!=' ') proprioVin+=infosVin[i];
			else if(i>=184 && i<190 && infosVin[i]!=' ') surfVin+=infosVin[i];
			else if(i>=190 && i<196 && infosVin[i]!=' ') numStand+=infosVin[i];
		}
		
		//affichage des résultats
		System.out.print("Le vin "+nomVin+" a pour appellation "+appelVin+" dans la région "+regionVin+". "
				+ "Le propriétaire s'appelle "+proprioVin+". Il est au stand "+numStand+". Il a une surface de "+surfVin+" hectares");
	}

}

