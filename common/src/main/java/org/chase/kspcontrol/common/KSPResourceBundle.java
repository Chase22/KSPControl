package org.chase.kspcontrol.common;

import java.util.Enumeration;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.Set;

public class KSPResourceBundle {
	
	private ResourceBundle bundle;
	
	private String prefix;
	
	public static KSPResourceBundle getBundle(String baseName) {
		return new KSPResourceBundle(ResourceBundle.getBundle(baseName));
	}
	
	public static KSPResourceBundle getBundle(String baseName, Locale locale) {
		return new KSPResourceBundle(ResourceBundle.getBundle(baseName, locale));
	}
	
	public static KSPResourceBundle getBundle(String baseName, String prefix) {
		KSPResourceBundle bundle = new KSPResourceBundle(ResourceBundle.getBundle(baseName));
		bundle.setPrefix(prefix);
		return bundle;
	}
	
	public static KSPResourceBundle getBundle(String baseName, Locale locale, String prefix) {
		KSPResourceBundle bundle = new KSPResourceBundle(ResourceBundle.getBundle(baseName, locale));
		bundle.setPrefix(prefix);
		return bundle;
	}
	
	public KSPResourceBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	/* (non-Javadoc)
	 * @see java.util.PropertyResourceBundle#getKeys()
	 */
	public Enumeration<String> getKeys() {
		// TODO Auto-generated method stub
		return bundle.getKeys();
	}

	/* (non-Javadoc)
	 * @see java.util.ResourceBundle#containsKey(java.lang.String)
	 */
	public boolean containsKey(String key) {
		// TODO Auto-generated method stub
		return bundle.containsKey(key);
	}

	/* (non-Javadoc)
	 * @see java.util.ResourceBundle#getBaseBundleName()
	 */
	public String getBaseBundleName() {
		// TODO Auto-generated method stub
		return bundle.getBaseBundleName();
	}

	/* (non-Javadoc)
	 * @see java.util.ResourceBundle#getLocale()
	 */
	public Locale getLocale() {
		// TODO Auto-generated method stub
		return bundle.getLocale();
	}

	/* (non-Javadoc)
	 * @see java.util.ResourceBundle#keySet()
	 */
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		return bundle.keySet();
	}
	
	public String getString(String key) {
		return bundle.getString(prefix + "." + key);
	}
	
	public String getFormatString(String key, Object...params) {
		return String.format(getString(key), params);
	}
	
	public Object getObject(String key) {
		return bundle.getObject(key);
	}

	/**
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	

}
