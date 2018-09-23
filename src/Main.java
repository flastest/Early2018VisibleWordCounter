

public class Main {  
	public static void main(String [] args) {
		System.out.println("//");
		System.out.println("/");
		System.out.println("red255\\\\green255\\\\blue255");
		System.out.println("red255\\\\green255\\\\blue255".length());
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa".length());
		WordCount kek;
		String pathname = "C:\\Program Files (x86)\\cygwin\\home\\Flasterhack\\wordCount\\src\\Document.rtf";
		kek = new WordCount(pathname);
		kek.fileToString();


		System.out.println("is there white in this?  "+kek.checkWordColor());


		String meme = "bridge base online";
		System.out.println(meme.substring(meme.length()-5,meme.length()-1));



		kek.printStrings();
		kek.printWords();
		meme+="jejeje";
		System.out.println(meme + "kekekeke");

		kek.getLocOf1stInstanceOf("kknow");
		kek.getLocOf1stInstanceOf("   kknow   ");
	}
}