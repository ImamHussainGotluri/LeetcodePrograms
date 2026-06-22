class Solution {
    public int rearrangeCharacters(String s, String target) {
         Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        int arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
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