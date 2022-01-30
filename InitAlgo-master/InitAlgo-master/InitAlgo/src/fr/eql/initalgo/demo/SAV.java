package fr.eql.initalgo.demo;

import java.text.DecimalFormat;

public class SAV {

	public static void main(String[] args) {
		int k;
		int i;

		i = 1;
		k = i++;
		//System.out.println("Avec i++ j vaut: " + k);

		i = 1;
		k = ++i;
		//System.out.println("Avec ++i j vaut: " + k);
		
		float pi = 3.14159261f;
		DecimalFormat df = new DecimalFormat("#.#####");
		System.out.println(df.format(pi));



	}

}
