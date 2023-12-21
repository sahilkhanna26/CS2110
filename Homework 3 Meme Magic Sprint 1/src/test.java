
public class test {

	public static void main(String[] args) {

		BackgroundImage b = new BackgroundImage("city.png","city","New Delhi, India");
		
		BackgroundImage b1 = new BackgroundImage("sand.png","beach","Goa, India");
		
		System.out.println(b.toString());
		System.out.println(b1.toString());
		System.out.println(b.equals(b1));
		System.out.println(b.equals(b));
		
		User user1 = new User();
		User user2 = new User();
		
		Meme m = new Meme(b , "Image of Joquain Phoenix in his role as Joker, laughing maniacally", user1);
		Meme m1 = new Meme(b1 , "Leonardo DiCaprio raising a glass of wine", user2);
		
		System.out.println(m.toString());
		System.out.println(m1.toString());
		System.out.println(m.equals(m1));
		System.out.println(m.equals(m));
		
		
		
		Rating r = new Rating(user1, 1);
		Rating r1 = new Rating(user2, 0);
		
		System.out.println(r.toString());
		System.out.println(r1.toString());
		System.out.println(r.equals(r1));
		System.out.println(r.equals(r));
		

		System.out.println(m.calculateOverallRating());
		System.out.println(m1.calculateOverallRating());
		
		System.out.println(m.addRating(r));
		System.out.println(m1.addRating(r1));
		
		System.out.println(m.setCaptionVerticalAlign("bottom"));
		System.out.println(m1.setCaptionVerticalAlign("top"));
		
		
		System.out.println(r.setScore(1));
		System.out.println(r.setScore(0));
		
		
		
		
		
		
		
		
		
		
		
	}

}
