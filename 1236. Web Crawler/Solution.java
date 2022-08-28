import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startUrl);
        set.add(startUrl);
        String hostName = getHostName(startUrl);
        while (!queue.isEmpty()) {
            String url = queue.poll();
            for (String next : htmlParser.getUrls(url)) {
                if (!set.contains(next) && getHostName(next).equals(hostName)) {
                    set.add(next);
                    queue.offer(next);
                }
            }
        }
        return new ArrayList<>(set);
    }

    private String getHostName(String url) {
        return url.split("/")[2];
    }

    interface HtmlParser {
        public List<String> getUrls(String url);
    }
}
