package DemoProj;

public class ConstructorDemo 
{
    String name;
    int rollno;    
    ConstructorDemo(String name,int rollno)
    {
    	this.name = name;
    	this.rollno = rollno;
    	
    }
	public static void main(String[] args) 
	{
		ConstructorDemo d = new ConstructorDemo("firoz",102); 
		System.out.println(d.toString());
    }

}
