package Repo;

import Model.MyObjects;

public class RepoC implements RepoI {
    public int pos;
    MyObjects a[];
    public RepoC(int size){
        a=new MyObjects[size];
        this.pos=0;
    }
    public void add(MyObjects obj) throws IndexOutOfBoundsException{
        if (this.pos>=a.length)
            throw new IndexOutOfBoundsException();
        a[pos]=obj;
        pos++;
    }
    public void delete(int index)  throws IndexOutOfBoundsException{
        if (index<0 || this.pos<index)
            throw new IndexOutOfBoundsException();
        for(int i=index;i<this.pos;i++)
            a[i]=a[i+1];
        this.pos=this.pos-1;
    }
    public MyObjects[] getAll(){
        return this.a;
    }

    public int currentPos()
    {
        return this.pos;
    }
    public String moreThan(){
        String st;
        st="";
        MyObjects obj[];
        obj=this.a;
        //for(MyObjects obj:repo.getAll())
        for(int i=0;i<this.pos;i++)

            if(obj[i].getAge()>1)
                //System.out.print(obj[i]);
                st=st.concat(obj[i].toString()+"\n");

        return st;


    }
}
