import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static String[] solution(String[] streamerInformation, String[] commands) {
        List<String> res = new ArrayList<>();
        List<twitch> streamers = new ArrayList<>();
        for (int i = 0; i < streamerInformation.length; i += 3) {
            String name = streamerInformation[i];
            int views = Integer.parseInt(streamerInformation[i + 1]);
            String category = streamerInformation[i + 2];
            streamers.add(new twitch(name, views, category));
        }
        int i = 0;
        while (i < commands.length) {
            String command = commands[i];
            if (command.equals("StreamerOnline")) {
                String name = commands[i + 1];
                int views = Integer.parseInt(commands[i + 2]);
                String category = commands[i + 3];
                streamers.add(new twitch(name, views, category));
                i += 4;
            } else if (command.equals("UpdateViews")) {
                String name = commands[i + 1];
                int views = Integer.parseInt(commands[i + 2]);
                String category = commands[i + 3];
                for (int j = 0; j < streamers.size(); j++) {
                    if (streamers.get(j).name.equals(name)) {
                        if (streamers.get(j).category.equals(category)) {
                            streamers.get(j).views = views;
                            break;
                        }
                    }
                }
                i += 4;
            } else if (command.equals("UpdateCategory")) {
                String name = commands[i + 1];
                String oldCategory = commands[i + 2];
                String newcategory = commands[i + 3];
                for (int j = 0; j < streamers.size(); j++) {
                    if (streamers.get(j).name.equals(name)) {
                        if (streamers.get(j).category.equals(oldCategory)) {
                            streamers.get(j).category = newcategory;
                            break;
                        }
                    }
                }
                i += 4;
            } else if (command.equals("StreamerOffine")) {
                String name = commands[i + 1];
                String category = commands[i + 2];
                for (int j = 0; j < streamers.size(); j++) {
                    if (streamers.get(j).name.equals(name)) {
                        if (streamers.get(j).category.equals(category)) {
                            streamers.remove(j);
                            break;
                        }
                    }
                }
                i += 3;
            } else if (command.equals("ViewsInCategory")) {
                int totalViews = 0;
                String category = commands[i + 1];
                for (int j = 0; j < streamers.size(); j++) {
                    if (streamers.get(j).category.equals(category)) {
                        totalViews += streamers.get(j).views;
                    }
                }
                res.add(String.valueOf(totalViews));
                i += 2;
            } else if (command.equals("TopStreamerInCategory")) {
                String streamer = null;
                String category = commands[i + 1];
                int max = 0;
                for (int j = 0; j < streamers.size(); j++) {
                    if (streamers.get(j).category.equals(category)) {
                        if (streamer == null) {
                            streamer = streamers.get(j).name;
                            max = streamers.get(j).views;
                        } else if (streamers.get(j).views > max) {
                            streamer = streamers.get(j).name;
                            max = streamers.get(j).views;
                        }
                    }
                }
                res.add(streamer);
                i += 2;
            } else if (command.equals("TopStreamer")) {
                String streamer = null;
                int max = 0;
                for (int j = 0; j < streamers.size(); j++) {
                    if (streamer == null) {
                        streamer = streamers.get(j).name;
                        max = streamers.get(j).views;
                    } else if (streamers.get(j).views > max) {
                        streamer = streamers.get(j).name;
                        max = streamers.get(j).views;
                    }
                }
                res.add(streamer);
                i += 1;
            }
        }
        return res.toArray(new String[0]);
    }

    static class twitch {
        String name;
        int views;
        String category;

        twitch(String name, int views, String category) {
            this.name = name;
            this.views = views;
            this.category = category;
        }
    }

    public static void main(String[] args) {
        String[] streamerInformation = new String[]{"Ninja", "100000", "Fortnite", "Pokimane", "40000", "Valorant"};
        String[] commands = new String[]{"StreamerOnline", "AOC", "75000", "Just Chatting", "ViewsInCategory", "Just Chatting"};
        String[] commands2 = new String[]{"StreamerOnline", "Tue", "110000", "Fortnite", "ViewsInCategory", "Fortnite", "TopStreamerInCategory", "Fortnite"};
        System.out.println(Arrays.toString(solution(streamerInformation, commands2)));
    }
}

