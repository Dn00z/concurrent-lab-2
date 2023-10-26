public class Main {
    public static void main(String[] args) {

        BusCreator busCreator = new BusCreator();
        RiderCreator riderCreator = new RiderCreator();

        new Thread(busCreator).start();
        new Thread(riderCreator).start();
    }
}