package io.github.jmcleodfoss.xanitizertest;

import java.nio.channels.FileChannel;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;

class Test
{
	static class UnknownStorageTypeException extends Exception
	{
		UnknownStorageTypeException()
		{
			super("Unknown Storage Type");
		}
	}

	static class Directory
	{
		ArrayList<DirectoryEntry> entries;

		Directory()
		{
		}

		ArrayList<DirectoryEntry> getChildren(DirectoryEntry de)
		{
			return entries;
		}
	}	

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

		for (String a: args) {
			System.out.println(a);
			try {
				java.io.File file = new java.io.File(a);
				java.io.FileInputStream stream = new java.io.FileInputStream(file);
				try {
					FileChannel fc = stream.getChannel();
					try {
//						MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());

//						Directory directory = new Directory();

//						for (int i = 0; i < directory.entries.size(); ++i){
							java.util.Iterator<DirectoryEntry> childIterator = data.iterator();
							while (childIterator.hasNext()) {
									DirectoryEntry child = childIterator.next();
									System.out.println("\t" + child);
							}
//						}
//					} catch (final java.io.IOException e) {
//						System.out.printf("There was a problem reading from file %s%n", a);
					} finally {
						try {
							fc.close();
						} catch (final java.io.IOException e) {
							System.out.printf("There was a problem closing filechannel for stream for file %s%n", a);
						}
					}
				} finally {
					try {
						stream.close();
					} catch (final java.io.IOException e) {
						System.out.printf("There was a problem closing file %s%n", a);
					}
				}
			} catch (final java.io.FileNotFoundException e) {
				System.out.printf("File %s not found%n", a);
			}
		}
	}
}
