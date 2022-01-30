package fr.eql.ai108.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DemoTime {

	public static void main(String[] args) {
		// LocalDate, LocalTime, LocalDateTime, ZonedDateTime
		
		//LOCALDATE
		//Date d'aujourd'hui:
		LocalDate dateAujourDHui = LocalDate.now();
		System.out.println("Ajourd'hui nous sommes " + dateAujourDHui);
		
		//Date précise: L'année de commence plus à 1900 et l'index des mois commence à 1
		LocalDate uneDate = LocalDate.of(2017, 1, 25);
		System.out.println(uneDate);
		
		//Modifier une date avec la méthode with
		LocalDate dateModifiee = uneDate.withYear(2020).withMonth(12);
		System.out.println(dateModifiee);
		
		//Convertir chaine de caractère en Date
		LocalDate dateParsee = LocalDate.parse("2017-02-09", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		System.out.println("Date parsée: " + dateParsee);
		
		//Formater l'affichage d'une date
		String dateFormatee = dateParsee.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println("Date formatée: " + dateFormatee);
		
		//Incrémenter ou décrémenter la date minus ou plus
		//Ajouter un jour
		LocalDate dateIncrementJour = uneDate.plusDays(32);
		System.out.println(dateIncrementJour);
		
		//ENlever un mois
		LocalDate dateDecrementMois = uneDate.minusMonths(2);
		System.out.println(dateDecrementMois);
		
		
		//LOCALTIME: Time sans date
		LocalTime maintenant = LocalTime.now();
		System.out.println(maintenant);
		
		LocalTime heureParsee = LocalTime.parse("17:45");
		System.out.println(heureParsee);
		
		LocalTime ajoutMinute = heureParsee.plusMinutes(30);
		System.out.println(ajoutMinute);
		
		//LOCALDATETIME
		LocalDateTime dateTimeNow = LocalDateTime.now();
		System.out.println("LocalDateTime: " + dateTimeNow);
		LocalDateTime uneDateTime = LocalDateTime.of(2020, 2, 28, 6, 30, 45);
		System.out.println("Autre LocalDateTime: " + uneDateTime);
		
		ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
		LocalDateTime tokyo = LocalDateTime.now(tokyoZone);
		System.out.println("Pendant ce temps là à Tokyo: " + tokyo);
		
		
		//ZonedDateTime
		ZonedDateTime zonesDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
		System.out.println(zonesDateTime);
		
		ZonedDateTime australiaSydneyZonesDateTime = ZonedDateTime.of(LocalDateTime.now(ZoneId.of("Australia/Sydney")),
				ZoneId.of("Australia/Sydney"));
		System.out.println(australiaSydneyZonesDateTime);	
		
		ZonedDateTime tokyoZonedDateTime = ZonedDateTime.of(LocalDateTime.now(tokyoZone), tokyoZone);
		System.out.println(tokyoZonedDateTime);
		System.out.println("Fuseau horraire: " + tokyoZonedDateTime.getZone());
		
	}

}
