/********************************************************************************
** Form generated from reading UI file 'user.ui'
**
** Created by: Qt User Interface Compiler version 5.10.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_USER_H
#define UI_USER_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QListWidget>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QVBoxLayout>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_UserWindow
{
public:
    QWidget *centralwidget;
    QLabel *label;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_4;
    QListWidget *listAdopt;
    QListWidget *listFilter;
    QLineEdit *lineBreed;
    QLineEdit *lineAge;
    QWidget *layoutWidget;
    QVBoxLayout *verticalLayout;
    QHBoxLayout *horizontalLayout;
    QPushButton *nextButton;
    QPushButton *addButton_2;
    QPushButton *filterButton_4;
    QWidget *layoutWidget1;
    QHBoxLayout *horizontalLayout_2;
    QPushButton *csvButton_5;
    QPushButton *htmlButton_6;

    void setupUi(QMainWindow *UserWindow)
    {
        if (UserWindow->objectName().isEmpty())
            UserWindow->setObjectName(QStringLiteral("UserWindow"));
        UserWindow->resize(800, 610);
        centralwidget = new QWidget(UserWindow);
        centralwidget->setObjectName(QStringLiteral("centralwidget"));
        label = new QLabel(centralwidget);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(10, 10, 71, 16));
        label_2 = new QLabel(centralwidget);
        label_2->setObjectName(QStringLiteral("label_2"));
        label_2->setGeometry(QRect(10, 250, 71, 16));
        label_3 = new QLabel(centralwidget);
        label_3->setObjectName(QStringLiteral("label_3"));
        label_3->setGeometry(QRect(10, 480, 71, 16));
        label_4 = new QLabel(centralwidget);
        label_4->setObjectName(QStringLiteral("label_4"));
        label_4->setGeometry(QRect(10, 520, 71, 16));
        listAdopt = new QListWidget(centralwidget);
        listAdopt->setObjectName(QStringLiteral("listAdopt"));
        listAdopt->setGeometry(QRect(0, 30, 561, 211));
        listFilter = new QListWidget(centralwidget);
        listFilter->setObjectName(QStringLiteral("listFilter"));
        listFilter->setGeometry(QRect(10, 270, 561, 192));
        lineBreed = new QLineEdit(centralwidget);
        lineBreed->setObjectName(QStringLiteral("lineBreed"));
        lineBreed->setGeometry(QRect(60, 480, 113, 20));
        lineAge = new QLineEdit(centralwidget);
        lineAge->setObjectName(QStringLiteral("lineAge"));
        lineAge->setGeometry(QRect(60, 520, 113, 20));
        layoutWidget = new QWidget(centralwidget);
        layoutWidget->setObjectName(QStringLiteral("layoutWidget"));
        layoutWidget->setGeometry(QRect(260, 480, 241, 56));
        verticalLayout = new QVBoxLayout(layoutWidget);
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        verticalLayout->setContentsMargins(0, 0, 0, 0);
        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        nextButton = new QPushButton(layoutWidget);
        nextButton->setObjectName(QStringLiteral("nextButton"));

        horizontalLayout->addWidget(nextButton);

        addButton_2 = new QPushButton(layoutWidget);
        addButton_2->setObjectName(QStringLiteral("addButton_2"));

        horizontalLayout->addWidget(addButton_2);


        verticalLayout->addLayout(horizontalLayout);

        filterButton_4 = new QPushButton(layoutWidget);
        filterButton_4->setObjectName(QStringLiteral("filterButton_4"));

        verticalLayout->addWidget(filterButton_4);

        layoutWidget1 = new QWidget(centralwidget);
        layoutWidget1->setObjectName(QStringLiteral("layoutWidget1"));
        layoutWidget1->setGeometry(QRect(390, 570, 158, 25));
        horizontalLayout_2 = new QHBoxLayout(layoutWidget1);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        horizontalLayout_2->setContentsMargins(0, 0, 0, 0);
        csvButton_5 = new QPushButton(layoutWidget1);
        csvButton_5->setObjectName(QStringLiteral("csvButton_5"));

        horizontalLayout_2->addWidget(csvButton_5);

        htmlButton_6 = new QPushButton(layoutWidget1);
        htmlButton_6->setObjectName(QStringLiteral("htmlButton_6"));

        horizontalLayout_2->addWidget(htmlButton_6);

        UserWindow->setCentralWidget(centralwidget);

        retranslateUi(UserWindow);

        QMetaObject::connectSlotsByName(UserWindow);
    } // setupUi

    void retranslateUi(QMainWindow *UserWindow)
    {
        UserWindow->setWindowTitle(QApplication::translate("UserWindow", "user", nullptr));
        label->setText(QApplication::translate("UserWindow", "Adoption List", nullptr));
        label_2->setText(QApplication::translate("UserWindow", "Filter List", nullptr));
        label_3->setText(QApplication::translate("UserWindow", " Breed", nullptr));
        label_4->setText(QApplication::translate("UserWindow", "Age", nullptr));
        nextButton->setText(QApplication::translate("UserWindow", "Next", nullptr));
        addButton_2->setText(QApplication::translate("UserWindow", "Add", nullptr));
        filterButton_4->setText(QApplication::translate("UserWindow", "Filter", nullptr));
        csvButton_5->setText(QApplication::translate("UserWindow", "showCSV", nullptr));
        htmlButton_6->setText(QApplication::translate("UserWindow", "showHTML", nullptr));
    } // retranslateUi

};

namespace Ui {
    class UserWindow: public Ui_UserWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_USER_H
