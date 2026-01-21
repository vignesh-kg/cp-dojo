package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func main(){
	var list1 *ListNode = &ListNode{1, &ListNode{2, &ListNode{4, nil}}}
	var list2 *ListNode = &ListNode{1, &ListNode{3, &ListNode{4, nil}}}

	var mergedList *ListNode = mergeTwoLists(list1, list2)
	for mergedList != nil{
		fmt.Printf("%d -> ", mergedList.Val)
		mergedList = mergedList.Next
	}
	fmt.Print("\n")
}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    dummy := &ListNode{-1, nil}
	copyNode := dummy
	for list1 != nil && list2 != nil{
		if(list1.Val <= list2.Val){
			dummy.Next = list1
			list1 = list1.Next
		} else {
			dummy.Next = list2
			list2 = list2.Next
		}
		dummy = dummy.Next
	}

	if(list1 != nil){
		dummy.Next = list1
	} else {
		dummy.Next = list2
	}

	return copyNode.Next
}