大家好，今天是 [@cornprincess-2](/u/cornprincess-2/) 日更第二天， 今日题目 [83. 删除排序链表中的重复元素](/problems/remove-duplicates-from-sorted-list/)

## 思路
这道题与昨天 [92. 反转链表 II](/problems/reverse-linked-list-ii/) 很相似，都是删除链表中重复的节点，那么同样也可以使用双指针和递归的解法

### 迭代
使用迭代法解链表题时一般会用到哑节点和双指针，我们这里创建两个指针，pre 和 curr，pre 的作用为链接非重复节点，curr 的作用为过滤重复节点
```java

```
时间复杂度： O(N)
空间复杂度：O(1)

### 递归
能用迭代来求解的题目一般也能使用递归来求解，写好递归最重要的是要弄清楚以下四要素：
- 递归函数的意义：删除链表中重复的节点
- basecase：head == null || head.next == null
- 递归函数的调用：
- head.val == head.next.val : return  deleteDuplicates(head.next)
- head.val != head.next.val: head.next = deleteDuplicates(head.next);
- 递归函数返回的结果：处理完的链表头 head

```java

```
时间复杂度：O(N)
空间复杂度：O(N)

欢迎大家多多评论，相关题解库：[leetcode](https://github.com/CornPrincess/LeetCode)，**最后求赞，求关注，求收藏**，我们明天见。
