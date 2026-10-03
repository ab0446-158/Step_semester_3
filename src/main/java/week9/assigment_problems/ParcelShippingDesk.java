import java.util.Scanner;

abstract class Parcel {

    protected double weight;
    protected double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0.0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel {

    StandardParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight);
    }
}

class ExpressParcel extends Parcel {

    ExpressParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 80 + (15 * weight);
    }

    double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel {

    FragileParcel(double weight, double declaredValue) {
        super(weight, declaredValue);
    }

    double calculateCharge() {
        return 40 + (10 * weight) + 50;
    }

    double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk {

    static Parcel createParcel(
            String type, double weight, double declaredValue) {

        switch (type) {
            case "STANDARD":
                return new StandardParcel(weight, declaredValue);

            case "EXPRESS":
                return new ExpressParcel(weight, declaredValue);

            default:
                return new FragileParcel(weight, declaredValue);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double weight = sc.nextDouble();
            double declaredValue = sc.nextDouble();

            Parcel parcel =
                    createParcel(type, weight, declaredValue);

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        sc.close();
    }
}