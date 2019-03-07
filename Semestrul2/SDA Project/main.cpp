#include "Ui.h"
int main()
{
	BST b(">");
	Elem e{1.50,"marius" };
	//e.Tests();
	//b.getIterator().tests();
	Elem e1{1.51,"alin" };
	Elem e2(2.02, "darius");
	Elem e3(1.48, "dani");
	Elem e4(2.06, "mihai");
	Elem e5(2.07, "mihaita");
	Elem e6(2.01, "george");
	Elem e7(1.56, "andrei");
	//Elem e8(1.55, "tudor");
	SMElem s1(e,5);
	//s1.Tests();
	SMElem s2(e1, 1);
	SMElem s3(e2, 2);
	SMElem s4(e3, 8);
	SMElem s5(e4, 7);
	SMElem s6(e5, 9);
	SMElem s7(e6, 6);
	SMElem s8(e7, 0);
	b.test();
	b.ins(s1);
	b.ins(s2);
	b.ins(s3);
	b.ins(s4);
	b.ins(s5);
	b.ins(s6);
	b.ins(s7);
	b.ins(s8);
	//b.display();
	//b.ins(s8);
    UI U(b);
    U.start();
    system("pause");
}