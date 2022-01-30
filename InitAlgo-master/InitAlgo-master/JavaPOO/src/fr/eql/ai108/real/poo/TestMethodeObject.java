package fr.eql.ai108.real.poo;

public class TestMethodeObject {

	public static void main(String[] args) {
		Chien ein = new Chien("Ein", 8, 0.45f, 7.2f, "Welsh Corgi", 'E');
		Chien laica = new Chien("Laïca", 7, 0.75f, 12.45f, "Berger Allemand", 'L');
		 
		//Test toString()
		System.out.println(ein);
		System.out.println(laica);
		
		//Test Equals
		System.out.println(ein.equals(laica));
		System.out.println(ein.equals(ein));
		
		//Test CLone
		try {
			Chien copieEin = ein.clone();
			System.out.println(ein.equals(copieEin));
			copieEin.setNom("Iggy");
			System.out.println(ein.getNom());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
