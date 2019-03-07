#pragma once
#include "FileAdoption.h"
#include <string>

class HTMLPlaylist : public FileAdoption
{
public:
	/*
	Writes the playlist to file.
	Throws: FileException - if it cannot write.
	*/
	void writeToFile() override;


	void displayAdopt() const override;
};