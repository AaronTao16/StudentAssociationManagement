package com.stuUnion.util;

public class StringUtil {
	public static boolean isNull(String str) {
		if("".equals(str) || str == null) {
			return true;
		}
		return false;
	}
	
	public static boolean isEqual(String str1, String str2) {
		if(str1.equals(str2)) {
			return true;
		}
		return false;
	}
	
	public static boolean outOfRange2(float f) {
		if(f > 2) {
			return true;
		}
		return false;
	}
	
	public static boolean outOfRange5(float f) {
		if(f > 5) {
			return true;
		}
		return false;
	}
	
	public static boolean outOfRange6(float f) {
		if(f > 6) {
			return true;
		}
		return false;
	}
	
	public static boolean outOfRange9(float f) {
		if(f > 9) {
			return true;
		}
		return false;
	}
	
	public static boolean outOfRange10(float f) {
		if(f > 10) {
			return true;
		}
		return false;
	}
}
