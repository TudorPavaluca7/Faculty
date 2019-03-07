#include "View.h"
#include <QSortFilterProxyModel>

View::View(AdoptionList & ad, QWidget * parent):adp{ad}, QMainWindow{ parent }
{
	ui.setupUi(this);
	this->table = new Table(this->adp);
	this->ui.tableView->setModel(this->table);
}

View::~View()
{
	delete this->table;
}

