package io.github.jmcleodfoss.xanitizertest;

import java.util.ArrayList;

class Test
{
	public static void main(String[] args)
	{
		ArrayList<Integer> al = new ArrayList<Integer>();

		try {
			java.io.FileInputStream stream = new java.io.FileInputStream("test.csv");
			try {
				java.util.Iterator<Integer> iter = al.iterator();
				while (iter.hasNext()) {
					Integer i = iter.next();
					System.out.println("\t" + i);
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
