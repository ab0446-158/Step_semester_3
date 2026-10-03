import java.util.Scanner;
import java.time.LocalDate;

abstract class Plan {
    protected String name;
    protected LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract LocalDate getRenewalDate();
}

class BasicPlan extends Plan {

    BasicPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends Plan {

    StandardPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends Plan {

    PremiumPlan(String name, LocalDate startDate) {
        super(name, startDate);
    }

    LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder {

    static Plan createPlan(
            String type, String name, LocalDate date) {

        switch (type) {
            case "BASIC":
                return new BasicPlan(name, date);

            case "STANDARD":
                return new StandardPlan(name, date);

            default:
                return new PremiumPlan(name, date);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            Plan plan = createPlan(type, name, startDate);

            System.out.println(
                    name + ": " + plan.getRenewalDate()
            );
        }

        sc.close();
    }
}