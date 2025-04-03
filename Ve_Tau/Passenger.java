package Ve_Tau;

class Passenger extends Thread {
    private TicketStore store;

    public Passenger(TicketStore store) {
        this.store = store;
    }

    public void run() {
        while (true) {
            store.bookTicket();
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}