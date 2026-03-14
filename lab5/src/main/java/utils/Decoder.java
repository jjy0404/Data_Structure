package utils;

import stores.*;

public class Decoder {
    private BinaryTreeNode<String> root;

    public Decoder() {
        root = new BinaryTreeNode<String>(""); // root node has no information

        // there must be a better way to do this...
        root.setLeft(new BinaryTreeNode<String>("e")); 
        root.setRight(new BinaryTreeNode<String>("t")); 
        root.getLeft().setLeft(new BinaryTreeNode<String>("i")); 
        root.getLeft().setRight(new BinaryTreeNode<String>("a")); 
        root.getRight().setLeft(new BinaryTreeNode<String>("n")); 
        root.getRight().setRight(new BinaryTreeNode<String>("m"));
	root.getLeft().getLeft().setLeft(new BinaryTreeNode<String>("s"));
	root.getLeft().getRight().setLeft(new BinaryTreeNode<String>("r"));
	root.getRight().getLeft().setLeft(new BinaryTreeNode<String>("d"));
	root.getRight().getRight().setLeft(new BinaryTreeNode<String>("g"));
       	root.getLeft().getLeft().setRight(new BinaryTreeNode<String>("u"));
    }

    // INCOMPLETE: An iterative version of the Morse code decoder
    public String decode(String m) {
        BinaryTreeNode<String> ptr = root; // start at root of tree
        String str="?"; // decoded character

        // scan through the Morse string
        for (int i=0;i<m.length();i++)
        {
            if (ptr==null){
                str = "Yipes! Can't decode Morse string!";
            } else if (m.charAt(i)=='.'){
                ; // missing statement 1
		ptr = ptr.getLeft();
            } else if (m.charAt(i)=='-'){
                ; // missing statement 2
		ptr = ptr.getRight();
            }
        }

        if (ptr!=null)
            str = (String)ptr.getValue();

        return str;     
    }

    // INCOMPLETE: A Recursive version of the decoder
    private String decodeR(BinaryTreeNode<String> n, String m) {
        String str="?";
        if (n!=null) {
            if (m.length()==0){
                str = n.getValue();
            } else if (m.charAt(0)=='.') {
                ;//  Missing recursion here
		str =  decodeR(n.getLeft(), m.substring(1));
            } else if (m.charAt(0)=='-') {
                ;//  Missing recursion here
		str = decodeR(n.getRight(), m.substring(1));
            } 
        }
        return str;
    }

    // public wrapper function to hide decodeR()
    public String decode2(String m) {
        return decodeR(root, m);
    }
}
