class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> arr=new ArrayList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            arr.add(new ArrayList());
        }

        while(k>0){
            int col[]=new int[n];

            for(int i=0;i<n;i++){
                col[i]=grid[i][0];
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m-1;j++){
                    int temp=grid[i][j+1];
                    grid[i][j+1]=col[i];
                    col[i]=temp;
                }
            }

            grid[0][0]=col[n-1];

            for(int i=1;i<n;i++){
                grid[i][0]=col[i-1];
            }
            k--;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr.get(i).add(grid[i][j]);
            }
        }
        return arr;
    }
}