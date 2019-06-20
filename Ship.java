public class Ship extends Storage{
    Ship(String naam, int loadedContainers){
        super(naam);
        //vul de lijst met het aantal containers dat geladen is op het schip
        for(int i = 1; i <= loadedContainers; i++){
            containers.add(new Container(i));
        }
    }
}