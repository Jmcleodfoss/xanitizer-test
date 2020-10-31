package io.github.jmcleodfoss.xanitizertest;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

class TestLoop
{
	public static void main(String[] args)
	{
		try {
			FileInputStream stream = new FileInputStream("test2.csv");
			try {
				for (int i = 0; i < 10; ++i) {
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
