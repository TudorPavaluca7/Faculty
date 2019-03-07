/********************************************************************************
** Form generated from reading UI file 'ch.ui'
**
** Created by: Qt User Interface Compiler version 5.10.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_CH_H
#define UI_CH_H

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

class Ui_File
{
public:
    QWidget *centralwidget;
    QHBoxLayout *horizontalLayout_2;
    QVBoxLayout *verticalLayout;
    QLabel *label;
    QHBoxLayout *horizontalLayout;
    QPushButton *CSVButton;
    QPushButton *HTMLButton;

    void setupUi(QMainWindow *File)
    {
        if (File->objectName().isEmpty())
            File->setObjectName(QStringLiteral("File"));
        File->resize(286, 167);
        centralwidget = new QWidget(File);
        centralwidget->setObjectName(QStringLiteral("centralwidget"));
        horizontalLayout_2 = new QHBoxLayout(centralwidget);
        horizontalLayout_2->setObjectName(QStringLiteral("horizontalLayout_2"));
        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QStringLiteral("verticalLayout"));
        label = new QLabel(centralwidget);
        label->setObjectName(QStringLiteral("label"));
        QFont font;
        font.setPointSize(18);
        label->setFont(font);

        verticalLayout->addWidget(label);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QStringLiteral("horizontalLayout"));
        CSVButton = new QPushButton(centralwidget);
        CSVButton->setObjectName(QStringLiteral("CSVButton"));

        horizontalLayout->addWidget(CSVButton);

        HTMLButton = new QPushButton(centralwidget);
        HTMLButton->setObjectName(QStringLiteral("HTMLButton"));

        horizontalLayout->addWidget(HTMLButton);


        verticalLayout->addLayout(horizontalLayout);


        horizontalLayout_2->addLayout(verticalLayout);

        File->setCentralWidget(centralwidget);

        retranslateUi(File);

        QMetaObject::connectSlotsByName(File);
    } // setupUi

    void retranslateUi(QMainWindow *File)
    {
        File->setWindowTitle(QApplication::translate("File", "File", nullptr));
        label->setText(QApplication::translate("File", "CSV or HTML?", nullptr));
        CSVButton->setText(QApplication::translate("File", "CSV", nullptr));
        HTMLButton->setText(QApplication::translate("File", "HTML", nullptr));
    } // retranslateUi

};

namespace Ui {
    class File: public Ui_File {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_CH_H
