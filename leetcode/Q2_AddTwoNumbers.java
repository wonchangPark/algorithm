public class Q2_AddTwoNumbers {
    public static class  ListNode{
        int val;
        ListNode next;
        ListNode(){ }
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next){ this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        // 위는 주어진 예시 코드
        // 숫자의 개수 범위가 100개까지 있기 때문에 Integer로 변환해서는 안된다.

        // 리턴의 값이 맨 처음 링크드리스트의 값이기 때문에 dummy를 만들어서 첫번째 노드를 저장하고
        // curr이라는 노드를 만들어서 while문을 돌면서 계속 노드들을 이어주는 역할을 한다.
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int num = val1 + val2 + carry;
            carry = num / 10;

            ListNode n = new ListNode(num % 10);
            curr.next = n;
            curr = n;

            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        // 맨 처음 값부터 차례로 출력해야 하므로 dummy가 가르키는 첫번째 노드를 반환
        System.out.println(dummy.next);

    }
}
