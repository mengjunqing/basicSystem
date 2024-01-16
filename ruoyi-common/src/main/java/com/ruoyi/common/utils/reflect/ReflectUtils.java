package com.ruoyi.common.utils.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.poi.ss.usermodel.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;

/**
 * 反射ツール. 通話を提供しますgetter/setter方法, プライベート変数にアクセスしてください, プライベートメソッドを呼び出します, 一般のなタイプを取得しますClass, キルトAOP渡されたツール機能.
 * 
 * @author ruoyi
 */
@SuppressWarnings("rawtypes")
public class ReflectUtils
{
    private static final String SETTER_PREFIX = "set";

    private static final String GETTER_PREFIX = "get";

    private static final String CGLIB_CLASS_SEPARATOR = "$$";

    private static Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

    /**
     * 移行Getter方法.
     * マルチレベルをサポートします，のように：オブジェクト名.オブジェクト名.方法
     */
    @SuppressWarnings("unchecked")
    public static <E> E invokeGetter(Object obj, String propertyName)
    {
        Object object = obj;
        for (String name : StringUtils.split(propertyName, "."))
        {
            String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(name);
            object = invokeMethod(object, getterMethodName, new Class[] {}, new Object[] {});
        }
        return (E) object;
    }

    /**
     * 移行Setter方法, メソッド名のみに一致します。
     * マルチレベルをサポートします，のように：オブジェクト名.オブジェクト名.方法
     */
    public static <E> void invokeSetter(Object obj, String propertyName, E value)
    {
        Object object = obj;
        String[] names = StringUtils.split(propertyName, ".");
        for (int i = 0; i < names.length; i++)
        {
            if (i < names.length - 1)
            {
                String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(names[i]);
                object = invokeMethod(object, getterMethodName, new Class[] {}, new Object[] {});
            }
            else
            {
                String setterMethodName = SETTER_PREFIX + StringUtils.capitalize(names[i]);
                invokeMethodByName(object, setterMethodName, new Object[] { value });
            }
        }
    }

    /**
     * オブジェクト属性値を直接読み取ります, 無視するprivate/protected飾る, 通行禁止getter関数.
     */
    @SuppressWarnings("unchecked")
    public static <E> E getFieldValue(final Object obj, final String fieldName)
    {
        Field field = getAccessibleField(obj, fieldName);
        if (field == null)
        {
            logger.debug("存存存存存在するするするするする [" + obj.getClass() + "] 真ん真ん真ん真ん真ん中，見つけることができませんでした [" + fieldName + "] 分野 ");
            return null;
        }
        E result = null;
        try
        {
            result = (E) field.get(obj);
        }
        catch (IllegalAccessException e)
        {
            logger.error("投げられない異常{}", e.getMessage());
        }
        return result;
    }

    /**
     * オブジェクト属性値を直接設定します, 無視するprivate/protected飾る, 通行禁止setter関数.
     */
    public static <E> void setFieldValue(final Object obj, final String fieldName, final E value)
    {
        Field field = getAccessibleField(obj, fieldName);
        if (field == null)
        {
            // throw new IllegalArgumentException("存存存存存在するするするするする [" + obj.getClass() + "] 真ん真ん真ん真ん真ん中，見つけることができませんでした [" + fieldName + "] 分野 ");
            logger.debug("存存存存存在するするするするする [" + obj.getClass() + "] 真ん真ん真ん真ん真ん中，見つけることができませんでした [" + fieldName + "] 分野 ");
            return;
        }
        try
        {
            field.set(obj, value);
        }
        catch (IllegalAccessException e)
        {
            logger.error("投げられない異常: {}", e.getMessage());
        }
    }

