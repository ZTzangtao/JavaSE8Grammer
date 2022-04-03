package OwnTest.JavaDesign;

/**
 * @Author: Tommy
 * @DATE: 2022/3/31
 */
public class Demo {

    public static void main(String[] args) {
        Sound sound = new Sound();
        SoundDeal soundDeal = new SoundDeal(sound);
        sound.setType("EventH");
        sound.setType("EventM");
        sound.setType("EventL");
    }

}
