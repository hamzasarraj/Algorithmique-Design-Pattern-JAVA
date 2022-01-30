package fr.eql.ai108.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReader {

	public static void main(String[] args) {
		//FileReader
		FileReader fr = null;
		try {
			fr  = new FileReader("c:/DossierAI108/testFW.txt");
			int caractere = 0;
			String chaine = "";
			
			//Methode read renvoie -1 quand il n'y a plus rien à lire
			while((caractere = fr.read()) != -1) {
				chaine += (char)caractere;
			}
			System.out.println(chaine);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//Buffered Reader
		//Lecture de tous le fichier
		FileReader in = null;
		BufferedReader br = null;
		
		try {
			in = new FileReader("c:/DossierAI108/testBW.txt");
			br = new BufferedReader(in);
			String chaine2 = "";
			// Le BR possède une méthode ready() qui renvoie true tant qu'il reste
			// des éléments à lire dans le fichier
			while(br.ready()) {
				chaine2 += br.readLine();
			}
			System.out.println(chaine2);
			
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
		
		//BufferedReader
		//Lecture ligne par ligne
		 FileReader in2 = null;
		 BufferedReader br2 = null;
		 try {
			in2 = new FileReader("c:/DossierAI108/testBW.txt");
			br2 = new BufferedReader(in2);
			String ligne1 = br2.readLine();
			int ligne2 = br2.read();
			System.out.println(ligne1);
			System.out.println(ligne2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in2.close();
				br2.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
