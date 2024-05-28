package Game;

import java.util.ArrayList;

/**
 * this class have all the waves
 */
public class Waves {
    int timer;
    private final int SECOND = 60;
    int enemiesCount;
    int fullEnemies;
    int waveCount = 0;
    boolean wave;
    boolean resetColdowns;
    ArrayList<String> enemiesTypes = new ArrayList<>();
    MyWaveButton myWaveButton;

    /**
     * this method will start the wave
     * @param myWaveButton
     */
    public void startWave(MyWaveButton myWaveButton){
        this.myWaveButton = myWaveButton;
        resetColdowns = true;
        waveCount++;
        CoinBar.COINS += 3;
        timer = 0;
        enemiesCount = 0;
        wave = true;
        enemiesTypes.clear();
    }

    /**
     * this method will update waves
     */
    public void update(){
        resetColdowns = false;
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
            case 7:
                wave7();
                break;
            case 8:
                wave8();
                break;
            case 9:
                wave9();
                break;
            case 10:
                wave10();
                break;
            case 11:
                wave11();
                break;
            case 12:
                wave12();
                break;
            case 13:
                break;
        }
        if (showWaveIcon()) {
            wave = false;
            if (waveCount < 12) {
                myWaveButton.setVisible(true);
            }
        }
    }

    /**
     * this method will end waves
     */
    public void end (){
        if (EnemyManager.getEnemies().isEmpty()) {
            waveCount = 13;
        }
    }

    public int getWaveCount() {
        return waveCount;
    }

    /**
     * if all the enemies from the wave has been spawned it will return true
     * @return
     */
    public boolean showWaveIcon(){
        return enemiesCount >= fullEnemies;
    }

    /**
     * it will count enemies according to their name
     * @param enemyName
     * @return
     */
    public int countEnemyTypes(String enemyName){
        int count = 0;
        for (int i =0; i < enemiesTypes.size(); i++) {
            if (enemiesTypes.get(i).equals(enemyName)) count++;
        }
        return count;
    }

    /**
     * this method will spawn enemy
     * @param spawnRate
     * @param enemyName
     * @param maxEnemyOFType
     * @param enemyRecognition
     */
    public void spawnEnemy(double spawnRate, String enemyName, int maxEnemyOFType, String enemyRecognition){
        if (spawnRatePerSecond(spawnRate) && countEnemyTypes(enemyRecognition) < maxEnemyOFType ){
            EnemyManager.addEnemy(enemyName);
            enemiesTypes.add(enemyName);
            enemiesCount++;
        }
    }

    /**
     * this method will return true if enemy can be spawned
     * @param seconds
     * @return
     */
    public boolean spawnRatePerSecond(double seconds) {
        if (timer % (SECOND * seconds) == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * this method represents wave1
     */
    public void wave1(){
        fullEnemies = 7;
        spawnEnemy(10,"enemy1",2, "enemy1");
        spawnEnemy(3,"enemy2",5, "enemy2");
    }
    /**
     * this method represents wave2
     */
    public void wave2(){
        fullEnemies = 15;
        spawnEnemy(1,"enemy1",7, "enemy1");
        spawnEnemy(1,"enemy2",8, "enemy2");
    }
    /**
     * this method represents wave3
     */
    public void wave3(){
        fullEnemies = 16;
        spawnEnemy(5,"enemy1",3, "enemy1");
        spawnEnemy(5,"enemy2",10, "enemy2");
        spawnEnemy(8,"enemy3",3, "enemy3");

    }
    /**
     * this method represents wave4
     */
    public void wave4(){
        fullEnemies = 25;
        spawnEnemy(2,"enemy1",18, "enemy1");
        spawnEnemy(7,"enemy2",5, "enemy2");
        spawnEnemy(6,"enemy3",2, "enemy3");
    }
    /**
     * this method represents wave5
     */
    public void wave5(){
        fullEnemies = 40;
        spawnEnemy(5,"enemy2",15, "enemy2");
        spawnEnemy(3,"enemy3",25, "enemy3");
    }
    /**
     * this method represents wave6
     */
    public void wave6(){
        fullEnemies = 1;
        spawnEnemy(1,"enemy4",1, "enemy4");
    }
    /**
     * this method represents wave7
     */
    public void wave7(){
        fullEnemies = 60;
        spawnEnemy(6,"enemy1",15, "enemy1");
        spawnEnemy(8,"enemy2",15, "enemy2");
        spawnEnemy(3,"enemy3",30, "enemy3");
    }
    /**
     * this method represents wave8
     */
    public void wave8(){
        fullEnemies = 51;
        spawnEnemy(6,"enemy1",15, "enemy1");
        spawnEnemy(3,"enemy2",20, "enemy2");
        spawnEnemy(5,"enemy2",15, "enemy22");
        spawnEnemy(20,"enemy4",2, "enemy4");
    }
    /**
     * this method represents wave9
     */
    public void wave9(){
        fullEnemies = 55;
        spawnEnemy(1,"enemy3",30, "enemy3");
        spawnEnemy(3,"enemy3",15, "enemy33");
        spawnEnemy(5,"enemy3",10, "enemy333");
    }
    /**
     * this method represents wave10
     */
    public void wave10(){
        fullEnemies = 1;
        spawnEnemy(1, "enemy5",1, "enemy5");
    }
    /**
     * this method represents wave11
     */
    public void wave11(){
        fullEnemies = 5;
        spawnEnemy(6, "enemy4",5, "enemy4");
    }
    /**
     * this method represents wave12
     */
    public void wave12(){
        fullEnemies = 1;
        spawnEnemy(1,"enemy1",24, "enemy1");
        spawnEnemy(2,"enemy2",30, "enemy11");
        spawnEnemy(1,"enemy3",10, "enemy3");
        spawnEnemy(3,"enemy3",15, "enemy33");
        spawnEnemy(12, "enemy5",1,"enemy5");
    }

    public int getEnemiesCount() {
        return enemiesCount;
    }

    public void setEnemiesCount(int enemiesCount) {
        this.enemiesCount = enemiesCount;
    }
}
