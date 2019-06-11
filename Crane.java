public class Crane extends Mover {
    String name;
    Wall wall;
    Ship ship;
    Long duration;

    Crane(String name, Wall wall, Ship ship){
        this.name = name;
        this.wall = wall;
        this.ship = ship;
    }

    public void run(){
        try {
            while(true){
                Container container = ship.getContainer();
                if(container != null){
                    System.out.println(name + " begint nu met lossen van " + container.getName() + ".."); 
                    duration = (long) randInt(1000, 6000); //het lossen van een container durationt 1 - 6 seconden
                    Thread.sleep(duration);

                    //loop totdat een vrachtwagen de container heeft verplaats zodat er weer ruimte is

                    if(wall.countContainers() < wall.getMaxContainers()){
                        System.out.println(name + " heeft " + container.getName() + " op de wall gezet. Dit durationde " + duration + " milliseconden.");
                        wall.add(container);
                    }else{
                        System.out.println(name + " wacht nu op ruimte op de wall.."); //hier notify/wait
                    }
                }else{
                    break; //er zijn geen containers meer op het Ship
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(name + " onderbroken");
        }
    }
}