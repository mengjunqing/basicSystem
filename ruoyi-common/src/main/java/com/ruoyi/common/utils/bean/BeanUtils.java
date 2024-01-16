package com.ruoyi.common.utils.bean;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bean ツール
 * 
 * @author ruoyi
 */
public class BeanUtils extends org.springframework.beans.BeanUtils
{
    /** Beanメソッド名の属性名は入札を開始します */
    private static final int BEAN_METHOD_PROP_INDEX = 3;

    /** * マッチgetterメソッドの正規表現 */
    private static final Pattern GET_PATTERN = Pattern.compile("get(\\p{javaUpperCase}\\w*)");

    /** * マッチsetterメソッドの正規表現 */
    private static final Pattern SET_PATTERN = Pattern.compile("set(\\p{javaUpperCase}\\w*)");

    /**
     * Beanプロパティコピーツールメソッド。
     * 
     * @param dest 目標
     * @param src ソース
     */
    public static void copyBeanProp(Object dest, Object src)
    {
        try
        {
            copyProperties(src, dest);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 客観的setter方法。
     * 
     * @param obj 物体
     * @return 物体的setterメソッドリスト
     */
    public static List<Method> getSetterMethods(Object obj)
    {
        // setterメソッドリスト
        List<Method> setterMethods = new ArrayList<Method>();

        // すべてのメソッドを取得します
        Method[] methods = obj.getClass().getMethods();

        // 探すsetter方法

        for (Method method : methods)
        {
            Matcher m = SET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 1))
            {
                setterMethods.add(method);
            }
        }
        // 戻るsetterメソッドリスト
        return setterMethods;
    }

    /**
     * 客観的getter方法。
     * 
     * @param obj 物体
     * @return 物体的getterメソッドリスト
     */

    public static List<Method> getGetterMethods(Object obj)
    {
        // getterメソッドリスト
        List<Method> getterMethods = new ArrayList<Method>();
        // すべてのメソッドを取得します
        Method[] methods = obj.getClass().getMethods();
        // 探すgetter方法
        for (Method method : methods)
        {
            Matcher m = GET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 0))
            {
                getterMethods.add(method);
            }
        }
        // 戻るgetterメソッドリスト
        return getterMethods;
    }

    /**
     * 診るBeanメソッド名の属性名が等しいかどうか。<br>
     * のようにgetName()そしてsetName()属性名は同じです，getName()そしてsetAge()属性名は異なります。
     * 
     * @param m1 メソッド名1
     * @param m2 メソッド名2
     * @return 属性名は同じです戻るtrue，否则戻るfalse
     */

    public static boolean isMethodPropEquals(String m1, String m2)
    {
        return m1.substring(BEAN_METHOD_PROP_INDEX).equals(m2.substring(BEAN_METHOD_PROP_INDEX));
    }
}
