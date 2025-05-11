package src.Gaurav;

public class ceilingOfNumber {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 15;
        int ans = ceilingNumber(arr, target);
        System.out.println(ans);
    }

    static int ceilingNumber(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            //find mid 
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // return ans
                return mid;
            }
        }
        return arr[start];
    }

}
