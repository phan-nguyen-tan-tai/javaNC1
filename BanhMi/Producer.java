package BanhMi;

// Lớp Producer (Nhà sản xuất)
class Producer extends Thread {
    Store store;
    long index = 1;

    public Producer(Store store) {
        this.store = store;
    }

    public void run() {
        while (true) {
            store.put(index);
            index++;
            try {
                Thread.sleep(1000); // Giả lập thời gian sản xuất
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}