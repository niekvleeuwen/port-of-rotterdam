import java.util.Random;

public abstract class Mover extends Thread{
    private Random r;

    Mover(){
        r = new Random();
    }
    
    //this function creates a random integer between the integers passed as parameters
    public int randInt(int min, int max) {
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}