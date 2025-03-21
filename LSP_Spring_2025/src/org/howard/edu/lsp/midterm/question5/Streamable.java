package org.howard.edu.lsp.midterm.question5;
/**
 * Streamable interface used to define shared behavior between different streaming services.
 */
public interface Streamable {
	/**
	 * Plays whichever media type is specified by printing a string
	 */
	void play();
	
	/**
	 * Pauses whichever media type is specified by printing a string
	 */
	void pause();
	
	/**
	 * Stops whichever media type is specified by printing a string
	 */
	void stop();

}
