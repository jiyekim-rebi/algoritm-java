package src.SortAlgoritm;

// 선택정렬
// n(n+1)/2
public class SelectionSort {

    // i, j 위치변경
    public static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 최소값의 위치를 찾음
    public static int indexLowest(int[] array, int start) {
        int lowIndex = start;

        for (int i = start; i < array.length; i++) {
            if (array[i] < array[lowIndex]) {
                lowIndex = i;
            }
        }

        return lowIndex;
    }

    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int j = indexLowest(array, i);
            swapElements(array, i, j);
        }
    }

}
