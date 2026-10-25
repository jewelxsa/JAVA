
package arraysactivity;

import java.util.Arrays;

// @author j.fernandez

public class ArraysActivity {

    public static void main(String[] args) {

        System.out.println("========== BASIC ==========");
        String[] favorites = {"Pizza", "Basketball", "Anime", "Rainy days", "Milk tea"};

        for (int i = 0; i < favorites.length; i++) {
            System.out.println((i + 1) + ". " + favorites[i]);
        }
        System.out.println("Length of array: " + favorites.length);

        System.out.println("\n========== INTERMEDIATE ==========");
        int[] scores = {85, 92, 78, 65, 99, 88, 73, 90, 56, 81};

        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            sum = sum + scores[i];
        }
        double average = sum / (double) scores.length;

        int highest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > highest) {
                highest = scores[i];
            }
        }

        int lowest = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);

        System.out.println("\n========== ADVANCED ==========");
        // linear search (try 88 and then 100)
        int target = 88;
        int index = -1;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println(target + " was found at index " + index);
        } else {
            System.out.println(target + " was not found");
        }

        // sort a copy, not the original
        // because Arrays.sort changes the array itself, so if I sorted the
        // original the old order (and the index I just found) would be lost
        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);

        System.out.println("Original: " + Arrays.toString(scores));
        System.out.println("Sorted: " + Arrays.toString(sortedScores));

        System.out.println("\n========== EXPERT ==========");
        String[] names = {"Alice", "Bob", "Carla", "Dan", "Ella", "Fred"};
        int[][] quizData = {
            {90, 85, 95, 88},
            {78, 82, 80, 76},
            {88, 92, 85, 93},
            {70, 65, 80, 75},
            {95, 98, 92, 99},
            {60, 70, 65, 55}
        };

        // make the Student objects
        Student[] students = new Student[6];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(names[i], quizData[i]);
        }

        // my own sort (bubble sort), highest average first
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = 0; j < students.length - 1 - i; j++) {
                if (students[j].average < students[j + 1].average) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }

        // give ranks, same average = same rank (tie)
        students[0].rank = 1;
        for (int i = 1; i < students.length; i++) {
            if (students[i].average == students[i - 1].average) {
                students[i].rank = students[i - 1].rank;
            } else {
                students[i].rank = i + 1;
            }
        }

        // leaderboard
        System.out.println("Rank | Name | Quizzes | Average");
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i].rank + " | " + students[i].name + " | ");
            for (int j = 0; j < students[i].quizzes.length; j++) {
                System.out.print(students[i].quizzes[j] + " ");
            }
            System.out.print("| " + students[i].average);

            // mark the ties
            boolean tie = false;
            if (i > 0 && students[i].rank == students[i - 1].rank) {
                tie = true;
            }
            if (i < students.length - 1 && students[i].rank == students[i + 1].rank) {
                tie = true;
            }
            if (tie) {
                System.out.print("  <-- TIE");
            }
            System.out.println();
        }

        // my own linear search for a student's rank
        String searchName = "Carla";
        int foundRank = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].name.equals(searchName)) {
                foundRank = students[i].rank;
                break;
            }
        }

        if (foundRank != -1) {
            System.out.println(searchName + " is rank " + foundRank);
        } else {
            System.out.println(searchName + " was not found");
        }
    }
}

class Student {
    String name;
    int[] quizzes;
    int rank;
    double average;

    Student(String name, int[] quizzes) {
        this.name = name;
        this.quizzes = quizzes;

        int total = 0;
        for (int i = 0; i < quizzes.length; i++) {
            total = total + quizzes[i];
        }
        this.average = total / (double) quizzes.length;
    }
}
