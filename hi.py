def swap_positions(soldiers, row, col):
    m = (col - row) // 2
    for i in range(m + 1):
        soldiers[row + i], soldiers[col - i] = soldiers[col - i], soldiers[row + i]

def soldierAtK(num, soldierPosition, posSoldier):
    N = num
    Q, S = map(int, soldierPosition.pop(0))
    actions = soldierPosition
    soldiers = list(range(1, N + 1))

    for i in range(Q):
        row, col = actions[i]
        swap_positions(soldiers, row - 1, col - 1)

    return soldiers[posSoldier - 1]

def main():
    # input for num
    num = int(input())

    # input for soldierPosition
    soldierPosition = []
    soldierPosition_rows, soldierPosition_cols = map(int, input().split())
    for idx in range(soldierPosition_rows):
        soldierPosition.append(list(map(int, input().split())))

    # input for posSoldier
    posSoldier = int(input())

    result = soldierAtK(num, soldierPosition, posSoldier)
    print(result)

if __name__ == "__main__":
    main()

