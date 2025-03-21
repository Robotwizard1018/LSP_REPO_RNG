package org.howard.edu.lsp.midterm.question5;
/**
 * Audiobook class to represent an audio book and its functions.
 */
public class Audiobook implements Streamable {
    private String title;
    /**
     * Constructor for an Audiobook. 
     * 
     * @param title
     */
    public Audiobook(String title) {
        this.title = title;
    }
    
    /**
     * 
     */
    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }
    
    /**
     * Pauses the Audiobook and prints the title
     */
    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }
    
    /**
     * 
     */
    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    /**
     * Prints the play back speed of the specified audiobook.
     * 
     * @param speed 
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}
