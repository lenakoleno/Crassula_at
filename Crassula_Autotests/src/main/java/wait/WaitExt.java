package wait;

public class WaitExt {
    public static void sleep(int sec) {
        if (sec > 60) {
            throw new IllegalArgumentException("Попытка остановить поток более чем на минуту");
        }
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
