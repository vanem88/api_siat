package com.evelia.api_siat.utils;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.*;
import java.io.*;

public class Util{  
  private  static String KEY_STRING = "";

 public void setString(String string)
 {
   KEY_STRING = string;
 }

  public String encrypt(String source )
  {
    try
    {
      // Get our secret key
      Key key = getKey();

      // Create the cipher
      Cipher desCipher =
          Cipher.getInstance("DES/ECB/PKCS5Padding");

      // Initialize the cipher for encryption
      desCipher.init(Cipher.ENCRYPT_MODE, key);

      // Our cleartext as bytes
      byte[] cleartext = source.getBytes();

      // Encrypt the cleartext
      byte[] ciphertext = desCipher.doFinal(cleartext);

      // Return a String representation of the cipher text
      return getString( ciphertext );
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
    return null;
  }

  public static String generateKey()
  {
    try
    {
      KeyGenerator keygen = KeyGenerator.getInstance("DES");
      SecretKey desKey = keygen.generateKey();
      byte[] bytes = desKey.getEncoded();
      return getString( bytes );
    }
    catch( Exception e )
    {
      e.printStackTrace();
      return null;
    }
  }

  public static String decrypt( String source )
  {
    try
    {
      // Get our secret key
      Key key = getKey();

      // Create the cipher
      Cipher desCipher =
          Cipher.getInstance("DES/ECB/PKCS5Padding");

      // Encrypt the cleartext
      byte[] ciphertext = getBytes( source );

      // Initialize the same cipher for decryption
      desCipher.init(Cipher.DECRYPT_MODE, key);

      // Decrypt the ciphertext
      byte[] cleartext = desCipher.doFinal(ciphertext);

      // Return the clear text
      return new String( cleartext );
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
    return null;
  }

  private static Key getKey()
  {
    try
    {
      byte[] bytes = getBytes( KEY_STRING );
      DESKeySpec pass = new DESKeySpec( bytes );
      SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
      SecretKey s = skf.generateSecret(pass);
      return s;
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Returns true if the specified text is encrypted, false otherwise
   */
  public static boolean isEncrypted( String text )
  {
    // If the string does not have any separators then it is not
    // encrypted
    if( text.indexOf( '-' ) == -1 ) {
      ///comun.ImprimirReportes.ImprimirReporte( "text is not encrypted: no dashes" );
      return false;
    }

    StringTokenizer st = new StringTokenizer( text, "-", false );
    while( st.hasMoreTokens() ) {
      String token = st.nextToken();
      if( token.length() > 3 ){
        return false;
      }
      for( int i=0; i<token.length(); i++ ) {
        if( !Character.isDigit( token.charAt( i ) ) ) {
          return false;
        }
      }
    }
    //comun.ImprimirReportes.ImprimirReporte( "text is encrypted" );
    return true;
  }

  private static String getString( byte[] bytes ) {
    StringBuffer sb = new StringBuffer();
    for( int i=0; i<bytes.length; i++ ) {
      byte b = bytes[ i ];
      sb.append( ( int )( 0x00FF & b ) );
      if( i+1 <bytes.length ) {
        sb.append( "-" );
      }
    }
    return sb.toString();
  }

  private static byte[] getBytes( String str ) {
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    StringTokenizer st = new StringTokenizer( str, "-", false );
    while( st.hasMoreTokens() ) {
      int i = Integer.parseInt( st.nextToken() );
      bos.write( ( byte )i );
    }
    return bos.toByteArray();
  }
  
  static String convert(String in) {
	  return in.replace("&amp;","&")   
	           .replace("&nbsp;"," ")   
	           .replace("&lt;","<")   
	           .replace("&gt;",">")   
	           .replace("&ntilde;","ñ")   
	           .replace("&Ntilde;","Ñ")   
	           .replace("&aacute;","á")   
	           .replace("&eacute;","é")   
	           .replace("&iacute;","í")   
	           .replace("&oacute;","ó")   
	           .replace("&uacute;","ú")   
	           .replace("&iquest;","¿")   
	           .replace("&iexcl;","¡")   
	           .replace("&quot;","\"")   
	           .replace("&#039;","'");   
	 }
  
  
}
