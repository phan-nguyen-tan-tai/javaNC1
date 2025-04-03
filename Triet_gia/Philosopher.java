package Triet_gia;

import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    private int id;
    private Semaphore leftChopstick, rightChopstick;

    public Philosopher(int id, Semaphore leftChopstick, Semaphore rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    private void think() {
        System.out.println("triết gia.Philosopher " + id + " is thinking.");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        System.out.println("triết gia.Philosopher " + id + " is eating.");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            think();
            try {
                leftChopstick.acquire();
                System.out.println("triết gia.Philosopher " + id + " picked up left chopstick.");

                rightChopstick.acquire();
                System.out.println("triết gia.Philosopher " + id + " picked up right chopstick.");

                eat();

                rightChopstick.release();
                System.out.println("triết gia.Philosopher " + id + " put down right chopstick.");

                leftChopstick.release();
                System.out.println("triết gia.Philosopher " + id + " put down left chopstick.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
