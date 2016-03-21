package lab12;

public class Palindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("noon"));
		System.out.println(isPalindrome("Madam I'm Adam"));
		System.out.println(isPalindrome("A man, a plan, a canal, Panama"));
		System.out.println(isPalindrome("A Toyota"));
		System.out.println(isPalindrome("Not a palindrome"));
		System.out.println(isPalindrome("asdfghfdsa"));
		System.out.println("String of size 17".substring(1,16));
	}
	
	public static boolean isPalindrome(String in) {
		if(in==null) {
			return false;
		}
		return isPalindromeHelper(in.toUpperCase());
	}
	
	private static boolean isPalindromeHelper(String in) {
		//store the most commonly used values as variables so that you don't have to call the respective methods repeatedly (higher efficiency)
		int size = in.length();
		
		if (size <= 1){
			return true;
		}
		
		else{
			//store the most commonly used values as variables so that you don't have to call the respective methods repeatedly (higher efficiency)
			char first = in.charAt(0);
			char last = in.charAt(in.length()-1);
			
			//check if the first and last characters are letters or not
			if (!Character.isLetter(first)){
				return isPalindromeHelper(in.substring(1));
			}
			else if (!Character.isLetter(last)){
				return isPalindromeHelper(in.substring(0, size-1));
			}
			
		
			//now check if the first and last characters are the same or not
			else if (first == last){
				return isPalindromeHelper(in.substring(1, size-1));
			}
			
		}
		return false;
		
	}
}