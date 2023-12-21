public class Rating {
	
	private int score;
	private User user;
	
	
	
	public Rating(){
		}
		 
	public Rating(User user, int score){
		this.user = user;
		if (score == 0 | score == -1 | score == 1) {
			this.score = score;
		}
		else {
			score = 0;
		}
		
	}
	@Override
	public String toString() {
		
		if (score == 1) {
			 
			return "Rating was an upvote" ;
		}
		if (score == -1) {
			
			return "Rating was a downvote" ;
		}
					
		
		return "Rating was a pass";
		
			
		}
		
	
	
	
	@Override 
	public boolean equals(Object object) {
		if (object == null) { 
			return false;
		}
		if (object instanceof Rating) {
			Rating r = (Rating) object;
			
			if ( this.score == r.score && this.user == r.user) { 
				return true;
			}
		}
			
			
		return false;
	}

	public int getScore() {
		return score;
	}

	public boolean setScore(int score) {
		
		if (score == 1 | score == 0 | score == -1) {
			this.score = score;
			return true;
		}
		return false;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	


}
