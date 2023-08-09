def sorting(new_num,p,q):
    new_num.sort();
    siz=len(new_num);
    if(new_num[siz-1]>0):
        new_num[siz-1]=new_num[siz-1]-p
        if(new_num[siz-1]<0):
            new_num[siz-1]=0
    for i in range (siz-2,-1,-1):
        new_num[i]=new_num[i]-q
        if(new_num[i]<0):
            new_num[i]=0
        
    return new_num;

def minProjecr(errorScore, comP, othq):
    new_num = sorting(errorScore,comP,othq)
    count = 1;
    flag=0;
    while(True):
        flag=0
        for new_nums in new_num:
            if (new_nums == 0):
                flag=0;
                continue
            else:
                new_num=sorting(errorScore,comP,othq)
                count=count+1
                flag=1;
                break
        if(flag==0):
            break
    return count

errroScore = [1,6,4]
errroScore_size = 3
compP = 4
othQ = 1
result = minProjecr(errroScore, compP, othQ)
print(result)