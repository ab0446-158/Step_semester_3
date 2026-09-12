import java.util.Scanner;

public class MatchDayGridAnalyzer {

    public static double rowAverage(int[] row) {

        int sum = 0;

        for (int value : row) {
            sum = sum + value;
        }

        return (double) sum / row.length;
    }

    public static void analyzeGrid(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {

            double average = rowAverage(grid[i]);

            String classification;

            if (average >= 90) {
                classification = "Excellent";
            } else if (average >= 75) {
                classification = "Good";
            } else {
                classification = "Needs Improvement";
            }

            System.out.printf(
                "Match %d: Average = %.2f | %s%n",
                i + 1,
                average,
                classification
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matches: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of players per match: ");
        int columns = sc.nextInt();

        int[][] grid = new int[rows][columns];

        System.out.println("Enter the scores:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        analyzeGrid(grid);

        sc.close();
    }
}