from _ast import List


class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        answer = 0
        for num in nums:
            if len(str(num))%2 is 0:
                answer += 1

        return answer