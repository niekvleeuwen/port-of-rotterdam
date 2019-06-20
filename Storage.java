import java.util.ArrayList;
import java.util.concurrent.*; 

public abstract class Storage{
    private String name;
    private Semaphore sem; 
    public ArrayList<Container> containers = new ArrayList<Container>();

    Storage(String name){
        this.name = name;
        sem = new Semaphore(1); //er mag maar 1 permit uitgegeven worden
    }

    public Container getContainer(){
        try{
            sem.acquire(); //acquiring the lock (dit is nodig omdat anders allebei de kranen tegelijk de container opvragen)
        }catch(InterruptedException e){}
        
        for(Container i : containers){ //loop door alle containers
            if(i != null){
                containers.remove(i); //verwijder de container van het schip
                sem.release(); //release the lock
                System.out.println(name + " geeft container " + i.getNumber());
                return i;
            }
        }
        sem.release(); //release the lock
        return null;
    }

    //deze functie geeft de naam van het object terug
    public String getName(){
        return name;
    }

    //deze functie geeft het huidig aantal containers die het gegeven object bevat terug
    public int countContainers(){
        return containers.size();
    }
}