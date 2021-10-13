import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static class Score {
        int actualTime;
        String timeString;
        String teamName;
        String playerName;
        String substituteName;
        char eventType;
        boolean isFirstHalf;
        String originString;

        public Score(int actualTime, String timeString, String teamName, String playerName, String substituteName, char eventType, boolean isFirstHalf, String originString) {
            this.actualTime = actualTime;
            this.timeString = timeString;
            this.teamName = teamName;
            this.playerName = playerName;
            this.substituteName = substituteName;
            this.eventType = eventType;
            this.isFirstHalf = isFirstHalf;
            this.originString = originString;
        }
    }

    static Map<Character, Integer> map = new HashMap<>();

    public static List<String> getEventsOrder(String team1, String team2, List<String> events1, List<String> events2) {
        map.put('G', 1);
        map.put('Y', 2);
        map.put('R', 3);
        map.put('S', 4);
        List<Score> scoreList = new ArrayList<>();
        for (String e1 : events1) {
            Score score = parseString(e1, team1);
            scoreList.add(score);
            System.out.println(score);
        }
        for (String e2 : events2) {
            Score score = parseString(e2, team2);
            scoreList.add(score);
            System.out.println(score);
        }
        scoreList.sort((s1, s2) -> {
            if (s1.isFirstHalf && !s2.isFirstHalf) {
                return -1;
            }
            if (!s1.isFirstHalf && s2.isFirstHalf) {
                return 1;
            }
            if (s1.actualTime != s2.actualTime) {
                return s1.actualTime - s2.actualTime;
            }
            if (!map.get(s1.eventType).equals(map.get(s2.eventType))) {
                return map.get(s1.eventType) - map.get(s2.eventType);
            }
            if (!s1.teamName.equals(s2.teamName)) {
                return s1.teamName.compareTo(s2.teamName);
            }
            return s1.playerName.compareTo(s2.playerName);
        });
        List<String> answer = new ArrayList<>();
        for (Score score : scoreList) {
            answer.add(score.teamName + " " + score.originString);
        }
        return answer;
    }

    public static Score parseString(String str, String team) {
        String[] words = str.split(" ");
        int timeIndex = getTimeIndex(words);
        char event = words[timeIndex + 1].charAt(0);
        String player = "";
        for (int i = 0; i < timeIndex; i++) {
            player = player + " " + words[i];
        }
        player = player.trim();
        String sub = "";
        if (event == 'S') {
            for (int i = timeIndex + 2; i < words.length; i++) {
                sub += words[i] + " ";
            }
            sub = sub.trim();
        }
        int actualTime = 0;
        boolean isFirstHalf = false;
        if (words[timeIndex].contains("+")) {
            String[] timeSplit = words[timeIndex].split("\\+");
            actualTime += Integer.parseInt(timeSplit[0]);
            if (actualTime <= 45) {
                isFirstHalf = true;
            }
            actualTime += Integer.parseInt(timeSplit[1]);
        } else {
            actualTime += Integer.parseInt(words[timeIndex]);
            if (actualTime <= 45) {
                isFirstHalf = true;
            }
        }
        Score score = new Score(actualTime, words[timeIndex], team, player, sub, event, isFirstHalf, str);
        return score;
    }

    public static int getTimeIndex(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (Character.isDigit(words[i].charAt(0))) {
                return i;
            }
        }
        return -1;
    }
}
