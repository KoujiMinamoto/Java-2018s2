import java.util.*;
import java.io.*;

public class Product
{
    
    private String name;
    private String desc;
    private double price;
    private int qtyOnHand;
    private int minOrderQty;
    private int Qty = 0;
    
    public Product()
    {
        
    }

    public String getname()
    {
       return name;  
    }
   
    public void setname(String name1) 
    {
       name = name1;
    }
    
    public String getdescription()
    {
       return desc;  
    }
   
    public void setdesc(String de) 
    {
       desc = de;
    }    
    
    public double getprice()
    {
       return price;  
    }
   
    public void setprice(double pr) 
    {
       price = pr;
    }        
    
    public int getqtyOnHand()
    {
       return qtyOnHand;  
    }
   
    public void setqtyOnHand(int qty) 
    {
       qtyOnHand = qty;
    }        
    
    public int getminOrderQty()
    {
       return minOrderQty;  
    }
   
    public void setminOrderQty(int min) 
    {
       minOrderQty = min;
    }        
    
    public int getQty()
    {
       return Qty;  
    }
   
    public void setQty(int qty) 
    {
       Qty = Qty;
    }        
}
