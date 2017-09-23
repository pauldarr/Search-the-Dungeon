/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.searchTheDungeon.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Gibran Millan, Paul Darr, Les Aycock
 */
public class Riddle implements Serializable{
    
    //class instance variables
    private String riddle;
    private double answer1;
    private double answer2;
    private double answer3;
    private double answer4;
    private double correctAnswerNumber;
    
    //default constructor
    public Riddle() {
    }

    
    //getter and setter

    public String getRiddle() {
        return riddle;
    }

    public void setRiddle(String riddle) {
        this.riddle = riddle;
    }

    public double getAnswer1() {
        return answer1;
    }

    public void setAnswer1(double answer1) {
        this.answer1 = answer1;
    }

    public double getAnswer2() {
        return answer2;
    }

    public void setAnswer2(double answer2) {
        this.answer2 = answer2;
    }

    public double getAnswer3() {
        return answer3;
    }

    public void setAnswer3(double answer3) {
        this.answer3 = answer3;
    }

    public double getAnswer4() {
        return answer4;
    }

    public void setAnswer4(double answer4) {
        this.answer4 = answer4;
    }

    public double getCorrectAnswerNumber() {
        return correctAnswerNumber;
    }

    public void setCorrectAnswerNumber(double correctAnswerNumber) {
        this.correctAnswerNumber = correctAnswerNumber;
    }

    //toString, equals and hashCode

    @Override
    public String toString() {
        return "Riddle{" + "riddle=" + riddle + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4 + ", correctAnswerNumber=" + correctAnswerNumber + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.riddle);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.answer1) ^ (Double.doubleToLongBits(this.answer1) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.answer2) ^ (Double.doubleToLongBits(this.answer2) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.answer3) ^ (Double.doubleToLongBits(this.answer3) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.answer4) ^ (Double.doubleToLongBits(this.answer4) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.correctAnswerNumber) ^ (Double.doubleToLongBits(this.correctAnswerNumber) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Riddle other = (Riddle) obj;
        if (Double.doubleToLongBits(this.answer1) != Double.doubleToLongBits(other.answer1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.answer2) != Double.doubleToLongBits(other.answer2)) {
            return false;
        }
        if (Double.doubleToLongBits(this.answer3) != Double.doubleToLongBits(other.answer3)) {
            return false;
        }
        if (Double.doubleToLongBits(this.answer4) != Double.doubleToLongBits(other.answer4)) {
            return false;
        }
        if (Double.doubleToLongBits(this.correctAnswerNumber) != Double.doubleToLongBits(other.correctAnswerNumber)) {
            return false;
        }
        if (!Objects.equals(this.riddle, other.riddle)) {
            return false;
        }
        return true;
    }
    
    
    
}
