package com.company;
/*
Here we have new way for sorting numbers i explain it below:
 we choose the last element of the array then we compare remainders with it then we divide the number in two groups first group are less than the last one and second group are more
than last one after that we put the last one exactly between two group (ok here our recursive is start) we send these two group to that function(part) again and again... until the members
of the group become two then there is no need to call function again and sorting is finished
 */
public class Main
{
    //this is the function that divide the list to two group:
    static int part(int arr[], int low,int high)
    {
        int pivot = arr[high], i ;
        {
            i = low-1;
            for ( ; low<high; low++)
            {
                if (arr[low] < pivot)
                {
                    i++;
                    int temp = arr[i];
                    arr[i]   = arr[low];
                    arr[low] = temp;

                }
                //it was extra: else { }
            }
            int temp = arr[++i];
            arr[i] = arr[high];
            arr[high] = temp;
        }
        return i;
    }
    //here the our recursive function which send groups to part for comparing:
    static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = part(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
    //it is obvious by the name
    static void print(int... arr)
    {
        for (int i: arr)
            System.out.print(i + " ");
        System.out.println();
    }
    //only god knows what the hell this one should do!!
    static double power(double x, double y) {
        if (y == 0)
            return 1;

        double result = x;

        for (int i = 1 ; i < y ; i++) {
            result = result * x;
        }

        return result;
    }
    // Driver program
    public static void main(String args[])
    {
        int a[] = {10, 7, 8, 9,1,5};
        //we need the number of list to which one is the last one :
        int n = a.length;
        sort(a, 0, n-1);
        print(a);
    }
}
