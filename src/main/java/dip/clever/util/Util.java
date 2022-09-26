package dip.clever.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import dip.clever.model.User;

public class Util {
	public static final String path = "C:\\Users\\8\\Documents\\GitHub\\TeamProject\\src\\main\\resources\\static\\imgs\\profile\\"; 
		
	// 비밀번호 암호화
	public String encode(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-512");
			messageDigest.update(password.getBytes());
		} catch (NoSuchAlgorithmException e) {
		}		
		return hashcode(messageDigest.digest());		
	}
	
	// 데이터 반환
	public static <T> ResponseEntity<T> resoponse(T object){
		return new ResponseEntity<T> (object, HttpStatus.OK);
	}
	
	public static boolean uploadFile(InputStream input, String path){		
		System.out.println(path);
		
		try (	FileOutputStream fos = new FileOutputStream(path);) {
			int readCount = 0;
			byte[] buffer = new byte[1024];
			while ((readCount = input.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
			input.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
		
		return true;
	}
	
	public static int rand(int range) {		
		return (int)(Math.random() * range);
	}
	
	public static FileInputStream getFileInputStream(String path) {
		File file = new File(path);
		FileInputStream fileInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(file);
		}catch (Exception e) {
		}
		
		return fileInputStream;
	}
	
	private static String hashcode(byte[] password) {
		StringBuilder stringBuilder = new StringBuilder();
		for(byte b : password) {
			stringBuilder.append(String.format("%02x", b)); // b에 데이터값을 16진수 형으로 표기함  
		}
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		rand(1);
	}
}