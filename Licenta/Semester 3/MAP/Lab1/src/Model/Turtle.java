package Model;

public class Turtle implements MyObjects{
    private double age;
    public Turtle(double ag)
    {
        this.age=ag;
    }
    public double getAge()
    {
        return this.age;
    }
    public void setAge(int age)
    {
        this.age=age;
    }
    public String toString()
    {
        return "this turtle is: " + this.age + " years old";
    }
}
