package arrays

fun main() {
    for (quadruplet in fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0)) {
        println(quadruplet)
    }

    for (quadruplet in fourSum(intArrayOf(1000000000,1000000000,1000000000,1000000000), -294967296)) {
        println(quadruplet)
    }
}


fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val res = ArrayList<List<Int>>()
    nums.sort()
    val size = nums.size
    for (i in 0 until size) {
        if (i != 0 && nums[i] == nums[i - 1]) {
            continue
        }
        for (j in i + 1 until size) {
            if (j > i + 1 && nums[j] == nums[j - 1])
                continue
            val intermediateTarget = 1L*target - nums[i] - nums[j]
            var k = j + 1
            var l = size - 1
            while (k < l) {
                var sum = 1L*nums[k]
                sum += nums[l]
                if (sum == intermediateTarget) {
                    res.add(listOf(nums[i], nums[j], nums[k], nums[l]))
                    ++k
                    --l
                    while (k < l && nums[k] == nums[k - 1]) ++k
                    while (k < l && nums[l] == nums[l + 1]) --l
                } else if (sum < intermediateTarget) ++k
                else --l
            }
        }
    }
    return res;
}
