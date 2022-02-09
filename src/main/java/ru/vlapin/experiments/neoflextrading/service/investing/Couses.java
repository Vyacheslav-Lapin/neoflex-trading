package ru.vlapin.experiments.neoflextrading.service.investing;

import java.io.StringReader;
import javax.xml.transform.stream.StreamSource;
import lombok.SneakyThrows;
import lombok.experimental.ExtensionMethod;
import lombok.val;
import net.sf.saxon.s9api.Processor;
import net.sf.saxon.s9api.XdmNode;
import net.sf.saxon.s9api.XdmValue;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.SimpleXmlSerializer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
@ExtensionMethod(Double.class)
public class Couses {

  @SneakyThrows
  public double bitcoin() {
    Document document = Jsoup.connect("https://ru.investing.com/crypto/")
        .get();
    //    val text = htmlCleaner.clean(document.text()).getText().toString();

    val html = getHtmlAsString(document);

    return getValueByXpath(html, "(//td[.='BTC']/following-sibling::td)[1]/a/text()");

//    return document
//        .selectXpath("(//td[.='BTC']/following-sibling::td)[1]/a/text()", TextNode.class)
//        .get(0)
//        .text()
//        .parseDouble();
  }

  @SneakyThrows
  private String getValueByXpath(String html, String xpath) {
    Processor processor = new Processor(false);
    XdmNode xdm = processor.newDocumentBuilder().build(new StreamSource(new StringReader(html)));
    XdmValue result = processor.newXPathCompiler().evaluate(xpath, xdm);
//    result.
    return result.toString();
  }

  private static String getHtmlAsString(Document document) {
    val properties = new CleanerProperties();
    val htmlCleaner = new HtmlCleaner(properties);
    return new SimpleXmlSerializer(properties).getAsString(htmlCleaner.clean(document.html()));
  }
}
