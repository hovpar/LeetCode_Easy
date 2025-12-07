package p013_roman_to_integer;

class RomanToInteger {

	int romanToInt(String s) {
		var result = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			switch (s.charAt(i)) {
			case 'M':
				result += 1000;
				break;
			case 'D':
				result += 500;
				break;
			case 'L':
				result += 50;
				break;
			case 'V':
				result += 5;
				break;
			case 'I':
				if (result == 5 || result == 10) {
					result = result - 1;
				} else {
					result += 1;
				}
				break;
			case 'X':
				if (result >= 50 && result <= 59 || result >= 100 && result <= 109) {
					result = result - 10;
				} else {
					result += 10;
				}
				break;
			case 'C':
				if (result >= 500 && result <= 599 || result >= 1000 && result <= 1099) {
					result = result - 100;
				} else {
					result += 100;
				}
				break;
			}
		}

		return result;
	}
}
