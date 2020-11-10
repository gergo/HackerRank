import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class ContactsLookup {

    static int[] contacts(String[][] queries) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < queries.length; ++i) {
            String action = queries[i][0];
            String word = queries[i][1];
            if (action.equals("add")) {
                for (int j = 1; j <= word.length(); ++j) {
                    String part = word.substring(0, j);
                    if (map.get(part) == null) {
                        map.put(part, 1);
                    } else {
                        map.put(part, map.get(part) + 1);
                    }
                }
            } else {
                if (map.get(word) == null) {
                    ret.add(0);
                } else {
                    ret.add(map.get(word));
                }
            }
        }
        int[] arr = new int[ret.size()];
        for (int i = 0; i < ret.size(); ++i) {
            arr[i] = ret.get(i);
        }
        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
