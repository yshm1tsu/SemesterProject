package helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class JsonParser{
    JSONParser parser = new JSONParser();
    Map titleInfo = new HashMap<String, String>();
    public Map query(String movieTitle){
        try {
            URI path = new URI("http://www.omdbapi.com/?apikey=c0d0654c&t="+ URLEncoder.encode(movieTitle, "UTF-8"));

            URL url = path.toURL();
            URLConnection yc = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                JSONArray array = new JSONArray();
                array.add(parser.parse(inputLine));

                // Loop through each item
                for (Object o : array) {
                    JSONObject parameters = (JSONObject) o;

                    String id = (String) parameters.get("Title");
                    titleInfo.put("titleId", id);
                    String year = (String) parameters.get("Year");
                    titleInfo.put("year", year);
                    String released = (String) parameters.get("Released");
                    titleInfo.put("released",released);
                    String runtime = (String) parameters.get("Runtime");
                    titleInfo.put("runtime", runtime);
                    String genre = (String) parameters.get("Genre");
                    titleInfo.put("genre", genre);
                    String director = (String) parameters.get("Director");
                    titleInfo.put("director", director);
                    String writer = (String) parameters.get("Writer");
                    titleInfo.put("writer", writer);
                    String actors = (String) parameters.get("Actors");
                    titleInfo.put("actors", actors);
                    String plot = (String) parameters.get("Plot");
                    titleInfo.put("plot", plot);
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return titleInfo;
    }
}