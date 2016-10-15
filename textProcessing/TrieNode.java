package text;

public class TrieNode {
	char data;
	boolean isTerminal;
	TrieNode[] children;
	boolean isRoot;
	
	public TrieNode() {
		children = new TrieNode[26];
	}
}
