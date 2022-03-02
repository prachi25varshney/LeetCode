class Solution {
    public boolean isSubsequence(String s, String t) {
        for (char ch : s.toCharArray()) {
			int find = t.indexOf(ch);
			if (find == -1) {
				return false;
			} else {
				t = t.substring(find + 1);
			}
		}
		return true;
    }
}