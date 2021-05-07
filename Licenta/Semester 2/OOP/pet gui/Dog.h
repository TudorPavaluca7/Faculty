#pragma once
#include <iostream>

class Dog
{
private:
	std::string breed;
	std::string name;
	int age;
	int weight;
	std::string source;
public:
	Dog();

	// constructor with parameters
	Dog(const std::string& breed, const std::string& name,int age,const std::string& source,int weight);

	std::string getBreed() const { return breed; }
	std::string getName() const { return name; }
	int getAge() const { return age; }
	int getWeight() const { return weight; }
	void setBreed(std::string breed);
	void setAge(int varsta);
	void setName(std::string name);
	void setSource(std::string name);
	void setWeight(int weight);
	std::string getSource() const { return source; }
	bool operator<(int value);

	void show();

	friend std::istream& operator>>(std::istream& is, Dog& d);
	friend std::ostream& operator<<(std::ostream& os, const Dog& d);
	std::string toString();

};