package Ve_Tau;

import java.util.LinkedList;
import java.util.List;

class TicketStore {
    private List<String> tickets = new LinkedList<>();
    private final int MAX_TICKETS = 10;

    public synchronized void addTicket(String ticket) {
        while (tickets.size() >= MAX_TICKETS) {
            try {
                System.out.println("Hệ thống vé đầy! Chờ thêm vé mới...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tickets.add(ticket);
        System.out.println("Vé mới được thêm: " + ticket);
        notify();
    }

    public synchronized String bookTicket() {
        while (tickets.isEmpty()) {
            try {
                System.out.println("Hết vé! Chờ hệ thống cập nhật...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String ticket = tickets.remove(0);
        System.out.println("Khách hàng đã đặt vé: " + ticket);
        notify();
        return ticket;
    }
}
