def domino(dominos, n):
    global max
    max = 0
    if n == 0:
        return 0
    else:
        for i in range(n):
            calculate(dominos[i][0], dominos[i][1], {i}, 1, dominos)
            dominos.remove(dominos[i])
    return max
def calculate(endL, endR, indexes, n, dominos):
    global max
    if n >= len(dominos)-1:
        if n > max:
            max = n
            return
        else:
            return
    if n>max:
        max=n
    for i in range(len(dominos)):
        if i not in indexes:
            if(dominos[i][0] == endL):
                indexes.add(i)
                calculate(dominos[i][1], endR, indexes, n+1, dominos)
                indexes.remove(i)
            if(dominos[i][0] == endR):
                indexes.add(i)
                calculate(endL, dominos[i][1], indexes, n+1, dominos)
                indexes.remove(i)
            if(dominos[i][1] == endL):
                indexes.add(i)
                calculate(endL, dominos[i][1], indexes, n+1, dominos)
                indexes.remove(i)
            if(dominos[i][1] == endR):
                indexes.add(i)
                calculate(endL, dominos[i][0], indexes, n+1, dominos)
                indexes.remove(i)
    return
n = input()
dominos = []
for i in range(int(n)):
    dominos.append(list(map(int, input().split())))
print(domino(dominos, int(n)))