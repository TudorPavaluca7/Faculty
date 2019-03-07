#pragma once
#include "FileAdoption.h"
#include <string>

class CSVPlaylist : public FileAdoption
{
public:
	/*
	Writes the playlist to file.
	Throws: FileException - if it cannot write.
	*/
	void writeToFile() override;

	/*
	Displays the playlist using Microsof Excel.
	*/
	void displayAdopt() const override;
};

