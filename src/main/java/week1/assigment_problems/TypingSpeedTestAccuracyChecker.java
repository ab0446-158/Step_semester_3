package week1.assigment_problems;

public class TypingSpeedTestAccuracyChecker {

    public static void compareTypedText(String original, String typed) {

        int errors = 0;
        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {
            if (original.charAt(i) != typed.charAt(i)) {
                errors++;
            }
        }

        errors += Math.abs(original.length() - typed.length());

        System.out.println("Total Typing Errors: " + errors);
    }

    public static void main(String[] args) {

        String original = "JAVA";
        String typed = "JXVA";

        compareTypedText(original, typed);
    }
}