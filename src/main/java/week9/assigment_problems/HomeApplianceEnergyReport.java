import java.util.Scanner;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {

    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return (getPower() * hours) / 1000.0;
    }

    double calculateCost() {
        return calculateUnits() * 8;
    }
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {

    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {

    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {

    static Appliance createAppliance(
            String type, double hours) {

        switch (type) {

            case "FRIDGE":
                return new Fridge(hours);

            case "AC":
                return new AC(hours);

            case "TV":
                return new TV(hours);

            default:
                return new Washer(hours);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext("SAVER")) {
                sc.next();
                saver = true;
            }

            Appliance appliance =
                    createAppliance(type, hours);

            if (saver && !(appliance instanceof SaverMode)) {

                System.out.println(
                        type + ": saver mode not supported"
                );

                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                SaverMode saverAppliance =
                        (SaverMode) appliance;

                units = saverAppliance.applySaver(units);
            }

            double cost = units * 8;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost
            );

            totalCost += cost;
        }

        System.out.printf(
                "Total Cost: %.2f%n",
                totalCost
        );

        sc.close();
    }
}
