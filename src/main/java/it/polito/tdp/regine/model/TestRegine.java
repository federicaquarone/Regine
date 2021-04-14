package it.polito.tdp.regine.model;

import java.util.ArrayList;
import java.util.List;

public class TestRegine {
	
public static void main(String[] args) {
	Regine r= new Regine();
	
	List<Integer> soluzione=new ArrayList<Integer>();
	soluzione=r.risolvi(4);
	System.out.println(soluzione);
}
}
