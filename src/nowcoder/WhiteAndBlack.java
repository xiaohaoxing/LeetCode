package nowcoder;

import java.util.*;

public class WhiteAndBlack {


    public static void main(String[] args) {

        TreeMap<Integer, Integer> odd = new TreeMap<>();
        TreeMap<Integer, Integer> even = new TreeMap<>();
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        String[] sizes = firstLine.split(" ");
        int x = Integer.parseInt(sizes[0]);
        int y = Integer.parseInt(sizes[1]);
        int count = x * y;
        for (int i = 0; i < x; i++) {
            String line = in.nextLine();
            String[] elements = line.split(" ");
            for (int j = 0; j < y; j++) {
                int current = Integer.parseInt(elements[j]);
                if ((i + j) % 2 == 0) {
                    // even
                    if (even.containsKey(current)) {
                        int value = even.get(current);
                        even.replace(current, value + 1);
                    } else {
                        even.put(current, 1);
                    }
                } else {
                    // odd
                    if (odd.containsKey(current)) {
                        int value = odd.get(current);
                        odd.replace(current, value + 1);
                    } else {
                        odd.put(current, 1);
                    }
                }
            }
        }
        Map.Entry[] odds = findBigest(odd);
        Map.Entry[] evens = findBigest(even);
        if(odds[0].getKey() == evens[0].getKey()) {

        }

    }

    public static Map.Entry<Integer, Integer>[] findBigest(Map<Integer, Integer> map) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return new Map.Entry[]{list.get(0), list.get(1)};
    }

}
