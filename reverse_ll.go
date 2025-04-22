package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	head := ListNode{Val: 1, Next: &ListNode{Val: 2, Next: &ListNode{Val: 3}}}
	new_head := reverseList(&head)
	for ; new_head != nil; new_head = new_head.Next {
		fmt.Printf("%d\t", new_head.Val)
	}
}

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode
	var temp *ListNode
	for head != nil {
		temp = head.Next
		head.Next = prev
		prev = head
		head = temp
	}
	return prev
}
