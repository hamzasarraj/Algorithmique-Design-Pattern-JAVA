package fr.eql.ai108.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DemoDate {

	public static void main(String[] args) {
		
		//Instancier la date du jour
		Date date = new Date();
		
		//Pour afficher une date:
		//1ère méthode: toString()
		System.out.println("Date du jour: " + date.toString());
		
		//2ème méthode: un objet SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		System.out.println("Date du jour formatée : " + sdf.format(date));
		
		//L'année commence par 1900, le premier mois commence à 0:
		Date dateDepreciee = new Date(120, 10, 13);
		System.out.println("Ajourd'hui nous sommes le " + dateDepreciee.toString());
		
		//Convertir une chaîne de caractères en date
		String dateAFormater = "02-04-2020 17:35:20";
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		try {
			Date newDate = sdf2.parse(dateAFormater);
			System.out.println(newDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Comparer des java.util.date
		
		//1ère méthode: utiliser les méthodes before(), after() et equals()
		
		try {
			Date date1 = sdf.parse("17/07/1989");
			Date date2 = sdf.parse("15/10/2017");
			
			if(date1.after(date2)) {
				System.out.println("La date 1 est plus récente que la date 2");
			} else if(date1.before(date2)) {
				System.out.println("La date 2 est plus récente que la date 1");
			} else if(date1.equals(date2)) {
				System.out.println("Ce sont les mêmes dates");
			}
			
			//2ème méthode: compareTo()
			
			if(date1.compareTo(date2) > 0) {
				System.out.println("date2 est plus ancienne que date1");
			}else if(date1.compareTo(date2) < 0) {
				System.out.println("date1 est plus ancienne que date2");
			}else if(date1.compareTo(date2) == 0) {
				System.out.println("Ce sont les mêmes dates");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		

	}

}
