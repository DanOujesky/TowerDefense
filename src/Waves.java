import org.ietf.jgss.GSSManager;

import java.util.ArrayList;

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
        }
        if (showWaveIcon()) {
            wave = false;
            myWaveButton.setVisible(true);
        }
    }
    public boolean showWaveIcon(){
        return enemiesCount >= fullEnemies;
    }
    public int countEnemyTypes(String enemyName){
        int count = 0;
        for (int i =0; i < enemiesTypes.size(); i++) {
            if (enemiesTypes.get(i).equals(enemyName)) count++;
        }
        return count;
    }
    public void spawnEnemy(double spawnRate, String enemyName, int maxEnemyOFType, String enemyRecognition){
        if (spawnRatePerSecond(spawnRate) && countEnemyTypes(enemyRecognition) < maxEnemyOFType ){
            EnemyManager.addEnemy(enemyName);
            enemiesTypes.add(enemyName);
            enemiesCount++;
        }
    }
    public boolean spawnRatePerSecond(double seconds) {
        if (timer % (SECOND * seconds) == 0) {
            return true;
        } else {
            return false;
        }
    }
    public void wave1(){
        fullEnemies = 7;
        spawnEnemy(10,"enemy1",2, "enemy1");
        spawnEnemy(3,"enemy2",5, "enemy2");
    }
    public void wave2(){
        fullEnemies = 15;
        spawnEnemy(1,"enemy1",7, "enemy1");
        spawnEnemy(1,"enemy2",8, "enemy2");
    }
    public void wave3(){
        fullEnemies = 16;
        spawnEnemy(5,"enemy1",3, "enemy1");
        spawnEnemy(5,"enemy2",10, "enemy2");
        spawnEnemy(8,"enemy3",3, "enemy3");

    }
    public void wave4(){
        fullEnemies = 25;
        spawnEnemy(2,"enemy1",18, "enemy1");
        spawnEnemy(7,"enemy2",5, "enemy2");
        spawnEnemy(6,"enemy3",2, "enemy3");
    }
    public void wave5(){
        fullEnemies = 40;
        spawnEnemy(5,"enemy2",15, "enemy2");
        spawnEnemy(3,"enemy3",25, "enemy3");
    }
    public void wave6(){
        fullEnemies = 1;
        spawnEnemy(1,"enemy4",1, "enemy4");
    }
    public void wave7(){
        fullEnemies = 60;
        spawnEnemy(6,"enemy1",15, "enemy1");
        spawnEnemy(8,"enemy2",15, "enemy2");
        spawnEnemy(3,"enemy3",30, "enemy3");
    }
    public void wave8(){
        fullEnemies = 51;
        spawnEnemy(6,"enemy1",15, "enemy1");
        spawnEnemy(3,"enemy2",20, "enemy2");
        spawnEnemy(5,"enemy2",15, "enemy22");
        spawnEnemy(20,"enemy4",2, "enemy4");
    }
    public void wave9(){
        fullEnemies = 55;
        spawnEnemy(1,"enemy3",30, "enemy3");
        spawnEnemy(3,"enemy3",15, "enemy33");
        spawnEnemy(5,"enemy3",10, "enemy333");
    }
    public void wave10(){
        fullEnemies = 1;
        spawnEnemy(1, "enemy5",1, "enemy5");
    }
    public void wave11(){
        fullEnemies = 5;
        spawnEnemy(6, "enemy4",5, "enemy4");
    }
    public void wave12(){
        fullEnemies = 90;
        spawnEnemy(1,"enemy1",24, "enemy1");
        spawnEnemy(2,"enemy2",30, "enemy11");
        spawnEnemy(1,"enemy3",20, "enemy3");
        spawnEnemy(3,"enemy3",15, "enemy33");
        spawnEnemy(12, "enemy5",1,"enemy5");
    }

}
