//Imported classes
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

//Implementation of the pseudocode for Select_kth_Algorithm3
public class Algorithm3
{
   public static void Select_kth_Algorithm3(int[] A, int k)
   {
      int[] B = new int[k];
      int min = 0;
      
      for(int i = 0; i < k; i++)
      {
         B[i] = A[i];
      }
      min = 0;
      
      for(int i = 1; i < k; i++)
      {
         if(B[i] < B[min])
         {
            min = i;
         }
      }
      
      for(int i = k; i <= (A.length - 1); i++)
      {
         if(A[i] > B[min])
         {
            B[min] = A[i];
            min = 0;
            
            for(int j = 1; j < k; j++)
            {
               if(B[j] < B[min])
               {
                  min = j;
               }
            }
         }
      }
      
      System.out.println(B[min]);
   }
}