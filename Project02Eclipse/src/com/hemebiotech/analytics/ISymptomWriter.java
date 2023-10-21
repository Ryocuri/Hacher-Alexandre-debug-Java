package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {

	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
