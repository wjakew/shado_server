/**
 * by Jakub Wawak
 * kubawawak@gmail.com
 * all rights reserved 2022
 */
package Server;

import java.net.ServerSocket;

/**
 * Main Server object
 */
public class Server {

    int server_port = 6969;
    ServerSocket server_socket;

    /**
     * Constructor
     */
    public Server() {
        try {
            server_socket = new ServerSocket(server_port);

        }catch(Exception e){

        }
    }

}
