package com.chj.Service;

import javax.mail.MessagingException;
import java.io.File;
import java.util.List;

/**
 * @author ：chj
 * @date ：Created in 2021/2/17 16:42
 * @params :  接口
 */
public interface MailService {
    /** 发送简单邮件
    * @Description:   接收方 邮件主题  邮件内容
    * @Param: [to , subject, text] 
    * @return: void
    * @Author: chj
    * @Date: 2021/2/17
    */
     void sendSimpleMail(String to,String subject,String text);
     
     
     /** 发送HTML格式的邮件
     * @Description:  接收方 邮件主题  HTML格式的邮件内容
     * @Param: [to, subject, content]
     * @return: void
     * @Author: chj
     * @Date: 2021/2/17
     */
     void sendHtmlMail(String to,String subject,String content) throws MessagingException;

     /** 发送HTML格式的邮件，并可以添加附件
     * @Description:  接收方 邮件主题 HTML格式的邮件内容 附件
     * @Param: [to, subject, content, files]
     * @return: void
     * @Author: chj
     * @Date: 2021/2/17
     */
     void sendAttachmentsMail(String to, String subject, String content, List<File> files)throws MessagingException;
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
