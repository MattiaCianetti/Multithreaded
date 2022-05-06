/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreaded.cianetti;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class AvvioClient 
{
     public static void main(String[] args) 
    {
         try {
             Client c = new Client(InetAddress.getLocalHost(), 2000);
             c.Leggi();
             c.Scrivi("ciao");
         } catch (UnknownHostException ex) {
             Logger.getLogger(AvvioClient.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
