#pragma once
#include "Repository.h"
class Undo
{
protected:
	std::string type;
public:
	Undo(std::string ty):type{ty} {}
	virtual ~Undo(){}
	virtual void executeUndo() = 0;
	virtual Dog &getDog() = 0;
	std::string getType();

};
class UndoAdd :public Undo
{
private:
	Dog addedDog;
	Repository &repo;
public:
	UndoAdd(Dog const &addedDog, Repository &repo, std::string ty);
	~UndoAdd();
	void executeUndo() override;
	Dog &getDog() override { return this->addedDog; }
};
class UndoRemove :public Undo
{
private:
	Dog removedDog;
	Repository &repo;
public:
	UndoRemove(Dog const &removedDog, Repository &repo, std::string ty);
	~UndoRemove();
	void executeUndo() override;
	//Dog getDog() override {return this->removedDog; }

};