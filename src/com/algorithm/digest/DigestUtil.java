package com.algorithm.digest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 快速获取文件MD5
 * 
 * @author robert
 *
 */
public class DigestUtil {
	public static String fastDigest(File file) {
		FileInputStream input = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			input = new FileInputStream(file);
			long len = file.length();
			long start = 0;
			if (file.length() > 1024 * 1024 * 1024 * 2) {
				len = 1024 * 1024 * 1024 * 1;
				start = len;
			}
			MappedByteBuffer mb = input.getChannel().map(MapMode.READ_ONLY, 0, len);
			md.update(mb);
			if (start != 0) {
				FileInputStream in = null;
				byte buffer[] = new byte[1024 * 1024 * 10];
				try {
					in = new FileInputStream(file);
					in.skip(len);
					int length = 0;
					while ((length = in.read(buffer)) != -1) {
						md.update(buffer, 0, length);
					}
					in.close();
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}
			return bytesTohex(md.digest());

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	public static String getFileMD5(File file) {
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[1024 * 1024 * 10];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			in.read(buffer, 0, 1);
			while ((len = in.read(buffer)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bytesTohex(digest.digest());
	}

	/**
	 * 字节转换为Stirng
	 * 
	 * 快速简单实现方式 BigInteger bigInt = new BigInteger(1, digest.digest()); <br>
	 * return bigInt.toString(16);
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesTohex(byte[] bytes) {
		StringBuffer strbuf = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			strbuf.append(Character.forDigit((bytes[i] & 0xf0) >> 4, 16));
			strbuf.append(Character.forDigit((bytes[i] & 0x0f), 16));
		}
		return strbuf.toString();

	}
}
