package edu.uga.ccrc.sgaf.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.uga.ccrc.simiantools.ms.om.data.Fragment;

public class FragmentFactory {
	
	public static List<Fragment> createFragments(){
		Scanner scan = new Scanner(System.in);
		List<Fragment> fragments = new ArrayList();
		Fragment f1 = new Fragment();
        f1.setNumber(Fragment.UNKNOWN);
        f1.setType(Fragment.TYPE_B);
        Fragment f2 = new Fragment();
        f2.setNumber(Fragment.UNKNOWN);
        f2.setType(Fragment.TYPE_Y);
        Fragment f3 = new Fragment();
        f3.setNumber(Fragment.UNKNOWN);
        f3.setType(Fragment.TYPE_A);
        Fragment f4 = new Fragment();
        f4.setNumber(Fragment.UNKNOWN);
        f4.setType(Fragment.TYPE_X);
        Fragment f5 = new Fragment();
        f5.setNumber(Fragment.UNKNOWN);
        f5.setType(Fragment.TYPE_C);
        Fragment f6 = new Fragment();
        f6.setNumber(Fragment.UNKNOWN);
        f6.setType(Fragment.TYPE_Z);
       
        System.out.println("Would you like to consider fragment B yes/no?");
        String selection = scan.nextLine();
        if(selection.trim().toLowerCase().equals("yes"))
        	fragments.add(f1);
        
        System.out.println("Would you like to consider fragment Y yes/no?");
        selection = scan.nextLine();
        if(selection.trim().toLowerCase().equals("yes"))
        	fragments.add(f2);
        
        System.out.println("Would you like to consider fragment A yes/no?");
        selection = scan.nextLine();
        if(selection.trim().toLowerCase().equals("yes"))
        	fragments.add(f3);
        
        System.out.println("Would you like to consider fragment X yes/no?");
        selection = scan.nextLine();
        if(selection.trim().toLowerCase().equals("yes"))
        	fragments.add(f4);
        
        System.out.println("Would you like to consider fragment C yes/no?");
        selection = scan.nextLine();
        if(selection.trim().toLowerCase().equals("yes"))
        	fragments.add(f5);
        
        System.out.println("Would you like to consider fragment Z yes/no?");
        selection = scan.nextLine();
        if(selection.trim().toLowerCase().equals("yes"))
        	fragments.add(f6);
        
        if(fragments.size() == 0){
        	fragments.add(f1);
        	fragments.add(f2);
        }
        return fragments;
	}

}
