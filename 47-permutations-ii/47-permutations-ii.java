class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 0);
            map.put(num, map.get(num) + 1);
        }

        this.backtrack(new LinkedList<Integer>(), nums.length, map, results);
        return results;
    }

    protected void backtrack(
            LinkedList<Integer> list,
            Integer n,
            HashMap<Integer, Integer> map,
            List<List<Integer>> results) {

        if (list.size() == n) {
            results.add(new ArrayList<Integer>(list));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;

            list.addLast(num);
            map.put(num, count - 1);

            backtrack(list, n, map, results);

            list.removeLast();
            map.put(num, count);
        }
    }
}