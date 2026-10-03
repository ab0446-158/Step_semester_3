import java.util.Scanner;

abstract class Student {

    protected String name;

    private static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    double calculateExtraFee() {
        return 0.0;
    }

    boolean usesBus() {
        return false;
    }

    double calculateTotalFee() {
        double total = calculateTuition() + calculateExtraFee();

        if (usesBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }
}

class DayScholar extends Student {

    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0;
    }

    double calculateExtraFee() {
        return 60000.0;
    }
}

class ScholarshipStudent extends Student {

    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000.0;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {

    static Student createStudent(String type, String name) {

        switch (type) {

            case "DAY_SCHOLAR":
                return new DayScholar(name);

            case "HOSTELLER":
                return new Hosteller(name);

            default:
                return new ScholarshipStudent(name);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student = createStudent(type, name);

            double fee = student.calculateTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);

            totalCollected += fee;
        }

        System.out.printf(
                "Total Collected: %.2f%n",
                totalCollected
        );

        sc.close();
    }
}
