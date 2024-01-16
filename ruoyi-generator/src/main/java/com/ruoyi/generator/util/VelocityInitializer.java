package com.ruoyi.generator.util;

import java.util.Properties;
import org.apache.velocity.app.Velocity;
import com.ruoyi.common.constant.Constants;

/**
 * VelocityEngine工場
 * 
 * @author ruoyi
 */
public class VelocityInitializer
{
    /**
     * 初期化vm方法
     */
    public static void initVelocity()
    {
        Properties p = new Properties();
        try
        {
            // 負荷classpathディレクトリの下vm書類
            p.setProperty("resource.loader.file.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            // 定義文字セット
            p.setProperty(Velocity.INPUT_ENCODING, Constants.UTF8);
            // 初期化Velocityエンジン，指定された構成Properties
            Velocity.init(p);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
