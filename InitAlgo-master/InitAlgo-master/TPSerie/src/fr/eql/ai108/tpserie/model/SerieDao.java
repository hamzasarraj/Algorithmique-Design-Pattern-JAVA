package fr.eql.ai108.tpserie.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerieDao {
	
	private File file = new File("serie.csv");
	
	private Serie stringToSerie(String ligne) {
		String[] infos = ligne.split(";");
		Serie serie = new Serie(infos[0], Integer.parseInt(infos[1]), 
				Integer.parseInt(infos[2]), infos[3], infos[4]);
		return serie;
	}
	private String serieToString(Serie serie){
		StringBuffer sb = new StringBuffer();
		sb.append(serie.getTitre());
		sb.append(";");
		sb.append(serie.getNbSaison());
		sb.append(";");
		sb.append(serie.getAnneeDiffusion());
		sb.append(";");
		sb.append(serie.getMaisonProd());
		sb.append(";");
		sb.append(serie.getEvaluation());
		return sb.toString();
	}
	public List<Serie> getAll(){	
		//Instancier une liste de série
		List<Serie> series = new ArrayList<Serie>();
		//Lire chacun des lignes du fichier CSV
		FileReader in = null;
		BufferedReader br = null;		
		try {
			in = new FileReader(file);
			br = new BufferedReader(in);
			String ligne = "";
			//Pour chacune de ces lignes, on instancie un objet série
			while((ligne = br.readLine()) != null) {
				Serie serie = stringToSerie(ligne);
				//On ajoute l'objet série à la liste
				series.add(serie);
			}
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
		//On retourne la liste		
		return series;
	}
	public void ajouterSerie(Serie serie){
		String chaine = serieToString(serie);
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(chaine + "\r\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void supprimerSerie (String titre){
		List<Serie> series = getAll();
		try {
			FileWriter fw = new FileWriter(file, false);
			for (Serie serie : series) {
				if(!serie.getTitre().equals(titre)){
					fw.write(serieToString(serie)+ "\r\n");
				}		
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mettreAJour (Serie serieUpdated){
		List<Serie> series = getAll();
		try {
			FileWriter fw = new FileWriter(file, false);
			for (Serie serie : series) {
				if(!serie.getTitre().equals(serieUpdated.getTitre())){
					fw.write(serieToString(serie)+ "\r\n");
				}else{
					fw.write(serieToString(serieUpdated)+ "\r\n");
				}				
			}
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
