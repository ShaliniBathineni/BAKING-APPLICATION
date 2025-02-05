package BankApplication;

import java.util.Scanner;

public class election {

	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("eligible for School");
		int year=sc.nextInt();
		if(year<5)
			try {
			throw new Shalini();
		}
		catch(Exception e){
			System.out.println(e);
          e.getStackTrace();
			//System.out.println(e.getMessage());
		}
		 else {
			System.out.println("not eligible for School ");
		}

	}

}
