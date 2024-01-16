package com.ruoyi.common.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import com.ruoyi.common.utils.spring.SpringUtils;

/**
 * 得るi18nリソース
 * 
 * @author ruoyi
 */
public class MessageUtils
{
    /**
     * メッセージキーとパラメーターに基づいています 得る消息 委託されたspring messageSource
     *
     * @param code メッセージキー
     * @param args パラメーター
     * @return 得る国际化翻译值
     */
    public static String message(String code, Object... args)
    {
        MessageSource messageSource = SpringUtils.getBean(MessageSource.class);
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
