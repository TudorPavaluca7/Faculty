#include "ch.h"
Ch::Ch(User &u1, User &u2, QWidget *parent) :QMainWindow(parent)
{
	ui.setupUi(this);
	this->setUser1(u1);
	this->setUser2(u2);
	this->connectSignalsAndSlots();

}

void Ch::connectSignalsAndSlots()
{
	//QObject::connect(this->ui.CSVButton)
	QObject::connect(this->ui.CSVButton, SIGNAL(clicked()), this, SLOT(User1Mode()));
	QObject::connect(this->ui.HTMLButton, SIGNAL(clicked()), this, SLOT(User2Mode()));
}

void Ch::setUser1(User & u1)
{
	this->usr1 = &u1;
}

void Ch::setUser2(User & u2)
{
	this->usr2 = &u2;
}

void Ch::User2Mode()
{
	this->usr2->show();
}

void Ch::User1Mode()
{
	this->usr1->show();
}
