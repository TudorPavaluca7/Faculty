#pragma once
#include "Dog.h"
//#include "DynamicArray.h"
#include <vector>
class Repository
{
private:
	std::vector<Dog> dogs;
	int current;
	std::string filename;
public:
	Repository();
	/*
	Default constructu=or.
	Initializes an object of type repository.
	*/

	Repository(const std::string& filename);
	/*
	Adds a dog to the repository.
	Input: d - Dog.
	Output: 1 if the dog was added 0 otherwise
	*/
	void addDog(const Dog& d);

	//find the position of a dog
	int findPos(const std::string& name);

	//remove a dog from repository
	//in:the name
	//out:1 if the dog was removed,0 otherwise
	void del(const std::string& name);

	/*
	Finds a dog, by name.
	Input: name- string
	Output: the dog that was found, or an "empty" dog if nothing was found.
	*/
	/*Dog findByName(const std::string& name);*/

	//update a dog from repository
	//in:the name and the new age
	//out:1 if the dog was updated, 0 otherwise
	void update(const std::string& name, int age);
	void dele(int pos);
	void clr() { dogs.clear(); }
	int len();

	//void fori(int i, const Dog& d);

	//Dog ret(int i);

	Dog getCurrentDog();

	//show a picture with the current dog
	//void showDog();

	//show the next dog 
	void next();

	std::vector<Dog> getDogs() const { return dogs; };
	void readFromFile();
	void writeToFile();
	int cu() { return this->current; }
	void setCurrent() { this->current = 0; }
};
