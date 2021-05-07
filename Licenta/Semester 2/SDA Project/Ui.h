#pragma once
#include "BST.h"
#include "iterator.h"
class UI
{
	BST bs;
public:
	UI(BST B):bs{B}{}
	void menu();
	void add();
	void dispaly();
	void remove();
	void fRound();
	void start();
};