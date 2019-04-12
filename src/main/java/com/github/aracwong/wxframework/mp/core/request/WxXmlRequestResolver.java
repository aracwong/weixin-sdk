package com.github.aracwong.wxframework.mp.core.request;

import com.github.aracwong.wxframework.common.exception.WxException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aracwong
 * @version 1.0.0
 */
public class WxXmlRequestResolver {

    private Document document;
    private XPath xPath;

    private WxXmlRequestResolver() {
    }

    protected WxXmlRequestResolver(InputSource inputSource)  {
        DocumentBuilderFactory dbf = getDocumentBuilderFactory();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(inputSource);
            xPath = getXPathFactory().newXPath();
        } catch (Exception e) {
            throw new RuntimeException("初始化报文请求异常");
        }
    }

    private static class XmlFactoryHolder {
        private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        private static XPathFactory xPathFactory = XPathFactory.newInstance();

        private XmlFactoryHolder() {
        }
    }

    private static DocumentBuilderFactory getDocumentBuilderFactory() {
        return XmlFactoryHolder.documentBuilderFactory;
    }

    private static XPathFactory getXPathFactory() {
        return XmlFactoryHolder.xPathFactory;
    }

    private Object evalXPath(String expression, Object item, QName returnType) {
        item = (null == item ? document : item);
        try {
            return xPath.evaluate(expression, item, returnType);
        } catch (XPathExpressionException e) {
            throw new WxException(e);
        }
    }

    /**
     * 针对没有嵌套节点的简单处理
     *
     * @return map集合
     */
    public Map<String, String> toSimpleMap() {
        Element root = document.getDocumentElement();
        Map<String, String> params = new HashMap<>();

        // 将节点封装成map形式
        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node instanceof Element) {
                params.put(node.getNodeName(), node.getTextContent());
            }
        }
        return params;
    }

    /**
     * 获取String
     *
     * @param expression 路径
     * @return String
     */
    public String getString(String expression) {
        return (String) evalXPath(expression, null, XPathConstants.STRING);
    }

    /**
     * 获取Boolean
     *
     * @param expression 路径
     * @return String
     */
    public Boolean getBoolean(String expression) {
        return (Boolean) evalXPath(expression, null, XPathConstants.BOOLEAN);
    }

    /**
     * 获取Number
     *
     * @param expression 路径
     * @return {Number}
     */
    public Number getNumber(String expression) {
        return (Number) evalXPath(expression, null, XPathConstants.NUMBER);
    }

    /**
     * 获取某个节点
     *
     * @param expression 路径
     * @return {Node}
     */
    public Node getNode(String expression) {
        return (Node) evalXPath(expression, null, XPathConstants.NODE);
    }

    /**
     * 获取子节点
     *
     * @param expression 路径
     * @return NodeList
     */
    public NodeList getNodeList(String expression) {
        return (NodeList) evalXPath(expression, null, XPathConstants.NODESET);
    }


    /**
     * 获取String
     *
     * @param node       节点
     * @param expression 相对于node的路径
     * @return String
     */
    public String getString(Object node, String expression) {
        return (String) evalXPath(expression, node, XPathConstants.STRING);
    }

    /**
     * 获取 Boolean
     *
     * @param node       节点
     * @param expression 相对于node的路径
     * @return String
     */
    public Boolean getBoolean(Object node, String expression) {
        return (Boolean) evalXPath(expression, node, XPathConstants.BOOLEAN);
    }

    /**
     * 获取 Number
     *
     * @param node       节点
     * @param expression 相对于node的路径
     * @return {Number}
     */
    public Number getNumber(Object node, String expression) {
        return (Number) evalXPath(expression, node, XPathConstants.NUMBER);
    }

    /**
     * 获取某个节点
     *
     * @param node       节点
     * @param expression 路径
     * @return {Node}
     */
    public Node getNode(Object node, String expression) {
        return (Node) evalXPath(expression, node, XPathConstants.NODE);
    }

    /**
     * 获取子节点
     *
     * @param node       节点
     * @param expression 相对于node的路径
     * @return NodeList
     */
    public NodeList getNodeList(Object node, String expression) {
        return (NodeList) evalXPath(expression, node, XPathConstants.NODESET);
    }
}
