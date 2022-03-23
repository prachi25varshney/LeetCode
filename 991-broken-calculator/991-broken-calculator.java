class Solution {
    
    public int brokenCalc(int X, int Y) {
        int count =0;
        while(X!=Y){
            if(X>Y)
                return X-Y + count;
            if(Y%2==0)
                Y=Y/2;
            else
                Y=Y+1;
            count++;
        }
        return count;
    }
}