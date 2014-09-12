/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io;
import java.io.*;
/**
 *
 * @author 07070040
 */
public class IOImpl implements IO{
    public void save(String nomeArq, String cont) throws Exception{
        try{
            File f = new File(nomeArq);
            FileWriter fw = new FileWriter(f);
            fw.write(cont);
            fw.flush();
            fw.close();
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        }
        catch(IOException e){
            
            throw e;
        }       
    }
    public String read(String nomeArq) throws Exception{
        try{
            String conteudo = "";
            int size = 0;
            char[] in = new char[50];
            File f = new File(nomeArq);
            FileReader fr = new FileReader(f);
            size = fr.read(in);
            while(size!=-1){
                for(char c:in){
                    conteudo += (c);
                }
                in = new char[50];
                size = fr.read(in);
            }
            fr.close();
            //System.out.println(conteudo);
            return (conteudo.trim());
        }
        catch(IOException e){ 
            
            throw e;
        }
    }
}
