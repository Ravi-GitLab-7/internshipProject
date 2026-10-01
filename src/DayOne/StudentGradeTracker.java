package DayOne;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    // Student class
    static class Student {
        String     name;
        int rollNo;
        ArrayList<Double> marks;

        Student(String name, int rollNo, ArrayList<Double> marks) {
            this.name = name;
            this.rollNo = rollNo;
            this.marks = marks;
        }

        // Calculate average
        double getAverage() {
            double sum = 0;

            for (double mark : marks) {
                sum += mark;
            }

            return sum / marks.size();
        }

        // Highest mark
        double getHighest() {
            double highest = marks.get(0);

            for (double mark : marks) {
                if (mark > highest) {
                    highest = mark;
                }
            }

            return highest;
        }

        // Lowest mark
        double getLowest() {
            double lowest = marks.get(0);

            for (double mark : marks) {
                if (mark < lowest) {
                    lowest = mark;
                }
            }

            return lowest;
        }

        // Calculate grade
        char getGrade() {
            double average = getAverage();

            if (average >= 90) {
                return 'A';
            } else if (average >= 80) {
                return 'B';
            } else if (average >= 70) {
                return 'C';
            } else if (average >= 60) {
                return 'D';
            } else if (average >= 50) {
                return 'E';
            } else {
                return 'F';
            }
        }

        // Display student information
        void displayStudent() {

            System.out.println("--------------------------------------");
            System.out.println("Roll Number : " + rollNo);
            System.out.println("Name        : " + name);

            System.out.println("Marks       : " + marks);

            System.out.printf("Average     : %.2f%n", getAverage());

            System.out.println("Highest     : " + getHighest());
            System.out.println("Lowest      : " + getLowest());
            System.out.println("Grade       : " + getGrade());

            System.out.println("--------------------------------------");
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        int choice;
        do {

            System.out.println("\n======================================");
            System.out.println("       STUDENT GRADE TRACKER");
            System.out.println("======================================");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Find Highest Scoring Student");
            System.out.println("4. Find Lowest Scoring Student");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Exit");

            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // clear buffer

                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter roll number: ");
                    int rollNo = sc.nextInt();

                    System.out.print("Enter number of subjects: ");
                    int numberOfSubjects = sc.nextInt();

                    ArrayList<Double> marks = new ArrayList<>();

                    for (int i = 1; i <= numberOfSubjects; i++) {

                        double mark;

                        while (true) {

                            System.out.print(
                                    "Enter marks for Subject " + i + " (0-100): "
                            );

                            mark = sc.nextDouble();

                            if (mark >= 0 && mark <= 100) {
                                break;
                            }

                            System.out.println(
                                    "Invalid marks! Enter marks between 0 and 100."
                            );
                        }

                        marks.add(mark);
                    }

                    Student student =
                            new Student(name, rollNo, marks);

                    students.add(student);

                    System.out.println(
                            "\nStudent added successfully!"
                    );

                    break;
                case 2:

                    if (students.isEmpty()) {

                        System.out.println(
                                "\nNo students available."
                        );

                    } else {

                        System.out.println(
                                "\n========== ALL STUDENTS =========="
                        );

                        for (Student s : students) {
                            s.displayStudent();
                        }
                    }

                    break;

                case 3:

                    if (students.isEmpty()) {

                        System.out.println(
                                "\nNo students available."
                        );

                    } else {

                        Student highestStudent = students.get(0);

                        for (Student s : students) {

                            if (s.getAverage()
                                    > highestStudent.getAverage()) {

                                highestStudent = s;
                            }
                        }

                        System.out.println(
                                "\n===== HIGHEST SCORING STUDENT ====="
                        );

                        highestStudent.displayStudent();
                    }

                    break;

                case 4:

                    if (students.isEmpty()) {

                        System.out.println(
                                "\nNo students available."
                        );

                    } else {

                        Student lowestStudent = students.get(0);

                        for (Student s : students) {

                            if (s.getAverage()
                                    < lowestStudent.getAverage()) {

                                lowestStudent = s;
                            }
                        }

                        System.out.println(
                                "\n===== LOWEST SCORING STUDENT ====="
                        );

                        lowestStudent.displayStudent();
                    }

                    break;


                case 5:

                    System.out.print(
                            "Enter roll number to search: "
                    );

                    int searchRoll = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {

                        if (s.rollNo == searchRoll) {

                            System.out.println(
                                    "\n===== STUDENT FOUND ====="
                            );

                            s.displayStudent();

                            found = true;
                            break;
                        }
                    }

                    if (!found) {

                        System.out.println(
                                "Student not found."
                        );
                    }

                    break;

                case 6:

                    System.out.println(
                            "\nThank you for using Student Grade Tracker!"
                    );

                    break;

                default:

                    System.out.println(
                            "\nInvalid choice! Please try again."
                    );
            }

        } while (choice != 6);

        sc.close();
    }
}