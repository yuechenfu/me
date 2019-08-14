package com.pib.property.exception.parameter;

import org.springframework.web.multipart.MultipartFile;

import com.pib.property.exception.ParameterException;


public class MultipartFileParameter {
	private String infoOfValue;
	private MultipartFile value;
	public MultipartFileParameter(String infoOfValue, MultipartFile value) {
		this.infoOfValue = infoOfValue;
		this.value = value;
	}
	public MultipartFileParameter isImage() throws ParameterException {
		String type = value.getOriginalFilename().substring(value.getOriginalFilename().lastIndexOf(".")+1);
		if (!type.equals("png") && !type.equals("jpg") && !type.equals("jpeg") && !type.equals("gif") && !type.equals("bmp")) {
			throw new ParameterException(infoOfValue + " 不能为 " + value.toString() + (type!=null?", 后缀 ."+type:"") + ", 类型不是图片");
		}
		return this;
	}
	public MultipartFileParameter isAudio() throws ParameterException {
		String type = value.getOriginalFilename().substring(value.getOriginalFilename().lastIndexOf(".")+1);
		if (!type.equals("ogg") && !type.equals("mp3") && !type.equals("wav") && !type.equals("aac")) {
			throw new ParameterException(infoOfValue + " 不能为 " + value.toString() + (type!=null?", 后缀 ."+type:"") + ", 类型不是音频");
		}
		return this;
	}
}
