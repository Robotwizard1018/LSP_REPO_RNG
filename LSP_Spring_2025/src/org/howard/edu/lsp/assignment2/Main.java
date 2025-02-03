package org.howard.edu.lsp.assignment2;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Read in file
		Pipeline pipeline = new Pipeline();
		
		// Store in some data type/format
		List<Pipeline.CsvRow> data = pipeline.extract("data/products.csv");
		
		// Perform transformations
		List<Pipeline.CsvRow> newRows = pipeline.transform(data);
		
		// Save results to new file
		pipeline.load(newRows, "data/transformed_products.csv");

	}

}
