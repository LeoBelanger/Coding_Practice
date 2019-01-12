//Question #724: Find Pivot Index
class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int totalSum = 0;
        int leftSum = 0;
        int i;

        for(i = 0; i < nums.size(); i++) {
            totalSum += nums[i];
        }

        for(i = 0; i < nums.size(); i++ ) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return
         -1;
    }
};

/* The trick for this problem is to first calculate the entire sum of the
 * array. You then iteratively traverse the array while computing the left sum.
 * Right sum equals the total sum minus the current left sum minus the current
 * index. Terminate if left sum equals right sum.
 */
