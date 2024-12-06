import java.util.EmptyStackException;

class ArrayStack {
    private int maxSize;
    private Student[] stackArray;
    private int top;

    public ArrayStack(int size) {
        this.maxSize = size;
        this.stackArray = new Student[maxSize];
        this.top = -1;
    }

    public void push(Student student) {
        if (top == maxSize - 1) {
            System.out.println("Stack is full. Cannot add " + student);
        } else {
            stackArray[++top] = student;
            System.out.println("Added " + student + " to the stack.");
        }
    }

    public Student pop() {
        if (top == -1) {
            System.out.println("Stack is empty. Cannot pop.");
            throw new EmptyStackException();
        } else {
            return stackArray[top--];
        }
    }

    public Student peek() {
        if (top == -1) {
            System.out.println("Stack is empty. Nothing to peek.");
            throw new EmptyStackException();
        } else {
            return stackArray[top];
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        // Sample students
        Student s1 = new Student(1, "Alice", 8.5);
        Student s2 = new Student(2, "Bob", 6.0);

        stack.push(s1);
        stack.push(s2);
        System.out.println("Top student: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
    }

