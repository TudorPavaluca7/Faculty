/********************************************************************************
** Form generated from reading UI file 'petgui.ui'
**
** Created by: Qt User Interface Compiler version 5.10.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_PETGUI_H
#define UI_PETGUI_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QToolBar>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_petguiClass
{
public:
    QWidget *centralWidget;
    QMenuBar *menuBar;
    QToolBar *mainToolBar;
    QStatusBar *statusBar;

    void setupUi(QMainWindow *petguiClass)
    {
        if (petguiClass->objectName().isEmpty())
            petguiClass->setObjectName(QStringLiteral("petguiClass"));
        petguiClass->resize(600, 400);
        centralWidget = new QWidget(petguiClass);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        petguiClass->setCentralWidget(centralWidget);
        menuBar = new QMenuBar(petguiClass);
        menuBar->setObjectName(QStringLiteral("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 600, 21));
        petguiClass->setMenuBar(menuBar);
        mainToolBar = new QToolBar(petguiClass);
        mainToolBar->setObjectName(QStringLiteral("mainToolBar"));
        petguiClass->addToolBar(Qt::TopToolBarArea, mainToolBar);
        statusBar = new QStatusBar(petguiClass);
        statusBar->setObjectName(QStringLiteral("statusBar"));
        petguiClass->setStatusBar(statusBar);

        retranslateUi(petguiClass);

        QMetaObject::connectSlotsByName(petguiClass);
    } // setupUi

    void retranslateUi(QMainWindow *petguiClass)
    {
        petguiClass->setWindowTitle(QApplication::translate("petguiClass", "petgui", nullptr));
    } // retranslateUi

};

namespace Ui {
    class petguiClass: public Ui_petguiClass {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_PETGUI_H
