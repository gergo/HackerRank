import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        Stack<Integer> s3 = new Stack();
        Collections.reverse(h1);
        Collections.reverse(h2);
        Collections.reverse(h3);

        Integer sum = 0;
        for (Integer i : h1) {
            sum += i;
            s1.push(sum);
        }
        sum = 0;
        for (Integer i : h2) {
            sum += i;
            s2.push(sum);
        }
        sum = 0;
        for (Integer i : h3) {
            sum += i;
            s3.push(sum);
        }

        while (!(s1.empty() || s2.empty() || s3.empty())) {
            Integer min = Math.min(s1.peek(), Math.min(s2.peek(), s2.peek()));
            if ((s1.peek() == s2.peek()) && (s1.peek() == s3.peek())) {
                return s1.peek();
            }
            while (s1.peek() > min) {
                s1.pop();
            }
            while (s2.peek() > min) {
                s2.pop();
            }
            while (s3.peek() > min) {
                s3.pop();
            }
        }
        return 0;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        String[] h1Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h1 = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            int h1Item = Integer.parseInt(h1Temp[i]);
            h1.add(h1Item);
        }

        String[] h2Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h2 = new ArrayList<>();

        for (int i = 0; i < n2; i++) {
            int h2Item = Integer.parseInt(h2Temp[i]);
            h2.add(h2Item);
        }

        String[] h3Temp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n3; i++) {
            int h3Item = Integer.parseInt(h3Temp[i]);
            h3.add(h3Item);
        }

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
