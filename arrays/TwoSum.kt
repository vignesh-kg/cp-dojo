package arrays

import java.util.Scanner

fun main(){
    val scanner = Scanner(System.`in`);
    val size = scanner.nextInt();
    val nums: IntArray = IntArray(size);
    for(i in 0 until size){
        nums[i] = scanner.nextInt();
    }
    val target = scanner.nextInt();
    println(twoSum(nums, target).joinToString());
}

/**
 * Given an array of integers and a target
 * return index of numbers in nums which adds up to target
 * nums[i] + nums[j] = target
 *
 * solution:
 * we use a Hashmap to store the difference and it's index in a hashMap
 * and we iterate the array. If diffMap contains the difference in hashMap, return the indices
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    val diffMap = HashMap<Int, Int>();
    for((i, num) in nums.withIndex()){
        val diff = target - num;
        if(diffMap.containsKey(diff)){
            return intArrayOf(diffMap[diff]!!, i);
        }
        diffMap[num] = i;
    }
    return intArrayOf(-1, -1);
}