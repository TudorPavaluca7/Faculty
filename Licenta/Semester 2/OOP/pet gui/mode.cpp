#include "mode.h"

Mode::Mode(View &vim,Admin& a,Ch& u,QWidget *parent) :QMainWindow(parent)
{
	ui.setupUi(this);
	this->setAdmin(a);
	this->setUser(u);
	this->setList(vim);
	this->connectSignalsAndSlots();


}

void Mode::connectSignalsAndSlots()
{
	QObject::connect(this->ui.adminButton, SIGNAL(clicked()), this, SLOT(AdminMode()));

	QObject::connect(this->ui.userButton_2, SIGNAL(clicked()), this, SLOT(UserMode()));
	 
	QObject::connect(this->ui.ListButton, SIGNAL(clicked()), this, SLOT(ViewMode()));

}

void Mode::setAdmin(Admin & a)
{
	this->adm = &a;

}

void Mode::setUser(Ch & u)
{
	this->usr = &u;

}

void Mode::setList(View & vi)
{
	this->v = &vi;
}

void Mode::UserMode()
{
	this->usr->show();
}

void Mode::ViewMode()
{
	this->v->show();
}

void Mode::AdminMode()
{
	this->adm->show();
}