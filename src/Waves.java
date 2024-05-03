import org.ietf.jgss.GSSManager;

import java.util.ArrayList;

public class Waves {
    static int timer;
    private final static int SECOND = 60;
    static int enemiesCount;
    static int fullEnemies;
    static int waveCount = 0;
    static boolean wave;
    static ArrayList<String> enemiesTypes = new ArrayList<>();
    public static void startWave(){
        waveCount++;
        timer = 0;
        enemiesCount = 0;
        wave = true;
        enemiesTypes.clear();
    }
    public static void update(){
        timer++;
        switch (waveCount){
            case 1:
                wave1();
                break;
            case 2:
                wave2();
                break;
            case 3:
                wave3();
                break;
            case 4:
                wave4();
                break;
            case 5:
                wave5();
                break;
            case 6:
                wave6();
                break;
        }
        if (showWaveIcon()) {
            wave = false;
            GamePanel.myWaveButton.setVisible(true);
        }
    }
    public static boolean showWaveIcon(){
        return enemiesCount >= fullEnemies;
    }
    public static int countEnemyTypes(String enemyName){
        int count = 0;
        for (int i =0; i < enemiesTypes.size(); i++) {
            if (enemiesTypes.get(i).equals(enemyName)) count++;
        }
        return count;
    }
    public static void spawnEnemy(double spawnRate, String enemyName, int maxEnemyOFType){
        if (spawnRatePerSecond(spawnRate) && countEnemyTypes(enemyName) < maxEnemyOFType ){
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
        fullEnemies = 7;
        spawnEnemy(10,"enemy1",2);
        spawnEnemy(3,"enemy2",5);
    }
    public static void wave2(){
        fullEnemies = 15;
        spawnEnemy(1,"enemy1",7);
        spawnEnemy(1,"enemy2",8);
    }
    public static void wave3(){
        fullEnemies = 16;
        spawnEnemy(5,"enemy1",3);
        spawnEnemy(5,"enemy2",10);
        spawnEnemy(8,"enemy3",3);

    }
    public static void wave4(){
        fullEnemies = 25;
        spawnEnemy(2,"enemy1",18);
        spawnEnemy(7,"enemy2",5);
        spawnEnemy(6,"enemy3",2);
    }
    public static void wave5(){
        fullEnemies = 40;
        spawnEnemy(5,"enemy2",10);
        spawnEnemy(2,"enemy3",30);
    }
    public static void wave6(){
        fullEnemies = 1;
        spawnEnemy(1,"enemy4",1);
    }

}
