a=[99,88,77,66, 55]
b=[9,8,7,6,5,4,3]
c=[]
m=4
n=6
while m >= 0 and n >= 0:
    if a[m] < b[n]:
        c.append(a[m])
        m -= 1
    else:
        c.append(b[n])
        n -= 1

while m >= 0:
    c.append(a[m])
    m -= 1

while n >= 0:
    c.append(b[n])
    n -= 1
print(c)