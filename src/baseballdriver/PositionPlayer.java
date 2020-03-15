/***********************************************************************
 * REVISION HISTORY (Newest First)
 *********************************************************************** 
 * 10/22/19 - Finished the class - Thomas Bahun
 * 10/22/19 - Started work on the class - Thomas Bahun
 * 08/04/2016 - Anne Applin - formatting and JavaDoc
 * 2014 - David Briggs - original starting code and comments
 ***********************************************************************/ 

package baseballdriver;

/**
 * A class to represent non-pitcher position players.
 * You must
 * <ol>
 * <li> define private data members for the additional
 *    attributes that are specific to non-Pitcher players,
 *    essentially additional hitting statistics</li>
 * <li> define a public constructor to take values for all the
 *    inherited and local data members, which sets their
 *    data members' values to the parameter values</li>
 * <li> define public getters for the data members to be 
 *    used in calculating aggregate statistics for the the team's hitting
 *    stats</li>
 * <li> define a public toString method that produces a
 *    String in the format needed for the lookup method of  
 *    Team <br>
 *    <pre>n is a position named name and has statistics
 *    PA: k  BB: m  SO: p  H: q  AB: r  BI: s  HR: t HBP: u BA: x  OBP: y </pre>
 *    which is discussed in the program assignment. The first 4 items 
 *    come from the super class toString()</li>
 * </ol>
 *    If you do extra credits, you may need to define more methods, but
 *    all data members must be private, so only object instances can
 *    directly access them.
 * @author dbriggs
 */
public class PositionPlayer extends Player{
    // class implementation goes here
    
    /**
     * an int for the position player's times at bat
     */
    private int atBats;
    
    /**
     * an int for the position player's times batted in
     */
    private int runsBattedIn;
    
    /**
     * an int for the position player's home runs
     */
    private int homeRuns;
    
    /**
     * an int for the position player's times hit by pitch
     */
    private int hitByPitch;
    
    /**
     * a double for the position player's batting avg
     */
    private double battingAvg; // calculated, not input
    
    /**
     * a double for the position player's on base percentage
     */
    private double onBasePerc; // calculated, not input
    
    /**
     * Parameterized Constructor for the PositionPlayer class.
     * @param number the position player's number 
     * @param name the position player's name 
     * @param position the position player's position as an int 
     * @param throwsRightHanded the position player throws right handed or not
     * @param plateApp the position player's number of plate appearances
     * @param walks the position player's number of walks
     * @param strikeouts the position player's number of stikeouts
     * @param hits the position player's number of hits
     * @param atBats the position player's number of times at bat
     * @param runsBattedIn the position player's number of times batted in
     * @param homeRuns the position player's number of home runs
     * @param hitByPitch the position player's number of times hit by pitch
     */
    public PositionPlayer(int number, String name, int position, 
            boolean throwsRightHanded, int plateApp, 
            int walks, int strikeouts, int hits, int atBats,
            int runsBattedIn, int homeRuns, int hitByPitch) {
        super(number, name, position, throwsRightHanded, plateApp,
                walks, strikeouts, hits);
        this.atBats = atBats;
        this.runsBattedIn = runsBattedIn;
        this.homeRuns = homeRuns;
        this.hitByPitch = hitByPitch;
        
        // call calc methods
        calcBattingAvg();
        calcOnBasePerc();
    }
    
    /**
     * Mutator for the plateApp attribute, only used for update
     * @param plateApp the num of plate appearances
     */
    @Override
    public void setPlateApp(int plateApp) {
        this.plateApp = plateApp;
    }
    
    /**
     * Mutator for the walks attribute, only used for update
     * @param walks the num of walks
     */
    @Override
    public void setWalks(int walks) {
        this.walks = walks;
    }
    
    /**
     * Mutator for the strikeouts attribute, only used for update
     * @param strikeouts the num of strikeouts
     */
    @Override
    public void setStrikeouts(int strikeouts) {
        this.strikeouts = strikeouts;
    }
    
    /**
     * Mutator for the hits attribute, only used for update
     * @param hits the num of hits
     */
    @Override
    public void setHits(int hits) {
        this.hits = hits;
    }
    
    /**
     * calcBattingAvg to calculate the position player's batting avg
     */
    private void calcBattingAvg() {
        if(atBats > 0) {
            battingAvg = (double)hits/(double)atBats;
        } else {
            battingAvg = -1;
        }
    }
    
    /**
     * calcOnBasePerc to calculate the position player's on base percentage
     */
    private void calcOnBasePerc() {
        if(plateApp > 0) {
            onBasePerc = 
                    (double)(hits + walks + hitByPitch)/(double)(plateApp);
        } else {
            onBasePerc = -1;
        }
    }
    
    /**
     * Accessor for the position player's number attribute
     * @return the position player's number
     */
    @Override
    public int getNumber() {
        return number;
    }
    
    /**
     * Accessor for the position player's name attribute
     * @return the position player's name
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Accessor for the position player's position attribute
     * @return the position player's position
     */
    @Override
    public int getPosition() {
        return position;
    }
    
