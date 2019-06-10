import java.util.Random;

public class Kraan extends Thread {
    String naam;
    Kade kade;
    Schip schip;
    Random r;
    Long duur;
    Kraan(String naam, Kade kade, Schip schip){
        this.naam = naam;
        this.kade = kade;
        this.schip = schip;
        r = new Random();
    }

    public void run(){
        try {
            while(true){
                Container container = schip.getContainer();
                if(container != null){
                    System.out.println(naam + " begint nu met lossen van " + container.getNaam() + ".."); 
                    duur = (long) randInt(1000, 6000); //het lossen van een container duurt 1 - 6 seconden
                    Thread.sleep(duur);

                    //loop totdat een vrachtwagen de container heeft verplaats zodat er weer ruimte is

                    if(kade.getAantalContainers() < 5){
                        System.out.println(naam + " heeft " + container.getNaam() + " op de kade gezet. Dit duurde " + duur + " milliseconden.");
                        kade.add(container);
                    }else{
                        System.out.println(naam + " wacht nu op ruimte op de kade.."); //hier notify/wait
                    }
                }else{
                    break; //er zijn geen containers meer op het schip
                }
            }
        }
        catch (InterruptedException e) {
            System.out.println(naam + " onderbroken");
        }
    }

    //deze functie genereert een random getal tussen twee andere getallen in
    public int randInt(int min, int max) {
        int randomNum = r.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}