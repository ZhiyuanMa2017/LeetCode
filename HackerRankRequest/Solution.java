import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private static String URL = "https://jsonmock.hackerrank.com/api/food_outlets?city=";

    class Outlet {
        String name;
        float rating;

        Outlet(String name, float rating) {
            this.name = name;
            this.rating = rating;
        }
    }

    public List<String> getTopRatedFoodOutlets(String city) {
        int maxPages = getMaxPages(city);
        List<Outlet> allOutlets = new ArrayList<>();

        for (int i = 1; i <= maxPages; i++) {
            try {
                String url = URL + city + "&page=" + i;
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .GET()
                        .uri(URI.create(url))
                        .build();
                String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
                JsonObject json = new Gson().fromJson(response, JsonObject.class);
                JsonArray outlets = json.get("data").getAsJsonArray();
                for (int j = 0; j < outlets.size(); j++) {
                    String name = outlets.get(j).getAsJsonObject().get("name").getAsString();
                    String rating = outlets.get(j).getAsJsonObject().get("user_rating")
                            .getAsJsonObject().get("average_rating").getAsString();
                    Outlet outlet = new Outlet(name, Float.parseFloat(rating));
                    allOutlets.add(outlet);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<String> topRatedOutlets = new ArrayList<>();
        if (allOutlets.size() > 0) {

            Collections.sort(allOutlets, (o1, o2) -> Float.compare(o2.rating, o1.rating));
            for (Outlet allOutlet : allOutlets) {
                System.out.println(allOutlet.name + " " + allOutlet.rating);
            }
            float rating = allOutlets.get(0).rating;
            for (Outlet outlet : allOutlets) {
                if (outlet.rating == rating) {
                    topRatedOutlets.add(outlet.name);
                }
            }
        }
        return topRatedOutlets;
    }

    private int getMaxPages(String city) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().GET()
                    .uri(URI.create(URL + city)).build();
            String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            JsonObject json = new Gson().fromJson(response, JsonObject.class);
            return json.get("total_pages").getAsInt();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> topRatedOutlets = s.getTopRatedFoodOutlets("Seattle");
        for (String outlet : topRatedOutlets) {
            System.out.println(outlet);
        }
    }
}
