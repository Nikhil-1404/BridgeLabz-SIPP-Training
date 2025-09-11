import java.util.Scanner;
public class ReverseString {
	public static String  reverseStringUsingStringBuilder (String input) {
		StringBuilder sb = new StringBuilder();
		sb.append(input);
		sb.reverse();
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = sc.nextLine();
		String reversed = reverseStringUsingStringBuilder(str);
		System.out.println("Original string : " + str );
		System.out.println("Reversed string : " + reversed );
		
	}

}
