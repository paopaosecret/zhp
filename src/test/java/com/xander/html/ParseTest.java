package com.xander.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaobing04 on 2019/12/23.
 */
public class ParseTest {
    public static String[] keyArray = {"联系人", "手机", "项目名称", "发布时间"};
    public static void main(String[] args) {
        //6.Jsoup解析html
        Document document = Jsoup.parse(html1);
        Elements elements = document.getElementsByTag("td");
        if(elements != null){
            List<String> textList = elements.eachText();
            if(textList != null && textList.size() > 0){
                List<String> strings = new ArrayList<>();
                for(String text : textList){
                    strings.add(text.replaceAll(" ",""));
                    System.out.println(text.replaceAll(" ",""));
                }
                System.out.println("\n\n----------------------------------------------------------");
                if(strings.contains("联系人")){
                    int index = strings.indexOf("联系人");
                    System.out.println("联系人:"+ strings.get(index + 1));
                }
            }
        }


    }

    public static void parseOld(){
        //6.Jsoup解析html
        Document document = Jsoup.parse(html2);
        Elements elements = document.getElementsByTag("tr");
        Element element = elements.get(0);
        Elements elements1 = element.getElementsByTag("input");
        Element inputElement = elements1.get(0);
        String value = inputElement.attr("value");
        System.out.println("value = " + value);
        if(elements != null){
            List<String> textList = elements.eachText();
            if(textList != null &&textList.size() > 0){
                for(String str : textList){
                    System.out.println(str);
//                    String string[] = str.split("：");
//                    if(string.length == 2){
//                        System.out.println("key = " + string[0] + ",value = " + string[1]);
//                    }
                }
            }
        }else{
            System.out.println("strong Tag为空");
        }
    }

    public  static void parseTest(){
        /**
         * 下面是Jsoup展现自我的平台
         */
        //6.Jsoup解析html
        Document document = Jsoup.parse(html);
        //像js一样，通过标签获取title
        System.out.println(document.getElementsByTag("strong"));
        //像js一样，通过id 获取文章列表元素对象
        Element postList = document.getElementById("post_list");
        //像js一样，通过class 获取列表下的所有博客
        Elements postItems = postList.getElementsByClass("post_item");
        //循环处理每篇博客
        for (Element postItem : postItems) {
            //像jquery选择器一样，获取文章标题元素
            Elements titleEle = postItem.select(".post_item_body a[class='titlelnk']");
            //获取元素文本属性
            System.out.println("文章标题:" + titleEle.text());

            //获取元素的某个属性的值
            System.out.println("文章地址:" + titleEle.attr("href"));
            //像jquery选择器一样，获取文章作者元素
            Elements footEle = postItem.select(".post_item_foot a[class='lightblue']");
            System.out.println("文章作者:" + footEle.text());;
            System.out.println("作者主页:" + footEle.attr("href"));
            System.out.println("*********************************");
        }
    }

