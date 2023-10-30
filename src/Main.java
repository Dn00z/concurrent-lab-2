public class Main {
    public static void main(String[] args) throws InterruptedException {

        BusCreator busCreator = new BusCreator();
        RiderCreator riderCreator = new RiderCreator();

        new Thread(riderCreator).start();
        new Thread(busCreator).start();
    }
}