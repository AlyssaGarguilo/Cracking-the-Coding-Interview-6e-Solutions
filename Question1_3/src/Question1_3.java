import java.util.*;

public class Question1_3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Driver assumes split on ','
		while (scanner.hasNext()) {
			String input = scanner.nextLine();
			String[] parts = input.split(",");
			String string = parts[0];
			int length = Integer.parseInt(parts[1]);
			char[] charString = string.toCharArray();
			
			System.out.println(URLify(charString, length));
		}

		scanner.close();
	}

	// O(N) solution; in-place
	public static String URLify(char[] string, int length) {
		int numSpaces = 0;
		for (int i = 0; i < length; i++)
			if (string[i] == ' ')
				numSpaces++;
		// "%20" takes two more characters than " ", but leave room for terminating '\0'
		int index = length + numSpaces * 2 - 1;
		// Work backwards to prevent accidental overwrites
		for (int i = length - 1; i >= 0; i--) {
			if (string[i] == ' ') {
				string[index - 2] = '%';
				string[index - 1] = '2';
				string[index] = '0';
				index = index - 3;
			} else {
				string[index] = string[i];
				index--;
			}
		}
		
		return new String(string);
	}
}
