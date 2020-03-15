/***********************************************************************
 * REVISION HISTORY (Newest First)
 *********************************************************************** 
 * 10/23/19 - Finished class - Thomas Bahun
 * 10/23/19 - Received help from prof on class - Thomas Bahun
 * 10/22/19 - Started work on Team class - Thomas Bahun
 * 08/04/2016 - Anne Applin - formatting and JavaDoc
 * 2014 - David Briggs - original starting code and comments
 ***********************************************************************/ 

package baseballdriver;

import java.util.TreeMap;

/**
 * A class to represent a team and its roster.  It needs data members
 * for the name of the team, which will be String w/o embedded blanks,
 * for example, RedSox, BlueJay, Yankees, and WhiteSox, and a Java
 * Collection class for the players on the team.
 * <br>
 * You must use a Map member for the
 * players.  You can set up the Map to lookup players by number,
 * which is more efficient than iterating over a list of players.
 * <br>
 * You must define
 * <ol>
 * <li> a public constructor that takes a name and a map of
 * Player objects(which will be invoked by the League class constructor).
 * <code>public Team(String tname, TreeMap<Integer, Player> roster)</code>
 *   and creates an instance for that team
 * 
 * <li> a public method
 *   <code>String  lookupPlayer(int n)</code>
 * 
 * that returns the appropriate one of the follow two results
 * (assuming t is the name of this team)
 * <br>
 * No player with number n is on the roster for the t.<br> 
 * or<br>
 * <pre><stats for that player></pre>
 * <br>
 * The format of the latter is given in the program assignment and
 * is based on whether the player is a pitcher or a position player.
 * You should write the toString method for Pitcher and PositionPlayer
 * to return the appropriate portion of that result.  Dynamic dispatch
 * will take care of the rest.</li>
 * 
 * <li> a public method
 * <code>String calcPitchingStats()</code>
 * <br>
 * that returns the appropriate choice from the following two
 * results(assuming t is the name of the team)
 * <ol>
 * <li>The t appear to have no pitchers at this time.</li>
 * <li> <code><aggregated pitching stats for t></code></li>
 * </ol>
 * where the format of the latter is discussed in the program assignment.</li>
 * 
 * <li> code a public method
 * String calcHittingStats()
 * 
 * that returns the appropriate choice from the following two
 * results(assuming t is the name of the team)
 * <ol>
 * <li>The t appear to have no hitters at this time.</li>
 * 
 * <li><code><aggregated hitting  stats for t><code><li>
 * </ol>
 * where the format of the latter is discussed in the program assignment.</ol>
 * If you do the extra credits, you will need to define additional methods.
 * Note, all data members should be private, so only the Team object instance 
 * can directly access them.
 * @author dbriggs
 */
public class Team{
    // class implementation goes here

    /**
     * a String for the name of the team
     */
    private String name;
    
    /**
     * an int for the number of pitchers on the team
     */
    private int numPitchers; // calculated
    
    /**
     * an int for the number of position players on the team
     */
    private int numPosPlayers; // calculated
    
    /**
     * a TreeMap holding all the team's players
     */
    private TreeMap<Integer, Player> players = new TreeMap<>();
    
    /**
     * Parameterized Constructor for the Pitcher class.
     * @param name the team's name
     * @param players the team's roster
     */
    public Team(String name, TreeMap players) {
        this.name = name;
        this.players = players;
        
        // call calc method
        calcStats();
    }
    
    /**
     * lookup to look up a specific player on the team by their position num
     * @param number the num representing the player's position
     * @return the name of the player in question
     */
    public String lookupPlayer(int number) {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator();
        
        if (players.containsKey(number)) {
            str.append("The ").append(name);
            str.append(" player number ").append(number);
            str.append(" is a ").append(players.get(number).getStrPosition());
            str.append(" named ").append(players.get(number).getName());
            str.append(" and has statistics :").append(eol);
            str.append(players.get(number).toString());
        } else {
            str.append("No player with number ").append(number);
            str.append(" is on the roster for the ").append(name);
        }

        return str.toString();
    }
    
