#pragma once
#include "Repository.h"
#include "AdoptionList.h"
#include "DogValidator.h"
#include "FileAdoption.h"
#include <stack>
#include "Operation.h"
class Controller
{
private:
	Repository repo;
	AdoptionList AL;
	Repository reps;
	Repository r;
	FileAdoption* playList;
	DogValidator val;
	std::stack<Operation> op;
	std::stack<Operation> op2;
	
public:
	//Controller(const Repository& r) : repo{ r } { }
	Controller(const Repository& r, DogValidator validator, FileAdoption* p) :repo{ r }, val{ validator }, playList{ p }, op{}, op2{} {}
	/*{
		this->repo = r;
		this->val = validator;
		this->playList = p;
	}*/
	Repository getRepo() const { return repo; }
	AdoptionList getAdoptionList() const { return AL; }
	//AdoptionList* getAdoptionList() const { return adoption; }
	Repository getReps() const { return reps; }
	// Adds a dog with the given data to the repository.
	void addDogToRepo(const std::string& breed, const std::string& name, int age, const std::string& source, int weight);

	void deleteController(const std::string& name);

	void updateController(const std::string& name, int age);

	int adopt(const Dog& d);


	void showPic();
	void nextDog();

	void nextD();
	Repository filtrare(const std::string& breed, int age);
	Repository filt(int value);
	//Repository sirt(int value);
	bool checkEmpty();
	void savePlaylist(const std::string& filename);
	void openPlaylist() const;
	void Undo();
	void Redo();
	void delGui(int pos);
};
