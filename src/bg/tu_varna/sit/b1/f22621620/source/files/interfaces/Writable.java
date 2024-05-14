package bg.tu_varna.sit.b1.f22621620.source.files.interfaces;

import org.w3c.dom.Document;

import java.io.OutputStream;

public interface Writable {
    void write(Document document, OutputStream outputStream) throws Exception;
    void writeXml(Document document) throws Exception;
}
