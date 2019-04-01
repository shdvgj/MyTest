package com.hlq.test_002;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Start {
	public static void main(String[] args) throws IOException {
		CSVReader reader = new CSVReader(new FileReader("data.csv"));
		FileWriter writer = new FileWriter("out.csv");

		List<String[]> myEntries = reader.readAll();
		List<Punto> puntos = new ArrayList<Punto>();

		for (String[] strings : myEntries) {
			Punto p = new Punto(strings);
			puntos.add(p);
		}

		KMeans kmeans = new KMeans();
		KMeansResultado resultado = kmeans.calcular(puntos, 20);
		writer.write("------- Con k=" + 20 + " ofv=" + resultado.getOfv() + "-------\n");
		int i = 0;
		for (Cluster cluster : resultado.getClusters()) {
			i++;
			writer.write("-- Cluster " + i + " --\n");
			for (Punto punto : cluster.getPuntos()) {
				writer.write(punto.toString() + "\n");
			}
			writer.write("\n");
			writer.write(cluster.getCentroide().toString());
			writer.write("\n\n");
		}
		writer.close();
	}
}