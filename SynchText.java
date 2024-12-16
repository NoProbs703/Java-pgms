class A extends Thread{
	public void run(){
		for(int i=1;i<=5;i++){
			if (i==1) yield();
			System.out.println("\t From Thread A: i= " + i);
		}
	System.out.println("Exiting from A");
	}
}
class B extends Thread{
	public void run(){
		for(int j=1;j<=5;j++){
			System.out.println("\t From Thread B: j= " + j);
			if (j==3) stop();
		}
	System.out.println("Exiting from B");
	}
}
class C extends Thread{
	public void run(){
		for(int k=1;k<=5;k++){
			System.out.println("\t From Thread C: k= " + k);
			if (k==1){
				try{
					sleep(1000);
			}
			catch (Exception e){
				System.out.println("After exception " + e);
			}
		}
	System.out.println("Exiting from C");
	}
}
class SynchTest{
    public static void main(String[] args) {
        A threadA = new A();
        B threadB = new B();
        C threadC = new C();

        threadA.start();
        threadB.start();
        threadC.start();
    }
}