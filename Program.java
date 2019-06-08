public class Program {
    public static void main(String[] args) {
        
        Schip schip = new Schip("Schip 1", 100);

        Kraan kraan1 = new Kraan("Kraan 1");
        Kraan kraan2 = new Kraan("Kraan 2");

        Vrachtwagen wagen1 = new Vrachtwagen("Vrachtwagen 1");
        Vrachtwagen wagen2 = new Vrachtwagen("Vrachtwagen 2");
        Vrachtwagen wagen3 = new Vrachtwagen("Vrachtwagen 3");

        System.out.println("Done");
    }
}