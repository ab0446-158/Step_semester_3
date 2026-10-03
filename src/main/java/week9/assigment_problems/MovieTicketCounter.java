import java.util.Scanner;

abstract class Ticket {

    protected int count;

    private static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double getAmount() {
        return (getPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularTicket extends Ticket {

    RegularTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 150.0;
    }
}

class PremiumTicket extends Ticket {

    PremiumTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 250.0;
    }
}

class ReclinerTicket extends Ticket {

    ReclinerTicket(int count) {
        super(count);
    }

    double getPrice() {
        return 400.0;
    }
}

public class MovieTicketCounter {

    static Ticket createTicket(String seat, int count) {

        switch (seat) {
            case "REGULAR":
                return new RegularTicket(count);

            case "PREMIUM":
                return new PremiumTicket(count);

            default:
                return new ReclinerTicket(count);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket = createTicket(seat, count);

            double amount = ticket.getAmount();

            System.out.printf("%s: %.2f%n", seat, amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}