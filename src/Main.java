public class Main {
    public static void main(String[] args) throws InterruptedException {

        Rider rider1 = new Rider(1);
        Rider rider2 = new Rider(2);
        Rider rider3 = new Rider(3);
        Rider rider4 = new Rider(4);
        Rider rider5 = new Rider(5);

        Bus bus1 = new Bus(1);
        Bus bus2 = new Bus(2);
        Bus bus3 = new Bus(3);

        new Thread(rider1).start();
        new Thread(rider2).start();
        new Thread(rider3).start();
        new Thread(rider4).start();
        new Thread(rider5).start();
        new Thread(bus1).start();

        Thread.sleep(30000);

        new Thread(bus2).start();

        Thread.sleep(30000);

        new Thread(bus3).start();
    }
}