    /**
     * Accessor for the position player's throwsRightHanded attribute
     * @return the position player's throwsRightHanded
     */
    @Override
    public boolean getThrowsRightHanded() {
        return throwsRightHanded;
    }
    
    /**
     * Accessor for the position player's plateApp attribute
     * @return the position player's plateApp
     */
    @Override
    public int getPlateApp() {
        return plateApp;
    }
    
    /**
     * Accessor for the position player's walks attribute
     * @return the position player's walks
     */
    @Override
    public int getWalks() {
        return walks;
    }
    
    /**
     * Accessor for the position players's strikeouts attribute
     * @return the position players's strikeouts
     */
    @Override
    public int getStrikeouts() {
        return strikeouts;
    }
    
    /**
     * Accessor for the position players's hits attribute
     * @return the position players's hits
     */
    @Override
    public int getHits() {
        return hits;
    }
    
    /**
     * Accessor for the position position player's position as a String
     * @return the position position player's position as a String
     */
    @Override
    public String getStrPosition() {
        String pos = "";
        switch(position) {
            case 1: pos = "pitcher"; break;
            case 2: pos = "catcher"; break;
            case 3: pos = "first baseman"; break;
            case 4: pos = "second baseman"; break;
            case 5: pos = "third baseman"; break;
            case 6: pos = "shortstop"; break;
            case 7: pos = "left fielder"; break;
            case 8: pos = "center fielder"; break;
            case 9: pos = "right fielder"; break;
        }
        return pos;
    }

    /**
     * Accessor for the position player's atBats
     * @return the position player's times at bat
     */
    public int getAtBats() {
        return atBats;
    }

    /**
     * Accessor for the position player's runsBattedIn
     * @return the position player's runs batted in
     */
    public int getRunsBattedIn() {
        return runsBattedIn;
    }

    /**
     * Accessor for the position player's homeRuns
     * @return the position player's number of home runs
     */
    public int getHomeRuns() {
        return homeRuns;
    }

    /**
     * Accessor for the position player's hitByPitch
     * @return the position player's times hit by pitch
     */
    public int getHitByPitch() {
        return hitByPitch;
    }

    /**
     * Accessor for the position player's batting avg
     * @return the position player's batting avg
     */
    public double getBattingAvg() {
        return battingAvg;
    }

    /**
     * Accessor for the position player's onBasePerc
     * @return the position player's on base percentage
     */
    public double getOnBasePerc() {
        return onBasePerc;
    }
    
    /**
     * toString allows an object to be directly printed by returning a String
     * that can be printed to the console or to a file.  
     * @return a formatted string for the following:
     * PA: k BB: m SO: p H: q AB: r BI: s HR: t HBP: u BA: x OBP: y
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator(); // do I need this?
        String convertBA, convertOBP;
        
        str.append("PA: ").append(this.plateApp).append(" ");
        str.append("BB: ").append(this.walks).append(" ");
        str.append("SO: ").append(this.strikeouts).append(" ");
        str.append("H: ").append(this.hits).append(" ");
        str.append("AB: ").append(this.atBats).append(" ");
        str.append("BI: ").append(this.runsBattedIn).append(" ");
        str.append("HR: ").append(this.homeRuns).append(" ");
        str.append("HBP: ").append(this.hitByPitch).append(" ");
        
        if(atBats > 0) { // divisor not 0
           convertBA = String.format("%.3f", this.battingAvg);
           str.append("BA: ").append(convertBA).append(" ");
        } else { // divisor 0
           str.append("BA: n/a ");
        }
        
        if(plateApp > 0) { // divisor not 0
            convertOBP = String.format("%.3f", this.onBasePerc);
            str.append("OBP: ").append(convertOBP).append(eol); 
        } else { // divisor 0
            str.append("OBP: n/a").append(eol); 
        }
        
        return str.toString();
    }
    
    /**
     * Unit test for PositionPlayer - creates a PositionPlayer by calling 
     * the constructor and then prints it out. There is no need to comment 
     * this out!  
     * * Do NOT Change.  Leave it at the bottom of the file!
     * @param args command line args 
     */
    public static void main (String[] args){
        Player posPlayer = new PositionPlayer(12, "Bob", 7 , 
            true, 12, 2, 3, 5, 12, 3, 4, 0);
        // test toString
        System.out.println((PositionPlayer)posPlayer);
        // test accessors for Player class
        System.out.println(posPlayer.getName() + " is a " 
                           + posPlayer.getStrPosition());
        Player p = new PositionPlayer(26, "Brock", 4,  true, 1443, 33, 83, 
                422, 454, 274, 50, 2);
        System.out.println((PositionPlayer)p);
    }
    /* 
        Expeced output from a unit test run:
        PA: 12 BB: 2 SO: 3 H: 5 AB: 12 BI: 3 HR: 4 HBP: 0 BA: 0.42 OBP: 0.58
    */
}