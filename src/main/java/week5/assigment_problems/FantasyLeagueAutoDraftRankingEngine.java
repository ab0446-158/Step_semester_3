import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRankingEngine {

    static class Player implements Comparable<Player> {

        private String name;
        private int runs;
        private int wickets;
        private double strikeRate;
        private double economy;

        public Player(String name, int runs, int wickets,
                      double strikeRate, double economy) {

            this.name = name;
            this.runs = runs;
            this.wickets = wickets;
            this.strikeRate = strikeRate;
            this.economy = economy;
        }

        public Player(String name, int runs, int wickets) {
            this(name, runs, wickets, 0.0, 0.0);
        }

        public String getName() {
            return name;
        }

        public int getRuns() {
            return runs;
        }

        public int getWickets() {
            return wickets;
        }

        public double getStrikeRate() {
            return strikeRate;
        }

        public double getEconomy() {
            return economy;
        }

        public boolean isDraftable() {

            return runs >= 100
                    && wickets >= 5
                    && strikeRate >= 120
                    && economy <= 8.0;
        }

        @Override
        public int compareTo(Player other) {

            if (this.runs != other.runs) {
                return Integer.compare(other.runs, this.runs);
            }

            if (this.wickets != other.wickets) {
                return Integer.compare(other.wickets, this.wickets);
            }

            return Double.compare(other.strikeRate, this.strikeRate);
        }

        @Override
        public String toString() {

            return name
                    + " | Runs: " + runs
                    + " | Wickets: " + wickets
                    + " | Strike Rate: " + strikeRate
                    + " | Economy: " + economy
                    + " | Draftable: " + isDraftable();
        }
    }

    public static void sortPlayers(Player[] players) {
        Arrays.sort(players);
    }

    public static void sortPlayers(Player[] players, boolean onlyDraftable) {

        if (!onlyDraftable) {
            Arrays.sort(players);
            return;
        }

        Player[] draftablePlayers = new Player[players.length];
        int count = 0;

        for (Player player : players) {
            if (player.isDraftable()) {
                draftablePlayers[count] = player;
                count++;
            }
        }

        Player[] result = new Player[count];

        for (int i = 0; i < count; i++) {
            result[i] = draftablePlayers[i];
        }

        Arrays.sort(result);

        for (int i = 0; i < result.length; i++) {
            players[i] = result[i];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.println("Enter details for Player " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Runs: ");
            int runs = sc.nextInt();

            System.out.print("Wickets: ");
            int wickets = sc.nextInt();

            System.out.print("Strike Rate: ");
            double strikeRate = sc.nextDouble();

            System.out.print("Economy: ");
            double economy = sc.nextDouble();

            sc.nextLine();

            players[i] = new Player(
                    name,
                    runs,
                    wickets,
                    strikeRate,
                    economy
            );
        }

        System.out.println("\nAll Players - Ranked:");

        sortPlayers(players);

        for (Player player : players) {
            System.out.println(player);
        }

        System.out.println("\nDraftable Players:");

        for (Player player : players) {
            if (player.isDraftable()) {
                System.out.println(player);
            }
        }

        sc.close();
    }
}