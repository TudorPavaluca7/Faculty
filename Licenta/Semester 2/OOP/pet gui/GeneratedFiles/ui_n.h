/********************************************************************************
** Form generated from reading UI file 'n.ui'
**
** Created by: Qt User Interface Compiler version 5.10.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_N_H
#define UI_N_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QListWidget>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Nw
{
public:
    QWidget *centralwidget;
    QListWidget *listWidget;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *Nw)
    {
        if (Nw->objectName().isEmpty())
            Nw->setObjectName(QStringLiteral("Nw"));
        Nw->resize(800, 600);
        centralwidget = new QWidget(Nw);
        centralwidget->setObjectName(QStringLiteral("centralwidget"));
        listWidget = new QListWidget(centralwidget);
        listWidget->setObjectName(QStringLiteral("listWidget"));
        listWidget->setGeometry(QRect(40, 30, 401, 301));
        Nw->setCentralWidget(centralwidget);
        menubar = new QMenuBar(Nw);
        menubar->setObjectName(QStringLiteral("menubar"));
        menubar->setGeometry(QRect(0, 0, 800, 21));
        Nw->setMenuBar(menubar);
        statusbar = new QStatusBar(Nw);
        statusbar->setObjectName(QStringLiteral("statusbar"));
        Nw->setStatusBar(statusbar);

        retranslateUi(Nw);

        QMetaObject::connectSlotsByName(Nw);
    } // setupUi

    void retranslateUi(QMainWindow *Nw)
    {
        Nw->setWindowTitle(QApplication::translate("Nw", "MainWindow", nullptr));
    } // retranslateUi

};

namespace Ui {
    class Nw: public Ui_Nw {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_N_H
