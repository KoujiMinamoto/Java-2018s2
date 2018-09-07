import java.util.*;
public class Sale
{
    ProductList prodList;
    SaleTransaction transaction;
    RandomNumberGenerator Random = new RandomNumberGenerator();
    
    public Sale()
    {
        prodList = new ProductList();
    }
    
    public void displaymenu()
    {
        System.out.println("=================================================");
        System.out.println("Welcome to the Simple Inventory Management System");
        System.out.println("=================================================");
        System.out.println("(1) Register a Product for sale");
        System.out.println("(2) Buy a Product to the Cart");
        System.out.println("(3) Remove a Product from the cart");
        System.out.println("(4) View all Available Products");        
        System.out.println("(5) Check out");
        System.out.println("(6) Get Help");
        System.out.println("(7) Exit ");
        System.out.println("=================================================");
        System.out.println("Choose an option:");
    }
    
    public void setNewProduct()
    {
        System.out.println("====Set new Product=====");
        String name = "";
        String desc = "";
        String pr;
        Scanner productNameScanner = new Scanner(System.in);
        System.out.print("Enter Product Name: ");
        name = productNameScanner.nextLine();
        while(validname(name)) 
        name = productNameScanner.nextLine();
        
        System.out.print("Enter Product Description: ");
        desc = productNameScanner.nextLine();
        while(validdesc(desc)) 
        desc = productNameScanner.nextLine();
        
        System.out.print("Enter Product Price: ");
        pr = productNameScanner.nextLine();
        while(validdouble(pr))
        pr = productNameScanner.nextLine();
        double price = Double.parseDouble(pr);
        
        int qtyOnHand =Random.GenerateRandomNumber(10,0);
        int minOrderQty = Random.GenerateRandomNumber(5,1);
        
        Product load = new Product();
        load.setname(name);
        load.setdesc(desc);
        load.setprice(price);
        load.setqtyOnHand(qtyOnHand);
        load.setminOrderQty(minOrderQty);
        prodList.addproduct(load);
        
        
    }
    
    private boolean validdouble(String pr)
    {
        try
        {
         double b = Double.parseDouble(pr);
         return false;
        }
        catch(Exception e)
        {
          System.out.print("Enter Product Price should be double: ");
          return true;
        }
    

    }
    private boolean validname(String name)
    {
        boolean isrepeated = prodList.validname(name);
        if (isrepeated)
        {
          System.out.println("Error :  name existed , please insert another name!");
          return isrepeated;
        
        }
        else
        if (name.isEmpty() || name.length() < 3 ||name.length() >25)
        {
           System.out.println("Error : please insert from 3 to 35 !");
           return true;
        }
        return false;
        
    }
    private boolean validdesc(String desc)
    {
        if (desc.isEmpty() || desc.length() > 50)
        {
           System.out.println("Error : please insert from 1 to 50 !");
           return true;
        }
        else
        return false;

    }
}
