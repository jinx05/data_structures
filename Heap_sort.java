/**
 * 
 */
/**
 * @author jitengirdhar
 *
 */

import java.util.Random; 

public class Heap_sort {
	
	public static int[] Heapifyer(int[] a)
	{
		//MAX heap
		int len = a[0];
		int lpaat = len/2;
		while(lpaat >0)
		{
			if(2*lpaat <= len)
			{
				Percolatedown(a,lpaat,len);
				//printh(a);
				//System.out.print("\n");
				
			}
			lpaat--;
		}
		
		return a;
		}
	
	//Percolate down to heapify using floyd's technique
	public static void Percolatedown(int[] a,int parent,int length)
	{
		
		while((2*parent) <= length)
		{
			int pval = a[parent];
			int mx = parent;
			if(2*parent <= length && pval < a[2*parent] )
			{
				mx = 2*parent;
			}
			if((2*parent + 1) <= length && a[mx] < a[2*parent +1])
			{
				mx = 2*parent + 1;
			}
			if(mx != parent)
			{
				int c = a[parent];
				a[parent] = a[mx];
				a[mx] = c;
			}else
			{
				mx = 2*parent;
			}
			
			parent = mx;
			//a = Heapifyer(a);

		}
	}
	
	//heap sort function
	public static int[] sort(int[] a)
	{
		while(a[0] > 0)
		{
			Heapifyer(a);
			int c = a[1];
			a[1] = a[a[0]];
			a[a[0]] = c;
			a[0] = a[0] - 1;
		}
		return a;
	}
	
	//As the first number represents the length of array, a modified function to print the contents
	public static void printh(int[] a)
	{
		for(int i =1; i< a.length;i++)
		{
			System.out.print(a[i]);
			System.out.print(" ");
		}
		return;
	}
	
	//main function
	public static void main(String args[])
	{
		 
		Random rand = new Random(); 
		//int[] Arr = {10,4,19,1,3,5,9,18,11,21,10};
		int[] Brr = new int[21];
		Brr[0] = 20;
		for(int i = 1;i<21;i++)
		{
			Brr[i] = rand.nextInt(50);
		}
		printh(Brr);
		System.out.print("\n");
		printh(Heapifyer(Brr));
		sort(Brr);
		System.out.print("\n");
		printh(Brr);
		
		
	}
	
}