/********************************************************************************
** Form generated from reading UI file 'mode.ui'
**
** Created by: Qt User Interface Compiler version 5.10.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_MODE_H
#define UI_MODE_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_ModeWindow
{
public:
    QWidget *centralwidget;
    QHBoxLayout *horizontalLayout_2;
    QVBoxLayout *verticalLayout;
    QLabel *label;
    QHBoxLayout *horizontalLayout;
    QPushButton *ListButton;
    QPushButton *adminButton;
    QPushButton *userButton_2;

    void setupUi(QMainWindow *ModeWindow)
    {
        if (ModeWindow->objectName().isEmpty())
            ModeWindow->setObjectName(QStringLiteral("ModeWindow"));
        ModeWindow->resize(446, 234);
        centralwidget = new QWidget(ModeWindow);
        centralwidget->setObjectName(QStringLiteral("centralwidget"));
        horizontalLayout_2 = new QHBoxLayout(centralwidget);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        label = new QLabel(centralwidget);
        label->setObjectName(QStringLiteral("label"));
        QFont font;
        font.setPointSize(11);
        label->setFont(font);

        verticalLayout->addWidget(label);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        ListButton = new QPushButton(centralwidget);
        ListButton->setObjectName(QStringLiteral("ListButton"));

        horizontalLayout->addWidget(ListButton);

        adminButton = new QPushButton(centralwidget);
        adminButton->setObjectName(QStringLiteral("adminButton"));

        horizontalLayout->addWidget(adminButton);

        userButton_2 = new QPushButton(centralwidget);
        userButton_2->setObjectName(QStringLiteral("userButton_2"));

        horizontalLayout->addWidget(userButton_2);


        verticalLayout->addLayout(horizontalLayout);


        horizontalLayout_2->addLayout(verticalLayout);

        ModeWindow->setCentralWidget(centralwidget);

        retranslateUi(ModeWindow);

        QMetaObject::connectSlotsByName(ModeWindow);
    } // setupUi

    void retranslateUi(QMainWindow *ModeWindow)
    {
        ModeWindow->setWindowTitle(QApplication::translate("ModeWindow", "mode", nullptr));
        label->setText(QApplication::translate("ModeWindow", "Do you want to continue as an admin or as an user?", nullptr));
        ListButton->setText(QApplication::translate("ModeWindow", "Adoption List", nullptr));
        adminButton->setText(QApplication::translate("ModeWindow", "Admin", nullptr));
        userButton_2->setText(QApplication::translate("ModeWindow", "User", nullptr));
    } // retranslateUi

};

namespace Ui {
    class ModeWindow: public Ui_ModeWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_MODE_H
