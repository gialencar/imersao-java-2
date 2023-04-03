import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBContentExtractor implements ContentExtractor {

  public List<Content> extractContents(String json) {

    var parser = new JsonParser();
    List<Map<String, String>> attributesList = parser.parse(json);

    List<Content> contents = new ArrayList<>();

    for (Map<String, String> attributes : attributesList) {
      String title = attributes.get("title");
      String imageURL = attributes.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");

      var Content = new Content(title, imageURL);

      contents.add(Content);
    }

    return contents;
  }

}