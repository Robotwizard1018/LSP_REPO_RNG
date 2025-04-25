package org.howard.edu.lspfinal.question3;

/**
 * Driver class demonstrating the template method design pattern.
 */
public class Driver {
    public static void main(String[] args) {
        Report salesReport = new SalesReport();
        Report inventoryReport = new HrReport();

        // Demonstrate different report types.
        System.out.println("SALES:");
        salesReport.generateReport();
        
        System.out.println("\nHR:");
        inventoryReport.generateReport();
    }
}

