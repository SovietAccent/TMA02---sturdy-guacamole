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
    public MontyHall()
    {
        ran = new Random();
        doors = new ArrayList<String>();
    }

    /**
     * (c)
     */
    public int setup()
    {
        // clear the doors
        doors.clear();

        //
        int ranNumber = ran.nextInt(3);
        switch (ranNumber){
            case 0:
                doors.add("car");
                doors.add("goat");
                doors.add("goat");
                break;

            case 1:
                doors.add("goat");
                doors.add("car");
                doors.add("goat");
                break;

            case 2:
                doors.add("goat");
                doors.add("goat");
                doors.add("car");
                break;
        }
        //return the index of the element Car, despite it's location in the array
        return doors.indexOf("car");
    }

    /**
     * (d) - method to return the original contestant choice being a random number between 1 and 3
     * @return
     */
    public int getContestantChoice()
    {
        return ran.nextInt(3) + 1;
    }

    /**
     * (e)
     *
     * @return
     */
    public int findAlternativeDoor(int contestantChoice)
    {
        if (doors.indexOf("car") == contestantChoice) {
            return contestantChoice;
        }
        return doors.indexOf("goat");
    }

}