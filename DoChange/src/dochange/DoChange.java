/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dochange;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author steph
 */
public class DoChange {

    /**
     * @param args the command line arguments
     */
    public static void doChange(int x, int[] y) {
        int rest;
        double Dime, Nickel, Penny, Quarter, dollar;

        dollar = x / 100;
        rest = (int) (Math.floor(dollar) * 100);
        Quarter = (x - rest) / 25;
        rest += +(Math.floor(Quarter) * 25);
        Dime = (x - rest) / 10;
        rest += (Math.floor(Dime) * 10);
        Nickel = (x - rest) / 5;
        rest += (Math.floor(Nickel) * 5);
        Penny = x - rest;

        y[0] = (int) Penny;
        y[1] = (int) Nickel;
        y[2] = (int) Dime;
        y[3] = (int) Quarter;
        y[4] = (int) dollar;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int money;
        //change array
        int[] change = new int[5];
        for (;;) {
            System.out.print("Please enter the amount of money you would like to change: ");
            Scanner scanner = new Scanner(System.in);
            try {
                money = scanner.nextInt();
                if (money >= 0) {
                    //make change
                    doChange(money, change);

                    //print 
                    for (int i = change.length; i >= 0; i--) {
                        switch (i) {
                            case 0:
                                System.out.printf("%d Penny(ies)\n", change[i]);
                                break;
                            case 1:
                                System.out.printf("%d Nickel(s)\n", change[i]);
                                break;
                            case 2:
                                System.out.printf("%d Dimes\n", change[i]);
                                break;
                            case 3:
                                System.out.printf("%d Quarter(s)\n", change[i]);
                                break;
                            case 4:
                                System.out.printf("%d Dollar(s)\n", change[i]);
                                break;
                        }
                    }
                } //if negative
                else {
                    System.out.println("Wrong input");

                }
            } catch (InputMismatchException ex) {
                System.out.println("Wrong input");
            }

        }
    }

}
