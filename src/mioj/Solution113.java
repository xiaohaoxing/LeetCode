package mioj;

public class Solution113 {
    private static String solution(String line) {
        String[] pieces = line.split(" ");
        int[] enemies = new int[pieces.length];
        for (int i = 0; i < pieces.length; i++) {
            enemies[i] = Integer.parseInt(pieces[i]);
        }
        int count = 1;                  //总共使用次数。
        boolean hasAlive;        //是否仍有存活的。
        boolean killed;         //这一轮是否杀死了。
        while (true) {
            hasAlive = false;
            killed = false;
            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] == 1 || enemies[i] == 2) {
                    killed = true;
                } else if (enemies[i] > 2) {
                    hasAlive = true;
                }
                enemies[i] -= 2;
            }
            if (!hasAlive) {
                break;
            }
            if (!killed) {
                count++;
            }
        }
        return "" + count;
    }

    public static void main(String[] args) {
        String line = "1 2 3 4 10";
        String result = solution(line);
        System.out.println(result);
    }

}
