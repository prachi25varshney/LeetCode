class Solution {
    class Interval{
		int start;
		int end;
		public Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            intervals = new int[1][2];
            intervals[0] = newInterval;
            return intervals;
        }
        List<Interval> intervalsList = new ArrayList<>();
		for(int i=0; i< intervals.length;i++)
		{
			intervalsList.add(new Interval(intervals[i][0], intervals[i][1]));
		}
		int index=0;
		while(index< intervalsList.size() && intervalsList.get(index).start < newInterval[0]){
			index++;
		}
		intervalsList.add(index, new Interval(newInterval[0], newInterval[1]));
		Stack<Interval> stack = new Stack<>();
		stack.push(intervalsList.get(0));
		for(int i=1;i<intervalsList.size();i++){
			Interval prev = stack.peek();
			if(prev.end< intervalsList.get(i).start)
				stack.push(intervalsList.get(i));
			else if(prev.end< intervalsList.get(i).end){
				Interval temp = stack.pop();
				stack.push(new Interval(temp.start, intervalsList.get(i).end));
			}
		}
		int[][] mergedIntervals = new int[stack.size()][2];
		int i=stack.size()-1;
		while(!stack.isEmpty()){
			Interval temp = stack.pop();
			mergedIntervals[i][0] = temp.start;
			mergedIntervals[i][1] = temp.end;
			i--;
		}
		return mergedIntervals;
    }
}