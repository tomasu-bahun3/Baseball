/***********************************************************************
 * REVISION HISTORY (Newest First)
 ***********************************************************************
 * 10/22/19 - Finished class - Thomas Bahun
 * 10/22/19 - Started project - Thomas Bahun
 * 08/04/2016 - Anne Applin - formatting only
 * 2014 - David Briggs - original starting code and comments
 ***********************************************************************/ 
package baseballdriver;
/**
 * The super class for the Pitcher and PositionPlayer classes that unifies 
 * them.
 * It implements the Comparable interface so that a Team's players can be sort
 * by number. 
 * You must
 * <ol>
 * <li> define data members for the common data(always make data members  for a 
 *     super class protected)</li>
 * <li> define a constructor that initializes all data members</li>
 * <li> define getters for the data members that you need to produce the program
 *    output</li>
 * <li> a public toString method that returns a String in the format:<br>
 *    <pre>PA: k BB: m SO: p H: q</pre><br>
 *    where k, m, p, and q are the values for plate appearances, walks, 
 *    strike-outs, and hits.</li>
 * <li> IF YOU DO THE FIRST EXTRA CREDIT
 *    define protected methods for the updateable data members(that is, 
 *    for counts that can change; you can assume no players are traded, so 
 *    name and number and position, and throwsRightHanded will not change)
 *    the update methods should ADD to the existing values.</li>
 * </ol>
 * All constructors and methods should be declared protected(or private, if 
 * they are auxiliary).
 * @author dbriggs
 */
public abstract class Player implements Comparable<Player>{
    // class properties should be protected

    /**
     * an int for the player's number
     */
    protected int number;
    
    /**
     * a String for the player's name
     */
    protected String name;
    
    /**
     * an int for the player's position
     */
    protected int position;
    
    /**
     * a boolean for whether the player throws right handed or not
     */
    protected boolean throwsRightHanded;
    
    /**
     * an int for the player's number number of plate appearances
     */
    protected int plateApp; // used for update()
    
    /**
     * an int for the player's number number of walks
     */
    protected int walks; // used for update()
    
    /**
     * an int for the player's number number of strikeouts
     */
    protected int strikeouts; // used for update()
    
    /**
     * an int for the player's number of hits
     */
    protected int hits; // used for update()
    
    // class method implementation goes here   
    
    /**
     * Parameterized Constructor for the Player class.
     * @param number the player's number
     * @param name the player's name 
     * @param position the player's position as an int 
     * @param throwsRightHanded the player throws right handed or not
     * @param plateApp the player's number of plate appearances
     * @param walks the player's number of walks
     * @param strikeouts the player's number of stikeouts
     * @param hits the player's number of hits
     */
    protected Player(int number, String name, int position, 
            boolean throwsRightHanded, int plateApp, 
            int walks, int strikeouts, int hits) {
        this.number = number;
        this.name = name;
        this.position = position;
        this.throwsRightHanded = throwsRightHanded;
        this.plateApp = plateApp;
        this.walks = walks;
        this.strikeouts = strikeouts;
        this.hits = hits;
    }
    
    /**
     * Mutator for the plateApp attribute, only used for update
     * @param plateApp the num of plate appearances 
     */
    protected abstract void setPlateApp(int plateApp);
    
    /**
     * Mutator for the plateApp attribute, only used for update
     * @param walks the num of walks
     */
    protected abstract void setWalks(int walks);
    
    /**
     * Mutator for the plateApp attribute, only used for update
     * @param strikeouts the num of strikeouts
     */
    protected abstract void setStrikeouts(int strikeouts);
    
    /**
     * Mutator for the plateApp attribute, only used for update
     * @param hits the num of hits
     */
    protected abstract void setHits(int hits);
    
    /**
     * Accessor for the player's number attribute
     * @return the player's number
     */
    protected abstract int getNumber();
    
    /**
     * Accessor for the player's name attribute
     * @return the player's name
     */
    protected abstract String getName();
    
    /**
     * Accessor for the player's position attribute
     * @return the players position
     */
    protected abstract int getPosition();
    
    /**
     * Accessor for the player's throwsRightHanded attribute
     * @return the player's throwsRightHanded
     */
    protected abstract boolean getThrowsRightHanded();
    
    /**
     * Accessor for the player's plateApp attribute
     * @return the players plateApp
     */
    protected abstract int getPlateApp();
    
    /**
     * Accessor for the player's walks attribute
     * @return the player's walks
     */
    protected abstract int getWalks();
    
    /**
     * Accessor for the player's strikeouts attribute
     * @return the player's strikeouts
     */
    protected abstract int getStrikeouts();
    
    /**
     * Accessor for the player's hits attribute
     * @return the player's hits
     */
    protected abstract int getHits();
    
    /**
     * Accessor for the player's position as a String
     * @return the pitcher's position as a String
     */
    protected abstract String getStrPosition();
    
    /**
     * toString allows an object to be directly printed by returning a String
     * that can be printed to the console or to a file.  
     * @return a formatted string for PA: k BB: m SO: p H: q
     */
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator(); // do I need this?
        
        str.append("PA: " + this.plateApp + " ");
        str.append("BB: " + this.walks + " ");
        str.append("SO: " + this.strikeouts + " ");
        str.append("H: " + this.hits).append(eol);
        
        return str.toString();
    }

    /**
     * compares two Players by number.  Do not change!
     * @param that a Player object
     * @return an integer value < 0 , 0, or > 0
     */
    @Override
    public int compareTo(Player that){
        return this.number - that.number;
    }
    
}
