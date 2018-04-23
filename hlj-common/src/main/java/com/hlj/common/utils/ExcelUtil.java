package com.hlj.common.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by hanlaijin@xiaomi.com on 17-10-16.
 */
public class ExcelUtil {

    /**
     * @param header   表头
     * @param fields   要导出的字段(dto的属性)
     * @param data     要导出的数据
     * @param fileName 导出的文件名称(需带后缀)
     */
    public static <T> File exportToLocalExcel(String[] header, String[] fields, List<T> data, String fileName) throws Exception {
        if (CollectionUtils.isEmpty(data)) {
            return null;
        }
        Workbook wb = null;
        File file;
        BufferedOutputStream bos = null;
        try {
            wb = fillWorkbook(header, fields, data, fileName);
            file = new File(fileName);
            bos = new BufferedOutputStream(new FileOutputStream(file));
            wb.write(bos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            bos.flush();
            bos.close();
            wb.close();
        }
        return file;
    }

    public static <T> void exportToWebExcel(String[] header, String[] fields, List<T> data, String fileName, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/x-download;charset=UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        Workbook wb = null;
        OutputStream os = null;
        try {
            wb = fillWorkbook(header, fields, data, fileName);
            os = response.getOutputStream();
            wb.write(os);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            os.flush();
            os.close();
            wb.close();
        }
    }

    private static <T> Workbook fillWorkbook(String[] header, String[] fields, List<T> data, String fileName) throws Exception {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet(fileName);
        //write title
        Row title = sheet.createRow(0);
        int index = 0;
        for (int i = 0; i < header.length; i++) {
            Cell cell = title.createCell(index++ % header.length);
            cell.setCellValue(header[i]);
        }
        //write data
        for (T obj : data) {
            Row row = sheet.createRow(sheet.getLastRowNum() + 1);
            for (int i = 0; i < fields.length; i++) {
                Cell cell = row.createCell(index++ % fields.length);
                cell.setCellValue(BeanUtils.getProperty(obj, fields[i]));
            }
        }
        return wb;
    }
}
