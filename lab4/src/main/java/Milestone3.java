import  stores.HashMap;

public class Milestone3 {
    public static void main (String args[]) {
        HashMap<String, String> module = new HashMap<>();
	module.add("cs118", "programming");
	module.add("cs126", "data structure");
	module.add("ib104", "mathematical programming");
	module.add("ma138", "sets and numbers");
	module.add("ma142", "calculus 1");
	module.add("ma143", "calculus 2");
	module.add("ma148", "vectors and matrices");
	module.add("ma1k2", "refresher");
	module.add("st117", "statistical modelling");
	module.add("st118", "probability 1");
	module.add("st119", "probability 2");
	module.add("as826", "pyhsic");
	module.add("af156", "chem");
	module.add("gr157", "bio");
	module.add("t2091", "engineering");
	module.add("hk145", "tennis");
	module.add("so104", "korean");
	module.add("ho194", "english");
	module.add("oj132", "grammar");
	module.add("sf182", "economic");
	System.out.print(module.toString());
    
    }
}
