package fr.eql.AI108.tpvin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TpVinV3 
{
	public static int tailleNom = 0;
	public static int tailleMaxNom = 0;
	public static int tailleAppellation = 0;
	public static int tailleMaxAppellation = 0;
	public static int tailleRegion = 0;
	public static int tailleMaxRegion = 0;
	public static int tailleProprietaire = 0;
	public static int tailleMaxProprietaire = 0;
	public static int tailleSurface = 0;
	public static int tailleMaxSurface = 0;
	public static int tailleNumeroStand = 0;
	public static int tailleMaxNumeroStand = 0;
	public static int nbTabulation = 0;
	public static int nbVins = 0;
	public static int tailleLigne = 0;
	public static FileReader in = null;
	public static BufferedReader br = null;
	public static RandomAccessFile raf = null;

	public static void main(String[] args) throws FileNotFoundException 
	{
		plusGrandCatégorie();
//		System.out.println(recupererVin(index));
		System.out.println("taille ligne : " + tailleLigne);
				
		trierVins(raf, nbVins);

		raf = new RandomAccessFile("C:/Users/formation/git/algo-avancee/cours/tp vins/vin.txt", "rw");

		
		for (int i = 0; i < 390; i++)
		{

			System.out.println(recupererVin(raf,i));

		}
	
	}

	public static int plusGrandCatégorie()
	{	

		FileReader in = null;
		BufferedReader br = null;
		RandomAccessFile raf = null;
		File vin = new File("C:/Users/formation/git/algo-avancee/cours/tp vins/vin.txt");
		try {
			boolean createFile = vin.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try 
		{
			in = new FileReader("C:/Users/formation/git/algo-avancee/cours/tp vins/VINStp.DON");
			br = new BufferedReader(in);
			determinerTailleMaxCategorie(br);
			
			in = new FileReader("C:/Users/formation/git/algo-avancee/cours/tp vins/VINStp.DON");
			br = new BufferedReader(in);
			raf = new RandomAccessFile("C:/Users/formation/git/algo-avancee/cours/tp vins/vin.txt", "rw");

			ecrireUnNouveauFichierOrdonne(br, raf);
		}


		catch (IOException e) 
		{

			e.printStackTrace();
		}
		finally {
			try {
				System.out.println("nom : " + tailleMaxNom);
				System.out.println("appellation: " + tailleMaxAppellation);
				System.out.println("region : " + tailleMaxRegion);
				System.out.println("propietaire : " + tailleMaxProprietaire);
				System.out.println("surface : " + tailleMaxSurface);
				System.out.println("stand : " + tailleMaxNumeroStand);
				br.close();
				in.close();
				raf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		return tailleMaxNom+tailleMaxAppellation+tailleMaxRegion
				+tailleMaxProprietaire+tailleMaxSurface+tailleMaxNumeroStand;
	}

	private static void ecrireUnNouveauFichierOrdonne(BufferedReader br, RandomAccessFile raf) throws IOException {
		while(br.ready())
		{
			String ligne1 = br.readLine();				
			char[] ligne = ligne1.toCharArray();
			tailleNom = 0;
			tailleAppellation = 0;
			tailleRegion = 0;
			tailleProprietaire = 0;
			tailleSurface = 0;
			tailleNumeroStand = 0;
			nbTabulation = 0;

			for (int i = 0; i < ligne.length; i++) 
			{
				if(ligne[i] == '\t')
				{
					nbTabulation++;
				}
				if(ligne[i] != '\t' && nbTabulation == 0)
				{
					tailleNom++;
					raf.write(ligne[i]);
				}
				if(i+1 < ligne.length && ligne[i+1] == '\t' && nbTabulation == 0)
				{
					for (int j = tailleNom; j < tailleMaxNom; j++) 
					{
						raf.write(' ');
						//raf.writechar
					}
				}					
				if(ligne[i] != '\t' && nbTabulation == 1)
				{
					tailleAppellation++;
					raf.write(ligne[i]);
				}
				if(i+1 < ligne.length && ligne[i+1] == '\t' && nbTabulation == 1)
				{
					for (int j = tailleAppellation; j < tailleMaxAppellation; j++) 
					{
						raf.write(' ');
					}
				}
				if(ligne[i] != '\t' && nbTabulation == 2)
				{
					tailleRegion++;
					raf.write(ligne[i]);
				}
				if(i+1 < ligne.length && ligne[i+1] == '\t' && nbTabulation == 2)
				{
					for (int j = tailleRegion; j < tailleMaxRegion; j++) 
					{
						raf.write(' ');
					}
				}
				if(ligne[i] != '\t' && nbTabulation == 3)
				{
					tailleProprietaire++;
					raf.write(ligne[i]);
				}
				if(i+1 < ligne.length && ligne[i+1] == '\t' && nbTabulation == 3 )
				{
					for (int j = tailleProprietaire; j < tailleMaxProprietaire; j++) 
					{
						raf.write(' ');
					}
				}
				if(ligne[i] != '\t' && nbTabulation == 4)
				{
					tailleSurface++;
					raf.write(ligne[i]);
				}
				if(i+1 < ligne.length && ligne[i+1] == '\t' && nbTabulation == 4)
				{
					for (int j = tailleSurface; j < tailleMaxSurface; j++) 
					{
						raf.write(' ');
					}
				}
				if(ligne[i] != '\t' && nbTabulation == 5)
				{
					tailleNumeroStand++;
					raf.write(ligne[i]);
				}			
				if(i+1 < ligne.length && ligne[i+1] == '\t' && nbTabulation == 5)
				{
					for (int j = tailleNumeroStand; j < tailleMaxNumeroStand; j++) 
					{
						raf.write(' ');
					}
				}
			}
		}
	}

	private static void determinerTailleMaxCategorie(BufferedReader br) throws IOException {
		while(br.ready())
		{
			String ligne1 = br.readLine();				
			char[] ligne = ligne1.toCharArray();
			tailleNom = 0;
			tailleAppellation = 0;
			tailleRegion = 0;
			tailleProprietaire = 0;
			tailleSurface = 0;
			tailleNumeroStand = 0;
			nbTabulation = 0;
			for (int i = 0; i < ligne.length; i++) 
			{
				if(ligne[i] == '\t')
				{
					nbTabulation++;
				}
				else if(ligne[i] != '\t' && nbTabulation == 0)
				{
					tailleNom++;
				}
				else if(ligne[i] != '\t' && nbTabulation == 1)
				{
					tailleAppellation++;
				}
				else if(ligne[i] != '\t' && nbTabulation == 2)
				{
					tailleRegion++;
				}
				else if(ligne[i] != '\t' && nbTabulation == 3)
				{
					tailleProprietaire++;
				}
				else if(ligne[i] != '\t' && nbTabulation == 4)
				{
					tailleSurface++;
				}
				else if(ligne[i] != '\t' && nbTabulation == 5)
				{
					tailleNumeroStand++;
				}

			}
			if (tailleNom > tailleMaxNom) 
			{
				tailleMaxNom = tailleNom;
			}
			if (tailleAppellation > tailleMaxAppellation) {
				tailleMaxAppellation = tailleAppellation;
			}
			if (tailleRegion > tailleMaxRegion) {
				tailleMaxRegion = tailleRegion;
			}
			if (tailleProprietaire > tailleMaxProprietaire) {
				tailleMaxProprietaire = tailleProprietaire;
			}
			if (tailleSurface > tailleMaxSurface) {
				tailleMaxSurface = tailleSurface;
			}
			if (tailleNumeroStand > tailleMaxNumeroStand) {
				tailleMaxNumeroStand = tailleNumeroStand;
			}
			nbVins++;	
		}
		tailleLigne = tailleMaxNom + tailleMaxAppellation + tailleMaxRegion + tailleMaxProprietaire 
				+ tailleMaxSurface + tailleMaxNumeroStand;
	}

	public static void permuter(RandomAccessFile raf, int m, int n)
	{
		String vinM = recupererVin(raf, m);
		String vinN = recupererVin(raf, n);
		
		ecrireVin(raf, vinM, n);
		ecrireVin(raf, vinN, m);
		
	}

	public static String recupererVin(RandomAccessFile raf, int index)
	{
		int taille = tailleLigne;
		String result = "";
		long offset = taille * index;
		try {
			raf.seek(offset);
			byte[] b = new byte[taille];
			raf.read(b);
			result = new String(b);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static int comparer(String vinA , String vinB)
	{	
			return vinA.compareTo(vinB);	
	}
	public static void trierVins(RandomAccessFile raf, int n)
	{
		try {
			raf = new RandomAccessFile("C:/Users/formation/git/algo-avancee/cours/tp vins/vin.txt", "rw");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(n > 1)
		{
			for (int i = 0; i < n - 1; i++) 
			{
				String vinA = recupererVin(raf, i);
				String vinB = recupererVin(raf, i+1);
				if(comparer(vinA, vinB) > 0)
				{
					permuter(raf, i, i+1);
				}
			}
			trierVins(raf, n - 1);
		}
		
	}
	public static void ecrireVin(RandomAccessFile raf, String vin, int index)
	{
		try {
			raf.seek(tailleLigne * index);
			byte[] b = vin.getBytes();
			raf.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String recherche(String nom)
	{
		//recherche dichotomique
		return"";
	}
}




