Question #1: Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = {0, 0};

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }
}

/* The trick to this was to realize that while using 2 pointers and checking
 * every sum is possible, with large arrays this will grow in time complexity
 * O(N*N), and by using a hashmap, the lookup would be O(1). You hash using
 * the array values as keys, and their indices as values.  
 */
