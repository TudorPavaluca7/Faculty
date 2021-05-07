#include <iostream>
#include <string>
#include <chrono>
#include "ThreadPool.h"
#include "Matrix.h"

void add(Matrix a, Matrix b, Matrix &res)
{
	ThreadPool pool(4);
	std::vector<std::future<int>> f;

	for (int i = 0; i < a.getRowsNumber(); i++)
	{
		f.push_back(pool.enqueue([](int line, Matrix a, Matrix b, Matrix* res) {
			for (int j = 0; j < a.getColsNumber(); j++)
				res->set(line, j, (a.get(line, j) + b.get(line, j)));
			return line;
		}, i, a, b, res));
	}



}

int main()
{
	Matrix a = Matrix(5, 5);
	Matrix b = Matrix(5, 5);
	Matrix res = Matrix(5, 5);

	std::cout << "Matrix a: \n";
	std::cout << a.printMatrix();

	std::cout << "\nMatrix b: \n";
	std::cout << b.printMatrix();

	auto start = std::chrono::high_resolution_clock::now();
	system("pause");

}