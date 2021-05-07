#include "Elem.h"

Elem::Elem(double sc,std::string n)
{
	//this->id = i;
	this->score = sc;
	this->name = n;
}

Elem::~Elem()
{


}

//void Elem::Tests()
//{
//	Elem e{ 2.0,"asd" };
//	assert(e.GetId() == 1);
//	assert(e.getName() == "asd");
//	assert(e.GetScore() == 2.0);
//}

SMElem::SMElem(Elem el, int k)
{
	this->e = el;
	this->key = k;
}

//void SMElem::Tests()
//{
//	Elem e{ 2.0,"asd" };
//	SMElem s{ e,1 };
//	assert(s.GetKey() == 1);
//	assert(s.getElem().getName() == "asd");
//}
