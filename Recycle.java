package com.conor;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by conor budge on 2/11/16.
 *
 */
public class Recycle {
    public static void main(String[] args)  throws IOException{
        //Write data to a file
        try {
            FileWriter writer = new FileWriter("houses.txt", false);
            BufferedWriter bufWriter = new BufferedWriter(writer);

            //Scanner to ask for data
            Scanner numberScanner = new Scanner(System.in);
            System.out.println("How many crates are set out by each house?");

            int[] crates = new int[8];


            //Add items to Array store crates and houses in i
            try {

                for (int i = 0; i < crates.length; i++) {
                    crates[i] = numberScanner.nextInt();
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a whole number!");

            }

            //Write loop to write to file
            for (int i = 0; i < crates.length; i++) {
                bufWriter.write("House " + i + " has this many crates: " + crates[i] + "\n");
            }

            //Find sum of elements in Array
            int sum = 0;
            for (int i : crates)

            bufWriter.write("Total crates recycled =" + sum + "\n");

            //Try and find max/ min of Array
            int max = 0;
            int min = 1000;
            int largestHouse = 0;
            int smallestHouse = 0;
            for (int i = 0; i < crates.length; i++) {
                if (crates[i] > max) {
                    max = crates[i];
                    largestHouse = i;
                    //Add items to array list
                    //crateList.add(max);
                } else if (crates[i] < min) {
                    min = crates[i];
                    smallestHouse = i;
                }
            }

            bufWriter.write("Houses that recycled the most and least: \n");
            bufWriter.write("House " + largestHouse + " recycled the most Crates: " + max + "\n");
            bufWriter.write("House " + smallestHouse + " recycled the least Crates: " + min + "\n");

            bufWriter.close();
            numberScanner.close();
        }
        catch (IOException ioe) {
            System.out.println("An IO Exception was thrown!");
            ioe.printStackTrace();
        }
    }
}
