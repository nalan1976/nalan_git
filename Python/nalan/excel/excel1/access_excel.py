"""
problems:
1. Data type include time information
2.
"""

import openpyxl
import copy
import re

# whole new sheet
lst = []
# total columns number
TATAL_COL = 18


def align(row):
    """
    Align the row into the data that contains TOTAL_COL columns
    """
    # if first col isn't number then put the null string into it
    if row[0] != "" and not is_number(row[0]):
        row.insert(0, "")
    # find the last col(that is the chinese columns) index
    idx = -1
    for i in range(0, len(row)):
        if row[len(row) - i - 1] != "":
            idx = len(row) - i - 1
            break
    # insert several null string into the position
    while idx < TATAL_COL:
        row.insert(idx, "")
        idx += 1
    return row


def is_last_number_not_0(row):
    l = list()
    for col in row:
        if col != "":
            l.append(col)
    if len(l) > 2 and is_number(l[-2]) and str(l[-2]) != "0.0":
        return True
    else:
        return False


def is_number(num):
    pattern = re.compile(r'^[-+]?[-0-9]\d*\.\d*|[-+]?\.?[0-9]\d*$')
    result = pattern.match(str(num))
    if result:
        return True
    else:
        return False


def read_excel(tab):
    # each row of new sheet
    lst2 = list()
    sheet = wb.get_sheet_by_name(tab)

    # for debug only
    idx = 0

    for row in sheet.rows:
        for cell in row:
            if cell.value is not None:
                lst2.append(cell.value)
            else:
                lst2.append("")
        idx += 1
        # print(lst2)
        if is_last_number_not_0(lst2):
            lst.append(align(copy.deepcopy(lst2)))
        lst2.clear()
        # print(lst2)
        # print(lst)
    return lst


def write_excel(path, tab):
    wb = openpyxl.Workbook()
    sheet = wb.create_sheet('demo_sheet', index=0)

    for row in lst:
        sheet.append(row)

    wb.save(path)


def modify_excel(tab):
    sheet = wb.get_sheet_by_name(tab)
    x, y = -1, -1

    for i in range(1, sheet.max_row+1):
        for j in range(1, TATAL_COL+2):
            print(sheet.cell(i, j).value)
            if is_number(sheet.cell(i, j).value):
                x = i
                y = j
        if x != -1 and y != -1:
            sheet.cell(x, y+1).value = 0
            x, y = -1, -1

    wb.save("苏浩然法语单词.xlsx")



wb = openpyxl.load_workbook("e:\\MyCode\\Python\\nalan\\excel\\excel1\\苏浩然法语单词.xlsx")
# read_excel('突击1')
# read_excel('突击2')
# read_excel('突击3')
# read_excel('突击4')
# read_excel('突击5')
# read_excel('突击6')
# read_excel('突击7')
# read_excel('突击8')
modify_excel("顽固词汇2")
# read_excel('突击9')
# read_excel('突击2')
# write_excel("顽固词汇2.xlsx", 0)
