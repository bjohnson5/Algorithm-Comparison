//Imported classes
import java.util.Arrays;
import java.util.Random;
import java.lang.Math;
import java.io.File;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Number;
import java.lang.Long;
import java.lang.Double;
import java.text.DecimalFormat;

public class Programming_Assignment
{
   public static void main(String[] args)
   {
      //Variable declaration
      int k = 5;
      double m = 1000;
      int n = 0;
      DecimalFormat df = new DecimalFormat("#.000");
      //Arrays used to save the averages of the run times
      double[] mAvgAlg1 = new double[12];
      double[] mAvgAlg2 = new double[12];
      double[] mAvgAlg3 = new double[12];
      double[] mAvgAlg4 = new double[12];
      double[] nAvgAlg1 = new double[19];
      double[] nAvgAlg2 = new double[19];
      double[] nAvgAlg3 = new double[19];
      double[] nAvgAlg4 = new double[19];
      
      //Setting up the file writer
      //The comma delimeted txt file will be written in the current directory and will be called "Data.txt"
      FileWriter file = null;
      try
      {
         file = new FileWriter("Data.txt");
      }
      catch(IOException e)
      {
         System.out.println("Error with file.");
      }
      
      //This outer loop increments n everytime around, depending on the size of the data you want
      for(int i = 1; i <= 19; i++)
      {
         //Uncomment this line and comment out the line below to see the algorithms run on small data sets
         //(n=10 to n=1000)
         if(i <= 10)
         {
            n = n + 10;
         }
         else
         {
            n = n + 100;
         }

         //Uncomment this line and comment out the if-else above to see the algorithms run on much larger data sets (n=10000 to n=190,000):
//         n = i * 10000;

         //This loop changes the type of array that is passed to the algorithms
         //When j=1 it is an array with numbers 1-n in increasing order
         //When j=2 it is an array with numbers 1-n in decreasing order
         //When j=3 through 12 it is an array with numbers 1-n in random order
         for(int j = 1; j <= 12; j++)
         {
            //Load array returns a array based on the value of j and the size of the data set (n) (see Functions.java)
            int[] InputArray = new int[n];
            InputArray = Functions.LoadArray(j,n);
            
            //Running Algorithm 1 m times
            Long t1_alg1 = System.nanoTime();
            for(int l = 0; l < m; l++)
            {
               Algorithm1.Select_kth_Algorithm1(InputArray, k);
            }
            Long t2_alg1 = System.nanoTime();
            //saving the average of A1 when it is run m times with the given input type (increasing, decreasing, etc...)
            //Avg. for increasing in mAvgAlg1[0], Avg. for decreasing in mAvgAlg1[1], and Avg. for random in mAvgAlg1[2 through 11]
            mAvgAlg1[j-1] = ((t2_alg1.doubleValue() - t1_alg1.doubleValue())/m);
            
            //Running Algorithm 2 m times
            Long t1_alg2 = System.nanoTime();
            for(int l = 0; l < m; l++)
            {
               Algorithm2.Select_kth_Algorithm2(InputArray, k);
            }
            Long t2_alg2 = System.nanoTime();
            //saving the average of A2 when it is run m times with the given input type (increasing, decreasing, etc...)
            //Avg. for increasing in mAvgAlg2[0], Avg. for decreasing in mAvgAlg2[1], and Avg. for random in mAvgAlg2[2 through 11]
            mAvgAlg2[j-1] = ((t2_alg2.doubleValue() - t1_alg2.doubleValue())/m);
            
            //Running Algorithm 3 m times
            Long t1_alg3 = System.nanoTime();
            for(int l = 0; l < m; l++)
            {
               Algorithm3.Select_kth_Algorithm3(InputArray, k);
            }
            Long t2_alg3 = System.nanoTime();
            //saving the average of A3 when it is run m times with the given input type (increasing, decreasing, etc...)
            //Avg. for increasing in mAvgAlg3[0], Avg. for decreasing in mAvgAlg3[1], and Avg. for random in mAvgAlg3[2 through 11]
            mAvgAlg3[j-1] = ((t2_alg3.doubleValue() - t1_alg3.doubleValue())/m);
            
            //Running Algorithm 4 m times
            Long t1_alg4 = System.nanoTime();
            for(int l = 0; l < m; l++)
            {
               Algorithm4.Select_kth_Algorithm4(InputArray, 0, InputArray.length - 1, k);
            }
            Long t2_alg4 = System.nanoTime();
            //saving the average of A4 when it is run m times with the given input type (increasing, decreasing, etc...)
            //Avg. for increasing in mAvgAlg4[0], Avg. for decreasing in mAvgAlg4[1], and Avg. for random in mAvgAlg4[2 through 11]
            mAvgAlg4[j-1] = ((t2_alg4.doubleValue() - t1_alg4.doubleValue())/m);
         }
         
         //Once it runs each Algorithm m times with the 12 different inputs this finds the average of those 12 times
         //Algorithm 1
         double sum1 = 0;
         for(int p = 0; p < mAvgAlg1.length; p++)
         {
            sum1 = sum1 + mAvgAlg1[p];
         }
         //Saves the average time for the 19 different values of n
         //n=10 goes in nAvgAlg1[0] and n=100 goes in nAvgAlg1[1], etc...
         nAvgAlg1[i-1] = sum1 / 12.0;
         
         //Algorithm 2
         double sum2 = 0;
         for(int p = 0; p < mAvgAlg2.length; p++)
         {
            sum2 = sum2 + mAvgAlg2[p];
         }
         //Saves the average time for the 19 different values of n
         //n=10 goes in nAvgAlg2[0] and n=100 goes in nAvgAlg2[1], etc...
         nAvgAlg2[i-1] = sum2 / 12.0;
         
         //Algorithm 3
         double sum3 = 0;
         for(int p = 0; p < mAvgAlg3.length; p++)
         {
            sum3 = sum3 + mAvgAlg3[p];
         }
         //Saves the average time for the 19 different values of n
         //n=10 goes in nAvgAlg3[0] and n=100 goes in nAvgAlg3[1], etc...
         nAvgAlg3[i-1] = sum3 / 12.0;
         
         //Algorithm 4
         double sum4 = 0;
         for(int p = 0; p < mAvgAlg4.length; p++)
         {
            sum4 = sum4 + mAvgAlg4[p];
         }
         //Saves the average time for the 19 different values of n
         //n=10 goes in nAvgAlg4[0] and n=100 goes in nAvgAlg4[1], etc...
         nAvgAlg4[i-1] = sum4 / 12.0;
         
         //Writing the header of the file to show what the range of n is
         try
         {
            file.write(n + ", ");
         }
         catch(IOException e)
         {
            System.out.println("Error with file.");
         }
      }
      
      //Writing the average times to the file
      try
      {  
         //Algorithm 1
         file.write("\n");
         for(int q = 0; q < nAvgAlg1.length; q++)
         {
            file.write(df.format(nAvgAlg1[q]));
            file.write(",");
         }
         //Algorithm 2
         file.write("\n");
         for(int q = 0; q < nAvgAlg1.length; q++)
         {
            file.write(df.format(nAvgAlg2[q]));
            file.write(",");
         }
         //Algorithm 3
         file.write("\n");
         for(int q = 0; q < nAvgAlg1.length; q++)
         {
            file.write(df.format(nAvgAlg3[q]));
            file.write(",");
         }
         //Algorithm 4
         file.write("\n");
         for(int q = 0; q < nAvgAlg1.length; q++)
         {
            file.write(df.format(nAvgAlg4[q]));
            file.write(",");
         }
      }
      catch(IOException e)
      {
         System.out.println("Error with file.");
      }
      
      //Closing the file
      try
      {
         file.close();
      }
      catch(IOException e)
      {
         System.out.println("Error with file.");
      }
   }
}