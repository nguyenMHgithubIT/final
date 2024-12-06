//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[this.maxSize];
        this.top = -1;
    }

    public void push(int value) {
        if (this.top < this.maxSize - 1) {
            this.stackArray[++this.top] = value;
        }

    }

    public int pop() {
        return this.top >= 0 ? this.stackArray[this.top--] : -1;
    }
}
