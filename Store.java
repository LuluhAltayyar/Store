/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstore;

import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author loloo
 */
public class Store extends data
{
    private static final Scanner  s = new Scanner(System.in);
    private String name;
    private static final int maximumSize =100;
    private LinkedList<Products> products = new LinkedList<>();
    private LinkedList<String> SpecialProducts1= new LinkedList<String>(); 
    private LinkedList<String> SpecialProducts2= new LinkedList<String>(); 

   private double intputUser;
   private String intputUserString;
   private int intputUserint;
    
    
    public Store() 
    {
        this.name="Happy";
        // Insert the Products
        products.add(new Products("Phone", 5000));
        products.add(new Products("Table", 200));
        products.add(new Products("Pen", 100));
        products.add(new Products("Cover", 80));
        products.add(new Products("Ipad", 3000));
        listSpecialProducts();

    }
    
    public Store(String n)
    {
        this.name=n;
        // Insert the Products
        products.add(new Products("Phone", 5000));
        products.add(new Products("Table", 200));
        products.add(new Products("Pen", 100));
        products.add(new Products("Cover", 80));
        products.add(new Products("Ipad", 3000));
        listSpecialProducts();
    }
    
    public void printStore()
    {
        System.out.println("Welcome in "+this.name+ " Store \nIt contains "+products.size()+ " product(s)");
        for (int i = 0; i < products.size(); i++) 
        {
           System.out.println("Products("+ products.get(i).getIDpProduct()+"): "
                               +products.get(i).getName()+" costs "  +products.get(i).getPrice()+" RS.");
        }
    }
    
    public void menu()
    {
        try{
        System.out.println("Hi enter 1 for Customer or 2 for Employee   ");  
        intputUserint = s.nextInt();
        
            switch ( intputUserint )
            {
                case 1:menuCustomer(); 
                break;
                case 2: menuEmployee(); 
                break;
            }
        }
        catch( Exception e)
        {
            System.out.println(" Your entered something wrong");
        }
    }
    
      

    public void menuCustomer()
    {
        try{
        System.out.println("Hi Custome you can choice: \n 1: viwe Products  \n 2: Is Exist Product  \n 3:Buy  \n 4:Special Products  "
                + " \nOr enter -1 to finsh  ");
        
        intputUserint = s.nextInt();
        while(intputUserint != -1)
        {
            switch ( intputUserint )
            {
                case 1:printStore() ; 
                break;
                case 2: isExistUesr(); 
                break;
                case 3:buyUser(); 
                break;
                case 4: SpecialProductsUser();
                break;
               
            }
            System.out.println("Hi you choice: \n 1: viwe Products  \n 2: Is Exist Product  \n 3:Buy  \n 4:Special Products  "
                + " \n Enter -1 to finsh  ");
            intputUserint = s.nextInt();
        }
        finall();
        }
        catch( Exception e)
        {
            System.out.println(" Your entered something wrong");
        }
    }
    
    
    
    public void menuEmployee()
    {
        try{
        System.out.println("Hi Employee you choice:\n 1: viwe Products  \n 2: Is Exist Product \n 3:Add Product  \n 4:remove Product"
                + " \n Enter -1 to finsh  ");
        
        intputUserint = s.nextInt();
        while(intputUserint != -1)
        {
            switch ( intputUserint )
            {
                case 1:printStore() ; 
                break;
                case 2: isExistUesr(); 
                break;
                case 3:addProduct(); 
                break;
                case 4: removeProductUser();
                break;
               
            }
            System.out.println("Hi you choice: \n 1: Is Exist Product \n 2:Add Product \n 3:Add Product  \n 4:remove Product"
                + " \n Enter -1 to finsh  ");
            intputUserint = s.nextInt();
        }
        finall();
        }
        catch( Exception e)
        {
            System.out.println(" Your entered something wrong");
        }
    }
        
        
       
     public int isExist(int id)
    {
        int y= 0;
        for (int i = 0; i < products.size(); i++) 
        {
            if(id == products.get(i).getIDpProduct())
            {
                System.out.println("The products "+products.get(i).getName() + " is exist");
                return products.get(i).getIDpProduct();
            }
        }
            System.out.println("The products "+ id + " is not exist");
            return -1;
        
    }
      
       public int isExistUesr()
    {
        Scanner s = new Scanner(System.in);
        int intputUser;

            System.out.println("Enter the ID for product you want: ");
            try{
                intputUser= s.nextInt();
                int y= 0;
        for (int i = 0; i < products.size(); i++) 
        {
            if(intputUser == products.get(i).getIDpProduct())
            {
                System.out.println("The products "+products.get(i).getName() + " is exist");
                y++;
                return products.get(i).getIDpProduct();
            }
        }
        if (y== 0)
            System.out.println("The products "+ intputUser + " is not exist");  
            }
            catch(Exception e)
            {
                System.out.println(" Your entered something wrong");
            }
             return -1;
    }
       
