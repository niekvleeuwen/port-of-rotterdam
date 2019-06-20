public class Crane extends Mover {
    private Wall wall;
    private Ship ship;
    private Long duration;


    Crane(String name, Wall wall, Ship ship){
        super(name);
        this.wall = wall;
        this.ship = ship;
    }

    public void run(){
        try {
            while(true){
                Container container = ship.getContainer();
                if(container != null){
                    System.out.println(getNaam() + " begint nu met lossen van container " + container.getNumber() + ".."); 
                    duration = (long) randInt(1000, 6000); //het lossen van een container durationt 1 - 6 seconden
                    Thread.sleep(duration); //slaap voor de random tijd die we net gekregen hebben
                    if(wall.spaceAvailable()){ //checken of er ruimte is op de kade
                        System.out.println(getNaam() + " heeft container " + container.getNumber() + " op de kade gezet. Dit duuurde " + duration + " milliseconden.");
                        wall.add(container); //voeg de container toe aan de kade
                    }else{
                        System.out.println(getNaam() + " wacht nu op ruimte op de kade..");
                        //de kraan moet wachten totdat er ruimte is gecreëerd op de kade
                        synchronized(this){
                            try{
                                wait();
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                }else{
                    System.out.println(getNaam() + " gaat nu afsluiten.");
                    break; //er zijn geen containers meer op het schip dus de kraan kan stoppen
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(getNaam() + " onderbroken");
        }
    }
}