#pragma once
#include "BST.h"
class Controller
{
	Node* root;
	BST bs;
public:
	Controller()
	{
		root = NULL;
	}
	~Controller()
	{
		root = bs.empty(root);
	}
	void in


};