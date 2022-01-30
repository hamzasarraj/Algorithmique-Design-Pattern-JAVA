package fr.eql.ai108.vins;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;


public class ProgrammeVins {

	static int tailleMaxNom=0;
	static int tailleMaxAp=0;
	static int tailleMaxRegion=0;
	static int tailleMaxProprio=0;
	static int tailleMaxSurface=0;
	static int tailleMaxStand=0;
	static int nbLignes =0;
	static int tailleLigne=0;
	static RandomAccessFile outputFile=null;
	static int resultatComparaison=0;

	public static void main(String[] args) {

		//aller récupérer le tableau de données initial

		FileReader fr = null;
		BufferedReader tabInit = null;

		try {
			fr = new FileReader("c:/Users/formation/Documents/tpVins/VINStp.DON");
			tabInit = new BufferedReader(fr);

			//1- METHODE GENERER FICHIER STRUCTURE


			compterChar(tabInit);
			afficher(tabInit);

			fr = new FileReader("c:/Users/formation/Documents/tpVins/VINStp.DON");
			tabInit = new BufferedReader(fr);
			RandomAccessFile tableauStructure = new RandomAccessFile("c:/Users/formation/Documents/tpVins/tableauStructure.txt", "rw");

			repartir(tabInit, tableauStructure);

			//2 - METHODE DE TRI (par BULLES)

			RandomAccessFile raf = new RandomAccessFile("c:/Users/formation/Documents/tpVins/tableauStructure.txt", "r");
			tailleLigne = tailleMaxNom + tailleMaxAp + tailleMaxRegion + tailleMaxProprio + tailleMaxSurface + tailleMaxStand;
			raf.length();
			int nbCharTot = (int) (raf.length());
			nbLignes = nbCharTot/tailleLigne;
			System.out.println("nombre de char total : " + nbCharTot + " et taille de la ligne : " + tailleLigne
					+ " enfin, le nombre de lignes : " + nbLignes);
			
			
			// ne fonctionne pas encore, bug à partir de permuter : trier(raf);
			
			 //tests
			
			byte[] tabByte = new byte[tailleLigne-1];
			tabByte = ecrireVin(raf,2);
			String s = new String(tabByte);
			System.out.println(s);
			String s2 = ecrireStringNomVin(raf,2);
			System.out.println(s2);
			String s3 = ecrireStringNomVin(raf,3);
			System.out.println(s3);
			System.out.println(comparerVins(s3, s2));
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				tabInit.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}


	}




	private static void trier(RandomAccessFile raf) {
		for (int i = nbLignes-1; i >1 ; i--) {
			for (int j =0; j<i-1; j++) {
				byte[] vin1 = null;
				byte[] vin2 =null;
				vin1 = ecrireVin(raf, i); //méthode renvoie une chaine de char qui correspond à la ligne d'un vin
				vin2 = ecrireVin(raf, i+1);
				
				String nomVin1 = ecrireStringNomVin(raf,i); //string1 et string2
				String nomVin2 = ecrireStringNomVin(raf, i+1);
				comparerVins(nomVin1,nomVin2);
				if (resultatComparaison > 0) {
					permuter(raf, vin1,vin2, i);
				}

			}
		}

	}




