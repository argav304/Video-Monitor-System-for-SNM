
package com.trust_based;


import javax.ejb.*;

@Singleton
public class  ScheduledDBUpdate{
                @Schedule(hour="*", minute="*/30", second="0", persistent=false)
                        public void DateCheck() {
                            final String path="C:\\Users\\bharghava\\OneDrive\\Desktop\\project\\updateLog.txt";
                                                        if(DateChecker.test()){
                                                        Write.write("DATE:"+Write.date(),path);
                                                        }
                        }

                    @Schedule(hour="*", minute="*/1", second="0", persistent=false)
    public void DatabaseUpdate() {
                                    final String path="C:\\Users\\bharghava\\OneDrive\\Desktop\\project\\updateLog.txt";
                                    Write.write("DATABASE UPDATES AT TIME:"+Write.time(),path);
                                    VideoCheck.videoCheck();
    }
    
 }
