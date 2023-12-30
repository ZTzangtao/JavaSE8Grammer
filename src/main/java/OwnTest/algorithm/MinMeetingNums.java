package OwnTest.algorithm;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
/**
 * @Author: Tommy
 * @DATE: 2023/2/4
 */
public class MinMeetingNums {

    static class Meeting{
        int index;
        int start;
        int end;

        public Meeting(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
    /**
     3 2 2 6
     4
     1 0 2
     2 1 3
     2 2 4
     3 3 6

     * @param args
     * result 0
     */
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:\\Users\\zt\\Desktop\\code\\sample_ts1_input.txt");
        BufferedReader br = new BufferedReader(fr);
//        List<String> list = new ArrayList<>();
        String line = null;
        String param = null;
        int index = 0,num = 0,total = 0;
        List<Meeting>[] arrays = null;
        while ((line = br.readLine()) != null) {
            //首行
            if(0 == index){
                index++;
                continue;
            }
            //3 2 2 6
            if(0 < index && null == param){
                param = line;
                arrays = new ArrayList[Integer.parseInt(param.split(" ")[3]) + 1];
                continue;
            }
            //会议数量
            if(1 == index){
                total = Integer.parseInt(line);
                index++;
                continue;
            }
            //存在会议
            if(null != arrays){
                String[] tmp = line.split(" ");
                Meeting meeting = new Meeting(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]));
                for (int i = meeting.start; i < meeting.end; i++) {
                    if(null == arrays[i]){
                        arrays[i] = new ArrayList<>();
                    }
                    arrays[i].add(meeting);
                }
                num++;

                if(num == total){
                    String[] tmps = param.split(" ");
                    int count = Integer.parseInt(tmps[0]);
                    int min = Integer.parseInt(tmps[1]);
                    int hour = Integer.parseInt(tmps[2]);
                    int lastRes = Integer.MAX_VALUE;
                    for (int i = 0; i < arrays.length; i++) {
                        Set<Meeting> set = new HashSet<>();
                        //0 - 1,1
                        //1 2,1 2
                        for (int j = i; j < i + hour && j < arrays.length; j++) {
                            List<Meeting> list = arrays[j];
                            if(null != list){
                                set.addAll(list);
                            }
                        }
                        //先找到空闲人的数量，如果符合则 lastRes = 0;
                        //如果不符合，则找到要删除的会议数量
                        //应该以人分组，key分人编号，value=会议数量
                        //找到要删除的最小会议数量就是遍历上面分组，缺少两个人，就减去这俩人所有的会议，这里找到最少会议的人即可
                        //(count - set.size()) = 空闲会议
                        int empty = count - set.size();
                        //min - 空闲会议 = 需要删除的会议
                        if(min <= empty){
                            lastRes = 0;
                            break;
                        }
                        lastRes = Math.min(lastRes,min - empty);
                    }
                    System.out.println(lastRes);
                    num = 0;
                    total = 0;
                    index = 1;
                    param = null;
                    arrays = null;
                }
            }
            //System.out.println("第" + i + "行：" + line);
//            list.add(line);
        }
//
////        list.forEach(System.out::println);
//        Integer allNums = Integer.valueOf(list.get(0));
//        // case group
//        List<List<String>> singleCases = new ArrayList<>();
//        for(int i = 1; i < list.size(); i++) {
//            if (list.get(i).length() >= 7) {
//                List<String> singleCase = new ArrayList<>();
//                singleCase.add(list.get(i));
//                singleCase.add(list.get(i + 1));
//                Integer singleAllNums = Integer.valueOf(list.get(i + 1));
//                for(int j = 1; j <= singleAllNums; j++) {
//                    singleCase.add(list.get(i + 1 + j));
//                }
//                singleCases.add(singleCase);
//            }
//        }
//        for (int i = 0; i < singleCases.size(); i++) {
//            List<String> c = singleCases.get(i);
//            String[] firstLine =  c.get(0).split(" ");
//            Integer SMEPersonNum = Integer.valueOf(firstLine[0]);
//            Integer minJoinNum = Integer.valueOf(firstLine[1]);
//            Integer meetingHour = Integer.valueOf(firstLine[2]);
//            Integer maxTimeHour = Integer.valueOf(firstLine[3]);
//            if (minJoinNum == SMEPersonNum && meetingHour == maxTimeHour) {
//                System.out.println("Case #" + (1 + i) + ": " + c.get(1));
//                continue;
//            }
//            if () {
//
//            }
//
//            maxTimeHour / meetingHour
////            System.out.println(Arrays.asList(firstLine));
//            Integer singleAllNums = Integer.valueOf(c.get(1));
////            System.out.println(singleAllNums);
////            TreeMap
//            for(int j = 1; j <= singleAllNums; j++) {
////                System.out.println( c.get(1+i));
//                // 计算出每个人的空闲区间
//
//
//                c.get(1+j);
//
//            }
//        }

    }
}
