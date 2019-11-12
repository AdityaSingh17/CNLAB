// Write a program for congestion control using leaky bucket algorithm.

import java.util.*;
public class Leaky 
{
	public static void main(String[] args)
 {
	Scanner my = new Scanner(System.in);
	int no_groups,bucket_size;
	System.out.print("\n Enter the bucket size : \t");
	bucket_size = my.nextInt();
	System.out.print("\n Enter the no of groups : \t");
	no_groups = my.nextInt();
	int no_packets[] = new int[no_groups];
	int in_bw[] = new int[no_groups];
	int out_bw,reqd_bw=0,tot_packets=0;
	for(int i=0;i<no_groups;i++)
        {
		System.out.print("\n Enter the no of packets for group " + (i+1) + "\t");
		no_packets[i] = my.nextInt();
		System.out.print("\n Enter the input bandwidth for the group " + (i+1) + "\t");
		in_bw[i] = my.nextInt();
		if((tot_packets+no_packets[i])<=bucket_size)
        	{
			tot_packets += no_packets[i];
        	}    
		else
        	{
			do
           		{
				System.out.println(" Bucket Overflow ");
				System.out.println(" Enter value less than " + (bucket_size-tot_packets));
				no_packets[i] = my.nextInt();        
			}while((tot_packets+no_packets[i])>bucket_size);
			
			tot_packets += no_packets[i];
        	}
		reqd_bw += (no_packets[i]*in_bw[i]);
    	}
	System.out.println("\nThe total required bandwidth is " + reqd_bw);
	System.out.println("Enter the output bandwidth ");
	out_bw = my.nextInt();
	int temp=reqd_bw;
	int rem_pkts = tot_packets;
	while((out_bw<=temp)&&(rem_pkts>0))
   	{
		System.out.println("Data Sent \n" + (--rem_pkts) + " packets remaining");
		System.out.println("Remaining Bandwidth " + (temp -= out_bw));
		if((out_bw>temp)&&(rem_pkts>0))
		System.out.println(rem_pkts + " packet(s) discarded due to insufficient bandwidth");
   	}
 }
}
