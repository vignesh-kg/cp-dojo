package main

import "fmt"

type ListNode struct {
    Val int
    Next *ListNode
}

func hasCycle(head *ListNode) bool {
    slow, fast := head, head
	for fast != nil && fast.Next != nil{
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast{
			return true
		}
	}
	return false
}

func main(){
	node3 := &ListNode{4, nil}
	node2 := &ListNode{2, &ListNode{0, node3}}
	node1 := &ListNode{3, node2}
	node3.Next = node2
	fmt.Println(hasCycle(node1))
}