/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreaded.cianetti;

/**
 *
 * @author Studente
 */
public class AvvioServer 
{
     public static void main(String[] args)
     {
        Server s = new Server(2000);
        s.Ascolto();
        s.Scrivi("benvenuto client");
        s.Leggi();
    }
    
}
