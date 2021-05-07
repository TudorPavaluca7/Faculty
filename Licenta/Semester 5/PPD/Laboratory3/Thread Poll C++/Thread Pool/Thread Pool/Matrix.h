#pragma once
#include <vector>

class Matrix
{
private:
	std::vector<std::vector<int>> content;
	int rows, cols;

public:
	Matrix();

	Matrix(int rows, int cols);
	
		
	

	std::string printMatrix();

	int index(int row, int col);
	void set(int row, int col, int value);
	int get(int row, int col);
	int getRowsNumber();
	int getColsNumber();

	~Matrix();
};