/***********************************************************************
 * REVISION HISTORY (Newest First)
 * **********************************************************************
 * 10/23/19 - Finished class - Thomas Bahun
 * 10/23/19 - Received help from prof on class - Thomas Bahun
 * 10/23/19 - Started work on League class - Thomas Bahun
 * 08/04/2016 - Anne Applin - formatting and JavaDoc
 * 2014 - David Briggs - original starting code and comments 
 ***********************************************************************/

package baseballdriver;

import java.util.*;

/**
 * A class to hold a number of team rosters for the teams of a league.
 * You must use a Map data member to hold the Team objects, either a HashMap
 * or a TreeMap may be used.
 * You must
 * <ol>
 * <li> code a constructor that takes a Scanner object and which loads
 *     the Map data member with the collection of Team objects from the file
 *     given by the Scanner.</li>
 * <li> code a public method String lookupPlayer(String t, int n)
 *     that returns the appropriate choice from the following three results
 *    <ol>
 *     <li>No team named t is in the league.</li>
 *     <li>No player with number n is on the roster for the t.</li>
 *     <li><code><player stats for player n of team t></code></li>
 *    </ol>
 *     where the format of the last is given in the program assignment.</li>
 * <li> code a public method String calcPitchingStats(String t)
 *     that returns the appropriate choice from the following three results
 *     <ol>
 *     <li>No team named t is in the league.</li>
 *     <li>The t appear to have no pitchers at this time.</li>
 *     <li><code><pitching stats for t></code></li>
 *     where the format of the last is given in the program assignment.</li>
 * <li> code a public method String calcHittingStats(String t)
 *     that returns the appropriate choice from the following three results
 *     <ol>
 *     <li>No team named t is in the league.<li>
 *     <li>The t appear to have no hitters at this time.</li>
 *     <li><code><hitting stats for t></code></li>
 *     where the format of the last is given in the program assignment.
 *     The other two methods are extra credit options that you may do if
 *     you wish.  Consult the program assignment for their specifications.</li>
 *</ol> 
 * @author David Briggs
 */
public class League{
    
    /**
     * a Map to store all the teams in the league
     */
    Map<String, Team> league = new TreeMap<>();
    
    /**
     * Constructor for League.  Reads the input file given and validated
     * on the command line.
     * @param s a Scanner object that has already been connected to a 
     *    physical file in the driver.
     */
    public League(Scanner s){
        // be sure to use ignore case for all string inputs
        while (s.hasNext()) {
            Team t = readInTeam(s);
            league.put(t.getName().toLowerCase(), t);
        }
        s.close();
    }
    
    /**
     * readInTeam to read in the Teams name and call the readInPlayer method
     * @param s the Scanner from the driver
     * @return the Team in question
     */
    public Team readInTeam(Scanner s) {
        String name = s.next();
        int number = s.nextInt();
        TreeMap<Integer, Player> players = new TreeMap<>();
        while (number != -1) {
            Player p = readInPlayer(s, number);
            players.put(number, p);
            number = s.nextInt();
        }
        return new Team(name, players);
    }
    
    /**
     * readInPlayer to read the players stats and store into Map
     * @param s the Scanner from the driver
     * @param number the players number
     * @return the Player in question 
     */
    public Player readInPlayer(Scanner s, int number) {
        
        Player p;
        
        String name = s.next();
        int position = s.nextInt();
        boolean throwsRightHanded = (s.next().charAt(0) == 't');
        int plateAppearances = s.nextInt();
        int walks = s.nextInt();
        int strikeouts = s.nextInt();
        int hits = s.nextInt();
        int other1 = s.nextInt();
        int other2 = s.nextInt();
        
        if (position == 1) {
            p = new Pitcher(number, name, position, throwsRightHanded,
                    plateAppearances, walks, strikeouts, hits, other1, other2);
        } else {
            int other3 = s.nextInt();
            int other4 = s.nextInt();
            p = new PositionPlayer(number, name, position, throwsRightHanded,
                    plateAppearances, walks, strikeouts, hits, other1, other2,
                    other3, other4);      
        }
        return p;
    }
    

    /**
     * Lookup a specific player on a specific team.
     * @param team a String representing the team name
     * @param playerNum an int representing the player we are looking up
     * @return a string representing the results of the lookup.  
     */
    public String lookup(String team, int playerNum){
        StringBuilder str = new StringBuilder();
        
        if (league.containsKey(team.toLowerCase())) {
            str.append(league.get(team).lookupPlayer(playerNum));
        } else {
            str.append(noTeamExists(team));
        }
        return str.toString();
    }

    /**
     * Calculate the pitching statistics for a given team
     * @param team a String that is the team name - the key for the map
     * @return a String representing the results of the calculations
     */
    public String calcPitchingStats(String team){
        StringBuilder str = new StringBuilder();
        
        if(league.containsKey(team.toLowerCase())) {
            str.append(league.get(team).calcPitchingStats());
        } else {
            str.append(noTeamExists(team));
        }
        return str.toString();
    }

    /**
     * Calculate the hitting statistics for a given team
     * @param team a String that is the team name - the key for the map
     * @return a String representing the results of the calculations
     */
    public String calcHittingStats(String team){
        StringBuilder str = new StringBuilder();
        
        if(league.containsKey(team.toLowerCase())) {
            str.append(league.get(team).calcHittingStats());
        } else {
            str.append(noTeamExists(team));
        }
        return str.toString();
    }
    
    /**
     * noTeamExists method to print the output if not team exists when input
     * @param team the team object in question
     * @return a string explaining that no team exists
     */
    public String noTeamExists(String team) {
        return "No team named " + team + " is in the league.";
    }

    // the first extra credit option

    /**
     * Allows the players on a team to update statistics based on the
     * outcome of a current game. (ideally will update two teams from one game)
     * There is no need to comment this out! 
     * Do NOT Change unless you implement it.
     * @param scnr a keyboard Scanner object
     * @return A String as specified
     */
    public String update(Scanner scnr){
        StringBuilder str = new StringBuilder();
        str.append("update stub");
        return str.toString();
    }

    // the second extra credit option

    /**
     * Calculates the statistics for the league for right handed and left \
     *  handed pitchers and hitters
     * There is no need to comment this out! 
     * Do NOT Change unless you implement it.
     * @return a String as specified
     */
    public String calculateHandedness(){
        StringBuilder str = new StringBuilder();
        str.append("handedness stub");
        return str.toString();
    }

}