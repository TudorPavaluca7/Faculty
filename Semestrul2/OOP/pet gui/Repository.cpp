#include "Repository.h"
#include <string>
#include <fstream>
#include "Utils.h"
#include "RepositoryExceptions.h"
//#include <algorithm>
using namespace std;

Repository::Repository()
{
	int current = 0;
	std::string filename = "";

}


Repository::Repository(const std::string& filename)
{
	this->current = 0;
	this->filename = filename;
	this->readFromFile();
}


void Repository::addDog(const Dog& d)
{
	int i = findPos(d.getName());
	if (i == -1)
	{
		this->dogs.push_back(d);
		this->writeToFile();
	}
	//this->dogs=this->dogs+d;
	else
		throw DuplicateDogException();
}

//Dog Repository::ret(int i)
//{
//	return this->getDogs().getElem(i);
//
//
//}


//void Repository::fori (int i, const Dog& d)
//{
//	this->dogs.fors(i, d);
//}
//Dog Repository::findByName(const std::string& name)
//{
//	if (findPos(name) != -1)
//	{
//		Dog dog = this->dogs.getElem(findPos(name));
//	}
//	else
//
//		return Dog{};
//}

//int Repository::findPos(const std::string& name)
//{
//
//	//Dog* dogsInDynamicVector = this->dogs.getAllElems();
//	for (int i = 0; i < this->dogs.size(); i++)
//	{
//		Dog d = dogs[i];
//		if (d.getName() == name)
//	       return i;
//	}
//	return -1;
//
//
//}



int Repository::findPos(const std::string& name)
{
	//for_each(this->dogs.begin(), this->dogs.end(), [this, name](Dog d) { if (d.getName()== name) return ;  });
	int k = 0;
	for (auto i : this->dogs)
	{
		if (i.getName() == name)
			return k;
		k++;
	}
	return -1;


}

void Repository::del(const std::string& name)
{
	int i = findPos(name);
	if (i == -1)
		throw NoDogException();
	this->dogs.erase(this->dogs.begin() + i);
	this->writeToFile();
}
void Repository::update(const std::string& name, int age)
{
	int i = findPos(name);
	if (i == -1)
		throw NoDogException();
	//Dog* dogsInDynamicVector = this->dogs.getAllElems();
	dogs[i].setAge(age);
	this->writeToFile();
}
void Repository::dele(int pos)
{
	if (pos < 0 || pos >= this->len())
		return;
	
	this->dogs.erase(this->dogs.begin() + pos);
	this->writeToFile();


}
int Repository::len()
{
	return this->dogs.size();

}

Dog Repository::getCurrentDog()
{
	if (this->current == this->dogs.size())
		this->current = 0;
	//Dog* dogsInDynamicVector = this->dogs.getAllElems();
	return dogs[this->current];
	/*Dog d = dogsInDynamicVector[this->current];
	return d;*/
}


//void Repository::showDog()
//{
//	if (this->dogs.getSize() == 0)
//		return;
//	this->current = 0;
//	Dog currentDog = this->getCurrentDog();
//	currentDog.show();
//}

void Repository::next()
{
	if (this->dogs.size() == 0)
		return;
	this->current++;
	Dog currentDog = this->getCurrentDog();
	//currentDog.show();
}
void Repository::readFromFile()
{
	ifstream file(this->filename);

	/*if (!file.is_open())
	throw FileException("The file could not be opened!");
	*/
	Dog d;
	while (file >> d)
		this->dogs.push_back(d);

	file.close();
}

void Repository::writeToFile()
{
	ofstream file(this->filename);
	/*if (!file.is_open())
	throw FileException("The file could not be opened!");*/

	for (auto d : this->dogs)
	{
		
		file << d;
	}

	file.close();
}