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
            sb.append(o + ",");
        }
        String result = sb.toString();
        System.out.println(result.substring(0, result.length() - 1) + "]");
    }

    public static void printTable(char[][] table) {
        System.out.print("[");
        for (char[] list : table) {
            StringBuilder sb = new StringBuilder("[");
            for (char c : list) {
                sb.append(c + ",");
            }
            System.out.println(sb.subSequence(0, sb.length() - 1) + "]");
        }
        System.out.println("]");
    }
}
