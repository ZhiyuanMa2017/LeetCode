import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
    String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Random random = new Random();
    Map<String, String> map = new HashMap<>();
    String key = getKey();

    private String getKey() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(alphabet.charAt(random.nextInt(62)));
        }
        return stringBuilder.toString();
    }

    public Codec() {
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while (map.containsKey(key)) {
            key = getKey();
        }
        map.put(key, longUrl);
        return "http://tinyurl.com/" + key;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("http://tinyurl.com/", ""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));