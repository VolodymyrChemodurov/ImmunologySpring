package com.immunology.logic.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class URIUtils {

	private static final Logger LOG = LoggerFactory.getLogger(URIUtils.class); 
	
	public static String decodePathVariable(String uri, int place) {
		String result = null;
		try {
			String decodedUri = URLDecoder.decode(uri, "UTF-8");
			result = decodedUri.split("/")[place + 1];
		} catch (UnsupportedEncodingException e) {
			LOG.error(uri);
		}
		return result;
	}
}
