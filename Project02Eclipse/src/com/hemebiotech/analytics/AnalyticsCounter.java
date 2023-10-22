package com.hemebiotech.analytics;

import java.util.*;

public class AnalyticsCounter {
	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructor
	 * @param reader
	 * @param writer
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/**
	 * Get symptoms from file
	 * @return symptoms
	 */
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	/**
	 * Count symptoms
	 * @param symptoms
	 * @return symptoms with their count
	 */
	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomCounts = new HashMap<>();

		for (String symptom : symptoms) {
			if (!symptomCounts.containsKey(symptom)) {
				symptomCounts.put(symptom, 1);
			}
			else {
				symptomCounts.put(symptom, symptomCounts.get(symptom) + 1);
			}
		}

		return symptomCounts;
	}

	/**
	 * Sort symptoms by alphabetical order
	 * @param symptoms
	 * @return sorted symptoms
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		// sort symptoms by alphabetical order

		// Convertissez la map en une liste d'entrées (paires clé-valeur)
		List<Map.Entry<String, Integer>> list = new ArrayList<>(symptoms.entrySet());

		// Triez la liste en fonction des clés (ordre alphabétique)
		list.sort(Map.Entry.comparingByKey());


		// Créez une nouvelle Map triée
		Map<String, Integer> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		return sortedMap;
	}

	/**
	 * Write symptoms in a file
	 * @param symptoms
	 * @throws Exception
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) throws Exception {
		writer.writeSymptoms(symptoms);
	}

	/**
	 * Main
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {

		AnalyticsCounter analyticsCounter = new AnalyticsCounter(new ReadSymptomDataFromFile((System.getProperty("user.dir") + "/Project02Eclipse/symptoms.txt")), new WriteSymptomDataToFile());
		List<String> symptoms = analyticsCounter.getSymptoms();
		Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);
		Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);
		analyticsCounter.writeSymptoms(sortedSymptoms);
	}
}
