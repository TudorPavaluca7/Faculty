#include "DogValidator.h"

using namespace std;

DogException::DogException(std::vector<std::string> _errors) : errors{ _errors }
{
}

std::vector<std::string> DogException::getErrors() const
{
	return this->errors;
}

void DogValidator::validate(const Dog & d)
{
	vector<string> errors;
	if (d.getBreed().size() < 3)
		errors.push_back("The breed name cannot be less than 2 characters!\n");
	if (!isupper(d.getName()[0]))
		errors.push_back(string("The name of the dog must start with a capital letter!\n"));
	if (d.getAge() <= 0)
		errors.push_back(string("The dog cannot be 0 or less!\n"));
	if (d.getWeight() <= 0)
		errors.push_back(string("The dog cannot be 0 or less!\n"));
	// search for "www" or "http" at the beginning of the source string
	size_t posWww = d.getSource().find("www");
	size_t posHttp = d.getSource().find("http");
	if (posWww != 0 && posHttp != 0)
		errors.push_back("The browser source must start with one of the following strings: \"www\" or \"http\"");

	if (errors.size() > 0)
		throw DogException(errors);
}
