/**
 * Created by leo.zinger on 4/17/17.
 */
public class QuickSort {

        int[] myQuickSort (int[] s){
            if (s.length == 1){
                return s;
            }

            //first half of array's size is always the same calculation (not including the middle element)
            int[] s1 = new int[s.length / 2];
            int[] s2;

            //2nd half of array's size depends on whether the array is odd numbered or not, including the middle element)
            if(s.length % 2 == 1) { //odd numbered array
                s2 = new int[s.length/2 + 1];
            }
            else {
                s2 = new int[s.length/2];
            }

            //Begin: quick-sort the 2 halves of the array around middle
            int middle_index = s.length/2;
            int middle_element = s[s.length/2];
            int temp;
            int i=0;
            int j=s.length-1;

            while (s[i]<=middle_element && i<middle_index){
                i++;
            }
            while (middle_element<=s[j] && middle_index < j){
                j--;
            }

            if (i!=j){
                    //we swap first two out-of-order elements
                    temp = s[i];
                    s[i] = s[j];
                    s[j] = temp;
            }
            //End: quick-sort the 2 halves of the array around middle

            //copy first 1/2 of array into array s1.
            for (i=0; i<s.length/2; i++){
                s1[i] = s[i];
            }

            //copy second 1/2 of array into array s2.
            for (i=s.length/2, j=0 ; i<s.length; i++, j++){
                s2[j] = s[i];
            }

            //recursively quick-sort the 2 halves of the array
            s1 = myQuickSort(s1);
            s2 = myQuickSort(s2);

            //copy array s1 back into first 1/2 of array s
            for (i=0; i<s.length/2; i++){
                s[i] = s1[i];
            }

            //copy array s2 back into second 1/2 of array s
            for (i=s.length/2, j=0; i<s.length; i++,j++){
                s[i] = s2[j];
            }

            return s;
        }

        public static void main(String[] s){
            int[] sortArray = {5, 6, 9, 10, 14, 97, 134, 971, 7, 51, 15, 83, 65, 77, 259, 111, 47, 34, 12};
            QuickSort quickSort = new QuickSort();
            String stringVar = java.util.Arrays.toString(quickSort.myQuickSort(sortArray));
            System.out.println("Result Quick=Sorted Array: " + stringVar);
        }
}
