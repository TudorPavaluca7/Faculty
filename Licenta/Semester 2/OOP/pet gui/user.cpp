#include "user.h"
#include "RepositoryExceptions.h"
User::User(Controller c, QWidget *parent) :contro{c},QMainWindow(parent)
{
	ui.setupUi(this);
	this->connectSignalsAndSlots();
	this->populateAdoptionList();
}







int User::getSelectedIndex()
{
	if (ui.listAdopt->count() == 0)
		return -1;
	QModelIndexList indexList = this->ui.listAdopt->selectionModel()->selectedIndexes();
	if (indexList.size() == 0)
	{
		return -1;
	}
	int index = indexList.at(0).row();
	return index;
}

void User::connectSignalsAndSlots()
{
	QObject::connect(ui.listAdopt, SIGNAL(itemSelectionChanged()), this, SLOT(listItemChanged()));

	QObject::connect(this->ui.addButton_2, SIGNAL(clicked()), this, SLOT(addDog()));

	QObject::connect(this->ui.nextButton, SIGNAL(clicked()), this, SLOT(nextDog()));

	QObject::connect(this->ui.filterButton_4, SIGNAL(clicked()), this, SLOT(filterDogs()));

	QObject::connect(this->ui.csvButton_5, SIGNAL(clicked()), this, SLOT(showCSV()));

	QObject::connect(this->ui.htmlButton_6, SIGNAL(clicked()), this, SLOT(showHTML()));

	




}

void User::populateAdoptionList()
{
	if (ui.listAdopt->count() != 0)
		ui.listAdopt->clear();
	for (auto m : contro.getAdoptionList().getDogs())
	{
		QString listItem = QString::fromStdString(m.toString());
		QListWidgetItem * listItemWidget = new QListWidgetItem(listItem);
		this->ui.listAdopt->addItem(listItemWidget);
	}
	if (contro.getAdoptionList().getLenght() > 0)
		ui.listAdopt->setCurrentRow(0);
	//this->contro.savePlaylist("adopt.csv");
	//this->contro.savePlaylist("adopt.html");



}

void User::filterDogs()
{
	this->filter.clr();
	std::string f = this->ui.lineBreed->text().toStdString();
	int ag = this->ui.lineAge->text().toInt();
	this->ui.lineBreed->clear();
	this->ui.lineAge->clear();
	this->filter=this->contro.filtrare(f,ag);
	this->filter.setCurrent();
	this->ok = 0;
	this->populateFilter();
	


}

void User::populateFilter()
{
	if (ui.listFilter->count() != 0)
		ui.listFilter->clear();
	for (auto m : filter.getDogs())
	{
		QString listItem = QString::fromStdString(m.toString());
		QListWidgetItem * listItemWidget = new QListWidgetItem(listItem);
		this->ui.listFilter->addItem(listItemWidget);
	}
	if (filter.len() > 0)
		ui.listFilter->setCurrentRow(0);




}








void User::addDog()
{
	//try {
	//	if (this->filter.len() == 0)
	//	{
	//		QMessageBox messageBox;
	//		messageBox.critical(0, "error", QString::fromStdString("You have to filter by breed first!"));
	//		return;
	//	}
	//	/*if (this->filter.getCurrent() == -1)
	//	{
	//		QMessageBox messageBox;
	//		messageBox.critical(0, "error", QString::fromStdString("You have to watch the trailer first!"));
	//		return;
	//	}*/
	//
	if (this->ok == 0) {
		Dog d = this->filter.getCurrentDog();
		int f = this->contro.adopt(d);
		if (f == 0)
		{
			QMessageBox messageBox;
			messageBox.critical(0, "error", QString::fromStdString("the dog already exists!"));
			return;
		}
	
	
	
	}
	else
	{
		Dog d = this->contro.getRepo().getCurrentDog();
		int f = this->contro.adopt(d);

		if (f == 0)
		{
			QMessageBox messageBox;
			messageBox.critical(0, "error", QString::fromStdString("the dog already exists!"));
			return;
		}
	}
	this->populateAdoptionList();

}


void User::showCSV()
{
	this->contro.savePlaylist("adopt.csv");
	this->contro.openPlaylist();

}

void User::showHTML()
{
	this->contro.savePlaylist("adopt.html");
	this->contro.openPlaylist();
}

void User::nextDog()
{

	if (this->ok == 0)
	{
		
		this->filter.next();
		//this->contro.nextD();
		Dog d = this->filter.getCurrentDog();
		d.show();
	}
	else
	{

		this->contro.nextDog();
		Dog d = this->contro.getRepo().getCurrentDog();
		d.show();
	}
}




