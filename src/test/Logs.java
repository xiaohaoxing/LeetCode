package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Logs {
    public String raw;
    private Method method;
    private String url;
    private String path;
    private String basePath;
    private Dictionary<String, String> args;

    public String getPath() {
        return path;
    }
    public String getBasePath() {return basePath;}
    public String parseBasePath(String path) {
        return path.split("/")[1];
    }

    public Dictionary<String, String> getArgs() {
        return args;
    }

    public Logs(String raw) {
        this.raw = raw;
        // parse the url into path and args
        try {
            String[] strs = raw.split(" ");
            method = parseMethod(strs[0]);
            url = strs[1];
            path = parsePath(url);
            args = parseArgs(url);
            basePath = parseBasePath(path);
        } catch (Exception e) {
            System.err.println("Error while parsing:" + raw);
            System.err.println("\t\tError type:" + e.getClass().getName());
        }

    }

    public static Method parseMethod(String raw) {
        switch (raw.toUpperCase()) {
            case "POST":
                return Method.post;
            case "GET":
                return Method.get;
            // new methods here:
            default:
                return Method.unknown;
        }
    }

    public static String parsePath(String url) {
        return url.split("[?]")[0];
    }

    public static Dictionary<String, String> parseArgs(String url) {
        Dictionary<String, String> result = new Hashtable<>();
        // 问号出现在最后的时候，split 得到的结果不包括最后一个空字符串。
        if (!url.contains("?") || url.split("[?]").length == 1) {
            return result;
        } else {
            String argsStr = url.split("[?]")[1];
            // parse the args
            String[] args = argsStr.split("&");
            for (String arg : args) {
                String[] pair = arg.split("=");
                result.put(pair[0], pair[1]);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
//        Logs log = new Logs("GET /location/getOneAuthCity.htm?");
//        System.out.println("hh");

        List<Logs> list = new LinkedList<>();
        String line;
        System.out.println("【读取文件中。。。】");
        BufferedReader reader = new BufferedReader(new FileReader(new File("/Users/haoxingxiao/Desktop/access.log")));
        while (true) {
            line = reader.readLine();
            if (line == null || line == "\n") {
                break;
            }
            list.add(new Logs(line));
        }
        // process the list:
        System.out.println("【文件读取完成，开始分析：】");

        // 1. 请求总量
        System.out.println("1. 请求总量：");
        System.out.println(list.size());
        System.out.println("2. 请求最频繁的 10 个接口，及其相应的请求数量：");
        // 2. 请求最频繁的 10 个接口，及其相应的请求数量
        Map<String, Long> count = list.stream().collect(Collectors.groupingBy((Logs::getPath), Collectors.counting()));
        Map<String, Long> sortedCount = new LinkedHashMap<>();
        count.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(10).forEachOrdered(e -> sortedCount.put(e.getKey(), e.getValue()));
        sortedCount.forEach((k, v) -> System.out.println("[" + v + "]" + ":" + k));
        // 3. Post 和 Get 请求分别是多少
        System.out.println("3. POST 和 GET 请求分别是多少：");
        int[] counts = new int[2];  // 0 : get count, 1: post count
        list.forEach((Logs log) -> {
            if (log.method == Method.get) counts[0]++;
            else if (log.method == Method.post) counts[1]++;
        });
        System.out.println("[POST]:" + counts[1]);
        System.out.println("[GET]:" + counts[0]);
        // 4. 输出各个 URL 下的类别都有哪些
        System.out.println("4. 输出各个 URL 下的类别都有哪些:");
        Map<String, HashSet<String>> types = new LinkedHashMap();
        for (Logs log : list) {
            if (types.containsKey(log.getBasePath())) {
                types.get(log.getBasePath()).add(log.path);
            } else {
                HashSet<String> set = new HashSet<>();
                set.add(log.getBasePath());
                types.put(log.getBasePath(), set);
            }
        }
            // print:
        types.forEach((k, v)->{
            System.out.println("[" + k + "]开头的 URL 有：");
            for(String url:v) {
                System.out.println("\t" + url);
            }
        });

    }
}

enum Method {
    post,
    get,
    unknown,
}