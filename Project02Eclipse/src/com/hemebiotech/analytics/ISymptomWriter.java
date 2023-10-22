package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.Map;

public interface ISymptomWriter {

	/**
	 *
	 * @param symptoms
	 * @throws IOException
	 */
	public void writeSymptoms(Map<String, Integer> symptoms) throws IOException;
}
