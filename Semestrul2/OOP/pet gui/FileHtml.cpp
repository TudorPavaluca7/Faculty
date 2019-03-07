#include "FileHtml.h"
#include <fstream>
#include <Windows.h>
#include "RepositoryExceptions.h"

using namespace std;
void HTMLPlaylist::writeToFile()
{
	std::ofstream file(this->filename);
	if (!file.is_open())
		throw FileException("Error opening file for write!");
	file << "<!DOCTYPE html> \n <html> \n \t<head> \n \t\t <title>AdoptionList</title> \n";
	file << "\t</head> \n \t<body> \n \t\t<table border=\"1\"> \n \t\t<tr>\n";
	file << "\t\t\t<td>Breed</td> \n \t\t\t<td>Name</td> \n \t\t\t<td>Age</td> \n \t\t\t <td>Weight</td>\n";
	file << "\t\t\t<td>Link to photo</td> \n \t\t </tr>\n";
	for (auto dog : this->dogs)
	{
		file << "\t\t<tr>\n";
		file << "\t\t\t<td>" << dog.getBreed() << "</td>\n";
		file << "\t\t\t<td>" << dog.getName() << "</td>\n";
		file << "\t\t\t<td>" << dog.getAge() << "</td>\n";
		file << "\t\t\t<td>" << dog.getWeight() << "</td>\n";
		file << "\t\t\t<td><a href=" << dog.getSource() << ">Link</td>\n";
		file << "\t\t</tr>\n";
	}
	file << "\t\t</table>\n";
	file << "\t</body>\n";
	file << "</html>\n";
	file.close();
}



void HTMLPlaylist::displayAdopt() const
{
	ShellExecuteA(NULL, NULL, "chrome.exe", this->filename.c_str(), NULL, SW_SHOWMAXIMIZED);
}
