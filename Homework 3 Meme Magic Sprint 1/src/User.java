import java.util.ArrayList;

public class User {
	
	

	private String username;
	private ArrayList<Meme> memesCreated = new ArrayList<Meme>();
	private ArrayList<Meme> memesViewed;
	
	
	public void rateMeme(Meme meme, int rating) {
		
	
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
		return null;
	}
	
	public boolean deleteMeme(Meme meme) {
		return true;
	}
	
	public void shareMeme(Meme meme, Feed feed) {
	}
	
	public void rateNextMemeFromFeed(Feed feed, int ratingScore) {
		
	}
	
	public double calculateReputation() {
	return 0;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override 
	public boolean equals(Object o) {
		return super.equals(o);
		
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
