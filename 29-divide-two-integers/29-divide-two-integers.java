class Solution {
    public int divide(int dividend, int divisor) {
        
        if(dividend==0)  return 0;
        if(divisor==-1 && dividend <= Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        int count =0,temp=0;
        long pdivisor = Math.abs((long)divisor);
        long pdividend = Math.abs((long)dividend);
        while(pdividend>=pdivisor){
           int numShift = 0;    
        while(pdividend>=(pdivisor<<numShift)){
            numShift++;
        }
        count += 1<<(numShift-1);
        pdividend -= (pdivisor<<(numShift-1));
        }
         if((dividend>0 && divisor>0) || (dividend<0 && divisor<0))
             return count;
        
        return -count;
    }
}