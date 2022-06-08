//Name: Dennis Perez
//Class : CPSC - 06 - 32002
//DennisPerezFinalCode_Actual

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

public static void main(String[] args) {

int[] month = new int[9088];
int[] day = new int[9088];
int[] year = new int[9088];


double[] temperature = new double[9088];



Scanner in = null;

try {
in = new Scanner(new File("ALBIRMIN.txt"));
} catch (FileNotFoundException e) {

e.printStackTrace();
}

//in.nextLine();//read in header

int count = 0;


while(in.hasNextDouble()) {
month[count] = in.nextInt();
day[count] = in.nextInt();
year[count] = in.nextInt();

temperature[count] = in.nextDouble();
//System.out.println("Month " + month[count] + "Day " + day[count] + "Year " + year[count] + "Temperature " + temperature[count]);
count++;
}
//int countA = findCountPerYear(year);
//System.out.println("yes" + findCountPerYear(year));


System.out.println("\t");
double average = findAverage(temperature);
System.out.println("The Average Temperature in Bramingham, Alabama is: " + findAverage(temperature)); 

System.out.println("\t");

double minTemperature = searchMin(temperature);
System.out.print("The Min Temperature in Bramingham, Alabama is:" + minTemperature);
System.out.println("\t");
double maxTemperature = searchMax(temperature);
System.out.print("The Max Temperature in Bramingham, Alabama is: " + maxTemperature);

}



public static int findCountPerYear(int[] array, int year) { 
int countPerYear = array[0];
int total = 0;
for(int i = 0; i < array.length; i++) {
total += array[i];
}
return countPerYear;
}



public static double findAverage(double[] array) {

double total = 0;
for(int i = 0; i < array.length; i++) {


total += array[i];
}
return total/array.length;
}



public static double searchMax(double[] array) { 

double max = array[0];
int total = 0;
for(int i = 0; i < array.length; i++) {
  if(array[i] > max)
    max = array[i];
}
return max;
}

public static double searchMin(double[] array) { // for a double array

double min = array[0];
int total = 0;
for(int i = 0; i < array.length; i++) {
  if(array[i] < min)
    min = array[i];
}
return min;
}
public static int searchValue(double[] temperature, double minTemperature) { // for a double array

int total = 0;
for(int i = 0; i < temperature.length; i++) {
  if(temperature[i] == minTemperature)

    total = total + 1;
}
return total;
}

}