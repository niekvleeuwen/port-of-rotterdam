public class Program {
    public static void main(String[] args) {
        int loadedContainers = 7; //containers on the ship
        int roomOnWall = 5; //how much containers fit on the wall
        Ship ship = new Ship("Schip 1", loadedContainers);
        Wall wall = new Wall("Kade 1", roomOnWall);

        Crane crane1 = new Crane("Kraan 1", wall, ship);
        Crane crane2 = new Crane("Kraan 2", wall, ship);

        Truck truck1 = new Truck("Vrachtwagen 1", wall, ship);
        Truck truck2 = new Truck("Vrachtwagen 2", wall, ship);
        Truck truck3 = new Truck("Vrachtwagen 3", wall, ship);

        crane1.start();
        crane2.start();
        
        truck1.start();
    }
}