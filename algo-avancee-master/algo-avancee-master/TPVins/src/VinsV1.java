import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class VinsV1 {

	private static int tailleNom = 0;
	private static int tailleAppellation = 0;
	private static int tailleRegion = 0;
	private static int tailleProducteur = 0;
	private static int tailleSuperficie = 0;
	private static int tailleStand = 0;
	
	private static int nombreEnregistrements = 0;
	private static int longueurEnregistrement = 0;
	
	private static String cheminOrigine = "C:\\git\\algo-avancee\\cours\\tp vins\\VINStp.DON";
	private static String cheminDestination = "C:\\git\\algo-avancee\\cours\\tp vins\\vins.ben";
	
	
	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		definirTailles();
		
		afficherTailles();
		
		ecrireFichier();
		
		RandomAccessFile raf;
		try {
			raf = new RandomAccessFile(cheminDestination, "rw");
		
			trierFichier(raf, nombreEnregistrements);
			
			for (int i = 0; i < nombreEnregistrements; i++) {
				System.out.println(recupererVin(raf, i));
			}
		
		//rechercher("chateau lapompe");
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("V1 - durée : " + ((endTime - startTime) / 1000) + "s");
	}
	
	public static void afficherTailles()
	{
		System.out.println("noms : " + tailleNom);
		System.out.println("appellations : " + tailleAppellation);
		System.out.println("regions : " + tailleRegion);
		System.out.println("producteurs : " + tailleProducteur);
		System.out.println("superficies : " + tailleSuperficie);
		System.out.println("stand : " + tailleStand);
	}
	
	public static void definirTailles()
	{
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(cheminOrigine));
		
			String ligne = br.readLine();
			
			while(ligne != null)
			{
				nombreEnregistrements++;
				char[] tableau = ligne.toCharArray();
				int nbTabs = 0;
				int taille = 0;
				
				for (int i = 0; i < tableau.length; i++) {
					
					if (tableau[i] != '\t')
					{
						taille++;
					}
					else
					{
						nbTabs++;
						switch(nbTabs)
						{
							case 1:
								if (taille > tailleNom) {
									tailleNom = taille;
								}
								break;
							case 2:
								if (taille > tailleAppellation) {
									tailleAppellation = taille;
								}
								break;
							case 3:
								if (taille > tailleRegion) {
									tailleRegion = taille;
								}
								break;
							case 4:
								if (taille > tailleProducteur) {
									tailleProducteur = taille;
								}
								break;
							case 5:
								if (taille > tailleSuperficie) {
									tailleSuperficie = taille;
								}
								break;
						}
						taille = 0;
					}
					
				}
				
				// dernier champ : stand (fin de la ligne)
				if (taille > tailleStand) {
					tailleStand = taille;
				}
				
				ligne = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		longueurEnregistrement = tailleNom + tailleAppellation + tailleRegion + tailleProducteur + tailleSuperficie + tailleStand;
	}

	public static void ecrireFichier()
	{
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(cheminOrigine));
			RandomAccessFile raf = new RandomAccessFile(cheminDestination, "rw");

			String ligne = br.readLine();
			while(ligne != null)
			{
				char[] tableau = ligne.toCharArray();
				int nbTabs = 0;
				int taille = 0;
				
				for (int i = 0; i < tableau.length; i++) {
					
					if (tableau[i] != '\t')
					{
						raf.writeChar(tableau[i]);
						taille++;
					}
					else
					{
						int nbEspaces = 0;
						nbTabs++;
						switch (nbTabs)
						{
							case 1:
								nbEspaces = tailleNom - taille;
								break;
							case 2:
								nbEspaces = tailleAppellation - taille;
								break;
							case 3:
								nbEspaces = tailleRegion - taille;
								break;
							case 4:
								nbEspaces = tailleProducteur - taille;
								break;
							case 5:
								nbEspaces = tailleSuperficie - taille;
								break;
						}
						
						for(int e = 0; e < nbEspaces; e++)
						{
							raf.writeChar(' ');
						}
						
						taille = 0;
					}
					
				}

				ligne = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void trierFichier(RandomAccessFile raf, int n) {
	
		if (n > 1)
		{
			for (int i = 0; i < n - 1; i++) {
				
				String vinA = recupererVin(raf, i);
				String vinB = recupererVin(raf, i+1);
				if (comparer(vinA, vinB) > 0)
				{
					permuter(raf, i, i+1);
				}
			}
			
			trierFichier(raf, n - 1);
		}
	}
	
	public static int comparer(String vinA, String vinB)
	{
		String nomA = getNom(vinA);
		String nomB = getNom(vinB);
		
		return nomA.compareTo(nomB);
	}
	
	public static String getNom(String vin)
	{
		String nom = "";
		for (int i = 0; i < tailleNom; i++)
		{
			nom += vin.charAt(i);
		}
		
		return nom;
	}
	
	public static void permuter(RandomAccessFile raf, int m, int n)
	{
		// permuter 2 l'enregistrement m et l'enregistrement n dans le fichier
		String vinM = recupererVin(raf, m); 
		String vinN = recupererVin(raf, n);
		
		ecrireVin(raf, vinM, n);
		ecrireVin(raf, vinN, m);
	}
	
	public static void ecrireVin(RandomAccessFile raf, String vin, int index)
	{
		try {
			raf.seek(longueurEnregistrement * index * 2);
			char[] tableau = vin.toCharArray();
			for (int i=0; i < tableau.length; i++)
			{
				raf.writeChar(tableau[i]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String recupererVin(RandomAccessFile raf, int index)
	{
		String result = "";
		long offset = longueurEnregistrement * index * 2;
		try {
			raf.seek(offset);
			for (int i=0; i < longueurEnregistrement; i++)
			{
				result += raf.readChar();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String rechercher(String nom)
	{
		// dichotomie
		return "";
	}
	
}
