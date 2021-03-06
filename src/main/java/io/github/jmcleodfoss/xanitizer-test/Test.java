package io.github.jmcleodfoss.xanitizertest;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

class Test
{
	public static void main(String[] args)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();

		try {
			FileInputStream stream = new FileInputStream("test1.csv");
			try {
				Iterator<Integer> iter = al.iterator();
				while (iter.hasNext()) {
					Integer i = iter.next();
					String s = "\t" + i;
					System.out.println(s);
				}
			} finally {
				try {
					stream.close();
				} catch (final java.io.IOException e) {
					System.out.printf("There was a problem closing file%n");
				}
			}
		} catch (final java.io.FileNotFoundException e) {
			System.out.printf("File not found%n");
		}
	}
}
