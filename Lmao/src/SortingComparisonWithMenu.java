import java.util.Random;
import java.util.Scanner;

public class SortingComparisonWithMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sorting Comparison ---");
            System.out.println("Enter the number of students to generate: ");
            System.out.println("(Enter 0 to exit)");
            System.out.print("Your choice: ");

            int numberOfStudents = scanner.nextInt();

            if (numberOfStudents == 0) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            // Tạo danh sách sinh viên ngẫu nhiên
            Student[] students = generateRandomStudents(numberOfStudents);

            // Hiển thị danh sách sinh viên được tạo
            System.out.println("\nGenerated Students List:");
            for (Student student : students) {
                System.out.println(student);
            }

            System.out.println("\nComparing sorting algorithms...");

            // Sao chép danh sách sinh viên để đảm bảo dữ liệu giống nhau cho cả 2 thuật toán
            Student[] studentsForBubbleSort = students.clone();
            Student[] studentsForQuickSort = students.clone();

            // So sánh thời gian chạy của Bubble Sort
            long bubbleSortStart = System.nanoTime();
            bubbleSort(studentsForBubbleSort);
            long bubbleSortEnd = System.nanoTime();
            long bubbleSortTime = bubbleSortEnd - bubbleSortStart;

            // So sánh thời gian chạy của Quick Sort
            long quickSortStart = System.nanoTime();
            quickSort(studentsForQuickSort, 0, studentsForQuickSort.length - 1);
            long quickSortEnd = System.nanoTime();
            long quickSortTime = quickSortEnd - quickSortStart;

            // Hiển thị kết quả thời gian
            System.out.println("\nTime taken to sort:");
            System.out.println("Bubble Sort: " + bubbleSortTime + " nanoseconds");
            System.out.println("Quick Sort: " + quickSortTime + " nanoseconds");
        }

        scanner.close();
    }

    // Tạo danh sách sinh viên ngẫu nhiên
    private static Student[] generateRandomStudents(int number) {
        Random random = new Random();
        Student[] students = new Student[number];
        for (int i = 0; i < number; i++) {
            students[i] = new Student(
                    i + 1,
                    null, // Tên là null
                    random.nextDouble() * 10 // Điểm từ 0 đến 10
            );
        }
        return students;
    }

    // Bubble Sort cho danh sách sinh viên dựa trên điểm số
    private static void bubbleSort(Student[] students) {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (students[j].getMarks() > students[j + 1].getMarks()) {
                    // Hoán đổi
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Nếu không có hoán đổi, thoát sớm
        }
    }

    // Quick Sort cho danh sách sinh viên dựa trên điểm số
    private static void quickSort(Student[] students, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(students, low, high);
            quickSort(students, low, pivotIndex - 1);
            quickSort(students, pivotIndex + 1, high);
        }
    }

    private static int partition(Student[] students, int low, int high) {
        Student pivot = students[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students[j].getMarks() <= pivot.getMarks()) {
                i++;
                // Hoán đổi
                Student temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
        // Hoán đổi phần tử pivot vào vị trí chính xác
        Student temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;
        return i + 1;
    }
}


