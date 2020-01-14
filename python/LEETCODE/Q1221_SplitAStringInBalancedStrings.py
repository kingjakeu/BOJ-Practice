class Solution:
    def balancedStringSplit(self, s: str) -> int:
        answer = 0
        stack = [s[0]]
        length = len(s)
        for i in range(1, length):
            if stack:
                if stack[-1] == s[i]:
                    stack.append(s[i])
                else:
                    stack.pop()
                    if not stack: answer += 1
            else:
                stack.append(s[i])
        return answer