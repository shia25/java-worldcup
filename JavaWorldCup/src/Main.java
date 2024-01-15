import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static Squad[] squads = new Squad[32];

    //ArrayLists to store new objects of players
    public static ArrayList<Player> playersList = new ArrayList<>();

    //ArrayLists to store new objects of Managers
    public static ArrayList<Manager> managersList = new ArrayList<>();



    // learn how to use this
    public static void main(String[] args)throws FileNotFoundException{

        // need to make an object which is an Arraylist for players and managers, they will show up in the output


        //creates object filePlayer and initialized to read from file Players.csv
        Scanner filePlayer = new Scanner(new File("JavaWorldCup/Players.csv"));

        /* the delimiter insures that scanner separates all values in the  csv file with "," */
        filePlayer.useDelimiter(",");

        /* loops through file player until no value are left */
        while(filePlayer.hasNext()){
            //prints all the values separated by " | "
            System.out.print(filePlayer.next()+" | ");
        }


        //creates object fileManager and initialized to read from file managers.csv
        Scanner fileManager = new Scanner (new File("JavaWorldCup/Managers.csv"));

        /* the delimiter insures that scanner separates all values in the  csv file with "," */
        fileManager.useDelimiter(",");

        /* loops through file managers until no value are left */
        while(fileManager.hasNext()){
            //prints all the values separated by " | "
            System.out.print(fileManager.next()+" | ");
        }


        while(filePlayer.hasNextLine()){
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
            for (Squad squad: squads) {
                if (squad.getTeamName().equals(player.getTeam())) {
                    squad.addPlayer(player);
                }

        }
        filePlayer.close();

        while(fileManager.hasNextLine()){
            String Properties = " ";
            //Separating the row into individual data items
            //Storing managers properties from cvs file into new variables
            String[] managerProperties = Properties.toString().split(",");

            String firstname = managerProperties[0];
            String surname = managerProperties[1];
            String team = managerProperties[2];
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

        // Assigning a new squad for each manager.
        int i = 0;
        for (Manager manager : managersList) {
            // explain this further
            squads[i] = new Squad(manager.getTeam(), manager);
            i++;
        }
        fileManager.close();


    }

    public static Team getTeam(Squad s){
        Team t = new Team(s.getTeamName(), s.getManager());

        return t;
    }

    public static void runTournament(){

    }
}