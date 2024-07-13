import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        Collections.sort(robots, (a, b) -> a.p - b.p);
        Deque<Robot> deque = new ArrayDeque<>();
        List<Robot> res = new ArrayList<>();
        for (Robot robot : robots) {
            if (robot.dir == 0) {
                while (!deque.isEmpty() && deque.peekLast().h < robot.h) {
                    deque.pollLast();
                    robot.h--;
                }
                if (!deque.isEmpty()) {
                    if (deque.peekLast().h == robot.h) {
                        deque.pollLast();
                    } else if (deque.peekLast().h > robot.h) {
                        deque.peekLast().h--;
                    }
                } else {
                    res.addLast(robot);
                }
            } else {
                deque.addLast(robot);
            }
        }
        while (!deque.isEmpty()) {
            res.add(deque.pollLast());
        }
        Collections.sort(res, (a, b) -> a.index - b.index);
        List<Integer> result = new ArrayList<>();
        for (Robot robot : res) {
            result.add(robot.h);
        }
        return result;
    }

    class Robot {
        int p;
        int h;
        int dir;
        int index;

        Robot(int p, int h, char c, int i) {
            this.p = p;
            this.h = h;
            dir = c == 'R' ? 1 : 0;
            index = i;
        }
    }
}
