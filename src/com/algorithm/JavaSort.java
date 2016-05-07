package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaSort {

	public static void main(String[] args) {
	 int num[]=new int[100];
	 String curnum;
	 BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
	 for(int i=0;i<10;i++)
	 {
		 try {
			curnum= read.readLine();
			num[i]=Integer.valueOf(curnum);
			System.out.print(num[i]+" ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 System.out.println();
	 int temp;
	 for(int i=1;i<10;i++)
		 for(int j=0;j<10-i;j++)
		 {
			 if(num[j]>num[j+1])
			 {
				 temp=num[j];
				 num[j]=num[j+1];
				 num[j+1]=temp;
			 }
		 }
	 for(int i=0;i<10;i++)
		 System.out.print(num[i]+" ");
	}

}
