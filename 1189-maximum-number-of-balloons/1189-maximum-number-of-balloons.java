class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> hm = new HashMap<>();
        int n = text.length();
        String s = "balloon";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int arr[] = new int[26];
        for (int i = 0; i < text.length(); i++) {
            int idx = text.charAt(i) - 'a';
            arr[idx]++;
        }

        int min = Integer.MAX_VALUE;
        for (char ch : hm.keySet()) {
            int ind = ch - 'a';
            min = Math.min(arr[ind] / hm.get(ch), min);
        }
        return min;
    }
}