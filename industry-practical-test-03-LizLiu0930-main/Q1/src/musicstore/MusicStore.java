package musicstore;

import java.io.*;
import java.util.*;

/**
 * This the application for running the music store.
 * TODO step c. - step j. modify this class appropriately
 *
 * @author Write your UPI here
 */
public class MusicStore {

    // This is the main method. Do not change this!
    public static void main(String[] args) {
        new MusicStore().start();
    }

    // This is the start method. Do not change this!
    private void start() {
        System.out.println("Welcome to the Auckland ICT Music Store");
        System.out.println("===============================");

        List<Album> albums = getAlbums("albums.csv");

        System.out.println("We have a total number of " + albums.size() + " albums available in store.");
        System.out.println("--------------------------------------------");
        System.out.println("Here is a quick summary of what we have in store for you :)");
        System.out.println("--------------------------------------------");
        System.out.println("Albums in 1960s: " + getTotalByPeriod(albums, MusicTime.SIXTIES));
        System.out.println("Albums in 1970s: " + getTotalByPeriod(albums, MusicTime.SEVENTIES));
        System.out.println("Albums in 1980s: " + getTotalByPeriod(albums, MusicTime.EIGHTIES));
        System.out.println("Albums in 1990s: " + getTotalByPeriod(albums, MusicTime.NINETIES));
        System.out.println("Albums in 21st century: " + getTotalByPeriod(albums, MusicTime.TWENTY_FIRST_CENTURY));
        System.out.println("--------------------------------------------");
        System.out.println("Exporting album information to a file was " +
                (exportAlbumsToFile(albums, "albumSummary.txt") ? "successful!" : "not successful :("));

        System.out.println("--------------------------------------------");
        System.out.println("Top 15 Highest-Number-of-Tracks albums in store");
        System.out.println("--------------------------------------------");
        printTopNumTrackAlbums(albums);
        System.out.println("--------------------------------------------");

        int year = 0;
        while (true) {
            try {
                year = getUserTimePeriodChoice();
                break;
            } catch (TimePeriodInvalidException e) {
                e.getMessage();
            }
        }

        System.out.println("--------------------------------------------");
        printAlbumsByPeriod(albums, getPeriod(year));


    }


    /**
     * Creates an album based on the given information.
     * Do not modify this method!
     *
     * @param albumInfo String array containing information about an album1
     * @return an album object
     */
    private Album createAlbum(String[] albumInfo) {
        int id = Integer.parseInt(albumInfo[0]);
        String album = albumInfo[1];
        String genre = albumInfo[2];
        String artist = albumInfo[3];
        MusicTime period = getPeriod(Integer.parseInt(albumInfo[4]));
        int tracks = Integer.parseInt(albumInfo[5]);
        int discs = Integer.parseInt(albumInfo[6]);
        return new Album(id, album, genre, artist, period, tracks, discs);
    }

    //TODO step c. complete the getPeriod method
    private MusicTime getPeriod(int year) {

        if(year >= 1960 && year <= 1969) return MusicTime.SIXTIES;
        else if(year >= 1970 && year <= 1979) return MusicTime.SEVENTIES;
        else if(year >= 1980 && year <= 1989) return MusicTime.EIGHTIES;
        else if(year >= 1990 && year <= 1999) return MusicTime.NINETIES;
        else if(year >= 2000 && year <= 2015) return MusicTime.TWENTY_FIRST_CENTURY;

        return null;

    }


    // TODO step d. complete the getAlbums method
    private List<Album> getAlbums(String filePath) {

        List<Album> albumList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] albumInfo = line.split(";");

                Album album = createAlbum(albumInfo);
                albumList.add(album);
            }

            } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    // TODO step e. complete the getTotalByPeriod method
    private int getTotalByPeriod(List<Album> albums, MusicTime period) {

        int count = 0;

        for(Album album : albums) {

            if (album.getPeriod()==period) {
                count++;
            }
        }

        return count;

    }

    // TODO step f. complete the exportAlbumsToFile method
    private boolean exportAlbumsToFile(List<Album> albums, String filePath) {

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            for(Album album : albums){

                bw.write(album.toString());
                bw.write("\n");

            }
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // TODO step g. complete printTopNumTrackAlbums method
    private void printTopNumTrackAlbums(List<Album> albums) {


        Comparator<Album> albumComparator = new Comparator<Album>() {

            @Override
            public int compare(Album o1, Album o2) {
                return o2.getTracks() - o1.getTracks();
            }

        };
        Collections.sort(albums, albumComparator);

        for (int i = 0; i < 15; i++) {

            System.out.println(albums.get(i).highestNumberOfTracks());

        }

    }


    // TODO step h. complete the validatePeriod method
    private int validatePeriod(String yearInput) throws TimePeriodInvalidException{

        if (yearInput == "") {
            throw new TimePeriodInvalidException("Empty Input");
        }

        return Integer.parseInt(yearInput);
    }

    // TODO step i. modify the getUserTimePeriodChoice method
    private int getUserTimePeriodChoice() throws TimePeriodInvalidException{
        while (true) {
            System.out.print("Please enter a time between 1960 - 2015: ");
            int year = validatePeriod(Keyboard.readInput());

            if( year < 1960){
                throw new TimePeriodInvalidException("Too old!");
            }
            else if(year > 2015) {
                throw new TimePeriodInvalidException("Too new!");
            }
            else {
                return year;
            }

        }
    }

    // TODO step j. complete the printAlbumsByPeriod method
    private void printAlbumsByPeriod(List<Album> albums, MusicTime period) {

        System.out.println(String.format("All available %s albums:", period));

        for(Album album:albums) {
            if(album.getPeriod()==period) {
                System.out.println(album.toString());
            }
        }


    }


}
