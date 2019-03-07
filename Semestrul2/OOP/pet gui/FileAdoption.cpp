#include "FileAdoption.h"



FileAdoption::FileAdoption() : AdoptionList{}, filename{ "" }
{
}

void FileAdoption::setFilename(const std::string& filename)
{
	this->filename = filename;
}