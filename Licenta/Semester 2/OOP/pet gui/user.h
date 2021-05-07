#pragma once
#include <QtWidgets\QMainWindow>
#include "ui_user.h"
#include "Controller.h"
#include <QtWidgets\qmessagebox.h>
class User :public QMainWindow
{
	Q_OBJECT
public:
	User(Controller c1,QWidget *parent = Q_NULLPTR);
private:
	Ui::UserWindow ui;
	Controller contro;
	//Controller ctr
	Repository filter{ "catei.txt" };
	
	//Repository filter{"catei.txt"};
	int getSelectedIndex();
	void connectSignalsAndSlots();
	void populateAdoptionList();
	void populateFilter();
	int ok;
	private slots:
	void filterDogs();
	void addDog();
	void showCSV();
	void showHTML();
	void nextDog();
	

};