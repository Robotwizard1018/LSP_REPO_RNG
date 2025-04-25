package org.howard.edu.lspfinal.question3; 

/**
 *  Concrete implementation of the Report abstract class. Simulates data retrieval and uniqueness by printing messages to the console.
 */
public class SalesReport extends Report {
	
	 /**
     * Loads sales data.
     * 
     */
    @Override
    void loadData() {
        System.out.println("Loading sales data...");
        System.out.println("Sales data loaded.");
    }

    /**
     * Formats sales data.
     *
     */
    @Override
    void formatData() {
        System.out.println("Formatting sales data...");
        System.out.println("Sales data formatted!");
    }

    /**
     * Prints the final sales report.
     * 
     */
    @Override
    void printReport() {
        System.out.println("Printing final sales report...");
        System.out.println("Heres your sales data!! -<<<><><><>");
    }

}
