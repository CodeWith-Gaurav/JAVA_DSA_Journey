package src.Gaurav;

public class findInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 4;
        System.out.println(search(arr, target));
    }
    public static int search(int[] arr, int target){
        int peak = peakIndexMountainArray(arr);
        int firsTry = orderAgnosticSearch(arr, target, 0, peak);
        if(firsTry != -1){
            return firsTry;
        }
        //try to search in second half
        return orderAgnosticSearch(arr, target, peak+1, arr.length-1);

    }

    public static int peakIndexMountainArray(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[mid+1]){
                //you are in dec part of arr
                // this may be the ans but look at left
                end = mid;
            }else{
                //you are in asc part of arr
                start = mid+1;
            }
        }
        //in the end start == end and pointing to the largest number
        return start; //or return end; as both are equal
    }
    static int orderAgnosticSearch(int[] arr, int target, int s, int e) {
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
