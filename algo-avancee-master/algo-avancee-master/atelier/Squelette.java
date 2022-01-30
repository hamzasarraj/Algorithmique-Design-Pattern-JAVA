package fr.eql.ai108.TPvin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Squelette {

	public static String champs ="";
	public static int tailleNom =0, tailleMaxNom=0;
	public static int tailleAppellation=0, tailleMaxAppellation=0;
	public static int tailleRegion=0, tailleMaxRegion=0;
	public static int tailleNomProprio=0, tailleMaxNomProprio=0;
	public static int tailleSurface=0, tailleMaxSurface=0;
	public static int tailleStand=0, tailleMaxStand=0;
	public static int tailleChamps =0;
	public static int nombreTab =0;
	public static char[] tableau;
	public static int tailleVin=98;


	public static void main(String[] args) {
		RandomAccessFile raf = null;


		trouverPlusGrandNombre();
		creerDeuxiemeFichier();
		try {
			raf = new RandomAccessFile("C:/Users/formation/Desktop/WorkspaceGitAlgoAvance/"
										+ "AlgoAvance/cours/tp vins/VINStp2.DON", "rw");
			trierFichier(raf, 389);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Trouver le plus grand nombre de caractères

	public static void trouverPlusGrandNombre (){

		// parcourir le fichier d'entrée
		FileReader fr =null;
		BufferedReader br = null;




		try {
			fr = new FileReader("C:/Users/formation/Desktop/WorkspaceGitAlgoAvance/"
					+ "AlgoAvance/cours/tp vins/VINStpVersioOK.DON");
			br = new BufferedReader (fr);
			// pour chaque ligne :
			// lire tailleNom (1ere tab) >> si tailleNom > tailleMaxNom alors tailleMaxNom = tailleNom

			while (br.ready()) {
				tailleChamps = 0;
				nombreTab = 0;
				champs = br.readLine();
				tableau = champs.toCharArray();
				for (int i = 0; i<tableau.length; i++) {
					if (tableau[i] != '\t') {
						tailleChamps++;
					}else {
						switch (nombreTab) {
						case 0:

							tailleNom = tailleChamps;
							if (tailleNom > tailleMaxNom) {
								tailleMaxNom = tailleNom;
							}
							break;

						case 1:	

							tailleAppellation = tailleChamps;
							if (tailleAppellation > tailleMaxAppellation) {
								tailleMaxAppellation = tailleAppellation;

							}
							break;

						case 2:

							tailleRegion = tailleChamps;
							if (tailleRegion > tailleMaxRegion) {
								tailleMaxRegion = tailleRegion;
							}
							break;

						case 3:

							tailleNomProprio = tailleChamps;
							if (tailleNomProprio > tailleMaxNomProprio) {
								tailleMaxNomProprio = tailleNomProprio;
							}
							break;
						case 4:

							tailleSurface = tailleChamps;
							if (tailleSurface> tailleMaxSurface) {
								tailleMaxSurface = tailleSurface;
							}
							break;
						}
						nombreTab++;
						tailleChamps =0;
					}
				}
				tailleStand = tailleChamps;
				if (tailleStand> tailleMaxStand) {
					tailleMaxStand = tailleStand;
				}
			}
			System.out.println("taille max nom: " + tailleMaxNom);
			System.out.println("taille max Appellation "+tailleMaxAppellation);
			System.out.println("taille max region " + tailleMaxRegion);
			System.out.println("taille max nom proprio "+tailleMaxNomProprio);
			System.out.println("taille surface "+ tailleMaxSurface);
			System.out.println("taille stand "+tailleMaxStand);
			System.out.println("nomber de tabulations "+ nombreTab);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	//Création du deuxieme fichier
	public static void creerDeuxiemeFichier () {

		//Creer le nouveau fichier
		//lire le premier fichier
		FileReader fr =null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fr = new FileReader("C:/Users/formation/Desktop/WorkspaceGitAlgoAvance/"
					+ "AlgoAvance/cours/tp vins/VINStpVersioOK.DON");
			br = new BufferedReader (fr);
			fw = new FileWriter("C:/Users/formation/Desktop/WorkspaceGitAlgoAvance/"
					+ "AlgoAvance/cours/tp vins/VINStp2.DON", true);
			bw = new BufferedWriter(fw);

			while(br.ready()) {
				champs = br.readLine();
				tableau = champs.toCharArray();
				tailleChamps =0;
				nombreTab = 0;
				for (int i = 0; i<tableau.length; i++) {
					if (tableau[i] != '\t') {
						tailleChamps++;
						bw.write(tableau[i]);
					}else {
						switch (nombreTab) {
						case 0:
							if (tailleChamps<tailleMaxNom) {
								for (int j = tailleChamps; j < tailleMaxNom; j++ )
									bw.write(" ");
							}	
							break;
						case 1:
							if (tailleChamps<tailleMaxAppellation) {
								for (int j = tailleChamps; j < tailleMaxAppellation; j++ )
									bw.write(" ");
							}	
							break;
						case 2:
							if (tailleChamps<tailleMaxRegion) {
								for (int j = tailleChamps; j < tailleMaxRegion; j++ )
									bw.write(" ");
							}	
							break;
						case 3:
							if (tailleChamps<tailleMaxNomProprio) {
								for (int j = tailleChamps; j < tailleMaxNomProprio; j++ )
									bw.write(" ");
							}	
							break;
						case 4:
							if (tailleChamps<tailleMaxSurface) {
								for (int j = tailleChamps; j < tailleMaxSurface; j++ )
									bw.write(" ");
							}	
							break;
						}
						nombreTab++;
						tailleChamps = 0;

					}
				}
				if (tailleChamps<tailleMaxStand) {
					for (int j = tailleChamps; j < tailleMaxStand; j++ )
						bw.write(" ");
				}	
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bw.close();
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public static void trierFichier(RandomAccessFile raf, int n) {

		//		RandomAccessFile raf = null;
		//		byte[] tableauNom;
		//		String nom1;
		//		String nom2;
		//
		//		try {
		//
		//			raf = new RandomAccessFile("C:/Users/formation/Desktop/WorkspaceGitAlgoAvance/"
		//					+ "AlgoAvance/cours/tp vins/VINStp2.DON", "rw");
		//
		//			tableauNom = new byte [100];
		//			raf.read(tableauNom);
		//			nom1 = new String (tableauNom);
		//			raf.read(tableauNom);
		//			nom2= new String (tableauNom);
		//			System.out.println("nom1: " + nom1);
		//			System.out.println("nom2: " + nom2);
		//			if(nom1.compareTo(nom2) > 0) {
		//				System.out.println(nom2);
		//				System.out.println(nom1);
		//			}
		//
		//		} catch (IOException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}
		if (n>1) {
			for (int i=0; i<n-1; i++) {
				String nom1 = recupererVin(raf, i);
				String nom2 = recupererVin(raf, i+1);
				if (nom1.compareTo(nom2) < 0) {
					permuter(raf, i, i+1);
				}
			}
			trierFichier(raf, n-1);
		}
	}


	public static void permuter(RandomAccessFile raf, int m, int n)
	{
		// permuter l’enregistrement m et l’enregistrement n dans le fichier
		String nom2;
		String nom1;

		nom1 = recupererVin (raf, m);
		nom2 = recupererVin (raf,n);
		ecrireVin(raf, nom1, n);
		ecrireVin(raf, nom2, m);
	}

	public static void ecrireVin (RandomAccessFile raf, String nomVin,int index){
		try {
			raf.seek(tailleVin*index);
			byte[] tableauNom = nomVin.getBytes();
			raf.write(tableauNom);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String recupererVin(RandomAccessFile raf, int index)
	{
		int taille = tailleVin;
		int pointeur = tailleVin*index;
		byte[] tableauNom;
		String nomVin="";

		try {
			raf.seek(pointeur);
			tableauNom = new byte [taille];
			raf.read(tableauNom);
			nomVin = new String (tableauNom);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomVin;
	}
	
	//		 public static String rechercher(String nom)
	//		 {
	//		  // dichotomie
	//		  return ;
}






