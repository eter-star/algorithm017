# 极客时间算法训练营第17期 第01周 学习总结

#### 01.Two Sum java代码
##### 这道题目的one-pass hashmap的解法有一个前提是，数组当中存在唯一解；如果存在多种解，应该把所有的解保存到一个linkedlist当中
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //One-pass hashmap on premise that there exist only one solution
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i =0; i < nums.length; i++){
            int completment = target - nums[i];
            if(map.containsKey(completment)){
                return new int[]{i, map.get(completment)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
```

#### 21. merge two lists java代码
##### 采用递归方法求解，也可以采用iteration的方法求解
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            ListNode head = null;
            if(l1.val < l2.val) head = new ListNode(l1.val, mergeTwoLists(l1.next, l2));
            else head = new ListNode(l2.val, mergeTwoLists(l1, l2.next));
            return head;
        }
    }

#### 24. swap pairs java代码

##### iteration方法，需要建立一个dummy node
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode prevNode = dummy;
            ListNode firstNode = null;
            ListNode secondNode = null;
            while(head!=null && head.next !=null){
                firstNode = head;
                secondNode = head.next;
                prevNode.next = secondNode;
                firstNode.next = secondNode.next;
                secondNode.next = firstNode;
                prevNode = firstNode;
                head = firstNode.next;
            }
            return dummy.next;
        }
    }

##### 递归方法
    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null) return head;
            ListNode p = swapPairs(head.next.next);
            ListNode newHead = head.next;
            newHead.next = head;
            head.next = p;
            return newHead;
        }
    }

#### 66. plus one java代码
##### 注意plusOne有进位的情况
```java
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int bitIncrease = (digits[n - 1] + 1)/10 ;
        digits[n - 1] = (digits[n- 1] + 1) % 10;
        for(int i = n - 2; i >= 0 ; i--){
            digits[i] += bitIncrease;
            bitIncrease = digits[i] / 10;
            digits[i] %= 10;
        }
        if(bitIncrease == 1){
            int[] arr = new int[n + 1];
            for(int i = 1; i < n+1; i++){
                arr[i] = digits[i-1];
            }
            arr[0] = 1;
            return arr;
        }else{
            return digits;
        }
    }
}
```
#### 77 climb stairs java代码
##### 使用递归方法的Fibonnaci数列求解，算法时间复杂度O（n），利用aux函数，将两个参数Fibo-prev, Fibo_prevprev传入函数参数
```java
class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        return climbStairsAux(n, 2 , 1);
    }
    public int climbStairsAux(int n, int nMinusOne, int nMinusTwo){
        if(n < 3) return nMinusOne;
        return climbStairsAux(n-1, nMinusOne + nMinusTwo , nMinusOne);
    }
}
```

#### 189 rotate array java代码
##### 涉及到数组长度与k值的最小公约数gcd的计算。此外，leetcode上给出了一种全局计算count的循环方法。
##### corner case 是处理过的 k==0 的情况
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k = k% nums.length;
        if(k == 0 ) return;
        int j = 0;
        int gcd = gcd(nums.length, k);
        while(j++ < gcd){
            int prev = nums[j];
            int count = 0;
            for(int i = j; count++ < nums.length/gcd; i+=k){
                int tmp = nums[(i+k) % nums.length];
                nums[(i+k) % nums.length] = prev;
                prev = tmp;
            }
        }

    }

    public int gcd(int a, int b){
        while(a != b){
            if(a > b){ a = a-b; }
            else{ b = b-a;}
        }
        return a;
    }
}
```
#### 283 move zeros java代码
##### 是一种双指针的线性时间复杂度的计算
```java
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1) return;
        int i = 0, j = 1;
        while(i < nums.length && j < nums.length){
            if(nums[i]== 0){
                if(nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    i++;
                }
                j++;
            }
            else{
                if(nums[j] == 0){
                    i++;
                    j++;
                }else{
                    i=j;
                    j++;
                }
            }
        }

    }
}
```
