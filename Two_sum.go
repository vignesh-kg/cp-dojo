package main

import "fmt"

func main(){
	fmt.Println(twoSum([]int{2,7,11,15}, 9))
}

func twoSum(nums []int, target int) []int {
	var diff_map map[int]int = make(map[int]int, len(nums))
	var diff int;
	for i, num := range nums{
		diff = target - num
		if index, ok := diff_map[diff]; ok{
			return []int{index, i}
		}
		diff_map[num] = i
	}
	return []int{-1, -1}
}