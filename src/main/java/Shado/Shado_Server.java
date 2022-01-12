/**
 * by Jakub Wawak
 * kubawawak@gmail.com
 * all rights reserved 2022
 */
package Shado;

import Database.Database_Connector;
import Maintanance.Configuration;
import Maintanance.ConsoleColors;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

/**
 * Main program class
 */
public class Shado_Server {

    public static String version = "v.1.0.0";
    public static String build = "SHADO-120122REV1";
    public static int debug = 0;

    /**
     * Main program function
     * @param args
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, SQLException, IOException {
        show_header();
        Database_Connector database = new Database_Connector();
        if(debug == 0){
            Configuration configuration = new Configuration();
            try{
                configuration.read_file();
                configuration.load_file_data();
            }catch(Exception e){
                System.out.println("Failed to load configuration file!\n ("+e.toString()+")");
                configuration.load_user_data();
                configuration.copy_configuration();
            }
            // connecting to the database
            database.configuration = configuration;
            try{
                database.connect();
                // running shado menu
                Shado_Menu menu = new Shado_Menu(database);
                menu.run();
            }catch(Exception e){
                System.out.println("Failed to connect to database ("+e.toString()+")");
                System.exit(1);
            }
        }
        else{
            System.out.println("Debug mode on");
            Shado_Server_Test sst = new Shado_Server_Test();
            sst.run();
        }
    }


    /**
     * Function for showing header
     */
    public static void show_header(){
        String header = "     _               _       \n" +
                        " ___| |__   __ _  __| | ___  \n" +
                        "/ __| '_ \\ / _` |/ _` |/ _ \\ \n" +
                        "\\__ \\ | | | (_| | (_| | (_) |\n" +
                        "|___/_| |_|\\__,_|\\__,_|\\___/ \n";
        header = header +"  "+ version + "/" + build;
        System.out.println(ConsoleColors.PURPLE_BOLD+header+ConsoleColors.RESET);
    }
}
