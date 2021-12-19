import junit.runner.Sorter;

import java.util.Comparator;
import java.util.List;

public class Quicksort<Song> extends Sorter {

    /**
     * Sorts all items by quick sort using the provided comparator for deciding
     * relative ordening of two items Items are sorted 'in place' without use of an
     * auxiliary list or array
     *
     * @return the items sorted in place
     */
    public List<Song> quickSort(List<Song> items, Comparator<Song> comparator) {
        // sort the complete list of items from position 0 till size-1, including
        // position size
        this.quickSortPart(items, 0, items.size() - 1, comparator);
        return items;
    }


    /**
     * Sorts all items between index positions 'from' and 'to' inclusive by quick
     * sort using the provided comparator for deciding relative ordening of two
     * items Items are sorted 'in place' without use of an auxiliary list or array
     * or other positions in items
     * <p>
     * // create pivot from the middle of the list
     * E pivot = items.get((F + T) / 2);
     */
    private void quickSortPart(List<Song> items, int from, int to, Comparator<Song> comparator) {

        // quick sort the sublist of items between index positions 'from' and 'to'
        // inclusive
        int F = from;
        int T = to;

        if (T > F) {
            // create pivot from the middle of the list
            Song pivot = medianOfThree(items, F, T, comparator);
            while (F <= T) {
                //
                while (F < to && comparator.compare(items.get(F), pivot) < 0) {
                    F += 1;
                }
                while (T > from && comparator.compare(items.get(T), pivot) > 0) {
                    T -= 1;
                }
                if (F <= T) {
                    swap(items, F, T);
                    F += 1;
                    T -= 1;
                }
            }
        }

        if (from < T) {
            quickSortPart(items, from, T, comparator);
        }
        if (F < to) {
            quickSortPart(items, F, to, comparator);
        }

    }

    void swap(List<Song> arr, int from, int to) {
        Song F = arr.get(from);
        arr.set(from, arr.get(to));
        arr.set(to, F);
    }

    Song medianOfThree(List<Song> list, int left, int right, Comparator<Song> comparator) {

        int center = (left + right) / 2;
        if (comparator.compare(list.get(center), list.get(left)) < 0)
            swap(list, left, center);
        if (comparator.compare(list.get(right), list.get(left)) < 0)
            swap(list, left, right);
        if (comparator.compare(list.get(right), list.get(center)) < 0)
            swap(list, center, right);

        return list.get(center);
    }


}
