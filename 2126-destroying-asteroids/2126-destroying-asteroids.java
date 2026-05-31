class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n=asteroids.length;
        long wt=mass;
        for(int i=0;i<n;i++){
            if(asteroids[i]>wt){
                return false;
            }
            wt+=asteroids[i];
        }
        return true;
    }
}