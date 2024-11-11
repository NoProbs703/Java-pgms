package p1;
public class A{
	public A()
	{
		System.out.println("Constructor of A");
	}
	void display()
	{
		System.out.println("Display A method");
	}
}
package p2;
public class B{
	public B()
	{
		System.out.println("Constructor of B");
	}
	void display()
	{
		System.out.println("Display B method");
	}
}
package p3;
public class C{
	public C()
	{
		System.out.println("Constructor of C");
	}
	void display()
	{
		System.out.println("Display C method");
	}
}
package p4;
public class D{
	public D()
	{
		System.out.println("Constructor of D");
	}
	void display()
	{
		System.out.println("Display D method");
	}
}
package pack;
import p1.A;
import p2.B;
import p3.C;
import p4.D;
class PackTest{
	public static void main(String args[]){
		A.a1 = new A();
		B.b1 = new B();
		C.c1 = new C();
		D.d1 = new D();
		a1.displayA();
		b1.displayB();
		c1.displayC();
		d1.displayD();
	}
}
