class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        word = str(n)
        mult = 1
        sum = 0
        for w in word:
            mult *= int(w)
            sum += int(w)

        return mult-sum
