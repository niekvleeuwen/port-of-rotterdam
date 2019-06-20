import java.util.Random;

public abstract class Mover extends Thread{
    private Random r;
    private String name;

    Mover(String name){
        r = new Random();
        this.name = name;
    }
    
    //deze functie geeft een random getal binnen twee meegegeven grenzen
    public int randInt(int min, int max) {
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    //deze functie geeft de naam van het object terug
    public String getNaam(){
        return name;
    }

}