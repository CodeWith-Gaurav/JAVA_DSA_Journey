// package SortingAndSearching;

public class orderAgnosticBS {

    public static void main(String[] args) {
        int[] arr = {1,3, 3, 5, 6, 9, 10, 12, 19};
        int target = 12;
        int ans = orderAgnosticBinarySearch(arr, target);
        System.out.println(ans);
    }
   

    static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        //find whether arr is sorted in asc or desc
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return -1;
    }
}
