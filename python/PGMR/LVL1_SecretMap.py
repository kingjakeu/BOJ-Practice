def solution(n, arr1, arr2):
    answer = []
    std = pow(2, n)

    for i in range(0, n):
        str = bin(arr1[i] | arr2[i] | std)[3:]
        str = str.replace("1", "#")
        str = str.replace("0", " ")
        answer.append(str)

    return answer


solution(6, [46, 33, 33 ,22, 31, 50], [27 ,56, 19, 14, 14, 10])