import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        int maxSoFar = 0;
        int length = 0;
        int heightOfFirst = 0;
        for (int i = 0; i < h.length; ++i) {
            heightOfFirst = h[i];
            maxSoFar = Math.max(maxSoFar, h[i]);
            if (i > 0 && heightOfFirst <= h[i - 1]) {
                // check left
                length = 0;
                for (int step = 0; step <= i; ++step) {
                    if (h[i - step] >= heightOfFirst) {
                        ++length;
                    } else {
                        break;
                    }
                }
                maxSoFar = Math.max(maxSoFar, length * heightOfFirst);
            }
            if (i < h.length - 1 && heightOfFirst <= h[i + 1]) {
                // check right
                length = 0;
                for (int step = 0; step < h.length - i; ++step) {
                    if (h[i + step] >= heightOfFirst) {
                        ++length;
                    } else {
                        break;
                    }
                }
                maxSoFar = Math.max(maxSoFar, length * heightOfFirst);
            }
            if (i > 0 && i < h.length - 1 && heightOfFirst < h[i - 1] && heightOfFirst < h[i + 1]) {
                // check both directions
                length = 0;
                for (int step = 0; step <= i; ++step) {
                    if (h[i - step] >= heightOfFirst) {
                        ++length;
                    } else {
                        break;
                    }
                }
                for (int step = 0; step < h.length - i; ++step) {
                    if (h[i + step] >= heightOfFirst) {
                        ++length;
                    } else {
                        break;
                    }
                }
                length--;
                maxSoFar = Math.max(maxSoFar, length * heightOfFirst);
            }
        }
        return maxSoFar;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        int maxSoFar = 0;
        int length = 0;
        int heightOfFirst = 0;
        for (int i = 0; i < h.length; ++i) {
            heightOfFirst = h[i];
            maxSoFar = Math.max(maxSoFar, h[i]);
            if (i > 0 && heightOfFirst <= h[i - 1]) {
                // check left
                length = 0;
                System.out.println("left " + i);
                for (int step = 0; step <= i; ++step) {
                    if (h[i - step] >= heightOfFirst) {
                        ++length;
                    } else {
                        break;
                    }
                }
                System.out.println(maxSoFar + " vs " + length + " * " + heightOfFirst);
                maxSoFar = Math.max(maxSoFar, length * heightOfFirst);
            }
            if (i < h.length - 1 && heightOfFirst <= h[i + 1]) {
                // check right
                System.out.println("right " + i);
                length = 0;
                for (int step = 0; step < h.length - i; ++step) {
                    if (h[i + step] >= heightOfFirst) {
                        ++length;
                    } else {
                        break;
                    }
                }
                System.out.println(maxSoFar + " vs " + length + " * " + heightOfFirst);
                maxSoFar = Math.max(maxSoFar, length * heightOfFirst);
            }
            if (i > 0 && i < h.length - 1 && heightOfFirst < h[i - 1] && heightOfFirst < h[i + 1]) {
                length = 0;
                System.out.println("mid " + i);
                for (int step = 0; step <= i; ++step) {
                    if (h[i - step] >= heightOfFirst) {
                        ++length;
                    } else {
                        break;
                    }
                }
                for (int step = 0; step < h.length - i; ++step) {
                    if (h[i + step] >= heightOfFirst) {
                        ++length;
                    } else {
                        break;
                    }
                }
                length--;
                System.out.println(maxSoFar + " vs " + length + " * " + heightOfFirst);
                maxSoFar = Math.max(maxSoFar, length * heightOfFirst);
            }


        }
        return maxSoFar;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
