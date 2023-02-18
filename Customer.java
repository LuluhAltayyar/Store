/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstore;

/**
 *
 * @author loloo
 */
public class Customer extends User{
    
    private int visit;
    private String customerType ;// This customer is a new customer or special customer.
    
    public Customer(String name) {
        super(name);
        this.visit=0;
        this.customerType="New customer ";
        this.type ="Customer";
    }
     public Customer(String name, int v) {
        super(name);
        this.type ="Customer";
        this.visit=v;
        if (this.visit >= 3)
            this.customerType ="Special customer ";
        else
            this.customerType ="New customer "; 
    }

    public int getVisit() {
        return visit;
    }

    public void setVisit(int v) {
        this.visit = v;
        if (this.visit >= 3)
            this.customerType ="Special customer ";
        else
            this.customerType ="New customer ";      
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomertype(String c) {
        this.customerType = c;
    }
    
    public void checkID(int id)
    {
        if(id == getID())
            System.out.println("tred ");
        else
            System.out.println("no");
            
    }
     @Override
    public void printInfromation() {
        
         System.out.print(this.customerType +": ");
        super.printInfromation(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("visits "+this.visit + " time(s).");
    }
    
    
    
    
    
    
}
