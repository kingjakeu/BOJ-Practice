from typing import List


class Solution:
    def decompressRLElist(self, nums: List[int]) -> List[int]:
        answer = []
        length = len(nums)
        for i in range(0, length, 2):
            for j in range(0, nums[i]):
                answer.append(nums[i+1])

        return answer

