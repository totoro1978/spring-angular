package com.totoro4.webservice.models;

import java.util.Iterator;
import java.util.List;

public class ResponseStock {

	List<Item> items;
	String respTime;

	public String toString() {
		String listOfItems = "";
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			listOfItems += it.next().getName() + " ";
		}
		
		return listOfItems + " " + this.respTime;
	}
}
