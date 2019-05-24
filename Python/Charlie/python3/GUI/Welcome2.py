import QT_Designer.Statistics as stat
from PyQt5.QtWidgets import QDialog
from PyQt5 import QtCore
global stat_dialog
global stat_Ui


class Winoflast:
    strShow = ""

    def __init__(self):
        global stat_dialog
        global stat_Ui
        stat_dialog = QDialog()
        stat_Ui = stat.Ui_Dialog()
        stat_Ui.setupUi(stat_dialog)
        stat_Ui.checkwordsButton.clicked.connect(self.checkwords)
    def setStrShow(self, str1):
        self.strShow = str1
    def checkwords(self):
        global strShow
        global stat_Ui
        _translate = QtCore.QCoreApplication.translate
        stat_Ui.labelHardWords.setText(_translate("Statistics", self.strShow))
    def showInfo(self, num_correct, num_incorrect):
        global stat_dialog
        global stat_Ui
        stat_Ui.showInfo(num_correct, num_incorrect)
        stat_dialog.show()