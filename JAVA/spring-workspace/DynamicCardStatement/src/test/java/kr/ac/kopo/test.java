package kr.ac.kopo;

import org.apache.log4j.Logger;

public class test {
    private final Logger logger = Logger.getLogger(test .class);

    public void logTest(String msg){
       try{
          logger.info(msg);
       }catch(Exception e){
          logger.error("got error",e);
       }
    }

    public static void main(String[] args) {
	test obj = new test();
	obj.logTest("info+"+1+1+"rmation");
    }
}
