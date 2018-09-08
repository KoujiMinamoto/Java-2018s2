import java.util.*;

public class SaleTransaction
{
    //Product[] items  = new Product[3];
    private ArrayList<Product> items;
    RandomNumberGenerator Random = new RandomNumberGenerator();
    int saleCode = Random.GenerateRandomNumber(9999,1000);
    double totalCost;
    public SaleTransaction()
    {
      items = new ArrayList<Product>();
    }
    
    public void addproduct(Product newproduct)
    {
        items.add(newproduct);
    
    
    }
    
    public int getnumberofproducts()
    {
       
       return items.size();
    
    }
    
    public ArrayList<Product> getProducts()
    {
       return items;
    }
    
    public void delete(int i)
    {
    
        getProducts().remove(i);
    
    }

   
}
