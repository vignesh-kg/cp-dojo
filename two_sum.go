package main

import "fmt"

func main(){
	nums := []int{2,7,11,15}
	fmt.Println(twoSum(nums, 22))
}

func twoSum(nums []int, target int) []int {
    diffMap := make(map[int]int, len(nums))
		var diff int
		for i, num := range nums{
			diff = target - num
			if seen, ok := diffMap[diff];ok{
				return []int{seen, i}
			}
			diffMap[num] = i
		}
		return []int{-1, -1}
}