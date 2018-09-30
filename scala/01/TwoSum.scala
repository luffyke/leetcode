object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var result = new Array[Int](2)
        var flag = false
        var i = 0
        while (i < nums.length && !flag) {
            var j = i + 1
            while (j < nums.length && !flag) {
                if (nums(i) + nums(j) == target) {
                    result(0) = i
                    result(1) = j
                    flag = true
                }
                j += 1
            }
            i += 1
        }
        return result
    }
}