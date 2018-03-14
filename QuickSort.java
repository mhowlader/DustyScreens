//Mohtasim Howlader
//APCS2 pd8
//HW18 -- QuickSort
//2018-03-13t

/*****************************************************
* class QuickSort
* Implements quicksort algo to sort an array of ints in place
*
* 1. Summary of QuickSort algorithm:
* QSort(arr):
    Recursive algorithm with parameters of: the array to be sorted, and params to represent left and right indices (called left and right)
    Begin with left being index 0 and right being the index of the last value in the array (which is arr.length-1)

    Base Case: if left is less than right (this means that there is at least one integer in the interval between left and right), then do this:
        Partition from left to right, with the pivot index chosen equal to right. Set a certain variable (pvtPos) to equal the return value of this partition.
        Run the same algorithm with right set to pvtPos - 1 (one less than the index of the pivot value)
        Run the same algorithm with left set to pvtPos + 1 (one more than index of the pivot value)

    When a recurive instance fails the base case, it will simply return nothing.

    This will work similar to divide and conquer because partitions will be created out of partitions, and then it's "all put back together" aka sorted.
*
* 2a. Worst pivot choice and associated runtime:
*   Just generall the worst choice is the one which requires the most number of recursive instances and calls for partition.
    Selecting the lowest or greatest element of a list as the pivot point is one example of this.

    Runtime: O(n^2) because partition (which is O(n)) will be called n times because the code will check each index.

* 2b. Best pivot choice and associated runtime:
*   When the pivot choice is exactly the median of the portion of the array being looked at in that particular instance.

    Runtime: O(nlogn) because partition will be called log n times (think binary sort)
* 3. Approach to handling duplicate values in array:

    The code I have written seems to work for duplicate values so I'm not entirely sure what more is there to be said.
    Perhaps the algorithm could be optimized by not partitioning duplicate values as the pivot point.
*



    I tested the runtime of the quicksort algorithm using 3 different ways to select the pivot point (descending, halves, and random).
    I did not noice any significant differences between these different approaches. If anything, the runtime seemed to be somewhat inconsistent.

    Sorting 1000 item list (Average over 5 trials):

    Descending: 335986 ns
    Halves:     362963 ns
    Random:     401420 ns
*****************************************************/

public class QuickSort
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
        int tmp = o[x];
        o[x] = o[y];
        o[y] = tmp;
    }

    //print input array
    public static void printArr( int[] a ) {
        for ( int o : a )
        System.out.print( o + " " );
        System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
        int tmp;
        int swapPos;
        for( int i = 0; i < d.length; i++ ) {
            tmp = d[i];
            swapPos = i + (int)( (d.length - i) * Math.random() );
            swap( i, swapPos, d );
        }
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
        int[] retArr = new int[s];
        for( int i = 0; i < retArr.length; i++ )
        retArr[i] = (int)( maxVal * Math.random() );
        return retArr;
    }

    public static int partition( int arr[], int left, int right, int pivot)
    {
      int v = arr[pivot];

      swap( pivot, right, arr);
      int s = left;

      for( int i = left; i < right; i++ ) {
       if ( arr[i] <= v) {
          swap( i, s, arr );
          s++;}
      }
      swap(s,right,arr);

      return s;
  }//end parititon


    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
    * void qsort(int[])
    * @param d -- array of ints to be sorted in place
    *****************************************************/
    public static void qsort( int[] d )
    {
        qsortHelper2(d, 0, (d.length-1));
    }

    //you may need a helper method...

    //descending pivot
    public static void qsortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int pvtPos = partition(arr, left, right, right);
            qsortHelper(arr,left,pvtPos-1);
            qsortHelper(arr, pvtPos+1,right);
        }
    }

    //halves pivot
    public static void qsortHelper2(int[] arr, int left, int right) {
        if (left < right) {
            int pvtPos = partition(arr, left, right, ((left+right)/2));
            qsortHelper2(arr,left,pvtPos-1);
            qsortHelper2(arr, pvtPos+1,right);
        }
    }

    //random pivot
    public static void qsortHelper3(int[] arr, int left, int right) {
        if (left < right) {
            int pvtPos = partition(arr, left, right, left + ((int)(Math.random() * (right - left+1))));
            qsortHelper3(arr,left,pvtPos-1);
            qsortHelper3(arr, pvtPos+1,right);
        }
    }

    //main method for testing
    public static void main( String[] args )
    {

        //get-it-up-and-running, static test case:
        int [] arr1 = {7,1,5,12,3};
        System.out.println("\narr1 init'd to: " );
        printArr(arr1);




        qsort( arr1 );
        System.out.println("arr1 after qsort: " );
        printArr(arr1);



        // randomly-generated arrays of n distinct vals
        int[] arrN = new int[10];
        for( int i = 0; i < arrN.length; i++ )
        arrN[i] = i;

        System.out.println("\narrN init'd to: " );
        printArr(arrN);

        shuffle(arrN);
        System.out.println("arrN post-shuffle: " );
        printArr(arrN);

        qsort( arrN );
        System.out.println("arrN after sort: " );
        printArr(arrN);

        /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



        //get-it-up-and-running, static test case w/ dupes:
        int [] arr2 = {7,1,5,12,3,7};
        System.out.println("\narr2 init'd to: " );
        printArr(arr2);

        qsort( arr2 );
        System.out.println("arr2 after qsort: " );
        printArr(arr2);




        // arrays of randomly generated ints

        // arrays of randomly generated ints
        int[] arrMatey = new int[20];
        for( int i = 0; i < arrMatey.length; i++ )
        arrMatey[i] = (int)( 48 * Math.random() );

        System.out.println("\narrMatey init'd to: " );
        printArr(arrMatey);
        shuffle(arrMatey);
        System.out.println("arrMatey post-shuffle: " );
        printArr(arrMatey);
        qsort( arrMatey );
        System.out.println("arrMatey after sort: " );
        printArr(arrMatey);


        int[] arrMatey2 = new int[100];
        for( int i = 0; i < arrMatey2.length; i++ )
        arrMatey2[i] = (int)( 100 * Math.random() );

        System.out.println("\narrMatey2 init'd to: large array with 1000000 elements" );
        //printArr(arrMatey);

        shuffle(arrMatey2);
        System.out.println("arrMatey1 post-shuffle: large array with 1000000 elements" );
        //printArr(arrMatey);

        long btime=System.nanoTime();

        qsort( arrMatey2 );

        long etime=System.nanoTime();

        System.out.println("arrMatey2 after sort: it's sorted " );
        //printArr(arrMatey);

        System.out.println("nanoseconds for algorithm: " + (etime-btime));


        /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)

        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
