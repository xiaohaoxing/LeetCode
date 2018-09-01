package algorithms.problem13;

import java.util.HashMap;

public class Solution {
    public static HashMap<Character, Integer> map = new HashMap<>();
    static{
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D',500);
        map.put('M', 1000);
    }
    public int romanToInt(String s) {
        int number = 0;
        int current = 0;
        char[] chars = s.toCharArray();
        for(int i = chars.length-1; i >= 0; i--) {
            int value = map.get(chars[i]);
            if(value >= current){
                number+=value;
                current = value;
            }else{
                number-=value;
            }
        }
        return number;
    }

    public static void main(String[] args){
        String roman = "MCMXCIV";
        Solution sol = new Solution();
        System.out.println(sol.romanToInt(roman));
    }
}
