package OwnTest.JavaDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Tommy
 * @DATE: 2022/3/31
 */
public class Sound {

    private List<FrequencyWave> frequencyWaves = new ArrayList<>();

    private String type;

    public List<FrequencyWave> getFrequencyWaves() {
        return frequencyWaves;
    }

    public void setFrequencyWaves(List<FrequencyWave> frequencyWaves) {
        this.frequencyWaves = frequencyWaves;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        dealWithSound();
    }

    public void dealWithSound() {
        for (FrequencyWave frequencyWave : frequencyWaves) {
            frequencyWave.dealWith();
        }
    }

    public void add(FrequencyWave frequencyWave){
        frequencyWaves.add(frequencyWave);
    }
}
