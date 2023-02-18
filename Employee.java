/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstore;

public class Employee extends User{
    
    private double salary;
    private boolean manager;
    
     public Employee() {
        super();
        this.salary=0;
        this.manager= false;
       this.type ="Employee";
    }
    public Employee(String name) {
        super(name);
        this.salary=0;
        this.manager= false;
       this.type ="Employee";
    }
     public Employee(String name, double s) {
        super(name);
        this.salary=s;
        this.manager= false;
        this.type ="Employee";
        
    }
      public Employee(String name, double s, boolean m) {
        super(name);
        this.salary=s;
        this.manager=m;
        this.type ="Employee";
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean m) {
        this.manager = m;
    }
    
     //we can update the salary and increase it with a specific percentage as a bonus.
     public void updateSalary(double bonus)
     {
         bonus= (bonus/100)*this.salary;
         this.salary= bonus +this.salary;
     }
     /*  public static void updateSalary6(double bonus, int id)
     {
         bonus= (bonus/100)*;
         this.salary= bonus +this.salary;
     }*/
     

      public void allupdateSalary(double bonus)// خطأ
     {
          
         bonus/=100;
         int cou= User.count -1000;
         int cr = 1000;
         System.out.println(" rrrrrrrrrrrrr" + checkId(cr));
         /*for (int i = 0; i < cou; i++) 
         {
            if(checkId(cr).equals("Employee") )
            {
               bonus *= getSalary();
               setSalary(bonus+getSalary());
                System.out.println(" name: " + getName()+ " Sa : "+ getSalary());
             }
         }*/

     }

    @Override
    public void printInfromation() {
        if(this.manager != false)
        {
          System.out.print("Employee (manager): ");
          super.printInfromation(); //To change body of generated methods, choose Tools | Templates.
          System.out.println("has " + this.salary+"RS.");
        }
      
        else
        {
          System.out.print("Employee: ");
          super.printInfromation(); //To change body of generated methods, choose Tools | Templates.
          System.out.println("has " + this.salary+"RS.");
          
        }
        
        
           
    }
     
     
    
}
