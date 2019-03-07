#include "Ui.h"

void UI::menu()
{
	cout << "1.Add a new competitor"<<endl;
	cout << "2.Display the result of first round" << endl;
	cout << "3.See all the competitors which are qualified in the next round" << endl;
	cout << "4.Remove a competitor" << endl;
}

void UI::add()
{
	int k;
	double sc;
	std::string name;
	cout << "give the id";
	cin >> k;
	cout << "give the name";
	cin >> name;
	cout << "give the score";
	cin >> sc;
	Elem e{sc,name};
	SMElem f{ e,k };
	try
	{
		bs.ins(f);
	}
	catch(const char* msg)
	{
		cout << msg<<endl;
	}
}

void UI::dispaly()
{
	int k=0;
	Iterator it = bs.getIterator();
	//bs.display();
	while (k < bs.capacity())
	{
		k++;
		cout << "the id is: " << it.getElem().key << " the name: " << it.getElem().e.name << " the score: " << it.getElem().e.score << endl;
		it.Next();
	}
 
}

void UI::remove()
{
	int k;
	cout << "give the id";
	cin >> k;
	try
	{

		bs.remove(k);
	}
	catch (const char* msg)
	{
		cout << msg << endl;
	}

}

void UI::fRound()
{
	int k = 0;
	Iterator it = bs.getIterator();
	//bs.display();
	while (k<bs.capacity())
	{
		k++;
		//if (it.getElem().getElem().GetScore()<2)
		if (it.getElem().e.score<2)
		  cout << "the id is: " << it.getElem().key << " the name: " << it.getElem().e.name << " the score: " << it.getElem().e.score << endl;
		it.Next();
	}
	
}

void UI::start()
{
	while (true)
	{
		menu();
		int command;
		cout << "please give the comand: ";
		cin >> command;
		if (command == 0)
			break;
		switch (command)
		{
		case 1:
		{
			this->add();
			break;
		}
		case 2:
		{
			this->dispaly();
			break;
		}
		case 3:
		{
			this->fRound();
			//cout << "asd";
			break;
		}
		case 4:
		{
			this->remove();
			break;
		}
		}
	}
}
