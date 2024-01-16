package com.ruoyi.common.utils.poi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPicture;
import org.apache.poi.hssf.usermodel.HSSFPictureData;
import org.apache.poi.hssf.usermodel.HSSFShape;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.annotation.Excel.Type;
import com.ruoyi.common.annotation.Excels;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.UtilException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.DictUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileTypeUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.file.ImageUtils;
import com.ruoyi.common.utils.reflect.ReflectUtils;

/**
 * Excel関連治療
 * 
 * @author ruoyi
 */
public class ExcelUtil<T>
{
    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    public static final String FORMULA_REGEX_STR = "=|-|\\+|@";

    public static final String[] FORMULA_STR = { "=", "-", "+", "@" };

    /**
     * のためにdictType属性データストレージ，繰り返し調査キャッシュは避けてください
     */
    public Map<String, String> sysDictMap = new HashMap<String, String>();

    /**
     * Excel sheet最大行数，デフォルト65536
     */
    public static final int sheetSize = 65536;

    /**
     * ワークヒート名前
     */
    private String sheetName;

    /**
     * エクスポートタイプ（EXPORT:データのエクスポート；IMPORT：テンプレートをインポートします）
     */
    private Type type;

    /**
     * 薄いオブジェクトの動作
     */
    private Workbook wb;

    /**
     * ワークシートオブジェクト
     */
    private Sheet sheet;

    /**
     * スタイルリスト
     */
    private Map<String, CellStyle> styles;

    /**
     * 輸入データのエクスポート列表
     */
    private List<T> list;

    /**
     * 注記釈リスト
     */
    private List<Object[]> fields;

    /**
     * 現在の行番号
     */
    private int rownum;

    /**
     * タイトル
     */
    private String title;

    /**
     * 最大高さ
     */
    private short maxHeight;

    /**
     * マージ後の最後の数
     */
    private int subMergedLastRowNum = 0;

    /**
     * 合併後、番号を開始します
     */
    private int subMergedFirstRowNum = 1;

    /**
     * オブジェクトのサブリストメソッド
     */
    private Method subMethod;

    /**
     * オブジェクトのサブリスト属性
     */
    private List<Field> subFields;

    /**
     * 統計リスト
     */
    private Map<Integer, Double> statistics = new HashMap<Integer, Double>();

    /**
     * デジタル形式
     */
    private static final DecimalFormat DOUBLE_FORMAT = new DecimalFormat("######0.00");

    /**
     * エンティティオブジェクト
     */
    public Class<T> clazz;

    /**
     * 列の属性を除外する必要があります
     */
    public String[] excludeFields;

