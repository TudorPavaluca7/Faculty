#pragma once
#include "ui_view.h"
#include <QtWidgets\QMainWindow>
#include "Table.h"
#include "AdoptionList.h"
class View :public QMainWindow
{
	Q_OBJECT
private:
	AdoptionList &adp;
	Table* table;
	Ui::MainWindow ui;
public:
	View(AdoptionList &ad, QWidget *parent = Q_NULLPTR);
	~View();
private:
	void setupTableView();
};