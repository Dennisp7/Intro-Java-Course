// Name : Dennis Perez
// Class: CSE-021-02L
// DennisPerez_project 1

import java.util.Scanner;
public class Main {

  //These variables needed to be global to be accessible to multiple methods
	static double additionalDiscount = 0;
	static double additionalDiscountRate = 0; 
  
  
  //this method was taken from the lab for the change in suffix 
  public static String numSuffix(int i) { 
    int rem = i % 10;
    
    // if i = 20
    // 20 / 10 = 2, rem is 0

    // if i = 33
    // 33 / 10 = 3, rem is 3

    // if i = 156
    // 156 / 10 = 15, rem is 6

    switch (rem) { 
      case 0: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9:
          return (i + "th"); 
      case 1:
        // If the i argument is less than 100, print this .. 
        if (i % 100 != 11) 
          return (i + "st");
      else
        // If the i argument is greater than 100, print this .. 11[1th]
        return (i + "th");
      case 2:
        if (i % 100 != 12)
          return (i + "nd"); 
        else
          return (i + "th");
      case 3:
        if (i % 100 != 13)
          return (i + "rd"); 
      else
        return (i + "th");
      default: //ensures to break out of switch statement if value doesn't apply. It will return an empty string in this case
        break;
    }
    return "";
  }

  
	public static int setupShop(Scanner input, String[] names, double[] prices, int[] specialDiscounts) { //promised to return something and it must be an integer. We need this information for the rest of the code to function since it relies on this information
		
    System.out.print("Please enter the number of items to set up shop: "); 
		int items = input.nextInt();//local variable to this function

		System.out.println();	
    //each item entered for the number user input must have all these, so I put them in a for loop	
		for (int i = 0; i < items; i++){ 

			System.out.print("Enter name of the " + numSuffix(i+1) + " product: "); //tutor assistance 
			names[i] = input.next(); 
			
			System.out.print("Enter the per package price of " + names[i] + ": ");
			prices[i] = input.nextDouble();

      System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free) for " + names[i] + ", or 0 if no Special Discount offered: "); 
      specialDiscounts[i] = input.nextInt(); //user dictates the special discount now
			while (specialDiscounts[i] < 0) { //created a while loop to check for an error
        System.out.print("Invalid input. Enter a value >= 0: ");
			  specialDiscounts[i] = input.nextInt();        
      }      
		}
  	
    System.out.println();
		System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
		additionalDiscount = input.nextDouble(); //user sets the dollar amount threshold for additional discount to be applied
    

