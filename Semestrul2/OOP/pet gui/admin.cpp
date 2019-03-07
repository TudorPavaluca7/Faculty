#include "admin.h"
Admin::Admin(Controller c, Repository r, QWidget *parent) :repo{ r }, ctrl{ c },QMainWindow(parent)
{
	ui.setupUi(this);
	
	this->connectSignalAndSlots();
	this->populate();
}

void Admin::populate()
{
	if (ui.listWidget->count() != 0)
		ui.listWidget->clear();
	for (auto d : this->ctrl.getRepo().getDogs()) {
		QString listItem = QString::fromStdString(d.toString());
		QListWidgetItem *listItemWidget = new QListWidgetItem(listItem);
		this->ui.listWidget->addItem(listItemWidget);
	}
	if (repo.len() > 0)
		ui.listWidget->setCurrentRow(0);
	
}

int Admin::getSelectedIndex()
{
	if (ui.listWidget->count() == 0)
		return -1;
	QModelIndexList indexList = this->ui.listWidget->selectionModel()->selectedIndexes();
	if (indexList.size()==0)
	{
		ui.BreedLine->clear();
		ui.NameLine->clear();
		ui.AgeLine->clear();
		ui.WeightLine->clear();
		ui.SourceLine->clear();
		return -1;
	}
	int index = indexList.at(0).row();
	return index;


}

void Admin::add()
{
	int t1 = ui.BreedLine->text().length();
	int g1 = ui.NameLine->text().length();
	int y1 = ui.AgeLine->text().length();
	int l1 = ui.WeightLine->text().length();
	int tr1 = ui.SourceLine->text().length();

	std::string t = ui.BreedLine->text().toStdString();
	std::string g = ui.NameLine->text().toStdString();
	int y = ui.AgeLine->text().toInt();
	int l = ui.WeightLine->text().toInt();
	std::string tr = ui.SourceLine->text().toStdString();
	Dog m{ t,g,y,tr,l };

	ui.BreedLine->clear();
	ui.NameLine->clear();
	ui.AgeLine->clear();
	ui.WeightLine->clear();
	ui.SourceLine->clear();

	if (t1 == 0 || g1 == 0 || y1 == 0 || l1 == 0 || tr1 == 0)
	{
		QMessageBox messageBox;
		messageBox.critical(0, "error", QString::fromStdString("Fill in the text lines to add a dog!"));
		return;
	}

	//int f = this->repo.findPos(m.getName());
	int f = this->ctrl.getRepo().findPos(m.getName());
	if (f != -1)
	{
		QMessageBox messageBox;
		messageBox.critical(0, "error", QString::fromStdString("You cannot have 2 dogs with the same name!"));
		return;
	}
	try
	{
		this->ctrl.addDogToRepo(t, g, y, tr, l);

	}
	catch (DogException& e)
	{
		for (auto s : e.getErrors())
		{
			QMessageBox messageBox;
			messageBox.critical(0, "error", QString::fromStdString(s));
		}
	}
	//this->ctrl.addDogToRepo(t,g,y,tr,l);
	this->populate();


}

void Admin::del()
{
	int i = this->getSelectedIndex();
	this->ctrl.delGui(i);
	//int r=this->repo.findPos()
	this->populate();
}

void Admin::update()
{
	std::string t = ui.NameLine->text().toStdString();
	int y = ui.AgeLine->text().toInt();
	ui.NameLine->clear();
	ui.AgeLine->clear();
	int f = repo.findPos(t);
	if (f == -1)
	{
		QMessageBox messageBox;
		messageBox.critical(0, "error", QString::fromStdString("the dog doesn't exist!"));
		return;

	}
	//repo.update(t,y);
	ctrl.updateController(t, y);
	this->populate();
}

void Admin::filt()
{
	int weight = ui.WeightLine->text().toInt();
	ui.WeightLine->clear();
	//Repository re{ "catei.txt" };
	repo=this->ctrl.filt(weight);
	this->popFilter();

}
void Admin::undo()
{
	try
	{
		this->ctrl.Undo();
	}
	catch (const char* msg) {
		QMessageBox messageBox;
		messageBox.critical(0, "error", QString::fromStdString(msg));
	}
	repo = this->ctrl.getRepo();
	//this->populate;
	this->popFilter();
}

void Admin::redo()
{
	try
	{
		this->ctrl.Redo();
	}
	catch (const char* msg) {
		QMessageBox messageBox;
		messageBox.critical(0, "error", QString::fromStdString(msg));
	}
	repo = this->ctrl.getRepo();
	//this->populate;
	this->popFilter();

}

void Admin::popFilter()
{
	if (ui.listWidget->count() != 0)
		ui.listWidget->clear();
	for (auto d : repo.getDogs()) {
		QString listItem = QString::fromStdString(d.toString());
		QListWidgetItem *listItemWidget = new QListWidgetItem(listItem);
		this->ui.listWidget->addItem(listItemWidget);
	}
	if (repo.len() > 0)
		ui.listWidget->setCurrentRow(0);
}

void Admin::connectSignalAndSlots()
{
	QObject::connect(ui.listWidget, SIGNAL(itemSelectionChanged()), this, SLOT(listItemChanged()));

	QObject::connect(this->ui.addButton, SIGNAL(clicked()), this, SLOT(add()));

	QObject::connect(this->ui.removeButton, SIGNAL(clicked()), this, SLOT(del()));

	QObject::connect(this->ui.updateButton, SIGNAL(clicked()), this, SLOT(update()));

	QObject::connect(this->ui.filtButton, SIGNAL(clicked()), this, SLOT(filt()));
	QObject::connect(this->ui.undoButton, SIGNAL(clicked()), this, SLOT(undo()));

	QObject::connect(this->ui.redoButton, SIGNAL(clicked()), this, SLOT(redo()));
}