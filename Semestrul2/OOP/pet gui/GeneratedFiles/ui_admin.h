/********************************************************************************
** Form generated from reading UI file 'admin.ui'
**
** Created by: Qt User Interface Compiler version 5.10.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_ADMIN_H
#define UI_ADMIN_H

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

class Ui_AdminWindow
{
public:
    QWidget *centralwidget;
    QLabel *label;
    QListWidget *listWidget;
    QWidget *layoutWidget;
    QHBoxLayout *horizontalLayout;
    QVBoxLayout *verticalLayout;
    QLabel *label_2;
    QLabel *label_3;
    QLabel *label_4;
    QLabel *label_5;
    QLabel *label_6;
    QVBoxLayout *verticalLayout_2;
    QLineEdit *BreedLine;
    QLineEdit *NameLine;
    QLineEdit *AgeLine;
    QLineEdit *WeightLine;
    QLineEdit *SourceLine;
    QWidget *layoutWidget1;
    QVBoxLayout *verticalLayout_3;
    QPushButton *addButton;
    QPushButton *updateButton;
    QPushButton *undoButton;
    QWidget *layoutWidget2;
    QVBoxLayout *verticalLayout_4;
    QPushButton *removeButton;
    QPushButton *filtButton;
    QPushButton *redoButton;
    QPushButton *sdfsdfsdfsdf;
    QPushButton *pushButton;

    void setupUi(QMainWindow *AdminWindow)
    {
        if (AdminWindow->objectName().isEmpty())
            AdminWindow->setObjectName(QStringLiteral("AdminWindow"));
        AdminWindow->resize(583, 528);
        centralwidget = new QWidget(AdminWindow);
        centralwidget->setObjectName(QStringLiteral("centralwidget"));
        label = new QLabel(centralwidget);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(30, 10, 51, 21));
        listWidget = new QListWidget(centralwidget);
        listWidget->setObjectName(QStringLiteral("listWidget"));
        listWidget->setGeometry(QRect(20, 30, 541, 261));
        layoutWidget = new QWidget(centralwidget);
        layoutWidget->setObjectName(QStringLiteral("layoutWidget"));
        layoutWidget->setGeometry(QRect(20, 330, 281, 128));
        horizontalLayout = new QHBoxLayout(layoutWidget);
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        horizontalLayout->setContentsMargins(0, 0, 0, 0);
        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        label_2 = new QLabel(layoutWidget);
        label_2->setObjectName(QStringLiteral("label_2"));

        verticalLayout->addWidget(label_2);

        label_3 = new QLabel(layoutWidget);
        label_3->setObjectName(QStringLiteral("label_3"));

        verticalLayout->addWidget(label_3);

        label_4 = new QLabel(layoutWidget);
        label_4->setObjectName(QStringLiteral("label_4"));

        verticalLayout->addWidget(label_4);

        label_5 = new QLabel(layoutWidget);
        label_5->setObjectName(QStringLiteral("label_5"));

        verticalLayout->addWidget(label_5);

        label_6 = new QLabel(layoutWidget);
        label_6->setObjectName(QStringLiteral("label_6"));

        verticalLayout->addWidget(label_6);


        horizontalLayout->addLayout(verticalLayout);

        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2->setObjectName(QStringLiteral("verticalLayout_2"));
        BreedLine = new QLineEdit(layoutWidget);
        BreedLine->setObjectName(QStringLiteral("BreedLine"));

        verticalLayout_2->addWidget(BreedLine);

        NameLine = new QLineEdit(layoutWidget);
        NameLine->setObjectName(QStringLiteral("NameLine"));

        verticalLayout_2->addWidget(NameLine);

        AgeLine = new QLineEdit(layoutWidget);
        AgeLine->setObjectName(QStringLiteral("AgeLine"));

        verticalLayout_2->addWidget(AgeLine);

        WeightLine = new QLineEdit(layoutWidget);
        WeightLine->setObjectName(QStringLiteral("WeightLine"));

        verticalLayout_2->addWidget(WeightLine);

        SourceLine = new QLineEdit(layoutWidget);
        SourceLine->setObjectName(QStringLiteral("SourceLine"));

        verticalLayout_2->addWidget(SourceLine);


        horizontalLayout->addLayout(verticalLayout_2);

        layoutWidget1 = new QWidget(centralwidget);
        layoutWidget1->setObjectName(QStringLiteral("layoutWidget1"));
        layoutWidget1->setGeometry(QRect(380, 350, 77, 83));
        verticalLayout_3 = new QVBoxLayout(layoutWidget1);
        verticalLayout_3->setObjectName(QStringLiteral("verticalLayout_3"));
        verticalLayout_3->setContentsMargins(0, 0, 0, 0);
        addButton = new QPushButton(layoutWidget1);
        addButton->setObjectName(QStringLiteral("addButton"));

        verticalLayout_3->addWidget(addButton);

        updateButton = new QPushButton(layoutWidget1);
        updateButton->setObjectName(QStringLiteral("updateButton"));

        verticalLayout_3->addWidget(updateButton);

        undoButton = new QPushButton(layoutWidget1);
        undoButton->setObjectName(QStringLiteral("undoButton"));

        verticalLayout_3->addWidget(undoButton);

        layoutWidget2 = new QWidget(centralwidget);
        layoutWidget2->setObjectName(QStringLiteral("layoutWidget2"));
        layoutWidget2->setGeometry(QRect(470, 350, 77, 83));
        verticalLayout_4 = new QVBoxLayout(layoutWidget2);
        verticalLayout_4->setObjectName(QStringLiteral("verticalLayout_4"));
        verticalLayout_4->setContentsMargins(0, 0, 0, 0);
        removeButton = new QPushButton(layoutWidget2);
        removeButton->setObjectName(QStringLiteral("removeButton"));

        verticalLayout_4->addWidget(removeButton);

        filtButton = new QPushButton(layoutWidget2);
        filtButton->setObjectName(QStringLiteral("filtButton"));

        verticalLayout_4->addWidget(filtButton);

        redoButton = new QPushButton(layoutWidget2);
        redoButton->setObjectName(QStringLiteral("redoButton"));

        verticalLayout_4->addWidget(redoButton);

        sdfsdfsdfsdf = new QPushButton(centralwidget);
        sdfsdfsdfsdf->setObjectName(QStringLiteral("sdfsdfsdfsdf"));
        sdfsdfsdfsdf->setGeometry(QRect(370, 480, 75, 23));
        pushButton = new QPushButton(centralwidget);
        pushButton->setObjectName(QStringLiteral("pushButton"));
        pushButton->setGeometry(QRect(500, 490, 75, 23));
        AdminWindow->setCentralWidget(centralwidget);

        retranslateUi(AdminWindow);

        QMetaObject::connectSlotsByName(AdminWindow);
    } // setupUi

    void retranslateUi(QMainWindow *AdminWindow)
    {
        AdminWindow->setWindowTitle(QApplication::translate("AdminWindow", "admin", nullptr));
        label->setText(QApplication::translate("AdminWindow", "DogRepo", nullptr));
        label_2->setText(QApplication::translate("AdminWindow", "Breed", nullptr));
        label_3->setText(QApplication::translate("AdminWindow", "Name", nullptr));
        label_4->setText(QApplication::translate("AdminWindow", "Age", nullptr));
        label_5->setText(QApplication::translate("AdminWindow", "Weight", nullptr));
        label_6->setText(QApplication::translate("AdminWindow", "Source", nullptr));
        addButton->setText(QApplication::translate("AdminWindow", "Add", nullptr));
        updateButton->setText(QApplication::translate("AdminWindow", "Update", nullptr));
        undoButton->setText(QApplication::translate("AdminWindow", "undo", nullptr));
        removeButton->setText(QApplication::translate("AdminWindow", "Remove", nullptr));
        filtButton->setText(QApplication::translate("AdminWindow", "filtrare", nullptr));
        redoButton->setText(QApplication::translate("AdminWindow", "redo", nullptr));
        sdfsdfsdfsdf->setText(QApplication::translate("AdminWindow", "sdfsdfs", nullptr));
        pushButton->setText(QApplication::translate("AdminWindow", "j", nullptr));
    } // retranslateUi

};

namespace Ui {
    class AdminWindow: public Ui_AdminWindow {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_ADMIN_H
