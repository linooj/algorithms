package ee.ttu.algoritmid.interestingstamps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InterestingStamps {

    public static List<Integer> findStamps(int sum, List<Integer> stampOptions) throws IllegalArgumentException {
        if (sum < 0 || stampOptions.size() == 0) throw new IllegalArgumentException();
        List<Integer> sorted = stampOptions.stream().sorted().collect(Collectors.toList());
        int length = stampOptions.size();
        int[][] dp = new int[length][sum + 1];

        for (int i = 0; i < sum+1; i++) {
            if (i % sorted.get(0) == 0) {
                dp[0][i] = i / sorted.get(0);
            }
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (sorted.get(i) > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-sorted.get(i)]);
                }
            }
        } int min_coins = dp[length-1][sum];

        List<Integer> answer = new ArrayList<>();
        int total = sum;
        int len = length - 1;
        while(total != 0) {
            if (dp[len - 1][total] == min_coins) {
                len -= 1;
            } else {
                answer.add(stampOptions.get(len));
                total -= stampOptions.get(len);
                min_coins -= 1;
            }
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        List<Integer> coins = List.of(1, 5, 6, 8);
        findStamps(11, coins);
    }
}

