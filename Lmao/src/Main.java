    import java.util.ArrayList;
    import java.util.Scanner;


    public class Main {

        private static ArrayStack studentStack;

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            // Nhập số lượng sinh viên cần quản lý
            System.out.println("Enter the number of students in the class: ");
            int numberOfStudents = scanner.nextInt();
            studentStack = new ArrayStack(numberOfStudents);

            while (true) {
                // Menu chính
                System.out.println("\n===== Student Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Search Student by ID");
                System.out.println("6. Sort Students by Marks");
                System.out.println("7. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Xóa bộ đệm

                switch (choice) {
                    case 1:
                        addStudent(scanner);
                        break;
                    case 2:
                        editStudent(scanner);
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        displayAllStudents();
                        break;
                    case 5:
                        searchStudent(scanner);
                        break;
                    case 6:
                        sortStudentsBubbleSort();
                        break;
                    case 7:
                        System.out.println("Exiting program. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

        // Thêm sinh viên vào stack
        private static void addStudent(Scanner scanner) {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Marks: ");
            double marks = scanner.nextDouble();

            Student student = new Student(id, name, marks);
            studentStack.push(student);
        }

        // Sửa thông tin sinh viên
        private static void editStudent(Scanner scanner) {
            System.out.print("Enter the Student ID to edit: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm
            ArrayList<Student> tempStack = new ArrayList<>();

            boolean found = false;
            while (!studentStack.isEmpty()) {
                Student student = studentStack.pop();
                if (student.getId() == id) {
                    found = true;
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    double newMarks = scanner.nextDouble();
                    student = new Student(id, newName, newMarks);
                }
                tempStack.add(student);
            }

            // Đẩy lại vào stack
            for (int i = tempStack.size() - 1; i >= 0; i--) {
                studentStack.push(tempStack.get(i));
            }

            if (found) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
        }

        // Xóa sinh viên
        private static void deleteStudent() {
            if (studentStack.isEmpty()) {
                System.out.println("Stack is empty. No student to delete.");
            } else {
                Student removedStudent = studentStack.pop();
                System.out.println("Removed: " + removedStudent);
            }
        }

        // Hiển thị tất cả sinh viên
        private static void displayAllStudents() {
            if (studentStack.isEmpty()) {
                System.out.println("No students in the stack.");
                return;
            }

            ArrayList<Student> tempStack = new ArrayList<>();
            while (!studentStack.isEmpty()) {
                Student student = studentStack.pop();
                tempStack.add(student);
                System.out.println(student + " -> Rank: " + getRanking(student.getMarks()));
            }


            // Đẩy lại vào stack
            for (int i = tempStack.size() - 1; i >= 0; i--) {
                studentStack.push(tempStack.get(i));
            }
        }

        // Tìm kiếm sinh viên theo ID
        private static void searchStudent(Scanner scanner) {
            System.out.print("Enter the Student ID to search: ");
            int id = scanner.nextInt();

            ArrayList<Student> tempStack = new ArrayList<>();
            boolean found = false;

            while (!studentStack.isEmpty()) {
                Student student = studentStack.pop();
                tempStack.add(student);

                if (student.getId() == id) {
                    System.out.println(student + " -> Rank: " + student.getRanking());

                    found = true;
                }
            }

            // Đẩy lại vào stack
            for (int i = tempStack.size() - 1; i >= 0; i--) {
                studentStack.push(tempStack.get(i));
            }

            if (!found) {
                System.out.println("Student not found.");
            }
        }


    // Sắp xếp sinh viên theo điểm sử dụng Bubble Sort
        private static void sortStudentsBubbleSort() {
            ArrayList<Student> tempStack = new ArrayList<>();
            // Lấy tất cả sinh viên từ stack và lưu vào tempStack
            while (!studentStack.isEmpty()) {
                tempStack.add(studentStack.pop());
            }
            // Bubble Sort
            for (int i = 0; i < tempStack.size() - 1; i++) {
                for (int j = 0; j < tempStack.size() - 1 - i; j++) {
                    // So sánh điểm của 2 sinh viên
                    if (tempStack.get(j).getMarks() < tempStack.get(j + 1).getMarks()) {
                        // Hoán đổi nếu sinh viên hiện tại có điểm thấp hơn sinh viên tiếp theo
                        Student temp = tempStack.get(j); // Khai báo temp để lưu trữ sinh viên tạm thời
                        tempStack.set(j, tempStack.get(j + 1)); // Đổi vị trí
                        tempStack.set(j + 1, temp); // Đổi vị trí
                    }
                }
            }
            // Đưa lại tất cả sinh viên vào stack sau khi đã sắp xếp
            for (int i = tempStack.size() - 1; i >= 0; i--) {
                studentStack.push(tempStack.get(i));
            }

            System.out.println("Students sorted by marks using Bubble Sort.");
            displayAllStudents();
        }


        // Xếp hạng sinh viên theo điểm
        private static String getRanking(double marks) {
            if (marks < 5.0) return "Fail";
            if (marks < 6.5) return "Medium";
            if (marks < 7.5) return "Good";
            if (marks < 9.0) return "Very Good";
            return "Excellent";
        }
    }


