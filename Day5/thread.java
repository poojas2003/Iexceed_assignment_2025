class Sample extends Thread {
    Sample() {
        start();
    }

    public void run() {
        System.out.println("Hello from Sample class");
    }
}

public class thread {
    public static void main(String[] args) {
        // Creates and starts the thread
        Sample obj = new Sample();
    }
}
