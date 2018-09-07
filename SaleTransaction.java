
/**
 * Write a description of class SaleTransaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SaleTransaction
{
    Product[] items  = new Product[3];
    RandomNumberGenerator Random = new RandomNumberGenerator();
    int saleCode = Random.GenerateRandomNumber(9999,1000);
    double totalCost;
    public SaleTransaction()
    {
      
    }

   
}
