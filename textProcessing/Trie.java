package text;

public class Trie {
	
	private TrieNode rootNode;
	private int count;
	
	public Trie() {
		rootNode = new TrieNode();
		rootNode.data = '$';
		rootNode.isRoot = true;
		rootNode.isTerminal = false;
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}
	
	public void addWord(String word) {
		String smallWord = word.toLowerCase();
		TrieNode currentParent = rootNode;
		// TODO
		//boolean isDuplicate = true;
		for (int i = 0; i < smallWord.length(); i++) {
			char currentChar = smallWord.charAt(i);
			int indexCurrentChar = currentChar - 'a';
			if (currentParent.children[indexCurrentChar] != null) {
				currentParent = currentParent.children[indexCurrentChar];
			} else {
			//	isDuplicate = false;
				TrieNode newNode = new TrieNode();
				newNode.data = currentChar;
				newNode.isRoot = false;
				newNode.isTerminal = false;
				currentParent.children[indexCurrentChar] = newNode;
				currentParent = newNode;
			}
		}
		//if (!isDuplicate)
		count++;
		currentParent.isTerminal = true;
	}
	
	public boolean search(String toBeFound) {
		String smallWord = toBeFound.toLowerCase();
		TrieNode currentParent = rootNode;
		for (int i = 0; i < smallWord.length(); i++) {
			char currentChar = smallWord.charAt(i);
			int indexCurrentChar = currentChar - 'a';
			if (currentParent.children[indexCurrentChar] == null) {
				return false;
			}
			currentParent = currentParent.children[indexCurrentChar];
		}
		if (currentParent.isTerminal)
			return true;
		else 
			return false;
	}
	
	//TODO
//	public boolean deleteWord(String word) {
//		
//	}
	
}
