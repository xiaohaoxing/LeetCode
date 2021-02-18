package machineLearning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CalGain {
    public static void main(String[] args) {
        Boolean[] isGoods = new Boolean[]{true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, false, false};
        Double[] densities = new Double[]{0.697, 0.774, 0.634, 0.608, 0.556, 0.403, 0.481, 0.437, 0.666, 0.243, 0.245, 0.343, 0.639, 0.657, 0.360, 0.593, 0.719};
        List<Watermelon> melons = new ArrayList<>();
        for (int i = 0; i < isGoods.length; i++) {
            melons.add(new Watermelon(isGoods[i], densities[i]));
        }
        Collections.sort(melons, (a, b) -> (int) ((a.density - b.density) * 1000));

        Double[] threaholds = new Double[melons.size() - 1];
        Watermelon[] melonList = (Watermelon[]) melons.toArray(new Watermelon[0]);
        for (int i = 0; i < melonList.length - 1; i++) {
            threaholds[i] = (melonList[i + 1].density + melonList[i].density) / 2;
        }
        int size = melonList.length;
        Double[] gainIndex = new Double[threaholds.length];
        Double originGain = calGain(melons);
        for (int i = 0; i < threaholds.length; i++) {
            final int index = i;
            List<Watermelon> lessList = melons.stream().filter(m -> m.density <= threaholds[index]).collect(Collectors.toList());
            List<Watermelon> greaterList = melons.stream().filter(m -> m.density > threaholds[index]).collect(Collectors.toList());
            Double leftGain = (lessList.size() * 1.0 / size) * calGain(lessList);
            Double rightGain = (greaterList.size() * 1.0 / size) * calGain(greaterList);
            System.out.println(String.format("阈值为%f时，左边信息熵为：%f，右边信息熵为：%f。", threaholds[i], leftGain, rightGain));
            Double gain = originGain - leftGain - rightGain;
            gainIndex[index] = gain;
        }

        for (int i = 0; i < gainIndex.length; i++) {
            System.out.println(String.format("gain with threahold:%f is %f", threaholds[i], gainIndex[i]));
        }
    }

    public static Double calGain(List<Watermelon> list) {
        Double goodRatio = list.stream().filter(Watermelon::getGood).count() * 1.0 / list.size();
        return calEntropy(goodRatio) + calEntropy(1 - goodRatio);
    }

    private static Double calEntropy(Double value) {
        if (value > -0.001 && value < 0.001) {
            return 0.0;
        }
        return -((Math.log(value) / Math.log(2)) * value);
    }
}

class Watermelon {
    Boolean isGood;

    Double density;

    public Watermelon(Boolean isGood, Double density) {
        this.isGood = isGood;
        this.density = density;
    }

    public Boolean getGood() {
        return isGood;
    }

    @Override
    public String toString() {
        return "[Melon]:density:" + density + ",isGood:" + (isGood ? "是" : "否");
    }
}

