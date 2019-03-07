#pragma once
#include <QtWidgets\QMainWindow>
#include "ui_mode.h"
#include "admin.h"
#include "user.h"
#include "Controller.h"
#include "ch.h"
#include "View.h"
class Mode:public QMainWindow
{
	Q_OBJECT
public:
	Mode(View &vim,Admin &a,Ch &u,QWidget *parent = Q_NULLPTR);
private:
	Ui::ModeWindow ui;
	Admin *adm;
	Ch *usr;
	View *v;
	void connectSignalsAndSlots();
	void setAdmin(Admin &a);
	void setUser(Ch &u);
	void setList(View &vi);
	private slots:
	void AdminMode();
	void UserMode();
	void ViewMode();


};