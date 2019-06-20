import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        int loadedContainers = 12; //containers op het schip
        int roomOnWall = 5; //hoeveel containers op de kade passen
        Ship ship = new Ship("Schip 1", loadedContainers);
        Wall wall = new Wall("Kade 1", roomOnWall);

        Crane crane1 = new Crane("Kraan 1", wall, ship);
        Crane crane2 = new Crane("Kraan 2", wall, ship);

        //maak een arraylist van alle kranen
        ArrayList<Crane> cranes = new ArrayList<>();
        cranes.add(crane1);
        cranes.add(crane2);

        Truck truck1 = new Truck("Vrachtwagen 1", wall, ship, cranes);
        Truck truck2 = new Truck("Vrachtwagen 2", wall, ship, cranes);
        Truck truck3 = new Truck("Vrachtwagen 3", wall, ship, cranes);

        wall.addTruck(truck1);
        wall.addTruck(truck2);
        wall.addTruck(truck3);
        wall.addCrane(crane1);
        wall.addCrane(crane2);

        //start de threads
        crane1.start();
        crane2.start();
        
        truck1.start();
        truck2.start();
        truck3.start();
    }
}