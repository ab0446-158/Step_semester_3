import java.util.Arrays;
import java.util.Scanner;

public class Playlist {

    private String[] songs;
    private int songCount;

    public Playlist(int maxSize) {
        songs = new String[maxSize];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum playlist size: ");
        int maxSize = sc.nextInt();
        sc.nextLine();

        Playlist p = new Playlist(maxSize);

        System.out.print("Enter number of songs: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter song " + (i + 1) + ": ");
            p.addSong(sc.nextLine());
        }

        String[] copy = p.getSongs();

        System.out.println("Songs: " + Arrays.toString(copy));
        System.out.println("Song Count: " + p.getSongCount());

        // Test that modifying the returned array does not affect the playlist
        if (copy.length > 0) {
            copy[0] = "Hacked";
        }

        System.out.println("After modifying copy: "
                + Arrays.toString(p.getSongs()));

        sc.close();
    }
}