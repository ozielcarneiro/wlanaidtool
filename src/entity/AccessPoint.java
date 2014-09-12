/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

/**
 *
 * @author oziel
 */
public class AccessPoint {

    public double x;
    public double y;
    public double z;
    public double pot;
    public double ganhos;

    @Override
    public String toString(){
        return ("("+x+","+y+","+z+") "+pot+"dB+"+ganhos+"dB");
    }

}
