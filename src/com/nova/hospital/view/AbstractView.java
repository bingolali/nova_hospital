package com.nova.hospital.view;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * @author bingolalii
 */
public abstract class AbstractView {

    public static Scanner scanner() {
        return new Scanner(in);
    }

    public static void println(String content) {
        out.println(content);
    }
    public static void print(String content) {
        out.print(content);
    }

    public static int learnOptionFromUser() {
        out.print("Please enter your choice : ");
        return scanner().nextInt();
    }

}
