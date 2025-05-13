package src.Gaurav;

public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6, 4, 3, 2};
        System.out.println(peakIndexMountainArray(arr));
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

}
