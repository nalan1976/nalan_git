# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'MainWindows2.ui'
#
# Created by: PyQt5 UI code generator 5.11.3
#
# WARNING! All changes made in this file will be lost!

from PyQt5 import QtCore, QtGui, QtWidgets

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(582, 613)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.tabWidget = QtWidgets.QTabWidget(self.centralwidget)
        self.tabWidget.setGeometry(QtCore.QRect(0, 0, 591, 581))
        self.tabWidget.setObjectName("tabWidget")
        self.tab = QtWidgets.QWidget()
        self.tab.setObjectName("tab")
        self.nextButton = QtWidgets.QPushButton(self.tab)
        self.nextButton.setGeometry(QtCore.QRect(80, 480, 75, 23))
        self.nextButton.setObjectName("nextButton")
        self.lastButton = QtWidgets.QPushButton(self.tab)
        self.lastButton.setGeometry(QtCore.QRect(190, 480, 75, 23))
        self.lastButton.setObjectName("lastButton")
        self.label = QtWidgets.QLabel(self.tab)
        self.label.setGeometry(QtCore.QRect(110, 40, 401, 91))
        self.label.setObjectName("label")
        self.scrollArea = QtWidgets.QScrollArea(self.tab)
        self.scrollArea.setGeometry(QtCore.QRect(310, 309, 271, 81))
        self.scrollArea.setWidgetResizable(True)
        self.scrollArea.setObjectName("scrollArea")
        self.scrollAreaWidgetContents = QtWidgets.QWidget()
        self.scrollAreaWidgetContents.setGeometry(QtCore.QRect(0, 0, 269, 79))
        self.scrollAreaWidgetContents.setObjectName("scrollAreaWidgetContents")
        self.labelIncorrect = QtWidgets.QLabel(self.scrollAreaWidgetContents)
        self.labelIncorrect.setGeometry(QtCore.QRect(20, 40, 158, 31))
        self.labelIncorrect.setObjectName("labelIncorrect")
        self.labelCorrect = QtWidgets.QLabel(self.scrollAreaWidgetContents)
        self.labelCorrect.setGeometry(QtCore.QRect(20, 10, 271, 31))
        self.labelCorrect.setObjectName("labelCorrect")
        self.labelNumcorrect = QtWidgets.QLabel(self.scrollAreaWidgetContents)
        self.labelNumcorrect.setGeometry(QtCore.QRect(190, 10, 71, 31))
        self.labelNumcorrect.setText("")
        self.labelNumcorrect.setObjectName("labelNumcorrect")
        self.labelNumincorrect = QtWidgets.QLabel(self.scrollAreaWidgetContents)
        self.labelNumincorrect.setGeometry(QtCore.QRect(190, 40, 71, 31))
        self.labelNumincorrect.setText("")
        self.labelNumincorrect.setObjectName("labelNumincorrect")
        self.scrollArea.setWidget(self.scrollAreaWidgetContents)
        self.correctButton = QtWidgets.QPushButton(self.tab)
        self.correctButton.setGeometry(QtCore.QRect(70, 210, 91, 41))
        self.correctButton.setObjectName("correctButton")
        self.incorrectButton = QtWidgets.QPushButton(self.tab)
        self.incorrectButton.setGeometry(QtCore.QRect(190, 210, 91, 41))
        self.incorrectButton.setObjectName("incorrectButton")
        self.tabWidget.addTab(self.tab, "")
        self.tab_2 = QtWidgets.QWidget()
        self.tab_2.setObjectName("tab_2")
        self.tabWidget.addTab(self.tab_2, "")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 582, 23))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        self.tabWidget.setCurrentIndex(0)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "MainWindow"))
        self.nextButton.setText(_translate("MainWindow", "Next"))
        self.lastButton.setText(_translate("MainWindow", "Last"))
        self.label.setText(_translate("MainWindow", "Textlabel"))
        self.labelIncorrect.setText(_translate("MainWindow", "Incorrect :"))
        self.labelCorrect.setText(_translate("MainWindow", "Correct :"))
        self.correctButton.setText(_translate("MainWindow", "Correct"))
        self.incorrectButton.setText(_translate("MainWindow", "Incorrect"))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.tab), _translate("MainWindow", "Tab 1"))
        self.tabWidget.setTabText(self.tabWidget.indexOf(self.tab_2), _translate("MainWindow", "Tab 2"))

