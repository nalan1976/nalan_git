import openpyxl
import copy
def read07Excel(path):
    wb = openpyxl.load_workbook(path)
    sheet = wb.get_sheet_by_name('突击2')
    list1 = list()
    list2 = list()
    for row in sheet.rows:
        list1.append(copy.deepcopy(list2))
        list2.clear()
        for cell in row:
            if cell.value != None:
                list2.append(cell.value)
            else:
                list2.append(",")
    print(list1)
read07Excel("E:\\Charlie.py\\The things about excercice\\苏浩然法语单词.xlsx")
