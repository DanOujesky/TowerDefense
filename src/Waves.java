import org.ietf.jgss.GSSManager;

import java.util.ArrayList;

public class Waves {
    static int timer;
    private final static int SECOND = 60;
    static int enemiesCount;
    static boolean wave = false;
    static int waveCount = 0;
    static ArrayList<String> enemiesTypes = new ArrayList<>();
    public static void startWave(){
        timer = 0;
        enemiesCount = 0;
        wave = true;
        waveCount++;
        enemiesTypes.clear();
    }
    public static void update(){
        timer++;
        switch (waveCount){
            case 1:
                wave(15);
                wave1();
        }

    }
    public static void wave(int fullEnemies){
        if (enemiesCount >= fullEnemies) {
            wave = false;
            GamePanel.myWaveButton.setVisible(true);
        }
    }
    public static int countEnemyTypes(String enemyName){
        int count = 0;
        for (int i =0; i < enemiesTypes.size(); i++) {
            if (enemiesTypes.get(i).equals(enemyName)) count++;
        }
        return count;
    }
    public static void spawnEnemy(double spawnRate, String enemyName, int maxEnemyOFType){
        if (spawnRatePerSecond(spawnRate) && countEnemyTypes(enemyName) < maxEnemyOFType){
            EnemyManager.addEnemy(enemyName);
            enemiesTypes.add(enemyName);
            enemiesCount++;
        }
    }
    public static boolean spawnRatePerSecond(double seconds) {
        if (timer % (SECOND * seconds) == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void wave1(){
        spawnEnemy(3,"enemy1",0);
        spawnEnemy(3,"enemy2",5);
    }

}
