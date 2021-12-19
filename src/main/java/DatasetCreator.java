import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DatasetCreator {

    public Map<String, Song> getSongs() {
        return songs;
    }

    private final Map<String, Song> songs = new LinkedHashMap<>();

    public void listToSongs() {

        List<List<String>> lines = readCSV();
        for (List<String> line : lines.subList(1, lines.size())) {
            // skip first line
            Song song = Song.lineToSong(line);
            songs.put(song.getId(), song);


        }
    }

    public List<List<String>> readCSV() {
        List<List<String>> csvLines = new ArrayList<List<String>>();
        try (CSVReader csvReader = new CSVReader(new FileReader("genres_v2.csv"));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                csvLines.add(Arrays.asList(values));
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        return csvLines;
    }
}
