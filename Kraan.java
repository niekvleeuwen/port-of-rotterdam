import java.util.concurrent.*; 

public class Kraan extends Thread {
    String naam;
    Kade kade;
    Schip schip;
    Kraan(String naam, Kade kade, Schip schip){
        this.naam = naam;
        this.kade = kade;
        this.schip = schip;
    }

    public void run(){
        try {
            while(true){
                Container container = schip.getContainer();
                if(container != null){
                    System.out.println(naam + " begint nu met lossen van container " + container.getNaam() + ".."); 
                    Thread.sleep(1000);
                    System.out.println(naam + " heeft container " + container.getNaam() + " gelost");
                    //hier een while loop totdat een vrachtwagen de container verplaatst heeft
                    if(kade.getAantalContainers() < 5){
                        kade.add(container);
                    }else{
                        System.out.println(naam + " wacht nu");
                    }
                }else{
                    break;
                }
            }
            
        }
        catch (InterruptedException e) {
            System.out.println(naam + " onderbroken");
        }
    }
}