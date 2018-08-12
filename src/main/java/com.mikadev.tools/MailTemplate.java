/*
 * Copyright 2018 mikadev.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Created by Nikolay Sviridenko on 04.08.2018.
 */
package com.mikadev.tools;

public class MailTemplate {

    public static final String HEADER = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\">\n" +
            " <head> \n" +
            "  <meta charset=\"UTF-8\"> \n" +
            "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\"> \n" +
            "  <meta name=\"x-apple-disable-message-reformatting\"> \n" +
            "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
            "  <meta content=\"telephone=no\" name=\"format-detection\"> \n" +
            "  <title>craw</title> \n" +
            "  <!--[if (mso 16)]>\n" +
            "    <style type=\"text/css\">\n" +
            "    a {text-decoration: none;}\n" +
            "    </style>\n" +
            "    <![endif]--> \n" +
            "  <!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--> \n" +
            "  <style>\n" +
            "@media only screen and (max-width: 600px) {p, ul li, ol li, a { font-size: 16px !important } h1 { font-size: 30px !important; text-align: center } h2 { font-size: 26px !important; text-align: center } h3 { font-size: 20px !important; text-align: center } h1 a { font-size: 30px !important } h2 a { font-size: 26px !important } h3 a { font-size: 20px !important } .es-menu td a { font-size: 16px !important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size: 16px !important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size: 16px !important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size: 12px !important } *[class=\"gmail-fix\"] { display: none !important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align: center !important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align: right !important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align: left !important } .es-m-txt-r a img, .es-m-txt-c a img, .es-m-txt-l a img { display: inline !important } .es-button-border { display: block !important } .es-button { font-size: 20px !important; display: block !important; border-width: 10px 0px 10px 0px !important } .es-btn-fw { border-width: 10px 0px !important; text-align: center !important } .es-adaptive table, .es-btn-fw, .es-btn-fw-brdr, .es-left, .es-right { width: 100% !important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width: 100% !important; max-width: 600px !important } .es-adapt-td { display: block !important; width: 100% !important } .adapt-img { width: 100% !important; height: auto !important } .es-m-p0 { padding: 0px !important } .es-m-p0r { padding-right: 0px !important } .es-m-p0l { padding-left: 0px !important } .es-m-p0t { padding-top: 0px !important } .es-m-p0b { padding-bottom: 0 !important } .es-m-p20b { padding-bottom: 20px !important } .es-hidden { display: none !important } table.es-table-not-adapt, .esd-block-html table { width: auto !important } table.es-social { display: inline-block !important } table.es-social td { display: inline-block !important } }\n" +
            "\n" +
            "</style> \n" +
            "  <style>\n" +
            "\n" +
            "\n" +
            "#outlook a {\n" +
            "\tpadding: 0;\n" +
            "}\n" +
            ".ExternalClass {\n" +
            "\twidth: 100%;\n" +
            "}\n" +
            ".ExternalClass,\n" +
            ".ExternalClass p,\n" +
            ".ExternalClass span,\n" +
            ".ExternalClass font,\n" +
            ".ExternalClass td,\n" +
            ".ExternalClass div {\n" +
            "\tline-height: 100%;\n" +
            "}\n" +
            ".es-button {\n" +
            "\tmso-style-priority: 100 !important;\n" +
            "\ttext-decoration: none !important;\n" +
            "}\n" +
            "a[x-apple-data-detectors] {\n" +
            "\tcolor: inherit !important;\n" +
            "\ttext-decoration: none !important;\n" +
            "\tfont-size: inherit !important;\n" +
            "\tfont-family: inherit !important;\n" +
            "\tfont-weight: inherit !important;\n" +
            "\tline-height: inherit !important;\n" +
            "}\n" +
            "@-ms-viewport {\n" +
            "\twidth: device-width;\n" +
            "}\n" +
            "\n" +
            "</style> \n" +
            " <script type=\"text/javascript\" src=\"https://gc.kis.v2.scr.kaspersky-labs.com/7FD54C95-C1F2-9744-A6D8-7C9B32680756/main.js\" charset=\"UTF-8\"></script></head> \n" +
            " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0;\"> \n" +
            "  <div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6;\"> \n" +
            "   <!--[if gte mso 9]>\n" +
            "    <v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
            "        <v:fill type=\"tile\" src=\"\" color=\"#f6f6f6\"></v:fill>\n" +
            "    </v:background>\n" +
            "<![endif]--> \n" +
            "   <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-wrapper\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;\"> \n" +
            "    <tbody> \n" +
            "     <tr style=\"border-collapse:collapse;\"> \n" +
            "      <td valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-header\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top;\"> \n" +
            "        <tbody> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table class=\"es-header-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\"> \n" +
            "            <tbody> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:20px;padding-left:20px;padding-right:20px;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                <tbody> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                    <tbody> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;\"> <a href=\"http://stripo.email\" target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:14px;text-decoration:underline;color:#1376C8;\"><img src=\"https://image.ibb.co/gmDUOz/logo.png\" alt=\"\" width=\"124\" style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic;\"></a> </td> \n" +
            "                     </tr> \n" +
            "                    </tbody> \n" +
            "                   </table> </td> \n" +
            "                 </tr> \n" +
            "                </tbody> \n" +
            "               </table> </td> \n" +
            "             </tr> \n" +
            "            </tbody> \n" +
            "           </table> </td> \n" +
            "         </tr> \n" +
            "        </tbody> \n" +
            "       </table> \n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
            "        <tbody> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \n" +
            "            <tbody> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" bgcolor=\"#93c47d\" style=\"padding:20px;Margin:0;background-color:#93C47D;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                <tbody> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                    <tbody> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:15px;\"> <h2 style=\"Margin:0;line-height:120%;mso-line-height-rule:exactly;font-family:arial, 'helvetica neue', helvetica, sans-serif;font-size:24px;font-style:normal;font-weight:normal;color:#333333;\"><strong>Crawler report</strong></h2></td> \n" +
            "                     </tr> \n" +
            "                    </tbody> \n" +
            "                   </table> </td> \n" +
            "                 </tr> \n" +
            "                </tbody> \n" +
            "               </table> </td> \n" +
            "             </tr> \n" +
            "            </tbody> \n" +
            "           </table> </td> \n" +
            "         </tr> \n" +
            "        </tbody> \n" +
            "       </table> \n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
            "        <tbody> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;\"> \n" +
            "           <table class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;\"> \n" +
            "            <tbody> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                <tbody> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"600\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                    <tbody> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" height=\"40\" bgcolor=\"#f6f6f6\" style=\"padding:0;Margin:0;\"> </td> \n" +
            "                     </tr> \n" +
            "                    </tbody> \n" +
            "                   </table> </td> \n" +
            "                 </tr> \n" +
            "                </tbody> \n" +
            "               </table> </td> \n" +
            "             </tr> \n" +
            "            </tbody> \n" +
            "           </table> </td> \n" +
            "         </tr> \n" +
            "        </tbody> \n" +
            "       </table> \n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
            "        <tbody> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;background-image:url(https://fuakk.stripocdn.email/content/guids/707e79a9-0497-4eb7-ba0c-4d03aad9b0e0/images/86471533298677997.jpg);background-position:center top;background-repeat:repeat;\"> \n" +
            "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;background-position:center top;\"> \n" +
            "            <tbody id=\"md_main_table\"> ";

