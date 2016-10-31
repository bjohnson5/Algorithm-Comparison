//Imported classes
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;

//Implementation of the pseudocode for Select_kth_Algorithm4
public class Algorithm4
{
   public static int Select_kth_Algorithm4(int[] A, int left, int right, int k)
   {
      Random rand = new Random();
      int range = Math.abs(right - left) + 1;
      int pivotIndex = rand.nextInt(range) + left;
      
      int pivotNewIndex = partition(A, left, right, pivotIndex);
      if((pivotNewIndex) - left >= k)
      {
         return Select_kth_Algorithm4(A, left, (pivotNewIndex - 1), k);
      }
      else if((pivotNewIndex - left) == (k-1))
      {
         return A[pivotNewIndex];
      }
      else
      {
         return Select_kth_Algorithm4(A, (pivotNewIndex + 1), right, (k - pivotNewIndex + left - 1));
      }
   }
   
   //Helper function for Select_kth_Algorithm4
   public static int partition(int[] A, int left, int right, int pivotIndex)
   {
      int pivotValue = A[pivotIndex];
      int temp = 0;
      
      //swap
      temp = A[pivotIndex];
      A[pivotIndex] = A[right];
      A[right] = temp;
      
      int storeIndex = left;
      
      for(int i = left; i <= (right - 1); i++)
      {
         if(A[i] > pivotValue)
         {
            //swap
            temp = A[storeIndex];
            A[storeIndex] = A[i];
            A[i] = temp;
            
            storeIndex = storeIndex + 1;
         }
      }
      
      //swap
      temp = A[right];
      A[right] = A[storeIndex];
      A[storeIndex] = temp;      
      
      return storeIndex;
   }
}