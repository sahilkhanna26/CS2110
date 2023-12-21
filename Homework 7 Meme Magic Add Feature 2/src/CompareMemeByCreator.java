import java.util.Comparator;

public class CompareMemeByCreator implements Comparator<Meme>{

	@Override
	public int compare(Meme m1, Meme m2) {
		int retVal = m1.getCreator().compareTo(m2.getCreator());
		
		if (retVal != 0) return retVal;
		
		double retVal2 = m2.calculateOverallRating() - m1.calculateOverallRating();
		
		if (retVal2 != 0) return (int)retVal2;

		int retVal3 = m1.getCaption().compareTo(m2.getCaption());
		
		if (retVal3 != 0) return retVal3;
		
		int retVal4 = m1.getBackgroundImage().compareTo(m2.getBackgroundImage());
		
		if (retVal4 != 0) return retVal4;
		
		boolean a = m1.getShared();
		boolean b = m2.getShared();
		
		if (a == true && b == false) {
			return -1;
		}
		
		else if (a == false && b == true) {
			return +1 ;
		
		
		}
		return 0;
	}

}