		if (additionalDiscount > 0) { //ensures the discount rate is only offered if there is an additional discount
		System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
		additionalDiscountRate = input.nextDouble();

    while (additionalDiscountRate <= 0 || additionalDiscountRate > 0.5) { //while loop to check for error
      System.out.print("Invalid input. Enter a value > 0 and <= 0.5: "); 
      additionalDiscountRate = input.nextDouble();

    } 
    }  
    System.out.println();
		return items; //must return number of items. That is the point of the setupshop function
    
  }
	public static void buy(Scanner input, String[] names, double[] prices, int[] amounts, int numOfItems) {
	  System.out.println();
		for (int i = 0; i < numOfItems; i++){
			System.out.print("Enter the number of " + names[i] + " packages to buy: ");
			amounts[i] = input.nextInt();  
      //must be >= 0
			while (amounts[i] < 0) { //while loop to check for error
        System.out.print("Invalid input. Enter a value >= 0: ");
			  amounts[i] = input.nextInt();        
      }
		}
		System.out.println();
	}
	public static void listItems(String [] names, double[] prices, int[] amounts, int numOfItems) {
		

    boolean zero = true;     // Created a boolean variable to set array as 0 -- tutor assistance

		for(int i = 0; i < numOfItems; i++) {     //Used a for-loop to iterate throughout the entire array

         if (amounts[i] > 0) {    //If any single value is non-zero, switch/change the value of the boolean variable.
          zero = false; 
         }
    }

    //blocks are separated so that it doesn't run through the array more than it has to.
    //this next block of code knows whether the boolean above is true or fales and compiles the rest based on that
    if (zero) {
      System.out.println();
      System.out.println("No items were purchased.");     //If all of the values were zero, print "No items were purchased."
      System.out.println();      
    }
    else {
      System.out.println();
    //Otherwise, we want to print out the individual statements.
      for(int i = 0; i < numOfItems; i++) { //we are running through the entire array again because we know that there is at least one non zero values
          
              if (amounts[i] > 1) { //made if statements to ensure it prints packages for more than 1 and package for 1 item

              System.out.printf("%d packages of %s @ $%.2f per pkg = $%.2f\n", amounts[i], names[i], prices[i], amounts[i] * prices[i]);   
              //10 packages of alpha @ $10.00 per pkg = $100.00   
              }
              else if (amounts[i] == 1) {

              System.out.printf("%d package of %s @ $%.2f per pkg = $%.2f\n", amounts[i], names[i], prices[i], amounts[i] * prices[i]);   

              //10 packages of alpha @ $10.00 per pkg = $100.00   
              }			
              
      }
      System.out.println();


    }
	
	}
	public static void checkout(int numOfItems, double[] prices, int[] amounts, int[] specialDiscounts) {
		
    double origSubTotal = 0;
    double itemDiscount = 0;
    double newSubTotal = 0;
		double discount = 0;     
		double finalTotal = 0;


		for(int i = 0; i < numOfItems; i++) {

      //This line is calculating the original total
		  origSubTotal = origSubTotal + (prices[i]*amounts[i]); //tutor assistance
      
      //This line is calculating the special discount
      if (specialDiscounts[i] > 0) {
            
        itemDiscount += (Math.floor(amounts[i]/(specialDiscounts[i]+ 1)) * prices[i]); //discount created according to user entry 
      } 
		}
    System.out.println();
  
    //both discounts don't apply
		if (itemDiscount <= 0 && additionalDiscount == 0){
      System.out.printf("Original Sub Total:              $%.2f\n", origSubTotal); 
      System.out.println("No Special Discounts applied"); 
			System.out.printf("New Sub Total:                   $%.2f\n", origSubTotal); 
			System.out.println("You did not qualify for an Additional Discount"); 
			System.out.printf("Final Sub Total:                 $%.2f\n", origSubTotal);      
			System.out.println(); 
      
		} 
    else {
      //Subtracts special discount
      newSubTotal = origSubTotal - itemDiscount;

      //Subtracts additional money for buying over X amount.
      //multiplies additional discount times percent or additionalDiscountRate IF new sub total is over the dollar threshold
      discount = newSubTotal * additionalDiscountRate;    

      //final val
      finalTotal = newSubTotal - discount;	

      //special doesn't apply but additional does
		  if (itemDiscount <= 0 && (newSubTotal >= additionalDiscount)) { 
      System.out.printf("Original Sub Total:        $%.2f\n", origSubTotal);
			System.out.println("No Special Discounts applied"); 
			System.out.printf("New Sub Total:             $%.2f\n", newSubTotal);       
			System.out.printf("Additional %d%s Discount:  -$%.2f\n", ((int)(additionalDiscountRate*100)), "%", discount); //tutor assistance to change double to int
			System.out.printf("Final Sub Total:           $%.2f\n", finalTotal); 
			System.out.println();
		  } 

      if (itemDiscount > 0 && (newSubTotal >= additionalDiscount)){ 
        //both discounts apply here
        System.out.printf("Original Sub Total:        $%.2f\n", origSubTotal);      
        System.out.printf("Special Discounts:        -$%.2f\n", itemDiscount); 
        System.out.printf("New Sub Total:             $%.2f\n", newSubTotal); 
			  System.out.printf("Additional %d%s Discount:  -$%.2f\n", ((int)(additionalDiscountRate*100)), "%", discount);        
        System.out.printf("Final Sub Total:           $%.2f\n", finalTotal);  System.out.println();
      }

      if (itemDiscount > 0 && (newSubTotal < additionalDiscount)) { 
        //special applies but not additional
        System.out.printf("Original Sub Total:        $%.2f\n", origSubTotal);      
        System.out.printf("Special Discounts:        -$%.2f\n", itemDiscount);
        System.out.printf("New Sub Total:             $%.2f\n", newSubTotal);       
        System.out.println("You did not qualify for an Additional Discount"); 
        System.out.printf("Final Sub Total:           $%.2f\n", (finalTotal));System.out.println();
      }
    }
    System.out.println("Thanks for coming!"); 
	}

	
	public static void main(String[] args) { //main function for the code to run
		final int MAX = 50; //max amount (arbitrary limit)
		int originalOption = 0; //these are just markers to know when I am dealing with a new instance below. They hold no other significance
		int nextOption = 0; //these are just markers to know when I am dealing with a new instance below. They hold no other significance
		String[] names = new String[MAX];
		double[] prices = new double[MAX];
		int[] amounts = new int[MAX];
    int[] specialDiscounts = new int[MAX];
    int numOfItems = 0; 
		
		do {   //do while loop to ensure the program is keeping and running on latest information   
			Scanner input = new Scanner(System.in);
			System.out.println("This program supports 4 functions:");
			System.out.println("     1. Setup Shop");
			System.out.println("     2. Buy");
			System.out.println("     3. List Items");
			System.out.println("     4. Checkout");
			System.out.print("Please type the function you want: ");
			int choice = input.nextInt(); 
			
      if (choice == 1 || choice == 2 || choice == 3|| choice == 4) {
        if (originalOption == 1 && choice == 1) { //sets up shop again if shop was already set up
            names = null;
            prices = null;
            amounts = null;
            specialDiscounts = null;

		        names = new String[MAX];
		        prices = new double[MAX];
		        amounts = new int[MAX];
            specialDiscounts = new int[MAX];
            
            numOfItems = 0;
            originalOption = 0;
            nextOption = 0;

            numOfItems = setupShop(input, names, prices, specialDiscounts);
            originalOption = 1;            
        } else if (originalOption == 0 && choice == 1) {
            numOfItems = setupShop(input, names, prices, specialDiscounts);
            originalOption = 1;            
        } else if (choice == 2) {
          if(originalOption == 1) {
            buy(input, names, prices, amounts,numOfItems);
            nextOption = 1; //value is updated since it was already bought
          } else {
            System.out.println("\nThe shop has not been setup yet!\n"); //ensures the shop is set up first
          }
        } else if (choice == 3) {
          if (nextOption == 1) {
            listItems(names, prices, amounts, numOfItems);
          } else if (originalOption == 1 && nextOption == 0) { //nothing is bought but shop is set up
            System.out.println("\nYou have not bought anything!\n"); //ensuring something is bought first before listing
          } else if (originalOption == 0) {
            System.out.println("\nThe shop has not been setup yet!\n"); //shop wasn't set up so it can't run function 3
          }
        } else if (choice == 4) {
          if (originalOption == 0) {
            System.out.println("\nThe shop has not been setup yet!\n");  //can't run function 4 before setting up shop          
          } else if (nextOption == 0) {
            System.out.println("\nYou have not bought anything!\n"); //can't checkout if nothing was bought            
          } else if (nextOption == 1) {

            checkout(numOfItems, prices, amounts, specialDiscounts);

            //RUN THE PROGRAM AGAIN

            int runAgain = 0;   
            //Ask user is they want to run the program again. 
            System.out.println();
            System.out.println("-------------------------------------------------");          
            System.out.print("Would you like to re-run (1 for yes, 0 for no)? "); runAgain = input.nextInt();          
            System.out.println("-------------------------------------------------");

            //If yes, clear arrays of existing data
            if (runAgain == 1) {
              names = null;
              prices = null;
              amounts = null;
              specialDiscounts = null;

              names = new String[MAX];
              prices = new double[MAX];
              amounts = new int[MAX];
              specialDiscounts = new int[MAX];
            
              numOfItems = 0;
              originalOption = 0;
              nextOption = 0;

  
          } else {           //If no, exit 0
            System.exit(0); //tutor assistance
          } 



        }
      }
    } else {
      System.out.println("\nNot an option\n"); //must input correct choice
    }
  } while (true);
  }
}


//need to make error messages. Sample run 2 is missing this message at line 21 in the handout --fixed

//Special discounts did not display correctly for sample run 2-- APPLIES TO ALL ENTRIES NOT JUST 2 Cheeses!!! NEED NEW FORMULA-- fixed


//need to ensure it says package instead of packages when they only buy 1 in item list print out-- fixed


//fix all outputs to ensure they have same display as handout-- fixed 


//need to write a for loop on line 85 that doesnt ask for additional discount if user input is 0-- fixed


//fix spacing for all print statements, especially for checkout-- fixed


//fix decimals printed for outputs-- fixed


//need to fix white space on sample 3 test after inputing 0 to buy and when it lists the "this shop supports"-- fixed
