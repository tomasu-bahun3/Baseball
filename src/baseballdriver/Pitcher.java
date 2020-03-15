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
 * A class to represent the pitchers on a team.
 * You must
 * <ol>
 * <li> define private data members for the additional
 *    attributes that are specific to pitchers,
 *    essentially a few additional statistics </li>
 * <li>  define a public constructor to take values for all the
 *    inherited and local data members, which sets their
 *    data members' values to the parameter values</li>
 * <li>  define public getters for the count data members to be 
 *    used in calculating aggregate statistics for the the team's
 *    pitching</li>
 * <li> define a public toString method that produces a
 *    String in the format needed for the lookup method of
 *    Team </li>
 * </ol>
 *<pre>    n is a pitcher named name and has statistics
 *    PA: k  BB: m  SO: p  H: q  IP: r  ER: s  ERA: x  WHIP: y</pre>
 *    which is discussed in the program assignment. The first 4 items 
 *    come from the super class toString()
 * If you do extra credits, you may need to define more methods, but
 * all data members must be private, so only object instances can
 * directly access them.
 * 
 * @author dbriggs
 */
public class Pitcher extends Player{
    // class implementation goes here

    /**
     * an int for the pitcher's innings pitched
     */
    private int inningsPitched;
    
    /**
     * an int for the pitcher's earned runs
     */
    private int earnedRuns;
    
    /**
     * a double for the pitcher's earned runs avg
     */
    private double earnedRunsAvg; // calculated, not input
    
    /**
     * a double for the pitcher's whip
     */
    private double whip; // calculated, not input
    
