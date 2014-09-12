/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package io;

/**
 *
 * @author 07070040
 */
public interface IO {

    public void save(String nomeArq, String conteudo) throws Exception;
    public String read(String nomeArq) throws Exception;
}
