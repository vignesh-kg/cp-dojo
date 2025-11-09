package main

import "fmt"

type ListNode struct{
	Val int
	Next *ListNode
}

func main(){
	var l1 *ListNode = &ListNode{2, &ListNode{4, &ListNode{3, nil}}}
	var l2 *ListNode = &ListNode{5, &ListNode{6, &ListNode{4, nil}}}

	var result *ListNode = addTwoNumbers(l1, l2)
	for result != nil{
		fmt.Print(result.Val, " ")
		result = result.Next
	}
	fmt.Print("\n")
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var res_head *ListNode = &ListNode{-1, nil}
	var copy *ListNode = res_head
	var carry int = 0
	for l1 != nil || l2 != nil{
		var sum int = 0
		if l1 != nil{
			sum += l1.Val
			l1 = l1.Next
		}

		if l2 != nil{
			sum += l2.Val
			l2 = l2.Next
		}

		sum += carry
		copy.Next = &ListNode{sum%10, nil}
		copy = copy.Next
		carry = sum/10
	}

	if carry != 0{
		copy.Next = &ListNode{carry, nil}
	}

	return res_head.Next
}