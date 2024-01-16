package com.ruoyi.common.core.redis;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 * spring redis ツール
 *
 * @author ruoyi
 **/
@SuppressWarnings(value = { "unchecked", "rawtypes" })
@Component
public class RedisCache
{
    @Autowired
    public RedisTemplate redisTemplate;

    /**
     * キャッシュの基本的なオブジェクト，Integer、String、熱狂的なクラスなど
     *
     * @param key キャッシュの重要な値
     * @param value キャッシュ値
     */
    public <T> void setCacheObject(final String key, final T value)
    {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * キャッシュの基本的なオブジェクト，Integer、String、熱狂的なクラスなど
     *
     * @param key キャッシュの重要な値
     * @param value キャッシュ値
     * @param timeout 時間
     * @param timeUnit 時間颗粒度
     */
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit)
    {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置有效時間
     *
     * @param key Redis鍵
     * @param timeout 超时時間
     * @return true=正常に設定します；false=セットアップに失敗しました
     */
    public boolean expire(final String key, final long timeout)
    {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效時間
     *
     * @param key Redis鍵
     * @param timeout 超时時間
     * @param unit 時間单位
     * @return true=正常に設定します；false=セットアップに失敗しました
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit)
    {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 得る有效時間
     *
     * @param key Redis鍵
     * @return 有效時間
     */
    public long getExpire(final String key)
    {
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断 keyそれは存在するしますか
     *
     * @param key 鍵
     * @return true 存在する false存在しないする
     */
    public Boolean hasKey(String key)
    {
        return redisTemplate.hasKey(key);
    }

    /**
     * キャッシュの基本的なオブジェクト。
     *
     * @param key キャッシュ鍵価値
     * @return キャッシュ鍵価値对应的データ
     */
    public <T> T getCacheObject(final String key)
    {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 単一のオブジェクトを削除します
     *
     * @param key
     */
    public boolean deleteObject(final String key)
    {
        return redisTemplate.delete(key);
    }

    /**
     * コレクションオブジェクトを削除します
     *
     * @param collection 複数のオブジェクト
     * @return
     */
    public boolean deleteObject(final Collection collection)
    {
        return redisTemplate.delete(collection) > 0;
    }

    /**
     * キャッシュListデータ
     *
     * @param key キャッシュの重要な値
     * @param dataList 待キャッシュ的Listデータ
     * @return キャッシュ的物体
     */
    public <T> long setCacheList(final String key, final List<T> dataList)
    {
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * 获得キャッシュ的list物体
     *
     * @param key キャッシュの重要な値
     * @return キャッシュ鍵価値对应的データ
     */
    public <T> List<T> getCacheList(final String key)
    {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * キャッシュSet
     *
     * @param key キャッシュ鍵価値
     * @param dataSet キャッシュ的データ
     * @return キャッシュデータ的物体
     */
    public <T> BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet)
    {
        BoundSetOperations<String, T> setOperation = redisTemplate.boundSetOps(key);
        Iterator<T> it = dataSet.iterator();
        while (it.hasNext())
        {
            setOperation.add(it.next());
        }
        return setOperation;
    }

    /**
     * 获得キャッシュ的set
     *
     * @param key
     * @return
     */
    public <T> Set<T> getCacheSet(final String key)
    {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * キャッシュMap
     *
     * @param key
     * @param dataMap
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap)
    {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * 获得キャッシュ的Map
     *
     * @param key
     * @return
     */
    public <T> Map<String, T> getCacheMap(final String key)
    {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 過去Hash中存入データ
     *
     * @param key Redis鍵
     * @param hKey Hash鍵
     * @param value 価値
     */
    public <T> void setCacheMapValue(final String key, final String hKey, final T value)
    {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 得るHash中的データ
     *
     * @param key Redis鍵
     * @param hKey Hash鍵
     * @return Hash中的物体
     */
    public <T> T getCacheMapValue(final String key, final String hKey)
    {
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * 得る多个Hash中的データ
     *
     * @param key Redis鍵
     * @param hKeys Hash鍵集合
     * @return Hash物体集合
     */
    public <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hKeys)
    {
        return redisTemplate.opsForHash().multiGet(key, hKeys);
    }

    /**
     * 消去Hash中的某条データ
     *
     * @param key Redis鍵
     * @param hKey Hash鍵
     * @return 成功するかどうか
     */
    public boolean deleteCacheMapValue(final String key, final String hKey)
    {
        return redisTemplate.opsForHash().delete(key, hKey) > 0;
    }

    /**
     * キャッシュの基本的なオブジェクト列表
     *
     * @param pattern 文字列プレフィックス
     * @return 物体列表
     */
    public Collection<String> keys(final String pattern)
    {
        return redisTemplate.keys(pattern);
    }
}
