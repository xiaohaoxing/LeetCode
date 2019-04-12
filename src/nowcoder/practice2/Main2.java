package nowcoder.practice2;

import java.util.HashSet;

public class Main2 {
    public static void main(String[] args) {
        HashSet<Integer> values = new HashSet<>();
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 4; j++) {
                for (int k = 0; k <= 6; k++) {
                    values.add(i * 8 + j * 10 + k * 18);
                }
            }
        }
        System.out.println(values.size() - 1);
    }
}
