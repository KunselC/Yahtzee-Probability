import java.util.*;
import java.util.stream.Collectors;

public class Yahtzee
{
    Die die1 = new Die(6);
    Die die2 = new Die(6);
    Die die3 = new Die(6);
    Die die4 = new Die(6);
    Die die5 = new Die(6);
    
    // 2 points - This method should call roll for every Die 
    public void roll(){
        die1.roll();
        die2.roll();
        die3.roll();
        die4.roll();
        die5.roll();
        determineKeep();

    }

    // 2 points - This method checks to see if every die is the same value
    public boolean yahtzee(){
        if (die1.getKeep() == die2.getKeep() && die2.getKeep() == die3.getKeep() && die3.getKeep() == die4.getKeep() && die4.getKeep() == die5.getKeep()){
            return true;
        }
        return false;



    
    }
    
     // 6 points 
     // A player's turn consists of the number of rolls specified by the 
     // parameter numRolls
     // (e.g. playerTurn(1) means the player only gets one roll
     // to see if they get a yahtzee (! pretty rare); playerTurn(2) means the player
     // gets two rolls to see if they get a yahtzee; playerTurn(1000) means the player
     // get 1000 rolls to see if they ever get a yahtzee) 
     // The method should return a one(1) if they got a 
     // yahztee; 0 if they did not.
    public int playerTurn(int numRolls){
        for (int i = 0; i < numRolls; i++){
            roll();
            if (yahtzee() == true){
                reset();
                return 1;
            }
        }
        reset();
        return 0;





    }

    // 5 points 
    // In the normal game each player gets a 3 rolls per turn
    // In this simulation I want to know what the chance of a yahztee if a player turn
    // was:
    // . - 1 roll,
    // . - 2 rolls, or
    //   - 3 rolls   
    //This runs a yatzhee game numberTurns times, keeping track 
    //   of how many yahtzees occur under each simulation
    //   1 roll, 2 rolls, or 3 rolls and then printing the results to
    //   this console. I kept the first and last lines for you to use 
    public void runSimulation(int numberTurns){
        int numYahtzees1Roll = 0, numYahtzees2Rolls = 0, numYahtzees3Rolls = 0;
        for(int i = 0; i < numberTurns; i++){
            numYahtzees1Roll += playerTurn(1);
        }
        for(int i = 0; i < numberTurns; i++){
            numYahtzees2Rolls += playerTurn(2);
        }
        for(int i = 0; i < numberTurns; i++){
            numYahtzees3Rolls += playerTurn(3);
        }
          
        System.out.println("On 1 roll, you got : "  + numYahtzees1Roll + " out of " + numberTurns + " : " + (numYahtzees1Roll * 1.0/numberTurns));
        System.out.println("On 2 rolls, you got : "  + numYahtzees2Rolls+ " out of " + numberTurns + " : " + (numYahtzees2Rolls * 1.0/numberTurns));
        System.out.println("On 3 rolls, you got : "  + numYahtzees3Rolls + " out of " + numberTurns + " : " + (numYahtzees3Rolls * 1.0/numberTurns));
    }
    
   //this resets all the dice so that keep is false
   //you need to do this after every player turn 
   public void reset(){
    for(Die d : this.putInCup())
    {
        d.setKeep(false);
    }
}

//this method determines which dice to keep after
//every roll.
public void determineKeep(){
    ArrayList<Integer> counts = new ArrayList<Integer>();
    for(int x = 1; x <= 6; x++){
        counts.add(this.numOfVal(x));
    }
    
    int largestVal = -1;
    int largestIndex = -1;
    for(int x = 0; x < 6; x++){
        if(counts.get(x) > largestVal){
            largestVal = counts.get(x);
            largestIndex = x;
        }
    }
    int keepVal = largestIndex + 1; //why do I add 1?
    for(Die d : this.putInCup()){
        int val = d.getValue();
        if(val == keepVal)
            d.setKeep(true);
        else
            d.setKeep(false);
    }
    
}

private int numOfVal(int val){
    int count = 0;
    for(Die d : this.putInCup()){
        if(d.getValue() == val)
            count++;
    }      
    return count;
}

private ArrayList<Die> putInCup(){
    ArrayList<Die> cup = new ArrayList<Die>();
    cup.add(die1);
    cup.add(die2);
    cup.add(die3);
    cup.add(die4);
    cup.add(die5);
    return cup;
}

   
}

