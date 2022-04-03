package OwnTest.JavaDesign;

/**
 * @Author: Tommy
 * @DATE: 2022/3/31
 */
public class SoundDeal extends FrequencyWave {

    public SoundDeal(Sound sound){
        this.sound = sound;
        this.sound.add(this);
    }

    @Override
    public void dealWith() {
        if("EventH".equals(sound.getType())){
            System.out.println("H1 在处理");
        }else if("EventM".equals(sound.getType())){
            System.out.println("M1 在处理");
        }else {
            System.out.println("L1，L2 在处理");
        }

    }
}