    /**
     * Parameterized Constructor for the Pitcher class.
     * @param number the pitcher's number
     * @param name the pitcher's name (String)
     * @param position the pitcher's position as an int
     * @param throwsRightHanded the pitcher throws right handed or not
     * @param plateApp the pitcher's number of plate appearances
     * @param walks the pitcher's number of walks
     * @param strikeouts the pitcher's number of stikeouts
     * @param hits the pitcher's number of hits
     * @param inningsPitched the pitcher's number of innings pitched
     * @param earnedRuns the pitcher's number of earned runs
     */
    public Pitcher(int number, String name, int position, 
            boolean throwsRightHanded, int plateApp, int walks,
            int strikeouts, int hits, int inningsPitched, int earnedRuns) {
        super(number, name, position, throwsRightHanded, plateApp,
                walks, strikeouts, hits);
        this.inningsPitched = inningsPitched;
        this.earnedRuns = earnedRuns;
        
        // call calc methods
        calcERAvg();
        calcWhip();
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
     * calcERAvg to calculate the earned runs avg
     * Done by dividing the earned runs by the innings pitched, then
     * multiplying the result by 27 as innings pitched are counted in thirds
     */
    private void calcERAvg() {
        // because innings pitched counted in thirds
        final double MULTIPLIER = 27.0;
        if(inningsPitched > 0) {
            earnedRunsAvg = ((double)earnedRuns/(double)inningsPitched) 
                * MULTIPLIER;
        } else {
            earnedRunsAvg = -1.0;
        }
    }
    
    /**
     * calcwhip to calculate the pitcher's whip
     * Done by dividing the number of (hits + walks) by innings pitched, then
     * multiplying the result by 3 as innings pitched are counted in thirds
     */
    private void calcWhip() {
        // because innings pitched counted in thirds
        final double MULTIPLIER = 3.0;
        if(inningsPitched > 0) {
            whip = ((double)(walks + hits) / 
                (double)(inningsPitched)) * MULTIPLIER;
        } else {
            whip = -1.0;
        } 
    }
    
    /**
     * Accessor for the pitcher's number attribute
     * @return the pitcher's number
     */
    @Override
    public int getNumber() {
        return number;
    }
    
    /**
     * Accessor for the pitcher's name attribute
     * @return the pitcher's name
     */
    @Override
    public String getName() {
        return name;
    }
    
    /**
     * Accessor for the pitcher's position attribute
     * @return the pitcher's position
     */
    @Override
    public int getPosition() {
        return position;
    }
    
    /**
     * Accessor for the pitcher's throwsRightHanded attribute
     * @return the picther's throwsRightHanded
     */
    @Override
    public boolean getThrowsRightHanded() {
        return throwsRightHanded;
    }
    
    /**
     * Accessor for the pitcher's plateApp attribute
     * @return the pithcer's plateApp
     */
    @Override
    public int getPlateApp() {
        return plateApp;
    }
    
    /**
     * Accessor for the pitcher's walks attribute
     * @return the pitcher's walks
     */
    @Override
    public int getWalks() {
        return walks;
    }
    
    /**
     * Accessor for the pitcher's strikeouts attribute
     * @return the pitcher's strikeouts
     */
    @Override
    public int getStrikeouts() {
        return strikeouts;
    }
    
    /**
     * Accessor for the pitcher's hits attribute
     * @return the pitcher's hits
     */
    @Override
    public int getHits() {
        return hits;
    }
    
    /**
     * Accessor for the pitcher's position as a String
     * @return the pitcher's position as a String
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
     * Accessor for the pitcher's innings pitched
     * @return the pitcher's innings pitched
     */
    public int getInningsPitched() {
        return inningsPitched;
    }
    
    /**
     * Accessor for the pitcher's earned runs
     * @return the pitcher's earned runs
     */
    public int getEarnedRuns() {
        return earnedRuns;
    }
    
    /**
     * Accessor for the pitcher's earned runs avg
     * @return the pitcher's earned runs avg
     */
    public double getEarnedRunsAvg() {
        return earnedRunsAvg;
    }
    
    /**
     * Accessor for the pitcher's whip
     * @return the pitcher's whip
     */
    public double getWhip() {
        return whip;
    }
    
    /**
     * toString allows an object to be directly printed by returning a String
     * that can be printed to the console or to a file.  
     * @return a formatted string for the following:
     * PA: k BB: m SO: p H: q IP: r ER: s ERA: x WHIP: y
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator(); // do I need this?
        String convert;
        
        str.append("PA: ").append(this.plateApp).append(" ");
        str.append("BB: ").append(this.walks).append(" ");
        str.append("SO: ").append(this.strikeouts).append(" ");
        str.append("H: ").append(this.hits).append(" ");
        str.append("IP: ").append(this.inningsPitched).append(" ");
        str.append("ER: ").append(this.earnedRuns).append(" ");
        
        if(inningsPitched > 0) { // divisor not 0
            convert = String.format("%.3f", this.earnedRunsAvg);
            str.append("ERA: ").append(convert).append(" ");
            convert = String.format("%.2f", this.whip);
            str.append("WHIP: ").append(convert).append(eol);
        } else { // divisor 0
            str.append("ERA: n/a ");
            str.append("WHIP: n/a").append(eol);
        }
        
        return str.toString();
    }
    
    /**
     * Unit test for Pitcher.  There is no need to comment this out! 
     * Do NOT Change.  Leave it at the bottom of the file!
     * @param args command line args 
     */   
    public static void main (String[] args){
        Pitcher pitcher = new Pitcher(4, "Jim", 1 , 
            true, 12, 2, 3, 5, 12, 3);
        // test toString
        System.out.println(pitcher);
        // test accessors for Player class
        System.out.println(pitcher.getName() + " is a " 
                          + pitcher.getStrPosition());
        Player p = new Pitcher(65, "Jonathan", 1, true, 416, 23, 80, 
                111, 259, 32);
        System.out.println((Pitcher)p);
    }
    /* 
        Expeced output from a unit test run:
        PA: 12 BB: 2 SO: 3 H: 5 IP: 12 ER: 3 ERA: 6.750 WHIP: 1.75
    */
}