package Ve_Tau;

class TicketAgent extends Thread {
    private TicketStore store;
    private int ticketNumber = 1;

    public TicketAgent(TicketStore store) {
        this.store = store;
    }

    public void run() {
        while (true) {
            store.addTicket("Vé tàu " + ticketNumber);
            ticketNumber++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}