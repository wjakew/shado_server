/**
 * by Jakub Wawak
 * kubawawak@gmail.com
 * all rights reserved 2022
 */
package Shado;

import Database.Database_Connector;
import Maintanance.ConsoleColors;

import java.util.ArrayList;
import java.util.Scanner;

public class Shado_Menu {

    /**
     * Constructor
     */

    Scanner console_scanner;
    ArrayList<String> input_history;
    boolean ready;
    Database_Connector database;

    /**
     * Constructor
     */
    public Shado_Menu(Database_Connector database){
        show_header();
        this.database = database;
        console_scanner = new Scanner(System.in);
        input_history = new ArrayList<>();
        ready = true;
    }

    /**
     * Function for running
     */
    public void run(){
        while(ready){
            System.out.print(ConsoleColors.RED_BOLD+"shado-server>"+ConsoleColors.RESET);
            String user_input = console_scanner.nextLine();
            input_history.add(user_input);
            mind(user_input);
        }
    }

    /**
     * Function for executing procedures on exit
     */
    public void exit(){
        System.out.println("Closing the server...");
    }

    /**
     * Function for showing info
     */
    public void info(){
        System.out.println("Current configuration:");
        database.configuration.show_configuration();
        System.out.println("Database:");
        if(database.connected){
            System.out.println("Connected! "+database.ip+" as "+database.database_user);
            System.out.println("Schema name: "+database.database_name);
        }
    }

    /**
     * Function for understanding user_input
     * @param user_input
     */
    public void mind(String user_input){
        System.out.print(ConsoleColors.GREEN_BOLD);
        for(String word : user_input.split(" ")){
            switch(word)
            {
                case "exit":
                {
                    exit();
                    System.exit(0);
                    break;
                }
                case "info":
                {
                    info();
                    break;
                }
            }
        }
        System.out.print(ConsoleColors.RESET);
    }


    /**
     * Function for showing header
     */
    public void show_header(){
        String header = " _ __ ___   ___ _ __  _   _ \n" +
                        "| '_ ` _ \\ / _ \\ '_ \\| | | |\n" +
                        "| | | | | |  __/ | | | |_| |\n" +
                        "|_| |_| |_|\\___|_| |_|\\__,_|\n";
        System.out.println(ConsoleColors.PURPLE_BOLD+header+ConsoleColors.RESET);
    }


}
