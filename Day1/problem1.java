import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Problem1 {
    public static void main(String[] args) {
        try {
            // File handle:
            Scanner scanner = new Scanner(new File("input.txt"));
            List<Integer> List1 = new ArrayList<>();
            List<Integer> List2 = new ArrayList<>();

            //create lists
            int counter = 0;
            while (scanner.hasNextInt()){
                int number = scanner.nextInt();
                counter++;
                if (counter % 2 == 1){
                    List1.add(number);
                } else{
                    List2.add(number);
                }
            }
            scanner.close();

            Collections.sort(List1);
            Collections.sort(List2);
            
            int difference = 0;
            for (int i = 0; i < List1.size(); i++){
                difference += Math.abs(List2.get(i) - List1.get(i));
            }

            System.out.println(difference);

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please ensure the file 'input.txt' exists in the correct directory.");
        }
    }
}
