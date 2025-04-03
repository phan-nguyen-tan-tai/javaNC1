package bai_1;

public class Main {
    public static void main(String[] args) {
        Counter c1 = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i=0; i<1000; i++){
                c1.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<1000; i++){
                c1.increment();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("giá trị cuối cùng của counter: "+ c1.getCount());
    }
}
