import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Kade{
    private final static int maxContainers = 5; //er is ruimte voor vijf containers op de kade 
    private String naam;
    private ArrayList<Container> containers = new ArrayList<Container>(); //hier een max
    private Semaphore sem; 

    Kade(String naam){
        this.naam = naam;
        sem = new Semaphore(1); 
    }
    
    public int getAantalContainers(){
        return containers.size();
    }

    public void add(Container container){
        containers.add(container);
        System.out.println(naam + " heeft nu " + containers.size() + " containers.");
    }
}