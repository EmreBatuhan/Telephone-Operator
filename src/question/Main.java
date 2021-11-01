
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		try {
			PrintStream outstream = new PrintStream(outFile);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		//True outstream1 which was given at email
		PrintStream outstream1;
		try {
		        outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
		        e2.printStackTrace();
		        return;
		}
        int totalCustomers = 0;
        int totalOperators = 0;//keeping track of totals to give IDs to new objects.
        
        for(int i = 0;i<N;i++) {
        	
        	int num = reader.nextInt();// num is the operation number between 1,8
        	
        	if(num == 1) {
        		String name = reader.next();
        		int age = reader.nextInt();
        		int ID = reader.nextInt();
        		double limitingAmount = reader.nextDouble();
        	    Customer customer = new Customer(totalCustomers,name,age,operators[ID],limitingAmount);
                customers[totalCustomers]= customer;
        	    totalCustomers++;
        	
        	}else if(num == 2) {
        		double talkingCharge = reader.nextDouble();  
        		double messageCost = reader.nextDouble();       		
        		double networkCharge = reader.nextDouble();
        		int discountRate = reader.nextInt();
        		Operator operator = new Operator(totalOperators,talkingCharge,messageCost,networkCharge,discountRate);
        		operators[totalOperators]= operator;
        		totalOperators++;
        		
        	}else if(num == 3) {
        		int firstID = reader.nextInt();
        		int secondID = reader.nextInt();
        		int time = reader.nextInt();
        		//Checking if the IDs are suitable
        		if (firstID != secondID) {
        			customers[firstID].talk(time,customers[secondID]);
        		} 
        	}else if(num == 4) {
        		int firstID = reader.nextInt();
        		int secondID = reader.nextInt();
        		int quantity = reader.nextInt();
        		if (firstID != secondID) {    
        		    customers[firstID].message(quantity,customers[secondID]);
        		}
        	}else if(num == 5) {
        		int ID = reader.nextInt();        	
        		double amount = reader.nextDouble();
        		customers[ID].connection(amount);
        		
        	}else if(num == 6) {
        		int ID = reader.nextInt();        		
        		double amount = reader.nextDouble();
        		customers[ID].getBill().pay(amount);
        		
        	}else if(num == 7) {
        		int customerID = reader.nextInt();
        		int operatorID = reader.nextInt();
        		customers[customerID].setOperator(operators[operatorID]);
        		
        	}else if(num == 8) {
        		int ID = reader.nextInt();
        		double amount = reader.nextDouble();
        		if (customers[ID].getBill().getCurrentDebt() < amount) {
        			customers[ID].getBill().changeTheLimit(amount);
        		}
        	}
        	
        //Printing the operators from the operators list 
        }
        for (int i = 0;i < O;i++) {
        	outstream1.print("Operator "+ i +" : "+ operators[i].getTalkingTime()+" "+operators[i].getNumOfMessage());
        	outstream1.println(String.format(" %.2f",operators[i].getNetworkUsage()));
        }
        //Printing the customers from the customers list 
        for (int i = 0;i < C;i++) {
        	outstream1.print("Customer "+ i +" :");
        	outstream1.print(String.format(" %.2f",customers[i].getBill().getTotalMoneySpent()));
        	outstream1.println(String.format(" %.2f",customers[i].getBill().getCurrentDebt()));
        }
        //Computing the most talkative and printing
        Customer mostTalk = customers[0];
        for (int i = 1;i < C;i++) {
        	if (customers[i].getTalkingTime() > mostTalk.getTalkingTime()) {
        		mostTalk = customers[i];
        	}
        }
        outstream1.println(mostTalk.getName()+" : "+mostTalk.getTalkingTime());
        
        //Computing the one with the most message and printing
        Customer mostMessage = customers[0]; 
        for (int i = 1;i < C;i++) {
        	if (customers[i].getNumOfMessage() > mostMessage.getNumOfMessage()) {
        		mostMessage = customers[i];
        	}
        }
        outstream1.println(mostMessage.getName()+" : "+mostMessage.getNumOfMessage());
        
        //Computing the one that has done the most connection and printing
        Customer mostConnection = customers[0];
        for (int i = 1;i < C;i++) {
        	if (customers[i].getNetworkUsage() > mostConnection.getNetworkUsage()) {
        		mostConnection = customers[i];
        	}
        }
        outstream1.println(String.format(mostConnection.getName()+" : "+"%.2f",mostConnection.getNetworkUsage()));
        outstream1.close();
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

