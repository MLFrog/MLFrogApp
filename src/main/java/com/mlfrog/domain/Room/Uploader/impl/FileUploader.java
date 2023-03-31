package com.mlfrog.domain.Room.Uploader.impl;

import com.mlfrog.domain.Room.Uploader.Uploader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUploader implements Uploader {

	@Override
	public void upload() {
		log.info("I'm FileUploader");
	}

}
