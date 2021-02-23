package com.leetcode.addtwonumbers;

public class AddTwoNumbers {
    public static void main(String[] args) {


        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;

        ListNode listNode = addTwoNumbers1(l1, l4);

        System.out.println("----" + listNode);
        System.out.println("----" + l1);
        System.out.println("----" + l4);

    }


    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode cur = res, m = l1, n = l2;
        int carry = 0; //进位
        while(m != null || n != null){
           // 依次获取两个加数链表当前指向结点的值
            int x = 0;// 记录链表1的值
            if(m != null){
                x = m.val;
            }
            int y = 0;// 记录链表2的值
            if(n != null){
                y = n.val;
            }
            // 计算两数相加
            int sum = carry + x + y;
            carry = sum / 10;// 更新进位
            cur.next = new ListNode(sum % 10);// 更新结果链表当前指向结点的值
            cur = cur.next;
            // 加数链表当前指向结点后移
            if(m != null){
                m = m.next;
            }
            if(n != null){
                n = n.next;
            }
        }
        // 最后的进位值作为结果链表的最高位
        if(carry != 0){
            cur.next = new ListNode(carry);
        }

        return res.next;

    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;

    }

}
//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    @Override
    public String toString() {
        String str = new String();
        ListNode ln = this;
        while(true){
            if (ln != null){
                str = str + "-" +ln.val;
                ln = ln.next;
            } else{
                break;
            }
        }

        return  str;
    }

}