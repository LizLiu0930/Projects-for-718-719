package musicstore;

/**
 * This class is used for storing each album entry.
 *
 * @author Vita
 *
 */
public class Album {
    private int id;
    private String genre;
    private String artist;
    private String title;
    private MusicTime period;
    private int tracks;
    private int discs;

    public Album(int id, String title, String genre, String artist,  MusicTime period, int tracks, int discs) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.artist = artist;
        this.period = period;
        this.tracks = tracks;
        this.discs = discs;
    }

    public int getId() {
        return id;
    }

    public String getGenre() {
        return genre;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public MusicTime getPeriod() {
        return period;
    }

    public int getTracks() {
        return tracks;
    }

    public int getDiscs() {
        return discs;
    }

    @Override
    public String toString() {
        return String.format("%s, \"%s\", %s, %s", artist, title, genre, period.toString().toLowerCase());
    }

    public String highestNumberOfTracks(){
        return String.format("%s, %s, tracks: %d", title, genre.toUpperCase(), tracks);
    }


}
