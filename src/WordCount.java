/* sources:
 * 	http://www.avajava.com/tutorials/lessons/how-do-i-read-a-string-from-a-file-line-by-line.html
 * 
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class WordCount{
	private File document;
	private ArrayList<String> fileStrings;
	private ArrayList<String> fileWords;
	
	public WordCount() {
		document= null;
	}
	
	public WordCount(String newFileLoc) {
		document = new File(newFileLoc);
		fileToStrings();
		wordParse();
	}
	
	private void fileToStrings() {
		try {
			FileReader fileReader = new FileReader(document);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			ArrayList<String> lines = new ArrayList<String>();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.length()>=4&&line.substring(line.length()-4,line.length()).equals("\\par")){
					line = line.substring(0,line.length()-4);
				}//that if statement removes all the /pars from ends of lines
				lines.add(line);
			}
			fileReader.close();
			System.out.println("fileCopied");
			fileStrings = lines;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void wordParse(){ //do this with...I hate to say it..map reduce
		ArrayList<String> kekekek = new ArrayList<String>();
		for(int i = 0; i < fileStrings.size();i++){
			kekekek.addAll(wordParseKernel(i,fileStrings.get(i)));
		}
		fileWords = kekekek;
	}

	private ArrayList<String> wordParseKernel(int order,String parseMe){ //parallelize this
		// wait until all the "order"s before you add to fileWords before you do.
		ArrayList<String> words = new ArrayList<String>();
		String word = "";
		for(int letter = 0; letter < parseMe.length();letter++){
			String curChar = parseMe.substring(letter,letter+1);
			if (curChar.equals(" ")) {
				words.add(word);
				word = "";
			} else{
				word+=parseMe.substring(letter,letter+1);
			}
		}
		return words;
	}

	public void printWords(){
		System.out.println("test");
		System.out.println("num words is "+fileWords.size());
		for(String str:fileWords){
			System.out.println(str);
		}
	}
	
	public void printStrings(){
		for (String str:fileStrings){
			System.out.println(str);
		}
	}

	public boolean checkWordColor() {
		boolean existanceOfWhiteText = false;
		String line2 = fileStrings.get(1);
		if(line2.substring(0,10).equals("{\\colortbl")) { //if there's multiple colors in text
			String whiteText = "red255\\green255\\blue255";
			int strLen = whiteText.length();
			String sample = line2.substring(10,line2.length());
			for(int i = 0; i < sample.length()-strLen; i++){
				String checkCheckSplit = sample.substring(i,i+strLen);
				if(checkCheckSplit.equals(whiteText)){
					return true;
				}
			}
		}
		return existanceOfWhiteText;
	}
	
	public void fileToString() {
		try {
			FileReader fileReader = new FileReader(document);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append("\n");
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String removeSpaces(String word){
		if(word.length()<2){
			return word;
		}
		if(word.substring(0,1).equals(" ")){
			return removeSpaces(word.substring(1,word.length()));
		}
		if(word.substring(word.length()-1,word.length()).equals(" ")){
			return removeSpaces(word.substring(0,word.length()-1));
		}
		return word;
	}

	private ArrayList<String> getWordsThatStartWith(String firstLetter) {
		ArrayList<String> wordies = new ArrayList<String>();
		String letter = removeSpaces(firstLetter);
		for (String keklord : fileWords){
			if(keklord.substring(0,1).equals(letter)){
				wordies.add(keklord);
			}
		}
		return wordies;
	}

	public int getLocOf1stInstanceOf(String word) {
		System.out.println("this is word before removeSpaces: " + word+".");
		String newWord = removeSpaces(word);
		System.out.println("This is word after removeSpaces: " + newWord+".");
		for(int i = 0; i < fileWords.size(); i++) {
			if(fileWords.get(i).equals(newWord)){
				return i;
			}
		}
		return -1;
	}

	private ArrayList<String> getWordsThatEndWith(String endLetter) {
		return null;
	}

	public boolean isManyCite() {
		//must do this sequentially
		return false;
	}

	private void ocnvertToRtf(){
		//this will be useful for color and the citations...
	}

	private void convertToTxt(){
		//this will be useful for determining margin violations and
		// the cheat with changing period sizes. that's for page
		// count though, maybe I'll make another class?
	}

	public int howManyWhiteWords(){
		return 0;
	}

}


