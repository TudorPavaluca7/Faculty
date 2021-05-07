#include "iterator.h"

bool Iterator::isValid()
{
	return root!= NULL;
}

bool Iterator::Deep(Node * n)
{
	if (n == NULL)
		return false;
	if (!Deep(n->left))
		root = n;
	return true;
}

void Iterator::Next()
{   
	if (!Deep(root->right))
		if (root->parent != NULL)
		{
			while (root->parent != NULL && root == root->parent->right)
				root = root->parent;
			root = root->parent;
		}
}

void Iterator::tests()
{
	assert(isValid() == 1);
	
}

