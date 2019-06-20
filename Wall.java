import java.util.ArrayList;

public class Wall extends Storage{
    private int maxContainers; //er is ruimte voor een maxium aantal containers op de kade
    private ArrayList<Truck> trucks;
    private ArrayList<Crane> cranes;

    Wall(String name, int maxContainers){
        super(name); 
        this.maxContainers = maxContainers;
        trucks = new ArrayList<>();
        cranes = new ArrayList<>();
    }

    //deze functie voegt de meegeven container toe aan de lijst
    public synchronized void add(Container container){
        containers.add(container); //voeg de container toe aan de arraylist
        notifyTrucks(); //geef de vrachtwagen een seintje dat er een container is om te verplaatsen
        System.out.println(getName() + " heeft nu " + containers.size() + " containers");
    }

    //deze functie verwijdert een gegeven container van de kade
    public synchronized void delete(Container container){
        containers.remove(container);
        notifyCranes(); //geef de kranen een seintje dat er ruimte is om een container neer te zetten
        if(countContainers() == 0){ //als de containers op zijn dan geef dan een seintje aan de vrachtwagens zodat ze niet blijven wachten op containers die niet komen
            notifyCranes();
        }
    }

    //deze functie voegt een truck toe aan de lijst
    public synchronized void addTruck(Truck t){
        trucks.add(t);
    }

     //deze functie voegt een truck toe aan de lijst
     public synchronized void addCrane(Crane c){
        cranes.add(c);
    }

    //deze functie geeft het aantal containers op de kade terug
    public synchronized int getMaxContainers(){
        return maxContainers;
    }

    //deze functie checkt of er ruimte is op de kade
    public synchronized Boolean spaceAvailable(){
        return countContainers() < getMaxContainers();
    }

    //deze functie notfied alle vrachtwagens in de lijst trucks
    public void notifyTrucks(){
        for(int i = 0; i < trucks.size(); i++){
            synchronized(trucks.get(i)){
                trucks.get(i).notify();
            }
        }
    }

     //deze functie notfied alle kranen in de lijst cranes
     public void notifyCranes(){
        for(int i = 0; i < cranes.size(); i++){
            synchronized(cranes.get(i)){
                cranes.get(i).notify();
            }
        }
    }
}