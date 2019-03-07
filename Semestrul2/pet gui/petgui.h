#pragma once

#include <QtWidgets/QMainWindow>
#include "ui_petgui.h"

class petgui : public QMainWindow
{
	Q_OBJECT

public:
	petgui(QWidget *parent = Q_NULLPTR);

private:
	Ui::petguiClass ui;
};
