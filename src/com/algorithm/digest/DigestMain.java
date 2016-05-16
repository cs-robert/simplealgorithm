package com.algorithm.digest;

import java.io.File;

/**
 * 
 * @author robert
 *
 */
public class DigestMain {

	public static void main(String[] args) {

		String file = DigestMain.class.getResource("/t").getFile();
		File f = new File(file);
		long start = System.currentTimeMillis();
		System.out.println("" + DigestUtil.getFileMD5(f));
		System.out.println("time: " + (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		System.out.println("" + DigestUtil.fastDigest(f));
		System.out.println("time: " + (System.currentTimeMillis() - start));

	}

}
