public class Ship extends Storage{
    Ship(String naam, int loadedContainers){
        super(naam);
        //fill the list with the number of loaded containers
        for(int i = 1; i <= loadedContainers; i++){
            containers.add(new Container("Container " + i));
        }
    }
}