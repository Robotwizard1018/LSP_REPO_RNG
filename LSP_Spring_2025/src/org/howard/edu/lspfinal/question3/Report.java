package org.howard.edu.lspfinal.question3;


// Reference: https://www.geeksforgeeks.org/template-method-design-pattern/

/**
 * Abstract class defining the template for a report.
 */
public abstract class Report {
	
	
	public final void generateReport() {
		// Template Method.
		loadData();
		formatData();
		printReport();
	}
	
	abstract void loadData();
	abstract void formatData();
	abstract void printReport();

}
