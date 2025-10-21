package main

import "fmt"

type ListNode struct{
	Val int
	Next *ListNode
}

func main(){
	head_1 := &ListNode{2, &ListNode{4, &ListNode{3, nil}}}
	head_2 := &ListNode{5, &ListNode{6, &ListNode{4, nil}}}

	res := addTwoNumbers(head_1, head_2)
	for res != nil{
		fmt.Printf("%d\t", res.Val)
		res = res.Next
	}
	fmt.Print("\n")
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    var res_head *ListNode = &ListNode{-1, nil}
		var res_copy *ListNode = res_head
		var carry, sum int = 0, 0
		for l1 != nil || l2 != nil{
			sum = 0
			if(l1 != nil){
				sum = sum + l1.Val
				l1 = l1.Next
			}

			if(l2 != nil){
				sum = sum + l2.Val
				l2 = l2.Next
			}

			if carry != 0{
				sum = sum + carry
			}
			res_head.Next = &ListNode{sum%10, nil}
			res_head = res_head.Next
			carry = sum / 10
		}

		if carry != 0{
			res_head.Next = &ListNode{carry, nil}
		}

		return res_copy.Next
}