    static String html = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head><title>\n" +
            "\n" +
            "</title><link href=\"//static.bidcenter.com.cn/css/www/zhaobiao/css/register/pop_up.css\" rel=\"stylesheet\" type=\"text/css\" /><link href=\"//static.bidcenter.com.cn/css/www/zhaobiao/css/detailzhongbiao/zbgg_sin.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
            "    <script src=\"//static.bidcenter.com.cn/js/www/js/jquery-1.8.2.min.js\" type=\"text/javascript\"></script>\n" +
            "    <script src=\"//static.bidcenter.com.cn/js/www/resource/flash/js/flexpaper_flash.js\"></script>\n" +
            "    <style type=\"text/css\">\n" +
            "        .main-text p, .main-left .xq-prompt p { line-height: 34px; color: #000000; font-size: 14px; font-family: \"微软雅黑\"; margin: 0; }\n" +
            "        .zdynr table { font-family: verdana,arial,sans-serif; font-size: 11px; color: #333333; border-width: 1px; border-color: #666666; border-collapse: collapse; }\n" +
            "            .zdynr table th { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #dedede; }\n" +
            "            .zdynr table td { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #ffffff; }\n" +
            "        .classdip, .disdip, .cidp, .ddpi, .ssie, .ppisd, .pidss, .hfds, .erdg, .fuioj, .grdhd, .dpdis, .isid, .dnxkig, .sekjg, .diowen { display: none; }\n" +
            "        #gethigh span { color: black; }\n" +
            "            #gethigh span.jc { color: #f00; }\n" +
            "        #news_contet_detail .zdynr h1, h2, h3, h4, h5 { font-size: 14px; font-weight: 100; }\n" +
            "        .lxfs_text { color: #ff0000; text-decoration: none; display: inline-block; font-family: '微软雅黑'; }\n" +
            "            .lxfs_text:hover { color: #ff0000; }\n" +
            "            .lxfs_text b { font-weight: normal; }\n" +
            "            .lxfs_text:hover b { text-decoration: underline; }\n" +
            "        .qyxq_text { color: #ff0000; text-decoration: none; display: inline-block; font-family: '微软雅黑'; }\n" +
            "            .qyxq_text:hover { color: #ff0000; }\n" +
            "            .qyxq_text b { font-weight: normal; }\n" +
            "            .qyxq_text:hover b { text-decoration: underline; }\n" +
            "        .lxfs_icon { background: url(//img.bidcenter.com.cn/www/zhaobiao/images/detailzhongbiao/zbtykt-03.jpg) no-repeat; background-position: 0px 10px; width: 20px; display: inline-block; }\n" +
            "        .user_icon { background: url(//img.bidcenter.com.cn/www/image/tel_icon.png) no-repeat; background-position: -37px 2px; width: 20px; display: inline-block; }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<script type=\"text/javascript\">\n" +
            "    if(parent!=null){\n" +
            "        function changeParen(a) {\n" +
            "            var iheight = document.getElementById('gethigh').scrollHeight;\n" +
            "            var iwidth = document.getElementById('gethigh').scrollWidth;\n" +
            "            parent.document.getElementById('iframe_content').style.height = iheight + 40 + \"px\";\n" +
            "            if (a == 1) {\n" +
            "                parent.document.getElementById('iframe_content').style.width = (iwidth + 40) + \"px\";\n" +
            "            }\n" +
            "            parent.document.getElementById('iframe_content').style.border = \"0\";\n" +
            "            parent.$(\"#iframe_content\").css(\"overflow-y\", \"hidden\");\n" +
            "        }\n" +
            "        function changeParenBack() {\n" +
            "            parent.document.getElementById('iframe_content').style.width = parent.$('#news_contet_detail').outerWidth() + \"px\";\n" +
            "        }\n" +
            "        var st = setInterval(function () {\n" +
            "            changeParen();\n" +
            "        }, 500);\n" +
            "        window.onload = function () {\n" +
            "            changeParen();\n" +
            "            clearInterval(st);\n" +
            "        }\n" +
            "    }\n" +
            "    var yuanshiURL=\"\";\n" +
            "    function jq_showYuanwen(url){\n" +
            "        yuanshiURL=url;\n" +
            "        parent.layer.confirm(\"您将跳出采招网访问原文地址，确认访问么？\", function (e) {\n" +
            "            parent.layer.close(e);\n" +
            "            window.open(yuanshiURL);\n" +
            "        });\n" +
            "\n" +
            "    }\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    var ixZbt = false;\n" +
            "    var islogin = true;\n" +
            "    var isfufei = true;\n" +
            "    var applyed=false;\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    $(\".lxfs_text\").live(\"click\", function () {\n" +
            "        if (ixZbt) {\n" +
            "            var company = $(this).attr(\"data-company\");\n" +
            "            var realcom = $(this).attr(\"real-com\");\n" +
            "            parent.fjclick(company, realcom);\n" +
            "        } else if (isfufei && applyed)\n" +
            "            parent.layer.alert(\"中标通开通申请已提交，稍候会有专人与您联系！咨询电话：400-810-9688\", 0);\n" +
            "        else\n" +
            "            parent.location.href = \"/BuserCenter/zhongbiaotong/ApplyZbt.aspx?id=84298128\";\n" +
            "    });\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    $(\"#gethigh a:not(.lxfs_text)\").attr(\"target\", \"_blank\");\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    var MoJibie = 0;\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    $(function () {\n" +
            "        switch (MoJibie) {\n" +
            "            case 1:\n" +
            "                parent.layer.alert(\"您的会员级别为“移动标准会员”，请在移动端查看该信息！\", 7);\n" +
            "                break;\n" +
            "            case 2:\n" +
            "                parent.layer.alert(\"您的会员级别为“移动高级会员”，请在移动端查看该信息！\", 7);\n" +
            "                break;\n" +
            "            default:\n" +
            "                break;\n" +
            "        }\n" +
            "    })\n" +
            "</script>\n" +
            "<body>\n" +
            "    <form name=\"form1\" method=\"post\" action=\"./NewIframeart.aspx?id=84298128&amp;type=5&amp;vcode=dd1528f3a1ab5af5&amp;keyword=\" id=\"form1\">\n" +
            "<div>\n" +
            "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/wEPDwUKLTMxMzAyNjg3MmRktLrHoiuZ+WdV99eUGzvhJkqajNB7OpidxmDvTfrPKLg=\" />\n" +
            "</div>\n" +
            "\n" +
            "<div>\n" +
            "\n" +
            "\t<input type=\"hidden\" name=\"__VIEWSTATEGENERATOR\" id=\"__VIEWSTATEGENERATOR\" value=\"35402B1E\" />\n" +
            "</div>\n" +
            "        <div id=\"gethigh\" class=\"main-text\">\n" +
            "            <p>\n" +
            "                <div class='zdynr' style='padding:10px; line-height:24px;'><br =\"main_info\"  =\"margin:10px 20px;padding:0px;:0px none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;\">\n" +
            "\t\t<ul =\"ul2 clearfix\"  =\"margin:0px;padding:0px;:0px none;list- :none outside none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;font-size:14px;zoom:1;\">\n" +
            "\t\t\t<li =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1; :923.991px;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>询价单单号：</strong>&nbsp;<span =\"shop\" id=\"ECS_SHOPPRICE\"  =\"font-family:Arial;font-size:18px;color:#E4393C;font-weight:bold;\">RFQ1912130095</span>\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1; :923.991px;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>询价单名称：</strong>鲁西集团叉车车棚询价单20191213\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li =\"clearfix\" \"=\"\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>发布时间：</strong>2019-12-13 10:42:14\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>状态：</strong>询价进行中\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li id=\"endtime\" =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>结束时间：</strong>2019-12-16 16:00:00\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>结算方式：</strong>网银支付\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1; :923.991px;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>付款条件：</strong>到货验收合格，开具13%税率的全额增值税专用发票，入账后次月付全款。\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1; :923.991px;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>备注：</strong>****（请<a target='_blank' href=\"http://cg.lxhg.com/user.php\"  =\"text-decoration-line:none;color:red;margin:0px;padding:0px;:0px none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;\">登录</a>查看）\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1; :923.991px;color:red;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>定标规则：</strong> 普通低价定标，可选择性报价，无法供货的产品价格必须填写“0”。\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1; :923.991px;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<strong>资质要求：</strong>\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li id=\"Countdown\" =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1; :923.991px;\">\n" +
            "\t\t\t\t<dd =\"shop\" id=\"Countdown_dd\"  =\"margin:0px;padding:0px;:none;list- -type:none;font-family:Arial;font-size:18px;color:#E4393C;font-weight:bold;\">\n" +
            "\t\t\t\t\t<strong>距询价结束还有：</strong>&nbsp;<span id=\"_d\">3天</span>&nbsp;<span id=\"_h\">04时</span>&nbsp;<span id=\"_m\">54分</span>&nbsp;<span id=\"_s\">43秒</span>\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t\t<li =\"clearfix\"  =\"margin:0px;padding:3px 0px;:0px none;list- -type:none;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1; :923.991px;text-align:center;\">\n" +
            "\t\t\t\t<dd  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t\t\t\t<a target='_blank' href=\"http://cg.lxhg.com/article_cat.php?id=6\"  =\"text-decoration-line:none;color:#E4393C;margin:0px;padding:0px;:0px none;font- :inherit;font-variant:inherit;font-weight:bold;font-stretch:inherit;line-height:inherit;font-size:18px;font-family:Arial;\">供应商曝光台</a>\n" +
            "\t\t\t\t</dd>\n" +
            "\t\t\t</li>\n" +
            "\t\t</ul>\n" +
            "\t<br id=\"com_b\" =\"history clearfix\"  =\"margin:0px;padding:0px;- :0px 0px 3px;- :none none solid;-top-color:initial;-right-color:initial;-bottom-color:#DB111D;-left-color:initial;-image:initial;font- :inherit;font-variant:inherit;font-weight:inherit;font-stretch:inherit;line-height:inherit;zoom:1;\">\n" +
            "\t\t\t<h2  =\"margin:0px 5px 0px 0px;padding:0px;:none;list- -type:none;height:32px;line-height:32px; :148px;text-align:center;font-size:12px;float:left;color:#FFFFFF;background:#DB111D;\">\n" +
            "\t\t\t\t询价单详情——请报价\n" +
            "\t\t\t</h2>\n" +
            "\t\t</br>\n" +
            "\t<form method=\"post\" action=\"http://cg.lxhg.com/user.php\" name=\"listForm\" id=\"listForm\"  =\"margin:0px;padding:0px;:none;list- -type:none;\">\n" +
            "\t\t<table border=\"1\" id=\"RFQTable\" =\"RFQTable\" cellpadding=\"3\" cellspacing=\"1\"  =\"-spacing:0px;font-size:12px; :962.727px;margin:10px 0px;- :solid;-color:#ADD9C0;-image:initial;- :1px 0px 0px 1px;\">\n" +
            "\t\t\t<tbody>\n" +
            "\t\t\t\t<tr>\n" +
            "\t\t\t\t\t<th =\" 70\"  =\"text-align:center; :70px;vertical-align:middle;- :solid;-color:#ADD9C0;-image:initial;- :0px 1px 1px 0px;padding-left:10px;\">\n" +
            "\t\t\t\t\t\t物料代码\n" +
            "\t\t\t\t\t</th>\n" +
            "\t\t\t\t\t<th =\" 60\"  =\"text-align:center; :60px;vertical-align:middle;- :solid;-color:#ADD9C0;-image:initial;- :0px 1px 1px 0px;padding-left:10px;\">\n";


