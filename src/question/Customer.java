
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private String name;
	private int age;
	private Operator operator;
	private Bill bill;
    private int talkingTime = 0;
    private int numOfMessage = 0;
    private double networkUsage = 0.0;
    // Last three fields are extra.Their purpose is to count the output numbers.
    
    public Customer(int ID,String name,int age,Operator operator,double limitingAmount) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.operator = operator;
        this.bill = new Bill(limitingAmount);//Creating customer's bill
        }
    public void talk(int minute,Customer other) {
    	double charge = operator.calculateTalkingCost(minute,this);
        if (bill.check(charge) == false) {
        	bill.add(charge);
        	talkingTime += minute;
        	operator.addTalkingTime(minute);
            other.talkingTime += minute;
            other.operator.addTalkingTime(minute);
        }
    }
    public void message(int quantity,Customer other) {
    	double charge = operator.calculateMessageCost(quantity,this,other);
    	if (bill.check(charge) == false) {
        	bill.add(charge);
    	    operator.addNumOfMessage(quantity);
    	    numOfMessage += quantity;
    	}
    }
    public void connection(double amount) {
    	double charge = operator.calculateNetworkCost(amount);
    	if (bill.check(charge) == false) {
        	bill.add(charge);
    	    operator.addNetworkUsage(amount);
    	    networkUsage += amount;
    	}
    }
    // getName was not obligated but i needed it in project
    public String getName() {
    	return name;
    }
    public int getAge() {
    	return age;
    }
    public Operator getOperator() {
    	return operator;
    }
    public Bill getBill() {
    	return bill;
    }
    public void setAge(int newAge) {
    	age = newAge;
    }
    public void setOperator(Operator newOperator) {
    	operator = newOperator;
    }
    public void setBill(Bill newBill) {
    	bill = newBill;
    }
    //get methods of the three extra fields
    public int getTalkingTime() {
    	return talkingTime;
    }
    public int getNumOfMessage() {
    	return numOfMessage;
    }
    public double getNetworkUsage() {
    	return networkUsage;
    }
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

