
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
    private double limitingAmount;
    private double currentDebt;
    private double totalMoneySpent = 0.0;
    // last field is extra.It's purpose is to count the output number
    
    public Bill(double limitingAmount){
    	this.limitingAmount = limitingAmount ;
        this.currentDebt = 0.0;
    }
    public boolean check(double amount) {
    	return currentDebt + amount > limitingAmount;
    }
    public void add(double amount) {
    	currentDebt += amount;
    }
    public void pay(double amount) {
    	if (amount >= currentDebt) {
    		totalMoneySpent += currentDebt;
    		currentDebt = 0;	 
    }   else {
    	currentDebt -= amount;
    	totalMoneySpent += amount;
    }
    }
    public void changeTheLimit(double amount) {
    	limitingAmount = amount;
    }
    public double getLimitingAmount() {
    	return limitingAmount ;
    }
    public double getCurrentDebt() {
    	return currentDebt;
    }
    //get method of the extra field
    public double getTotalMoneySpent() {
    	return totalMoneySpent;
    }
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

