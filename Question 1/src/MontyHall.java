import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Random;

public class MontyHall {

    /**
     * (a)
     */
    public Random ran;
    public ArrayList<String> doors;

    /**
     * (b)
     */
    public MontyHall() {
        ran = new Random();
        doors = new ArrayList<String>();
    }

    /**
     * (c)
     */
    public int setUp() {
        // clear the doors
        doors.clear();

        //
        int ranNumber = ran.nextInt(3) + 1;
        switch (ranNumber) {
            case 1:
                doors.add("car");
                doors.add("goat");
                doors.add("goat");
                break;

            case 2:
                doors.add("goat");
                doors.add("car");
                doors.add("goat");
                break;

            case 3:
                doors.add("goat");
                doors.add("goat");
                doors.add("car");
                break;
        }
        //return the index of the element Car, despite it's location in the array
        return doors.indexOf("car")+1;
    }

    /**
     * (d) - method to return the original contestant choice being a random number between 1 and 3
     *
     * @return
     */
    public int getContestantChoice() {
        return ran.nextInt(3) + 1;
    }

    /**
     * (e)
     *
     * @return
     */
    public int findAlternativeDoor(int contestantChoice) {
        // Check if the door the contestant selected has a goat behind it
        if (doors.get(contestantChoice - 1).equals("goat")) {
            // Find the door number that holds the car
            for (int i = 0; i < doors.size(); i++) {
                if (i != contestantChoice - 1 && doors.get(i).equals("car")) {
                    return i + 1; // Return the door number with the car
                }
            }

        // If the door selected by the contestant holds the car, randomly return one of the other two door numbers
            //if the contestant selects car
        } if (doors.get(contestantChoice - 1).equals("car")) {
            // initialise a new variable called alternativeDoor that will be equal in value to contestantChoice.
            int alternativeDoor = contestantChoice;
            //this will constantly loop until alternativeDoor is equal to a random value that is not equal to the contestant choice
            //which could be any one of the two doors hiding the goats.
            while (alternativeDoor == contestantChoice) {
                alternativeDoor = ran.nextInt(3) + 1;
            }
            //when alternativeDoor is equal to one of the goat doors, it will be returned.
            return alternativeDoor;
        }

        return contestantChoice;
    }

    public boolean playGame(boolean isStick) {
        int carDoor = setUp();
        int contChoice = getContestantChoice();
        int altChoice = findAlternativeDoor(contChoice);

        //if the contestant opts to stick with their original choice, the
        int finalChoice = isStick ? contChoice : altChoice;

//        System.out.println(doors);
//        System.out.println("Car door: " + (carDoor));
//        System.out.println("Contestant choice: " + (contChoice));
//        System.out.println("Alternative choice: " + (altChoice));
//        System.out.println("Final chosen door: " + (finalChoice));

        return finalChoice == carDoor;
    }

    public void simulate(int numRuns)
    {
        int winsStick = 0;
        int winsSwitch = 0;

        for (int i = 0; i < numRuns; i++) {
            boolean contWinStick = playGame(true);
            if (contWinStick) {
                winsStick++;
            }

            boolean contWinsSwitch = playGame(false);
            if (contWinsSwitch) {
                winsSwitch ++;
            }
        }

        System.out.println("Wins by sticking: " + winsStick);
        System.out.println("Wins by Switching: " + winsSwitch);}

}



