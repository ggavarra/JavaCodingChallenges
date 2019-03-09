package com.gg.hackerrank;

/**
 * Created by gayathrig on 03/03/2019.
 *
 */
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.*;
import java.util.stream.Collectors;

import static java.lang.String.*;

public class ClimbingTheLeaderBoard {



    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {

        Integer aliceRank=0;
        ArrayList<Integer> scoreList = new ArrayList<>();
        for (int i : scores
                ) {
            scoreList.add(new Integer(valueOf(i)));
        }

        int[] aliceRanking=new int[alice.length];
        for (int i=0;i<alice.length;i++) {
            long startTime=System.currentTimeMillis();
            aliceRank=getRankingForNewScore(scoreList,alice[i]);
            System.out.println(String.format("Alice Rank for score %s in the game %s is %s in time %s",alice[i],i,aliceRank,(System.currentTimeMillis()-startTime)));
            aliceRanking[i]=aliceRank;
        }

        return aliceRanking;

    }

    static Integer getRankingForNewScore(ArrayList<Integer>  scoreList, Integer newScore){

        ArrayList<Integer>  tempScoreList=new ArrayList<>(scoreList);
        tempScoreList.add(newScore);
        AtomicLong value = new AtomicLong(1);
        Map<Integer,Integer>  distinctScoreMap=tempScoreList.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toMap(x-> x,x->new Integer(valueOf(value.getAndIncrement()))));
        System.out.println(distinctScoreMap);
        return(distinctScoreMap.get(newScore));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int[] alice={ };
        Properties scoresP=new Properties();
        scoresP.load(new FileInputStream("C:\\Gayathri\\learning\\github\\JavaCodingChallenges\\src\\com\\gg\\hackerrank\\testdata\\climbingTheLeaderBoard\\scores.properties"));
        Integer scoreCount=Integer.parseInt((String) scoresP.get("scoreCount"));
        Integer aliceScoreCount=Integer.parseInt((String) scoresP.get("aliceScoreCount"));
        //Integer[] scores =Arrays.asList(scoresP.getProperty("scores").split(",")).toArray(new Integer[scoreCount] );
        //Integer[] aliceScores =Arrays.asList(scoresP.getProperty("aliceScores").split(",")).toArray(new Integer[aliceScoreCount] );
        //climbingLeaderboard(Arrays.stream(scores).mapToInt(Integer::intValue).toArray(),Arrays.stream(aliceScores).mapToInt(Integer::intValue).toArray());


        Integer[] scores=System.arraycopy(Arrays.asList(scoresP.getProperty("scores").split(",")),0,new Integer[scoreCount],0,scoreCount);
        Integer[] aliceScores =System.arraycopy(Arrays.asList(scoresP.getProperty("aliceScores").split(",")),0,new Integer[scoreCount],0,aliceScoreCount);
        climbingLeaderboard(Arrays.stream(scores).mapToInt(Integer::intValue).toArray(),Arrays.stream(aliceScores).mapToInt(Integer::intValue).toArray());

    }


   /* public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

    }*/
}
/**
 * Alice is playing an arcade game and wants to climb to the top of the leaderboard and wants to track her ranking. The game uses Dense Ranking, so its leaderboard works like this:

 The player with the highest score is ranked number  on the leaderboard.
 Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
 For example, the four players on the leaderboard have high scores of , , , and . Those players will have ranks , , , and , respectively. If Alice's scores are ,  and , her rankings after each game are ,  and .

 Function Description

 Complete the climbingLeaderboard function in the editor below. It should return an integer array where each element represents Alice's rank after the  game.

 climbingLeaderboard has the following parameter(s):

 scores: an array of integers that represent leaderboard scores
 alice: an array of integers that represent Alice's scores
 Input Format

 The first line contains an integer , the number of players on the leaderboard.
 The next line contains  space-separated integers , the leaderboard scores in decreasing order.
 The next line contains an integer, , denoting the number games Alice plays.
 The last line contains  space-separated integers , the game scores.

 Constraints

 for
 for
 The existing leaderboard, , is in descending order.
 Alice's scores, , are in ascending order.
 Subtask

 For  of the maximum score:

 Output Format

 Print  integers. The  integer should indicate Alice's rank after playing the  game.

 Sample Input 1

 CopyDownload
 Array: scores
 100
 100
 50
 40
 40
 20
 10





 Array: alice
 5
 25
 50
 120


 7
 100 100 50 40 40 20 10
 4
 5 25 50 120
 Sample Output 1

 6
 4
 2
 1
 Explanation 1

 Alice starts playing with  players already on the leaderboard, which looks like this:

 image

 After Alice finishes game , her score is  and her ranking is :

 image

 After Alice finishes game , her score is  and her ranking is :

 image

 After Alice finishes game , her score is  and her ranking is tied with Caroline at :

 image

 After Alice finishes game , her score is  and her ranking is :

 image


 Sample Input 2

 CopyDownload
 Array: scores
 100
 90
 90
 80
 75
 60





 Array: alice
 50
 65
 77
 90
 102


 6
 100 90 90 80 75 60
 5
 50 65 77 90 102
 Sample Output 2

 6
 5
 4
 2
 1
 */
