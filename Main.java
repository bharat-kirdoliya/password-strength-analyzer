import java.util.* ;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		Scanner input =  new Scanner(System.in);
		PassAnalyser a1 = new PassAnalyser();

		while(true){
			System.out.println(" Enter the Password to Check Strenght : ");
			String password = input.nextLine(); 
			if(a1.CheckPassword(password)){
				System.out.println("Strong Password Accepted");
	                break;
			}
		}
	}
}

class PassAnalyser{
	boolean CheckPassword(String password) throws Exception{
		int count = 0;
		File file = new File("commonpasswords.txt");
		Scanner sc = new Scanner(file);

        while(sc.hasNextLine()) {
            String common = sc.nextLine();
        	if(password.equals(common)) {
                sc.close();
                System.out.println(" It is a Common Password ");
                return false ;
            }
           
        }

		if(password.length() >= 8 &&
		 password.matches(".*[A-Z].*") &&
		 password.matches(".*[a-z].*") &&
		 password.matches(".*[!@#$%^&*()].*")){

			return true ;
		}
		else
			System.out.println(" Include both Capital and Small Letters and  symbols like  \"!@#$%^&*\" ");
			return false;
	
	}
}