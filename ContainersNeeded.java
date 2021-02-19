package exception;
import exception.MyException; 

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContainersNeeded{
	
	/* Demonstrate () calls two functions to enter
	 the size of the wholesale and retail containers 
	 respectively, then calls a 3rd function to calculate
	  the number of retail containers needed and displays this result*/
	
	public void Demonstrate () throws IOException, MyException{
		
		int WholesaleSize; //size of ws container
		int RetailSize; //Size of rt container
		int NumberRetailNeeded=0;// num of Containers needed
		char ans; // Single char needed to store 'y' or 'n' 
		
		System.out.println("Now in Demonstrate()");
		
		while (true) {
			WholesaleSize = EnterSizeOfWholesaleContainer();
			RetailSize = EnterSizeOfRetailContainer();
			//Excercise Four
			try {
				NumberRetailNeeded= CalculateRetaillContainersNeeded(WholesaleSize, RetailSize);
			}
			catch(ArithmeticException ex)
			{
				//system.err.println("Cannot divide by zero");
				throw new ArithmeticException();
			}
			System.out.println("BAck in Demonstrate()");
			System.out.println("The number of retail containers"+ " needed is " +NumberRetailNeeded);
			System.out.println(" Perform another calculation?"+"[y/n]");
			
			ans =' ';
			while (ans!= 'y' && ans != 'Y' && ans != 'n'&& ans != 'N')
				ans = (char) System.in.read();
			System.out.println(" ");
			if (ans == 'n' || ans== 'N')
				break;
		}
	}
	
	//enters the size of the wholesale container
	public int EnterSizeOfWholesaleContainer() {
		
		Scanner in = new Scanner(System.in);
		int size;
		System.out.println("Now in EnterSizeOfWholesaleContainer()");
		System.out.println("Enter the size of the Wholesalese" + " container -");
		
		size = in.nextInt();
		
		System.out.println("");
		return size;
	}
	// enter the size of the retail container
	public int EnterSizeOfRetailContainer() {
		
		Scanner in = new Scanner(System.in);
		int size;
		System.out.println("Now in EnterSizeOfRetailContainer()");
		System.out.println("Enter the size of the Retail container" + " container -");
		
		size = in.nextInt();
		
		System.out.println("");
		return size;
	}
	// calculates the number of retail containers needed
	//and returns the result

	/*public int CalculateRetaillContainersNeeded(int wcSize, int rcSize)
	{
		System.out.println(" Now in CalculateRetaillContainersNeeded() ");
		return wcSize/rcSize;
	}*/
	
	// EXCERCISE 2
	/*public int CalculateRetaillContainersNeeded(int wcSize, int rcSize)
	{
		int quotient=0;
		try {
			System.out.println(" Now in CalculateRetaillContainersNeeded() ");
		 quotient= wcSize/rcSize;
	
		}catch(ArithmeticException ex) {
			System.err.println("Cannot divide by zero");
		}
		return quotient;
	}*/
	
	
	// EXCERCISE 3
	/*public int CalculateRetaillContainersNeeded(int wcSize, int rcSize) throws ArithmeticException 
	{
		System.out.println(" Now in CalculateRetaillContainersNeeded() ");
		return wcSize/rcSize;
	}*/
	
	
	// main method - programs starts running here	
	
	 //Excercise 6
	public int CalculateRetaillContainersNeeded(int wcSize, int rcSize) throws MyException 
	{
		System.out.println(" Now in CalculateRetaillContainersNeeded() ");
		if (rcSize== 0) {
			
			throw new MyException(" retatil container size cannot be zero");
		}
		return wcSize/rcSize;
	}
	
	public static void main (String [] args) throws IOException, MyException 
	{
		ContainersNeeded X = new ContainersNeeded();
		System.out.println("Calling Demonstrate() from MAin ()");
		//Exercise five 
		try {
			X.Demonstrate();
		}catch( ArithmeticException ex) {
			
			System.err.println("error.. null nalue");
		}catch(MyException ae) {
			
			System.err.println(ae.getMsg());
		}catch(InputMismatchException ae) {
			System.err.println("incorrect data data type");

			
		}
		catch(Exception e) {
			System.err.println("incorrect entry");

		}

		System.out.println("Returned from Demonstrate()," +" now back in main()");
	}
	
	
	
	}