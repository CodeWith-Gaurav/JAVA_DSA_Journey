package src.Gaurav;

public class orderAgnosticBS {

    public static void main(String[] args) {
        int[] arr = {123, 78, 56, 32, 21, 10, 8, 6, 2, 1};
        int target = 2;
        int ans = orderAgnosticSearch(arr, target);
        System.out.println(ans);
    }

    static int orderAgnosticSearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;

        // check for ascending order
        boolean isAsc = arr[s] <= arr[e];

        while (s <= e) {
            // find mid
            int mid = s + (e - s) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    e = mid - 1;
                } else if (target > arr[mid]) {
                    s = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    e = mid - 1;
                } else if (target < arr[mid]) {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }
}