    /**
     * 直接移行对象方法, 無視するprivate/protected飾る.
     * 用于一次性移行の情况，さもないとgetAccessibleMethod()関数得るMethod后反复移行.
     * 同時にメソッド名を一致させます+パラメータータイプ，
     */
    @SuppressWarnings("unchecked")
    public static <E> E invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
            final Object[] args)
    {
        if (obj == null || methodName == null)
        {
            return null;
        }
        Method method = getAccessibleMethod(obj, methodName, parameterTypes);
        if (method == null)
        {
            logger.debug("存存存存存在するするするするする [" + obj.getClass() + "] 真ん真ん真ん真ん真ん中，見つけることができませんでした [" + methodName + "] 方法 ");
            return null;
        }
        try
        {
            return (E) method.invoke(obj, args);
        }
        catch (Exception e)
        {
            String msg = "method: " + method + ", obj: " + obj + ", args: " + args + "";
            throw convertReflectionExceptionToUnchecked(msg, e);
        }
    }

    /**
     * 直接移行对象方法, 無視するprivate/protected飾る，
     * 用于一次性移行の情况，さもないとgetAccessibleMethodByName()関数得るMethod后反复移行.
     * 只匹配関数名，のように果有多个同名関数移行第一个。
     */
    @SuppressWarnings("unchecked")
    public static <E> E invokeMethodByName(final Object obj, final String methodName, final Object[] args)
    {
        Method method = getAccessibleMethodByName(obj, methodName, args.length);
        if (method == null)
        {
            // のように果空虚のエラーはありません，空真ん中に直接戻ります。
            logger.debug("存存存存存在するするするするする [" + obj.getClass() + "] 真ん真ん真ん真ん真ん中，見つけることができませんでした [" + methodName + "] 方法 ");
            return null;
        }
        try
        {
            // タイプ変換（将参数数据タイプ変換为目标方法パラメータータイプ）
            Class<?>[] cs = method.getParameterTypes();
            for (int i = 0; i < cs.length; i++)
            {
                if (args[i] != null && !args[i].getClass().equals(cs[i]))
                {
                    if (cs[i] == String.class)
                    {
                        args[i] = Convert.toStr(args[i]);
                        if (StringUtils.endsWith((String) args[i], ".0"))
                        {
                            args[i] = StringUtils.substringBefore((String) args[i], ".0");
                        }
                    }
                    else if (cs[i] == Integer.class)
                    {
                        args[i] = Convert.toInt(args[i]);
                    }
                    else if (cs[i] == Long.class)
                    {
                        args[i] = Convert.toLong(args[i]);
                    }
                    else if (cs[i] == Double.class)
                    {
                        args[i] = Convert.toDouble(args[i]);
                    }
                    else if (cs[i] == Float.class)
                    {
                        args[i] = Convert.toFloat(args[i]);
                    }
                    else if (cs[i] == Date.class)
                    {
                        if (args[i] instanceof String)
                        {
                            args[i] = DateUtils.parseDate(args[i]);
                        }
                        else
                        {
                            args[i] = DateUtil.getJavaDate((Double) args[i]);
                        }
                    }
                    else if (cs[i] == boolean.class || cs[i] == Boolean.class)
                    {
                        args[i] = Convert.toBool(args[i]);
                    }
                }
            }
            return (E) method.invoke(obj, args);
        }
        catch (Exception e)
        {
            String msg = "method: " + method + ", obj: " + obj + ", args: " + args + "";
            throw convertReflectionExceptionToUnchecked(msg, e);
        }
    }

    /**
     * サイクル変換上向き変換, 客観のDeclaredField, アクセスに設定を強制しました.
     * のように向上转型到Object見つかりません, 戻るnull.
     */
    public static Field getAccessibleField(final Object obj, final String fieldName)
    {
        // 空虚のエラーはありません。直接戻る null
        if (obj == null)
        {
            return null;
        }
        Validate.notBlank(fieldName, "fieldName can't be blank");
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass())
        {
            try
            {
                Field field = superClass.getDeclaredField(fieldName);
                makeAccessible(field);
                return field;
            }
            catch (NoSuchFieldException e)
            {
                continue;
            }
        }
        return null;
    }

    /**
     * サイクル変換上向き変換, 客観のDeclaredMethod,アクセスに設定を強制しました.
     * のように向上转型到Object見つかりません, 戻るnull.
     * 匹配関数名+パラメータータイプ。
     * 用于方法需要キルト多次移行の情况. 先使用本関数先取得Method,然后移行Method.invoke(Object obj, Object... args)
     */
    public static Method getAccessibleMethod(final Object obj, final String methodName,
            final Class<?>... parameterTypes)
    {
        // 空虚のエラーはありません。直接戻る null
        if (obj == null)
        {
            return null;
        }
        Validate.notBlank(methodName, "methodName can't be blank");
        for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType.getSuperclass())
        {
            try
            {
                Method method = searchType.getDeclaredMethod(methodName, parameterTypes);
                makeAccessible(method);
                return method;
            }
            catch (NoSuchMethodException e)
            {
                continue;
            }
        }
        return null;
    }

    /**
     * サイクル変換上向き変換, 客観のDeclaredMethod,アクセスに設定を強制しました.
     * のように向上转型到Object見つかりません, 戻るnull.
     * 只匹配関数名。
     * 用于方法需要キルト多次移行の情况. 先使用本関数先取得Method,然后移行Method.invoke(Object obj, Object... args)
     */
    public static Method getAccessibleMethodByName(final Object obj, final String methodName, int argsNum)
    {
        // 空虚のエラーはありません。直接戻る null
        if (obj == null)
        {
            return null;
        }
        Validate.notBlank(methodName, "methodName can't be blank");
        for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType.getSuperclass())
        {
            Method[] methods = searchType.getDeclaredMethods();
            for (Method method : methods)
            {
                if (method.getName().equals(methodName) && method.getParameterTypes().length == argsNum)
                {
                    makeAccessible(method);
                    return method;
                }
            }
        }
        return null;
    }

    /**
     * 変化private/protected方法はですpublic，尽量不移行实际改动の语句，避けるJDKのSecurityManager不平をいう。
     */
    public static void makeAccessible(Method method)
    {
        if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers()))
                && !method.isAccessible())
        {
            method.setAccessible(true);
        }
    }

    /**
     * 変化private/protectedの成员变量为public，尽量不移行实际改动の语句，避けるJDKのSecurityManager不平をいう。
     */
    public static void makeAccessible(Field field)
    {
        if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())
                || Modifier.isFinal(field.getModifiers())) && !field.isAccessible())
        {
            field.setAccessible(true);
        }
    }

    /**
     * 反映する, 得るClass定义真ん真ん真ん真ん真ん中声明の泛型参数の类型, 注意泛型必须定义存存存存存在するするするするする父类处
     * のように无法找到, 戻るObject.class.
     */
    @SuppressWarnings("unchecked")
    public static <T> Class<T> getClassGenricType(final Class clazz)
    {
        return getClassGenricType(clazz, 0);
    }

    /**
     * 反映する, 得るClass定义真ん真ん真ん真ん真ん中声明の父类の泛型参数の类型.
     * のように无法找到, 戻るObject.class.
     */
    public static Class getClassGenricType(final Class clazz, final int index)
    {
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType))
        {
            logger.debug(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            return Object.class;
        }

        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0)
        {
            logger.debug("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
                    + params.length);
            return Object.class;
        }
        if (!(params[index] instanceof Class))
        {
            logger.debug(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
            return Object.class;
        }

        return (Class) params[index];
    }

    public static Class<?> getUserClass(Object instance)
    {
        if (instance == null)
        {
            throw new RuntimeException("Instance must not be null");
        }
        Class clazz = instance.getClass();
        if (clazz != null && clazz.getName().contains(CGLIB_CLASS_SEPARATOR))
        {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null && !Object.class.equals(superClass))
            {
                return superClass;
            }
        }
        return clazz;

    }

    /**
     * 将反射时のchecked exception変換するunchecked exception.
     */
    public static RuntimeException convertReflectionExceptionToUnchecked(String msg, Exception e)
    {
        if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
                || e instanceof NoSuchMethodException)
        {
            return new IllegalArgumentException(msg, e);
        }
        else if (e instanceof InvocationTargetException)
        {
            return new RuntimeException(msg, ((InvocationTargetException) e).getTargetException());
        }
        return new RuntimeException(msg, e);
    }
}
