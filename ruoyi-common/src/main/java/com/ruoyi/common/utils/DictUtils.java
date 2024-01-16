package com.ruoyi.common.utils;

import java.util.Collection;
import java.util.List;
import com.alibaba.fastjson2.JSONArray;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.spring.SpringUtils;

/**
 * 辞書ツール
 * 
 * @author ruoyi
 */
public class DictUtils
{
    /**
     * 分離主義者
     */
    public static final String SEPARATOR = ",";

    /**
     * 辞書キャッシュを設定します
     * 
     * @param key パラメーター
     * @param dictDatas 辞書データリスト
     */
    public static void setDictCache(String key, List<SysDictData> dictDatas)
    {
        SpringUtils.getBean(RedisCache.class).setCacheObject(getCacheKey(key), dictDatas);
    }

    /**
     * 辞書キャッシュを取得します
     * 
     * @param key パラメーター
     * @return dictDatas 辞書データリスト
     */
    public static List<SysDictData> getDictCache(String key)
    {
        JSONArray arrayCache = SpringUtils.getBean(RedisCache.class).getCacheObject(getCacheKey(key));
        if (StringUtils.isNotNull(arrayCache))
        {
            return arrayCache.toList(SysDictData.class);
        }
        return null;
    }

    /**
     * 辞書タイプと辞書値に従って辞書ラベルを​​取得します
     * 
     * @param dictType 辞書
     * @param dictValue 辞書
     * @return 辞書ラベル
     */
    public static String getDictLabel(String dictType, String dictValue)
    {
        return getDictLabel(dictType, dictValue, SEPARATOR);
    }

    /**
     * 根据辞書和辞書ラベル获取辞書
     * 
     * @param dictType 辞書
     * @param dictLabel 辞書ラベル
     * @return 辞書
     */
    public static String getDictValue(String dictType, String dictLabel)
    {
        return getDictValue(dictType, dictLabel, SEPARATOR);
    }

    /**
     * 辞書タイプと辞書値に従って辞書ラベルを​​取得します
     * 
     * @param dictType 辞書
     * @param dictValue 辞書
     * @param separator 分離主義者
     * @return 辞書ラベル
     */
    public static String getDictLabel(String dictType, String dictValue, String separator)
    {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);

        if (StringUtils.isNotNull(datas))
        {
            if (StringUtils.containsAny(separator, dictValue))
            {
                for (SysDictData dict : datas)
                {
                    for (String value : dictValue.split(separator))
                    {
                        if (value.equals(dict.getDictValue()))
                        {
                            propertyString.append(dict.getDictLabel()).append(separator);
                            break;
                        }
                    }
                }
            }
            else
            {
                for (SysDictData dict : datas)
                {
                    if (dictValue.equals(dict.getDictValue()))
                    {
                        return dict.getDictLabel();
                    }
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 根据辞書和辞書ラベル获取辞書
     * 
     * @param dictType 辞書
     * @param dictLabel 辞書ラベル
     * @param separator 分離主義者
     * @return 辞書
     */
    public static String getDictValue(String dictType, String dictLabel, String separator)
    {
        StringBuilder propertyString = new StringBuilder();
        List<SysDictData> datas = getDictCache(dictType);

        if (StringUtils.containsAny(separator, dictLabel) && StringUtils.isNotEmpty(datas))
        {
            for (SysDictData dict : datas)
            {
                for (String label : dictLabel.split(separator))
                {
                    if (label.equals(dict.getDictLabel()))
                    {
                        propertyString.append(dict.getDictValue()).append(separator);
                        break;
                    }
                }
            }
        }
        else
        {
            for (SysDictData dict : datas)
            {
                if (dictLabel.equals(dict.getDictLabel()))
                {
                    return dict.getDictValue();
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 指定された辞書キャッシュを削除します
     * 
     * @param key 辞書
     */
    public static void removeDictCache(String key)
    {
        SpringUtils.getBean(RedisCache.class).deleteObject(getCacheKey(key));
    }

    /**
     * 辞書キャッシュのクリーニング
     */
    public static void clearDictCache()
    {
        Collection<String> keys = SpringUtils.getBean(RedisCache.class).keys(CacheConstants.SYS_DICT_KEY + "*");
        SpringUtils.getBean(RedisCache.class).deleteObject(keys);
    }

    /**
     * 設定cache key
     * 
     * @param configKey パラメーター
     * @return キャッシュキーkey
     */
    public static String getCacheKey(String configKey)
    {
        return CacheConstants.SYS_DICT_KEY + configKey;
    }
}
