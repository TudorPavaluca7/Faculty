#include "Controller.h"
#include <algorithm>
#include <iterator>
void Controller::addDogToRepo(const std::string& breed, const std::string& name, int age, const std::string& source, int weight)
{
	Dog d{ breed,name,age,source,weight };
	this->val.validate(d);
	this->repo.addDog(d);
	Operation o{ "add",d };
	this->op.push(o);
}
void Controller::deleteController(const std::string& name)
{
	/*int i = this->repo.findPos(name);
	Dog d = this->repo.getDogs().at(i);
	Operation o{ "remove",d };
	this->op.push(o);*/
	this->repo.del(name);

}

void Controller::updateController(const std::string& name, int age)
{
	int i = this->repo.findPos(name);
	Dog d = this->repo.getDogs().at(i);
	Operation o{ "update",d };
	this->op.push(o);
	this->repo.update(name, age);

}

int Controller::adopt(const Dog& d)
{
	int res1 = this->AL.Add(d);
	int res = this->playList->Add(d);
	return res1;
}


//void Controller::showPic()
//{
//	this->repo.showDog();
//}

void Controller::nextDog()
{
	this->repo.next();
}
void Controller::nextD()
{
	this->reps.next();
}

Repository Controller::filtrare(const std::string& breed, int age)
{
	std::vector<Dog> dogs = this->getRepo().getDogs();
	size_t filterdogs = std::count_if(dogs.begin(), dogs.end(), [breed, age](Dog d) {return d.getBreed() == breed && d.getAge() < age; });
	std::vector<Dog> result{ filterdogs };
	std::copy_if(dogs.begin(), dogs.end(), result.begin(), [breed, age](Dog d) {return d.getBreed() == breed && d.getAge() < age; });
	/*for (auto it = result.begin(); it != result.end(); it++)
	this->reps.addDog(*it);*/
	for (auto it : result)
		this->reps.addDog(it);
	return this->reps;

}
Repository Controller::filt(int value)
{
	std::vector<Dog> dogs = this->getRepo().getDogs();
	size_t filterdogs = std::count_if(dogs.begin(), dogs.end(), [value](Dog d) {return d < value; });
	std::vector<Dog> result{ filterdogs };
	std::copy_if(dogs.begin(), dogs.end(), result.begin(), [value](Dog d) {return d<value; });
	for (auto it : result)
		this->r.addDog(it);

	return this->r;


}
//Repository Controller::sirt(int value)
//{
//	Repository r;
//		r = this->filt(value);
//		Dog e;
//	for (int i = 0; i < r.getDogs().getSize() - 1; i++)
//	{
//		
//		for (int j = i + 1; j<r.getDogs().getSize(); j++)
//		{
//			Dog d = r.ret(i);
//			Dog d1 = r.ret(j);
//			if (d.getWeight() > d1.getWeight())
//			{
//				e = d;
//				r.fori(i, d1);
//				r.fori(j, e);
//			}
//
//		}
//	}
//	//rip.getDogs().getAllElems() = dogs;
//	return r;
//}


bool Controller::checkEmpty()
{
	return this->reps.getDogs().size() == 0;
}
void Controller::savePlaylist(const std::string& filename)
{
	if (this->playList == nullptr)
		return;

	this->playList->setFilename(filename);
	this->playList->writeToFile();
}

void Controller::openPlaylist() const
{
	if (this->playList == nullptr)
		return;

	this->playList->displayAdopt();
}

void Controller::Undo()
{
	if (this->op.size() == 0)
		throw "you can't undo anymore";
	
	
	if (this->op.top().getType() == "add")
	{
		Operation o{ "add",this->op.top().getDog() };
		this->op2.push(o);
		this->repo.del(this->op.top().getDog().getName());
	}
	else
		if (this->op.top().getType() == "remove")
		{
			Operation o{ "remove",this->op.top().getDog() };
			this->op2.push(o);
			this->repo.addDog((this->op.top().getDog()));
		}
		else
			if (this->op.top().getType() == "update")
			{
				
				int i = this->repo.findPos(this->op.top().getDog().getName());
				Dog d = this->repo.getDogs().at(i);
				Operation o{ "update",d};
				this->op2.push(o);
                
				this->repo.update(this->op.top().getDog().getName(), this->op.top().getDog().getAge());
			
			}
	this->op.pop();
}

void Controller::Redo()
{
	if (this->op2.size() == 0)
		throw "No more redos to be made.";
	if (this->op2.top().getType() == "add")
	{
		
		this->repo.addDog((this->op2.top().getDog()));
	}
	else
		if (this->op2.top().getType() == "remove")
		{
			this->repo.del(this->op2.top().getDog().getName());
			
		}
		else
			if (this->op2.top().getType() == "update")
			{

				

				this->repo.update(this->op2.top().getDog().getName(), this->op2.top().getDog().getAge());

			}
	this->op2.pop();





}


void Controller::delGui(int pos)
{
	//int i = this->repo.findPos(name);
	Dog d = this->repo.getDogs().at(pos);
	Operation o{ "remove",d };
	this->op.push(o);
	
	this->repo.dele(pos);
	
}
