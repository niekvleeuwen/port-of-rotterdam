import java.util.ArrayList;
import java.util.concurrent.*; 

public abstract class Storage{
    private String name;
    private Semaphore sem; 
    public ArrayList<Container> containers = new ArrayList<Container>();

    Storage(String name){
        this.name = name;
        sem = new Semaphore(1); 
    }

    public Container getContainer(){
        try{
            sem.acquire(); //acquiring the lock (dit is nodig omdat anders allebei de kranen tegelijk de container opvragen)
        }catch(InterruptedException e){}
        
        for(Container i : containers){
            if(i != null){
                containers.remove(i); //verwijder de container van het schip
                sem.release(); //release the lock
                System.out.println(name + " geeft " + i.getName());
                return i;
            }
        }
        sem.release(); //release the lock
        return null;
    }

    public String getName(){
        return name;
    }

    public int countContainers(){
        return containers.size();
    }
}