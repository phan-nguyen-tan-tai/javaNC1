package Triet_gia;

import java.util.concurrent.Semaphore;
public class DiningPhilosophers {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Semaphore[] chopsticks = new Semaphore[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % numPhilosophers]);
            philosophers[i].start();
        }
    }
}