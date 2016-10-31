//Imported classes
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

//Function used to create an array of different types
public class Functions
{
   public static int[] LoadArray(int j, int n)
   {
      //The first array we want is 1..n in increasing order
      if(j == 1)
      {
         int[] InputArray = new int[n];
         int value = 1;
         
         for(int i = 0; i < n; i++)
         {
            InputArray[i] = value;
            value++;
         }
         return InputArray;
      }
      //The second array we want is n..1 in decreasing order
      if(j == 2)
      {
         int[] InputArray2 = new int[n];
         int value2 = 1;
         
         for(int i = (n-1); i >= 0; i--)
         {
            InputArray2[i] = value2;
            value2++;
         }
         return InputArray2;
      }
      //The rest of the arrays we want to be random permutations of numbers 1..n
      else
      {
         int[] InputArray3 = new int[n];
         int value3 = 1;
         
         //Fill the array with numbers 1..n in increasing order
         for(int i = 0; i < n; i++)
         {
            InputArray3[i] = value3;
            value3++;
         }
         
         //Convert the array to an ArrayList of Integers
         ArrayList<Integer> list = new ArrayList<Integer>();
         for(int i = 0; i < InputArray3.length; i++)
         {
            list.add(InputArray3[i]);
         }
         
         //Call the function "shuffle" on the ArrayList, which changes the order of the list
         Collections.shuffle(list);
         
         //Convert the shuffled ArrayList back to an array and return it
         for(int i = 0; i < InputArray3.length; i++)
         {
            InputArray3[i] = list.get(i);
         }
         
         return InputArray3;
      }
   }
}