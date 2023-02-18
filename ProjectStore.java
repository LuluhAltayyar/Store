/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstore;

import java.util.LinkedList;
import java.io.File;
import java.util.Scanner;


//import java.io.FileNotFoundException;





/**
 *
 * @author loloo
 */
 
public  class ProjectStore extends Exception {

         static  data d =new data() ;
         
    public static void main(String[] args) throws Exception {
        
      
       
        Store s= new Store();
        s.printStore();
        
        System.out.println("\n");
       
        d.print();
        d.allupdateSalary(15);
        System.out.println("");
        
      s.menu();
       
           
    }

     
     public static Customer idCustomer(int id)
        {
           
          return d.idCustomer(id);
            
        }
     
       public static User idEmployee(int id)
        {
           
          return d.idEmployee(id);
            
        }
       
}
