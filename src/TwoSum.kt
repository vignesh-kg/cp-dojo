fun main(){
    println(twoSum(intArrayOf(2, 7, 11, 21), 18).joinToString())
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val diffMap = HashMap<Int, Int>(nums.size);
    for(i in 0 until nums.size){
        val curNum = nums[i]
        val diff = target - curNum
        if(diffMap.containsKey(diff)){
            return intArrayOf(diffMap[diff]?:0, i)
        }
        diffMap[curNum] = i
    }
    return intArrayOf(-1, -1)
}