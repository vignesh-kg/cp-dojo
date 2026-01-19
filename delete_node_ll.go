package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	var end *ListNode = &ListNode{4, nil}
	var third *ListNode = &ListNode{3, end}
	var head *ListNode = &ListNode{1, &ListNode{2, third}}
	deleteNode(third)
	for head != nil {
		fmt.Printf("%d->", head.Val)
		head = head.Next
	}
	fmt.Print("\n")
}

func deleteNode(node *ListNode) {
	var prev *ListNode;
	for node != nil && node.Next != nil{
		node.Val = node.Next.Val
		prev = node
		node = node.Next
	}
	prev.Next = nil
}