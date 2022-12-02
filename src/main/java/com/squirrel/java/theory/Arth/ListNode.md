### ListNode

#### practice

##### 删除链表的倒数第n个节点

- [19] 删除链表的倒数第 N 个结点

  - 思路：采用双指针,快按指针,快的先走n个节点,然后大家一起走,直到快的走完。																			

  - ```java
    public ListNode removeNthFromEnd(ListNode head, int n) {
      // 采用双指针
      ListNode first =  head.next;
      ListNode second = head;
      for(int i =0;i<n;i++){
        first = first.next;
      }
    
      while(first!=null){
        first = first.next;
        second = second.next;
      }
    
      if(second!=null && second.next !=null){
        second.next = second.next.next;
      }
      return head;
    }
    ```

- 力扣第 21 题「 [合并两个有序链表](https://leetcode.cn/problems/merge-two-sorted-lists/)」

  - 思路: 采用哑节点,然后依次比较两个链表节点的大小，设置到新的链表上。

  - ```java
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      // 定义一个新的ListNode
      ListNode dummyNode = new ListNode(-1);
      ListNode pre = dummyNode;
    
      while(list1!=null && list2!=null){
        int val1= list1.val;
        int val2 =list2.val;
        if(val1 < val2){
          pre.next = new ListNode(val1);
          list1 = list1.next;
        }else{
          pre.next =new ListNode(val2);
          list2 = list2.next;
        }
        pre = pre.next;
      }
      if(list1!=null){
        pre.next = list1;
      }
      if(list2!=null){
        pre.next = list2;
      }
    
      return dummyNode.next;
    }

-  141 环形链表
-  



