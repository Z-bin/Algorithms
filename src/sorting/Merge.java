package sorting;

import javax.swing.plaf.metal.MetalRadioButtonUI;
import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;
import javax.tools.JavaFileObject.Kind;

import algs4.StdIn;
import algs4.StdOut;

public class Merge 
{
	public static Comparable[] aux;	
	
	private static boolean less(Comparable v, Comparable w) 
	{
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) 
	{
		for (int i = 0; i < a.length; i++) 
		{
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) 
	{
		for (int i = 0; i < a.length; i++) 
		{
			if (less(a[i], a[i - 1])) {
				return false;
			} 
		}
		return true;
	}

	public static void merge(Comparable[] a, int lo, int mid, int hi)
	{
		int i = lo, j = mid+1;
		
		for(int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		for(int k = lo; k <= hi; k++)
		{
			if(i > mid)
				a[k] = aux[j++];
			else if(j > hi)
				a[k] = aux[i++];
			else if(less(aux[j], aux[i]))
				a[k] = aux[j++];
			else 
				a[k] = aux[i++];			
		}
	}
	
	//自顶向下
	/*
	public static void sort(Comparable[] a)
	{
		aux =new Comparable[a.length];
		sort(a, 0, a.length-1);
	}
	*/

	//自底向上
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		aux = new Comparable[N];
		for(int sz = 1; sz < N; sz +=sz)
			for(int lo = 0; lo < N - sz; lo +=sz+sz)
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));		
	}
	
	public static void sort(Comparable[] a, int lo, int hi)
	{
		if(hi <= lo)
			return;
		int mid = lo + ((hi - lo) >> 1);
		sort(a, lo ,mid);
		sort(a, mid+1, hi);	
		merge(a, lo, mid, hi);
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}
}
