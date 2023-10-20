import java.util.concurrent.Semaphore;

public class BusStop {

    private static int riderCount = 0; // waiting riders for a bus

    private final static Semaphore riderWaitingSemaphore = new Semaphore(3); // to allow 50 riders to wait in bus stop

    private  final static Semaphore busArrivalSemaphore = new Semaphore(1); // to keep track of bus arrival

    private  final static Semaphore busDepartureSemaphore = new Semaphore(0); // to keep track of bus departure

    private final static Semaphore busBoardSemaphore = new Semaphore(0); // to keep track of bus boarding

    public static int getRiderCount() {
        return riderCount;
    }

    public static void incrementRiderCount() {
        riderCount ++;
    }

    public static void decrementRiderCount() {
        riderCount --;
    }

    public static Semaphore getBusArrivalSemaphore() {
        return busArrivalSemaphore;
    }

    public static Semaphore getBusDepartureSemaphore() {
        return busDepartureSemaphore;
    }

    public static Semaphore getRiderWaitingSemaphore() {
        return riderWaitingSemaphore;
    }

    public static Semaphore getBusBoardSemaphore() {
        return busBoardSemaphore;
    }
}
