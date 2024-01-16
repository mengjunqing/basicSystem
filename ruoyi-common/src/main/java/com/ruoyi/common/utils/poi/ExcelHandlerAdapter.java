package com.ruoyi.common.utils.poi;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * Excelデータ形式の処理アダプター
 * 
 * @author ruoyi
 */
public interface ExcelHandlerAdapter
{
    /**
     * フォーマット
     * 
     * @param value セルデータ値
     * @param args excel注釈argsパラメーターグループ
     * @param cell セルオブジェクト
     * @param wb ワークブックオブジェクト
     *
     * @return 治療後の値
     */
    Object format(Object value, String[] args, Cell cell, Workbook wb);
}
