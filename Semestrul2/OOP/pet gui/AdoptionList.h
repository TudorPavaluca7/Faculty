#pragma once
//#include "DynamicArray.h"
#include "Dog.h"
#include <vector>

class AdoptionList
{
protected:
	std::vector<Dog> dogs;

public:
	AdoptionList();
	//add a dog to the adoption list
	int Add(const Dog& d);
	void update(int index, const Dog& d);
	//find the position of a dog
	int findPos(const std::string& name);
	std::vector<Dog> getDogs() const { return dogs; };
	int getLenght() { return dogs.size(); }
	void readFile();
	void writeFile();
};