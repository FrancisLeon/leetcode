/**
    Sliding Window Maximum Total Accepted: 1189 Total Submissions: 5002
    Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see thek numbers in the window. Each time the sliding window moves right by one position.
    For example,
    Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7
    Therefore, return the max sliding window as [3,3,5,5,6,7].
    Note: 
    You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
    Follow up:
    Could you solve it in linear time?
    [思路]
    最初的想法是维持一个k大小的 max heap. 每次删除一个,再插入一个. 但是如果找到被删除的值呢?  并且, 算法复杂度也一定不是线性的. 
    换一个思路.   已题目给出的例子. 用一个linkedlist保存进入窗口的数的index. 如果3出现, 则1没有可能是最大值. 所以可以移除1. 然后-1出现. 这个时候不能移除3. 因为 3可能是最大值.  也就是说如果后出现的数比先出现的数要大, 则可以删除之前的数. 当list顶部的index超出窗口时,则移除.   这样list中的数应该是降序排列, 分别是 
    [最大的数, 第2大的数, 第3大的数, ....]
    cited from: http://blog.csdn.net/xudli/article/details/46955257
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        if (k == 0) {
            return new int[0];
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        
        int[] res = new int[nums.length - k + 1];
        
        for (int i = 0; i < nums.length; i++) {
            // make sure that the list is sorted.
            while (!q.isEmpty() && nums[i] >= nums[q.getLast()]) {
                q.removeLast();
            }
            
            // add new element into the list.
            q.addLast(i);
            
            // remove the first if it's beyond the window.
            if (i - q.getFirst() + 1 > k) {
                q.removeFirst();
            }
            
            // result set.
            if (i + 1 >= k) {
                res[i - k + 1] = nums[q.getFirst()];
            }
        }

        return res;
    }
}