    public static String DATE_ROW = " <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                <tbody> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                    <tbody> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"left\" style=\"padding:0;Margin:0;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\" id=\"md_date\">Date</p></td> \n" +
            "                     </tr> \n" +
            "                    </tbody> \n" +
            "                   </table> </td> \n" +
            "                 </tr> \n" +
            "                </tbody> \n" +
            "               </table> </td> \n" +
            "             </tr> ";

    public static String ACTIVITY_ROW = "<tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                <tbody> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                    <tbody> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"left\" style=\"padding:0;Margin:0;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:19px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#6AA84F;\" id=\"md_activity\"><strong>Activity</strong></p></td> \n" +
            "                     </tr> \n" +
            "                    </tbody> \n" +
            "                   </table> </td> \n" +
            "                 </tr> \n" +
            "                </tbody> \n" +
            "               </table> </td> \n" +
            "             </tr>";

    public static String ORDER_ROW = "<tr style=\"border-collapse:collapse;\" id=\"md_order_row\"> \n" +
            "              <td align=\"left\" style=\"padding:20px;Margin:0;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                <tbody> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"560\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                    <tbody> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"left\" style=\"padding:0;Margin:0;\"> \n" +
            "                       <table border=\"1\" align=\"center\" cellspacing=\"1\" cellpadding=\"1\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;width:500px;\"> \n" +
            "                        <tbody> \n" +
            "                         <tr style=\"border-collapse:collapse;\"> \n" +
            "                          <td style=\"padding:3px;Margin:0;\">Summ</td> \n" +
            "                          <td style=\"padding:3px;Margin:0;\">Link text</td> \n" +
            "                         </tr> \n" +
            "                         <tr style=\"border-collapse:collapse;\"> \n" +
            "                          <td style=\"padding:3px;Margin:0;\">Stop date</td> \n" +
            "                          <td style=\"padding:3px;Margin:0;\">Trade palce</td> \n" +
            "                         </tr> \n" +
            "                        </tbody> \n" +
            "                       </table><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\"><br></p></td> \n" +
            "                     </tr> \n" +
            "                    </tbody> \n" +
            "                   </table> </td> \n" +
            "                 </tr> \n" +
            "                </tbody> \n" +
            "               </table> </td> \n" +
            "             </tr> ";

