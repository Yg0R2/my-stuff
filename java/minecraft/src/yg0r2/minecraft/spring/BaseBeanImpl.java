/**
 * 
 */
package yg0r2.minecraft.spring;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import jodd.util.StringTemplateParser;
import yg0r2.core.MapMacroResolver;

/**
 * @author Yg0R2
 *
 */
public class BaseBeanImpl implements BaseBean {

	private Map<String, String> _context;

	public BaseBeanImpl() {
	}

	public BaseBeanImpl(Map<String, String> context) {
		_context = new HashMap<>(context);
	}

	/* (non-Javadoc)
	 * @see yg0r2.minecraft.spring.BaseBean#getDownloadURL()
	 */
	@Override
	public URL getDownloadURL() throws MalformedURLException {
		Map<String, String> context = new HashMap<>(_context);
		context.put("fileName", getFileName());

		StringTemplateParser templateParser = new StringTemplateParser();

		String parsedURL = templateParser.parse(context.get("URL"), new MapMacroResolver(context));
		parsedURL = parsedURL.replaceAll(" ", "%20");

		return new URL(parsedURL);
	}

	/* (non-Javadoc)
	 * @see yg0r2.minecraft.spring.BaseBean#getFileName()
	 */
	@Override
	public String getFileName() {
		StringTemplateParser templateParser = new StringTemplateParser();

		return templateParser.parse(_context.get("fileName"), new MapMacroResolver(_context));
	}

	/**
	 * @return the homePage
	 */
	public String getHomePage() {
		return _context.get("homePage");
	}

	/**
	 * @param homePage the homePage to set
	 */
	public void setHomePage(String homePage) {
		_context.put("homePage", homePage);
	}

}
