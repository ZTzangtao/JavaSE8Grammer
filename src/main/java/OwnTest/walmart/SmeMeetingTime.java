package OwnTest.walmart;

import lombok.Data;

/**
 * @Author: Tommy
 * @DATE: 2023/2/5
 */
@Data
public class SmeMeetingTime {

    private int personNum;
    private int startTime;
    private int endTime;

    public SmeMeetingTime(int personNum, int startTime, int endTime) {
        this.personNum = personNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
