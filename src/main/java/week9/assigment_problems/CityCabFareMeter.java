import java.util.Scanner;

interface NightService {
    double applyNightCharge(double fare);
}

abstract class Cab {

    protected double km;

    protected static final double MINIMUM_FARE = 100.0;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {
        return Math.max(MINIMUM_FARE, km * getRate());
    }
}

class MiniCab extends Cab {

    MiniCab(double km) {
        super(km);
    }

    double getRate() {
        return 10.0;
    }
}

class SedanCab extends Cab implements NightService {

    SedanCab(double km) {
        super(km);
    }

    double getRate() {
        return 14.0;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUVCab extends Cab implements NightService {

    SUVCab(double km) {
        super(km);
    }

    double getRate() {
        return 18.0;
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {

    static Cab createCab(String type, double km) {

        switch (type) {

            case "MINI":
                return new MiniCab(km);

            case "SEDAN":
                return new SedanCab(km);

            default:
                return new SUVCab(km);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            if (type.equals("MINI") && time.equals("NIGHT")) {
                System.out.println(
                        "MINI: night service not available"
                );
                continue;
            }

            Cab cab = createCab(type, km);

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")
                    && cab instanceof NightService) {

                fare = ((NightService) cab)
                        .applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}