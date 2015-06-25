/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.converter;

/**
 *
 * @author AION
 */
public class Validator {
    private static Validator instance = new Validator();
    
    private Validator() {
        
    }
    
    public static Validator getInstance()   {
        return instance;
    }
    
}
