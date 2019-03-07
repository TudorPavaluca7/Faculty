/********************************************************************************
** Form generated from reading UI file 'password.ui'
**
** Created by: Qt User Interface Compiler version 5.10.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_PASSWORD_H
#define UI_PASSWORD_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_password
{
public:
    QWidget *centralwidget;
    QHBoxLayout *horizontalLayout_2;
    QVBoxLayout *verticalLayout;
    QHBoxLayout *horizontalLayout;
    QLabel *label;
    QLineEdit *lineEdit;
    QPushButton *pushButton;

    void setupUi(QMainWindow *password)
    {
        if (password->objectName().isEmpty())
            password->setObjectName(QStringLiteral("password"));
        password->resize(245, 198);
        centralwidget = new QWidget(password);
        centralwidget->setObjectName(QStringLiteral("centralwidget"));
        horizontalLayout_2 = new QHBoxLayout(centralwidget);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        label = new QLabel(centralwidget);
        label->setObjectName(QStringLiteral("label"));

        horizontalLayout->addWidget(label);

        lineEdit = new QLineEdit(centralwidget);
        lineEdit->setObjectName(QStringLiteral("lineEdit"));

        horizontalLayout->addWidget(lineEdit);


        verticalLayout->addLayout(horizontalLayout);

        pushButton = new QPushButton(centralwidget);
        pushButton->setObjectName(QStringLiteral("pushButton"));

        verticalLayout->addWidget(pushButton);


        horizontalLayout_2->addLayout(verticalLayout);

        password->setCentralWidget(centralwidget);

        retranslateUi(password);

        QMetaObject::connectSlotsByName(password);
    } // setupUi

    void retranslateUi(QMainWindow *password)
    {
        password->setWindowTitle(QApplication::translate("password", "password", nullptr));
        label->setText(QApplication::translate("password", "enter the password", nullptr));
        pushButton->setText(QApplication::translate("password", "Log in", nullptr));
    } // retranslateUi

};

namespace Ui {
    class password: public Ui_password {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_PASSWORD_H