    public ExcelUtil(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    /**
     * 隠れるExcel列属性
     *
     * @param fields 列属性名前 模範的な例[シングル"name"/複数"id","name"]
     * @throws Exception
     */
    public void hideColumn(String... fields)
    {
        this.excludeFields = fields;
    }

    public void init(List<T> list, String sheetName, String title, Type type)
    {
        if (list == null)
        {
            list = new ArrayList<T>();
        }
        this.list = list;
        this.sheetName = sheetName;
        this.type = type;
        this.title = title;
        createExcelField();
        createWorkbook();
        createTitle();
        createSubHead();
    }

    /**
     * 作成するexcel第一行タイトル
     */
    public void createTitle()
    {
        if (StringUtils.isNotEmpty(title))
        {
            subMergedFirstRowNum++;
            subMergedLastRowNum++;
            int titleLastCol = this.fields.size() - 1;
            if (isSubList())
            {
                titleLastCol = titleLastCol + subFields.size() - 1;
            }
            Row titleRow = sheet.createRow(rownum == 0 ? rownum++ : 0);
            titleRow.setHeightInPoints(30);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellStyle(styles.get("title"));
            titleCell.setCellValue(title);
            sheet.addMergedRegion(new CellRangeAddress(titleRow.getRowNum(), titleRow.getRowNum(), titleRow.getRowNum(), titleLastCol));
        }
    }

    /**
     * 作成する右象的子列表名前称
     */
    public void createSubHead()
    {
        if (isSubList())
        {
            subMergedFirstRowNum++;
            subMergedLastRowNum++;
            Row subRow = sheet.createRow(rownum);
            int excelNum = 0;
            for (Object[] objects : fields)
            {
                Excel attr = (Excel) objects[1];
                Cell headCell1 = subRow.createCell(excelNum);
                headCell1.setCellValue(attr.name());
                headCell1.setCellStyle(styles.get(StringUtils.format("header_{}_{}", attr.headerColor(), attr.headerBackgroundColor())));
                excelNum++;
            }
            int headFirstRow = excelNum - 1;
            int headLastRow = headFirstRow + subFields.size() - 1;
            if (headLastRow > headFirstRow)
            {
                sheet.addMergedRegion(new CellRangeAddress(rownum, rownum, headFirstRow, headLastRow));
            }
            rownum++;
        }
    }

    /**
     * 右excel形状デフォルト第一個々索引名前转换成list
     * 
     * @param is 入力ストリーム
     * @return 変換後
     */
    public List<T> importExcel(InputStream is)
    {
        List<T> list = null;
        try
        {
            list = importExcel(is, 0);
        }
        catch (Exception e)
        {
            log.error("輸入Excel異常な{}", e.getMessage());
            throw new UtilException(e.getMessage());
        }
        finally
        {
            IOUtils.closeQuietly(is);
        }
        return list;
    }

    /**
     * 右excel形状デフォルト第一個々索引名前转换成list
     * 
     * @param is 入力ストリーム
     * @param titleNum タイトル占用行数
     * @return 変換後
     */
    public List<T> importExcel(InputStream is, int titleNum) throws Exception
    {
        return importExcel(StringUtils.EMPTY, is, titleNum);
    }

    /**
     * 右excelフォーム指定されたテーブルインデックスング名前はに変換されますlist
     * 
     * @param sheetName テーブルインデックス名前
     * @param titleNum タイトル占用行数
     * @param is 入力ストリーム
     * @return 変換後
     */
    public List<T> importExcel(String sheetName, InputStream is, int titleNum) throws Exception
    {
        this.type = Type.IMPORT;
        this.wb = WorkbookFactory.create(is);
        List<T> list = new ArrayList<T>();
        // 指定した場合sheet名前,仕様を取りますsheetコンテンツ 否则デフォルト指向第1個々sheet
        Sheet sheet = StringUtils.isNotEmpty(sheetName) ? wb.getSheet(sheetName) : wb.getSheetAt(0);
        if (sheet == null)
        {
            throw new IOException("書類sheet存在しない");
        }
        boolean isXSSFWorkbook = !(wb instanceof HSSFWorkbook);
        Map<String, PictureData> pictures;
        if (isXSSFWorkbook)
        {
            pictures = getSheetPictures07((XSSFSheet) sheet, (XSSFWorkbook) wb);
        }
        else
        {
            pictures = getSheetPictures03((HSSFSheet) sheet, (HSSFWorkbook) wb);
        }
        // 得る最后一個々非空行的行下标，例えばn，リターンですn-1
        int rows = sheet.getLastRowNum();
        if (rows > 0)
        {
            // 定义一個々mapのために存放excelシリアル番号とシリアル番号とfield.
            Map<String, Integer> cellMap = new HashMap<String, Integer>();
            // ヘッダーを取得します
            Row heard = sheet.getRow(titleNum);
            for (int i = 0; i < heard.getPhysicalNumberOfCells(); i++)
            {
                Cell cell = heard.getCell(i);
                if (StringUtils.isNotNull(cell))
                {
                    String value = this.getCellValue(heard, i).toString();
                    cellMap.put(value, i);
                }
                else
                {
                    cellMap.put(null, i);
                }
            }
            // データがある場合の治療 クラスをすべて入手してくださいfield.
            List<Object[]> fields = this.getFields();
            Map<Integer, Object[]> fieldsMap = new HashMap<Integer, Object[]>();
            for (Object[] objects : fields)
            {
                Excel attr = (Excel) objects[1];
                Integer column = cellMap.get(attr.name());
                if (column != null)
                {
                    fieldsMap.put(column, objects);
                }
            }
            for (int i = titleNum + 1; i <= rows; i++)
            {
                // 最初から2データを取得します,デフォルト第一行是表头.
                Row row = sheet.getRow(i);
                // 現在の線が空の線であるかどうかを判断します
                if (isRowEmpty(row))
                {
                    continue;
                }
                T entity = null;
                for (Map.Entry<Integer, Object[]> entry : fieldsMap.entrySet())
                {
                    Object val = this.getCellValue(row, entry.getKey());

                    // 如果存在しない实例则新建.
                    entity = (entity == null ? clazz.newInstance() : entity);
                    // からmap中得到右应列的field.
                    Field field = (Field) entry.getValue()[0];
                    Excel attr = (Excel) entry.getValue()[1];
                    // タイプ,并によると右象类型設定值.
                    Class<?> fieldType = field.getType();
                    if (String.class == fieldType)
                    {
                        String s = Convert.toStr(val);
                        if (StringUtils.endsWith(s, ".0"))
                        {
                            val = StringUtils.substringBefore(s, ".0");
                        }
                        else
                        {
                            String dateFormat = field.getAnnotation(Excel.class).dateFormat();
                            if (StringUtils.isNotEmpty(dateFormat))
                            {
                                val = parseDateToStr(dateFormat, val);
                            }
                            else
                            {
                                val = Convert.toStr(val);
                            }
                        }
                    }
                    else if ((Integer.TYPE == fieldType || Integer.class == fieldType) && StringUtils.isNumeric(Convert.toStr(val)))
                    {
                        val = Convert.toInt(val);
                    }
                    else if ((Long.TYPE == fieldType || Long.class == fieldType) && StringUtils.isNumeric(Convert.toStr(val)))
                    {
                        val = Convert.toLong(val);
                    }
                    else if (Double.TYPE == fieldType || Double.class == fieldType)
                    {
                        val = Convert.toDouble(val);
                    }
                    else if (Float.TYPE == fieldType || Float.class == fieldType)
                    {
                        val = Convert.toFloat(val);
                    }
                    else if (BigDecimal.class == fieldType)
                    {
                        val = Convert.toBigDecimal(val);
                    }
                    else if (Date.class == fieldType)
                    {
                        if (val instanceof String)
                        {
                            val = DateUtils.parseDate(val);
                        }
                        else if (val instanceof Double)
                        {
                            val = DateUtil.getJavaDate((Double) val);
                        }
                    }
                    else if (Boolean.TYPE == fieldType || Boolean.class == fieldType)
                    {
                        val = Convert.toBool(val, false);
                    }
                    if (StringUtils.isNotNull(fieldType))
                    {
                        String propertyName = field.getName();
                        if (StringUtils.isNotEmpty(attr.targetAttr()))
                        {
                            propertyName = field.getName() + "." + attr.targetAttr();
                        }
                        if (StringUtils.isNotEmpty(attr.readConverterExp()))
                        {
                            val = reverseByExp(Convert.toStr(val), attr.readConverterExp(), attr.separator());
                        }
                        else if (StringUtils.isNotEmpty(attr.dictType()))
                        {
                            val = reverseDictByExp(Convert.toStr(val), attr.dictType(), attr.separator());
                        }
                        else if (!attr.handler().equals(ExcelHandlerAdapter.class))
                        {
                            val = dataFormatHandlerAdapter(val, attr, null);
                        }
                        else if (ColumnType.IMAGE == attr.cellType() && StringUtils.isNotEmpty(pictures))
                        {
                            PictureData image = pictures.get(row.getRowNum() + "_" + entry.getKey());
                            if (image == null)
                            {
                                val = "";
                            }
                            else
                            {
                                byte[] data = image.getData();
                                val = FileUtils.writeImportBytes(data);
                            }
                        }
                        ReflectUtils.invokeSetter(entity, propertyName, val);
                    }
                }
                list.add(entity);
            }
        }
        return list;
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @param list データのエクスポート集合
     * @param sheetName 工作表的名前称
     * @return 結果
     */
    public AjaxResult exportExcel(List<T> list, String sheetName)
    {
        return exportExcel(list, sheetName, StringUtils.EMPTY);
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @param list データのエクスポート集合
     * @param sheetName 工作表的名前称
     * @param title タイトル
     * @return 結果
     */
    public AjaxResult exportExcel(List<T> list, String sheetName, String title)
    {
        this.init(list, sheetName, title, Type.EXPORT);
        return exportExcel();
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @param response データを返します
     * @param list データのエクスポート集合
     * @param sheetName 工作表的名前称
     * @return 結果
     */
    public void exportExcel(HttpServletResponse response, List<T> list, String sheetName)
    {
        exportExcel(response, list, sheetName, StringUtils.EMPTY);
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @param response データを返します
     * @param list データのエクスポート集合
     * @param sheetName 工作表的名前称
     * @param title タイトル
     * @return 結果
     */
    public void exportExcel(HttpServletResponse response, List<T> list, String sheetName, String title)
    {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        this.init(list, sheetName, title, Type.EXPORT);
        exportExcel(response);
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @param sheetName 工作表的名前称
     * @return 結果
     */
    public AjaxResult importTemplateExcel(String sheetName)
    {
        return importTemplateExcel(sheetName, StringUtils.EMPTY);
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @param sheetName 工作表的名前称
     * @param title タイトル
     * @return 結果
     */
    public AjaxResult importTemplateExcel(String sheetName, String title)
    {
        this.init(null, sheetName, title, Type.IMPORT);
        return exportExcel();
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @param sheetName 工作表的名前称
     * @return 結果
     */
    public void importTemplateExcel(HttpServletResponse response, String sheetName)
    {
        importTemplateExcel(response, sheetName, StringUtils.EMPTY);
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @param sheetName 工作表的名前称
     * @param title タイトル
     * @return 結果
     */
    public void importTemplateExcel(HttpServletResponse response, String sheetName, String title)
    {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        this.init(null, sheetName, title, Type.IMPORT);
        exportExcel(response);
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @return 結果
     */
    public void exportExcel(HttpServletResponse response)
    {
        try
        {
            writeSheet();
            wb.write(response.getOutputStream());
        }
        catch (Exception e)
        {
            log.error("輸出Excel異常な{}", e.getMessage());
        }
        finally
        {
            IOUtils.closeQuietly(wb);
        }
    }

    /**
     * 右listデータ源将其里面的データ輸入到excel形状
     * 
     * @return 結果
     */
    public AjaxResult exportExcel()
    {
        OutputStream out = null;
        try
        {
            writeSheet();
            String filename = encodingFilename(sheetName);
            out = new FileOutputStream(getAbsoluteFile(filename));
            wb.write(out);
            return AjaxResult.success(filename);
        }
        catch (Exception e)
        {
            log.error("輸出Excel異常な{}", e.getMessage());
            throw new UtilException("輸出Excel失敗，ウェブサイト管理者に連絡してください！");
        }
        finally
        {
            IOUtils.closeQuietly(wb);
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * 作成する写入データ到Sheet
     */
    public void writeSheet()
    {
        // 取出一共有多少個々sheet.
        int sheetNo = Math.max(1, (int) Math.ceil(list.size() * 1.0 / sheetSize));
        for (int index = 0; index < sheetNo; index++)
        {
            createSheet(sheetNo, index);

            // 1行
            Row row = sheet.createRow(rownum);
            int column = 0;
            // 写入各個々分野的列头名前称
            for (Object[] os : fields)
            {
                Field field = (Field) os[0];
                Excel excel = (Excel) os[1];
                if (Collection.class.isAssignableFrom(field.getType()))
                {
                    for (Field subField : subFields)
                    {
                        Excel subExcel = subField.getAnnotation(Excel.class);
                        this.createHeadCell(subExcel, row, column++);
                    }
                }
                else
                {
                    this.createHeadCell(excel, row, column++);
                }
            }
            if (Type.EXPORT.equals(type))
            {
                fillExcelData(index, row);
                addStatisticsRow();
            }
        }
    }

    /**
     * 充填excelデータ
     * 
     * @param index シリアルナンバー
     * @param row 細胞株
     */
    @SuppressWarnings("unchecked")
    public void fillExcelData(int index, Row row)
    {
        int startNo = index * sheetSize;
        int endNo = Math.min(startNo + sheetSize, list.size());
        int rowNo = (1 + rownum) - startNo;
        for (int i = startNo; i < endNo; i++)
        {
            rowNo = isSubList() ? (i > 1 ? rowNo + 1 : rowNo + i) : i + 1 + rownum - startNo;
            row = sheet.createRow(rowNo);
            // 得到輸出右象.
            T vo = (T) list.get(i);
            Collection<?> subList = null;
            if (isSubList())
            {
                if (isSubListValue(vo))
                {
                    subList = getListCellValue(vo);
                    subMergedLastRowNum = subMergedLastRowNum + subList.size();
                }
                else
                {
                    subMergedFirstRowNum++;
                    subMergedLastRowNum++;
                }
            }
            int column = 0;
            for (Object[] os : fields)
            {
                Field field = (Field) os[0];
                Excel excel = (Excel) os[1];
                if (Collection.class.isAssignableFrom(field.getType()) && StringUtils.isNotNull(subList))
                {
                    boolean subFirst = false;
                    for (Object obj : subList)
                    {
                        if (subFirst)
                        {
                            rowNo++;
                            row = sheet.createRow(rowNo);
                        }
                        List<Field> subFields = FieldUtils.getFieldsListWithAnnotation(obj.getClass(), Excel.class);
                        int subIndex = 0;
                        for (Field subField : subFields)
                        {
                            if (subField.isAnnotationPresent(Excel.class))
                            {
                                subField.setAccessible(true);
                                Excel attr = subField.getAnnotation(Excel.class);
                                this.addCell(attr, row, (T) obj, subField, column + subIndex);
                            }
                            subIndex++;
                        }
                        subFirst = true;
                    }
                    this.subMergedFirstRowNum = this.subMergedFirstRowNum + subList.size();
                }
                else
                {
                    this.addCell(excel, row, vo, field, column++);
                }
            }
        }
    }

    /**
     * 作成する表格样式
     * 
     * @param wb 薄いオブジェクトの動作
     * @return スタイルリスト
     */
    private Map<String, CellStyle> createStyles(Workbook wb)
    {
        // 各レコードに書き込みます,每条记录右应excelテーブルに1つ
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font titleFont = wb.createFont();
        titleFont.setFontName("Arial");
        titleFont.setFontHeightInPoints((short) 16);
        titleFont.setBold(true);
        style.setFont(titleFont);
        styles.put("title", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
        Font dataFont = wb.createFont();
        dataFont.setFontName("Arial");
        dataFont.setFontHeightInPoints((short) 10);
        style.setFont(dataFont);
        styles.put("data", style);

        style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        Font totalFont = wb.createFont();
        totalFont.setFontName("Arial");
        totalFont.setFontHeightInPoints((short) 10);
        style.setFont(totalFont);
        styles.put("total", style);

        styles.putAll(annotationHeaderStyles(wb, styles));

        styles.putAll(annotationDataStyles(wb));

        return styles;
    }

    /**
     * によるとExcel注記解作成する表格头样式
     * 
     * @param wb 薄いオブジェクトの動作
     * @return 自定义スタイルリスト
     */
    private Map<String, CellStyle> annotationHeaderStyles(Workbook wb, Map<String, CellStyle> styles)
    {
        Map<String, CellStyle> headerStyles = new HashMap<String, CellStyle>();
        for (Object[] os : fields)
        {
            Excel excel = (Excel) os[1];
            String key = StringUtils.format("header_{}_{}", excel.headerColor(), excel.headerBackgroundColor());
            if (!headerStyles.containsKey(key))
            {
                CellStyle style = wb.createCellStyle();
                style.cloneStyleFrom(styles.get("data"));
                style.setAlignment(HorizontalAlignment.CENTER);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                style.setFillForegroundColor(excel.headerBackgroundColor().index);
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                Font headerFont = wb.createFont();
                headerFont.setFontName("Arial");
                headerFont.setFontHeightInPoints((short) 10);
                headerFont.setBold(true);
                headerFont.setColor(excel.headerColor().index);
                style.setFont(headerFont);
                headerStyles.put(key, style);
            }
        }
        return headerStyles;
    }

    /**
     * によるとExcel注記解作成する表格列样式
     * 
     * @param wb 薄いオブジェクトの動作
     * @return 自定义スタイルリスト
     */
    private Map<String, CellStyle> annotationDataStyles(Workbook wb)
    {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        for (Object[] os : fields)
        {
            Excel excel = (Excel) os[1];
            String key = StringUtils.format("data_{}_{}_{}", excel.align(), excel.color(), excel.backgroundColor());
            if (!styles.containsKey(key))
            {
                CellStyle style = wb.createCellStyle();
                style.setAlignment(excel.align());
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                style.setBorderRight(BorderStyle.THIN);
                style.setRightBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                style.setBorderLeft(BorderStyle.THIN);
                style.setLeftBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                style.setBorderTop(BorderStyle.THIN);
                style.setTopBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                style.setBorderBottom(BorderStyle.THIN);
                style.setBottomBorderColor(IndexedColors.GREY_50_PERCENT.getIndex());
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                style.setFillForegroundColor(excel.backgroundColor().getIndex());
                Font dataFont = wb.createFont();
                dataFont.setFontName("Arial");
                dataFont.setFontHeightInPoints((short) 10);
                dataFont.setColor(excel.color().index);
                style.setFont(dataFont);
                styles.put(key, style);
            }
        }
        return styles;
    }

    /**
     * 作成する单元格
     */
    public Cell createHeadCell(Excel attr, Row row, int column)
    {
        // 作成する列
        Cell cell = row.createCell(column);
        // 書面による情報
        cell.setCellValue(attr.name());
        setDataValidation(attr, row, column);
        cell.setCellStyle(styles.get(StringUtils.format("header_{}_{}", attr.headerColor(), attr.headerBackgroundColor())));
        if (isSubList())
        {
            // 充填デフォルト样式，ユニットパターンの故障のマージを防ぎます
            sheet.setDefaultColumnStyle(column, styles.get(StringUtils.format("data_{}_{}_{}", attr.align(), attr.color(), attr.backgroundColor())));
            if (attr.needMerge())
            {
                sheet.addMergedRegion(new CellRangeAddress(rownum - 1, rownum, column, column));
            }
        }
        return cell;
    }

    /**
     * ユニット情報を設定します
     * 
     * @param value セル値
     * @param attr 注記釈関連
     * @param cell セル情報
     */
    public void setCellVo(Object value, Excel attr, Cell cell)
    {
        if (ColumnType.STRING == attr.cellType())
        {
            String cellValue = Convert.toStr(value);
            // 右于任何以表达式触发字符 =-+@最初から始めます，直接使用しますtabプレフィックスとしての文字，防ぐCSV注記射。
            if (StringUtils.startsWithAny(cellValue, FORMULA_STR))
            {
                cellValue = RegExUtils.replaceFirst(cellValue, FORMULA_REGEX_STR, "\t$0");
            }
            if (value instanceof Collection && StringUtils.equals("[]", cellValue))
            {
                cellValue = StringUtils.EMPTY;
            }
            cell.setCellValue(StringUtils.isNull(cellValue) ? attr.defaultValue() : cellValue + attr.suffix());
        }
        else if (ColumnType.NUMERIC == attr.cellType())
        {
            if (StringUtils.isNotNull(value))
            {
                cell.setCellValue(StringUtils.contains(Convert.toStr(value), ".") ? Convert.toDouble(value) : Convert.toInt(value));
            }
        }
        else if (ColumnType.IMAGE == attr.cellType())
        {
            ClientAnchor anchor = new XSSFClientAnchor(0, 0, 0, 0, (short) cell.getColumnIndex(), cell.getRow().getRowNum(), (short) (cell.getColumnIndex() + 1), cell.getRow().getRowNum() + 1);
            String imagePath = Convert.toStr(value);
            if (StringUtils.isNotEmpty(imagePath))
            {
                byte[] data = ImageUtils.getImage(imagePath);
                getDrawingPatriarch(cell.getSheet()).createPicture(anchor,
                        cell.getSheet().getWorkbook().addPicture(data, getImageType(data)));
            }
        }
    }

    /**
     * キャンバスを取得します
     */
    public static Drawing<?> getDrawingPatriarch(Sheet sheet)
    {
        if (sheet.getDrawingPatriarch() == null)
        {
            sheet.createDrawingPatriarch();
        }
        return sheet.getDrawingPatriarch();
    }

    /**
     * 画像タイプを取得します,画像挿入タイプを設定します
     */
    public int getImageType(byte[] value)
    {
        String type = FileTypeUtils.getFileExtendName(value);
        if ("JPG".equalsIgnoreCase(type))
        {
            return Workbook.PICTURE_TYPE_JPEG;
        }
        else if ("PNG".equalsIgnoreCase(type))
        {
            return Workbook.PICTURE_TYPE_PNG;
        }
        return Workbook.PICTURE_TYPE_JPEG;
    }

    /**
     * 作成する表格样式
     */
    public void setDataValidation(Excel attr, Row row, int column)
    {
        if (attr.name().indexOf("注記：") >= 0)
        {
            sheet.setColumnWidth(column, 6000);
        }
        else
        {
            // 列幅を設定します
            sheet.setColumnWidth(column, (int) ((attr.width() + 0.72) * 256));
        }
        if (StringUtils.isNotEmpty(attr.prompt()) || attr.combo().length > 0)
        {
            if (attr.combo().length > 15 || StringUtils.join(attr.combo()).length() > 255)
            {
                // ドロップダウンの数がより大きい場合15または文字列の長さはより大きくなります255，则使用一個々新sheetストレージ，生成されたテンプレートのドロップダウン値を取得できない
                setXSSFValidationWithHidden(sheet, attr.combo(), attr.prompt(), 1, 100, column, column);
            }
            else
            {
                // 迅速な情報または入力できない列のみを選択する.
                setPromptOrValidation(sheet, attr.combo(), attr.prompt(), 1, 100, column, column);
            }
        }
    }

    /**
     * セルを追加します
     */
    public Cell addCell(Excel attr, Row row, T vo, Field field, int column)
    {
        Cell cell = null;
        try
        {
            // 高さを設定します
            row.setHeight(maxHeight);
            // によるとExcel中設定情况决定是否輸出,場合によっては、空に保つ必要があります,ユーザーがこのコラムに記入することを願っています.
            if (attr.isExport())
            {
                // 作成するcell
                cell = row.createCell(column);
                if (isSubListValue(vo) && getListCellValue(vo).size() > 1 && attr.needMerge())
                {
                    CellRangeAddress cellAddress = new CellRangeAddress(subMergedFirstRowNum, subMergedLastRowNum, column, column);
                    sheet.addMergedRegion(cellAddress);
                }
                cell.setCellStyle(styles.get(StringUtils.format("data_{}_{}_{}", attr.align(), attr.color(), attr.backgroundColor())));

                // のために读取右象中的属性
                Object value = getTargetValue(vo, field, attr);
                String dateFormat = attr.dateFormat();
                String readConverterExp = attr.readConverterExp();
                String separator = attr.separator();
                String dictType = attr.dictType();
                if (StringUtils.isNotEmpty(dateFormat) && StringUtils.isNotNull(value))
                {
                    cell.setCellValue(parseDateToStr(dateFormat, value));
                }
                else if (StringUtils.isNotEmpty(readConverterExp) && StringUtils.isNotNull(value))
                {
                    cell.setCellValue(convertByExp(Convert.toStr(value), readConverterExp, separator));
                }
                else if (StringUtils.isNotEmpty(dictType) && StringUtils.isNotNull(value))
                {
                    if (!sysDictMap.containsKey(dictType + value))
                    {
                        String lable = convertDictByExp(Convert.toStr(value), dictType, separator);
                        sysDictMap.put(dictType + value, lable);
                    }
                    cell.setCellValue(sysDictMap.get(dictType + value));
                }
                else if (value instanceof BigDecimal && -1 != attr.scale())
                {
                    cell.setCellValue((((BigDecimal) value).setScale(attr.scale(), attr.roundingMode())).doubleValue());
                }
                else if (!attr.handler().equals(ExcelHandlerAdapter.class))
                {
                    cell.setCellValue(dataFormatHandlerAdapter(value, attr, cell));
                }
                else
                {
                    // 列タイプを設定します
                    setCellVo(value, attr, cell);
                }
                addStatisticsData(column, Convert.toStr(value), attr);
            }
        }
        catch (Exception e)
        {
            log.error("輸出Excel失敗{}", e);
        }
        return cell;
    }

    /**
     * 設定 POI XSSFSheet セラリアプロンプトまたは選択ボックス
     * 
     * @param sheet 形状
     * @param textlist ドロップダウンボックスによって表示されるコンテンツ
     * @param promptContent リマインダーコンテンツ
     * @param firstRow 始める
     * @param endRow 終わり
     * @param firstCol 列を開始します
     * @param endCol 終了列
     */
    public void setPromptOrValidation(Sheet sheet, String[] textlist, String promptContent, int firstRow, int endRow,
            int firstCol, int endCol)
    {
        DataValidationHelper helper = sheet.getDataValidationHelper();
        DataValidationConstraint constraint = textlist.length > 0 ? helper.createExplicitListConstraint(textlist) : helper.createCustomConstraint("DD1");
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        if (StringUtils.isNotEmpty(promptContent))
        {
            // 如果設定了提示信息则鼠标放上去提示
            dataValidation.createPromptBox("", promptContent);
            dataValidation.setShowPromptBox(true);
        }
        // 対処するExcel互換性の問題
        if (dataValidation instanceof XSSFDataValidation)
        {
            dataValidation.setSuppressDropDownArrow(true);
            dataValidation.setShowErrorBox(true);
        }
        else
        {
            dataValidation.setSuppressDropDownArrow(false);
        }
        sheet.addValidationData(dataValidation);
    }

    /**
     * 設定某些列的值只能输入预制的データ,ドロップダウンボックスを表示します（兼容超出一定量的下拉框）.
     * 
     * @param sheet 要設定的sheet.
     * @param textlist ドロップダウンボックスによって表示されるコンテンツ
     * @param promptContent リマインダーコンテンツ
     * @param firstRow 始める
     * @param endRow 終わり
     * @param firstCol 列を開始します
     * @param endCol 終了列
     */
    public void setXSSFValidationWithHidden(Sheet sheet, String[] textlist, String promptContent, int firstRow, int endRow, int firstCol, int endCol)
    {
        String hideSheetName = "combo_" + firstCol + "_" + endCol;
        Sheet hideSheet = wb.createSheet(hideSheetName); // のためにストレージ 下拉菜单データ
        for (int i = 0; i < textlist.length; i++)
        {
            hideSheet.createRow(i).createCell(0).setCellValue(textlist[i]);
        }
        // 作成する名前称，他のセルによって引用することができます
        Name name = wb.createName();
        name.setNameName(hideSheetName + "_data");
        name.setRefersToFormula(hideSheetName + "!$A$1:$A$" + textlist.length);
        DataValidationHelper helper = sheet.getDataValidationHelper();
        // ドロップダウンリストコンテンツをロードします
        DataValidationConstraint constraint = helper.createFormulaListConstraint(hideSheetName + "_data");
        // 設定データ有效性加载在哪個々单元格上,四個々参数分别是：銀行を開始します、終わり、始める、終了列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        // データ有效性右象
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        if (StringUtils.isNotEmpty(promptContent))
        {
            // 如果設定了提示信息则鼠标放上去提示
            dataValidation.createPromptBox("", promptContent);
            dataValidation.setShowPromptBox(true);
        }
        // 対処するExcel互換性の問題
        if (dataValidation instanceof XSSFDataValidation)
        {
            dataValidation.setSuppressDropDownArrow(true);
            dataValidation.setShowErrorBox(true);
        }
        else
        {
            dataValidation.setSuppressDropDownArrow(false);
        }

        sheet.addValidationData(dataValidation);
        // 設定hiddenSheet隠れる
        wb.setSheetHidden(wb.getSheetIndex(hideSheet), true);
    }

    /**
     * 解析輸出值 0=男,1=女性性,2=未知
     * 
     * @param propertyValue パラメーター
     * @param converterExp 翻译注記解
     * @param separator 分離主義者
     * @return 分析後
     */
    public static String convertByExp(String propertyValue, String converterExp, String separator)
    {
        StringBuilder propertyString = new StringBuilder();
        String[] convertSource = converterExp.split(",");
        for (String item : convertSource)
        {
            String[] itemArray = item.split("=");
            if (StringUtils.containsAny(propertyValue, separator))
            {
                for (String value : propertyValue.split(separator))
                {
                    if (itemArray[0].equals(value))
                    {
                        propertyString.append(itemArray[1] + separator);
                        break;
                    }
                }
            }
            else
            {
                if (itemArray[0].equals(propertyValue))
                {
                    return itemArray[1];
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 逆分析値 男=0,女性性=1,未知=2
     * 
     * @param propertyValue パラメーター
     * @param converterExp 翻译注記解
     * @param separator 分離主義者
     * @return 分析後
     */
    public static String reverseByExp(String propertyValue, String converterExp, String separator)
    {
        StringBuilder propertyString = new StringBuilder();
        String[] convertSource = converterExp.split(",");
        for (String item : convertSource)
        {
            String[] itemArray = item.split("=");
            if (StringUtils.containsAny(propertyValue, separator))
            {
                for (String value : propertyValue.split(separator))
                {
                    if (itemArray[1].equals(value))
                    {
                        propertyString.append(itemArray[0] + separator);
                        break;
                    }
                }
            }
            else
            {
                if (itemArray[1].equals(propertyValue))
                {
                    return itemArray[0];
                }
            }
        }
        return StringUtils.stripEnd(propertyString.toString(), separator);
    }

    /**
     * 分析辞書値
     * 
     * @param dictValue 辞書
     * @param dictType 辞書
     * @param separator 分離主義者
     * @return 辞書ラベル
     */
    public static String convertDictByExp(String dictValue, String dictType, String separator)
    {
        return DictUtils.getDictLabel(dictType, dictValue, separator);
    }

    /**
     * 逆分析値辞書
     * 
     * @param dictLabel 辞書ラベル
     * @param dictType 辞書
     * @param separator 分離主義者
     * @return 辞書
     */
    public static String reverseDictByExp(String dictLabel, String dictType, String separator)
    {
        return DictUtils.getDictValue(dictType, dictLabel, separator);
    }

    /**
     * データ対処する器
     * 
     * @param value データ值
     * @param excel データ注記解
     * @return
     */
    public String dataFormatHandlerAdapter(Object value, Excel excel, Cell cell)
    {
        try
        {
            Object instance = excel.handler().newInstance();
            Method formatMethod = excel.handler().getMethod("format", new Class[] { Object.class, String[].class, Cell.class, Workbook.class });
            value = formatMethod.invoke(instance, value, excel.args(), cell, this.wb);
        }
        catch (Exception e)
        {
            log.error("不能格式化データ " + excel.handler(), e.getMessage());
        }
        return Convert.toStr(value);
    }

    /**
     * 合計統計情報
     */
    private void addStatisticsData(Integer index, String text, Excel entity)
    {
        if (entity != null && entity.isStatistics())
        {
            Double temp = 0D;
            if (!statistics.containsKey(index))
            {
                statistics.put(index, temp);
            }
            try
            {
                temp = Double.valueOf(text);
            }
            catch (NumberFormatException e)
            {
            }
            statistics.put(index, statistics.get(index) + temp);
        }
    }

    /**
     * 作成する统计行
     */
    public void addStatisticsRow()
    {
        if (statistics.size() > 0)
        {
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);
            Set<Integer> keys = statistics.keySet();
            Cell cell = row.createCell(0);
            cell.setCellStyle(styles.get("total"));
            cell.setCellValue("合計");

            for (Integer key : keys)
            {
                cell = row.createCell(key);
                cell.setCellStyle(styles.get("total"));
                cell.setCellValue(DOUBLE_FORMAT.format(statistics.get(key)));
            }
            statistics.clear();
        }
    }

    /**
     * 编码書類名前
     */
    public String encodingFilename(String filename)
    {
        filename = UUID.randomUUID() + "_" + filename + ".xlsx";
        return filename;
    }

    /**
     * ダウンロードパスを取得します
     * 
     * @param filename 書類名前称
     */
    public String getAbsoluteFile(String filename)
    {
        String downloadPath = RuoYiConfig.getDownloadPath() + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists())
        {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }

    /**
     * 得るbean属性値
     * 
     * @param vo エンティティオブジェクト
     * @param field 分野
     * @param excel 注記解
     * @return 最終属性値
     * @throws Exception
     */
    private Object getTargetValue(T vo, Field field, Excel excel) throws Exception
    {
        Object o = field.get(vo);
        if (StringUtils.isNotEmpty(excel.targetAttr()))
        {
            String target = excel.targetAttr();
            if (target.contains("."))
            {
                String[] targets = target.split("[.]");
                for (String name : targets)
                {
                    o = getValue(o, name);
                }
            }
            else
            {
                o = getValue(o, target);
            }
        }
        return o;
    }

    /**
     * クラシックget方法方法形式得る值
     * 
     * @param o
     * @param name
     * @return value
     * @throws Exception
     */
    private Object getValue(Object o, String name) throws Exception
    {
        if (StringUtils.isNotNull(o) && StringUtils.isNotEmpty(name))
        {
            Class<?> clazz = o.getClass();
            Field field = clazz.getDeclaredField(name);
            field.setAccessible(true);
            o = field.get(o);
        }
        return o;
    }

    /**
     * 得到所有定义分野
     */
    private void createExcelField()
    {
        this.fields = getFields();
        this.fields = this.fields.stream().sorted(Comparator.comparing(objects -> ((Excel) objects[1]).sort())).collect(Collectors.toList());
        this.maxHeight = getRowHeight();
    }

    /**
     * 得る分野注記解信息
     */
    public List<Object[]> getFields()
    {
        List<Object[]> fields = new ArrayList<Object[]>();
        List<Field> tempFields = new ArrayList<>();
        tempFields.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
        tempFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        for (Field field : tempFields)
        {
            if (!ArrayUtils.contains(this.excludeFields, field.getName()))
            {
                // 单注記解
                if (field.isAnnotationPresent(Excel.class))
                {
                    Excel attr = field.getAnnotation(Excel.class);
                    if (attr != null && (attr.type() == Type.ALL || attr.type() == type))
                    {
                        field.setAccessible(true);
                        fields.add(new Object[] { field, attr });
                    }
                    if (Collection.class.isAssignableFrom(field.getType()))
                    {
                        subMethod = getSubMethod(field.getName(), clazz);
                        ParameterizedType pt = (ParameterizedType) field.getGenericType();
                        Class<?> subClass = (Class<?>) pt.getActualTypeArguments()[0];
                        this.subFields = FieldUtils.getFieldsListWithAnnotation(subClass, Excel.class);
                    }
                }

                // 多注記解
                if (field.isAnnotationPresent(Excels.class))
                {
                    Excels attrs = field.getAnnotation(Excels.class);
                    Excel[] excels = attrs.value();
                    for (Excel attr : excels)
                    {
                        if (!ArrayUtils.contains(this.excludeFields, field.getName() + "." + attr.targetAttr())
                                && (attr != null && (attr.type() == Type.ALL || attr.type() == type)))
                        {
                            field.setAccessible(true);
                            fields.add(new Object[] { field, attr });
                        }
                    }
                }
            }
        }
        return fields;
    }

    /**
     * によると注記解得る最大行高
     */
    public short getRowHeight()
    {
        double maxHeight = 0;
        for (Object[] os : this.fields)
        {
            Excel excel = (Excel) os[1];
            maxHeight = Math.max(maxHeight, excel.height());
        }
        return (short) (maxHeight * 20);
    }

    /**
     * 作成する一個々工作簿
     */
    public void createWorkbook()
    {
        this.wb = new SXSSFWorkbook(500);
        this.sheet = wb.createSheet();
        wb.setSheetName(0, sheetName);
        this.styles = createStyles(wb);
    }

    /**
     * 作成する工作表
     * 
     * @param sheetNo sheet量
     * @param index シリアルナンバー
     */
    public void createSheet(int sheetNo, int index)
    {
        // 設定工作表的名前称.
        if (sheetNo > 1 && index > 0)
        {
            this.sheet = wb.createSheet();
            this.createTitle();
            wb.setSheetName(index, sheetName + index);
        }
    }

    /**
     * 得るセル値
     * 
     * @param row 得る的行
     * @param column 得る单元格列号
     * @return セル値
     */
    public Object getCellValue(Row row, int column)
    {
        if (row == null)
        {
            return row;
        }
        Object val = "";
        try
        {
            Cell cell = row.getCell(column);
            if (StringUtils.isNotNull(cell))
            {
                if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA)
                {
                    val = cell.getNumericCellValue();
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        val = DateUtil.getJavaDate((Double) val); // POI Excel 日付形式の変換
                    }
                    else
                    {
                        if ((Double) val % 1 != 0)
                        {
                            val = new BigDecimal(val.toString());
                        }
                        else
                        {
                            val = new DecimalFormat("0").format(val);
                        }
                    }
                }
                else if (cell.getCellType() == CellType.STRING)
                {
                    val = cell.getStringCellValue();
                }
                else if (cell.getCellType() == CellType.BOOLEAN)
                {
                    val = cell.getBooleanCellValue();
                }
                else if (cell.getCellType() == CellType.ERROR)
                {
                    val = cell.getErrorCellValue();
                }

            }
        }
        catch (Exception e)
        {
            return val;
        }
        return val;
    }

    /**
     * 空の行であるかどうかを判断します
     * 
     * @param row 判定
     * @return
     */
    private boolean isRowEmpty(Row row)
    {
        if (row == null)
        {
            return true;
        }
        for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++)
        {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * 得るExcel2003写真
     *
     * @param sheet 現在sheet右象
     * @param workbook 工作簿右象
     * @return Map key:写真单元格索引（1_1）String，value:写真流PictureData
     */
    public static Map<String, PictureData> getSheetPictures03(HSSFSheet sheet, HSSFWorkbook workbook)
    {
        Map<String, PictureData> sheetIndexPicMap = new HashMap<String, PictureData>();
        List<HSSFPictureData> pictures = workbook.getAllPictures();
        if (!pictures.isEmpty())
        {
            for (HSSFShape shape : sheet.getDrawingPatriarch().getChildren())
            {
                HSSFClientAnchor anchor = (HSSFClientAnchor) shape.getAnchor();
                if (shape instanceof HSSFPicture)
                {
                    HSSFPicture pic = (HSSFPicture) shape;
                    int pictureIndex = pic.getPictureIndex() - 1;
                    HSSFPictureData picData = pictures.get(pictureIndex);
                    String picIndex = anchor.getRow1() + "_" + anchor.getCol1();
                    sheetIndexPicMap.put(picIndex, picData);
                }
            }
            return sheetIndexPicMap;
        }
        else
        {
            return sheetIndexPicMap;
        }
    }

    /**
     * 得るExcel2007写真
     *
     * @param sheet 現在sheet右象
     * @param workbook 工作簿右象
     * @return Map key:写真单元格索引（1_1）String，value:写真流PictureData
     */
    public static Map<String, PictureData> getSheetPictures07(XSSFSheet sheet, XSSFWorkbook workbook)
    {
        Map<String, PictureData> sheetIndexPicMap = new HashMap<String, PictureData>();
        for (POIXMLDocumentPart dr : sheet.getRelations())
        {
            if (dr instanceof XSSFDrawing)
            {
                XSSFDrawing drawing = (XSSFDrawing) dr;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes)
                {
                    if (shape instanceof XSSFPicture)
                    {
                        XSSFPicture pic = (XSSFPicture) shape;
                        XSSFClientAnchor anchor = pic.getPreferredSize();
                        CTMarker ctMarker = anchor.getFrom();
                        String picIndex = ctMarker.getRow() + "_" + ctMarker.getCol();
                        sheetIndexPicMap.put(picIndex, pic.getPictureData());
                    }
                }
            }
        }
        return sheetIndexPicMap;
    }

    /**
     * 格式化不同类型的日期右象
     * 
     * @param dateFormat 日付形式
     * @param val 被格式化的日期右象
     * @return フォーマット後の日付文字
     */
    public String parseDateToStr(String dateFormat, Object val)
    {
        if (val == null)
        {
            return "";
        }
        String str;
        if (val instanceof Date)
        {
            str = DateUtils.parseDateToStr(dateFormat, (Date) val);
        }
        else if (val instanceof LocalDateTime)
        {
            str = DateUtils.parseDateToStr(dateFormat, DateUtils.toDate((LocalDateTime) val));
        }
        else if (val instanceof LocalDate)
        {
            str = DateUtils.parseDateToStr(dateFormat, DateUtils.toDate((LocalDate) val));
        }
        else
        {
            str = val.toString();
        }
        return str;
    }

    /**
     * 是否有右象的子列表
     */
    public boolean isSubList()
    {
        return StringUtils.isNotNull(subFields) && subFields.size() > 0;
    }

    /**
     * 是否有右象的子列表，コレクションは空ではありません
     */
    public boolean isSubListValue(T vo)
    {
        return StringUtils.isNotNull(subFields) && subFields.size() > 0 && StringUtils.isNotNull(getListCellValue(vo)) && getListCellValue(vo).size() > 0;
    }

    /**
     * 得る集合的值
     */
    public Collection<?> getListCellValue(Object obj)
    {
        Object value;
        try
        {
            value = subMethod.invoke(obj, new Object[] {});
        }
        catch (Exception e)
        {
            return new ArrayList<Object>();
        }
        return (Collection<?>) value;
    }

    /**
     * 得るオブジェクトのサブリストメソッド
     * 
     * @param name 名前称
     * @param pojoClass 类右象
     * @return サブリストメソッド
     */
    public Method getSubMethod(String name, Class<?> pojoClass)
    {
        StringBuffer getMethodName = new StringBuffer("get");
        getMethodName.append(name.substring(0, 1).toUpperCase());
        getMethodName.append(name.substring(1));
        Method method = null;
        try
        {
            method = pojoClass.getMethod(getMethodName.toString(), new Class[] {});
        }
        catch (Exception e)
        {
            log.error("得る右象異常な{}", e.getMessage());
        }
        return method;
    }
}
