class Solution {
    public boolean isRobotBounded(String instructions) {
        int x=0, y=0, dir=1;
        for(int i=0;i<4;i++){
            for(char ch: instructions.toCharArray()){
                if(dir==1){
                    if(ch=='G') y++;
                    else if(ch=='L') dir =2;
                    else dir =4;
                }
                else if(dir==2){
                    if(ch=='G') x--;
                    else if(ch=='L') dir =3;
                    else dir =1;
                }
                else if(dir==3){
                    if(ch=='G') y--;
                    else if(ch=='L') dir =4;
                    else dir =2;
                }
                else{
                    if(ch=='G') x++;
                    else if(ch=='L') dir =1;
                    else dir =3;
                }
            }
        }
        return x==0 && y==0;
    }
}