package BT_10th4.User;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;

public class XMLTienIch {
    public static void xuatXML(HashMap<String, NguoiDung> danhSach, File tep) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element goc = doc.createElement("nguoidungs");
        doc.appendChild(goc);

        for (NguoiDung nguoi : danhSach.values()) {
            Element phanTuNguoi = doc.createElement("nguoidung");

            Element tenDN = doc.createElement("tendangnhap");
            tenDN.appendChild(doc.createTextNode(nguoi.getTenDangNhap()));
            phanTuNguoi.appendChild(tenDN);

            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode(nguoi.getEmail()));
            phanTuNguoi.appendChild(email);

            goc.appendChild(phanTuNguoi);
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(tep));
    }

    public static HashMap<String, NguoiDung> nhapXML(File tep) throws Exception {
        HashMap<String, NguoiDung> ketQua = new HashMap<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(tep);

        NodeList danhSach = doc.getElementsByTagName("nguoidung");

        for (int i = 0; i < danhSach.getLength(); i++) {
            Element phanTu = (Element) danhSach.item(i);
            String ten = phanTu.getElementsByTagName("tendangnhap").item(0).getTextContent();
            String email = phanTu.getElementsByTagName("email").item(0).getTextContent();
            ketQua.put(ten, new NguoiDung(ten, "", email));
        }
        return ketQua;
    }
}