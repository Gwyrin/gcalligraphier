/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcalligraphier.bean;

/**
 *
 * @author Vincent
 */
public class Params {
    int maxR;
    int maxG;
    int maxB;
    int minR;
    int minG;
    int minB;
    int maxSize;
    int minSize;
    boolean randomfonts;
    String mode;

    public Params() {
    }

    public boolean isRandomfonts() {
        return randomfonts;
    }

    public void setRandomfonts(boolean randomfonts) {
        this.randomfonts = randomfonts;
    }
        
    public int getMaxR() {
        return maxR;
    }

    public void setMaxR(int maxR) {
        this.maxR = maxR;
    }

    public int getMaxG() {
        return maxG;
    }

    public void setMaxG(int maxG) {
        this.maxG = maxG;
    }

    public int getMaxB() {
        return maxB;
    }

    public void setMaxB(int maxB) {
        this.maxB = maxB;
    }

    public int getMinR() {
        return minR;
    }

    public void setMinR(int minR) {
        this.minR = minR;
    }

    public int getMinG() {
        return minG;
    }

    public void setMinG(int minG) {
        this.minG = minG;
    }

    public int getMinB() {
        return minB;
    }

    public void setMinB(int minB) {
        this.minB = minB;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    
    
}
