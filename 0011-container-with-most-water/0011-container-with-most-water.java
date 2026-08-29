class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int l=0;
        int r=n-1;
        int ans=Integer.MIN_VALUE;
        while(l<r){
            
            int min=Math.min(height[l],height[r]);
            int width=r-l;
            ans=Math.max(ans,min*width);

            if(height[l]<=height[r]){
                l++;
            }
            else{
                r--;
            }

        }
        return ans;
    }
}