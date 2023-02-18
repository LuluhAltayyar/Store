/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author loloo
 */
public  class data extends Exception{
    
    
        LinkedList <Employee> employees = new LinkedList<>();
        LinkedList <Customer> customers = new LinkedList<>();


         String name = null , txt =null;
         double salary =0.0d ;
         boolean manager = false;
         int time;
         int kep;
         
       public data(int b)
       {}
       public data() 
       {
           
           try{
           // Create customers from text files (.txt) 
         File file = new File("D:\\NetBeans luluh\\ProjectStore\\testone.txt");
          Scanner sc = new Scanner(file);
          while (sc.hasNextLine())
          {
              txt=sc.nextLine();
              customers.add(new Customer(txt));
          }
          
           // Create Employee from text files (.txt) 
           file = new File("D:\\NetBeans luluh\\ProjectStore\\test.txt");
           sc = new Scanner(file);
          while (sc.hasNextLine())
          {
              txt=sc.nextLine();
               time =1;
               kep=1;
              for (int i = 0; i < txt.length(); i++)
              {
                  if(',' ==  txt.charAt(i))
                  {
                      if (time == 1)
                      {
                         name =  txt.substring(0,i);
                         time++;
                         kep += i;
                      }
                      if(time == 3)
                       {
                         salary =  Double.parseDouble(txt.substring(kep,i));
                         time++;
                           kep = i+1;
                      }
                        if(time == 5)
                       {
                         manager = Boolean.parseBoolean( txt.substring(kep,i));
                         time++;
                          kep= i+1;
                      }
                        time++;                  
              }
                  
                 
              }
               employees.add(new Employee(name,salary,manager));
        // System.out.println(name + " "+ salary + " "+ manager);
        
           }
           }
         catch(FileNotFoundException  e)
        {
            System.out.println("Your enter something worng  -buyUser- 77777777777");
        }
        
    
       }
       
       public void print()
       {
           System.out.println("The users are: ");
            for (int i = 0; i < customers.size(); i++) 
           {
               customers.get(i).printInfromation();
           }
            
           for (int i = 0; i < employees.size(); i++) 
           {
               employees.get(i).printInfromation();
           }
       }
       
       public void allupdateSalary(double bonus)
     {
         
         if (bonus !=0 && employees.isEmpty() == false )
         {
              System.out.println("\nIncrease all salaries with "+bonus+"%" );
          bonus/=100;
         double m;
         for (int i = 0; i < employees.size(); i++) 
         {
            m= bonus * employees.get(i).getSalary();
            employees.get(i).setSalary(employees.get(i).getSalary() + m);            
         }
         
         // print
          for (int i = 0; i < employees.size(); i++) 
           {
               employees.get(i).printInfromation();
           }
         
         
         }
         else
         System.out.println("Can't bonus is 0 or There aren't employees ");
     }
       
    public  Customer idCustomer(int id)
    {
        for (int i = 0; i < customers.size(); i++) 
        {
            if (id ==  customers.get(i).getID())
                return customers.get(i);
        }
        return null;
    }
        
    public  User idEmployee(int id)
    {
        for (int i = 0; i < employees.size()+ customers.size(); i++) 
        {
            if (id ==  employees.get(i).getID())
                 return employees.get(i);
            if (id ==  customers.get(i).getID())
                 return customers.get(i);
        }
        return null;
    }

}
        
    

