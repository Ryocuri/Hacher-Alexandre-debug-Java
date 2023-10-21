package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException {

		FileWriter writer = new FileWriter ("result2.out");
		for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
			writer.write(entry.getKey() + " " + entry.getValue() + "\n");
		}
		writer.close();
	}
}
