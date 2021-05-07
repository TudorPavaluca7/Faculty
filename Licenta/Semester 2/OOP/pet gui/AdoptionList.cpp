#include "AdoptionList.h"
#include <fstream>
using namespace std;
AdoptionList::AdoptionList()
{
	this->readFile();
}
int AdoptionList::Add(const Dog& d)
{
	int i = findPos(d.getName());
	if (i == -1)
	{
		this->dogs.push_back(d);
		this->writeFile();
	}
	else
		return 0;
	return 1;
}

void AdoptionList::update(int index, const Dog & d)
{
	if (index < 0 || index >= this->dogs.size())
		return;

	this->dogs.erase(this->dogs.begin() + index);
	this->dogs.insert(this->dogs.begin() + index, d);
	this->writeFile();

}

int AdoptionList::findPos(const std::string& name)
{
	int k = 0;
	for (auto i : this->dogs)
	{
		if (i.getName() == name)
			return k;
		k++;
	}
	return -1;

}

void AdoptionList::readFile()
{
	ifstream file("adoption.txt");

	/*if (!file.is_open())
	throw FileException("The file could not be opened!");
	*/
	Dog d;
	while (file >> d)
		this->dogs.push_back(d);

	file.close();



}

void AdoptionList::writeFile()
{
	ofstream file("adoption.txt");
	/*if (!file.is_open())
	throw FileException("The file could not be opened!");*/

	for (auto d : this->dogs)
	{
		file << d;
	}

	file.close();


}