    private static String html1= "\n" +
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "\n" +
            "<head><title>\n" +
            "\n" +
            "\n" +
            "\n" +
            "</title><link href=\"//static.bidcenter.com.cn/css/www/zhaobiao/css/register/pop_up.css\" rel=\"stylesheet\" type=\"text/css\" /><link href=\"//static.bidcenter.com.cn/css/www/zhaobiao/css/detailzhongbiao/zbgg_sin.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
            "\n" +
            "    <script src=\"//static.bidcenter.com.cn/js/www/js/jquery-1.8.2.min.js\" type=\"text/javascript\"></script>\n" +
            "\n" +
            "    <script src=\"//static.bidcenter.com.cn/js/www/resource/flash/js/flexpaper_flash.js\"></script>\n" +
            "\n" +
            "    <style type=\"text/css\">\n" +
            "\n" +
            "        .main-text p, .main-left .xq-prompt p { line-height: 34px; color: #000000; font-size: 14px; font-family: \"微软雅黑\"; margin: 0; }\n" +
            "\n" +
            "        .zdynr table { font-family: verdana,arial,sans-serif; font-size: 11px; color: #333333; border-width: 1px; border-color: #666666; border-collapse: collapse; }\n" +
            "\n" +
            "            .zdynr table th { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #dedede; }\n" +
            "\n" +
            "            .zdynr table td { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #ffffff; }\n" +
            "\n" +
            "        .classdip, .disdip, .cidp, .ddpi, .ssie, .ppisd, .pidss, .hfds, .erdg, .fuioj, .grdhd, .dpdis, .isid, .dnxkig, .sekjg, .diowen { display: none; }\n" +
            "\n" +
            "        #gethigh span { color: black; }\n" +
            "\n" +
            "            #gethigh span.jc { color: #f00; }\n" +
            "\n" +
            "        #news_contet_detail .zdynr h1, h2, h3, h4, h5 { font-size: 14px; font-weight: 100; }\n" +
            "\n" +
            "        .lxfs_text { color: #ff0000; text-decoration: none; display: inline-block; font-family: '微软雅黑'; }\n" +
            "\n" +
            "            .lxfs_text:hover { color: #ff0000; }\n" +
            "\n" +
            "            .lxfs_text b { font-weight: normal; }\n" +
            "\n" +
            "            .lxfs_text:hover b { text-decoration: underline; }\n" +
            "\n" +
            "        .qyxq_text { color: #ff0000; text-decoration: none; display: inline-block; font-family: '微软雅黑'; }\n" +
            "\n" +
            "            .qyxq_text:hover { color: #ff0000; }\n" +
            "\n" +
            "            .qyxq_text b { font-weight: normal; }\n" +
            "\n" +
            "            .qyxq_text:hover b { text-decoration: underline; }\n" +
            "\n" +
            "        .lxfs_icon { background: url(//img.bidcenter.com.cn/www/zhaobiao/images/detailzhongbiao/zbtykt-03.jpg) no-repeat; background-position: 0px 10px; width: 20px; display: inline-block; }\n" +
            "\n" +
            "        .user_icon { background: url(//img.bidcenter.com.cn/www/image/tel_icon.png) no-repeat; background-position: -37px 2px; width: 20px; display: inline-block; }\n" +
            "\n" +
            "    </style>\n" +
            "\n" +
            "</head>\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "\n" +
            "    if(parent!=null){\n" +
            "\n" +
            "        function changeParen(a) {\n" +
            "\n" +
            "            var iheight = document.getElementById('gethigh').scrollHeight;\n" +
            "\n" +
            "            var iwidth = document.getElementById('gethigh').scrollWidth;\n" +
            "\n" +
            "            parent.document.getElementById('iframe_content').style.height = iheight + 40 + \"px\";\n" +
            "\n" +
            "            if (a == 1) {\n" +
            "\n" +
            "                parent.document.getElementById('iframe_content').style.width = (iwidth + 40) + \"px\";\n" +
            "\n" +
            "            }\n" +
            "\n" +
            "            parent.document.getElementById('iframe_content').style.border = \"0\";\n" +
            "\n" +
            "            parent.$(\"#iframe_content\").css(\"overflow-y\", \"hidden\");\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        function changeParenBack() {\n" +
            "\n" +
            "            parent.document.getElementById('iframe_content').style.width = parent.$('#news_contet_detail').outerWidth() + \"px\";\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        var st = setInterval(function () {\n" +
            "\n" +
            "            changeParen();\n" +
            "\n" +
            "        }, 500);\n" +
            "\n" +
            "        window.onload = function () {\n" +
            "\n" +
            "            changeParen();\n" +
            "\n" +
            "            clearInterval(st);\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "    var yuanshiURL=\"\";\n" +
            "\n" +
            "    function jq_showYuanwen(url){\n" +
            "\n" +
            "        yuanshiURL=url;\n" +
            "\n" +
            "        parent.layer.confirm(\"您将跳出采招网访问原文地址，确认访问么？\", function (e) {\n" +
            "\n" +
            "            parent.layer.close(e);\n" +
            "\n" +
            "            window.open(yuanshiURL);\n" +
            "\n" +
            "        });\n" +
            "\n" +
            "\n" +
            "    }\n" +
            "\n" +
            "</script>\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "\n" +
            "    var ixZbt = false;\n" +
            "\n" +
            "    var islogin = true;\n" +
            "\n" +
            "    var isfufei = true;\n" +
            "\n" +
            "    var applyed=false;\n" +
            "\n" +
            "</script>\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "\n" +
            "    $(\".lxfs_text\").live(\"click\", function () {\n" +
            "\n" +
            "        if (ixZbt) {\n" +
            "\n" +
            "            var company = $(this).attr(\"data-company\");\n" +
            "\n" +
            "            var realcom = $(this).attr(\"real-com\");\n" +
            "\n" +
            "            parent.fjclick(company, realcom);\n" +
            "\n" +
            "        } else if (isfufei && applyed)\n" +
            "\n" +
            "            parent.layer.alert(\"中标通开通申请已提交，稍候会有专人与您联系！咨询电话：400-810-9688\", 0);\n" +
            "\n" +
            "        else\n" +
            "\n" +
            "            parent.location.href = \"/BuserCenter/zhongbiaotong/ApplyZbt.aspx?id=84167055\";\n" +
            "\n" +
            "    });\n" +
            "\n" +
            "</script>\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "\n" +
            "    $(\"#gethigh a:not(.lxfs_text)\").attr(\"target\", \"_blank\");\n" +
            "\n" +
            "</script>\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "\n" +
            "    var MoJibie = 0;\n" +
            "\n" +
            "</script>\n" +
            "\n" +
            "<script type=\"text/javascript\">\n" +
            "\n" +
            "    $(function () {\n" +
            "\n" +
            "        switch (MoJibie) {\n" +
            "\n" +
            "            case 1:\n" +
            "\n" +
            "                parent.layer.alert(\"您的会员级别为“移动标准会员”，请在移动端查看该信息！\", 7);\n" +
            "\n" +
            "                break;\n" +
            "\n" +
            "            case 2:\n" +
            "\n" +
            "                parent.layer.alert(\"您的会员级别为“移动高级会员”，请在移动端查看该信息！\", 7);\n" +
            "\n" +
            "                break;\n" +
            "\n" +
            "            default:\n" +
            "\n" +
            "                break;\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "    })\n" +
            "\n" +
            "</script>\n" +
            "\n" +
            "<body>\n" +
            "\n" +
            "    <form name=\"form1\" method=\"post\" action=\"./NewIframeart.aspx?id=84167055&amp;type=5&amp;vcode=d8d504586aea2529&amp;keyword=\" id=\"form1\">\n" +
            "\n" +
            "<div>\n" +
            "\n" +
            "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/wEPDwUKLTMxMzAyNjg3MmRktLrHoiuZ+WdV99eUGzvhJkqajNB7OpidxmDvTfrPKLg=\" />\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "<div>\n" +
            "\n" +
            "\n" +
            "\n" +
            "\t<input type=\"hidden\" name=\"__VIEWSTATEGENERATOR\" id=\"__VIEWSTATEGENERATOR\" value=\"35402B1E\" />\n" +
            "\n" +
            "</div>\n" +
            "\n" +
            "        <div id=\"gethigh\" class=\"main-text\">\n" +
            "\n" +
            "            <p>\n" +
            "\n" +
            "                <div class='zdynr' style='padding:10px; line-height:24px;'><!doctype html><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><meta charset=\"utf-8\" /><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /><meta name=\"viewport\" content=\"=device-, initial-scale=1\" user-scalable=\"no\" /></head><body><br >      <p >一、项目介绍</p>      <br >营口电厂球阀采购（有技术规范）</br>            <p >二、报价须知</p>       <br >1.请仔细阅读询价文件，须按照询价文件要求编制响应文件并上传至电子商务平台，未上传响应文件视为无效报价。2.报价应含运费等一切杂费，不许另行单列报价。</br>      <p >三、基本信息</p>      <table  =\"1\" cellspacing=\"0\" cellpadding=\"1\">        <tr>          <td >采购方案名称</td>          <td >营口电厂球阀采购（有技术规范）</td>          <td >采购单位</td>          <td>华能国际电力股份有限 公司营口电厂<div class=\"pcn omi hfds\">中 国采招网*（bidcenter.com.cn）</div></td>        </tr>        <tr>          <td >采购项目类型</td>          <td >货物（物资）</td>          <td >采购项目类别</td>          <td>材料</td>        </tr>        <tr>          <td >工程项目编号</td>          <td >GA463019006</td>          <td >工程项目名称</td>          <td>2号机热力系统阀门内漏治理</td>        </tr>        <tr>          <td >寻源类型</td>          <td >询价</td>          <td >寻源方式</td>          <td>合格供应商公开</td>        </tr>        <tr>          <td >评价原则</td>          <td >经评审最低评标价法</td>          <td >是否紧急采购</td>          <td>  否  </td>        </tr>      </table>      <p >四、报价要求</p>      <table  =\"1\" cellspacing=\"0\" cellpadding=\"1\">        <tr>          <td >结算币种</td>          <td >人民币</td>          <td >报价截止前是否允许            供应商修改报价</td>          <td>  允许  </td>        </tr>        <tr>          <td >是否缴纳保证金</td>          <td >  否  </td>          <td >保证金金额（元）</td>          <td>                    </td>        </tr>        <tr>          <td >报价开始时间</td>          <td >2019-12-12 08:39:12</td>          <td >报价截止时间</td>          <td>2019-12-20 08:39:12</td>        </tr>                 <tr>          <td >答疑／澄清时间</td>          <td colspan=\"3\">2019-12-12 08:39:19 至 2019-12-19 08:39:12</td>        </tr>              </table>      <p >五、产品信息</p>      <br >        <table  cellpadding=\"0\" cellspacing=\"0\">        <thead><tr><td>序号</td><td>计划号</td><td>物料编码</td><td>物料描述</td><td>物料组</td><td>物料组描述</td><td>采购明细</td><td>数量</td><td>计量单位</td><td>计量单位描述</td><td>标段或设备名称、规格型号</td><td>计划采购时间</td><td>计划交货日期</td><td>安装时间</td><td>需求单位</td><td>交货地址</td><td  >用途及说明</td></tr></thead>  <tr><td>1</td><td>10</td> <td>101831144</td><td>球阀\\1″-4500#-F91</td><td>03442007</td><td>球阀</td><td></td><td>2.000</td><td>PC</td><td>件</td><td></td><td>2019-11-30</td><td>2019-11-30</td><td></td><td>华能国际电力股份有限公司营口电厂</td><td></td><td></td></tr><tr><td>2</td><td>20</td> <td>101831146</td><td>球阀\\1″-1500#-F22</td><td>03442007</td><td>球阀</td><td></td><td>22.000</td><td>PC</td><td>件</td><td></td><td>2019-11-30</td><td>2019-11-30</td><td></td><td>华能国际电力股份有限公司营口电厂</td><td></td><td></td></tr><tr><td>3</td><td>30</td> <td>101831149</td><td>球阀\\2.5″-1500#-A105</td><td>03442007</td><td>球阀</td><td></td><td>2.000</td><td>PC</td><td>件</td><td></td><td>2019-11-30</td><td>2019-11-30</td><td></td><td>华能国际电力股份有限公司营口电厂</td><td></td><td></td></tr><tr><td>4</td><td>40</td> <td>101831150</td><td>球阀\\2.5″-1500#-F22</td><td>03442007</td><td>球阀</td><td></td><td>9.000</td><td>PC</td><td>件</td><td></td><td>2019-11-30</td><td>2019-11-30</td><td></td><td>华能国际电力股份有限公司营口电厂</td><td></td><td></td></tr><tr><td>5</td><td>50</td> <td>101831152</td><td>球阀\\2.5″-4500#-A105</td><td>03442007</td><td>球阀</td><td></td><td>6.000</td><td>PC</td><td>件</td><td></td><td>2019-11-30</td><td>2019-11-30</td><td></td><td>华能国际电力股份有限公司营口电厂</td><td></td><td></td></tr><tr><td>6</td><td>60</td> <td>101831153</td><td>球阀\\3″-1500#-F22</td><td>03442007</td><td>球阀</td><td></td><td>4.000</td><td>PC</td><td>件</td><td></td><td>2019-11-30</td><td>2019-11-30</td><td></td><td>华能国际电力股份有限公司营口电厂</td><td></td><td></td></tr>                  </table>      </br>      <p >六、联系人信息</p>       <table  =\"1\" cellspacing=\"0\" cellpadding=\"1\">       <tr>          <td >联系人</td>          <td >杜晓玉</td>          <td >询价单位</td>          <td>           华能国际电力股份有限公司营口电厂  </td>        </tr>         <tr>          <td >联系电话</td>          <td > 0417-6882236</td>          <td >传真</td>          <td>             </td>        </tr>         <tr>          <td >邮编</td>          <td >           115007</td>          <td >Email</td>          <td>           duxiaoyu.yk@hpi.com.cn  </td>        </tr>         <tr>          <td >手机</td>          <td >13841735119</td>          <td >联系地址</td>          <td>            </td>        </tr>       </table>              <p >七、附件</p>       <br >              <p >       <a  target='_blank' href=\"http://hnec-pro-public.oss-cn-beijing.aliyuncs.com/SourceAuth/1471028/ca656eed-4b66-48b5-bf2f-7821eb1217b6/华能营口电厂主、再热蒸汽管道进口疏水球阀招标技术规范书.docx\">华能营口电厂主、再热蒸汽管道进口疏水球阀招标技术规范书.docx</a>       </p>              <p >       <a  target='_blank' href=\"http://hnec-pro-public.oss-cn-beijing.aliyuncs.com/SourceAuth/1471028/fbc6c208-77fa-4aec-bdba-72da7e91793d/华能营口电厂2号机主、再热蒸汽管道进口疏水球阀询价文件.doc\">华能营口电厂2号机主、再热蒸汽管道进口疏水球阀询价文件.doc</a>       </p>              <br ><a  onclick=\"checkIsLogin(544169,1471028,,2019-12-20 08:39:12,yes)\"></br> </body></html>                        </br></div>\n" +
            "\n" +
            "                \n" +
            "\n" +
            "            </p>\n" +
            "\n" +
            "            \n" +
            "\n" +
            "            <div style=\"margin-top: 30px; border: 1px solid #16A8F4; width: 120px; height: 30px; line-height: 30px; text-align: center;\">\n" +
            "\n" +
            "                <a href=\"javascript:;\" target=\"_blank\" style=\"color: #16A8F4; display: block; width: 100%;\"\n" +
            "\n" +
            "                    onclick=\"baoming()\">报名地址</a>\n" +
            "\n" +
            "            </div>\n" +
            "\n" +
            "            <script type=\"text/javascript\">\n" +
            "\n" +
            "                var baominghref = 'http://ec.chng.com.cn/ecmall/announcement/announcementDetail.do?announcementId=11435249';\n" +
            "\n" +
            "                function baoming() {\n" +
            "\n" +
            "                    parent.layer.confirm(\"您将跳出采招网访问原始报名地址，确认访问么？\", function (e) {\n" +
            "\n" +
            "                        parent.layer.close(e);\n" +
            "\n" +
            "                        window.open(baominghref);\n" +
            "\n" +
            "                    });\n" +
            "\n" +
            "                }\n" +
            "\n" +
            "            </script>\n" +
            "\n" +
            "            \n" +
            "\n" +
            "        </div>\n" +
            "\n" +
            "        <script>\n" +
            "\n" +
            "            $(\"#gethigh img\").css(\"max-width\", \"800px\")\n" +
            "\n" +
            "        </script>\n" +
            "\n" +
            "    </form>\n" +
            "\n" +
            "</body>\n" +
            "\n" +
            "</html>\n";

    private static String html2 = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
            "<head><title>\n" +
            "\n" +
            "</title><link href=\"//static.bidcenter.com.cn/css/www/zhaobiao/css/register/pop_up.css\" rel=\"stylesheet\" type=\"text/css\" /><link href=\"//static.bidcenter.com.cn/css/www/zhaobiao/css/detailzhongbiao/zbgg_sin.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
            "    <script src=\"//static.bidcenter.com.cn/js/www/js/jquery-1.8.2.min.js\" type=\"text/javascript\"></script>\n" +
            "    <script src=\"//static.bidcenter.com.cn/js/www/resource/flash/js/flexpaper_flash.js\"></script>\n" +
            "    <style type=\"text/css\">\n" +
            "        .main-text p, .main-left .xq-prompt p { line-height: 34px; color: #000000; font-size: 14px; font-family: \"微软雅黑\"; margin: 0; }\n" +
            "        .zdynr table { font-family: verdana,arial,sans-serif; font-size: 11px; color: #333333; border-width: 1px; border-color: #666666; border-collapse: collapse; }\n" +
            "            .zdynr table th { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #dedede; }\n" +
            "            .zdynr table td { border-width: 1px; padding: 8px; border-style: solid; border-color: #666666; background-color: #ffffff; }\n" +
            "        .classdip, .disdip, .cidp, .ddpi, .ssie, .ppisd, .pidss, .hfds, .erdg, .fuioj, .grdhd, .dpdis, .isid, .dnxkig, .sekjg, .diowen { display: none; }\n" +
            "        #gethigh span { color: black; }\n" +
            "            #gethigh span.jc { color: #f00; }\n" +
            "        #news_contet_detail .zdynr h1, h2, h3, h4, h5 { font-size: 14px; font-weight: 100; }\n" +
            "        .lxfs_text { color: #ff0000; text-decoration: none; display: inline-block; font-family: '微软雅黑'; }\n" +
            "            .lxfs_text:hover { color: #ff0000; }\n" +
            "            .lxfs_text b { font-weight: normal; }\n" +
            "            .lxfs_text:hover b { text-decoration: underline; }\n" +
            "        .qyxq_text { color: #ff0000; text-decoration: none; display: inline-block; font-family: '微软雅黑'; }\n" +
            "            .qyxq_text:hover { color: #ff0000; }\n" +
            "            .qyxq_text b { font-weight: normal; }\n" +
            "            .qyxq_text:hover b { text-decoration: underline; }\n" +
            "        .lxfs_icon { background: url(//img.bidcenter.com.cn/www/zhaobiao/images/detailzhongbiao/zbtykt-03.jpg) no-repeat; background-position: 0px 10px; width: 20px; display: inline-block; }\n" +
            "        .user_icon { background: url(//img.bidcenter.com.cn/www/image/tel_icon.png) no-repeat; background-position: -37px 2px; width: 20px; display: inline-block; }\n" +
            "    </style>\n" +
            "</head>\n" +
            "<script type=\"text/javascript\">\n" +
            "    if(parent!=null){\n" +
            "        function changeParen(a) {\n" +
            "            var iheight = document.getElementById('gethigh').scrollHeight;\n" +
            "            var iwidth = document.getElementById('gethigh').scrollWidth;\n" +
            "            parent.document.getElementById('iframe_content').style.height = iheight + 40 + \"px\";\n" +
            "            if (a == 1) {\n" +
            "                parent.document.getElementById('iframe_content').style.width = (iwidth + 40) + \"px\";\n" +
            "            }\n" +
            "            parent.document.getElementById('iframe_content').style.border = \"0\";\n" +
            "            parent.$(\"#iframe_content\").css(\"overflow-y\", \"hidden\");\n" +
            "        }\n" +
            "        function changeParenBack() {\n" +
            "            parent.document.getElementById('iframe_content').style.width = parent.$('#news_contet_detail').outerWidth() + \"px\";\n" +
            "        }\n" +
            "        var st = setInterval(function () {\n" +
            "            changeParen();\n" +
            "        }, 500);\n" +
            "        window.onload = function () {\n" +
            "            changeParen();\n" +
            "            clearInterval(st);\n" +
            "        }\n" +
            "    }\n" +
            "    var yuanshiURL=\"\";\n" +
            "    function jq_showYuanwen(url){\n" +
            "        yuanshiURL=url;\n" +
            "        parent.layer.confirm(\"您将跳出采招网访问原文地址，确认访问么？\", function (e) {\n" +
            "            parent.layer.close(e);\n" +
            "            window.open(yuanshiURL);\n" +
            "        });\n" +
            "\n" +
            "    }\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    var ixZbt = false;\n" +
            "    var islogin = true;\n" +
            "    var isfufei = true;\n" +
            "    var applyed=false;\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    $(\".lxfs_text\").live(\"click\", function () {\n" +
            "        if (ixZbt) {\n" +
            "            var company = $(this).attr(\"data-company\");\n" +
            "            var realcom = $(this).attr(\"real-com\");\n" +
            "            parent.fjclick(company, realcom);\n" +
            "        } else if (isfufei && applyed)\n" +
            "            parent.layer.alert(\"中标通开通申请已提交，稍候会有专人与您联系！咨询电话：400-810-9688\", 0);\n" +
            "        else\n" +
            "            parent.location.href = \"/BuserCenter/zhongbiaotong/ApplyZbt.aspx?id=84429628\";\n" +
            "    });\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    $(\"#gethigh a:not(.lxfs_text)\").attr(\"target\", \"_blank\");\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    var MoJibie = 0;\n" +
            "</script>\n" +
            "<script type=\"text/javascript\">\n" +
            "    $(function () {\n" +
            "        switch (MoJibie) {\n" +
            "            case 1:\n" +
            "                parent.layer.alert(\"您的会员级别为“移动标准会员”，请在移动端查看该信息！\", 7);\n" +
            "                break;\n" +
            "            case 2:\n" +
            "                parent.layer.alert(\"您的会员级别为“移动高级会员”，请在移动端查看该信息！\", 7);\n" +
            "                break;\n" +
            "            default:\n" +
            "                break;\n" +
            "        }\n" +
            "    })\n" +
            "</script>\n" +
            "<body>\n" +
            "    <form name=\"form1\" method=\"post\" action=\"./NewIframeart.aspx?id=84429628&amp;type=2&amp;vcode=c799d61f5c16ad8b&amp;keyword=\" id=\"form1\">\n" +
            "<div>\n" +
            "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"/wEPDwUKLTMxMzAyNjg3MmRktLrHoiuZ+WdV99eUGzvhJkqajNB7OpidxmDvTfrPKLg=\" />\n" +
            "</div>\n" +
            "\n" +
            "<div>\n" +
            "\n" +
            "\t<input type=\"hidden\" name=\"__VIEWSTATEGENERATOR\" id=\"__VIEWSTATEGENERATOR\" value=\"35402B1E\" />\n" +
            "</div>\n" +
            "        <div id=\"gethigh\" class=\"main-text\">\n" +
            "            <p>\n" +
            "                <div class='zdynr' style='padding:10px; line-height:24px;'><br > <table cellspacing=\"0\" align=\"center\" >               <tr><td>一、采购人：<input  type=\"text\"  readonly=\"readonly\" value=\"梅州市梅江区伯聪学校\"/></td></tr><tr><td>二、采购项目编号：<input type=\"text\"  readonly=\"readonly\" value=\"441402-201912-360035-0012\"/></td></tr><tr><td>三、采购项目名称：                              <input type=\"text\"  readonly=\"readonly\" value=\"物业管理（保洁）\"/>                              </td></tr><tr><td>四、采购品目名称：<input type=\"text\"  readonly=\"readonly\" value=\"物业管理服务\"/></td></tr><tr><td>五、采购预算金额（元）：<input  type=\"text\"  readonly=\"readonly\" value=\"￥24,000.00\"/></td></tr><tr><td>六、采购数量：<input  type=\"text\"  readonly=\"readonly\" value=\"11\"/></td></tr><tr><td>七、需求时间：<input  type=\"text\"  readonly=\"readonly\" value=\"2019-11-14\"/></td></tr><tr><td>八、采购方式：<input  type=\"text\"  readonly=\"readonly\" value=\"定点采购\"/></td></tr><tr><td>九、备案时间：<input  type=\"text\"  readonly=\"readonly\" value=\"2019-12-16\"/></td></tr>          </table>        <br align=\"right\" >    <table cellspacing=\"0\" align=\"right\" >               <tr>           <td align=\"left\">发布人：<input  type=\"text\"  readonly=\"readonly\" value=\"梅州市梅江区伯聪学校\"/></td>           </tr>           <tr>           <td align=\"left\">发布时间：           <font class=\"beijygg isid gaputzm ukagdbc\"> 中国采招网（bidcenter.com.cn|）</font><input  type=\"text\"  readonly=\"readonly\" value=\"2019\" size=\"5\"/>年           <input  type=\"text\"  readonly=\"readonly\" value=\"12\" size=\"3\"/>月           <input  type=\"text\"  readonly=\"readonly\" value=\"16\" size=\"3\"/>日           </td>           </tr>            </table>    </br></div>\n" +
            "                \n" +
            "            </p>\n" +
            "            \n" +
            "        </div>\n" +
            "        <script>\n" +
            "            $(\"#gethigh img\").css(\"max-width\", \"800px\")\n" +
            "        </script>\n" +
            "    </form>\n" +
            "</body>\n" +
            "</html>\n";
}
