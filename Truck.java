import java.util.ArrayList;

public class Truck extends Mover{
    private Wall wall;
    private Ship ship;
    private Long duration;
    private ArrayList<Crane> cranes; //deze lijst wordt gebruikt om te kijken of de kraan bezig is om containers te verplaatsen
    
    Truck(String name, Wall wall, Ship ship, ArrayList<Crane> cranes){
        super(name);
        this.wall = wall;
        this.ship = ship;
        this.cranes = cranes;
    }

    public void run(){
        try {
            while(true){
                Container container = wall.getContainer(); //verkrijg een container van de kade
                if(container != null){ //checken of er een container op de kade was
                    System.out.println(getNaam() + " begint nu met wegrijden van container " + container.getNumber() + ".."); 
                    duration = (long) randInt(7000, 10000); //het verplaatsen van een container duurt 1 - 6 seconden
                    Thread.sleep(duration); //slaap voor de random tijd die we net gekregen hebben
                    wall.delete(container); //verwijder de container van de kade
                    System.out.println(getNaam() + " heeft container " + container.getNumber() + " weggebracht. Dit duuurde " + duration + " milliseconden.");
                }else{
                    //eerst checken of er nog containers zijn om weg te rijden
                    if(wall.countContainers() == 0 && ship.countContainers() == 0){ //checken of er nog containers op de kade of het schip staan
                        if(!cranes.get(0).isAlive() && !cranes.get(1).isAlive()){ //als beide kranen ook geen containers meer bevatten dan stoppen we deze thread
                            System.out.println(getNaam() + " gaat nu afsluiten.");
                            wall.notifyTrucks(); //geef een seintje aan de andere trucks om een deadlock te voorkomen
                            break;
                        }
                    }
                    //de Wall bevat nu geen containers en de vrachtwagen moet wachten
                    synchronized(this){
                        try{
                            wait();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(getNaam() + " onderbroken");
        }
    }

    //deze functie voegt de meegeven kraan toe aan de lijst cranes
    public void addCrane(Crane c){
        cranes.add(c);
    }
}