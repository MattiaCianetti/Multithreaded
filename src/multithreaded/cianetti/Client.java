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
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Client class
class Client
{
        ServerSocket ss;
        Socket so;
        BufferedWriter bw;
        BufferedReader br;

    public Client(InetAddress ip, int porta) 
    {
        try 
        {
            so = new Socket(ip,porta);
             //inputStream
            br = new BufferedReader(new InputStreamReader(so.getInputStream()));
            //outuputStream
            bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Ascolto()
    {
        try 
        {
            so = ss.accept();
            System.out.println("Connessione stabilita");       
        } 
        catch (IOException ex) 
        {
            //eccezione IO
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Scrivi(String messaggio)
    {
        try 
        {
            bw.write(messaggio + "\n");
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        try
        {
            bw.flush();
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public String Leggi()
    {
        String ritorno = "";
        try 
        {
             ritorno = br.readLine();
        } 
        catch (IOException ex)
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ritorno ;
    }
}

