package test;

import com.sun.deploy.util.ArrayUtil;
import com.sun.glass.ui.Size;

import java.sql.SQLOutput;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        Integer[] red = getRed(2);
        System.out.println(Arrays.toString(red));
        Integer[] blue = getBlue(2);
        Integer[] merger = new Integer[red.length + blue.length];
        System.arraycopy(red,0 , merger, 0, red.length);
        System.arraycopy(blue,0 , merger, red.length, blue.length);
        List<String> collect = Arrays.stream(merger).map(p -> p.toString()).collect(Collectors.toList());
        String join = String.join(",",collect);
        System.out.println(join);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name","张三" );
        hashMap.put("age","18" );
        String[] add = {"1","2"};
        List<String> strings = new ArrayList<>(Arrays.asList(add));
        strings.add("3");
        add = strings.toArray(new String[0]);
        System.out.println(Arrays.toString(add));
//        List<String> collect = hashMap.keySet().stream().map(p -> "?").collect(Collectors.toList());
//        String join = String.join(",", red);
//        System.out.println(join);
//         collect.forEach(System.out::println);
//        for (Integer integer : red) {
//            System.out.println("in: " + integer);
//        }
    }

    public static int[] getRandom() {
        int[] arr = new int[7];
        for (int i = 0; i < 5; i++) {
            arr[i] = (int) (Math.random()*35 + 1);
        }
        for (int i = 5; i < 7; i++) {
            arr[i] = (int) (Math.random()*12 + 1);
        }
        return arr;
    }
    public static Integer[] getRed(Integer type) {
        int x = 6, y = 33;
        Integer[] arrayPool = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};
        // daletou
        if (type == 2) {
            x = 5;
            y = 35;
            ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(arrayPool));
            integers.add(34);
            integers.add(35);
            arrayPool = integers.toArray(new Integer[0]);
        }
        Integer[] userPool = new Integer[x];
        Random random = new Random();
        for (int i = 0; i < userPool.length; i++) {
            int randNum = random.nextInt(y);
            int userNum = arrayPool[randNum];
            userPool[i] = userNum;
            arrayPool = remove(arrayPool, randNum);
            x--;
            y--;
        }
        Arrays.sort(userPool);
        // Arrays.asList(userPool).stream().
        return userPool;
    }
    public static Integer[] getBlue(Integer type) {
        Integer[] arrayPool = {1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16};
        if (type == 2) {
            ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(arrayPool));
            List<Integer> collect = integers.stream().filter(p -> p <= 12).collect(Collectors.toList());
            arrayPool = collect.toArray(new Integer[0]);
        }
        Integer[] integers = new Integer[1];
        integers[0] = arrayPool[new Random().nextInt(arrayPool.length)];
        return integers;
    }

    public static Integer[] remove(Integer[] arr, int index) {
        List<Integer> integers = Arrays.asList(arr);
        ArrayList<Integer> arrayList = new ArrayList<>(integers);
        arrayList.remove(index);
        Integer[] b = arrayList.toArray(new Integer[0]);
        // Arrays.stream(b).forEach(System.out::println);
        // System.out.println(Arrays.toString(b));
        return b;
    }
}
