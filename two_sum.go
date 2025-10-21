package main

import (
	"fmt"
)

func main(){
	nums := []int{2,7,11,15}
	fmt.Println(twoSum(nums, 17))
}

func twoSum(nums []int, target int) []int {
    diff_map := make(map[int]int, len(nums))
		var diff int
		for i, num := range nums{
			diff = target - num
			if index, ok := diff_map[diff];ok{
				return []int{index, i}
			}
			diff_map[num] = i
		}
		return []int {-1, -1}
}