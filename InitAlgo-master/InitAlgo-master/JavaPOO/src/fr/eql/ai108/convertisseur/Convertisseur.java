package fr.eql.ai108.convertisseur;

public class Convertisseur {
	
	private static double tauxUSD = 1.16d;
	
	public static double euroToUSD(double amount) {
		return amount * Convertisseur.tauxUSD;
	}
	public  double euroToYEN(double amount) {
		return amount * Convertisseur.tauxUSD;
	}
}
