//Imported classes
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

//Implementation of the pseudocode for Select_kth_Algorithm2
public class Algorithm2
{
   public static void Select_kth_Algorithm2(int[] A, int k)
   {
      int position = 0;
      int temp = 0;
      
      for(int i = 0; i < k; i++)
      {
         position = i;
         for(int j = (i+1); j <= (A.length - 1); j++)
         {
            if(A[j] > A[position])
            {
               position = j;
            }
         }
         
         if(position != i)
         {
            temp = A[i];
            A[i] = A[position];
            A[position] = temp;
         }
      }
      
      System.out.println(A[k-1]);
   }
}