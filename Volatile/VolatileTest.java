package nali.Volatile;

import java.util.Scanner;

public class VolatileTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        myThread.shutDown();


    }
}

class MyThread extends Thread {
    private volatile boolean running = true;
    public void run() {
        while (running) {
            System.out.println("Hello ");
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown() {
        this.running = false;
    }
}