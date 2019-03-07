#pragma once
#include <QAbstractTableModel>
#include "AdoptionList.h"
class Table :public QAbstractTableModel
{
	AdoptionList& adop;
public:
	Table(AdoptionList& a, QObject* parent = NULL);
	~Table();
	int rowCount(const QModelIndex &parent = QModelIndex{}) const override;
	int columnCount(const QModelIndex &parent = QModelIndex{}) const override;
	QVariant data(const QModelIndex &index, int role = Qt::DisplayRole) const override;

	// add header data
	QVariant headerData(int section, Qt::Orientation orientation, int role = Qt::DisplayRole) const override;

	// will be called when a cell is edited
	bool setData(const QModelIndex & index, const QVariant & value, int role = Qt::EditRole) override;

	// used to set certain properties of a cell
	Qt::ItemFlags flags(const QModelIndex & index) const override;
};