package fr.eql.ai108.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {

	public static void main(String[] args) {
		//Le RAF est un fichier binaire à accès directe:
		RandomAccessFile raf = null;
		
		try {
			raf = new RandomAccessFile("c:/DossierAI108/raf.bin", "rw");
			int[] tab = {13, 42, 45, 1545, 7984};
			for (int i : tab) {
				//Le raf a des méthodes spécifiques pour écrire chaque type présent 
				//en java
				raf.writeInt(i);
			}
			raf.writeChar('t');
			System.out.println("taille de mon fichier:" + raf.length());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				raf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Lecture dans le RAF
		RandomAccessFile raf2 = null;
		try {
			raf2 = new RandomAccessFile("c:/DossierAI108/raf.bin", "r");
			//Le RAF possède une méthode getFilePointer() qui permet de savoir où
			//est placé le pointer de lecteur
			System.out.println("Avant la lecture, le pointeur se situe sur: " 
					+ raf2.getFilePointer());
			//lecture du 4ème int
			//Bouger le pointeur avec la méthode seek(nbOctet)
			//3 pour me positionner sur l'octet précédent mon int
			//4: poids en octet d'un int en Java
			raf2.seek(3 * 4);
			System.out.println("Après le positionnement, le pointeur se trouve sur: "
					+ raf2.getFilePointer());
			//Je suis bien positionner pour lire le 4ème int
			System.out.println(raf2.readInt());
			System.out.println(raf2.readInt());
			//Attention: lorsqu'on lit une valeur, le pointeur se déplace
			System.out.println("Après la lecture de mes deux int, le pointeur est sur: "
					+ raf2.getFilePointer());
			System.out.println(raf2.readChar());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				raf2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
