import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static Squad[] squads = new Squad[32];

    //ArrayLists to store new objects of players
    public static ArrayList<Player> playersList = new ArrayList<>();

    //ArrayLists to store new objects of Managers
    public static ArrayList<Manager> managersList = new ArrayList<>();


    // learn how to use this
    public static void main(String[] args)throws FileNotFoundException {

        // need to make an object which is an Arraylist for players and managers, they will show up in the output


        //creates object filePlayer and initialized to read from file Players.csv
        Scanner filePlayer = new Scanner(new File("JavaWorldCup/Players.csv"));

        /* the delimiter insures that scanner separates all values in the  csv file with "," */
        filePlayer.useDelimiter(",");

        /* loops through file player until no value are left */
        while (filePlayer.hasNext()) {
            //prints all the values separated by " | "
            System.out.print(filePlayer.next() + " | ");
        }


        //creates object fileManager and initialized to read from file managers.csv
        Scanner fileManager = new Scanner(new File("JavaWorldCup/Managers.csv"));

        /* the delimiter insures that scanner separates all values in the  csv file with "," */
        fileManager.useDelimiter(",");

        /* loops through file managers until no value are left */
        while (fileManager.hasNext()) {
            //prints all the values separated by " | "
            System.out.print(fileManager.next() + " | ");
        }


        while (filePlayer.hasNextLine()) {
            String Properties = " ";
            //Separating the row into individual data items
            //Storing player properties from cvs file into new variables
            String[] playerProperties = Properties.toString().split(",");

            String firstname = playerProperties[0];
            String surname = playerProperties[1];
            String team = playerProperties[2];
            String positionValue = playerProperties[3];

            // Note: Double.parseDouble method allows a conversion of a string, containing a numeric representation into a double
            double fitnessValue = Double.parseDouble(playerProperties[4]);
            double passingAccuracyValue = Double.parseDouble(playerProperties[5]);
            double shotAccuracyValue = Double.parseDouble(playerProperties[6]);
            double shotFrequencyValue = Double.parseDouble(playerProperties[7]);
            double defensivenessValue = Double.parseDouble(playerProperties[8]);
            double aggresionValue = Double.parseDouble(playerProperties[9]);
            double positioningValue = Double.parseDouble(playerProperties[10]);
            double dribblingValue = Double.parseDouble(playerProperties[11]);
            double chanceCreationValue = Double.parseDouble(playerProperties[12]);
            double offsideAdherenceValue = Double.parseDouble(playerProperties[13]);

            //This object player will store the  playerProperties on these new variables collected from file player.cvs
            Player player = new Player(positionValue, fitnessValue, passingAccuracyValue, shotAccuracyValue, shotFrequencyValue, defensivenessValue, aggresionValue, positioningValue, dribblingValue, chanceCreationValue, offsideAdherenceValue);
            /*
            Note: This added player does not have a firstname , surname  or team on its class properties,
            therefore i'm not able to initialize or store it in the new object, but I can still add it on
            as it falls under class person, by calling player object setFirstName() as it is method of person
            player.setFirstName(firstname);
            */
            player.setFirstName(firstname);
            player.setSurname(surname);
            player.setTeam(team);

            // This player is now added into player array list
            playersList.add(player);

            // Adding the player to the squad of the team
            for (Squad squad : squads) {
                if (squad.getTeamName().equals(player.getTeam())) {
                    squad.addPlayer(player);
                }

            }
            filePlayer.close();

            while (fileManager.hasNextLine()) {
                Properties = " ";
                //Separating the row into individual data items
                //Storing managers properties from cvs file into new variables
                String[] managerProperties = Properties.toString().split(",");

                firstname = managerProperties[0];
                surname = managerProperties[1];
                team = managerProperties[2];
                String favouredFormationValue = managerProperties[3];
                double respectValue = Double.parseDouble(managerProperties[4]);
                double abilityValue = Double.parseDouble(managerProperties[5]);
                double knowledgeValue = Double.parseDouble(managerProperties[6]);
                double beliefValue = Double.parseDouble(managerProperties[7]);

                //This object manager will store the  playerProperties on these new variables collected from file player.cvs
                Manager manager = new Manager(favouredFormationValue, respectValue, abilityValue, knowledgeValue, beliefValue);
                manager.setFirstName(firstname);
                manager.setSurname(surname);
                manager.setTeam(team);

                // This manager is now added into managers array list
                managersList.add(manager);
            }

            // Assigning each manager to a new squad
            int i = 0;
            for (Manager manager : managersList) {
                squads[i] = new Squad(manager.getTeam(), manager);
                i++;
            }
            fileManager.close();


        }
    }

        public static Team getTeam (Squad squad){
            Team team = new Team(squad.getTeamName(), squad.getManager());

                Manager manager = squad.getManager();
                String formation = manager.getFavouredFormation();

                // using split the separate type of players in the formation to get the number of defenders, midfielders, and forwards
                String[] formationParts = formation.split("-");
                int defenders = Integer.parseInt(formationParts[0]);
                int midfielders = Integer.parseInt(formationParts[1]);
                int forwards = Integer.parseInt(formationParts[2]);
                int goalkeepers = 1;

                // arrayList for myPlayer objects that will store
                ArrayList<Player> myPlayers = new ArrayList<>();

                // using in built Collections.sort to find the best players
                // Players with higher average attributes will appear first in the list
                Collections.sort(myPlayers, new PlayerComparator());

                // players are added to the team based on the preferred formation
                int defendersCount = 0, midfieldersCount = 0, forwardsCount = 0, goalkeepersCount = 0;
                for (Player player : myPlayers) {
                    if (defendersCount < defenders && player.getPosition().equals("Defender")) {
                        team.addPlayer(player);
                        defendersCount++;
                    } else if (midfieldersCount < midfielders && player.getPosition().equals("Midfielder")) {
                        team.addPlayer(player);
                        midfieldersCount++;
                    } else if (forwardsCount < forwards && player.getPosition().equals("Forward")) {
                        team.addPlayer(player);
                        forwardsCount++;
                    } else if (goalkeepersCount < goalkeepers && player.getPosition().equals("Goalkeeper")) {
                        team.addPlayer(player);
                        goalkeepersCount++;
                    }

                    // stopping count when all the required member of formation has been filled
                    if (defendersCount == defenders &&
                        midfieldersCount == midfielders &&
                        forwardsCount == forwards &&
                        goalkeepersCount == goalkeepers) {
                        break;
                    }
                }

            return team;
        }

    // Using the in built Comparator to compare players attributes
    static class PlayerComparator implements Comparator<Player> {
        @Override
        public int compare(Player player1, Player player2) {
            // variable to store new average of comparing players
            double average1 = calculateAverage(player1);
            double average2 = calculateAverage(player2);

            // comparing player average to find best player
            return Double.compare(average2, average1);
        }

        //calculating the average of all player attributes to find best overall player
        private double calculateAverage(Player player) {
            return (player.getFitness() + player.getPassingAccuracy() + player.getShotAccuracy() +
                    player.getShotFrequency() + player.getDefensiveness() + player.getAggression() +
                    player.getPositioning() + player.getDribbling() + player.getChanceCreation() +
                    player.getOffsideAdherence()) / 10.0;
        }
    }

    public static void runTournament() {
        // Create an array of teams
        Team[] teams = new Team[32];
        int index = 0;
        // Assign teams to the array
        for (Squad s : squads) {
            Team tr = getTeam(s);
            teams[index++] = new Team(tr.getTeamName(), tr.getManager());
        }
        // Divide teams into 8 groups of 4
        Team[][] groups = new Team[8][4];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                int teamIndex = i * 4 + j;
                groups[i][j] = teams[teamIndex];
            }
        }
        // Keeping track of who played games
        Set<String> playedMatches = new HashSet<>();

        // Play group stage matches
        // Generating random scores for the group stage matches.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (j == k) {
                        continue;
                    }
                    Team team1 = groups[i][j];
                    Team team2 = groups[i][k];
                    String match = team1.getTeamName() + " vs " + team2.getTeamName();
                    String match2 = team2.getTeamName() + " vs " + team1.getTeamName();
                    if (playedMatches.contains(match) || playedMatches.contains(match2)) {
                        continue;
                    }
                    playedMatches.add(match);
                    int score1 = (int) (Math.random() * 5);
                    int score2 = (int) (Math.random() * 5);
                    System.out.println("Group stage " + i + team1.getTeamName() + " " + score1 + " - " + score2 + " "
                            + team2.getTeamName());
                }
            }
        }

        // Move top 2 teams from each group to knockout stage
        Team[] knockoutTeams = new Team[16];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 2; j++) {
                int knockoutIndex = i * 2 + j;
                knockoutTeams[knockoutIndex] = groups[i][j];
            }
        }

    }

}