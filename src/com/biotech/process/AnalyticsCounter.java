package com.biotech.process;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		boolean isOk = false;
		String path;
		List<String> symptoms = new ArrayList<>();

		while (!isOk) {
			try {
				System.out.println("Quel est le chemin du fichier ?");
				path = scan.nextLine();
				ReadSymptomDataFromFile readSymptoms = new ReadSymptomDataFromFile(path);
				System.out.println("Fichier trouvé");
				symptoms = readSymptoms.getSymptoms();
				System.out.println("Fichier valide");
				isOk = true;
			} catch (InputMismatchException | IOException e) {
				e.printStackTrace();
			}
		}

		HashSet<String> uniqueSymptoms = new HashSet<String>(symptoms);
//
		// next generate output
		try {
			FileWriter writer = new FileWriter ("result.out");
			for (String i : uniqueSymptoms) {
				writer.write(i + " : " + Collections.frequency(symptoms, i) + "\n");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
