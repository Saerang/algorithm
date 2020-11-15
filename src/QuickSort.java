import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {

    public static List<Integer> quickSort(List<Integer> list) {
        if (list.size() <= 1) return list;
        int pivot = list.get(list.size() / 2);

        List<Integer> lesserArr = new LinkedList<>();
        List<Integer> equalArr = new LinkedList<>();
        List<Integer> greaterArr = new LinkedList<>();

        for (int num : list) {
            if (num < pivot) lesserArr.add(num);
            else if (num > pivot) greaterArr.add(num);
            else equalArr.add(num);
        }

        return Stream.of(quickSort(lesserArr), equalArr, quickSort(greaterArr))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> data = quickSort(new LinkedList<>(Arrays.asList(10, 20, 5, 7)));

        data.forEach(q -> System.out.print(q + ", "));
    }
}
