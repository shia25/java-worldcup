import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Squad[] squads = new Squad[32];

    //ArrayLists to store new objects of players
    private static ArrayList<Player> playersList = new ArrayList<>();

    //ArrayLists to store new objects of Managers
    private static ArrayList<Manager> managersList = new ArrayList<>();



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
        //if the next value not detected terminate
        filePlayer.close();


        //creates object fileManager and initialized to read from file managers.csv
        Scanner fileManager = new Scanner (new File("JavaWorldCup/Managers.csv"));

        /* the delimiter insures that scanner separates all values in the  csv file with "," */
        fileManager.useDelimiter(",");

        /* loops through file managers until no value are left */
        while(fileManager.hasNext()){
            //prints all the values separated by " | "
            System.out.print(fileManager.next()+" | ");
        }
        System.out.println();
        //if the next value not detected terminate
        fileManager.close();


        while(filePlayer.hasNextLine()){
            //Separating the row into individual data items
            filePlayer.useDelimiter(",");
            //Storing player properties into new v



        }


    }

    public static Team getTeam(Squad s){
        Team t = new Team(s.getTeamName(), s.getManager());

        return t;
    }

    public static void runTournament(){

    }
}