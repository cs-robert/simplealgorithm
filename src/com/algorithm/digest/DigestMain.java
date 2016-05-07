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

public class DigestMain {

	public static void main(String[] args) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String file = DigestMain.class.getResource("/t").getFile();
		File f = new File(file);
		FileInputStream input = null;
		try {
			input = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File fo = new File(DigestMain.class.getResource("/").getPath(), "a");
		if (!fo.exists()) {
			try {
				fo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			DigestOutputStream outputStream = new DigestOutputStream(
					new FileOutputStream(fo), digest);
			byte[] buf = new byte[1024 * 1024];
			int num = 0;
			while (true) {
				try {
					num = input.read(buf);
					if (num == -1)
						break;
					outputStream.write(buf, 0, num);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getFileMD5(String file) {
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[1024];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			while ((len = in.read(buffer, 0, 1024)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}

	public static String onlydigest() {
		InputStream input = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			input = DigestMain.class.getResourceAsStream("/t");
			byte[] buf = new byte[1024 * 1024];
			int num = 0;
			while (true) {
				try {
					num = input.read(buf);
					if (num == -1)
						break;
					md.update(buf, 0, num);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return bytesTohex(md.digest());

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

	public static String fastdigest() {
		FileInputStream input = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			String file = DigestMain.class.getResource("/t").getFile();
			File f = new File(file);
			input = new FileInputStream(f);
			MappedByteBuffer mb = input.getChannel().map(MapMode.READ_ONLY, 0,
					f.length());
			md.update(mb);
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
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String getFileMD5String() throws IOException,
			NoSuchAlgorithmException {
		MessageDigest messagedigest = MessageDigest.getInstance("md5");
		String file = DigestMain.class.getResource("/t").getFile();
		File f = new File(file);
		FileInputStream in = new FileInputStream(f);
		FileChannel ch = in.getChannel();
		MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,
				f.length());
		messagedigest.update(byteBuffer);
		in.close();
		return bytesTohex(messagedigest.digest());
	}

	public static String bytesTohex(byte[] bytes) {
		StringBuffer strbuf = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			strbuf.append(Character.forDigit((bytes[i] & 0xf0) >> 4, 16));
			strbuf.append(Character.forDigit((bytes[i] & 0x0f), 16));
		}
		return strbuf.toString();

	}
}
