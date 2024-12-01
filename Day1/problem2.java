import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    public static void main(String[] args) {
        try {
            // File handle
            Scanner scanner = new Scanner(new File("input.txt"));
            List<Integer> List1 = new ArrayList<>();
            List<Integer> List2 = new ArrayList<>();
            List<Integer> CounterL = new ArrayList<>();

            int counter = 0;
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                counter++;
                if (counter % 2 == 1) {
                    List1.add(number);
                } else {
                    List2.add(number);
                }
            }

            // Check if number exists in the other list and count matches
            for (int i = 0; i < List1.size(); i++) {
                int test = 0;
                for (int j = 0; j < List2.size(); j++) {
                    if (List1.get(i).equals(List2.get(j))) {
                        test++;
                    }
                }
                CounterL.add(test);
            }

            int distance = 0;

            for (int i = 0; i < CounterL.size(); i++){
                distance += CounterL.get(i) * List1.get(i);
            }

            System.out.println(distance);

        } catch (FileNotFoundException e) {
            System.out.println("File not found, check if the file exists.");
        }
    }
}
