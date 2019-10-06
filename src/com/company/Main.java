package com.company;

import java.util.Random;

public class Main {
    public static int [] heroessHealth={250,250,250,250};
    public static int bossHealth = 700;
    public static int bossAttack = 50;
    public static int []heroesAttack = {20,20,20,10};
    public static String bossDefenceType = "";
    public static String[] heroesAttackType = {"Physical","Magical","Kinetic","hill"};
    public static int hillngHero =20;
    public static void main(String[] args) {
        int roundNumber = 1;
        printStatistics(1);
        while (!isFinished()){
            changeBossDefence();
            round(roundNumber);
            roundNumber++;
        }

    }
    public static void changeBossDefence(){
        Random r =new Random();
        int randomIndex = r.nextInt(3);
        bossDefenceType = heroesAttackType[randomIndex];
        System.out.println("Boss defence : "+ bossDefenceType);
    }
    public static void round(int number){
        heroesHit();
        bossHit();
        heroHill();
        printStatistics(number);
    }
    public static boolean isFinished(){
        if(bossHealth <=0){
            System.out.println("Heroes win!!!");
            return true;
        }
        if (heroessHealth[0] <= 0 && heroessHealth[1] <= 0 && heroessHealth[2] <= 0 ) {
            System.out.println("boss wins !!! ");
            return true;
        }
        return false;
    }
    public static void bossHit() {
        for (int i = 0; i < heroessHealth.length; i++) {
            heroessHealth[i] = heroessHealth[i] - bossAttack;

            if (bossDefenceType.equals(heroesAttackType[i])) {

            }

        }

    }
    public static void heroesHit(){

        for (int i = 0; i < heroesAttack.length; i++) {
            if (bossHealth >0 && heroessHealth [i] >0  ) {
                if (bossDefenceType.equals(heroesAttackType[i])) {
                    Random r = new Random();
                    int randomNumber = r.nextInt(9) + 2;
                    bossHealth = bossHealth - heroesAttack[i] * randomNumber;
                    System.out.println("Critical Damage" + (heroesAttack[i] * randomNumber));
                } else {
                    bossHealth = bossHealth - heroesAttack[i];
                }
                bossHealth = bossHealth - heroesAttack[i];


            }

        }

    }
    public static void heroHill (){
        for (int i = 0; i <heroessHealth.length ; i++) {
            if (heroessHealth[i] > 0 && heroessHealth[3]>0){
                heroessHealth [i] = heroessHealth[i] + hillngHero;
            }

        }
    }

    public static void printStatistics(int round){
        System.out.println("_______________________");
        System.out.println( "round "+ round);
        System.out.println("boss Health " + bossHealth);
        System.out.println("Warrior Health " + heroessHealth[0]);
        System.out.println("Magical Health " + heroessHealth[1]);
        System.out.println("Kinetic Health " + heroessHealth[2]);
        System.out.println("Hiller Health " + heroessHealth [3]);


        System.out.println("_______________________");
    }

}
