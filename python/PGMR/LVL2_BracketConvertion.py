def make2uv(p):
    stack = [p[0]]
    count = 1
    for c in p[1:]:
        if not stack:
            break
        else:
            if stack[-1] != c:
                stack.pop()
            else:
                stack.append(c)
            count += 1
    return [p[0:count], p[count:]]

def isCompleted(u):
    stack = []
    for c in u:
        if not stack:
            if c is not '(':
                return False
            else:
                stack.append(c)
        else:
            if stack[-1] != c:
                stack.pop()
            else:
                stack.append(c)
    if not stack:
        return True
    else:
        return False
def reverse(u):
    str = ""
    length = len(u)
    for c in u[1:length-1]:
        if c is '(':
            str += ')'
        else:
            str += '('
    return str

def convert(p):
    if p is "":
        return p
    else:
        dlist = make2uv(p)
        #print(dlist)
        if isCompleted(dlist[0]):
            return dlist[0]+convert(dlist[1])
        else:
            return "("+convert(dlist[1])+")"+reverse(dlist[0])

def solution(p):
    answer = convert(p)
    #print(answer)
    return answer

solution(")()()()(")