package BanhMi;

class Consumer extends Thread {
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        while (true) {
            store.get();
            try {
                Thread.sleep(1500); // Giả lập thời gian tiêu thụ
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}