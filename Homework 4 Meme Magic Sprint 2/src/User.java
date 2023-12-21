import java.util.ArrayList;

public class User {
	
	

	private String username;
	private ArrayList<Meme> memesCreated = new ArrayList<Meme>();
	private ArrayList<Meme> memesViewed;
	
	
	public void rateMeme(Meme meme, int rating) {
		this.memesViewed.add(meme);
		
		Rating r = new Rating(this, rating);
		
		meme.addRating(r);
	
	}
	
	public User(String username) {
		this.username = username;
		this.memesCreated = new ArrayList<Meme>();
		this.memesViewed = new ArrayList<Meme>();
	}
	
	public User(){
		this.username = "";
		this.memesCreated = new ArrayList<Meme>();
		this.memesViewed = new ArrayList<Meme>();
		
	}
//	public User(String username, ArrayList<Meme> memesCreated, ArrayList<Meme> memesViewed ) {
//		this.setUserName(username);
//		this.setMemesCreated(memesCreated);
//		this.setMemesViewed(memesViewed);
//	}
	
	
	public Meme createMeme(BackgroundImage backgroundImage, String caption) {
		Meme m = new Meme(backgroundImage, caption,this);
		this.memesCreated.add( m ) ;
		return m;
		
	}
	
	public boolean deleteMeme(Meme meme) {
		
		if (memesCreated.contains(meme) && meme.getShared() == false){
			return(memesCreated.remove(meme));
		}
		
		return false;
	}
	
	public void shareMeme(Meme meme, Feed feed) {
		meme.setShared(true);
		Meme m = meme;
		ArrayList<Meme> memes = feed.getMemes();
		memes.add(m);
		feed.setMemes(memes);
	}
	
	public boolean rateNextMemeFromFeed(Feed feed, int ratingScore) {
		
		
		Meme m= feed.getNewMeme(this);
		
		if (m != null) {
			this.memesViewed.add(m);
		
			Rating r = new Rating(this, ratingScore);
		
			m.addRating(r);
		
			return true;
		}
		return false;
		
		
	}
	
	public double calculateReputation() {
		double total = 0.0;
		int num_of_memes = 0;
		double average = 0.0;
		for (Meme m : memesCreated) {
			total = total + m.calculateOverallRating();
			num_of_memes ++;
		}
		
		if (num_of_memes != 0 && total != 0) {
			average = total/num_of_memes;
			return average;
		}
		
	return 0.0;
	}
	
	@Override
	public String toString() {
		int num_of_memes = 0;
		
		for (Meme m : memesViewed) {
			num_of_memes++;
		}
		return username + " has rated (" + num_of_memes + ") memes, (" + String.format("%.1f",this.calculateReputation())+ ")";
	}
	
	@Override 
	public boolean equals(Object o) {
		if (o == null) { 
			return false;
		}
		if (o instanceof User) {
			User u = (User) o ;
		
			if (this.username.equals(u.getUserName())){
			return true;
			}
		}
	
		return false;
		
	}
	
	
	
	
	
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public ArrayList<Meme> getMemesCreated() {
		return memesCreated;
	}
	public void setMemesCreated(ArrayList<Meme> memesCreated) {
		this.memesCreated = memesCreated;
	}
	public ArrayList<Meme> getMemesViewed() {
		return memesViewed;
	}
	public void setMemesViewed(ArrayList<Meme> memesViewed) {
		this.memesViewed = memesViewed;
	}
	
	
	

}
