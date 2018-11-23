package basic;

/**
 * Created by ck on 2018/11/23.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] i = {1, 2, 4, 5, 7, 9, 19, 30};
        int begin = 0;
        int end = i.length;
        int mid = (begin + end) / 2;

        int target = 4;
        while(true){
            if(target == i[mid]) {
                System.out.println("value: " + target + " position is " + mid);
                break;
            }
            if(target > i[mid]) {
                begin = mid + 1;
            } else{
                end = mid - 1;
            }
            mid = (begin + end) / 2;
        }

    }
}
