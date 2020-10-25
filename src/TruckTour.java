import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TruckTour {

    static int truckTour(int[][] petrolpumps) {
        int totalStops = petrolpumps.length;
        for (int i = 0; i < totalStops;) {
            System.out.println("start: " + i);
            int stops = 0;
            int petrol = 0;
            for (; stops < totalStops; ++stops) {
                System.out.println(" stop: " + stops);
                petrol += petrolpumps[(i+stops) % totalStops][0];
                petrol -= petrolpumps[(i+stops) % totalStops][1];
                System.out.println(" petrol: " + petrol);
                if (petrol < 0) {
                    i += stops + 1;
                    break;
                }
            }
            if (stops == totalStops) {
                return i;
            }
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] petrolpumps = new int[n][2];

        for (int petrolpumpsRowItr = 0; petrolpumpsRowItr < n; petrolpumpsRowItr++) {
            String[] petrolpumpsRowItems = scanner.nextLine().split(" ");

            for (int petrolpumpsColumnItr = 0; petrolpumpsColumnItr < 2; petrolpumpsColumnItr++) {
                int petrolpumpsItem = Integer.parseInt(petrolpumpsRowItems[petrolpumpsColumnItr].trim());
                petrolpumps[petrolpumpsRowItr][petrolpumpsColumnItr] = petrolpumpsItem;
            }
        }

        int result = truckTour(petrolpumps);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
