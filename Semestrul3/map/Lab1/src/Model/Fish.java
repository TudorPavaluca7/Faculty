package Model;

public class Fish implements MyObjects {
    private double age;
    public Fish(double ag)
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
        return  "this fish is: " + this.age + " years old";
    }
}
