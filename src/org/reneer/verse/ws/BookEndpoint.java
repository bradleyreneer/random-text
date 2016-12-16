/**
 * 
 */
package org.reneer.verse.ws;

import org.reneer.verse.PassageText;
import org.reneer.verse.RandomScriptureVerse;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;

/**
 * @author breneer
 *
 */
@Api(name = "bibleverse", )
public class BookEndpoint {

    @ApiMethod(name = "verse", httpMethod = "GET")
    public PassageText get() {
//        public String get(Integer passageNumber) {
        PassageText passageText = new PassageText();
        passageText.setText(RandomScriptureVerse.verses());
        return(passageText);
    }
}
