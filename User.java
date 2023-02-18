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
public abstract class User 
{
    
    public static int count =1000  ;// generated automatically in a sequence from 1000
    protected int ID;
    private String name;
    public String type; // type of user is Customer or Employee.

     public User() {
        this.name ="null";
        this.ID = 0;
    }
     
    public User(String name) {
        this.name = name;
        this.ID = count++;
    }

    public void setName(String n) {
        this.name = n;
    }
    
    public void setID() {
        this.ID = count++;
    }

    public  int getID() {
        return this.ID;
    }
    

    public String getName() {
        return this.name;
    }
    
    public void print() //Polymorphism  سوي بها
    {
        System.out.println("The Users are: ");
    }
    public void printInfromation()
    {
        System.out.print(this.name+ "("+ID+") ");
    }
    
    public String checkId(int ch)
    {
        if(ch == getID())
            return type;
        
        return null;
    }
    
   
}
