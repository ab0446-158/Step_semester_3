import java.util.Scanner;

public class PasswordChecker {

    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrengthRating() {

        int score = 0;

        if (password.length() >= 8) {
            score++;
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            }

            if (Character.isLowerCase(ch)) {
                hasLower = true;
            }

            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }

        if (hasUpper) {
            score++;
        }

        if (hasLower) {
            score++;
        }

        if (hasDigit) {
            score++;
        }

        if (score == 4) {
            return "Strong";
        } else if (score >= 2) {
            return "Medium";
        } else {
            return "Weak";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        PasswordChecker checker = new PasswordChecker(password);

        System.out.println("Strength: "
                + checker.getStrengthRating());

        sc.close();
    }
}