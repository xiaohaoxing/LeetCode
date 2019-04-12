package test;

public class Logger {

    public static void log(String str, Object... blocks) {
        String replacement = str;
        int index = 0;
        while (index < blocks.length) {
            replacement = replacement.replace("{}", blocks[index].toString());
            index++;
        }
        System.out.println(replacement);
    }

    public static void main(String[] args) {
        log("{}'s name is {}", "xiaoming", "xiaoming");
    }
}
