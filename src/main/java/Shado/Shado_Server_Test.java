/**
 * by Jakub Wawak
 * kubawawak@gmail.com
 * all rights reserved 2022
 */
package Shado;

import Maintanance.Password_Validator;

import java.security.NoSuchAlgorithmException;

/**
 * Object for maintaining tests
 */
public class Shado_Server_Test {

    /**
     * Constructor
     */
    public Shado_Server_Test(){
        System.out.println("Shado Server Test loaded");
    }

    /**
     * Function for running tests
     */
    public void run() throws NoSuchAlgorithmException {
        Password_Validator pv = new Password_Validator("admin");
        System.out.println(pv.hash());
    }
}