	private static void permuter(RandomAccessFile raf, byte[] m, byte[] n, int numLigne) {
		
		//toutes les méthodes marchaient, à partir du moment ou j'ai essayé d'implémenter celle ci, ça ne marchait plus : 
		
		byte[] buffer = new byte [tailleLigne];
		try {
			raf.seek((numLigne*tailleLigne) * 1);
			for (int i=0; i<tailleLigne; i++) {
				raf.seek((numLigne*tailleLigne)+i * 1);
				raf.getFilePointer();
				buffer[i]=m[i];
				raf.writeChar(n[i]);
			}
			for (int i =0; i<tailleLigne; i++) {
				raf.seek(((numLigne+1)*tailleLigne)+i * 1);
				raf.getFilePointer();
				raf.writeChar(buffer[i]);
			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private static int comparerVins(String a, String b) {
		resultatComparaison = a.compareTo(b);
		return resultatComparaison;
	}




	private static String ecrireStringNomVin(RandomAccessFile raf, int numLigne) {
		// TODO Auto-generated method stub
		byte[] tab = new byte [tailleMaxNom];
		
		try {
			raf.seek((numLigne*tailleLigne) * 1);
			for (int i=0; i<tailleMaxNom; i++) {
				raf.seek((numLigne*tailleLigne)+i * 1);
				raf.getFilePointer();
				tab[i]=raf.readByte();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String nomVin = new String(tab);
		return nomVin;
	}




	private static byte[] ecrireVin(RandomAccessFile raf, int numLigne) {
		//construit un tableau de char qui contient un Vin (toutes catégories)
		//bornes de chaque ligne : début : raf.seek((numLigne*tailleLigne) * 1);
		// fin : raf.seek((numLignes*tailleLigne + tailleLigne-1) * 1)
		byte[] tab = new byte [tailleLigne];
		try {
			raf.seek((numLigne*tailleLigne) * 1);
			for (int i=0; i<tailleLigne; i++) {
				raf.seek((numLigne*tailleLigne)+i * 1);
				raf.getFilePointer();
				tab[i]=raf.readByte();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tab;
	}




	private static void afficher(BufferedReader tableau) {
		System.out.println(tailleMaxNom);
		System.out.println(tailleMaxAp);
		System.out.println(tailleMaxRegion);
		System.out.println(tailleMaxProprio);
		System.out.println(tailleMaxSurface);
		System.out.println(tailleMaxStand);
	}

	private static int[] compterChar(BufferedReader inputFile) {


		int[] taillesMax = {tailleMaxNom, tailleMaxAp, tailleMaxRegion,
				tailleMaxProprio,tailleMaxSurface, tailleMaxStand};

		int nbTab = 0;
		int tailleChamp = 0;

		String ligne;
		try {
			ligne = inputFile.readLine();
			while(ligne != null)
			{
				char[] tableau = ligne.toCharArray();
				for (int i =0; i <tableau.length; i++) {
					if (tableau[i] != '\t' && i < tableau.length-1) {
						tailleChamp++;
					} else if (i == tableau.length - 1) {
						tailleChamp++;
						if (tailleChamp>tailleMaxStand) {
							tailleMaxStand = tailleChamp;
						}
						tailleChamp=0;
					}
					else if (tableau[i] == '\t') {
						nbTab++;
						switch (nbTab) {
						case 1:
							if (tailleChamp>tailleMaxNom) {
								tailleMaxNom = tailleChamp;	
							}
							break;
						case 2:
							if (tailleChamp>tailleMaxAp) {
								tailleMaxAp = tailleChamp;

							}
							break;
						case 3:
							if (tailleChamp>tailleMaxRegion) {
								tailleMaxRegion = tailleChamp;

							}
							break;
						case 4:
							if (tailleChamp>tailleMaxProprio) {
								tailleMaxProprio = tailleChamp;

							}
							break;
						case 5:
							if (tailleChamp>tailleMaxSurface) {
								tailleMaxSurface = tailleChamp;
							}
							break;
						default:
							break;
						}	
						tailleChamp=0;
					}

				}
				nbTab =0;
				ligne = inputFile.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return taillesMax;
	}




	private static void repartir(BufferedReader inputFile, RandomAccessFile outputFile) {

		int nbTab = 0;
		int tailleChamp = 0;
		String ligne;
		try {
			ligne = inputFile.readLine();
			while(ligne != null)
			{
				char[] tableau = ligne.toCharArray();
				for (int i =0; i <tableau.length; i++) {
					if (i < (tableau.length -1) && tableau[i] != '\t') {
						tailleChamp++;
						outputFile.write(tableau[i]);
					} else if (i == (tableau.length - 1)) {
						tailleChamp++;
						outputFile.write(tableau[i]);
						tailleChamp=0;
					}
					else if (tableau[i] == '\t') {
						nbTab++;
						switch (nbTab) {
						case 1:
							for (int j=0; j<(tailleMaxNom - tailleChamp);j++) {
								outputFile.write(' ');
							}
							break;
						case 2:
							for (int j=0; j<(tailleMaxAp - tailleChamp);j++) {
								outputFile.write(' ');
							}
							break;
						case 3:
							for (int j=0; j<(tailleMaxRegion - tailleChamp);j++) {
								outputFile.write(' ');
							}
							break;
						case 4:
							for (int j=0; j<(tailleMaxProprio - tailleChamp);j++) {
								outputFile.write(' ');
							}
							break;
						case 5:
							for (int j=0; j<(tailleMaxSurface - tailleChamp);j++) {
								outputFile.write(' ');
							}
							break;
						default:
							break;
						}	
						tailleChamp=0;
					}

				}
				nbTab =0;
				ligne = inputFile.readLine();
			}
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				inputFile.close();
				outputFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}



}
