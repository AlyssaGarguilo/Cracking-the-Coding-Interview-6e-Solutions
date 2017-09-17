import java.util.*;

public class Question1_2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Assuming significant whitespace
		while (scanner.hasNextLine()) {
			String string1 = scanner.nextLine();
			String string2 = scanner.nextLine();
			System.out.println(isPermutation(string1, string2) ? "Is a permutation" : "Is not a permutation");
		}
		scanner.close();
	}

	// O(n*lg(n)) sort time; O(n) space complexity
	public static String sortString(String string) {
		char[] charString = string.toCharArray();
		Arrays.sort(charString);
		return new String(charString);
	}
	
	// O(n) comparison
	public static boolean isPermutation(String string1, String string2) {
		if (string1.length() != string2.length())
			return false;
		return sortString(string1).equals(sortString(string2));
	}
}