    public void addProduct(String nameP , double pr)// for 
    {
        
     if (products.getLast().getIDpProduct() >= maximumSize)
     {
         System.out.println("The store has maximum products");
     }
     else
     {
         products.add(new Products(nameP, pr));
         System.out.println("Add: "+ nameP+ "  Successfully to the store.");
          printStore();
     }
    }
    
    
 
    
    
    public void addProduct()// for  user
    {
     if (products.getLast().getIDpProduct() >= maximumSize)
     {
         System.out.println("The store has maximum products");
     }
     else
     {
       
        System.out.println("Enter name product: ");
        try{
            intputUserString= s.next();
            System.out.println("Enter price of product: ");
            intputUser =s.nextDouble();
            products.add(new Products(intputUserString, intputUser));
            System.out.println("Add: "+ intputUserString+ "  Successfully to the store.");
        }
        catch(Exception e)
        {
           System.out.println(" Your entered something wrong");
        }
      printStore();
     }
    
    }
   
    public void removeProduct(User u, int id)
    {
         
        if ( u instanceof Employee &&((Employee) u).isManager() )
        {
             if( isExist(id) != -1)
             {
               products.remove(id);
                 System.out.println("Remove: "+ products.get(id).getName()+ "  Successfully to the store.");
               printStore();
             }
      
         }
        else
            System.out.println("Can't remove a product. Only managers can remove the product");

    }
    
    public void removeProductUser()
    {
        try
        {         
         System.out.println("Enter your ID: ");
         intputUserint = s.nextInt();
         User u = ProjectStore.idEmployee(intputUserint);
         
        if(u instanceof Employee &&((Employee) u).isManager())
        {
          JFrame f = new JFrame("Welcome ");
          f.setSize(700, 600);
          f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setDefaultLookAndFeelDecorated(true);

        JLabel labelM = new JLabel("Welcome in "+this.name+ " Store \nIt contains "+products.size()+ " product(s)");
        labelM.setBounds(50, 50, 600, 30);
        int x = 80;
   
        for (int i = 0; i < products.size(); i++) 
        {
          JLabel label = new JLabel("Products("+ products.get(i).getIDpProduct()+"): "
                               +products.get(i).getName()+" costs "  +products.get(i).getPrice()+" RS.");
         label.setBounds(50, x, 300, 100);
         f.add(label);
         x += 30;
        }
  
   
       JLabel label = new JLabel("Ener the product(s) you want to remove:");
       label.setBounds(50, x, 300, 100);
       x += 100;
     
      JTextField motto1 = new JTextField();
       //set size of the text box
      motto1.setBounds(50, x, 200, 30);
   
   //add elements to the frame
   f.add(labelM);
   f.add(motto1);
   f.setLayout(null);
   f.setVisible(true);
   //add a button
    JButton b = new JButton("Click");
    b.setBounds(50, x+50, 100, 30);
    //add button to the frame
   f.add(b);
   b.addActionListener((ActionEvent ActionListener) -> {
    
   int num = Integer.parseInt(motto1.getText()) ;
   
             if( isExist(num) != -1)
             {
                 JLabel label3 = new JLabel("Remove: "+ products.get(num).getName()+ "  Successfully to the store.");
                 products.remove(num);
                label3.setBounds(50, 450, 600, 30);
                f.add(label3); 
            }
            else
            {
              JLabel label3 = new JLabel("The products "+num+" is not exist");
              label3.setBounds(50, 500, 600, 30);
              f.add(label3);
            }
});
        }
        else
           System.out.println("Can't remove a product. Only managers can remove the product");

         }
         catch(Exception e)
         {
             System.out.println(" Your entered something wrong");
         }  
    }
    
        public void buyUser() throws Exception // buy products, The number of times for the same customer who wants to buy with a different invoice
    {
        try{
        System.out.println("Enter your ID: ");
        int id= s.nextInt();
        Customer c =ProjectStore.idCustomer(id);
        if (c != null)
        {
              System.out.println("If you want to buy enter number 1 or enter number 2 to stop ");
             intputUserint= s.nextInt();
         while(intputUserint == 1)
         {
             contBuyUesr(c);
              System.out.println("If you want to buy enter number 1 or enter number 2 to stop ");
             intputUserint= s.nextInt();
             
            
         }
        }
        else
            System.out.println("this not Customer");
         }
        catch(Exception e)
        {
            System.out.println(" Your entered something wrong");
        }
    }
    
    
     public void contBuyUesr( Customer c)//list of products
    {
        try{
         printStore();
        System.out.println("Enter number the product(s) you want to buy or enter -1 to stop ");
          intputUserint= s.nextInt();
           LinkedList list = new LinkedList();
           
          while(intputUserint != -1)
          {
              list.add(intputUserint);
              System.out.println("enter more product(s) you want to buy or enter -1 to stop ");
              intputUserint= s.nextInt();
             
          }
           buy(c, list);
        }
        catch(Exception e)
        {
            System.out.println( "Your entered something wrong");
        }
    }
    
