import java.util.*;
public class ProductList
{

    
    //Product[] listOfProducts  = new Product[5];
    private ArrayList<Product> productlist;
    public ProductList()
    {
        productlist = new ArrayList<Product>();
    }
    
    public void addproduct(Product newp)
    {
        productlist.add(newp);
    
    
    }
    public ArrayList<Product> getProducts()
    {
       return productlist;
    }
    
    public int getnumberofproducts()
    {
       
       return productlist.size();
    
    }
    public boolean validname(String name)
    {
        if (productlist != null)
        {
       for (int i =0; i < getnumberofproducts(); i++)
       {
        if (name.equals(getProducts().get(i).getname()))
        return true;
        }
       }
        
        return false;
    }

    
}
