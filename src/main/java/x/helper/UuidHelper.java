package x.helper;

import java.util.UUID;

public class UuidHelper {
	/**
	 * 
	 * 获取uuid 32位无'-'
	 * 
	 * @return
	 */
	public static String getId() {
		UUID uuid = UUID.randomUUID();

		String uuidStr = uuid.toString();
		StringBuilder builder = new StringBuilder(32);
		builder.append(uuidStr.substring(0, 8));
		builder.append(uuidStr.substring(9, 9 + 4));
		builder.append(uuidStr.substring(14, 14 + 4));
		builder.append(uuidStr.substring(19, 19 + 4));
		builder.append(uuidStr.substring(24));
		String r = builder.toString();
		return r;
	}
}
