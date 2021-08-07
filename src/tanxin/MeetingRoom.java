package tanxin;

import com.sun.xml.internal.ws.encoding.MtomCodec;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
    最多可以参加的会议数目
    https://leetcode-cn.com/problems/maximum-number-of-events-that-can-be-attended/
 */
public class MeetingRoom {
    public class Event {
        int startDay;
        int endDay;

        public Event(int s, int e) {
            startDay = s;
            endDay = e;
        }
    }

    public class earlyEnd implements Comparator<Event> {

        @Override
        public int compare(Event o1, Event o2) {
            if (o1.endDay == o2.endDay) {
                return o1.startDay - o2.startDay;
            } else {
                return o1.endDay - o2.endDay;
            }
        }
    }

    public class earlyStart implements Comparator<Event> {

        @Override
        public int compare(Event o1, Event o2) {
            if (o1.startDay == o2.startDay) {
                return o1.endDay - o2.endDay;
            } else {
                return o1.startDay - o2.startDay;
            }
        }
    }

    public int maxEvents(int[][] events) {
        int count = 0;
        PriorityQueue<Event> earStar = new PriorityQueue<>(new earlyStart());
        PriorityQueue<Event> earEnd = new PriorityQueue<>(new earlyEnd());
        for (int[] event :events) {
            earStar.offer(new Event(event[0], event[1]));
        }

        int startD = 0;
        Event temp;
        while (!earStar.isEmpty() || !earEnd.isEmpty()) {
            if (earEnd.isEmpty()) {
                temp = earStar.poll();
                earEnd.offer(temp);
                startD = temp.startDay;
            }
            while (!earStar.isEmpty() && startD >= earStar.peek().startDay) {
                temp = earStar.poll();
                earEnd.offer(temp);
            }
            if (earEnd.peek().endDay >= startD) {
                startD++;
                count++;
            }
            earEnd.poll();
        }
        return count;
    }

    @Test
    public void ttest() {
        //[[1,4],[4,4],[2,2],[3,4],[1,1]]
        int[][] events = {{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        // [[1,5],[1,5],[1,5],[2,3],[2,3]] 过不了
        System.out.println(maxEvents(events));
    }
}
