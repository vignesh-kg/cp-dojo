package main

import (
	"fmt"
)

func twoSum(nums []int, target int) []int {
	var diffMap map[int]int = make(map[int]int, len(nums))
	var diff int
	for i, num := range nums{
		diff = target - num
		if index, ok := diffMap[diff]; ok{
			return []int{index, i}
		}
		diffMap[num] = i
	}
	return []int{}
}

func main(){
	fmt.Println(twoSum([]int{2,7,11,15}, 18));
}