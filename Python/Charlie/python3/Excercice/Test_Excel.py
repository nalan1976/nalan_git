import openpyxl
def read07Excel(path):
    wb = openpyxl.load_workbook(path)
    sheet = wb.get_sheet_by_name('突击2')

    for row in sheet.rows:
        for cell in row:
            if cell.value != None:
                print(cell.value, "\t", end="")
        print()
read07Excel("E:\\Charlie.py\\The things about excercice\\苏浩然法语单词.xlsx")