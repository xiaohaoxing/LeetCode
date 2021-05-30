package nowcoder.decodeString;

/**
 * @author 肖皓星
 */
public class Solution {
    public String decode(String raw) {
        int[] numberStack = new int[raw.length()];
        String[] contentStack = new String[raw.length()];
        int numberIndex = 0;
        int contentIndex = 0;

        StringBuilder currentNumber = new StringBuilder();
        StringBuilder currentContent = new StringBuilder();
        for (int j = 0; j < raw.length(); j++) {
            char c = raw.charAt(j);
            if (c <= '9' && c >= '0') {
                if (currentContent.length() > 0) {
                    contentStack[contentIndex++] = currentContent.toString();
                    currentContent = new StringBuilder();
                }
                currentNumber.append(c);
            } else if (c == '[') {
                numberStack[numberIndex++] = Integer.parseInt(currentNumber.toString());
                currentNumber = new StringBuilder();
            } else if (c == ']') {
                contentStack[contentIndex++] = currentContent.toString();
                currentContent = new StringBuilder();
                String content = contentStack[--contentIndex];
                int times = numberStack[--numberIndex];
                StringBuilder timesContent = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    timesContent.append(content);
                }
                contentStack[contentIndex] = timesContent.toString();

            } else {
                currentContent.append(c);
            }
        }
        if (currentContent.length() > 0) {
            contentStack[contentIndex++] = currentContent.toString();
            currentContent = new StringBuilder();
        }
        // 遍历乘数
        while (numberIndex > 0) {
            String content = contentStack[--contentIndex];
            int times = numberStack[--numberIndex];
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < times; i++) {
                result.append(content);
            }
            contentStack[contentIndex++] = result.toString();
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < contentIndex; i++) {
            result.append(contentStack[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String data = "3[a2[c]]";
        Solution test = new Solution();
        System.out.println(test.decode(data));
    }
}
