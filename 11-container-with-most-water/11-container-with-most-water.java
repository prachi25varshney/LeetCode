class Solution {
    public int maxArea(int[] height) {
       int l=0;
        int r=height.length-1;
        int area =0;
        while(l<r){
            int lheight = height[l];
            int rheight = height[r];
            area = Math.max(area,((r-l)*Math.min(height[l],height[r])));
            if(height[l]<height[r]){
                while(l<r && height[l] <= lheight)
                    l++;
            }
            else{
                while(l<r && height[r] <= rheight)
                    r--;
            }
                
        }
        return area;
    }
}