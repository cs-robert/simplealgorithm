package com.algorithm.digest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
