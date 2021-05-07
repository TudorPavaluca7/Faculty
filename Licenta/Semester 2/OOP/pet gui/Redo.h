#pragma once
#include "Repository.h"
class Redo
{
public:
	Redo() {}
	virtual ~Redo() {}
	virtual void executeRedo() = 0;
};
class RedoAdd :public Redo
{
private:
	Dog addedDog;
	Repository &repo;
public:
	RedoAdd(Dog const &addedDog, Repository &repo);
	~RedoAdd();
	void executeRedo() override;
};
class RedoRemove :public Redo
{
private:
	Dog removedDog;
	Repository &repo;
public:
	RedoRemove(Dog const &removedDog, Repository &repo);
	~RedoRemove();
	void executeRedo() override;
};