#pragma once
#include <string>
#include <assert.h>
class Elem
{
public:
	//int id;
	std::string name;
	double score;

	Elem(){}
	Elem(double sc,std::string n);
	~Elem();
	//std::string getName() { return this->name; }
	//int GetId() { return this->id; }
	//double GetScore() { return this->score; }
	//void Tests();
};
class SMElem
{
public:
	Elem e;
	int key;
	//std::string relation;
     SMElem(){}
	SMElem(Elem el, int k);
	//Elem getElem() { return this->e; }
	//int GetKey() { return this->key; }
	//std::string getRel() { return this->relation; }
	//void Tests();
};