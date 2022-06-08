// Name : Dennis Perez
// Class: CSE-021-02L
// DennisPerez_Lab21_05_p1-3



class Main {

	public static void init(long[] arr) {
		// Initialize all the entries of the array to 0
    // assigns value to every element in array
    
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

	public static long sumAll(int max) { //one value
    // adds all numbers starting from 1 up to max or number passed into it- stored in subtotal variable
		// sumAll basic version
		long subTotal = 0;
		for (int i = 1; i <= max; i++) {
			subTotal += i;
			System.out.println("sumAll " + i + " value " + subTotal);
		}
		return subTotal;
	}
	
	public static long sumAll(long[] arr, int max) { //whole array
		// Use the array to store sub results
		for (int i = 1; i <= max ; i++) {
			if (arr[i] == 0) { //whatever element in the array = zero
				arr[i] = arr[i-1] + i;	//"arr[i-1]" means the value of the element before (actual value in the previous location) and "+ i" means plus location value (which is the number of the location)- all set equal to new current value

        //ex: if you're at 4, you'd go to the value before it and add that number to 4 to get current value
				System.out.println("sumAll[" + i + "] value " + arr[i]);
			}
		}
		return arr[max];

	}

  public static long squareSum(int max) { //one value at a time for sum of all squares up until that value
    long squareSum = 0;
       for (int i = 1; i <= max; i++) {
          squareSum += (i * i); //running total of one number plus the square of the next total
          //tutor assistance
          System.out.println("squareSum " + i + " value " + squareSum);

       }
       return squareSum;


  }

  public static long squareSum (long [] arr, int max) {
    for (int i = 1; i <= max; i++) {
      if (arr[i] == 0) {
        arr[i] += arr[i - 1] + (i * i); //if arr is zero, take the value from element before, add it to the square of the current location number, this gives you the new current value. then the foor loop tells you to keep counting 
        //tutor assistance
        System.out.println("squareSum [" + i + "] value " + arr[i]);
      }

    }
    return arr[max];


  }

  public static long fib(int max) {
    int fib = 0;
    int fib1 = 0;
    int fib2 = 1;

    for (int i = 2; i <= max; i++) {
      fib= fib1 + fib2; //sum of previous 2 values
      System.out.println("Fibonacci " + i + " value " + fib);
      fib1 = fib2; //fib 1 takes value from fib 2
      fib2 = fib; //fib 2 takes value from fib 
      //tutor assistance
    }
    return fib;
  }

  public static long fib(long [] arr, int max) {
    arr[0] = 0; //assigns value to element of that array named
    arr[1] = 1;
    for (int i = 2; i <= max; i++) {// start counting from second location
       if (arr[i] == 0) { 
         arr[i] = (arr[i-1] + arr[i-2]); //current value will be previous value plus 2 values previous
         //tutor assistance
         System.out.println("Fibonacci [" + i + "] value " + arr[i]);
       }

    }
    return arr[max];


  }

  public static long factorial(int max) {
    long factorial = 1;
    for (int i = 2; i <= max; i++) {
      factorial *= i;
      System.out.println("Factorial " + i + " value " + factorial);

    }

    return factorial;

  }
  
  public static long factorial(long [] arr, int max) {
    arr[1] = 1;
       for (int i = 2; i <= max; i++) {
         if (arr[i] == 0) {
           arr[i] = arr[i-1] * i; //tutor assistance
           System.out.println("Fibonacci [" + i + "] value " + arr[i]);
         }
       }

       return arr[max];

  }

	public static void main(String[] args) {

		final int MAXSIZE = 100; //constant that establishes array capacity
		long[] arr = new long[MAXSIZE]; //possibly an oversize array- where number of elements used is less than or equal to the memory allocated- usually less than the array length, so a seperate integer variable is used to keep track of how many array elements are currently used- the init method allows for all the array elements to initialize starting at zero because initially, zero elements are being used
    //this is useful when array values varry over time

    //when oversized arrays are passed to a method, two parameters are needed for both the array reference and the current size- use current size as the max in the for loop so it doesn't print unused array elements

		System.out.println("sumAll output for 5 is " + sumAll(5));
		System.out.println("sumAll output for 10 is " + sumAll(10));
		System.out.println("sumAll output for 20 is " + sumAll(20));
		System.out.println("sumAll output for 15 is " + sumAll(15));
		System.out.println();

		init(arr);
		System.out.println("sumAll output for 5 is " + sumAll(arr, 5));
		System.out.println("sumAll output for 10 is " + sumAll(arr, 10));
		System.out.println("sumAll output for 20 is " + sumAll(arr, 20));
		System.out.println("sumAll output for 15 is " + sumAll(arr, 15));
		System.out.println();

		
		System.out.println("squareSum output for 5 is " + squareSum(5));
		System.out.println("squareSum output for 10 is " + squareSum(10));
		System.out.println("squareSum output for 20 is " + squareSum(20));
		System.out.println("squareSum output for 15 is " + squareSum(15));
		System.out.println();

		init(arr);
		System.out.println("squareSum output for 5 is " + squareSum(arr, 5));
		System.out.println("squareSum output for 10 is " + squareSum(arr, 10));
		System.out.println("squareSum output for 20 is " + squareSum(arr, 20));
		System.out.println("squareSum output for 15 is " + squareSum(arr, 15));
		System.out.println();

		System.out.println("Fibonacci Number 5 is " + fib(5));
		System.out.println("Fibonacci Number 10 is " + fib(10));
		System.out.println("Fibonacci Number 20 is " + fib(20));
		System.out.println("Fibonacci Number 15 is " + fib(15));
		System.out.println();

		init(arr);
		System.out.println("Fibonacci Number 5 is " + fib(arr, 5));
		System.out.println("Fibonacci Number 10 is " + fib(arr, 10));
		System.out.println("Fibonacci Number 20 is " + fib(arr, 20));
		System.out.println("Fibonacci Number 15 is " + fib(arr, 15));
		System.out.println();

		System.out.println("Factorial of 5 is " + factorial(5));
		System.out.println("Factorial of 10 is " + factorial(10));
		System.out.println("Factorial of 20 is " + factorial(20));
		System.out.println("Factorial of 15 is " + factorial(15));
		System.out.println();

		init(arr);
		System.out.println("Factorial of 5 is " + factorial(arr, 5));
		System.out.println("Factorial of 10 is " + factorial(arr, 10));
		System.out.println("Factorial of 20 is " + factorial(arr, 20));
		System.out.println("Factorial of 15 is " + factorial(arr, 15));
		
	} 

}