    public static final String FOOTER = "   </tbody> \n" +
            "           </table> </td> \n" +
            "         </tr> \n" +
            "        </tbody> \n" +
            "       </table> \n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;\"> \n" +
            "        <tbody> \n" +
            "         <tr style=\"border-collapse:collapse;\"> \n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0;background-image:url(https://demo.stripo.email/content/guids/707e79a9-0497-4eb7-ba0c-4d03aad9b0e0/images/86471533298677997.jpg);background-repeat:repeat;background-position:center top;\"> \n" +
            "           <table class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:transparent;\"> \n" +
            "            <tbody> \n" +
            "             <tr style=\"border-collapse:collapse;\"> \n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-bottom:30px;\"> \n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;\"> \n" +
            "                <tbody> \n" +
            "                 <tr style=\"border-collapse:collapse;\"> \n" +
            "                  <td width=\"600\" align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;\"> \n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" bgcolor=\"#93c47d\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#93C47D;background-position:left top;\"> \n" +
            "                    <tbody> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"center\" height=\"40\" bgcolor=\"#f6f6f6\" style=\"padding:0;Margin:0;\"> </td> \n" +
            "                     </tr> \n" +
            "                     <tr style=\"border-collapse:collapse;\"> \n" +
            "                      <td align=\"right\" style=\"Margin:0;padding-top:5px;padding-bottom:5px;padding-left:5px;padding-right:5px;\"> <p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-size:14px;font-family:arial, 'helvetica neue', helvetica, sans-serif;line-height:150%;color:#333333;\"><strong>mikadev.com</strong></p></td> \n" +
            "                     </tr> \n" +
            "                    </tbody> \n" +
            "                   </table> </td> \n" +
            "                 </tr> \n" +
            "                </tbody> \n" +
            "               </table> </td> \n" +
            "             </tr> \n" +
            "            </tbody> \n" +
            "           </table> </td> \n" +
            "         </tr> \n" +
            "        </tbody> \n" +
            "       </table> </td> \n" +
            "     </tr> \n" +
            "    </tbody> \n" +
            "   </table> \n" +
            "  </div>  \n" +
            " </body>\n" +
            "</html>";
}