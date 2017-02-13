package ExtractTweetFromJson.ExtractTweetFromJson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
public class JsonParser {
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
{

	/*
	JSONObject obj = new JSONObject("{interests : [{interestKey:Dogs}, {interestKey:Cats}]}");

	List<String> list = new ArrayList<String>();
	JSONArray array = obj.getJSONArray("interests");
	for(int i = 0 ; i < array.length() ; i++){
	    list.add(array.getJSONObject(i).getString("interestKey"));
	}
	*/
	int i=0;
	int j=5;
	while(i<4)
	{
		BufferedReader bf=new BufferedReader(new FileReader("tweets"+i+"_aapl.txt"));
		BufferedWriter b1=new BufferedWriter(new FileWriter("tweets"+j+"_aapl.txt"));
	String line="";
	while((line=bf.readLine())!=null)
	{
		if(line.isEmpty() || line.trim().equals("") || line.trim().equals("\n"))
			continue;
		//System.out.println("line:"+line);
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(line);
		String txt= (String)json.get("text");
	//	System.out.println("text:"+txt);
		b1.write(txt);
		b1.write("\n");
		//JSONObject obj = new JSONObject(line);
		//System.out.println("line:"+line);
	}
	
	bf.close();
	System.out.println(i);
	i++;
	j++;
	b1.close();

	}
	
	
}
}
