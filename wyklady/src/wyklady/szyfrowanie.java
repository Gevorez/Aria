package wyklady;

import java.security.MessageDigest;

public class szyfrowanie {


	
	public static String md5( String source ) {
	    try {
	        MessageDigest md = MessageDigest.getInstance( "MD5" );
	        byte[] bytes = md.digest( source.getBytes("UTF-8") );
	        return getString( bytes );
	    } catch( Exception e )  {
	        e.printStackTrace();
	        return null;
	    }
	}

	private static String getString( byte[] bytes ) 
	{
	  StringBuffer sb = new StringBuffer();
	  for( int i=0; i<bytes.length; i++ )     
	  {
	     byte b = bytes[ i ];
	     String hex = Integer.toHexString((int) 0x00FF & b);
	     if (hex.length() == 1) 
	     {
	        sb.append("0");
	     }
	     sb.append( hex );
	  }
	  return sb.toString();
	}
}
