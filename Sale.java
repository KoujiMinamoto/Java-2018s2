import java.util.*;
public class Sale
{
    ProductList prodList;
    SaleTransaction transaction;
    RandomNumberGenerator Random = new RandomNumberGenerator();
    
    public Sale()
    {
        prodList = new ProductList();
        transaction = new SaleTransaction();
    }
    
    public void run()
    {
        boolean exit = false;
        Scanner input = new Scanner(System.in);
        while (!exit)
        {
           displaymenu();
           String iobuffer = input.nextLine(); 
           System.out.println("");
           if (validBlank(iobuffer))
         { 
           char option = iobuffer.charAt(0);
          if (validOption(option))
          {
           switch(option)
           {
                case '1': if(prodList.getnumberofproducts()<=5)
                         {
                             setNewProduct();
                         }
                         else
                         {
                             System.out.println("Error : just can be 5 products");
                         }
                         break;
                case '2': if(prodList.getnumberofproducts()<=3&&prodList.getnumberofproducts()>0)
                         {
                            buyProduct();
                         }
                         else
                         {
                            System.out.println("Error : just can buy 3 products or do no1 first");
                         }
                         break;
                case '3': if(transaction.getnumberofproducts()>0)
                         {
                            deleteproduct();
                         }
                         else
                         {
                            System.out.println("Error : should buy first");
                         }
                        break;
                case '4': showProduct();
                         break;
                case '5': checkout();
                         break;
                case '6': gethelp();
                         break;         
                case '7': 
                        exit = true;
                        System.out.println("Goodbye. ");
                        break;
        
               
            }
          }
        }
        }
    
    }
    
    private boolean validBlank(String iobuffer)
    {
    
      if (iobuffer.isEmpty() || iobuffer.length() > 1)
            {
                System.out.println("Error : please insert from 1 to 7 !");
                return false;
            }
            return true;
    
    }
     
    private boolean validOption(char option) //method to check char option
    {
        
        if (option < '1' || option > '7')
        {
            System.out.println("Error : please insert from 1 to 7!");
            return false;
        }
        return true;        
    }
    
    public void gethelp()
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
    
    public void buyProduct()
    {
        boolean exit = false;
        showProduct();
        while(!exit)
        {
            System.out.println("====Select a Product=====");
            Scanner choice = new Scanner(System.in);
            int i = choice.nextInt();
            if(i>0 && i<=prodList.getnumberofproducts())
            {
                Product load =new Product();
                load.setname(prodList.getProducts().get(i-1).getname());
                load.setdesc(prodList.getProducts().get(i-1).getdescription());
                load.setprice(prodList.getProducts().get(i-1).getprice());
                load.setqtyOnHand(prodList.getProducts().get(i-1).getqtyOnHand());
                load.setminOrderQty(prodList.getProducts().get(i-1).getminOrderQty());
                
                System.out.println("====Select a number you want buy=====");
                int n = choice.nextInt();
                if(n>=prodList.getProducts().get(i-1).getminOrderQty()&&n<=prodList.getProducts().get(i-1).getqtyOnHand())
                {
       
                    load.setQty(n);   
                    transaction.addproduct(load);
                    
                   
                }
                else
                {
                    System.out.println("error");
                }
                exit = true;
                
            
            }
            
        }
    

    
    
    
    }
    
    private void deleteproduct()
    {
        boolean exit = false;
        showcartProduct();
        while(!exit)
        {
            System.out.println("====Select a Product=====");
            Scanner choice = new Scanner(System.in);
            int i = choice.nextInt();
            if(i>0 && i<=transaction.getnumberofproducts())
            {
                transaction.delete(i-1);
                System.out.println("have been deleted");
            
            }
            exit= true;
        }
    
    
    
    }
    
    public void showProduct()
    {
        for (int i =0; i < prodList.getnumberofproducts(); i++)
       {
           System.out.println("NO."+ (i+1));
           System.out.println("name: "+ prodList.getProducts().get(i).getname());
           System.out.println("Description: "+prodList.getProducts().get(i).getdescription());
           System.out.println("price: "+prodList.getProducts().get(i).getprice());
           System.out.println("qty "+prodList.getProducts().get(i).getqtyOnHand());
           System.out.println("qtyorder: "+prodList.getProducts().get(i).getminOrderQty());
       }
        
    
    
    }
    
    public void showcartProduct()
    {
        for (int i =0; i < transaction.getnumberofproducts(); i++)
       {
           System.out.println("NO."+ (i+1));
           System.out.println("name: "+ transaction.getProducts().get(i).getname());
           System.out.println("Description: "+transaction.getProducts().get(i).getdescription());
           System.out.println("price: "+transaction.getProducts().get(i).getprice());
           System.out.println("qty "+transaction.getProducts().get(i).getqtyOnHand());
           System.out.println("qtyorder: "+transaction.getProducts().get(i).getminOrderQty());
       }
    }
    
    public void checkout()
    {
        double totalcost= 0;
        for (int i =0; i < transaction.getnumberofproducts(); i++)
       {
           totalcost= totalcost +transaction.getProducts().get(i).getprice()*transaction.getProducts().get(i).getQty();
           for (int a = 0; a < prodList.getnumberofproducts() ; a++)
          {  
           if(prodList.getProducts().get(a).getname().equals(transaction.getProducts().get(i).getname()))
           {
               prodList.getProducts().get(a).setqtyOnHand(prodList.getProducts().get(a).getqtyOnHand()-transaction.getProducts().get(i).getQty());
           
            }
        
          }
          
           System.out.print("cost for"+transaction.getProducts().get(i).getname() +"is"+  transaction.getProducts().get(i).getprice()*transaction.getProducts().get(i).getQty());
       }
    
       System.out.print("cost is"+totalcost );
    
    
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
