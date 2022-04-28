def NumberofDevesionToSum(n):
    t = [[0 for j in range(n)] for i in range(n)]
    for i in range(n):
        t[i][i] = 1
        t[i][0] = 1
    for i in range(1,n):
        for j in range(1,i):
            for k in range(0,j):
                t[i][j] += t[i-j][k]
    returner = 0
    for i in range(0,n):
        returner += t[n-1][i]
    return returner
n = int(input('insert n: '))
print(NumberofDevesionToSum(n))