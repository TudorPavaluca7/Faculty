#include "petgui.h"
#include <QtWidgets/QApplication>
#include "admin.h"
#include "user.h"
#include "mode.h"
#include "DogValidator.h"
#include "CSVPlaylist.h"
#include "FileHtml.h"
#include "ch.h"
#include "View.h"
#include "AdoptionList.h"
#include "n.h"
int main(int argc, char *argv[])
{
	QApplication a(argc, argv);
	petgui w;
	Repository repo{"catei.txt"};
	FileAdoption* p = new HTMLPlaylist{};
	FileAdoption* cs = new CSVPlaylist{};
	Controller c{ repo,DogValidator{},p};
	Controller c1{ repo,DogValidator{},cs};
	User us(c);
	User us1(c1);
	Ch ch{ us1,us };
	Admin ad(c,repo);
	AdoptionList adoption;
	View v(adoption);
	//Password ps(ad);
	Mode m{v,ad,ch };
	//us.show();
	m.show();
	//N n;
	//n.show();
	return a.exec();
	delete p, cs;
}
