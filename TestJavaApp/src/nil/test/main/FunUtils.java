package nil.test.main;

public class FunUtils {
	public static String caclDiskSpace(final long bytes){
		float perLength = 1024.0f;
		String str = null;
		double _len = bytes;345345345345
		if (_len < perLength) {
			str = String.format("%.0fBytes", _len);
			return str;
		}
		
		_len /= perLength;
		if (_len < perLength) {
			str = String.format("%.2fKB", _len);
			return str;
		}

		_len /= perLength;
		if (_len < perLength) {
			str = String.format("%.2fMB", _len);
			return str;
		}
		
		_len /= perLength;
		if (_len < perLength) {
			str = String.format("%.2fGB", _len);
			return str;
		}

		_len /= perLength;
		if (_len < perLength) {
			str = String.format("%.2fTB", _len);
			return str;
		}
		
		_len /= perLength;
		if (_len < perLength) {
			str = String.format("%.2fPB", _len);
			return str;
		}
		
		_len /= perLength;
		if (_len < perLength) {
			str = String.format("%.2fEB", _len);
			return str;
		}

		_len /= perLength;
		if (_len < perLength) {
			str = String.format("%.2fZB", _len);
			return str;
		}
		
		_len /= perLength;
		if (_len < perLength) {
			str = String.format("%.2fYB", _len);
			return str;
		}
		return str;
	}
	
	public static String getDiskScheme(final long bytes, int diskTypes, int index){
		// 160 250 320 400 500 750 1000
		double diskNums = bytes*1f/(diskTypes*1024l*1024l*1024l);
		String str = String.format("方案%d：%dGB硬盘【%.2f】块", index, diskTypes, diskNums);
		return str;
	}
	
	public static String getAllDiskScheme(final long bytes){
		StringBuffer strBuf = new StringBuffer();
		strBuf.append("全部方案如下：");
		strBuf.append("\n");
		strBuf.append(getDiskScheme(bytes, 160, 1));
		strBuf.append("\n");
		strBuf.append(getDiskScheme(bytes, 320, 2));
		strBuf.append("\n");
		strBuf.append(getDiskScheme(bytes, 400, 3));
		strBuf.append("\n");
		strBuf.append(getDiskScheme(bytes, 500, 4));
		strBuf.append("\n");
		strBuf.append(getDiskScheme(bytes, 750, 5));
		strBuf.append("\n");
		strBuf.append(getDiskScheme(bytes, 1000, 6));
		return strBuf.toString();
	}
	
	private static String sTimeUnit[] = new String[]{"秒","分","时","天","月","年"};
	private static int sLenUnit[] = new int[]{60,60,60,24,30,365};
	private static StringBuffer sStrBuf = new StringBuffer();
	public static String caclRecordTime(final long seconds, String unitSplit) {
		long _len = seconds;
		int level = 0;
		long tmp = 0;
		
		if (_len < sLenUnit[level]){
			tmp = (long) _len;//秒
			String str = null;
			if (tmp != 0){
				str = sStrBuf.append(concatString(unitSplit,tmp,sTimeUnit[level])).toString();
			}else {
				str = sStrBuf.toString();
			}
			sStrBuf = new StringBuffer();
			return str;
		}
		
		_len /= sLenUnit[++level];
		if (_len < sLenUnit[level]){
			tmp = (long) _len; //分
			sStrBuf.append(concatString(unitSplit,tmp,sTimeUnit[level]));
			_len = seconds-tmp*60;
			return caclRecordTime(_len, unitSplit);
		}
		
		_len /= sLenUnit[++level];
		if (_len < sLenUnit[level]){
			tmp = (long) _len; //时
			sStrBuf.append(concatString(unitSplit,tmp,sTimeUnit[level]));
			_len = seconds-tmp*60*60;
			return caclRecordTime(_len, unitSplit);
		}
		
		_len /= sLenUnit[++level];
//		if (_len < sLenUnit[level]){
			tmp = (long) _len; //天
			sStrBuf.append(concatString(unitSplit,tmp,sTimeUnit[level]));
			_len = seconds-tmp*24*60*60;
			return caclRecordTime(_len, unitSplit);
//		}
//		return "error!";
	}
	
	public static String concatString(String split, Object... intAry) {
		if (intAry == null) {
			return null;
		}

		int len = intAry.length;
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < len - 1; i++) {
			strBuf.append(intAry[i]);
			strBuf.append(split);
		}
		strBuf.append(intAry[len - 1]);
		return strBuf.toString();
	}
}
