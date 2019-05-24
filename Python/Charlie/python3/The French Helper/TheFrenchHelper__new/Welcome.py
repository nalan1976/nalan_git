import sys
from PyQt5.QtWidgets import QApplication, QMainWindow,QMessageBox
from MainWindows2 import *
from PyQt5 import QtCore, QtGui


class MyWindow(QMainWindow,Ui_MainWindow):
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
        self.label.setFont(font)
        # self.end_Btn.clicked.connect(self.end_event)  # 绑定登陆函数
        self.init()
        self.nextButton.clicked.connect(self.showWord)
        self.correctButton.clicked.connect(self.correct)
        self.incorrectButton.clicked.connect(self.incorrect)
    def showWord(self):
        print(self.sheet2[self.rang][1])
        _translate = QtCore.QCoreApplication.translate
        self.label.setText(_translate("MainWindows2", self.sheet2[self.rang][1]))
        if self.flagShowMeans:
            self.flagShowMeans = False
            if self.rang > 0:
                self.rang = self.rang - 1
                self.label.setText(_translate("MainWindows2", self.sheet2[self.rang][1]+" : "+self.sheet2[self.rang][12]))
               # self.rang = self.rang + 1
        else:
            self.flagShowMeans = True
            self.label.setText(_translate("MainWindows2", self.sheet2[self.rang][1]))
        self.rang += 1
    def correct(self):
        _translate = QtCore.QCoreApplication.translate
        self.num_correct += 1
        self.labelNumcorrect.setText(_translate("MainWindows2",str(self.num_correct)))
    def incorrect(self):
        _translate = QtCore.QCoreApplication.translate
        self.num_incorrect += 1
        self.labelNumincorrect.setText(_translate("MainWindows2", str(self.num_incorrect)))


# 登陆函数
   # def end_event(self):
        # if self.name_Edit.text() == "":
        #     QMessageBox.about(self, '登陆', '请输入姓名')
        # elif self.pass_Edit.text() == "":
        #     QMessageBox.about(self, '登陆', '请输入密码')
        # else:
        #     QMessageBox.about(self, '登陆', self.name_Edit.text() + ' 欢迎登陆')

    def init(self):
        import csv
        with open("words_sheet_test.csv") as sheet:
            self.sheet2 = list(csv.reader(sheet))

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWin = MyWindow()
    myWin.show()
    sys.exit(app.exec_())