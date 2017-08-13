
import java.io.*;
import java.util.*;

public class EbcdicToText {

	private Map<Integer,String> map;

	public EbcdicToText(){
		this.map = ebcdicTable();
	}

	public String toTextFromFile(File file) throws IOException{
	    StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(file));
		int intChar = br.read();
		while(intChar  != -1){

			Integer aux = new Integer(intChar);
			if(this.map.containsKey(aux)){
				sb.append(this.map.get(aux));
			}else{
			    sb.append(" ");
			}
			intChar = br.read();
		}
		br.close();
		return sb.toString();
	}

	private static Map<Integer,String> ebcdicTable(){
		Map<Integer,String> result = new HashMap<Integer,String>();

		int i = 129;
		result.put(new Integer(i++),"a");
		result.put(new Integer(i++),"b");
		result.put(new Integer(i++),"c");
		result.put(new Integer(i++),"d");
		result.put(new Integer(i++),"e");
		result.put(new Integer(i++),"f");
		result.put(new Integer(i++),"g");
		result.put(new Integer(i++),"h");
		result.put(new Integer(i++),"i");
		i = 145;
		result.put(new Integer(i++),"j");
		result.put(new Integer(i++),"k");
		result.put(new Integer(i++),"l");
		result.put(new Integer(i++),"m");
		result.put(new Integer(i++),"n");
		result.put(new Integer(i++),"o");
		result.put(new Integer(i++),"p");
		result.put(new Integer(i++),"q");
		result.put(new Integer(i++),"r");
		i = 162;
		result.put(new Integer(i++),"s");
		result.put(new Integer(i++),"t");
		result.put(new Integer(i++),"u");
		result.put(new Integer(i++),"v");
		result.put(new Integer(i++),"w");
		result.put(new Integer(i++),"x");
		result.put(new Integer(i++),"y");
		result.put(new Integer(i++),"z");
		i = 193;
		result.put(new Integer(i++),"A");
		result.put(new Integer(i++),"B");
		result.put(new Integer(i++),"C");
		result.put(new Integer(i++),"D");
		result.put(new Integer(i++),"E");
		result.put(new Integer(i++),"F");
		result.put(new Integer(i++),"G");
		result.put(new Integer(i++),"H");
		result.put(new Integer(i++),"I");
		i = 209;
		result.put(new Integer(i++),"J");
		result.put(new Integer(i++),"K");
		result.put(new Integer(i++),"L");
		result.put(new Integer(i++),"M");
		result.put(new Integer(i++),"N");
		result.put(new Integer(i++),"O");
		result.put(new Integer(i++),"P");
		result.put(new Integer(i++),"Q");
		result.put(new Integer(i++),"R");
		i = 226;
		result.put(new Integer(i++),"S");
		result.put(new Integer(i++),"T");
		result.put(new Integer(i++),"U");
		result.put(new Integer(i++),"V");
		result.put(new Integer(i++),"W");
		result.put(new Integer(i++),"X");
		result.put(new Integer(i++),"Y");
		result.put(new Integer(i++),"Z");
		i = 240;
		result.put(new Integer(i++),"0");
		result.put(new Integer(i++),"1");
		result.put(new Integer(i++),"2");
		result.put(new Integer(i++),"3");
		result.put(new Integer(i++),"4");
		result.put(new Integer(i++),"5");
		result.put(new Integer(i++),"6");
		result.put(new Integer(i++),"7");
		result.put(new Integer(i++),"8");
		result.put(new Integer(i++),"9");
		result.put(new Integer(i++),"|");
		return result;
	}
}