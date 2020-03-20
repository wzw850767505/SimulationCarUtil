package com.wzw.simcarutillib.util;


import java.io.ByteArrayOutputStream;


public class ByteUtil {

//	private static Logger log = LoggerFactory.getLogger(ByteUtil.class);

	public static byte[] intTo3Byte(int value) {
		byte[] buf = new byte[3];
		buf[0] = (byte) (value >> 16 & 0xff);
		buf[1] = (byte) (value >> 8 & 0xff);
		buf[2] = (byte) (value & 0xff);
		return buf;
	}
	
	public static byte[] intToByte(int value) {
		byte[] buf = new byte[4];
		buf[0] = (byte) (value >> 24);
		buf[1] = (byte) (value >> 16);
		buf[2] = (byte) (value >> 8);
		buf[3] = (byte) value;
		return buf;
	}

	public static byte[] shortToByte(int value) {
		byte[] buf = new byte[2];
		buf[0] = (byte) (value >> 8);
		buf[1] = (byte) value;
		return buf;
	}

	public static int intToByte(int value, byte[] buf, int pos) {
		try {
			buf[pos] = (byte) (value >> 24);
			buf[pos + 1] = (byte) (value >> 16);
			buf[pos + 2] = (byte) (value >> 8);
			buf[pos + 3] = (byte) value;
			return 4;
		} catch (Exception ex) {
			//log.error("intToByte出错![" + value + "]", ex);
			return 0;
		}
	}

	public static int byteToShort(byte b1, byte b2) {
		try {
			return ((0x000000FF & b1) << 8) | (0x00FF & b2);
		} catch (Exception ex) {
			//log.error("byteToShort出错!", ex);
			return 0;
		}
	}

	public static int byteToInt(byte[] buf) {
		try {
			return ((0x000000FF & buf[0]) << 24) | ((0x000000FF & buf[1]) << 16) | ((0x000000FF & buf[2]) << 8)
					| (0x00FF & buf[3]);
		} catch (Exception ex) {
			//log.error("byteToInt出错!", ex);
			return 0;
		}
	}

	public static int byteToInt(byte[] buf, int pos) {
		try {
			return ((0x000000FF & buf[pos]) << 24) | ((0x000000FF & buf[pos + 1]) << 16)
					| ((0x000000FF & buf[pos + 2]) << 8) | (0x00FF & buf[pos + 3]);
		} catch (Exception ex) {
			//log.error("byteToInt出错!", ex);
			return 0;
		}
	}

	public static byte[] longToByte(long value) {
		byte[] buf = new byte[8];
		buf[0] = (byte) (value >> 56);
		buf[1] = (byte) (value >> 48);
		buf[2] = (byte) (value >> 40);
		buf[3] = (byte) (value >> 32);
		buf[4] = (byte) (value >> 24);
		buf[5] = (byte) (value >> 16);
		buf[6] = (byte) (value >> 8);
		buf[7] = (byte) value;
		return buf;
	}

	public static int longToByte(long value, byte[] buf, int pos) {
		try {
			buf[pos] = (byte) (value >> 56);
			buf[pos + 1] = (byte) (value >> 48);
			buf[pos + 2] = (byte) (value >> 40);
			buf[pos + 3] = (byte) (value >> 32);
			buf[pos + 4] = (byte) (value >> 24);
			buf[pos + 5] = (byte) (value >> 16);
			buf[pos + 6] = (byte) (value >> 8);
			buf[pos + 7] = (byte) value;
			return 8;
		} catch (Exception ex) {
			//log.error("longToByte出错![" + value + "]", ex);
			return 0;
		}
	}

	public static long byteToLong(byte[] buf) {
		try {
			return (((long) buf[0] & (long) 0xFF) << 56) | (((long) buf[1] & (long) 0xFF) << 48)
					| (((long) buf[2] & (long) 0xFF) << 40) | (((long) buf[3] & (long) 0xFF) << 32)
					| (((long) buf[4] & (long) 0xFF) << 24) | (((long) buf[5] & (long) 0xFF) << 16)
					| (((long) buf[6] & (long) 0xFF) << 8) | ((long) buf[7] & (long) 0xFF);
		} catch (Exception ex) {
			//log.error("byteToLong出错!", ex);
			return 0;
		}
	}

	public static long byteToLong(byte[] buf, int pos) {
		try {
			return (((long) buf[pos] & (long) 0xFF) << 56) | (((long) buf[pos + 1] & (long) 0xFF) << 48)
					| (((long) buf[pos + 2] & (long) 0xFF) << 40) | (((long) buf[pos + 3] & (long) 0xFF) << 32)
					| (((long) buf[pos + 4] & (long) 0xFF) << 24) | (((long) buf[pos + 5] & (long) 0xFF) << 16)
					| (((long) buf[pos + 6] & (long) 0xFF) << 8) | ((long) buf[pos + 7] & (long) 0xFF);
		} catch (Exception ex) {
			//log.error("byteToLong出错!", ex);
			return 0;
		}
	}

	protected static char[] HEX_CHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };
	
	public static void byteToHexStr(byte value, StringBuilder sb) {
		sb.append(HEX_CHAR[(0xFF & value) >> 4]).append(HEX_CHAR[0x0F & value]);
	}

	public static String byteToHexStr(byte value) {
		StringBuilder sb = new StringBuilder();
		byteToHexStr(value, sb);
		return sb.toString();
	}

	public static String byteToHexStr(byte[] buffer) {
		return byteToHexStr(buffer, 0, buffer.length);
	}

	public static String byteToHexStr(byte[] buffer, int startPos, int length) {
		StringBuilder result = new StringBuilder();
		for (int i=startPos; i<startPos+length; i++) {
			byteToHexStr(buffer[startPos + i], result);
		}
		return result.toString();
	}

	public static byte[] hexStrToBytes(String str) {
		if (str == null || str.length() == 0) {
			return new byte[0];
		} else {
			str = str.trim();
			str = str.replaceAll("[ :\\r\\n]", "");
			ByteArrayOutputStream bos = new ByteArrayOutputStream(str.length()/2+1);
			int i = 0;
			while (i < str.length()) {
				String str1 = str.substring(i, i + 2);
				bos.write(Integer.parseInt(str1, 16));
				i = i + 2;
			}
			return bos.toByteArray();
		}
	}

	public static String byteToHexViewStr(byte[] buffer) {
		if (buffer == null) {
			return "";
		}
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < buffer.length; i++) {
			result.append(byteToHexStr(buffer[i]));
			result.append(" ");
		}
		return result.toString();
	}

	public static String bytesToBCDString(byte[] barr) {
		return byteToHexStr(barr);
	}
	
	//比较两个byte数组的值是否相等，用于对登录用户的登录验证
	public static boolean isEqual(byte[] buf1, int pos1, byte[] buf2, int pos2, int len){
		try{
			for(int i = 0; i < len; i++){
				if (buf1[pos1 + i] != buf2[pos2 + i]){
					return false;
				}				
			}
			return true;
		}catch(Exception ex){
			//log.error("theSameArr出错!",ex);
			return false;
		}
	}


	/**
	 * 获取指定长度字节数
	 *
	 * @param src
	 * @param startIndex
	 * @param length
	 * @return
	 */
	public static byte[] byteTobyte(byte[] src, int startIndex, int length) {
		byte[] des = new byte[length];
		int i = 0;
		for (int j = startIndex; i < length; ++j) {
			des[i] = src[j];
			++i;
		}
		return des;
	}
}
