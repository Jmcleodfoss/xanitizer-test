package io.github.jmcleodfoss.xanitizertest;

import java.nio.channels.FileChannel;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;

class Test
{
	static class DirectoryEntry
	{
	}

	/** Test this class by printing out the directory and the list of children for each node.
	*	@param	args	The msg file(s) to display the directory(ies) of.
	*/
	@SuppressWarnings("PMD.DoNotCallSystemExit")
	public static void main(String[] args)
	{
		if (args.length == 0) {
			System.out.println("use:\n\tjava io.github.jmcleodfoss.mst.Directory msg-file [msg-file] ...");
			System.exit(1);
		}

		ArrayList<DirectoryEntry> data = new ArrayList<DirectoryEntry>();

		try {
			java.io.File file = new java.io.File("test.csv");
			java.io.FileInputStream stream = new java.io.FileInputStream(file);
			try {
				try {
					java.util.Iterator<DirectoryEntry> childIterator = data.iterator();
					while (childIterator.hasNext()) {
							DirectoryEntry child = childIterator.next();
							System.out.println("\t" + child);
					}
				} finally {
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
