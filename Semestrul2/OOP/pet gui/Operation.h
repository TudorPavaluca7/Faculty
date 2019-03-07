#pragma once
#include "Repository.h"
class Operation
{
	std::string type;;
	Dog d;
public:
	Operation(std::string name, Dog dog) :type{ name }, d{ dog }{}
	std::string getType() { return this->type; }
	Dog getDog() { return this->d; }
};