import sys
import Utils_func as utils

from PyQt5.QtWidgets import QApplication, QMainWindow,QMessageBox,QDialog
# sys.path.append("QT_Designer")
from QT_Designer.MainWindows2 import *
# import Statistics as stat
from PyQt5 import QtCore, QtGui


import Welcome2 as w2
class MyWindow(QMainWindow,Ui_MainWindow):
    flagCorrect = False
    flagShowMeans = False
    sheet2 = list()
    rang = 1
    # d = dict()
    # print(sheet2)
    num_correct = 0
    num_incorrect = 0
    dict_hardwords = dict()

    def __init__(self, parent=None):
        super(MyWindow, self).__init__(parent)
        self.setupUi(self)
        font = QtGui.QFont()
        # 字体
        font.setFamily('微软雅黑')
        # 加粗
        font.setBold(True)
        # 大小
        font.setPointSize(13)
        font.setWeight(75)
        self.labelShowWord.setFont(font)
        # self.end_Btn.clicked.connect(self.end_event)  # 绑定登陆函数
        self.init()
        self.lastButton.clicked.connect(self.upLast)
        self.nextButton.clicked.connect(self.showWord)
        self.incorrectButton.clicked.connect(self.incorrect)
    def showWord(self):
        if (self.rang == len(self.sheet2)):
            self.addword()
            #stat_Ui.showInfo(self.num_correct, self.num_incorrect)
            #stat_dialog.show()
            win2.showInfo(self.num_correct, self.num_incorrect)
            return
        print(self.sheet2[self.rang][1])
        _translate = QtCore.QCoreApplication.translate
        self.labelShowWord.setText(_translate("MainWindows2", self.sheet2[self.rang][1]))
        if self.flagShowMeans:
            self.flagShowMeans = False
            # 调用函数correct
            #self.correct()
            if self.rang > 0:
               # self.rang = self.rang - 1
                self.labelShowWord.setText(_translate("MainWindows2", self.sheet2[self.rang][1]+" : "+self.sheet2[self.rang][12]))
                self.rang = self.rang + 1
        else:
            self.flagShowMeans = True
            self.labelShowWord.setText(_translate("MainWindows2", self.sheet2[self.rang][1]))
            #屏蔽第一次点击nextButton
            if self.rang > 1:
                self.correct()
                if self.rang == len(self.sheet2) - 1:
                    self.num_correct += 1
            #self.rang += 1
    def upLast(self):
        if self.rang <= 0:
            _translate = QtCore.QCoreApplication.translate
            self.rang += 1
            self.labelShowWord.setText(_translate("MainWindows2",self.sheet2[self.rang][1]))
        else:
            _translate = QtCore.QCoreApplication.translate
            self.rang -= 1
            self.labelShowWord.setText(_translate("MainWindows2", self.sheet2[self.rang][1]))
            #self.rang += 1
    def correct(self):
        _translate = QtCore.QCoreApplication.translate
        #if self.num_incorrect == True:
        self.num_correct += 1
        self.labelNumcorrect.setText(_translate("MainWindows2",str(self.num_correct)))
    def incorrect(self):
        _translate = QtCore.QCoreApplication.translate
        if not(self.sheet2[self.rang - 1][1] in self.dict_hardwords.keys()):
            self.num_incorrect += 1
            self.labelNumincorrect.setText(_translate("MainWindows2", str(self.num_incorrect)))
            self.dict_hardwords[self.sheet2[self.rang -1][1]] = self.sheet2[self.rang - 1][12]
    def addword(self):
        import csv

        with open('Words Sheet\\Hard_words_sheet.csv', 'a+') as hardw:
            # write = csv.writer(hardw)
            write = csv.writer(hardw, delimiter=",", quotechar=" ")
            # for row in dict_hardwords.keys():
            # write.writerows(dict_hardwords)
            print(self.dict_hardwords.keys())
            strShow = ""
            for key in self.dict_hardwords.keys():
                data = "" + key + ":" + str(self.dict_hardwords.get(key)) + "\n"
                hardw.write(data)
                strShow += data
            win2.setStrShow(strShow)


# 登陆函数
   # def end_event(self):
        # if self.name_Edit.text() == "":
        #     QMessageBox.about(self, '登陆', '请输入姓名')
        # elif self.pass_Edit.text() == "":
        #     QMessageBox.about(self, '登陆', '请输入密码')
        # else:
        #     QMessageBox.about(self, '登陆', self.name_Edit.text() + ' 欢迎登陆')

    def init(self):
         #import csv
         #with open("Words Sheet\\words_sheet_test.csv") as sheet:
        self.sheet2 = utils.read07Excel("E:\\Charlie.py\\The things about excercice\\苏浩然法语单词.xlsx")
        print(self.sheet2)

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWin = MyWindow()
    myWin.show()
    win2 = w2.Winoflast()
    #stat_dialog = QDialog()
    #stat_Ui = stat.Ui_Dialog()
    #stat_Ui.setupUi(stat_dialog)
    sys.exit(app.exec_())
