package com.github.L_Ender.cataclysm.util.AssetsProtector;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.RandomStringUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AESUtil
{
	//https://www.baeldung.com/java-aes-encryption-decryption
	
	public static ResourceLocation getTexture(ResourceLocation texture)
	{
		registerTexture(texture);
		return texture;
	}
	
	public static void registerTexture(ResourceLocation p_172522_) 
	{
		TextureManager textureManager = Minecraft.getInstance().getTextureManager();
		AbstractTexture abstracttexture = textureManager.getTexture(p_172522_, MissingTextureAtlasSprite.getTexture());
		if(abstracttexture == MissingTextureAtlasSprite.getTexture()) 
		{
			AbstractTexture texture = new AESTexture((File)null, p_172522_);
			textureManager.register(p_172522_, texture);
		}
	}
	
	private static String generateRandomString()
	{
		return RandomStringUtils.random(16, true, true);
	}
	
	private static SecretKey getKey(String password, String salt) throws NoSuchAlgorithmException, InvalidKeySpecException 
	{
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), 65536, 256);
		SecretKey secret = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
		return secret;
	}
	
	private static IvParameterSpec generateIv() 
	{
	    byte[] iv = new byte[16];
	    //new SecureRandom().nextBytes(iv);
	    return new IvParameterSpec(iv);
	}
	
	private static SecretKey decryptKey(byte[] array, String algorithm, IvParameterSpec ivParameterSpec) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, InvalidKeySpecException, IOException
	{
		String string = new String(Arrays.copyOfRange(array, array.length - 16, array.length));
		SecretKey key = getKey(string, string);
	    String encrypted = new String(Arrays.copyOfRange(array, array.length - 60, array.length - 16));
		String decrypted = decryptString(algorithm, encrypted, key, ivParameterSpec);
		return getKey(decrypted, string);
	}
	
	public static ByteArrayInputStream decrypt(byte[] array) throws NoSuchAlgorithmException, IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeySpecException
	{
	    String algorithm = "AES/CBC/PKCS5Padding";
	    IvParameterSpec ivParameterSpec = generateIv();
	    SecretKey key = decryptKey(array, algorithm, ivParameterSpec);
	    return decryptFile(algorithm, key, ivParameterSpec, array);
	}
	
	public static void encryptFiles(String fileExtension) throws NoSuchAlgorithmException, IOException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, InvalidKeySpecException
	{
	    String algorithm = "AES/CBC/PKCS5Padding";
	    IvParameterSpec ivParameterSpec = generateIv();
	    File directory = makeDirectory("aes");
	    File [] files = directory.listFiles(new FileFilter() 
	    {
	    	@Override
	        public boolean accept(File file) 
	        {
	            return file.isFile() && file.getName().toLowerCase().endsWith(fileExtension);
	        }
	    });
	    for(int i = 0; i < files.length; i++)
	    {
		    File inputFile = new File(directory, files[i].getName().toLowerCase());
		    File encryptedFile = new File(directory, files[i].getName().toLowerCase() + "encrypted");
		    String randomString = generateRandomString();
		    SecretKey key = getKey(randomString, randomString);
		    String encrypted = encryptString(algorithm, generateRandomString(), key, ivParameterSpec);
			String decrypted = decryptString(algorithm, encrypted, key, ivParameterSpec);
		    encryptFile(algorithm, getKey(decrypted, randomString), ivParameterSpec, inputFile, encryptedFile, encrypted, randomString);
	    }
	}
	
	private static File makeDirectory(String folderName)
	{
		Minecraft mc = Minecraft.getInstance();
		File cacheDirectory = new File(mc.gameDirectory.getPath() + "/" + folderName);
		if(!cacheDirectory.exists())
		{
			cacheDirectory.mkdir();
		}
		return cacheDirectory;
	}
	
	private static String encryptString(String algorithm, String input, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException 
	{	
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}
	
	private static String decryptString(String algorithm, String cipherText, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException 
	{
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
		return new String(plainText);
	}
	
	private static ByteArrayInputStream decryptFile(String algorithm, SecretKey key, IvParameterSpec iv, byte[] array) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
	{
	    Cipher cipher = Cipher.getInstance(algorithm);
	    cipher.init(Cipher.DECRYPT_MODE, key, iv);
	    ByteArrayInputStream inputStream = new ByteArrayInputStream(Arrays.copyOfRange(array, 0, array.length - 60));
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    byte[] buffer = new byte[64];
	    int bytesRead;
	    while((bytesRead = inputStream.read(buffer)) != -1) 
	    {
	        byte[] output = cipher.update(buffer, 0, bytesRead);
	        if(output != null) 
	        {
	            outputStream.write(output);
	        }
	    }
	    byte[] outputBytes = cipher.doFinal();
	    if(outputBytes != null)
	    {
	        outputStream.write(outputBytes);
	    }
	    inputStream.close();
	    return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
	private static void encryptFile(String algorithm, SecretKey key, IvParameterSpec iv, File inputFile, File outputFile, String encrypted, String string) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException
	{
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);
		FileInputStream inputStream = new FileInputStream(inputFile);
		FileOutputStream outputStream = new FileOutputStream(outputFile);
		byte[] buffer = new byte[64];
		int bytesRead;
		while((bytesRead = inputStream.read(buffer)) != -1) 
		{
			byte[] output = cipher.update(buffer, 0, bytesRead);
			if(output != null)
			{
				outputStream.write(output);
			}
		}
		byte[] outputBytes = cipher.doFinal();
		if(outputBytes != null)
		{
			//length == 16;
			outputStream.write(outputBytes);
			//length == 44;
			outputStream.write(encrypted.getBytes());
			//length == 16;
			outputStream.write(string.getBytes());
		}
		inputStream.close();
		outputStream.close();
	}
}
