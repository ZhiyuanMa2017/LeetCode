import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution2 {
    public static String[] solution(String[] streamerInformation, String[] commands) {
        List<String> res = new ArrayList<>();
        Map<String, Node> streamers = new HashMap<>();
        for (int i = 0; i < streamerInformation.length; i += 3) {
            String name = streamerInformation[i];
            int views = Integer.parseInt(streamerInformation[i + 1]);
            String category = streamerInformation[i + 2];
            streamers.put(name, new Node(views, category));
        }
        int i = 0;
        while (i < commands.length) {
            String command = commands[i];
            if (command.equals("StreamerOnline")) {
                String name = commands[i + 1];
                int views = Integer.parseInt(commands[i + 2]);
                String category = commands[i + 3];
                streamers.put(name, new Node(views, category));
                i += 4;
            } else if (command.equals("UpdateViews")) {
                String name = commands[i + 1];
                int views = Integer.parseInt(commands[i + 2]);
                String category = commands[i + 3];
                if (streamers.containsKey(name)) {
                    if (streamers.get(name).category.equals(category)) {
                        streamers.get(name).views = views;
                    }
                }
                i += 4;
            } else if (command.equals("UpdateCategory")) {
                String name = commands[i + 1];
                String oldCategory = commands[i + 2];
                String newcategory = commands[i + 3];
                if (streamers.containsKey(name)) {
                    if (streamers.get(name).category.equals(oldCategory)) {
                        streamers.get(name).category = newcategory;

                    }
                }
                i += 4;
            } else if (command.equals("StreamerOffline")) {
                String name = commands[i + 1];
                String category = commands[i + 2];
                if (streamers.containsKey(name)) {
                    if (streamers.get(name).category.equals(category)) {
                        streamers.remove(name);

                    }
                }
                i += 3;
            } else if (command.equals("ViewsInCategory")) {
                int totalViews = 0;
                String category = commands[i + 1];
                for (String key : streamers.keySet()) {
                    if (streamers.get(key).category.equals(category)) {
                        totalViews += streamers.get(key).views;
                    }
                }
                res.add(String.valueOf(totalViews));
                i += 2;
            } else if (command.equals("TopStreamerInCategory")) {
                String streamer = null;
                String category = commands[i + 1];
                int max = 0;
                for (String key : streamers.keySet()) {
                    if (streamers.get(key).category.equals(category)) {
                        if (streamer == null) {
                            streamer = key;
                            max = streamers.get(key).views;
                        } else if (streamers.get(key).views > max) {
                            streamer = key;
                            max = streamers.get(key).views;
                        }
                    }
                }
                res.add(streamer);
                i += 2;
            } else if (command.equals("TopStreamer")) {
                String streamer = null;
                int max = 0;
                for (String key : streamers.keySet()) {
                    if (streamer == null) {
                        streamer = key;
                        max = streamers.get(key).views;
                    } else if (streamers.get(key).views > max) {
                        streamer = key;
                        max = streamers.get(key).views;
                    }
                }
                res.add(streamer);
                i += 1;
            }
        }
        return res.toArray(new String[0]);
    }

    static class Node {

        int views;
        String category;

        Node(int views, String category) {
            this.views = views;
            this.category = category;
        }
    }

    public static void main(String[] args) {
        String[] streamerInformation = new String[]{"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"};
        String[] commands = new String[]{"StreamerOnline", "AOC", "75000", "Just Chatting", "ViewsInCategory", "Just Chatting"};
        String[] commands2 = new String[]{"StreamerOnline", "Tue", "110000", "Fortnite", "ViewsInCategory", "Fortnite", "TopStreamerInCategory", "Fortnite"};
        String[] commands3 = new String[]{"UpdateViews", "Ninja", "120000", "Fortnite", "ViewsInCategory", "Fortnite"};
        System.out.println(Arrays.toString(solution(streamerInformation, commands3)));
    }
}

