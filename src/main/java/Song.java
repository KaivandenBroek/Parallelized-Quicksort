import java.util.List;

public class Song {

    private final static int DANCEABILITY = 0;
    private final static int ENERGY = 1;
    private final static int ID = 13;
    private final static int DURATION_MS = 17;
    private final static int GENRE = 19;
    private final static int NAME = 20;

    private final String id;

    private double danceability;
    private double energy;
    private int duration;
    private String name;
    private String genre;

    public Song(String id) {
        this.id = id;
    }

    public static Object getSong(String id) {
        return new Song(id);
    }

    public static Song lineToSong(List<String> line) {
        String[] fields = line.toArray(new String[0]);

        final Song song = new Song(fields[ID]);

        song.setDancebility(Double.parseDouble(fields[DANCEABILITY]));
        song.setEnergy(Double.parseDouble(fields[ENERGY]));
        song.setGenre(fields[GENRE]);
        song.setName(fields[NAME]);
        song.setDuration(Integer.parseInt(fields[DURATION_MS]));

        return song;
    }

    public String getId() {
        return id;
    }

    public double getDancebility() {
        return danceability;
    }

    public void setDancebility(double danceability) {
        this.danceability = danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
