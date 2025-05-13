package src.Gaurav;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'g', 'j', 'm', 'z'};
        char target = 'z';
        System.out.println(ceiling(letters, target));


    }
    public static char ceiling(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            //find mid
            int mid = start + (end - start) / 2;
            if (target < letters[mid]) {
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return letters[start % letters.length];
    }
}
