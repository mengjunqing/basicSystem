package com.ruoyi.quartz.task;

import org.springframework.stereotype.Component;
import com.ruoyi.common.utils.StringUtils;

/**
 * タイミングタスクスケジューリングテスト
 * 
 * @author ruoyi
 */
@Component("ryTask")
public class RyTask
{
    public void ryMultipleParams(String s, Boolean b, Long l, Double d, Integer i)
    {
        System.out.println(StringUtils.format("マルチパラメーターメソッド： 文字列タイプ{}，ブール{}，長期的な完全性{}，フローティング - ポイントタイプ{}，外科医を形成します{}", s, b, l, d, i));
    }

    public void ryParams(String params)
    {
        System.out.println("参加方法を実行します：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("パフォーマンスのない方法");
    }
}
