import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ReactorSafetyWithDampener {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            List<List<Integer>> reports = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Scanner lineScanner = new Scanner(line);
                List<Integer> report = new ArrayList<>();
                while (lineScanner.hasNextInt()) {
                    report.add(lineScanner.nextInt());
                }
                reports.add(report);
                lineScanner.close();
            }
            scanner.close();

            int safeCount = 0;
            for (List<Integer> report : reports) {
                if (isSafe(report) || canBeMadeSafe(report)) {
                    safeCount++;
                }
            }

            System.out.println("Number of safe reports: " + safeCount);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    private static boolean isSafe(List<Integer> report) {
        if (report.size() < 2) {
            return true;
        }

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < report.size(); i++) {
            int diff = report.get(i) - report.get(i - 1);

            if (Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                return false;
            }

            if (diff > 0) {
                isDecreasing = false;
            } else if (diff < 0) {
                isIncreasing = false;
            }
        }

        return isIncreasing || isDecreasing;
    }

    private static boolean canBeMadeSafe(List<Integer> report) {
        for (int i = 0; i < report.size(); i++) {
            List<Integer> candidate = new ArrayList<>(report);
            candidate.remove(i);
            if (isSafe(candidate)) {
                return true;
            }
        }
        return false;
    }
}
