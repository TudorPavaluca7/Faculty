#pragma once
#include "AdoptionList.h"

class FileAdoption : public AdoptionList
{
protected:
	std::string filename;

public:
	FileAdoption();
	virtual ~FileAdoption() {}

	void setFilename(const std::string& filename);
	virtual void writeToFile() = 0;
	virtual void displayAdopt() const = 0;
};

