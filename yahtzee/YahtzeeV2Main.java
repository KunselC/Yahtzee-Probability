public class YahtzeeV2Main {
    public static void main(String[] args) {
        Yahtzee y = new Yahtzee();
        //On 1 roll you should get about 0.07-0.09% chance
        //On 2 rolls, you should get about 1.2-1.4% chance
        //On 3 rolls, you should get about 4.5-4.7% 
        //Those are about the chance depending on how many times 
        //you run the simulation: start with 1000 and get it running and then
        //go to 1000000
        y.runSimulation(1000000);
    }
}
