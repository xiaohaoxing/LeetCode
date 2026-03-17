package algorithms.utils;

import java.util.List;

public class ListPrinter {

    public static void printArray(Object[] list) {
        StringBuilder sb = new StringBuilder("[list: ");
        for (Object o : list) {
            sb.append(o + ",");
        }
        String result = sb.toString();
        System.out.println(result.substring(0, result.length() - 1) + "]");
    }

    public static void printArray(int[] list) {
        StringBuilder sb = new StringBuilder("[list: ");
        for (int o : list) {
            sb.append(o + ",");
        }
        String result = sb.toString();
        System.out.println(result.substring(0, result.length() - 1) + "]");
    }

    public static void printList(List<?> list) {
        StringBuilder sb = new StringBuilder("[list: ");
        for (Object o : list) {
            if (o instanceof List) {
                printList((List) o);
            } else {
                sb.append(o + ",");
            }
        }
        String result = sb.toString();
        System.out.println(result.substring(0, result.length() - 1) + "]");
    }

    public static <T> void printTable(T[][] table) {
        System.out.println("[");
        for (T[] row : table) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < row.length; i++) {
                sb.append(row[i]);
                if (i != row.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            System.out.println(sb);
        }
        System.out.println("]");
    }

}
