class Solution {
    public boolean isRobotBounded(String instructions) {
         int x = 0, y = 0, dir = 0;
        // north = 0, east = 1, south = 2, west = 3
        int[][] directions = new int[][] {{0,1}, {1,0}, {0, -1}, {-1,0}};
        
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                dir = (dir + 3) % 4;
            }
            else if (c == 'R') {
                dir = (dir + 1) % 4;
            } else {
                x += directions[dir][0];
                y += directions[dir][1];
            }
        }
        
        return (x == 0 && y == 0) || dir != 0;
    }
}