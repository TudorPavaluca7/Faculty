#pragma once
#include <QtWidgets\QMainWindow>
#include "user.h"
#include "Controller.h"
#include "ui_n.h"
class N :public QMainWindow
{
	Q_OBJECT
public:
	N(QWidget *parent = Q_NULLPTR);
private:
	Ui::Nw ui;
	

};