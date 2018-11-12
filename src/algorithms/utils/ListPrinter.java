package algorithms.utils;

public class ListPrinter {

    public static void printArray(Object[] list) {
        StringBuilder sb = new StringBuilder("[list: ");
        for (Object o : list) {
            sb.append(o + ",");
        }
        String result = sb.toString();
        System.out.println(result.substring(0, result.length() - 2) + "]");
    }

    public static void printArray(int[] list) {
        StringBuilder sb = new StringBuilder("[list: ");
        for (int o : list) {
            sb.append(o + ",");
        }
        String result = sb.toString();
        System.out.println(result.substring(0, result.length() - 3) + "]");
    }
}
