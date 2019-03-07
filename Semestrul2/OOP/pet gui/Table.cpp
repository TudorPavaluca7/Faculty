#include "Table.h"
#include <QFont>
#include <QBrush>
Table::Table(AdoptionList& a, QObject * parent) : QAbstractTableModel{ parent }, adop{ a }
{

}

Table::~Table()
{
}

int Table::rowCount(const QModelIndex & parent) const
{
	int Number = this->adop.getLenght();
	
	return Number+1;
}

int Table::columnCount(const QModelIndex & parent) const
{
	return 5;
}

QVariant Table::data(const QModelIndex & index, int role) const
{
	int row = index.row();
	int column = index.column();

	// get the genes
	std::vector<Dog> dogs = this->adop.getDogs();

	// Allow adding in the table
	// this is to show an empty row at the end of the table - to allow adding new genes
	if (row == dogs.size())
	{
		return QVariant();
	}

	// get the gene from the current row
	Dog g = dogs[row];

	if (role == Qt::DisplayRole || role == Qt::EditRole)
	{
		switch (column)
		{
		case 0:
			return QString::fromStdString(g.getBreed());
		case 1:
			return QString::fromStdString(g.getName());
		case 2:
			return QString::fromStdString(std::to_string(g.getAge()));
		case 3:
			return QString::fromStdString(g.getSource());
		case 4:
			return QString::fromStdString(std::to_string(g.getWeight()));
		default:
			break;
		}
	}
	if (role == Qt::FontRole)
	{
		QFont font("Times", 10, 10, true);
		font.setItalic(false);
		return font;
	}
	if (role == Qt::BackgroundRole)
	{
		if (row % 2 == 1)
		{
			return QBrush{ QColor{ 0, 250, 154 } };
		}
	}

	return QVariant{};
}

QVariant Table::headerData(int section, Qt::Orientation orientation, int role) const
{
	if (role == Qt::DisplayRole)
	{
		if (orientation == Qt::Horizontal)
		{
			switch (section)
			{
			case 0:
				return QString{ "Dog breed" };
			case 1:
				return QString{ "Dog name" };
			case 2:
				return QString{ "Dog age" };
			case 3:
				return QString{ "Dog source" };
			case 4:
				return QString{ "Dog weight" };
			default:
				break;
			}
		}
	}
	if (role == Qt::FontRole)
	{
		QFont font("Times", 10, 10, true);
		font.setBold(true);
		font.setItalic(false);
		return font;
	}

	return QVariant{};

}

bool Table::setData(const QModelIndex & index, const QVariant & value, int role)
{
	if (!index.isValid() || role != Qt::EditRole)
		return false;

	// set the new data to the gene
	int dogIndex = index.row();

	// get the genes
	std::vector<Dog> dogs = this->adop.getDogs();

	// Allow adding in the table
	//if the index is >= number of genes => a new gene is added
	if (dogIndex == dogs.size())
	{
		this->beginInsertRows(QModelIndex{}, dogIndex, dogIndex);

		switch (index.column())
		{
		case 0:
			this->adop.Add(Dog{ value.toString().toStdString(), "", {} ," ",{} });
			break;
		case 1:
			this->adop.Add(Dog{ "", value.toString().toStdString(), {}," ",{} });
			break;
		case 2:
			this->adop.Add(Dog{ "", "",stoi(value.toString().toStdString())," ",{} });
			break;
		case 3:
			this->adop.Add(Dog{ " "," ",{},value.toString().toStdString(),{} });
			break;
		case 4:
			this->adop.Add(Dog{ " "," ",{},"",stoi(value.toString().toStdString())});
            break;
		}

		this->endInsertRows();
		return true;
	}

	Dog currentDog = dogs[dogIndex];
	switch (index.column())
	{
	case 0:
		currentDog.setName(value.toString().toStdString());
		break;
	case 1:
		currentDog.setName(value.toString().toStdString());
		break;
	case 2:
		currentDog.setAge(stoi(value.toString().toStdString()));
	case 3:
		currentDog.setSource(value.toString().toStdString());
	case 4:
		currentDog.setWeight(stoi(value.toString().toStdString()));

	}
	this->adop.update(dogIndex, currentDog);

	// emit the dataChanged signal
	emit dataChanged(index, index);

	return true;
}

Qt::ItemFlags Table::flags(const QModelIndex & index) const
{
	return Qt::ItemIsSelectable | Qt::ItemIsEditable | Qt::ItemIsEnabled;
}
