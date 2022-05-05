  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreaded.cianetti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class Server  
{
    ServerSocket ss;
    Socket so;
    BufferedWriter bw;
    BufferedReader br;
        
    public Server(int porta) 
    {
        try 
        {
            ss = new ServerSocket(porta);
            System.out.println("Server avviato");
            ss.setSoTimeout(3000);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Ascolto()
    {
        try 
        {
            so = ss.accept();
            System.out.println("Connessione stabilita");
            //inputStream
            br = new BufferedReader(new InputStreamReader(so.getInputStream()));
            //outuputStream
            bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));
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
