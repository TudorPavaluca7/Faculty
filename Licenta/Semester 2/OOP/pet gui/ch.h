#pragma once
#include <QtWidgets\QMainWindow>
#include "ui_ch.h"
#include "user.h"
#include "Controller.h"
class Ch :public QMainWindow
{
	Q_OBJECT
public:
	Ch(User &u1, User &u2, QWidget *parent = Q_NULLPTR);
private:
	Ui::File ui;
	User *usr1;
	User *usr2;
	void connectSignalsAndSlots();
	void setUser1(User &u1);
	void setUser2(User &u2);
	private slots:
	void User1Mode();
	void User2Mode();

};