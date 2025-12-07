package p014_longest_common_prefix;

class LongestCommonPrefix {

	String longestCommonPrefix(String[] strs) {
//		Recursive
		
//        if(strs.length==0) {
//            return "";
//        }else {
//            return longestCommonPrefixRec(strs, 0);
//        }
//    }
//
//    private static String longestCommonPrefixRec(String[] strs, int start) {
//        var prefix = "";
//        if (strs[0].charAt(start) != strs[1].charAt(start) || strs[0].charAt(start) != strs[2].charAt(start)) {
//            return "";
//        } else {
//
//            return prefix + strs[0].charAt(start) + longestCommonPrefixRec(strs, start + 1);
//        }
		
//		Iterative

		if (strs.length == 0) {
			return "";
		} else {
			var prefix = strs[0];
			for (int i = 1; i < strs.length; i++) {
				while (strs[i].indexOf(prefix) != 0) {
					prefix = prefix.substring(0, prefix.length() - 1);
				}

			}

			return prefix;
		}
	}

}