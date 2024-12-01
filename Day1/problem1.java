import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class Problem2 {
    public static void main(String[] args){
        try{
            //file handle
            Scanner scanner = new Scanner(new File("input.txt"));
            List<Integer> List1 = new ArrayList<>();
            List<Integer> List2 = new ArrayList<>();

            int counter = 0;
            while (scanner.hasNextInt()){
                int number = scanner.nextInt();
                counter++;
                if (counter % 2 == 1){
                    List1.add(number);
                } else {
                    List2.add(number);
                }
            }

            Collections.sort(List1);
            Collections.sort(List2);

            int distance = 0;
            for (int i = 0; i < List1.size(); i++){
                distance += Math.abs(List2.get(i) - List1.get(i));
            }

            System.out.println(distance);

        }catch(FileNotFoundException e){
            System.out.println("File not found, check if file exists");
        }
    }
}