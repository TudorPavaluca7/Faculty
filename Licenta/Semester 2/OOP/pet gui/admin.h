#pragma once
#include <QtWidgets\QMainWindow>
#include "ui_admin.h"
#include "Repository.h"
#include <QtWidgets\qmessagebox.h>
#include "Controller.h"
#include "DogValidator.h"
class Admin :public QMainWindow
{
	Q_OBJECT
public:
	Admin(Controller c,Repository r,QWidget *parent = Q_NULLPTR);
private:
	Repository repo;
	Controller ctrl;
	Ui::AdminWindow ui;
	void populate();
	int getSelectedIndex();
	private slots:
	void connectSignalAndSlots();
	void add();
	void del();
	void update();
	void filt();
	void undo();
	void redo();
	void popFilter();
};