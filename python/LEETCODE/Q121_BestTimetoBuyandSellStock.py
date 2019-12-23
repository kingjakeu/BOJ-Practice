from _ast import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        answer = 0

        size = len(prices)
        if size is 0: return answer

        buy = prices[0]

        for i in range(1, size):
            if buy < prices[i]:
                answer = max(answer, prices[i]-buy)
            elif buy > prices[i]:
                buy = prices[i]

        return answer