class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int ans=0;
        int n=costs.length;
        for(int i=0;i<n;i++){
            if(coins>=costs[i]){
                ans++;
                coins=coins-costs[i];
            }
        }
        return ans;
    }
}