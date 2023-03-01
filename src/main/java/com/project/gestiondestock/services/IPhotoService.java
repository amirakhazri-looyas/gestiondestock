package com.project.gestiondestock.services;

import com.flickr4java.flickr.FlickrException;

import java.io.InputStream;

public interface IPhotoService {
    String savePhoto(InputStream photo, String title) throws FlickrException;
}
