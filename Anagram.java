/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		// Using preProcess on str1, str2 parameters
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		Boolean lettersCheck = false;
		String newStr1 = "", newStr2 = "";
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != ' ') {
				newStr1 += str1.charAt(i);
			}
		} for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) != ' ') {
				newStr2 += str2.charAt(i);
			}
		}
		if (newStr1.length() != newStr2.length()) {
			return false;
		}
		for (int i = 0; i < str1.length(); i++) 
		{
			lettersCheck = false;
			for (int j = 0; j < str2.length(); j++) 
			{
				if (str1.charAt(i) == str2.charAt(j)) {
					lettersCheck = true;
					str2 = str2.substring(0, j) + str2.substring(j+1);
					break;
				}
			}
			if (lettersCheck == false) {
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// This could be written differently and shortly but I didn't know
		// if I'm allowed to use toLowerCase().
		String newString = "";
		int i = 0;
		while (i < str.length()) {
			char ch = str.charAt(i);
			if ((ch >= 65) && (ch <= 90)) {
				// Converting upper case letter to lower case by using ASCII codes
				newString = newString + (char)(ch + 32);
			} else {
				if (((ch >= 97) && (ch <= 122)) || ch == 32) {
					newString = newString + ch;
				}
			}
			i++;
		}
		return newString;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Determines a new string variable to be str, in order not to change
		// the original str.
		String preString = str;
		String randomString = "";
		int randomIndex;
		while (preString.length() > 0) {
			randomIndex = (int)(Math.random() * preString.length());
			randomString = randomString + preString.charAt(randomIndex);
			preString = preString.substring(0, randomIndex) + preString.substring(randomIndex + 1);
		}
		return randomString;
	}
}
