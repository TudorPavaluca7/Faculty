#include "Undo.h"

std::string Undo::getType()
{
	return this->type;
}

UndoAdd::UndoAdd(Dog const & dog, Repository & re, std::string ty):Undo(ty),addedDog{dog},repo{re}
{

}

UndoAdd::~UndoAdd()
{
}

void UndoAdd::executeUndo()
{
	this->repo.del(this->addedDog.getName());
}

UndoRemove::UndoRemove(Dog const& dog, Repository & re, std::string ty) :Undo(ty), removedDog{ dog }, repo{ re }
{
}

UndoRemove::~UndoRemove()
{
}

void UndoRemove::executeUndo()
{
	this->repo.addDog(this->removedDog);
}
