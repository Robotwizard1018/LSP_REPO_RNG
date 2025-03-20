package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * VotingMachine class for managing and storing votes for candidates.
 */
public class VotingMachine {

    private Map<String, Integer> votes;

    // Constructor
    public VotingMachine() {
        votes = new HashMap<>();
    }

    /*
     * Adds a candidate to the voting machine
     * @param name of the voting candidate
     */
    public void addCandidate(String name) {
        if (!votes.containsKey(name)) {
            votes.put(name, 0);
        }
    }

    /**
     * Casts a vote for a given candidate
     * @param name
     * @return if the vote is successful or not
     */
    public boolean castVote(String name) {
        if (!votes.containsKey(name)) {
            return false; 
        }
        votes.put(name, votes.get(name) + 1);
        return true;
    }

    
    /**
     * Gets the winner with the most votes
     * @return the winner
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner +"wins with " + maxVotes + " votes!";
    }

}