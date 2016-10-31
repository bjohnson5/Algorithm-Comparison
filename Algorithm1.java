//Imported classes
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

//Implementation of the pseudocode for Select_kth_Algorithm1
public class Algorithm1
{
   public static void Select_kth_Algorithm1(int[] A, int k)
   {
      int temp = 0;
      
      for(int i = 1; i < (k+1); i++)
      {
         for (int j = (A.length - 1); j >= i; j--)
         {
            if(A[j] > A[j-1])
            {
               temp = A[j];
               A[j] = A[j-1];
               A[j-1] = temp;
            }
         }
      }
      System.out.println(A[k-1]);
   }
}