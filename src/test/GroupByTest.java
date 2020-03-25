package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 肖皓星
 * @email xiaohaoxing@outlook.com
 */
public class GroupByTest {

    public static void main(String[] args) {
        Goods a1 = new Goods("a", 10);
        Goods a2 = new Goods("a", 20);
        Goods b = new Goods("b", 10);
        List<Goods> list = Arrays.asList(a1, a2, b);
        List<Goods> result = new ArrayList<>(list.stream().collect(Collectors.toMap(Goods::getSku, Function.identity(), (x, y) -> {
            x.count = x.getCount() + y.getCount();
            return x;
        })).values());
        System.out.println(result.size());
    }

}

class Goods {
    Goods(String sku, int count) {
        this.sku = sku;
        this.count = count;
    }

    public String sku;
    public int count;

    public String getSku() {
        return sku;
    }

    public int getCount() {
        return count;
    }

}