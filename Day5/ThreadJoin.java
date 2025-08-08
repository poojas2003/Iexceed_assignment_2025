class Sample extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.display();
    }

    public void display() {
        for (int i = 0; i < 21; i++) {
            System.out.println("Display: " + i);
        }
    }
}

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Sample obj = new Sample();
        obj.start();
        obj.join(); 
        System.out.println("Main thread finished after obj completed.");
    }
}
