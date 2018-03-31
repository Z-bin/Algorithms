package sorting;

import algs4.StdIn;
import algs4.StdOut;

/*
 * ¶ÑÅÅÐò
 */
public class Heap 
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for(int k = N/2; k >= 1; k--)
		{
			sink(a, k, N);
		}
		
		while(N > 1)
		{
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	public static boolean less(Comparable[] pq, int i, int j)
	{
		return pq[i - 1].compareTo(pq[j - 1]) < 0;
	}
	
	public static void exch(Object[] pq, int i, int j)
	{
		Object swap = pq[i - 1];
		pq[i -1] = pq[j - 1];
		pq[j - 1] = swap;		
	}
	
	private static void sink(Comparable[] pq, int k, int N)
	{
		while(2 * k <= N)
		{
			int j = 2 * k;
			if(j < N && less(pq, j, j+1))
			{
				j++;
			}
			if(!less(pq, k, j))
			{
				break;
			}
			exch(pq, k, j);
			k = j;
		}
	}
	
	public static void show(Comparable[] a)
	{
		for(int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
	}
	
	public static void main(String[] args)
	{
		String[] a = StdIn.readAllStrings();
		sort(a);
		show(a);
	}
}
