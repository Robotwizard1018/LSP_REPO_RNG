package org.howard.edu.lsp.midterm.question5;
/**
 * Movie class to represent a movie and it's functions.
 */
public class Movie implements Streamable {
    private String title;
    /**
     * Constructor for the Movie class
     * 
     * @param title
     */
    public Movie(String title) {
        this.title = title;
    }
    
    /**
     * Plays the movie and prints the title
     */
    @Override
    public void play() {
        System.out.println("Playing movie: " + title);
    }
    
    /**
     * Pauses the movie and prints the title
     */
    @Override
    public void pause() {
        System.out.println("Paused movie: " + title);
    }
    
    /**
     * Stops the movie and prints the title
     */
    @Override
    public void stop() {
        System.out.println("Stopped movie: " + title);
    }

    /**
     * Prints how much a movie is rewinded by
     * 
     * @param seconds
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " seconds");
    }
}
