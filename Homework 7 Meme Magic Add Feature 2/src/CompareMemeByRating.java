import java.util.Comparator;

public class CompareMemeByRating  implements Comparator<Meme>{

	@Override
	public int compare(Meme m1, Meme m2) {

		double retVal = m2.calculateOverallRating() - m1.calculateOverallRating();
		
		if (retVal != 0) return (int)retVal;
		
		int retVal2 = m1.getCaption().compareTo(m2.getCaption());
		
		if (retVal2 != 0) return retVal2;
		
		int retVal3 = m1.getBackgroundImage().compareTo(m2.getBackgroundImage());
		
		if (retVal3 != 0) return retVal3;

		int retVal4 = m1.getCreator().compareTo(m2.getCreator());
		
		if (retVal4 != 0) return retVal4;
		
		return retVal4;

		
		
				
		
	}
}

