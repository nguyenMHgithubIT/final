//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.EmptyStackException;

class LinkedListStack {
    private Node top = null;

    public LinkedListStack() {
    }

    public void push(Student student) {
        Node newNode = new Node(student);
        newNode.next = this.top;
        this.top = newNode;
        System.out.println("Added " + String.valueOf(student) + " to the stack.");
    }

    public Student pop() {
        if (this.top == null) {
            System.out.println("Stack is empty. Cannot pop.");
            throw new EmptyStackException();
        } else {
            Student poppedValue = this.top.data;
            this.top = this.top.next;
            return poppedValue;
        }
    }

    public Student peek() {
        if (this.top == null) {
            System.out.println("Stack is empty. Nothing to peek.");
            throw new EmptyStackException();
        } else {
            return this.top.data;
        }
    }

    public boolean isEmpty() {
        return this.top == null;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        Student s1 = new Student(1, "Alice", 8.5);
        Student s2 = new Student(2, "Bob", 6.0);
        stack.push(s1);
        stack.push(s2);
        System.out.println("Top student: " + String.valueOf(stack.peek()));
        System.out.println("Popped: " + String.valueOf(stack.pop()));
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}




