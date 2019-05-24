# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'Statistics.ui'
#
# Created by: PyQt5 UI code generator 5.11.3
#
# WARNING! All changes made in this file will be lost!

from PyQt5 import QtCore, QtGui, QtWidgets

class Ui_Dialog(object):
    def setupUi(self, Dialog):
        Dialog.setObjectName("Dialog")
        Dialog.resize(594, 511)
        self.labelCorrect = QtWidgets.QLabel(Dialog)
        self.labelCorrect.setGeometry(QtCore.QRect(120, 40, 221, 21))
        self.labelCorrect.setObjectName("labelCorrect")
        self.labelIncorrect = QtWidgets.QLabel(Dialog)
        self.labelIncorrect.setGeometry(QtCore.QRect(120, 70, 221, 21))
        self.labelIncorrect.setObjectName("labelIncorrect")
        self.labelNumcorrect = QtWidgets.QLabel(Dialog)
        self.labelNumcorrect.setGeometry(QtCore.QRect(350, 40, 61, 21))
        self.labelNumcorrect.setText("")
        self.labelNumcorrect.setObjectName("labelNumcorrect")
        self.labelNumincorrect = QtWidgets.QLabel(Dialog)
        self.labelNumincorrect.setGeometry(QtCore.QRect(350, 70, 61, 21))
        self.labelNumincorrect.setText("")
        self.labelNumincorrect.setObjectName("labelNumincorrect")
        self.label = QtWidgets.QLabel(Dialog)
        self.label.setGeometry(QtCore.QRect(23, 469, 541, 31))
        self.label.setObjectName("label")
        self.checkwordsButton = QtWidgets.QPushButton(Dialog)
        self.checkwordsButton.setGeometry(QtCore.QRect(60, 280, 81, 23))
        self.checkwordsButton.setObjectName("checkwordsButton")
        self.plainTextEdit = QtWidgets.QPlainTextEdit(Dialog)
        self.plainTextEdit.setGeometry(QtCore.QRect(173, 220, 241, 171))
        self.plainTextEdit.setObjectName("plainTextEdit")
        self.labelHardWords = QtWidgets.QLabel(Dialog)
        self.labelHardWords.setGeometry(QtCore.QRect(183, 231, 221, 151))
        self.labelHardWords.setText("")
        self.labelHardWords.setObjectName("labelHardWords")

        self.retranslateUi(Dialog)
        QtCore.QMetaObject.connectSlotsByName(Dialog)

    def retranslateUi(self, Dialog):
        _translate = QtCore.QCoreApplication.translate
        Dialog.setWindowTitle(_translate("Dialog", "Dialog"))
        self.labelCorrect.setText(_translate("Dialog", "YOUR CORRECT WORDS                 :"))
        self.labelIncorrect.setText(_translate("Dialog", "YOUT INCORRECT WORDS               :"))
        self.label.setText(_translate("Dialog", "Your words which are incorrect were saved in your Hardwords_sheet."))
        self.checkwordsButton.setText(_translate("Dialog", "check words"))
    def showInfo(self, corr, incorr):
        _translate = QtCore.QCoreApplication.translate
        self.labelNumcorrect.setText(_translate("Dialog", str(corr)))
        self.labelNumincorrect.setText(_translate("Dialog", str(incorr)))
