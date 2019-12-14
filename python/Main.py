def solution(dartResult):
    answer = 0
    score = [0]

    count = 0
    tempString = ""
    for c in dartResult:
        if c is "S":
            score.append(int(tempString))
            tempString = ""
            count += 1
        elif c is "D":
            score.append(pow(int(tempString), 2))
            tempString = ""
            count += 1
        elif c is "T":
            score.append(pow(int(tempString), 3))
            tempString = ""
            count += 1
        elif c is "*":
            score[count] *= 2
            score[count-1] *= 2
        elif c is "#":
            if score[count] > 0:
                score[count] *= -1
        else:
            tempString += c
    for s in score:
        answer += s
    return answer

solution("1D2S#10S")