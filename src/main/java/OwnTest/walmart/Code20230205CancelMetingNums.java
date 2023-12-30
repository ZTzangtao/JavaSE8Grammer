package OwnTest.walmart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @Author: Tommy
 * @DATE: 2023/2/5
 */
public class Code20230205CancelMetingNums {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\zt\\Desktop\\code\\ts1_input.txt");
        BufferedReader br = new BufferedReader(fr);
        List<String> list = new ArrayList<>();
        String line = null;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        Integer allNums = Integer.valueOf(list.get(0));
        // case group
        List<List<String>> singleCases = new ArrayList<>();
        for(int i = 1; i < list.size(); i++) {
            if (list.get(i).split(" ").length >= 4) {
                List<String> singleCase = new ArrayList<>();
                singleCase.add(list.get(i));
                singleCase.add(list.get(i + 1));
                Integer singleAllNums = Integer.valueOf(list.get(i + 1));
                for(int j = 1; j <= singleAllNums; j++) {
                    singleCase.add(list.get(i + 1 + j));
                }
                singleCases.add(singleCase);
            }
        }
        for (int i = 0; i < singleCases.size(); i++) {
            List<String> c = singleCases.get(i);
            String[] firstLine =  c.get(0).split(" ");
            int SMEPersonNum = Integer.valueOf(firstLine[0]);
            int minJoinNum = Integer.valueOf(firstLine[1]);
            int meetingHour = Integer.valueOf(firstLine[2]);
            int maxTimeHour = Integer.valueOf(firstLine[3]);
            // 边界情况
            if (minJoinNum == SMEPersonNum && meetingHour == maxTimeHour) {
                System.out.println("Case #" + (1 + i) + ": " + c.get(1));
                continue;
            }
            int singleAllNums = Integer.valueOf(c.get(1));
            if (singleAllNums == 0) {
                System.out.println("Case #" + (1 + i) + ": " + 0);
                continue;
            }
            // 每个人的会议时间段
            Map<Integer,int[]> map = new HashMap<>();
            for(int j = 1; j <= singleAllNums; j++) {
                String[] s = c.get(j + 1).split(" ");
                SmeMeetingTime smeMeetingTime = new SmeMeetingTime(Integer.valueOf(s[0]), Integer.valueOf(s[1]), Integer.valueOf(s[2]));
                int[] meetingTime;
                // 人员编号为key, 其会议时间段为几个会议
                if (!map.containsKey(smeMeetingTime.getPersonNum())) {
                    // 如果是第一次出现
                    meetingTime = new int[maxTimeHour];
                    for (int k = smeMeetingTime.getStartTime(); k <= smeMeetingTime.getEndTime() - 1; k++) {
                        // (3~5) -> [3~4] （1->3） -> (1~2)
                        if (k < 0) {
                            continue;
                        }
                        meetingTime[k] = 1;
                    }
                } else {
                    // 如果是同一个人
                    meetingTime = map.get(smeMeetingTime.getPersonNum());
                    for (int k = smeMeetingTime.getStartTime(); k <= smeMeetingTime.getEndTime() - 1; k++) {
                        if (k < 0) {
                            continue;
                        }
                        meetingTime[k] += 1;
                    }
                }
                map.put(smeMeetingTime.getPersonNum(), meetingTime);
            }
            // 查看空闲人员
            int idlePersonnel = 0;
            for (int y = 1; y <= SMEPersonNum; y++) {
                if (!map.containsKey(y)) {
                    idlePersonnel++;
                }
            }
            if (idlePersonnel >= minJoinNum) {
                System.out.println("Case #" + (1 + i) + ": " + 0);
                continue;
            }
            int needValidPerson = minJoinNum - idlePersonnel;
            int resultCancelMeeting = Integer.MAX_VALUE;
            // 划分时间段
            for (int q = 0; q <= (maxTimeHour - meetingHour); q++) {
                List<Integer> personCancelMeetingNums = new ArrayList<>();
                Iterator<Map.Entry<Integer,int[]>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<Integer,int[]> entry = iterator.next();
                    int personNum = entry.getKey();
                    int[] singleMeeting = entry.getValue();
                    int judgeResult = judgeArrayNull(singleMeeting, q, q + meetingHour - 1);
                    personCancelMeetingNums.add(judgeResult);
                }
                Collections.sort(personCancelMeetingNums);

                int singleCancelMeetingNums = 0;
                for (int o = 0; o < needValidPerson; o++) {
                    singleCancelMeetingNums += personCancelMeetingNums.get(o);
                }
                resultCancelMeeting = Math.min(resultCancelMeeting, singleCancelMeetingNums);
            }
            System.out.println("Case #" + (1 + i) + ": " + resultCancelMeeting);
        }

    }

    public static int judgeArrayNull(int[] array, int start, int end) {
        int j = 0;
        for (int i = start; i <= end; i++) {
            j = Math.max(j, array[i]);
        }
        return j;
    }
}
