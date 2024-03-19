class Solution {
    public int lengthOfLIS(int[] nums) {
        int m = nums.length;

        int[] t = new int[m];
        Arrays.fill(t,1);
    
        int maxLIS = 1;
        
        for(int k = 1; k < m; k++){
            for(int j = 0; j < k; j++){
                if(nums[j] < nums[k]) {
                    t[k] = Math.max(t[k], t[j] + 1);
                    maxLIS = Math.max(maxLIS, t[k]);
                }
            }
        }

        return maxLIS;
    }
}
