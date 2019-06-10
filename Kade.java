import java.util.ArrayList; 

public class Kade{
    private final static int maxContainers = 5; //er is ruimte voor vijf containers op de kade 
    private String naam;
    private ArrayList<Container> containers = new ArrayList<Container>(); //hier een max

    Kade(String naam){
        this.naam = naam;
    }
    
    public int getAantalContainers(){
        return containers.size();
    }

    public void add(Container container){
        containers.add(container);
        System.out.println(naam + " heeft nu " + containers.size() + " containers");
    }
}