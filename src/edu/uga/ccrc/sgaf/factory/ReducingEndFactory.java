package edu.uga.ccrc.sgaf.factory;

import java.util.Scanner;

import edu.uga.ccrc.simiantools.ms.om.data.ReducingEnd;

public class ReducingEndFactory {
	
	public static ReducingEnd createReducingEnd(){
		ReducingEnd re = new ReducingEnd();
		Scanner scan = new Scanner(System.in);
        System.out.println("1- freeEnd");
        System.out.println("2- redEnd");
        String selection = scan.nextLine();
        switch(selection){
        case("1"):
        	re.setLabel("freeEnd");
			re.setType("freeEnd");
			break;
        case("2"):
        	re.setLabel("redEnd");
			re.setType("redEnd");
		break;
		default:
			re.setLabel("freeEnd");
			re.setType("freeEnd");
        }
        return re;
	}

}
