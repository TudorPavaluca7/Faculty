#pragma once
#include<iostream>
#include "Node.h"
#include "Elem.h"
#include<string>
#include "iterator.h"
using namespace std;

class BST
{
	//Elem e;
	//Node node;
	Node* root;
	std::string relation;
	
	bool cmp(int a, int b)
	{
		if (relation == "<")
			return a < b;
		else if (relation==">")
		    return a > b;
	}

	//Node* ins(Node* parent, SMElem x, Node* t)
	//{
	//	if (find(t, x.GetKey()) != NULL)
	//		throw "you can not have 2 competitors with the same id";

	//	if (t == NULL)
	//	{
	//		t = new Node;
	//		t->data = x;
	//		//t->getLeft() =NULL;
	//		t->left = NULL;
	//		t->right = NULL;
	//		t->parent = parent;

	//	}
	//	//else if (x.GetKey() < t->data.GetKey())
	//	else if (cmp(x.GetKey(), t->data.GetKey()))
	//		t->left = ins(t, x, t->left);
	//	//else if (x.GetKey()>t->data.GetKey())
	//	else if (!cmp(x.GetKey(), t->data.GetKey()))
	//		t->right = ins(t, x, t->right);
	//	return t;
	//}
	Node* ins(Node* parent, SMElem x, Node* t)
	{
		if (find(t, x.key) != NULL)
			throw "you can not have 2 competitors with the same id";

		if (t == NULL)
		{
			t = new Node;
			t->data = x;
			//t->getLeft() =NULL;
			t->left = NULL;
			t->right = NULL;
			t->parent = parent;

		}
		//else if (x.GetKey() < t->data.GetKey())
		else if (cmp(x.key, t->data.key))
			t->left = ins(t, x, t->left);
		//else if (x.GetKey()>t->data.GetKey())
		else if (!cmp(x.key, t->data.key))
			t->right = ins(t, x, t->right);
		return t;
	}


	Node* findMin(Node* t)
	{
		if (t == NULL)
			return NULL;
		

		else if (t->left == NULL)
			return t;
		else
			return findMin(t->left);
	}

	
	
	//Node* remove(int x, Node* t)
	//{
	//	if (find(t,x) == NULL)
	//		throw "the competitor with this id doesn't exist";
	//	
	//	Node* n;
	//	if (t == NULL)
	//		return NULL;
	//	else if (x < t->data.GetKey())
	//		t->left = remove(x, t->left);
	//	else if (x > t->data.GetKey())
	//		t->right = remove(x, t->right);
	//	/*else if (t->left == NULL && t->right == NULL)
	//	{
	//		delete t;
	//		t = NULL;

	//	}*/
	//	else if (t->left && t->right)
	//	{
	//		n = findMin(t->right);
	//		t->data = n->data;
	//		t->right = remove(t->data.GetKey(), t->right);
	//	}
	//	else
	//	{
	//		n = t;
	//		if (t->left == NULL)
	//			t = t->right;
	//		else if (t->right == NULL)
	//			t = t->left;
	//		delete n;




	//		//delete temp;
	//	}

	//	return t;
	//}
	Node* remove(int x, Node* t)
	{
		if (find(t, x) == NULL)
			throw "the competitor with this id doesn't exist";

		Node* n;
		if (t == NULL)
			return NULL;
		else if (x < t->data.key)
			t->left = remove(x, t->left);
		else if (x > t->data.key)
			t->right = remove(x, t->right);
		/*else if (t->left == NULL && t->right == NULL)
		{
		delete t;
		t = NULL;

		}*/
		else if (t->left && t->right)
		{
			n = findMin(t->right);
			t->data = n->data;
			t->right = remove(t->data.key,t->right);
		}
		else
		{
			n = t;
			if (t->left == NULL)
				t = t->right;
			else if (t->right == NULL)
				t = t->left;
			delete n;
		}
		return t;
	}
	void number(Node* t, int &contor)
	{
		if (t == NULL)
			return;
		contor += 1;
		if (t->left != NULL)
			number(t->left, contor);
		if (t->right != NULL)
			number(t->right, contor);

	}

	/*void inorder(Node* t)
	{
		if (t == NULL)
			return;
		inorder(t->left);
		cout << "Competitor id: " << t->data.GetKey() << " name: " << t->data.getElem().getName() << " score: " << t->data.getElem().GetScore() << endl;
		inorder(t->right);
	}


	void nextRound(Node* t)
	{
		if (t == NULL)
			return;
		nextRound(t->left);
		double w = t->data.getElem().GetScore();
		if (w < 2)
			cout << "Competitor id: " << t->data.GetKey() << " name: " << t->data.getElem().getName() << " score: " << t->data.getElem().GetScore() << endl;
		nextRound(t->right);

	}*/


	Node* find(Node* t, int x)
	{
		if (t == NULL)
			return NULL;
		else if (x < t->data.key)
			return find(t->left, x);
		else if (x > t->data.key)
			return find(t->right, x);
		else
			return t;
	}

public:
	BST()
	{
		root = NULL;
	}
	BST(std::string s) :relation{ s } {  }
	~BST() {}

	void ins(SMElem x)
	{
		root = ins(NULL, x, root);
	}
	void remove(int x)
	{
		root = remove(x, root);
	}

	
	void search(int x)
	{
		root = find(root, x);
	}
	Iterator getIterator() { return Iterator{ root }; }
	void test()
	{
		Elem x{2,"dda" };
		SMElem d{ x,11 };
		assert(ins(NULL,d, root)->data.key==11);
		assert(findMin(root) == NULL);
		//assert(cmp(1, 2) == 1);
	    assert(capacity() == 0);
        assert(find(root,100)==NULL);
		

	}
	int capacity()
	{
		int c = 0;
		number(root, c);
		return c;

	}
	void destroy(Node* t);
};
	


