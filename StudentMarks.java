package CIE;

public class Student {
    public String usn;
    public String name;
    public int sem;

    public Student(String usn, String name, int sem) {
        this.usn = usn;
        this.name = name;
        this.sem = sem;
    }
} 

package CIE;

public class Internals {
    public int[] internalMarks = new int[5]; // Array to store internal marks for 5 courses

    public Internals(int[] marks) {
        if (marks.length == 5) {
            System.arraycopy(marks, 0, internalMarks, 0, marks.length);
        } else {
            throw new IllegalArgumentException("Marks array must contain exactly 5 elements.");
        }
    }
}

package SEE;

import CIE.Student;

public class External extends Student {
    public int[] seeMarks = new int[5]; // Array to store SEE marks for 5 courses

    public External(String usn, String name, int sem, int[] seeMarks) {
        super(usn, name, sem);
        if (seeMarks.length == 5) {
            System.arraycopy(seeMarks, 0, this.seeMarks, 0, seeMarks.length);
        } else {
            throw new IllegalArgumentException("Marks array must contain exactly 5 elements.");
        }
    }
}

import CIE.Student;
import CIE.Internals;
import SEE.External;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        External[] students = new External[n];
        Internals[] internalMarks = new Internals[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for student " + (i + 1) + ":");
            System.out.print("USN: ");
            String usn = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Semester: ");
            int sem = scanner.nextInt();

            System.out.println("Enter 5 internal marks:");
            int[] internals = new int[5];
            for (int j = 0; j < 5; j++) {
                internals[j] = scanner.nextInt();
            }
            internalMarks[i] = new Internals(internals);

            System.out.println("Enter 5 SEE marks:");
            int[] seeMarks = new int[5];
            for (int j = 0; j < 5; j++) {
                seeMarks[j] = scanner.nextInt();
            }

            students[i] = new External(usn, name, sem, seeMarks);
            scanner.nextLine(); // Consume newline
        }

        System.out.println("\nFinal Marks:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student: " + students[i].name + " (" + students[i].usn + ")");
            System.out.print("Final Marks: ");
            for (int j = 0; j < 5; j++) {
                int finalMark = (int) (internalMarks[i].internalMarks[j] + (students[i].seeMarks[j] / 2.0));
                System.out.print(finalMark + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
