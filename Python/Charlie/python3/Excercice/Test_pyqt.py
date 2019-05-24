import sys
from PyQt5 import (QtWidgets, QtCore)

app = QtWidgets.QApplication(sys.argv)
widget = QtWidgets.QWidget()
widget.resize(1024, 768)
widget.setWindowTitle("The French Helper")
widget.show()
sys.exit(app.exec())