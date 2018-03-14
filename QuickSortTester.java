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

        int[] arrMatey2 = new int[1000];
        for( int i = 0; i < arrMatey2.length; i++ )
        arrMatey2[i] = (int)( 1000 * Math.random() );
        System.out.println("\narrMatey2 init'd to: an array of size " + arrMatey2.length );
        //printArr(arrMatey);

        shuffle(arrMatey2);
        System.out.println("arrMatey2 has been shuffled" );
        //printArr(arrMatey);


        long btime, etime, total, timeDif, atime;

        total=0;
        for (int i=1;i<21;i++) {
            shuffle(arrMatey2);
            btime=System.nanoTime();
            tool.qsort(arrMatey2);
            etime=System.nanoTime();

            timeDif=etime-btime;

            total+=timeDif;

            System.out.println("Trial " + i + ": " + timeDif);

        }

        atime=total/20;

        System.out.println("Average Time for all Trials: " + atime);


    }
}