    public void buy(Customer c,LinkedList list)// show the products user buy and remove from stor
    {
        
        int p=0;
        if(checkProducts(list) == 1) // buy
        {
             c.setVisit(c.getVisit()+1);
             c.printInfromation();
            System.out.println("\nThe user bought: ");

            
            for (int i = 0; i < list.size(); i++) 
        {
          
            for (int j = 0; j < products.size(); j++)
            { 
            if(list.get(i).equals( products.get(j).getIDpProduct()))
            {
             System.out.println("Products("+ products.get(j).getIDpProduct()+"): "
                               +products.get(j).getName()+" costs "  +products.get(j).getPrice()+" RS.");
           
            p+= products.get(j).getPrice();
            products.remove(j);
             continue;
            }
        }
        }
                
            totalPrice(p , c.getVisit());
        }
        
        else // not buy
        {
            System.out.println("Sorry, the product(s) is not exist in the store");
        }
        printStore();
    }
    
    public int checkProducts(LinkedList list) // Check all products the user want to exist or not
    {
        int check=0;
        int y=0;
        
        System.out.println("\nThr user need: ");
        
        for (int i = 0; i < list.size(); i++) 
        {
            y=0;
            for (int j = 0; j < products.size(); j++)
             if(list.get(i).equals( products.get(j).getIDpProduct()))
              {
                 System.out.println("Products("+ products.get(j).getIDpProduct()+"): "
                               +products.get(j).getName()+" costs "  +products.get(j).getPrice()+" RS.");
                 y++;
                 break;
            }
            if(y == 0)
            {
                 System.out.println("Products("+ list.get(i)+ "): is not exist");
                check++;
            }
        }
        
        if( check != 0)
            return -1;
        return 1;
    }
    
    public void totalPrice(int pr , int c)
    { 
        if (c >=3)
        {
            System.out.println("With total price: "+ (pr-(pr*0.25))+"RS\n");
        }
        else
        System.out.println("With total price: "+ pr+"RS\n");
    }
        
    public void finall()// to close Scanner
    {
        s.close();
    } 
      
      public void listSpecialProducts() {
      
        SpecialProducts1.add("Phone");
        SpecialProducts1.add("Pen");
        SpecialProducts1.add("Cover");
        
        SpecialProducts2.add("Table");
        SpecialProducts2.add("Ipad");
    }
    
     public void SpecialProductsUser()  //User
    {
        try
        {
            System.out.println("Enter name of the Special Products ");
            intputUserString=s.next();
             
         for (int i = 0; i < products.size(); i++) 
         {
            if(intputUserString.equals(SpecialProducts1.get(i)))
            {
                System.out.println("("+ intputUserString + ") The relation offers relateds between the following special products: ");
                printspecialProducts(1);
                 break;
            }
            else if(intputUserString.equals(SpecialProducts2.get(i)))
            {
             System.out.println("("+ intputUserString + ") The relation offers relateds between the following special products: ");
                printspecialProducts(2);
                break;
            }
         }    
        }
         catch(Exception e)
         { System.out.println(" Your entered something wrong"); }
           
    }
    
    
     public void printspecialProducts(int g) 
    {
       
        if(g ==1 )
        {
        System.out.println("The list of the frist special products:");
            for (int i = 0; i < SpecialProducts1.size(); i++)
                for (int j = 0; j < products.size(); j++)
                    if(SpecialProducts1.get(i).equals(products.get(j).getName()))
                         System.out.println("Products("+ products.get(j).getIDpProduct()+"): "
                               +products.get(j).getName()+" costs "  +products.get(j).getPrice()+" RS.");           
        }
        else
        {
        System.out.println("The list of the second special products:");
            for (int i = 0; i < SpecialProducts2.size(); i++)
                for (int j = 0; j < products.size(); j++)
                  if(SpecialProducts2.get(i).equals(products.get(j).getName()))
                    System.out.println("Products("+ products.get(j).getIDpProduct()+"): "
                               +products.get(j).getName()+" costs "  +products.get(j).getPrice()+" RS.");
        
        }
    }
      
}