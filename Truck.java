public class Truck extends Mover{
    private String name;
    private Wall wall;
    private Ship ship;
    private Long duration;
    
    Truck(String name, Wall wall, Ship ship){
        this.name = name;
        this.wall = wall;
        this.ship = ship;
    }

    public void run(){
        try {
            while(true){
                Container container = wall.getContainer();
                if(container != null){
                    System.out.println(name + " begint nu met wegrijden van " + container.getName() + ".."); 
                    duration = (long) randInt(1000, 6000); //het verplaatsen van een container duurt 1 - 6 seconden
                    Thread.sleep(duration);
                    wall.delete(container);
                }else{
                    //de Wall bevat nu geen containers en de vrachtwagen moet wachten
                    //hier moet een notify/wait

                    //dit voorkomt een deadlock maar kan er voor zorgen dat de thread stopt terwijl er nog een container aan de kraan hangt
                    if(ship.countContainers() == 0){
                        break;
                    }
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(name + " onderbroken");
        }
    }
}