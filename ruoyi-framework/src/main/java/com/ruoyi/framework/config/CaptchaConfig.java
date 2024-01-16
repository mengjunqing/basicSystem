package com.ruoyi.framework.config;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import static com.google.code.kaptcha.Constants.*;

/**
 * Verification Code configuration
 * 
 * @author ruoyi
 */
@Configuration
public class CaptchaConfig
{
    @Bean(name = "captchaProducer")
    public DefaultKaptcha getKaptchaBean()
    {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // Whether there is a border デフォルトはですtrue 私たちはそれを自分で設定することができますyes，no
        properties.setProperty(KAPTCHA_BORDER, "yes");
        // 検証コードテキスト文字の色 デフォルトはですColor.BLACK
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_COLOR, "black");
        // 検証コード画像幅 デフォルトはです200
        properties.setProperty(KAPTCHA_IMAGE_WIDTH, "160");
        // 検証コード画像の高さ デフォルトはです50
        properties.setProperty(KAPTCHA_IMAGE_HEIGHT, "60");
        // 検証コードテキスト文字サイズ デフォルトはです40
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_SIZE, "38");
        // KAPTCHA_SESSION_KEY
        properties.setProperty(KAPTCHA_SESSION_CONFIG_KEY, "kaptchaCode");
        // 検証コードテキスト文字長 デフォルトはです5
        properties.setProperty(KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        // 検証コードテキストフォントスタイル デフォルトはですnew Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize)
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial,Courier");
        // 画像スタイル 水パターンcom.google.code.kaptcha.impl.WaterRipple 魚眼com.google.code.kaptcha.impl.FishEyeGimpy 影com.google.code.kaptcha.impl.ShadowGimpy
        properties.setProperty(KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }

    @Bean(name = "captchaProducerMath")
    public DefaultKaptcha getKaptchaBeanMath()
    {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // Whether there is a border デフォルトはですtrue 私たちはそれを自分で設定することができますyes，no
        properties.setProperty(KAPTCHA_BORDER, "yes");
        // ボーダの色 デフォルトはですColor.BLACK
        properties.setProperty(KAPTCHA_BORDER_COLOR, "105,179,90");
        // 検証コードテキスト文字の色 デフォルトはですColor.BLACK
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");
        // 検証コード画像幅 デフォルトはです200
        properties.setProperty(KAPTCHA_IMAGE_WIDTH, "160");
        // 検証コード画像の高さ デフォルトはです50
        properties.setProperty(KAPTCHA_IMAGE_HEIGHT, "60");
        // 検証コードテキスト文字サイズ デフォルトはです40
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_SIZE, "35");
        // KAPTCHA_SESSION_KEY
        properties.setProperty(KAPTCHA_SESSION_CONFIG_KEY, "kaptchaCodeMath");
        // 検証コードテキストジェネレーター
        properties.setProperty(KAPTCHA_TEXTPRODUCER_IMPL, "com.ruoyi.framework.config.KaptchaTextCreator");
        // 検証コードテキスト文字間隔 デフォルトはです2
        properties.setProperty(KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "3");
        // 検証コードテキスト文字長 デフォルトはです5
        properties.setProperty(KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "6");
        // 検証コードテキストフォントスタイル デフォルトはですnew Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize)
        properties.setProperty(KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial,Courier");
        // 検証コードノイズカラー デフォルトはですColor.BLACK
        properties.setProperty(KAPTCHA_NOISE_COLOR, "white");
        // 干渉実装クラス
        properties.setProperty(KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        // 画像スタイル 水パターンcom.google.code.kaptcha.impl.WaterRipple 魚眼com.google.code.kaptcha.impl.FishEyeGimpy 影com.google.code.kaptcha.impl.ShadowGimpy
        properties.setProperty(KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
