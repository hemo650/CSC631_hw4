/*
NEW GAME CLASS 
CREATED FOR HW4 
This class is modified from the original WOB
to showcase understanding of WOB code.
Incorporated WoB files for testing was given aid for this portion
May not be used in Infection added by Tony
 */
package model;

import java.util.ArrayList;

public class Game {
    private ArrayList<String> players;
    private float time;
    private boolean  gameWin;

    public ArrayList<String> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<String> players) {
        this.players = players;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public boolean is gameWin() {
        return  gameWin;
    }

    public void set gameWin(boolean  gameWin) {
        this. gameWin =  gameWin;
    }
}