    /**
     * calcStats method to calculate the stats for the pitchers and
     * the hitters for the team.
     * Done by creating dummy players for the pitching and hitting stats
     * Puts the dummy players into the team to use to retrieve the stats
     * 
     */
    public void calcStats() {
        // declare local vars for pitchers and posPlayers
        int pitcherPA = 0,
            pitcherWalks = 0,
            pitcherSrikeouts = 0,
            pitcherHits = 0,
            inningsPitched = 0,
            earnedRuns = 0,
            posPlayerPA = 0,    
            posPlayerWalks = 0,
            posPlayerSrikeouts = 0,
            posPlayerHits = 0,
            atBats = 0,
            runsBattedIn = 0,
            homeRuns = 0,
            hitByPitch = 0;
        
        // declare pitcher and posPlayer
        Pitcher pitcher; // declare not create
        PositionPlayer posPlayer; // declare not create
        
        // loop through players
        for (Integer playerNum: players.keySet()) {
            // if a player is a pitcher
            if (players.get(playerNum) instanceof Pitcher) {
                numPitchers++; // increase total num pitchers
                pitcher = (Pitcher)players.get(playerNum);
                pitcherPA += pitcher.getPlateApp();
                pitcherWalks += pitcher.getWalks();
                pitcherSrikeouts += pitcher.getStrikeouts();
                pitcherHits += pitcher.getHits();
                inningsPitched += pitcher.getInningsPitched();
                earnedRuns += pitcher.getEarnedRuns();
            } else { // else a player is a pos player
                posPlayer = (PositionPlayer)players.get(playerNum);
                numPosPlayers++; // increase total num pos players
                posPlayerPA += posPlayer.getPlateApp();
                posPlayerWalks += posPlayer.getWalks();
                posPlayerSrikeouts += posPlayer.getStrikeouts();
                posPlayerHits += posPlayer.getHits();
                atBats += posPlayer.getAtBats();
                runsBattedIn += posPlayer.getRunsBattedIn();
                homeRuns += posPlayer.getHomeRuns();
                hitByPitch += posPlayer.getHitByPitch();
            }
        }
        // new dummy pitcher
        pitcher = new Pitcher(0, "dummyPitcher", 1, true, pitcherPA, 
                pitcherWalks, pitcherSrikeouts, pitcherHits, 
                inningsPitched, earnedRuns);
        players.put(0, pitcher);
        
        // new dummy pos player
        posPlayer = new PositionPlayer(-1, "dummyPosPlayer", 1, true, 
                posPlayerPA, posPlayerWalks, posPlayerSrikeouts, 
                posPlayerHits, atBats, runsBattedIn, homeRuns, hitByPitch);
        players.put(-1, posPlayer);
    }
    
    /**
     * calcPitchingStats to calculate the pitching stats for the team
     * @return the pitching stats for the team's players
     */
    public String calcPitchingStats() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator();
        
        if (numPitchers > 0) {
            str.append("There are ").append(numPitchers);
            str.append(" pitchers on the "). append(name);
            str.append(" and their aggregated statistics are ").append(eol);
            str.append(players.get(0).toString());
        } else {
            str.append("There are no pitchers on the ").append(name);
        }
        return str.toString();
    }
    
    /**
     * calcHittingStats to calculate the hitting stats for the team
     * @return the hitting stats for the team's players 
     */
    public String calcHittingStats() {
        StringBuilder str = new StringBuilder();
        String eol = System.lineSeparator();
        
        if (numPosPlayers > 0) {
            str.append("There are ").append(numPosPlayers);
            str.append(" hitters on the "). append(name);
            str.append(" and their aggregated statistics are ").append(eol);
            str.append(players.get(-1).toString());
        } else {
            str.append("There are no hitters on the ").append(name);
        }
        return str.toString();
    }

    /**
     * Accessor for the name field of the team
     * @return the String name of the team
     */
    public String getName() {
        return name;
    }
    
    /**
     * Unit test for Team - Creates a map with two players and 
     * calls the Team Constructor There is no need to comment 
     * this out!  
     * * Do NOT Change.  Leave it at the bottom of the file!
     * @param args command line args 
     */     
    public static void main (String[] args){
        TreeMap<Integer, Player> players = new TreeMap<>();
        players.put(65, new Pitcher(65, "Jonathan", 1, true, 416, 23, 80, 
                111, 259, 32));
        players.put(26, new PositionPlayer(26, "Brock", 4,  true, 1443, 33, 83, 
                422, 454, 274, 50, 2));
        Team team = new Team("RedSox", players);
        for(Integer num : players.keySet()) {
            System.out.println(players.get(num));
        }
    }
/*
Expected output of this unit test:
PA: 1443 BB: 33 SO: 83 H: 422 AB: 454 BI: 274 HR: 50 HBP: 2 BA: 0.93 OBP: 0.32
PA: 416 BB: 23 SO: 80 H: 111 IP: 259 ER: 32 ERA: 3.336 WHIP: 1.55
*/
}