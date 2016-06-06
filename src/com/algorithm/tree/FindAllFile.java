package com.algorithm.tree;

import java.io.File;
import java.util.ArrayList;

/**
 * 文件查找算法
 * 
 * @author chao
 *
 */
public class FindAllFile {
	private ArrayList<File> files = new ArrayList<>();

	public ArrayList<File> getFiles() {
		return files;
	}

	public void findAllFiles(File file) {
		if (file == null) {
			return;
		} else if (file.isFile()) {
			files.add(file);
		} else {
			for (File curfile : file.listFiles()) {
				findAllFiles(curfile);
			}
		}
	}

	public static void main(String[] args) {
		FindAllFile filefinder = new FindAllFile();
		filefinder.findAllFiles(new File("D:\\code\\git\\simplealgorithm\\bin"));
		System.out.println(filefinder.getFiles());
	}
}
