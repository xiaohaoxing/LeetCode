package algorithms.solution706;

/**
 * version 1: no threshold, no order, query with traverse
 */
public class MyHashMap {

    private final int init_size = 8;
    private int size;

    private int[] keys;

    private int[] values;

    public MyHashMap() {
        size = 0;
        keys = new int[init_size];
        values = new int[init_size];
    }

    public void put(int key, int value) {
        if (size == keys.length) {
            //expand
            int[] newKeys = new int[keys.length * 2];
            int[] newValues = new int[values.length * 2];
            for (int i = 0; i < size; i++) {
                newKeys[i] = keys[i];
                newValues[i] = values[i];
            }
            keys = newKeys;
            values = newValues;
        }
        // try udpate
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public int get(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                return values[i];
            }
        }
        return -1;
    }

    public void remove(int key) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == key) {
                for (int j = i + 1; j < size; j++) {
                    keys[j - 1] = keys[j];
                    values[j - 1] = values[j];
                }
                keys[size-1] = 0;
                values[size-1] = 0;
                size--;
                break;
            }
        }
        if (size < keys.length / 2 && keys.length > init_size) {
            // shrink
            int[] newKeys = new int[keys.length / 2];
            int[] newValues = new int[values.length / 2];
            for (int i = 0; i < size; i++) {
                newKeys[i] = keys[i];
                newValues[i] = values[i];
            }
            keys = newKeys;
            values = newValues;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        String[] ops = new String[]{"MyHashMap", "get", "put", "put", "put", "remove", "put", "put", "put", "get", "put", "put", "put", "put", "get", "put", "get", "put", "put", "put", "put", "remove", "put", "put", "put", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "put", "remove", "put", "remove", "put", "remove", "put", "remove", "put", "put", "put", "remove", "put", "put", "put", "put", "get", "put", "put", "put", "get", "remove", "put", "put", "put", "put", "remove", "put", "put", "put", "get", "put", "put", "get", "get", "put", "put", "put", "put", "put", "put", "put", "put", "get", "put", "put", "put", "get", "get", "remove", "remove", "put", "get", "get", "put", "get", "put", "put", "get"};
        int[][] params = new int[][]{{}, {79}, {72, 7}, {77, 1}, {10, 21}, {26}, {94, 5}, {53, 35}, {34, 9}, {94}, {96, 8}, {73, 79}, {7, 60}, {84, 79}, {94}, {18, 13}, {18}, {69, 34}, {21, 82}, {57, 64}, {23, 60}, {0}, {12, 97}, {56, 90}, {44, 57}, {30, 12}, {17, 10}, {42, 13}, {62, 6}, {34}, {70, 16}, {51, 39}, {22, 98}, {82, 42}, {84, 7}, {29, 32}, {96, 54}, {57, 36}, {85, 82}, {49, 33}, {22, 14}, {63, 8}, {56, 8}, {94}, {78, 77}, {51}, {20, 89}, {51}, {9, 38}, {20}, {29, 64}, {92, 69}, {72, 25}, {73}, {6, 90}, {1, 67}, {70, 83}, {58, 49}, {79}, {73, 2}, {56, 16}, {58, 26}, {53}, {7}, {27, 17}, {55, 40}, {55, 13}, {89, 32}, {49}, {75, 75}, {64, 52}, {94, 74}, {81}, {39, 82}, {47, 36}, {57}, {66}, {3, 7}, {54, 34}, {56, 46}, {58, 64}, {22, 81}, {3, 1}, {21, 96}, {6, 19}, {77}, {60, 66}, {48, 85}, {77, 16}, {78}, {23}, {72}, {27}, {20, 80}, {30}, {94}, {74, 85}, {49}, {79, 59}, {15, 15}, {26}};
        for (int i = 0; i < ops.length; i++) {
            Integer result = null;
            switch (ops[i]) {
                case "MyHashMap": new MyHashMap();break;
                case "get": result = map.get(params[i][0]);break;
                case "put":
                    map.put(params[i][0], params[i][1]);
                    result = null;
                    break;
                case "remove": map.remove(params[i][0]);break;
            }
            System.out.print(result + ",");
        }
    }
}
