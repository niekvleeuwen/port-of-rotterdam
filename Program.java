public class Program {
    public static void main(String[] args) {
        Schip schip = new Schip("Schip 1");
        Kade kade = new Kade("Kade 1");

        Kraan kraan1 = new Kraan("Kraan 1", kade, schip);
        Kraan kraan2 = new Kraan("Kraan 2", kade, schip);

        Vrachtwagen wagen1 = new Vrachtwagen("Vrachtwagen 1");
        Vrachtwagen wagen2 = new Vrachtwagen("Vrachtwagen 2");
        Vrachtwagen wagen3 = new Vrachtwagen("Vrachtwagen 3");

        kraan1.start();
        kraan2.start();
    }
}