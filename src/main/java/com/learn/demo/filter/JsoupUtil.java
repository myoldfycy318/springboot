package com.learn.demo.filter;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

import java.io.IOException;

/**
 * xss非法标签过滤工具类
 * 过滤html中的xss字符
 *
 */
public class JsoupUtil {

    /**
     * 使用自带的basicWithImages 白名单
     * 允许的便签有a,b,blockquote,br,cite,code,dd,dl,dt,em,i,li,ol,p,pre,q,small,span,
     * strike,strong,sub,sup,u,ul,img
     * 以及a标签的href,img标签的src,align,alt,height,width,title属性
     */
    private static final Whitelist whitelist = Whitelist.basicWithImages();

    /**
     * 配置过滤化参数,不对代码进行格式化
     */
    private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);


    public static String clean(String content) {
        if (StringUtils.isNotBlank(content)) {
            content = content.trim();
        }
        return Jsoup.clean(content, "", whitelist, outputSettings);
    }

    public static void main(String[] args) throws IOException {
        String text = "   <a href=\"http://www.baidu.com/a\" onclick=\"alert(1);\">sss</a><script>alert(0);</script>sss   ";
        System.out.println(clean(text));
    }
}