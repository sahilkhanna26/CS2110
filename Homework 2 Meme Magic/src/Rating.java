public class Rating {
	
	private int score;
	private User user;
	
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override 
	public boolean equals(Object object) {
		return true;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
