/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectstore;
import java.util.Scanner;
/**
 *
 * @author loloo
 */
public  class Products {
    
    public static int count =0;
    private int IDProduct;
    private String name;
    private double price;

    public Products(String n, double p) {
        this.IDProduct = count++;
        this.name = n;
        this.price = p;
    }

    public int getIDpProduct() {
        return IDProduct;
    }

    public void setIDpProduct(int IDpProduct) {
        this.IDProduct = IDpProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    /*
    public abstract void isExist();
    public abstract void addProduct();/*
    public abstract void removeProduct();
    public abstract void totalPrice();
    public  void buy(){}*/
    
    public void addProduct(String n, double p)
    {
        this.IDProduct = count++;
        this.name = n;
        this.price = p;
    }
    
     public void addProductEmployee(User i)
    {
        
        if (i.type.equals("Employee"))   
        {
             Scanner s= new Scanner(System.in);
        
        try {
        System.out.print("Enter name of Product: ");
        String n = s.next();
        System.out.print("Enter price the Product: ");
        double p = s.nextDouble();
       
        this.IDProduct = count++;
        this.name = n;
        this.price = p;
        
        } catch (Exception e) {
            System.out.println("Your information is wrong! Try again ");
        }
        
        s.close();
        }
        else
            System.out.println("can't add a product. Only employees or managers can add the products");
    }
    
       public void removeProduct(int idPro)
    {
        Employee e = null ;
        System.out.println(e.isManager());
        if(e.isManager())
        for (int i = 0; i <= count; i++)
        {
            if(idPro == i)
            {
                 System.out.println("Can't remove a product. Only managers can remove the products");
            }
            else
             System.out.println("The id Product is wrong plaes enter corrct id Product ");
            
        }
    }
    
    
}
