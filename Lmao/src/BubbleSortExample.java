//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
public class BubbleSortExample {
    public BubbleSortExample() {
    }
    public static void main(String[] args) {
        int[] array = new int[]{64, 25, 12, 22, 11};
        bubbleSort(array);
        System.out.println("Sorted array: ");

        for(int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + " ");
        }
    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n - 1; ++i) {
            boolean swapped = false;

            for(int j = 0; j < n - i - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
