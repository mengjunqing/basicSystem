package com.ruoyi.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.StringUtils;

/**
 * 表紙
 *
 * @author ruoyi
 */
@RestController
public class SysIndexController
{
    /** システムの基本構成 */
    @Autowired
    private RuoYiConfig ruoyiConfig;

    /**
     * アクセステーブルペーパー，ヒント
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("いらっしゃいませ{}バックグラウンド管理フレームワーク，現行版：v{}，フロントエンドアドレスからアクセスしてください。", ruoyiConfig.getName(), ruoyiConfig.getVersion());
    }
}
