import java.util.Map;

public class SpeedCheckerMain {

    public static void main(String[] args) {

        DatasetCreator datasetCreator = new DatasetCreator();
        Quicksort<Song> sorter = new Quicksort<Song>();

        datasetCreator.listToSongs();
        Map<String, Song> songs = datasetCreator.getSongs();

        // just checking the songs list
        System.out.println((long) songs.values().size());

        // TODO measure time
        //sorter.quickSort(songs, //TODO comperator);

        // TODO parallel quicksort

    }
}
