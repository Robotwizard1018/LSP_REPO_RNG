package org.howard.edu.lsp.assignment2;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Initialize pipeline.
		Pipeline pipeline = new Pipeline();
		
		// Establish connection and extract rows from CSV file.
		List<Pipeline.CsvRow> data = pipeline.extract("data/products.csv");
		
		// Perform transformations.
		List<Pipeline.CsvRow> newRows = pipeline.transform(data);
		
		// Save results to new CSV file.
		pipeline.load(newRows, "data/transformed_products.csv");

	}

}
