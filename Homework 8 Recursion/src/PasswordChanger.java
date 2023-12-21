
public class PasswordChanger implements PWCInterface {
	


	@Override
	public boolean containsDigit(String password) {
		// TODO Auto-generated method stub
		if (password.length() == 0) {
	    	return false;
	    }
		if (Character.isDigit(password.charAt(0))){ 
			return true;
		}
		
	
		return (containsDigit(password.substring(1)));
		
	}

	@Override
	public boolean equalsOld(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		if (oldPassword.length() == 0 && newPassword.length() == 0) {
	    	return true;
		}
		if (oldPassword.charAt(0) == newPassword.charAt(0)) {
			return equalsOld(oldPassword.substring(1),newPassword.substring(1)) ;
		}
		
		return false;
	}

	@Override
	public boolean reverseOfOld(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		if (oldPassword.equals("")&& newPassword.equals("")) {
	    	return true;
		}
		if ((oldPassword.charAt(0)) == (newPassword.charAt(newPassword.length()-1))) {
			return reverseOfOld(oldPassword.substring(1,oldPassword.length()),newPassword.substring(0,newPassword.length()-1)) ;
		}
		
		return false;
	}

	

	@Override
	public int numberDifferences(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
		
		if (oldPassword.length() == 0 &&  newPassword.length() == 0) {
			return 0;
		}
		if (oldPassword.length() == 0 &&  newPassword.length() != 0) {
			return 1 + numberDifferences(oldPassword,newPassword.substring(1,newPassword.length()));
		}

		if (oldPassword.length() != 0 &&  newPassword.length() == 0) {
				
			return 1+ numberDifferences(oldPassword.substring(1),newPassword);
		}
		
		if (oldPassword.charAt(0) != newPassword.charAt(0)) {
			
			return 1 + numberDifferences(oldPassword.substring(1, oldPassword.length()),newPassword.substring(1,newPassword.length()));
		}
		return numberDifferences(oldPassword.substring(1, oldPassword.length()),newPassword.substring(1,newPassword.length()));
	}

	@Override
	public boolean differentEnough(String oldPassword, String newPassword, int quality) {
		// TODO Auto-generated method stub
		
		int counter = numberDifferences(oldPassword, newPassword);
		
		if (counter >= quality) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean validPasswordChange(String oldPassword, String newPassword) {
		int quality = newPassword.length()/2;
		if(containsDigit(newPassword) == true && equalsOld(oldPassword, newPassword) == false && reverseOfOld(oldPassword, newPassword) == false 
				&& differentEnough(oldPassword, newPassword, quality) == true) {
			return true;
		}
		
		return false;
	}

	
	

public static void main(String[] args) {
	// TODO Auto-generated method stub
	PasswordChanger p1 = new PasswordChanger();
	String newPassword = new String ("abc2021def");
	String oldPassword = new String ("fed1202cba");
	String thirdPassword = new String("aasddfgh123");
	String fourthPassword = new String("abc2021def");
	
	System.out.println(p1.containsDigit(newPassword));
	System.out.println(p1.containsDigit(oldPassword));
	
	
	System.out.println(p1.equalsOld(oldPassword,newPassword));
	System.out.println(p1.equalsOld(newPassword,fourthPassword));
	
	System.out.println(p1.reverseOfOld(oldPassword,newPassword));
	System.out.println(p1.reverseOfOld(thirdPassword,newPassword));
	
	System.out.println(p1.numberDifferences(newPassword, thirdPassword));
	System.out.println(p1.numberDifferences(newPassword, fourthPassword));

	System.out.println(p1.differentEnough(oldPassword, newPassword, 4));
	System.out.println(p1.differentEnough(newPassword, fourthPassword,9));
	
	System.out.println(p1.validPasswordChange(oldPassword, newPassword));
	System.out.println(p1.validPasswordChange(newPassword, thirdPassword));

	
}
}


