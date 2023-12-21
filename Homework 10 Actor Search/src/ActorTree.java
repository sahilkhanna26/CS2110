/**
 * <p>This is the class you will complete - fill in all the missing method implementations</p>
 * 
 *  * <p>All the classes have been created for you, you must implement the ActorTree class methods.
 * If your BST works correctly, searches made against it should return in almost no time at all.</p>
 * 
 * @author Your friendly CS professors
 *
 */
public class ActorTree {
	/**
	 * ActorTree has only one property, the root node
	 */
	Node root;
	

	/**
	 * Initialize the root node in the default constructor
	 */
	public ActorTree() {
		root = new Node();
	}

	/**
	 * 
	 * @param name
	 *            - the name to find
	 * @return the matching Actor object
	 */
	public Actor find(String name) {
			
		if (root.actor != null) {
			return root.find(name);
		}
		return null; 
		}

	/**
	 * 
	 * @return an int representing 1 for each node in the tree
	 * 
	 */
	public int size() {
		if (root.actor != null) {
			return root.size();
		}
	return 0;
	}

	/**
	 * 
	 * @return an int representing the maximum height of any branch
	 */
	public int height() {
		
		if (root.actor != null) {
			return root.height();
		}
		return 0;
				
	}
	/**
	 * an empty tree is one with no data
	 * 
	 * @return boolean - True if the tree is empty
	 */
	public boolean isEmpty() {
		if (root.actor != null) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param a
	 *            - an Actor object
	 * @return boolean - True if the element was inserted
	 */
	public boolean insert(Actor a) {
		if (root.actor == null) {
			root = new Node(a);
			return true;
		}
		return root.insert(a);
	}
	
	/**
	 * In order Traversal
	 *
	 * @return a String representing the in-order traversal of this tree
	 */
	public String inOrder() {
		if (root.actor == null) {
			return "";
		}
		return root.inOrder();
	}

	/**
	 * The Node class is an inner class of the ActorTree This is a Binary Search
	 * Tree, so each Node will have left and right children
	 * 
	 * @author Your friendly CS Professors
	 *
	 */
	class Node {
		Actor actor;
		Node left;
		Node right;

		/**
		 * default constructor
		 */
		public Node() {
			actor = null;
			left = null;
			right = null;
		}

		/**
		 * Constructor that takes an Actor object
		 * 
		 * @param a
		 *            - an Actor left and right children are initialized to null
		 */
		public Node(Actor a) {
			actor = a;
			left = null;
			right = null;
		}

		/**
		 * The size method is recursive
		 * 
		 * @return an int to represent a count of all nodes
		 */
		public int size() {
			return size(this);
		}
		private int size(Node n) {
			if (n == null) {
				return 0;
			}
			else {
				return 1 + size(n.left) + size(n.right);
			}
		}

		/**
		 * The height method is recursive
		 * 
		 * @return an int to represent the maximum height of right or left child nodes,
		 *         plus 1 for the current node
		 */
		public int height() {
			Node n1 = this;
			int lHeight;
			int rHeight;
			
			if (n1.left == null) {
				lHeight = 0;
			}
			else {
				lHeight = n1.left.height();
			}
			if (n1.right == null) {
				rHeight = 0;
			}
			else {
				rHeight = n1.right.height();
			}
			if (lHeight < rHeight) {
				return 1 + rHeight;
			}
			else{
				return 1 + lHeight;
			}
		}
		
		/**
		 * The insert method finds the best place to insert the Actor argument
		 * 
		 * @param a
		 *            - an Actor to insert
		 * @return boolean - True if the Actor argument was added, false otherwise
		 */
		public boolean insert(Actor a) {
			Node n2 = this;
			int i = a.compareTo(n2.actor);
			if (i<0) {
				if(n2.left == null) {
					n2.left = new Node (a);
					return true;
				}
				else {
					return n2.left.insert(a);
				}
			}
			else if (i>0) {
				if(n2.right == null) {
					n2.right = new Node (a);
					return true;
				}
				else {
					return n2.right.insert(a);
				}
			}
			return false;
			}
			
		

		/**
		 * The find method returns an Actor object with a matching name
		 * 
		 * @param name
		 *            - the name to search for
		 * @return the searched for Actor, or null
		 */
		public Actor find(String name) {
			Node n3 =this; 
			while(n3 != null) {
				int i = name.compareTo(n3.actor.getPrimaryName());
				if (i<0 && n3.left != null) {
					return n3.left.find(name);
				}
				else if (i>0 && n3.right!= null) {
					return n3.right.find(name);
				}
				else if (i == 0 ) {
					return n3.actor;
				}
				else {
					return null;
				}
			}
			return null;
		}
		
			
	    /**
	     * In order Traversal
	     *
	     * @return a String representing the in-order traversal of the subtree rooted at this node
	     */
		public String inOrder() {
			String s = ""; 
			Node n4 = this;
			
			if (n4.left != null) {
				s = s + n4.left.inOrder();
			}
			
			s = s + n4.actor.toString() + '\n';
			
			if (n4.right != null) {
				s = s + n4.right.inOrder();
			}
			return s;
		
		}
	}
	
	public static void main( String[] args) {
		ActorTree AT = new ActorTree();
		Actor a = new Actor("Sahil");
		Actor a1 = new Actor("Mason");
		Actor a2 = new Actor("Ben");
		Actor a3 = new Actor("Emmanuel");
		Actor a4 = new Actor("Henry");
		Actor a5 = new Actor("Feroze");
		
		AT.insert(a);
		AT.insert(a3);
		AT.insert(a4);
		AT.insert(a1);
		AT.insert(a2);
		AT.insert(a5);
		
		System.out.println(AT.size());
		System.out.println(AT.height());
		System.out.println(AT.inOrder());
		System.out.println(AT.height());
		System.out.println(AT.isEmpty());
		System.out.println(AT.find("Sahil"));
		System.out.println(AT.find("Emmanuel"));

	}
	
}