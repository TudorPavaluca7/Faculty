#pragma once
#include "Elem.h"
class Node
{
public:
	SMElem data;
	Node* left;
	Node* right;
	Node* parent;
	Node() {

	}
	Node(SMElem d, Node* l, Node* r,Node* p)
	{
		this->data = d;
		this->left = l;
		this->right = r;
		this->parent = p;
	}
	//Elem getElem() { return this->data; }
	//Node* getLeft() { return this->left; }
	//Node* getRight() { return this->right; }
};