package ro.cineseuita.shared;

import java.util.ArrayList;
import java.util.List;

public class ListManipulator {

    public static <T> List<List<T>> chunks(List<T> list, int numberOfParts) {
        int initialSize = numberOfParts;
        List<List<T>> numberOfPartss = new ArrayList<>(numberOfParts);
        int size = list.size();
        int sizePernumberOfParts = (int) Math.ceil(((double) size) / numberOfParts);
        int leftElements = size;
        int i = 0;
        while (i < size && numberOfParts != 0) {
            numberOfPartss.add(list.subList(i, i + sizePernumberOfParts));
            i = i + sizePernumberOfParts;
            leftElements = leftElements - sizePernumberOfParts;
            sizePernumberOfParts = (int) Math.ceil(((double) leftElements) / --numberOfParts);
        }
        while (numberOfPartss.size() < initialSize) {
            numberOfPartss.add(new ArrayList<>());
        }
        return numberOfPartss;
    }
}
