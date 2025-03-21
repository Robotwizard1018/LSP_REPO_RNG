package org.howard.edu.lsp.midterm.question5;
/**
 * Music class to represent music and it's functions.
 */
public class Music implements Streamable {
    private String title;
    
    /**
     * Constructor for music class
     * @param title
     */
    public Music(String title) {
        this.title = title;
    }
    
    /**
     * 
     */
    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }
    
    /**
     * 
     */
    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }
    
    /**
     * 
     */
    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }

    /**
     * 
     * @param playlistName
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist");
    }
}
