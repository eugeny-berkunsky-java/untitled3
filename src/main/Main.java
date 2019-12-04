package main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        double[] nums = {1.1, 1000.35, -12.1, -100.34, 10.8, 11.7, -100000};
        Queue<Double> q = new PriorityQueue<>(Comparator.comparingDouble(Math::abs));
        for (double v : nums) {
            q.add(v);
        }
        while (q.size()>1) {
            q.offer(q.poll() + q.poll());
        }
        System.out.println(q.poll());
        double sum = 0;
        for (double v : nums) {
            sum += v;
        }
        System.out.println("sum = " + sum);
    }

    private void run6() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("sonnet1.txt"))) {
            List<String> list = reader.lines().collect(Collectors.toList());
            list.sort(Comparator.comparingInt(String::length));
            list.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void run4() {
        String s = "C:\\Users\\eberk\\IdeaProjects\\TrackEnsure\\untitled3";
        List<String> names = new ArrayList<>();
        File file = new File(s);
        scan(file, names);
        names.forEach(System.out::println);
    }

    private void scan(File file, List<String> names) {
        if (file.isFile()) names.add(file.getName());
        else if (file.isDirectory()){
            names.add(file.getName());
            File[] files = file.listFiles();
            for (File f : files) {
                scan(f, names);
            }
        }
    }

    private void run2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (n>0) {
            int r = n % 10;
            stack.push(r);
            n /= 10;
        }
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop());
        }
        System.out.println();
    }

    private void run1() {
        try (BufferedReader reader = new BufferedReader(new FileReader("f.txt"));
            PrintWriter writer = new PrintWriter("g.txt")) {
            List<String> list = new ArrayList<>();
            String line;
            while ((line = reader.readLine())!=null) {
                list.add(line);
            }
            while (!list.isEmpty()) {
                writer.println(list.get(list.size() - 1));
                list.remove(list.size()-1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
