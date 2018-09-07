import java.util.Random;

public class RandomNumberGenerator
{
    private int randomNumber;
    
    public int GenerateRandomNumber(int max,int min)
   {
       Random randomObject = new Random();
       randomNumber = randomObject.nextInt((max-min+1)+min);
       return randomNumber;
   }
}