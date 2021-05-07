#pragma once
#include "Node.h"

#include <assert.h>
class Iterator
{
	Node* root=NULL;
public:
	Iterator(Node* root) :root{ root }  { Deep(root->left); }
	//goLeft(Node* t);
	bool isValid();
	bool Deep(Node* n);
	SMElem getElem() { return root->data; }
	void Next();
	void tests();
};