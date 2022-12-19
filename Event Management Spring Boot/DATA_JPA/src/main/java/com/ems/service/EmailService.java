package com.ems.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ems.model.User;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	private static String fromAddress = "Trng2@evolvingsols.com";
    private static String senderName = "Company Pvt Ltd";
	
	public boolean sendVerificationEmail(User user, String siteURL)
	        throws MessagingException, UnsupportedEncodingException {
	    String toAddress = user.getEmail();
//	    String fromAddress = "Trng2@evolvingsols.com";
//	    String senderName = "Company Pvt Ltd";
	    String subject = "Please verify your account to activate it";
	    String content = "<style rel=\"stylesheet\">\r\n" + 
	    		"/* CONFIG STYLES Please do not delete and edit CSS styles below */\r\n" + 
	    		"/* IMPORTANT THIS STYLES MUST BE ON FINAL EMAIL */\r\n" + 
	    		"#outlook a {\r\n" + 
	    		"    padding: 0;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-button {\r\n" + 
	    		"    mso-style-priority: 100 !important;\r\n" + 
	    		"    text-decoration: none !important;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"a[x-apple-data-detectors] {\r\n" + 
	    		"    color: inherit !important;\r\n" + 
	    		"    text-decoration: none !important;\r\n" + 
	    		"    font-size: inherit !important;\r\n" + 
	    		"    font-family: inherit !important;\r\n" + 
	    		"    font-weight: inherit !important;\r\n" + 
	    		"    line-height: inherit !important;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-desk-hidden {\r\n" + 
	    		"    display: none;\r\n" + 
	    		"    float: left;\r\n" + 
	    		"    overflow: hidden;\r\n" + 
	    		"    width: 0;\r\n" + 
	    		"    max-height: 0;\r\n" + 
	    		"    line-height: 0;\r\n" + 
	    		"    mso-hide: all;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"[data-ogsb] .es-button {\r\n" + 
	    		"    border-width: 0 !important;\r\n" + 
	    		"    padding: 12px 30px 12px 30px !important;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"/*\r\n" + 
	    		"END OF IMPORTANT\r\n" + 
	    		"*/\r\n" + 
	    		"body {\r\n" + 
	    		"    width: 100%;\r\n" + 
	    		"    font-family: Montserrat, sans-serif;\r\n" + 
	    		"    -webkit-text-size-adjust: 100%;\r\n" + 
	    		"    -ms-text-size-adjust: 100%;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"table {\r\n" + 
	    		"    mso-table-lspace: 0pt;\r\n" + 
	    		"    mso-table-rspace: 0pt;\r\n" + 
	    		"    border-collapse: collapse;\r\n" + 
	    		"    border-spacing: 0px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"table td,\r\n" + 
	    		"body,\r\n" + 
	    		".es-wrapper {\r\n" + 
	    		"    padding: 0;\r\n" + 
	    		"    Margin: 0;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-content,\r\n" + 
	    		".es-header,\r\n" + 
	    		".es-footer {\r\n" + 
	    		"    table-layout: fixed !important;\r\n" + 
	    		"    width: 100%;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"img {\r\n" + 
	    		"    display: block;\r\n" + 
	    		"    border: 0;\r\n" + 
	    		"    outline: none;\r\n" + 
	    		"    text-decoration: none;\r\n" + 
	    		"    -ms-interpolation-mode: bicubic;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"p,\r\n" + 
	    		"hr {\r\n" + 
	    		"    Margin: 0;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"h1,\r\n" + 
	    		"h2,\r\n" + 
	    		"h3,\r\n" + 
	    		"h4,\r\n" + 
	    		"h5 {\r\n" + 
	    		"    Margin: 0;\r\n" + 
	    		"    line-height: 120%;\r\n" + 
	    		"    mso-line-height-rule: exactly;\r\n" + 
	    		"    font-family: 'comic sans ms', 'marker felt-thin', arial, sans-serif;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"p,\r\n" + 
	    		"ul li,\r\n" + 
	    		"ol li,\r\n" + 
	    		"a {\r\n" + 
	    		"    -webkit-text-size-adjust: none;\r\n" + 
	    		"    -ms-text-size-adjust: none;\r\n" + 
	    		"    mso-line-height-rule: exactly;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-left {\r\n" + 
	    		"    float: left;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-right {\r\n" + 
	    		"    float: right;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p5 {\r\n" + 
	    		"    padding: 5px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p5t {\r\n" + 
	    		"    padding-top: 5px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p5b {\r\n" + 
	    		"    padding-bottom: 5px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p5l {\r\n" + 
	    		"    padding-left: 5px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p5r {\r\n" + 
	    		"    padding-right: 5px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p10 {\r\n" + 
	    		"    padding: 10px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p10t {\r\n" + 
	    		"    padding-top: 10px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p10b {\r\n" + 
	    		"    padding-bottom: 10px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p10l {\r\n" + 
	    		"    padding-left: 10px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p10r {\r\n" + 
	    		"    padding-right: 10px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p15 {\r\n" + 
	    		"    padding: 15px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p15t {\r\n" + 
	    		"    padding-top: 15px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p15b {\r\n" + 
	    		"    padding-bottom: 15px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p15l {\r\n" + 
	    		"    padding-left: 15px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p15r {\r\n" + 
	    		"    padding-right: 15px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p20 {\r\n" + 
	    		"    padding: 20px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p20t {\r\n" + 
	    		"    padding-top: 20px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p20b {\r\n" + 
	    		"    padding-bottom: 20px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p20l {\r\n" + 
	    		"    padding-left: 20px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p20r {\r\n" + 
	    		"    padding-right: 20px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p25 {\r\n" + 
	    		"    padding: 25px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p25t {\r\n" + 
	    		"    padding-top: 25px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p25b {\r\n" + 
	    		"    padding-bottom: 25px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p25l {\r\n" + 
	    		"    padding-left: 25px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p25r {\r\n" + 
	    		"    padding-right: 25px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p30 {\r\n" + 
	    		"    padding: 30px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p30t {\r\n" + 
	    		"    padding-top: 30px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p30b {\r\n" + 
	    		"    padding-bottom: 30px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p30l {\r\n" + 
	    		"    padding-left: 30px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p30r {\r\n" + 
	    		"    padding-right: 30px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p35 {\r\n" + 
	    		"    padding: 35px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p35t {\r\n" + 
	    		"    padding-top: 35px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p35b {\r\n" + 
	    		"    padding-bottom: 35px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p35l {\r\n" + 
	    		"    padding-left: 35px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p35r {\r\n" + 
	    		"    padding-right: 35px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p40 {\r\n" + 
	    		"    padding: 40px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p40t {\r\n" + 
	    		"    padding-top: 40px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p40b {\r\n" + 
	    		"    padding-bottom: 40px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p40l {\r\n" + 
	    		"    padding-left: 40px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-p40r {\r\n" + 
	    		"    padding-right: 40px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-menu td {\r\n" + 
	    		"    border: 0;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-menu td a img {\r\n" + 
	    		"    display: inline-block !important;\r\n" + 
	    		"    vertical-align: middle;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"/*\r\n" + 
	    		"END CONFIG STYLES\r\n" + 
	    		"*/\r\n" + 
	    		"s {\r\n" + 
	    		"    text-decoration: line-through;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"p,\r\n" + 
	    		"ul li,\r\n" + 
	    		"ol li {\r\n" + 
	    		"    font-family: Montserrat, sans-serif;\r\n" + 
	    		"    line-height: 150%;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"ul li,\r\n" + 
	    		"ol li {\r\n" + 
	    		"    Margin-bottom: 15px;\r\n" + 
	    		"    margin-left: 0;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"a {\r\n" + 
	    		"    text-decoration: underline;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-menu td a {\r\n" + 
	    		"    text-decoration: none;\r\n" + 
	    		"    display: block;\r\n" + 
	    		"    font-family: Montserrat, sans-serif;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-wrapper {\r\n" + 
	    		"    width: 100%;\r\n" + 
	    		"    height: 100%;\r\n" + 
	    		"    background-image: url('https://tlr.stripocdn.email/content/guids/CABINET_d1443c583d5718b4494ce52c68c03596/images/bghelloween.png');\r\n" + 
	    		"    background-repeat: no-repeat;\r\n" + 
	    		"    background-position: center top;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-wrapper-color,\r\n" + 
	    		".es-wrapper {\r\n" + 
	    		"    background-color: #110146;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-header {\r\n" + 
	    		"    background-color: transparent;\r\n" + 
	    		"    background-image: ;\r\n" + 
	    		"    background-repeat: repeat;\r\n" + 
	    		"    background-position: center top;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-header-body {\r\n" + 
	    		"    background-color: #ffffff;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-header-body p,\r\n" + 
	    		".es-header-body ul li,\r\n" + 
	    		".es-header-body ol li {\r\n" + 
	    		"    color: #333333;\r\n" + 
	    		"    font-size: 14px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-header-body a {\r\n" + 
	    		"    color: #2cb543;\r\n" + 
	    		"    font-size: 14px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-content-body {\r\n" + 
	    		"    background-color: #ffffff;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-content-body p,\r\n" + 
	    		".es-content-body ul li,\r\n" + 
	    		".es-content-body ol li {\r\n" + 
	    		"    color: #0c0b0b;\r\n" + 
	    		"    font-size: 14px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-content-body a {\r\n" + 
	    		"    color: #F4081E;\r\n" + 
	    		"    font-size: 14px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-footer {\r\n" + 
	    		"    background-color: transparent;\r\n" + 
	    		"    background-image: ;\r\n" + 
	    		"    background-repeat: repeat;\r\n" + 
	    		"    background-position: center top;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-footer-body {\r\n" + 
	    		"    background-color: transparent;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-footer-body p,\r\n" + 
	    		".es-footer-body ul li,\r\n" + 
	    		".es-footer-body ol li {\r\n" + 
	    		"    color: #ffffff;\r\n" + 
	    		"    font-size: 12px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-footer-body a {\r\n" + 
	    		"    color: #ffffff;\r\n" + 
	    		"    font-size: 12px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-infoblock,\r\n" + 
	    		".es-infoblock p,\r\n" + 
	    		".es-infoblock ul li,\r\n" + 
	    		".es-infoblock ol li {\r\n" + 
	    		"    line-height: 120%;\r\n" + 
	    		"    font-size: 12px;\r\n" + 
	    		"    color: #cccccc;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-infoblock a {\r\n" + 
	    		"    font-size: 12px;\r\n" + 
	    		"    color: #cccccc;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"h1 {\r\n" + 
	    		"    font-size: 39px;\r\n" + 
	    		"    font-style: normal;\r\n" + 
	    		"    font-weight: bold;\r\n" + 
	    		"    color: #ffffff;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"h2 {\r\n" + 
	    		"    font-size: 28px;\r\n" + 
	    		"    font-style: normal;\r\n" + 
	    		"    font-weight: bold;\r\n" + 
	    		"    color: #110146;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"h3 {\r\n" + 
	    		"    font-size: 20px;\r\n" + 
	    		"    font-style: normal;\r\n" + 
	    		"    font-weight: bold;\r\n" + 
	    		"    color: #110146;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-header-body h1 a,\r\n" + 
	    		".es-content-body h1 a,\r\n" + 
	    		".es-footer-body h1 a {\r\n" + 
	    		"    font-size: 39px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-header-body h2 a,\r\n" + 
	    		".es-content-body h2 a,\r\n" + 
	    		".es-footer-body h2 a {\r\n" + 
	    		"    font-size: 28px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-header-body h3 a,\r\n" + 
	    		".es-content-body h3 a,\r\n" + 
	    		".es-footer-body h3 a {\r\n" + 
	    		"    font-size: 20px;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"a.es-button,\r\n" + 
	    		"button.es-button {\r\n" + 
	    		"    border-style: solid;\r\n" + 
	    		"    border-color: #fbe99c;\r\n" + 
	    		"    border-width: 12px 30px 12px 30px;\r\n" + 
	    		"    display: inline-block;\r\n" + 
	    		"    background: #fbe99c;\r\n" + 
	    		"    border-radius: 3px;\r\n" + 
	    		"    font-size: 14px;\r\n" + 
	    		"    font-family: arial, 'helvetica neue', helvetica, sans-serif;\r\n" + 
	    		"    font-weight: bold;\r\n" + 
	    		"    font-style: normal;\r\n" + 
	    		"    line-height: 120%;\r\n" + 
	    		"    color: #040404;\r\n" + 
	    		"    text-decoration: none;\r\n" + 
	    		"    width: auto;\r\n" + 
	    		"    text-align: center;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		".es-button-border {\r\n" + 
	    		"    border-style: solid solid solid solid;\r\n" + 
	    		"    border-color: #fbe99c #fbe99c #fbe99c #fbe99c;\r\n" + 
	    		"    background: #fbe99c;\r\n" + 
	    		"    border-width: 0px 0px 0px 0px;\r\n" + 
	    		"    display: inline-block;\r\n" + 
	    		"    border-radius: 3px;\r\n" + 
	    		"    width: auto;\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"/* RESPONSIVE STYLES Please do not delete and edit CSS styles below. If you don't need responsive layout, please delete this section. */\r\n" + 
	    		"@media only screen and (max-width: 600px) {\r\n" + 
	    		"\r\n" + 
	    		"    p,\r\n" + 
	    		"    ul li,\r\n" + 
	    		"    ol li,\r\n" + 
	    		"    a {\r\n" + 
	    		"        line-height: 150% !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    h1,\r\n" + 
	    		"    h2,\r\n" + 
	    		"    h3,\r\n" + 
	    		"    h1 a,\r\n" + 
	    		"    h2 a,\r\n" + 
	    		"    h3 a {\r\n" + 
	    		"        line-height: 120%;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    h1 {\r\n" + 
	    		"        font-size: 30px !important;\r\n" + 
	    		"        text-align: left;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    h2 {\r\n" + 
	    		"        font-size: 24px !important;\r\n" + 
	    		"        text-align: left;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    h3 {\r\n" + 
	    		"        font-size: 20px !important;\r\n" + 
	    		"        text-align: left;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-header-body h1 a,\r\n" + 
	    		"    .es-content-body h1 a,\r\n" + 
	    		"    .es-footer-body h1 a {\r\n" + 
	    		"        font-size: 30px !important;\r\n" + 
	    		"        text-align: left;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-header-body h2 a,\r\n" + 
	    		"    .es-content-body h2 a,\r\n" + 
	    		"    .es-footer-body h2 a {\r\n" + 
	    		"        font-size: 24px !important;\r\n" + 
	    		"        text-align: left;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-header-body h3 a,\r\n" + 
	    		"    .es-content-body h3 a,\r\n" + 
	    		"    .es-footer-body h3 a {\r\n" + 
	    		"        font-size: 20px !important;\r\n" + 
	    		"        text-align: left;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-menu td a {\r\n" + 
	    		"        font-size: 14px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-header-body p,\r\n" + 
	    		"    .es-header-body ul li,\r\n" + 
	    		"    .es-header-body ol li,\r\n" + 
	    		"    .es-header-body a {\r\n" + 
	    		"        font-size: 14px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-content-body p,\r\n" + 
	    		"    .es-content-body ul li,\r\n" + 
	    		"    .es-content-body ol li,\r\n" + 
	    		"    .es-content-body a {\r\n" + 
	    		"        font-size: 14px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-footer-body p,\r\n" + 
	    		"    .es-footer-body ul li,\r\n" + 
	    		"    .es-footer-body ol li,\r\n" + 
	    		"    .es-footer-body a {\r\n" + 
	    		"        font-size: 12px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-infoblock p,\r\n" + 
	    		"    .es-infoblock ul li,\r\n" + 
	    		"    .es-infoblock ol li,\r\n" + 
	    		"    .es-infoblock a {\r\n" + 
	    		"        font-size: 12px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    *[class=\"gmail-fix\"] {\r\n" + 
	    		"        display: none !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-txt-c,\r\n" + 
	    		"    .es-m-txt-c h1,\r\n" + 
	    		"    .es-m-txt-c h2,\r\n" + 
	    		"    .es-m-txt-c h3 {\r\n" + 
	    		"        text-align: center !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-txt-r,\r\n" + 
	    		"    .es-m-txt-r h1,\r\n" + 
	    		"    .es-m-txt-r h2,\r\n" + 
	    		"    .es-m-txt-r h3 {\r\n" + 
	    		"        text-align: right !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-txt-l,\r\n" + 
	    		"    .es-m-txt-l h1,\r\n" + 
	    		"    .es-m-txt-l h2,\r\n" + 
	    		"    .es-m-txt-l h3 {\r\n" + 
	    		"        text-align: left !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-txt-r img,\r\n" + 
	    		"    .es-m-txt-c img,\r\n" + 
	    		"    .es-m-txt-l img {\r\n" + 
	    		"        display: inline !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-button-border {\r\n" + 
	    		"        display: inline-block !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    a.es-button,\r\n" + 
	    		"    button.es-button {\r\n" + 
	    		"        font-size: 14px !important;\r\n" + 
	    		"        display: inline-block !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-adaptive table,\r\n" + 
	    		"    .es-left,\r\n" + 
	    		"    .es-right {\r\n" + 
	    		"        width: 100% !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-content table,\r\n" + 
	    		"    .es-header table,\r\n" + 
	    		"    .es-footer table,\r\n" + 
	    		"    .es-content,\r\n" + 
	    		"    .es-footer,\r\n" + 
	    		"    .es-header {\r\n" + 
	    		"        width: 100% !important;\r\n" + 
	    		"        max-width: 600px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-adapt-td {\r\n" + 
	    		"        display: block !important;\r\n" + 
	    		"        width: 100% !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .adapt-img {\r\n" + 
	    		"        width: 100% !important;\r\n" + 
	    		"        height: auto !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p0 {\r\n" + 
	    		"        padding: 0 !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p0r {\r\n" + 
	    		"        padding-right: 0 !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p0l {\r\n" + 
	    		"        padding-left: 0 !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p0t {\r\n" + 
	    		"        padding-top: 0 !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p0b {\r\n" + 
	    		"        padding-bottom: 0 !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p20b {\r\n" + 
	    		"        padding-bottom: 20px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-mobile-hidden,\r\n" + 
	    		"    .es-hidden {\r\n" + 
	    		"        display: none !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    tr.es-desk-hidden,\r\n" + 
	    		"    td.es-desk-hidden,\r\n" + 
	    		"    table.es-desk-hidden {\r\n" + 
	    		"        width: auto !important;\r\n" + 
	    		"        overflow: visible !important;\r\n" + 
	    		"        float: none !important;\r\n" + 
	    		"        max-height: inherit !important;\r\n" + 
	    		"        line-height: inherit !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    tr.es-desk-hidden {\r\n" + 
	    		"        display: table-row !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    table.es-desk-hidden {\r\n" + 
	    		"        display: table !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    td.es-desk-menu-hidden {\r\n" + 
	    		"        display: table-cell !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-menu td {\r\n" + 
	    		"        width: 1% !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    table.es-table-not-adapt,\r\n" + 
	    		"    .esd-block-html table {\r\n" + 
	    		"        width: auto !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    table.es-social {\r\n" + 
	    		"        display: inline-block !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    table.es-social td {\r\n" + 
	    		"        display: inline-block !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-desk-hidden {\r\n" + 
	    		"        display: table-row !important;\r\n" + 
	    		"        width: auto !important;\r\n" + 
	    		"        overflow: visible !important;\r\n" + 
	    		"        max-height: inherit !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p5 {\r\n" + 
	    		"        padding: 5px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p5t {\r\n" + 
	    		"        padding-top: 5px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p5b {\r\n" + 
	    		"        padding-bottom: 5px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p5r {\r\n" + 
	    		"        padding-right: 5px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p5l {\r\n" + 
	    		"        padding-left: 5px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p10 {\r\n" + 
	    		"        padding: 10px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p10t {\r\n" + 
	    		"        padding-top: 10px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p10b {\r\n" + 
	    		"        padding-bottom: 10px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p10r {\r\n" + 
	    		"        padding-right: 10px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p10l {\r\n" + 
	    		"        padding-left: 10px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p15 {\r\n" + 
	    		"        padding: 15px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p15t {\r\n" + 
	    		"        padding-top: 15px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p15b {\r\n" + 
	    		"        padding-bottom: 15px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p15r {\r\n" + 
	    		"        padding-right: 15px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p15l {\r\n" + 
	    		"        padding-left: 15px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p20 {\r\n" + 
	    		"        padding: 20px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p20t {\r\n" + 
	    		"        padding-top: 20px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p20r {\r\n" + 
	    		"        padding-right: 20px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p20l {\r\n" + 
	    		"        padding-left: 20px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p25 {\r\n" + 
	    		"        padding: 25px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p25t {\r\n" + 
	    		"        padding-top: 25px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p25b {\r\n" + 
	    		"        padding-bottom: 25px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p25r {\r\n" + 
	    		"        padding-right: 25px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p25l {\r\n" + 
	    		"        padding-left: 25px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p30 {\r\n" + 
	    		"        padding: 30px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p30t {\r\n" + 
	    		"        padding-top: 30px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p30b {\r\n" + 
	    		"        padding-bottom: 30px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p30r {\r\n" + 
	    		"        padding-right: 30px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p30l {\r\n" + 
	    		"        padding-left: 30px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p35 {\r\n" + 
	    		"        padding: 35px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p35t {\r\n" + 
	    		"        padding-top: 35px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p35b {\r\n" + 
	    		"        padding-bottom: 35px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p35r {\r\n" + 
	    		"        padding-right: 35px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p35l {\r\n" + 
	    		"        padding-left: 35px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p40 {\r\n" + 
	    		"        padding: 40px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p40t {\r\n" + 
	    		"        padding-top: 40px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p40b {\r\n" + 
	    		"        padding-bottom: 40px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p40r {\r\n" + 
	    		"        padding-right: 40px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"\r\n" + 
	    		"    .es-m-p40l {\r\n" + 
	    		"        padding-left: 40px !important;\r\n" + 
	    		"    }\r\n" + 
	    		"}\r\n" + 
	    		"\r\n" + 
	    		"/* END RESPONSIVE STYLES */\r\n" + 
	    		"html,\r\n" + 
	    		"body {\r\n" + 
	    		"    font-family: arial, 'helvetica neue', helvetica, sans-serif;\r\n" + 
	    		"}\r\n" + 
	    		"</style>\r\n" + 
	    		"<td class=\"esd-stripe\" align=\"center\">\r\n" + 
	    		"    <table class=\"es-content-body\" width=\"600\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"background-color: transparent;\">\r\n" + 
	    		"        <tbody>\r\n" + 
	    		"            <tr>\r\n" + 
	    		"                <td class=\"esd-structure\" align=\"left\" esd-custom-block-id=\"750863\">\r\n" + 
	    		"                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
	    		"                        <tbody>\r\n" + 
	    		"                            <tr>\r\n" + 
	    		"                                <td class=\"esd-container-frame\" width=\"600\" valign=\"top\" align=\"center\">\r\n" + 
	    		"                                    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
	    		"                                        <tbody>\r\n" + 
	    		"                                            <tr>\r\n" + 
	    		"                                                <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\"><a target=\"_blank\"><img class=\"adapt-img\" src=\"https://raw.githubusercontent.com/pranavjames/RandomText/main/good%20ay.jpg\" alt style=\"display: block;\" width=\"600\"></a></td>\r\n" + 
	    		"                                            </tr>\r\n" + 
	    		"                                        </tbody>\r\n" + 
	    		"                                    </table>\r\n" + 
	    		"                                </td>\r\n" + 
	    		"                            </tr>\r\n" + 
	    		"                        </tbody>\r\n" + 
	    		"                    </table>\r\n" + 
	    		"                </td>\r\n" + 
	    		"            </tr>\r\n" + 
	    		"            <tr>\r\n" + 
	    		"                <td class=\"esd-structure es-p30t es-p20b es-p20r es-p20l\" align=\"left\" bgcolor=\"#99ac00\" style=\"background-color: #99ac00;\" esd-custom-block-id=\"750864\">\r\n" + 
	    		"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	    		"                        <tbody>\r\n" + 
	    		"                            <tr>\r\n" + 
	    		"                                <td width=\"560\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\r\n" + 
	    		"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	    		"                                        <tbody>\r\n" + 
	    		"                                            <tr>\r\n" + 
	    		"                                                <td align=\"center\" class=\"esd-block-text es-m-txt-c\">\r\n" + 
	    		"                                                    <h1>Booo!</h1>\r\n" + 
	    		"                                                </td>\r\n" + 
	    		"                                            </tr>\r\n" + 
	    		"                                            <tr>\r\n" + 
	    		"                                                <td align=\"center\" class=\"esd-block-text es-p10t\">\r\n" + 
	    		"												    <p style=\"color: #ffffff;\">Hi [[name]] </p>\r\n" + 
	    		"                                                    <p style=\"color: #ffffff;\">Welcome to the Event Management System</p>\r\n" + 
	    		"                                                </td>\r\n" + 
	    		"                                            </tr>\r\n" + 
	    		"                                        </tbody>\r\n" + 
	    		"                                    </table>\r\n" + 
	    		"                                </td>\r\n" + 
	    		"                            </tr>\r\n" + 
	    		"                        </tbody>\r\n" + 
	    		"                    </table>\r\n" + 
	    		"                </td>\r\n" + 
	    		"            </tr>\r\n" + 
	    		"            <tr>\r\n" + 
	    		"                <td class=\"esd-structure\" align=\"left\" bgcolor=\"#FBE99C\" style=\"background-color: #fbe99c;\">\r\n" + 
	    		"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	    		"                        <tbody>\r\n" + 
	    		"                            <tr>\r\n" + 
	    		"                                <td width=\"600\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\r\n" + 
	    		"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	    		"                                        <tbody>\r\n" + 
	    		"                                            <tr>\r\n" + 
	    		"                                                <td align=\"center\" class=\"esd-block-image\" style=\"font-size: 0px;\"><a target=\"_blank\"><img class=\"adapt-img\" src=\"https://raw.githubusercontent.com/pranavjames/RandomText/main/maskdi.png\" alt style=\"display: block;\" width=\"600\"></a></td>\r\n" + 
	    		"                                            </tr>\r\n" + 
	    		"                                        </tbody>\r\n" + 
	    		"                                    </table>\r\n" + 
	    		"                                </td>\r\n" + 
	    		"                            </tr>\r\n" + 
	    		"                        </tbody>\r\n" + 
	    		"                    </table>\r\n" + 
	    		"                </td>\r\n" + 
	    		"            </tr>\r\n" + 
	    		"            <tr>\r\n" + 
	    		"                <td class=\"esd-structure es-p10t es-p20b es-p20r es-p20l\" align=\"left\" bgcolor=\"#FBE99C\" style=\"background-color: #fbe99c;\" esd-custom-block-id=\"750865\">\r\n" + 
	    		"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	    		"                        <tbody>\r\n" + 
	    		"                            <tr>\r\n" + 
	    		"                                <td width=\"560\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\r\n" + 
	    		"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	    		"                                        <tbody>\r\n" + 
	    		"                                            <tr>\r\n" + 
	    		"                                                <td align=\"center\" class=\"esd-block-text es-m-txt-c\">\r\n" + 
	    		"                                                    <h2>Please Verify Your Account</h2>\r\n" + 
	    		"                                                </td>\r\n" + 
	    		"                                            </tr>\r\n" + 
	    		"                                            <tr>\r\n" + 
	    		"                                                <td align=\"center\" class=\"esd-block-text es-p10t es-p25r es-p25l es-m-p0r es-m-p0l\">\r\n" + 
	    		"                                                    <p>Click the button below to activate your account</p>\r\n" + 
	    		"                                                </td>\r\n" + 
	    		"                                            </tr>\r\n" + 
	    		"                                        </tbody>\r\n" + 
	    		"                                    </table>\r\n" + 
	    		"                                </td>\r\n" + 
	    		"                            </tr>\r\n" + 
	    		"                        </tbody>\r\n" + 
	    		"                    </table>\r\n" + 
	    		"                </td>\r\n" + 
	    		"            </tr>\r\n" + 
	    		"            <tr>\r\n" + 
	    		"                <td class=\"esd-structure es-p15t es-p30b es-p20r es-p20l\" align=\"left\" bgcolor=\"#fbe99c\" style=\"background-color: #fbe99c;\">\r\n" + 
	    		"                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	    		"                        <tbody>\r\n" + 
	    		"                            <tr>\r\n" + 
	    		"                                <td width=\"560\" class=\"esd-container-frame\" align=\"center\" valign=\"top\">\r\n" + 
	    		"                                    <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" + 
	    		"                                        <tbody>\r\n" + 
	    		"                                            <tr>\r\n" + 
	    		"                                                <td align=\"center\" class=\"esd-block-button\"><span class=\"es-button-border\" style=\"background: #9daa25;\"><a href=\"[[URL]]\" class=\"es-button\" target=\"_blank\" style=\"background: #9daa25; border-color: #9daa25; color: #ffffff;\">Click Here </a></span></td>\r\n" + 
	    		"                                            </tr>\r\n" + 
	    		"                                        </tbody>\r\n" + 
	    		"                                    </table>\r\n" + 
	    		"                                </td>\r\n" + 
	    		"                            </tr>\r\n" + 
	    		"                        </tbody>\r\n" + 
	    		"                    </table>\r\n" + 
	    		"                </td>\r\n" + 
	    		"            </tr>\r\n" + 
	    		"        </tbody>\r\n" + 
	    		"    </table>\r\n" + 
	    		"</td>"
	    		
	    		
	   
	            + "Regards,<br>"
	            + "Company Pvt Ltd";
	     
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    try { 
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", user.getName());
	    String verifyURL = siteURL;
	     
	    content = content.replace("[[URL]]", verifyURL);
	    
	    helper.setText(content, true);
	     
	    mailSender.send(message);}
	    catch(Exception exception) {
	    	System.out.println("Exception occured in mailsender");
	    }
	     return true;
	}

	public boolean sendOTP(User user,String otp) {
		
		String toAddress = user.getEmail();
	    
	    String subject = "Please verify your account to activate it";
	    String content = "<<div style=\"font-family: Helvetica,Arial,sans-serif;min-width:1000px;overflow:auto;line-height:2\">\r\n" + 
	    		"  <div style=\"margin:50px auto;width:70%;padding:20px 0\">\r\n" + 
	    		"    <div style=\"border-bottom:1px solid #eee\">\r\n" + 
	    		"      <a href=\"\" style=\"font-size:1.4em;color: #00466a;text-decoration:none;font-weight:600\">Your Brand</a>\r\n" + 
	    		"    </div>\r\n" + 
	    		"    <p style=\"font-size:1.1em\">Hi, [[name]]</p>\r\n" + 
	    		"    <p>Thank you for choosing EMS. Use the following OTP to complete your Login procedure.</p>\r\n" + 
	    		"    <h2 style=\"background: #00466a;margin: 0 auto;width: max-content;padding: 0 10px;color: #fff;border-radius: 4px;\">[[otp]]</h2>\r\n" + 
	    		"    <p style=\"font-size:0.9em;\">Regards,<br />EMS</p>\r\n" + 
	    		"    <hr style=\"border:none;border-top:1px solid #eee\" />\r\n" + 
	    		"    <div style=\"float:right;padding:8px 0;color:#aaa;font-size:0.8em;line-height:1;font-weight:300\">\r\n" + 
	    		"      <p>EMS Inc</p>\r\n" + 
	    		"      <p>1600 Amphitheatre Parkway</p>\r\n" + 
	    		"      <p>California</p>\r\n" + 
	    		"    </div>\r\n" + 
	    		"  </div>\r\n" + 
	    		"</div>";
	    MimeMessage message = mailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    try { 
	    helper.setFrom(fromAddress, senderName);
	    helper.setTo(toAddress);
	    helper.setSubject(subject);
	     
	    content = content.replace("[[name]]", user.getName());
	    content = content.replace("[[otp]]", otp);
	    helper.setText(content, true);     
	    mailSender.send(message);}
	    catch(Exception exception) {
	    	System.out.println("Exception occured in mailsender");
	    }
		return true;
	}
	
	
	
}
