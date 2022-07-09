/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.trust_based;

/**
 *
 
 */
public class TrustCalc{

                public static Double trustplus(Double x){
                    if(x<90.0){
                        
                        x=x*1.1;
                        return x;
                    }
                    else if((x>=90.0) && (x<95.0)){
                        
                        x=x*1.05;
                        return x;
                    }
                    else if((x>=95.0) && (x<99.0)){
                        
                            x=x*1.03;
                            return x;
                    }
                    else{
                            return x;
                    }
                }
                
                public static Double trustmin(Double x){
                
                    if(x>40.0){
                                x*=0.7;
                            return x;
                        }
                    else if((x<40.0)&&(x>5.0)){
                            x*=0.4;
                            return x;
                    }
                    else{
                    
                        return 0.0;
                    }
                }
                
                public static Double penalty(Double x){
                        
                                    if(x>5.0){
                                        x=x*0.97;
                                        return x;
                                    }
                                    else{
                                            return 0.0;
                                    
                                    }
                }

                
                public static Double reward(Double x){
                        
                                    if(x<99.0){
                                        x=x*1.05;
                                        return x;
                                    }
                                    else{
                                            return x;
                                    
                                    }
                }

}
