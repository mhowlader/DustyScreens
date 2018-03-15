public class QuickSortTester {

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


    public static void main(String[] args) {
        QuickSort tool=new QuickSort();
/*
        System.out.println("\nProof of QuickSort Working");

        //get-it-up-and-running, static test case:
        int [] arr1 = {7,1,5,12,3};
        System.out.println("\narr1 init'd to: " );
        printArr(arr1);

        tool.qsort( arr1 );
        System.out.println("arr1 after qsort: " );
        printArr(arr1);

        //get-it-up-and-running, static test case w/ dupes:
        int [] arr2 = {7,1,5,12,3,7};
        System.out.println("\narr2 init'd to: " );
        printArr(arr2);

        tool.qsort( arr2 );
        System.out.println("arr2 after qsort: " );
        printArr(arr2);

*/

       // System.out.println("\n\nTrials for Testing Runtimes:");

        for (int g=11;g>0;g--) {



            int[] arrMatey2 = new int[g*1000];
            for( int i = 0; i < arrMatey2.length; i++ )
            arrMatey2[i] = (int)( (g*1000) * Math.random() );
            //System.out.println(arrMatey2.length );
            //printArr(arrMatey);

            long btime, etime, total, timeDif, atime;

            total=0;
            for (int i=1;i<11;i++) {



                shuffle(arrMatey2);
                btime=System.nanoTime();
                tool.qsort(arrMatey2);
                etime=System.nanoTime();

                timeDif=etime-btime;

                total+=timeDif;

                //System.out.println("Trial " + i + ": " + timeDif);

            }

            atime=total/10;
            if (arrMatey2.length <= 10000){
            System.out.println(arrMatey2.length + "," + atime);}

        }


    }
}
