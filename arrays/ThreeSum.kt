package arrays

fun main() {
    for (triplets: List<Int> in threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))) {
        println(triplets.joinToString())
    }

    for (triplets: List<Int> in threeSum(intArrayOf(1, -1, -1, 0))) {
        println(triplets.joinToString())
    }
}


fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val res = ArrayList<List<Int>>()
    for (i in 0 until nums.size) {
        if (i != 0 && nums[i] == nums[i - 1]) {
            continue
        }
        var j = i + 1;
        var k = nums.size - 1
        while (j < k) {
            val sum = nums[i] + nums[j] + nums[k]
            if (sum == 0) {
                res.add(listOf(nums[i], nums[j], nums[k]))
                ++j
                --k

                while (j < k && nums[j] == nums[j - 1]) ++j
                while (j < k && nums[k] == nums[k + 1]) --k
            } else if (sum > 0) --k
            else ++j
        }
    }
    return res
}