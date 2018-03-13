## DustyScreens
#### Maryann Foley, Mohtasim Howlader, Ying Xin Jiang
# QuickSort Results

### QuickSort Notation
## Big O(n^2)

### Best case
In the best case, the chosen pivot point will end up being the median value, so it will split the array in the middle

### Worst case

In the worst case, the chosen pivot point will be on either end of the array, so it will continiously have to incriment the size of the region by one.

##### Example
This example implements a choosing of the pivot that is completly random
Starting array: {7,1,5,12,3}
choose 4th element
{7,1,5,3,12}
choose first element
{1,5,3,7,12}
choose 2nd element
{1,3,5,7,12}
It wont know that it is sorted, choose first
{1,3,5,7,12}
Done

It took 4 steps, but each step takes n time, so it will be n^2

