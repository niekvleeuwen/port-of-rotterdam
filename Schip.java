import java.util.ArrayList;
import java.util.concurrent.*; 

public class Schip{
    private String naam;
    private int geladenContainers = 7;
    private ArrayList<Container> containers = new ArrayList<Container>();
    private Semaphore sem; 

    Schip(String naam){
        this.naam = naam;
        sem = new Semaphore(1); 
        //vul de arraylist met het aantal geladen containers
        for(int i = 1; i <= geladenContainers; i++){
            containers.add(new Container("Container " + i));
        }
    }

    public Container getContainer(){
        try{
            sem.acquire(); //acquiring the lock (dit is nodig omdat anders allebei de kranen tegelijk de container opvragen)
        }catch(InterruptedException e){}
        
        for(Container i : containers){
            if(i != null){
                containers.remove(i); //verwijder de container van het schip
                sem.release(); //release the lock
                return i;
            }
        }
        sem.release(); //release the lock
        return null;
    }
}