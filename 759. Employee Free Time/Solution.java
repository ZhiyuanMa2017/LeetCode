import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        int n = schedule.size();
        List<Interval> time = mergeSort(schedule, 0, n - 1);
        List<Interval> free = new ArrayList<>();
        int end = time.get(0).end;
        for (int i = 1; i < time.size(); i++) {
            if (time.get(i).start > end) {
                free.add(new Interval(end, time.get(i).start));
            }
            end = Math.max(end, time.get(i).end);
        }
        return free;
    }

    private List<Interval> mergeSort(List<List<Interval>> schedule, int left, int right) {
        if (left == right) {
            return schedule.get(left);
        }
        int mid = left + (right - left) / 2;
        List<Interval> l = mergeSort(schedule, left, mid);
        List<Interval> r = mergeSort(schedule, mid + 1, right);
        return merge(l, r);
    }

    private List<Interval> merge(List<Interval> l, List<Interval> r) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n = l.size();
        int m = r.size();
        while (i < n && j < m) {
            if (l.get(i).start < r.get(j).start) {
                res.add(l.get(i));
                i++;
            } else {
                res.add(r.get(j));
                j++;
            }
        }
        while (i < n) {
            res.add(l.get(i));
            i++;
        }
        while (j < m) {
            res.add(r.get(j));
            j++;
        }
        return res;
    }
}
