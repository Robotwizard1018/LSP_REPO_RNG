package org.howard.edu.lspfinal.question3; 

/**
 * Concrete implementation of the Report abstract class. Simulates data retrieval and uniqueness by printing messages to the console.
 */
public class HrReport extends Report {
	
	
	/**
     * Loads human resources data.
     * 
     */
    @Override
    void loadData() {
        System.out.println("Loading human resources data...");
        System.out.println("Human resources data loaded.");
    }

    /**
     * Formats human resources data.
     * 
     */
    @Override
    void formatData() {
        System.out.println("Formatting human resources data...");
        System.out.println("Human resources data formatted");
    }

    /**
     * Prints the final HR report.
     * 
     */
    @Override
    void printReport() {
        System.out.println("Printing final HR report...");
        System.out.println("Final HR report ====1=1=1=1=====");
    }

}
