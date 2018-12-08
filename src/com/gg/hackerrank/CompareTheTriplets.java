package com.gg.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareTheTriplets {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<Integer>();
        System.out.println("a lllll"+a.stream().map(f->f).collect(Collectors.toList()));
        a.stream().map(ar -> {
//           b.stream().map(br -> {
//               return(ar.compareTo(br));
//
//           });
            System.out.println("ar"+ar);
//            result.add(ar);
            return ar;
        });
        return null;

    }


    public static void main(String[] args) throws IOException {
        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());*/
        List<Integer> a = Arrays.asList(5, 6, 7);
        List<Integer> b = Arrays.asList(3, 6, 10);

        List<Integer> result = compareTriplets(a, b);
        System.out.println("Result "+result);

       /* bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();*/
    }
}

