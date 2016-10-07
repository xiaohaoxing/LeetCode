package newcode;

import java.util.Scanner;

/**
 * Created by Lenovo on 16.9.27.
 */
public class Order {
    public void order() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int count = Integer.parseInt(in.nextLine());
            int type = Integer.parseInt(in.nextLine());
            Score[] score = new Score[count];
            for (int i = 0; i < count; i++) {
                String[] line = in.nextLine().split(" ");
                score[i] = new Score(line[0], Integer.parseInt(line[1]));
            }
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < i; j++) {
                    swap(i, j, type, score);
                }
            }
            for (int i = 0; i < count; i++) {
                System.out.println(score[i].name + " " + score[i].score);
            }
        }
    }

    public void swap(int i, int j, int type, Score[] scores) {
        if (type == 0) {
            //从高到低
            if (scores[i].score > scores[j].score) {
                Score tmp = scores[i];
                scores[i] = scores[j];
                scores[j] = tmp;
            }
        } else if (type == 1) {
            //从低到高
            if (scores[i].score < scores[j].score) {
                Score tmp = scores[i];
                scores[i] = scores[j];
                scores[j] = tmp;
            }
        }
    }

    public static void main(String args[]) {
        Order test = new Order();

        test.order();
    }
}

class Score {
    public String name;
    public int score;

    public Score(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
