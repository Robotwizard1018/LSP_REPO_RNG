
package org.howard.edu.lsp.assignment2;

import java.util.*;
import java.io.*;


public class Pipeline {
	
	class CsvRow {
		
		private String productID;
		private String name;
		private double price;
		private String category;
		private String priceRange;
		
		CsvRow(String productId, String name, String price, String category){
			this.productID = productId;
			this.name = name;
			this.price = Double.parseDouble(price);
			this.category = category;
			this.setPriceRange(this.price);
		}
		
		// Getters 
		public String getProductID() { return productID; }
		public String getName() { return name; }
		public double getPrice() { return price; }
		public String getCategory() { return category; }
		public String getPriceRange() { return priceRange; }
		
		
		// Setters
		public void setName(String name) {
		    this.name = name;
		}

		public void setPrice(double price) {
		    this.price = price;
		}

		public void setCategory(String category) {
		    this.category = category;
		}
		
		public void applyElectronicDiscount(double discountPercentage) {
		    this.price = Math.round((price * (1 - discountPercentage / 100.0)) * 100.0) / 100.0;
		}
			
	
		public void setPriceRange(double price) {
		    if (price < 0) {
		        throw new IllegalArgumentException("Price cannot be negative");
		    }

		    if (price <= 10) {
		        this.priceRange = "Low";
		    } else if (price <= 100) {
		        this.priceRange = "Medium";
		    } else if (price <= 500) {
		        this.priceRange = "High";
		    } else {
		        this.priceRange = "Premium";
		    }
		}
	}
	
	
	
	public List<Pipeline.CsvRow> extract(String filePath) {
		List<Pipeline.CsvRow> csvRows = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				String line;
				String[] vals;
				reader.readLine();
				
				while ((line = reader.readLine()) != null) {
					if (!line.isEmpty()) {
						vals = line.split(",");
						if (vals.length >= 4) {
							CsvRow newRow = new CsvRow(vals[0], vals[1], vals[2], vals[3]); 
							csvRows.add(newRow);
						}
					}
				}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return csvRows;
	}

	
	public List<Pipeline.CsvRow> transform(List<Pipeline.CsvRow> csvRows){
		// Apply transformations 
		for (CsvRow row: csvRows) {
			row.setName(row.getName().toUpperCase());
			if (row.getCategory().equals("Electronics")) {
				row.applyElectronicDiscount(10);
				if (row.getPrice() > 500) {
				row.setCategory("Premium Electronics");
				}
				
			}
			row.setPriceRange(row.getPrice());
		} 
		
		return csvRows;
	}
	
	public void load(List<Pipeline.CsvRow> updatedRows, String destinationPath) {
		File file = new File(destinationPath);
	    file.getParentFile().mkdirs();
	    System.out.println("Saving transformed file to: " + file.getAbsolutePath());

		
		// Write each row to a new file called transformed_products.csv
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(destinationPath))) {
			String rowString;
			String header = "ProductID,Name,Price,Category,PriceRange";
			bw.write(header);
			bw.newLine();
			for (CsvRow row: updatedRows) {
				rowString = String.join(",", row.getProductID(), row.getName(), String.valueOf(row.getPrice()), row.getCategory(), row.getPriceRange());
				System.out.println("Saving Row: " + rowString);
				bw.write(rowString);
				bw.newLine();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
