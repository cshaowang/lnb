package nlp;

import org.apache.commons.lang3.StringUtils;

/**
 * A word is not valid if it meets any of the following criteria:
 * 
 * 1. stopword (domain independent or domain dependent).
 * 
 * 2. contains digits.
 * 
 * 3. contains punctuations.
 * 
 */
public class WordValidityHelper {
	private static WordValidityHelper _instance = null;

	public static WordValidityHelper getInstance() {
		if (_instance == null) {
			_instance = new WordValidityHelper();
		}
		return _instance;
	}

	public boolean isValid(String word, String domain) {
		// Stop word.
		if (StopWordHelper.getInstance().isDomainIndepStopWord(word)
				|| StopWordHelper.getInstance().isDomainDepStopWord(word,
						domain)) {
			return false;
		}

		// contains digits.
		if (StringUtils.isAlpha(word)) {
			// Contains letter only.
			return true;
		} else {
			return false;
		}
	}

	public boolean isStopword(String word, String domain) {
		// Stop word.
		if (StopWordHelper.getInstance().isDomainIndepStopWord(word)
				|| StopWordHelper.getInstance().isDomainDepStopWord(word,
						domain)) {
			return false;
		}
		return true;
	}
}
