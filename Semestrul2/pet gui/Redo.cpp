#include "Redo.h"

RedoAdd::RedoAdd(Dog const &dog, Repository & re):addedDog{dog},repo{re}
{

}

RedoAdd::~RedoAdd()
{
}

void RedoAdd::executeRedo()
{
	this->repo.addDog(this->addedDog);
}

RedoRemove::RedoRemove(Dog const & dog, Repository & re):removedDog{dog},repo{re}
{
}

RedoRemove::~RedoRemove()
{
}

void RedoRemove::executeRedo()
{
	this->repo.del(this->removedDog.getName());
}
