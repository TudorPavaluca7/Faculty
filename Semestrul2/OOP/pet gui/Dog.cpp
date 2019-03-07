#include "Dog.h"
#include <Windows.h>
#include <shellapi.h>
#include "Utils.h"
#include <iostream>
#include <vector>
#include <sstream>
#include <string>
using namespace std;
//Dog::Dog() : breed(""), name(""), age(), source("") {}
Dog::Dog()
{
	breed = "";
	name = "";
	age = 0;
	source = "";


}


Dog::Dog(const std::string& breed, const std::string& name, int age, const std::string& source, int weight)
{
	this->breed = breed;
	this->name = name;
	this->age = age;
	this->weight = weight;
	this->source = source;
}
void Dog::setBreed(std::string breed)
{
	this->breed = breed;
}
void Dog::setAge(int varsta)
{
	this->age = varsta;
}
void Dog::setName(std::string name)
{
	this->name = name;
}
void Dog::setSource(std::string name)
{
	this->source = source;
}
void Dog::setWeight(int weight)
{
	this->weight = weight;
}
bool Dog::operator<(int value)
{
	return this->weight < value;
}
void Dog::show()
{
	ShellExecuteA(NULL,NULL,"chrome.exe", this->getSource().c_str(), NULL, SW_SHOWMAXIMIZED);
}
std::string Dog::toString()
{
	stringstream buff;
	buff<< this->breed << "," << this->name << "," << this->age << "," << this->source << "," << this->weight;
	return buff.str();
}
istream & operator>>(istream & is, Dog & d)
{
	string line;
	getline(is, line);

	vector<string> tokens = tokenize(line, ',');
	if (tokens.size() != 5) // make sure all the song data was valid
		return is;

	d.breed = tokens[0];
	d.name = tokens[1];
	d.age = stod(tokens[2]);
	d.source = tokens[3];
	d.weight = stod(tokens[4]);
	return is;

}

ostream & operator<<(ostream & os, const Dog & d)
{
	os << d.breed << "," << d.name << "," << d.age << "," << d.source << "," << d.weight << endl;
	return os;
}
