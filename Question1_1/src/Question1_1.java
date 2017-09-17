import java.util.*;

public class Question1_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String testString = scanner.nextLine();
			System.out.println(isUnique1(testString) ? "Contains no duplicates" : "Contains duplicates");
			System.out.println(isUnique2(testString) ? "Contains no duplicates" : "Contains duplicates");
		}
		scanner.close();
	}
	
	// Amortized O(1) runtime; O(n) space complexity
	public static boolean isUnique1(String testString) {
		HashSet<Character> usedCharacters = new HashSet<Character>();
		for (int i = 0; i < testString.length(); i++)
			if (!usedCharacters.add(testString.charAt(i)))
				return false;
		return true;
	}
	
	// O(n^2) runtime; O(1) space complexity
	public static boolean isUnique2(String testString) {
		for (int i = 0; i < testString.length(); i++)
			for (int j = 0; j < i; j++)
				if (testString.charAt(i) == testString.charAt(j))
					return false;
		return true;
	}

}