// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Edge case- if x2 is a negative integer
		while (x2 < 0) {
			x1--;
			x2++;
		}
		// If x2 is a positive integer or 0
		for (int i = 0; i < x2; i++) {
			x1++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Edge case- if x2 is a negative integer
		while (x2 < 0) {
			x1++;
			x2++;
		}
		// If x2 is a positive integer or 0
		for (int i = 0; i < x2; i++) {
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		// Edge case- if x2 is a negative integer
		while (x2 < 0) {
			sum = minus(sum, x1);
			x2++;
		}
		// If x2 is a positive integer
		for (int i = 0; i < x2; i++) {
			sum = plus(sum, x1);
		}
		return sum;
	}
	
	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0) {
			return 1;
		} else {
			int num = x;
			for (int i = 1; i < n; i++) {
				num = times(num, x);
			}
			return num;
		}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int countDiv = 0;
		// Edge case- ERROR
		if (x2 == 0) {
			return -99999;
		}
		// Edge case- both equal
		if (x1 == x2) {
			return 1;
		}
		// Checking if only one of the two parameters is negative 
		boolean onlyOneIsNegative = false;
		if ((x1 < 0) != (x2 < 0)) {
			onlyOneIsNegative = true;
		}
		// Turning negative parameters to positive (equals to multiplying by -1)
		if (x1 < 0) {
			x1 = minus(0, x1);
		}
		if (x2 < 0) {
			x2 = minus(0, x2);
		}
		
		while ( x1 >= x2) {
			x1 = minus(x1, x2);
			countDiv++;
		}
		if (onlyOneIsNegative) {
			countDiv = minus(0, countDiv);
		}
		return countDiv;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int division = div(x1, x2);
		division = times(division, x2);
		int modulo = minus(x1, division);
		return modulo;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		// edge case- ERROR
		if (x < 0) {
			return -99999;
		} else {
			int num = 0;
			while (pow(num, 2) <=x) 
			{
				if (pow(num, 2) == x) {
					return num;
				}
				if (pow(plus(num, 1), 2) > x) {
					return num;
				}
				num++;
			}
			return num;	
		}
	}	  	  
	
}