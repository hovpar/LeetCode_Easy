package LengthOfLastWord_58;

class LengthOfLastWord {

	static int lengthOfLastWord(String s) {
		var length = 0;
		var found = false;

		for (int i = s.length() - 1; i >= 0 && !found; i--) {
			if (s.charAt(i) == ' ' && length == 0) {
				continue;
			} else if (s.charAt(i) != ' ') {
				length++;
			} else {
				found = true;
			}
		}
		return length;
	}
}
