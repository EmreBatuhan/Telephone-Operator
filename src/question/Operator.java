
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private double talkingCharge;
	private double messageCost;
	private double networkCharge;
	private int discountRate;
	private int talkingTime = 0; 
    private int numOfMessage = 0;
    private double networkUsage = 0.0; 
    // Last three fields are extra.Their purpose is to count the output numbers.
    
    public Operator(int ID,double talkingCharge,double messageCost,double networkCharge,int discountRate) {
    	this.ID = ID;
    	this.talkingCharge = talkingCharge;
    	this.messageCost= messageCost;
    	this.networkCharge = networkCharge;
    	this.discountRate = discountRate;
    }
    
    public double calculateTalkingCost(int minute,Customer customer) {
    	if (customer.getAge()>65 || customer.getAge()<18) {
    		return minute*talkingCharge*(100-discountRate)/100;
    	}
    	else {
    		return minute*talkingCharge;
    	}
    }
    public double calculateMessageCost(int quantity, Customer customer,Customer other) {
    	if (customer.getOperator() == other.getOperator()) {
    		return quantity*messageCost*(100-discountRate)/100;
    	}
    	else {
    		return quantity*messageCost;
    	}    	
    }
    public double calculateNetworkCost(double amount) {
    	return amount*networkCharge;
    	   	
    }
    public double getTalkingCharge() {
    	return talkingCharge;	
    }
    public double getMessageCost() {
    	return messageCost;
    }
    public double getNetworkCharge() {
    	return networkCharge;
    }
    public double getDiscountRate() {
    	return discountRate;
    }
    public void setTalkingCharge(double newTalkingCharge) {
    	talkingCharge = newTalkingCharge;
    }
    public void setMessageCost(double newMessageCost) {
    	messageCost = newMessageCost;
    }
    public void setNetworkCharge(double newNetworkCharge) {
    	networkCharge = newNetworkCharge;
    }
    public void setDiscountRate(int newDiscountRate) {
    	discountRate = newDiscountRate;
    }
    // these last six methods are add and get methods of extra fields
    public void addTalkingTime(int minute) {
    	talkingTime += minute;
    }
    public void addNumOfMessage(int quantity) {
    	numOfMessage += quantity;
    }
    public void addNetworkUsage(double amount) {
    	networkUsage += amount;
    }
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

