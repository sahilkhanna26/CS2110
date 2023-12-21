// Homework 3
//Sahil Khanna, sk5xvh
//Sources: TA, Lab, Cohort


public class Meme implements Comparable<Meme>{

	private User creator;
	private BackgroundImage backgroundImage;
	private Rating[] ratings; 
	private String caption; 
	private String captionVerticalAlign; 
	private boolean shared;
	
	
	public Meme() {
		ratings = new Rating[10];
		captionVerticalAlign = "bottom";
		backgroundImage = new BackgroundImage();
		this.caption = "";
		creator = new User();
				
	}
	
	
	public boolean addRating(Rating rating) {
		
				
		for (int i = 0; i< ratings.length; i++) {
			if (ratings[i] == null) {
				ratings[i] = rating;
				return true;
			}

		}

			
		Rating updatedratings[] = new Rating[ratings.length];
		
			for (int n = 0; n < ratings.length -1 ; n++) {
				updatedratings[n] = ratings[ n + 1];
				
			updatedratings[updatedratings.length - 1] = rating;
		
			ratings = updatedratings;
		
			return true;
			
			}
		
		return false;

		
	}
	
	public double calculateOverallRating() {
		double sum = 0.0;
		for (int i = 0; i < ratings.length;i++) {
			if (ratings[i] != null) {
				sum += ratings[i].getScore();
				
			}
			
		}
		return sum;
	
	}
	
	// Constructor Method
	
	public Meme(BackgroundImage backgroundImage, String caption, User creator) {
		ratings = new Rating[10];
		captionVerticalAlign = "bottom";
		this.backgroundImage = backgroundImage;
		this.caption = caption;
		this.creator = creator;
				
	}
	
	
	@Override
	public String toString() {
		int countPositive1 = 0;
		int countNegative1 = 0 ;
		
		
		for (int x  = 0; x < ratings.length-1; x++) {
			if (ratings[x] == null) {
				return backgroundImage.toString() + " '" + caption + "' " + this.calculateOverallRating() + " [+1: " + countPositive1 + ", -1: " + countNegative1 + "]" + " - created by " + creator.getUserName();			}
			
			if (ratings[x].getScore() == 1) {
				countPositive1 += 1;
			}
			if (ratings[x].getScore() == -1 ) {
				countNegative1 += 1;
			}
		}
		
		return backgroundImage.toString() + " '" + caption + "' " + this.calculateOverallRating() + " [+1: " + countPositive1 + ", -1: " + countNegative1 + "]"+ " - created by " + creator.getUserName() ;
	}
	
	@Override 
	public boolean equals(Object object) {
		if (object == null) { 
			return false;
		}
		if (object instanceof Meme) {
			Meme m = (Meme) object ;
		
			if (this.creator.equals(m.creator) && this.caption.equals(m.caption) &&
					this.backgroundImage.equals(m.backgroundImage)) {
				return true;
				}
			}
		
		return false;
	}
			
	
	

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(BackgroundImage backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public Rating[] getRatings() {
		return ratings;
	}

	public void setRatings(Rating[] ratings) {
		this.ratings = ratings;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getCaptionVerticalAlign() {
		return captionVerticalAlign;
	}

	public boolean setCaptionVerticalAlign(String captionVerticalAlign) {
		if (captionVerticalAlign.equals("top") | captionVerticalAlign.equals("bottom") | captionVerticalAlign.equals("middle")) {
			this.captionVerticalAlign = captionVerticalAlign;	
			return true;
	
		}
		return false;
		
		
	}

	public boolean getShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}


	@Override
	public int compareTo(Meme o) {
		int returnValue = this.caption.compareTo(o.caption);
		
		if (returnValue != 0) return returnValue;
		
		returnValue = this.backgroundImage.compareTo(o.backgroundImage);
		if (returnValue != 0) return returnValue;
		
		double returnValue2 = 0; 
		
		returnValue2 = o.calculateOverallRating() - this.calculateOverallRating();
		
		if (returnValue2 != 0) return (int)returnValue2;
		
		if (this.shared == true && o.shared == false) {
			return -1;
		}
		
		else if (this.shared == false && o.shared == true) {
			return +1 ;
		
		
		}
		return 0;
		
	}
	
	
	
	
	
	
}
