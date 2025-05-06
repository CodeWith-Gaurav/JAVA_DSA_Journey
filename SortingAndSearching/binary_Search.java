package SortingAndSearching;

public class binary_Search {

    public static void main(String[] args) {
        int[] arr = {-19, -12, -4, 0, 2, 3, 5, 7, 12, 19, 24, 58};
        int target = -19;
        int ans = BinarSearch(arr, target);
        System.out.println(ans);
    }

    //return index
    // return -1 if target not exist
    static int BinarSearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            //find middle element
            // int mid = (start + end)/2; // might be possible that (start+end) might exxceed the range of integers
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                //ans
                return mid;
            }

        }
        return -1;
    }
}
