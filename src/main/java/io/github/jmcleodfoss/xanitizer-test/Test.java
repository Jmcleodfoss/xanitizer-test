package io.github.jmcleodfoss.xanitizertest;

import java.nio.channels.FileChannel;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;

class Test
{
	public static void main(String[] args)
	{
		ArrayList<Integer> data = new ArrayList<Integer>();

		try {
			java.io.FileInputStream stream = new java.io.FileInputStream("test.csv");
			try {
				java.util.Iterator<Integer> childIterator = data.iterator();
				while (childIterator.hasNext()) {
					Integer child = childIterator.next();
					System.out.println("\t" + child);
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
