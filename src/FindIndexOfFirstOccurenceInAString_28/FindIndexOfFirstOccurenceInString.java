package FindIndexOfFirstOccurenceInAString_28;

class FindIndexOfFirstOccurenceInString {
	static int strStr(String haystack, String needle) {
		
//		1.Variant
		char firstLetter = needle.toCharArray()[0];
		var isSame = true;
		
		for (int i = 0; i <= (haystack.length() - needle.length()); i++) {
			if (firstLetter == haystack.toCharArray()[i]) {
				for (int j = 0; j < needle.length() && isSame; j++) {
					if (needle.toCharArray()[j] != haystack.toCharArray()[i + j]) {
						isSame = false;
					}
				}
				if (isSame) {
					return i;
				}
			}			
		}
		return -1;
		
//		2.Variant

//		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
//			var isSame = true;
//			if (haystack.charAt(i) == needle.charAt(0)) {
//				for (int j = 0; j < needle.length() && isSame; j++) {
//					if (needle.charAt(j) != haystack.charAt(i + j)) {
//						isSame = false;
//					}
//				}
//
//				if (isSame) {
//					return i;
//				}
//			}
//		}
//
//		return -1;
	}

}
