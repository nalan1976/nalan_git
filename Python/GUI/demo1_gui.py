import sys
from PyQt5.QtWidgets import QApplication, QMainWindow,QMessageBox,QDialog
from demo_first_win import *
import popup_win as popup

class MyWindow(QMainWindow,Ui_MainWindow):
    def __init__(self, parent=None):
        super(MyWindow, self).__init__(parent)
        self.setupUi(self)
        self.btnQuit.clicked.connect(self.end_event)  # 绑定登陆函数

    # 登陆函数
    def end_event(self):
        if self.name_Edit.text() == "":
            QMessageBox.about(self, '登陆', '请输入姓名')
        elif self.pass_Edit.text() == "":
            QMessageBox.about(self, '登陆', '请输入密码')
        else:
            QMessageBox.about(self, '登陆', self.name_Edit.text() + ' 欢迎登陆')

if __name__ == '__main__':
    app = QApplication(sys.argv)
    myWin = MyWindow()
    myWin.show()

    ###########################
    popWin = QDialog()
    popUi = popup.Ui_Dialog()
    popUi.setupUi(popWin)
    popWin.show()
    ###########################
    sys.exit(app.exec_())