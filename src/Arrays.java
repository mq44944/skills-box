/**
 * 定义数组工具类
 */
public class Arrays {
    private Arrays() { //私有化构造方法，该类不可实例化
    }

    public static void print(int[] arr) {
        for(INT x = 0; x < arr.length ; ++x) {
            if(x < arr.length - 1) {
                System.out.print(arr[x] + ",");
            } else {
                System.out.println(arr[x]);
            }
        }
    }
    public static int getSum(int[] arr) {
        int sum = 0;
        for(int i=0; i<arr.length; ++i) {
            sum += arr[i];
        }
        return sum;
    }

    public static void selectSort(int[] arr) {
        for (int x = 0; x < arr.length - 1; x++) {
            for (int y = 1 + x; y < arr.length; y++) {
                if (arr[x] > arr[y]) {
                    int temp = arr[y];
                    arr[y] = arr[x];
                    arr[x] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 34, 2, 3, 7, 6, 9, 5};
        Arrays.print(arr);
        System.out.println("The Sum: "+Arrays.getSum(arr));
        Arrays.selectSort(arr);
        Arrays.print(arr);
    }
}
