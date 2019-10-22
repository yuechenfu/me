package com.admin.exception.parameter;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.admin.exception.ParameterException;


public class FileParameter {
	private String infoOfValue;
	private File value;
	public FileParameter(String infoOfValue, File value) {
		this.infoOfValue = infoOfValue;
		this.value = value;
	}
	public FileParameter isImage() throws ParameterException {
		try {
			ImageInputStream imageInputStream = ImageIO.createImageInputStream(value);
			Iterator<ImageReader> iterator = ImageIO.getImageReaders(imageInputStream);
			iterator.next().getFormatName();
			imageInputStream.close();
		} catch (NullPointerException | IOException | NoSuchElementException | IllegalArgumentException e) {
			throw new ParameterException(infoOfValue + " 不能为 " + value.toString() + ", 类型不是图片");
		}
		return this;
	}
	public FileParameter isAudio() throws ParameterException {
		String type = value.getName().substring(value.getName().lastIndexOf(".")+1);
		if (!type.equals("ogg") && !type.equals("mp3") && !type.equals("wav")) {
			throw new ParameterException(infoOfValue + " 不能为 " + value.toString() + ", 类型不是音频");
		}
		return this;
	}
}
