package x.helper.map;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class BeanMap extends HashMap<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	  
	  public boolean isEmpty(String key)
	  {
	    if (!containsKey(key)) {
	      return true;
	    }
	    if (get(key) == null) {
	      return true;
	    }
	    if ("".equals((String)get(key))) {
	      return true;
	    }
	    return false;
	  }
	  
	  public String getString(String key)
	  {
	    if (!containsKey(key)) {
	      return null;
	    }
	    Object value = get(key);
	    return getStringValue(value);
	  }
	  
	  protected String getStringValue(Object value)
	  {
	    if (value == null) {
	      return null;
	    }
	    if ((value instanceof String)) {
	      return (String)value;
	    }
	    if ((value instanceof String[])) {
	      return ((String[])value)[0];
	    }
	    return String.valueOf(value);
	  }
	  
	  public boolean getBoolean(String key)
	  {
	    if (!containsKey(key)) {
	      return false;
	    }
	    Object value = get(key);
	    if (value == null) {
	      return false;
	    }
	    if ((value instanceof Boolean))
	    {
	      if (((Boolean)value).booleanValue()) {
	        return true;
	      }
	      return false;
	    }
	    String stringValue = getStringValue(value);
	    if ("true".equalsIgnoreCase(stringValue)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public int getInt(String key)
	  {
	    if (!containsKey(key)) {
	      return 0;
	    }
	    Object value = get(key);
	    return getInt(value);
	  }
	  
	  protected int getInt(Object value)
	  {
	    if (value == null) {
	      return 0;
	    }
	    if ((value instanceof Integer)) {
	      return ((Integer)value).intValue();
	    }
	    if ((value instanceof String)) {
	      try
	      {
	        return Integer.parseInt((String)value);
	      }
	      catch (Exception e)
	      {
	        return 0;
	      }
	    }
	    if ((value instanceof BigDecimal)) {
	      return ((BigDecimal)value).intValue();
	    }
	    if ((value instanceof int[])) {
	      return ((int[])value)[0];
	    }
	    if ((value instanceof String[])) {
	      return Integer.parseInt(((String[])value)[0]);
	    }
	    if ((value instanceof Long)) {
	      return ((Long)value).intValue();
	    }
		return 0;
	  }
	  
	  public java.util.Date getDate(String key)
	  {
	    if (!containsKey(key)) {
	      return null;
	    }
	    Object value = get(key);
	    return getDate(value);
	  }
	  
	  protected java.util.Date getDate(Object value)
	  {
	    if (value == null) {
	      return null;
	    }
	    if ((value instanceof java.util.Date)) {
	      return (java.util.Date)value;
	    }
	    if ((value instanceof java.sql.Date)) {
	      return new java.util.Date(((java.sql.Date)value).getTime());
	    }
	    if ((value instanceof Time)) {
	      return new java.util.Date(((Time)value).getTime());
	    }
	    if ((value instanceof Timestamp)) {
	      return new java.util.Date(((Timestamp)value).getTime());
	    }
	    if ((value instanceof String))
	    {
	      String s = (String)value;
	      try
	      {
	        SimpleDateFormat sdf = null;
	        if (s.length() == 8) {
	          sdf = new SimpleDateFormat("yyyyMMdd");
	        } else if ((s.length() == 10) && (s.charAt(4) == '-') && (s.charAt(7) == '-')) {
	          sdf = new SimpleDateFormat("yyyy-MM-dd");
	        } else if ((s.length() == 19) && (s.charAt(4) == '-') && (s.charAt(7) == '-') && (s.charAt(10) == ' ') && (s.charAt(13) == ':') && (s.charAt(16) == ':')) {
	          sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        }
	        if (sdf == null) {
	          return null;
	        }
	        return sdf.parse(s);
	      }
	      catch (ParseException localParseException) {}
	    }
	    else if ("oracle.sql.TIMESTAMP".equals(value.getClass().getName()))
	    {
	      try
	      {
	        Method method = value.getClass().getMethod("dateValue", null);
	        return new java.util.Date(((java.sql.Date)method.invoke(value, null)).getTime());
	      }
	      catch (Exception e)
	      {
	        e.printStackTrace();
	      }
	    }
		return null;
	  }
	  
	  public java.sql.Date getDateSql(String key)
	  {
	    if (!containsKey(key)) {
	      return null;
	    }
	    Object value = get(key);
	    return getDateSql(value);
	  }
	  
	  protected java.sql.Date getDateSql(Object value)
	  {
	    if (value == null) {
	      return null;
	    }
	    if ((value instanceof java.sql.Date)) {
	      return (java.sql.Date)value;
	    }
	    if ((value instanceof java.util.Date))
	    {
	      return new java.sql.Date(((java.util.Date)value).getTime());
	    }
	    if ((value instanceof Time))
	    {
	      return new java.sql.Date(((Time)value).getTime());
	    }
	    if ((value instanceof Timestamp))
	    {
	      return new java.sql.Date(((Timestamp)value).getTime());
	    }
	    if ((value instanceof String))
	    {
	      String s = (String)value;
	      try
	      {
	        SimpleDateFormat sdf = null;
	        if (s.length() == 8) {
	          sdf = new SimpleDateFormat("yyyyMMdd");
	        } else if ((s.length() == 10) && (s.charAt(4) == '-') && (s.charAt(7) == '-')) {
	          sdf = new SimpleDateFormat("yyyy-MM-dd");
	        } else if ((s.length() == 19) && (s.charAt(4) == '-') && (s.charAt(7) == '-') && (s.charAt(10) == ' ') && (s.charAt(13) == ':') && (s.charAt(16) == ':')) {
	          sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        }
	        if (sdf == null) {
	        	return null;
	        }
	        return new java.sql.Date(sdf.parse(s).getTime());
	      }
	      catch (ParseException localParseException) {}
	    }
	    else if ("oracle.sql.TIMESTAMP".equals(value.getClass().getName()))
	    {
	      try
	      {
	        Method method = value.getClass().getMethod("dateValue", null);
	        return (java.sql.Date)method.invoke(value, null);
	      }
	      catch (Exception e)
	      {
	        e.printStackTrace();
	      }
	    }
		return null;
	  }
	  
	  public Time getTime(String key)
	  {
	    if (!containsKey(key)) {
	      return null;
	    }
	    Object value = get(key);
	    return getTime(value);
	  }
	  
	  protected Time getTime(Object value)
	  {
	    if (value == null) {
	      return null;
	    }
	    if ((value instanceof Time)) {
	      return (Time)value;
	    }
	    if ((value instanceof java.sql.Date)) {
	      return new Time(((java.sql.Date)value).getTime());
	    }
	    if ((value instanceof java.util.Date)) {
	      return new Time(((java.util.Date)value).getTime());
	    }
	    if ((value instanceof Timestamp))
	    {
	      return new Time(((Timestamp)value).getTime());
	    }
	    if ((value instanceof String))
	    {
	      String s = (String)value;
	      try
	      {
	        SimpleDateFormat sdf = null;
	        if ((s.length() == 19) && (s.charAt(4) == '-') && (s.charAt(7) == '-') && (s.charAt(10) == ' ') && (s.charAt(13) == ':') && (s.charAt(16) == ':')) {
	          sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        } else if (s.length() == 8) {
	          sdf = new SimpleDateFormat("yyyyMMdd");
	        } else if ((s.length() == 10) && (s.charAt(4) == '-') && (s.charAt(7) == '-')) {
	          sdf = new SimpleDateFormat("yyyy-MM-dd");
	        }
	        if (sdf == null) {
	        	return null;
	        }
	        return new Time(sdf.parse(s).getTime());
	      }
	      catch (ParseException localParseException) {}
	    }
	    else if ("oracle.sql.TIMESTAMP".equals(value.getClass().getName()))
	    {
	      try
	      {
	        Method method = value.getClass().getMethod("timeValue", null);
	        return (Time)method.invoke(value, null);
	      }
	      catch (Exception e)
	      {
	        e.printStackTrace();
	      }
	    }
		return null;
	  }
	  
	  public Timestamp getTimestamp(String key)
	  {
	    if (!containsKey(key)) {
	      return null;
	    }
	    Object value = get(key);
	    return getTimestamp(value);
	  }
	  
	  protected Timestamp getTimestamp(Object value)
	  {
	    if (value == null) {
	      return null;
	    }
	    if ((value instanceof Timestamp)) {
	      return (Timestamp)value;
	    }
	    if ((value instanceof java.sql.Date)) {
	      return new Timestamp(((java.sql.Date)value).getTime());
	    }
	    if ((value instanceof java.util.Date)) {
	      return new Timestamp(((java.util.Date)value).getTime());
	    }
	    if ((value instanceof Time)) {
	      return new Timestamp(((Time)value).getTime());
	    }
	    if ((value instanceof String))
	    {
	      String s = (String)value;
	      try
	      {
	        SimpleDateFormat sdf = null;
	        if ((s.length() == 19) && (s.charAt(4) == '-') && (s.charAt(7) == '-') && (s.charAt(10) == ' ') && (s.charAt(13) == ':') && (s.charAt(16) == ':')) {
	          sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	        } else if (s.length() == 8) {
	          sdf = new SimpleDateFormat("yyyyMMdd");
	        } else if ((s.length() == 10) && (s.charAt(4) == '-') && (s.charAt(7) == '-')) {
	          sdf = new SimpleDateFormat("yyyy-MM-dd");
	        }
	        if (sdf == null) {
	          return null;
	        }
	        return new Timestamp(sdf.parse(s).getTime());
	      }
	      catch (ParseException localParseException) {}
	    }
	    else if ("oracle.sql.TIMESTAMP".equals(value.getClass().getName()))
	    {
	      try
	      {
	        Method method = value.getClass().getMethod("timestampValue", null);
	        return (Timestamp)method.invoke(value, null);
	      }
	      catch (Exception e)
	      {
	        e.printStackTrace();
	      }
	    }
		return null;
	  }
	  
	  public java.sql.Date getDateSql(String key, String format)
	  {
	    java.util.Date date = getDate(key, format);
	    if (date == null) {
	      return null;
	    }
	    return new java.sql.Date(date.getTime());
	  }
	  
	  public Time getTime(String key, String format)
	  {
	    java.util.Date date = getDate(key, format);
	    if (date == null) {
	      return null;
	    }
	    return new Time(date.getTime());
	  }
	  
	  public Timestamp getTimeStamp(String key, String format)
	  {
	    java.util.Date date = getDate(key, format);
	    if (date == null) {
	      return null;
	    }
	    return new Timestamp(date.getTime());
	  }
	  
	  public java.util.Date getDate(String key, String format)
	  {
	    if (!containsKey(key)) {
	      return null;
	    }
	    Object value = get(key);
	    if ((value == null) || ("".equals(value))) {
	      return null;
	    }
	    if ((value instanceof String)) {
	      try
	      {
	        SimpleDateFormat sdf = new SimpleDateFormat(format);
	        return sdf.parse((String)value);
	      }
	      catch (Exception e)
	      {
	      }
	    }
	    return getDate(key);
	  }
	  
	  public long getLong(String key)
	  {
	    if (!containsKey(key)) {
	      return 0L;
	    }
	    Object value = get(key);
	    return getLong(value);
	  }
	  
	  protected long getLong(Object value)
	  {
	    if (value == null) {
	      return 0L;
	    }
	    if ((value instanceof Long)) {
	      return ((Long)value).longValue();
	    }
	    if ((value instanceof Integer)) {
	      return ((Integer)value).longValue();
	    }
	    if ((value instanceof BigDecimal)) {
	      return ((BigDecimal)value).longValue();
	    }
	    if ((value instanceof String)) {
	      try
	      {
	        return Long.valueOf((String)value).longValue();
	      }
	      catch (Exception e)
	      {
	      }
	    }
		return 0;
	  }
	  
	  public float getFloat(String key)
	  {
	    if (!containsKey(key)) {
	      return 0.0F;
	    }
	    Object value = get(key);
	    return getFloat(value);
	  }
	  
	  protected float getFloat(Object value)
	  {
	    if (value == null) {
	      return 0.0F;
	    }
	    if ((value instanceof Float)) {
	      return ((Float)value).floatValue();
	    }
	    if ((value instanceof Integer)) {
	      return ((Integer)value).floatValue();
	    }
	    if ((value instanceof BigDecimal)) {
	      return ((BigDecimal)value).floatValue();
	    }
	    if ((value instanceof Long)) {
	      return ((Long)value).floatValue();
	    }
	    if ((value instanceof Double)) {
	      return ((Double)value).floatValue();
	    }
	    if ((value instanceof String)) {
	      try
	      {
	        return Float.valueOf((String)value).floatValue();
	      }
	      catch (Exception e)
	      {
	      }
	    }
		return 0;
	  }
	  
	  public double getDouble(String key)
	  {
	    if (!containsKey(key)) {
	      return 0.0D;
	    }
	    Object value = get(key);
	    return getDouble(value);
	  }
	  
	  protected double getDouble(Object value)
	  {
	    if (value == null) {
	      return 0.0D;
	    }
	    if ((value instanceof Double)) {
	      return ((Double)value).doubleValue();
	    }
	    if ((value instanceof Integer)) {
	      return ((Integer)value).doubleValue();
	    }
	    if ((value instanceof BigDecimal)) {
	      return ((BigDecimal)value).doubleValue();
	    }
	    if ((value instanceof Long)) {
	      return ((Long)value).doubleValue();
	    }
	    if ((value instanceof Float)) {
	      return ((Float)value).doubleValue();
	    }
	    if ((value instanceof String)) {
	      try
	      {
	        return Double.valueOf((String)value).doubleValue();
	      }
	      catch (Exception e)
	      {
	      }
	    }
		return 0;
	  }
	  
	  public BigDecimal getDecimal(String key)
	  {
	    if (!containsKey(key)) {
	      return null;
	    }
	    Object value = get(key);
	    return getDecimal(value);
	  }
	  
	  protected BigDecimal getDecimal(Object value)
	  {
	    if (value == null) {
	      return null;
	    }
	    if ((value instanceof Double)) {
	      return new BigDecimal(((Double)value).doubleValue());
	    }
	    if ((value instanceof Integer)) {
	      return new BigDecimal(((Integer)value).doubleValue());
	    }
	    if ((value instanceof BigDecimal)) {
	      return (BigDecimal)value;
	    }
	    if ((value instanceof Long)) {
	      return new BigDecimal(((Long)value).doubleValue());
	    }
	    if ((value instanceof Float)) {
	      return new BigDecimal(((Float)value).doubleValue());
	    }
	    if ((value instanceof String)) {
	      try
	      {
	        return new BigDecimal((String)value);
	      }
	      catch (Exception e)
	      {
	      }
	    }
		return null;
	  }
	  
	  public String[] getStringArray(String key)
	  {
	    if (!containsKey(key)) {
	      return null;
	    }
	    Object value = get(key);
	    if (!value.getClass().isArray())
	    {
	      String s = getString(key);
	      return new String[] { s };
	    }
	    if ((value instanceof String[])) {
	      return (String[])value;
	    }
	    Object[] os = (Object[])value;
	    String[] ss = new String[os.length];
	    for (int i = 0; i < os.length; i++) {
	      ss[i] = getStringValue(os[i]);
	    }
	    return ss;
	  }
	  
	  public int[] getIntArray(String key)
	  {
	    String[] s = getStringArray(key);
	    if (s == null) {
	      return null;
	    }
	    int[] is = new int[s.length];
	    for (int i = 0; i < s.length; i++) {
	      if (s[i] == null) {
	        is[i] = 0;
	      } else {
	        try
	        {
	          is[i] = Integer.parseInt(s[i]);
	        }
	        catch (Exception e)
	        {
	          is[i] = 0;
	        }
	      }
	    }
	    return is;
	  }
	  
	  public long[] getLongArray(String key)
	  {
	    String[] s = getStringArray(key);
	    if (s == null) {
	      return null;
	    }
	    long[] is = new long[s.length];
	    for (int i = 0; i < s.length; i++) {
	      if (s[i] == null) {
	        is[i] = 0L;
	      } else {
	        try
	        {
	          is[i] = Long.parseLong(s[i]);
	        }
	        catch (Exception e)
	        {
	          is[i] = 0L;
	        }
	      }
	    }
	    return is;
	  }
	  
	  public float[] getFloatArray(String key)
	  {
	    String[] s = getStringArray(key);
	    if (s == null) {
	      return null;
	    }
	    float[] is = new float[s.length];
	    for (int i = 0; i < s.length; i++) {
	      if (s[i] == null) {
	        is[i] = 0.0F;
	      } else {
	        try
	        {
	          is[i] = Float.parseFloat(s[i]);
	        }
	        catch (Exception e)
	        {
	          is[i] = 0.0F;
	        }
	      }
	    }
	    return is;
	  }
	  
	  public double[] getDoubleArray(String key)
	  {
	    String[] s = getStringArray(key);
	    if (s == null) {
	      return null;
	    }
	    double[] is = new double[s.length];
	    for (int i = 0; i < s.length; i++) {
	      if (s[i] == null) {
	        is[i] = 0.0D;
	      } else {
	        try
	        {
	          is[i] = Double.parseDouble(s[i]);
	        }
	        catch (Exception e)
	        {
	          is[i] = 0.0D;
	        }
	      }
	    }
	    return is;
	  }
	  
	  public java.util.Date[] getDateArray(String key, String format)
	  {
	    String[] s = getStringArray(key);
	    if (s == null) {
	      return null;
	    }
	    java.util.Date[] is = new java.util.Date[s.length];
	    SimpleDateFormat sdf = new SimpleDateFormat(format);
	    for (int i = 0; i < s.length; i++) {
	      if ((s[i] == null) || ("".equals(s[i]))) {
	        is[i] = null;
	      } else {
	        try
	        {
	          is[i] = sdf.parse(s[i]);
	        }
	        catch (Exception e)
	        {
	        }
	      }
	    }
	    return is;
	  }
	  
	  public java.sql.Date[] getDateSqlArray(String key, String format)
	  {
	    java.util.Date[] ds = getDateArray(key, format);
	    if (ds == null) {
	      return null;
	    }
	    java.sql.Date[] is = new java.sql.Date[ds.length];
	    for (int i = 0; i < ds.length; i++) {
	      if (ds[i] == null) {
	        is[i] = null;
	      } else {
	        is[i] = new java.sql.Date(ds[i].getTime());
	      }
	    }
	    return is;
	  }
	  
	  public Time[] getTimeArray(String key, String format)
	  {
	    java.util.Date[] ds = getDateArray(key, format);
	    if (ds == null) {
	      return null;
	    }
	    Time[] is = new Time[ds.length];
	    for (int i = 0; i < ds.length; i++) {
	      if (ds[i] == null) {
	        is[i] = null;
	      } else {
	        is[i] = new Time(ds[i].getTime());
	      }
	    }
	    return is;
	  }
	  
	  public Timestamp[] getTimestampArray(String key, String format)
	  {
	    java.util.Date[] ds = getDateArray(key, format);
	    if (ds == null) {
	      return null;
	    }
	    Timestamp[] is = new Timestamp[ds.length];
	    for (int i = 0; i < ds.length; i++) {
	      if (ds[i] == null) {
	        is[i] = null;
	      } else {
	        is[i] = new Timestamp(ds[i].getTime());
	      }
	    }
	    return is;
	  }
}
