package com.popularsafi.excel;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.popularsafi.model.ReporteRiesgo;
import com.popularsafi.util.Constantes;
import com.popularsafi.util.PixelUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelRiesgosSACIF_POP {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ReporteRiesgo> reporteRiesgo;

    public ExcelRiesgosSACIF_POP(List<ReporteRiesgo> listaRiesgos) {
        this.reporteRiesgo = listaRiesgos;
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine(String fechaProceso) {
        sheet = workbook.createSheet("Reporte de códigos de cuotas generadas al "+fechaProceso);
        sheet.setDisplayGridlines(false);

        CellRangeAddress mergedRegion0 = new CellRangeAddress(0,0,1,33);
        sheet.addMergedRegion(mergedRegion0);
        CellRangeAddress mergedRegion1 = new CellRangeAddress(2,3,1,1);
        sheet.addMergedRegion(mergedRegion1);
        CellRangeAddress mergedRegion2 = new CellRangeAddress(2,3,2,2);
        sheet.addMergedRegion(mergedRegion2);
        CellRangeAddress mergedRegion3 = new CellRangeAddress(2,3,3,3);
        sheet.addMergedRegion(mergedRegion3);
        CellRangeAddress mergedRegion4 = new CellRangeAddress(2,3,4,4);
        sheet.addMergedRegion(mergedRegion4);
        CellRangeAddress mergedRegion5 = new CellRangeAddress(2,3,5,5);
        sheet.addMergedRegion(mergedRegion5);
        CellRangeAddress mergedRegion6 = new CellRangeAddress(2,3,6,6);
        sheet.addMergedRegion(mergedRegion6);
        CellRangeAddress mergedRegion7 = new CellRangeAddress(2,3,7,7);
        sheet.addMergedRegion(mergedRegion7);
        CellRangeAddress mergedRegion8 = new CellRangeAddress(2,3,8,8);
        sheet.addMergedRegion(mergedRegion8);
        CellRangeAddress mergedRegion9 = new CellRangeAddress(2,3,9,9);
        sheet.addMergedRegion(mergedRegion9);
        CellRangeAddress mergedRegion10 = new CellRangeAddress(2,3,10,10);
        sheet.addMergedRegion(mergedRegion10);
        CellRangeAddress mergedRegion11 = new CellRangeAddress(2,3,11,11);
        sheet.addMergedRegion(mergedRegion11);
        CellRangeAddress mergedRegion12 = new CellRangeAddress(2,3,12,12);
        sheet.addMergedRegion(mergedRegion12);
        CellRangeAddress mergedRegion13 = new CellRangeAddress(2,3,13,13);
        sheet.addMergedRegion(mergedRegion13);
        CellRangeAddress mergedRegion14 = new CellRangeAddress(2,3,14,14);
        sheet.addMergedRegion(mergedRegion14);
        CellRangeAddress mergedRegion15 = new CellRangeAddress(2,3,15,15);
        sheet.addMergedRegion(mergedRegion15);
        CellRangeAddress mergedRegion16 = new CellRangeAddress(2,3,16,16);
        sheet.addMergedRegion(mergedRegion16);
        CellRangeAddress mergedRegion17 = new CellRangeAddress(2,3,17,17);
        sheet.addMergedRegion(mergedRegion17);
        CellRangeAddress mergedRegion18 = new CellRangeAddress(2,3,18,18);
        sheet.addMergedRegion(mergedRegion18);
        CellRangeAddress mergedRegion19 = new CellRangeAddress(2,3,19,19);
        sheet.addMergedRegion(mergedRegion19);
        CellRangeAddress mergedRegion20 = new CellRangeAddress(2,3,20,20);
        sheet.addMergedRegion(mergedRegion20);
        CellRangeAddress mergedRegion21 = new CellRangeAddress(2,3,21,21);
        sheet.addMergedRegion(mergedRegion21);
        CellRangeAddress mergedRegion22 = new CellRangeAddress(2,3,22,22);
        sheet.addMergedRegion(mergedRegion22);
        CellRangeAddress mergedRegion23 = new CellRangeAddress(2,3,23,23);
        sheet.addMergedRegion(mergedRegion23);
        CellRangeAddress mergedRegion24 = new CellRangeAddress(2,3,24,24);
        sheet.addMergedRegion(mergedRegion24);
        CellRangeAddress mergedRegion25 = new CellRangeAddress(2,3,25,25);
        sheet.addMergedRegion(mergedRegion25);
        CellRangeAddress mergedRegion26 = new CellRangeAddress(2,3,26,26);
        sheet.addMergedRegion(mergedRegion26);
        CellRangeAddress mergedRegion27 = new CellRangeAddress(2,3,27,27);
        sheet.addMergedRegion(mergedRegion27);
        CellRangeAddress mergedRegion28 = new CellRangeAddress(2,3,28,28);
        sheet.addMergedRegion(mergedRegion28);
        CellRangeAddress mergedRegion29 = new CellRangeAddress(2,3,29,29);
        sheet.addMergedRegion(mergedRegion29);
        CellRangeAddress mergedRegion30 = new CellRangeAddress(2,3,30,30);
        sheet.addMergedRegion(mergedRegion30);
        CellRangeAddress mergedRegion31 = new CellRangeAddress(2,3,31,31);
        sheet.addMergedRegion(mergedRegion31);
        CellRangeAddress mergedRegion32 = new CellRangeAddress(2,3,32,32);
        sheet.addMergedRegion(mergedRegion32);
        CellRangeAddress mergedRegion33 = new CellRangeAddress(2,3,33,33);
        sheet.addMergedRegion(mergedRegion33);
        CellRangeAddress mergedRegion34 = new CellRangeAddress(2,3,34,34);
        sheet.addMergedRegion(mergedRegion34);
        Row row0 = sheet.createRow(0);
        CellStyle styleTop = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(11);
        styleTop.setFont(font);
        styleTop.setAlignment(HorizontalAlignment.CENTER);
        createCell(row0, 1, "Reporte de Riesgos, generado al "+fechaProceso, styleTop);

        Row row = sheet.createRow(2);

        CellStyle styleHeaders = workbook.createCellStyle();
        styleHeaders.setVerticalAlignment(VerticalAlignment.CENTER);
        styleHeaders.setAlignment(HorizontalAlignment.CENTER);
        styleHeaders.setWrapText(true);
        font.setBold(true);
        font.setFontHeight(11);
        styleHeaders.setFont(font);

        CellStyle styleHeadersCuotasIC = workbook.createCellStyle();
        styleHeadersCuotasIC.setVerticalAlignment(VerticalAlignment.CENTER);
        styleHeadersCuotasIC.setAlignment(HorizontalAlignment.CENTER);
        styleHeadersCuotasIC.setBorderTop(BorderStyle.THIN);
        styleHeadersCuotasIC.setBorderBottom(BorderStyle.THIN);
        styleHeadersCuotasIC.setBorderLeft(BorderStyle.THIN);
        styleHeadersCuotasIC.setBorderRight(BorderStyle.THIN);
        styleHeadersCuotasIC.setWrapText(true);
        font.setBold(true);
        font.setFontHeight(11);
        styleHeadersCuotasIC.setFont(font);

        createCell(row, 1, "N°", styleHeaders);
        createCell(row, 2, "CODIGOTCHN", styleHeaders);
        createCell(row, 3, "CMONEDA", styleHeaders);
        createCell(row, 4, "NDOCUMENTO", styleHeaders);
        createCell(row, 5, "TAPATERNO", styleHeaders);
        createCell(row, 6, "TAMATERNO", styleHeaders);
        createCell(row, 7, "TNOMBRES", styleHeaders);
        createCell(row, 8, "DNACIMIENTO", styleHeaders);
        createCell(row, 9, "TDIRECCION", styleHeaders);
        createCell(row, 10, "CUBIGEO", styleHeadersCuotasIC);
        createCell(row, 11, "DEPARTAMENTO", styleHeaders);
        createCell(row, 12, "PROVINCIA", styleHeaders);
        createCell(row, 13, "DISTRITO", styleHeaders);
        createCell(row, 14, "CINMUEBLE", styleHeaders);
        createCell(row, 15, "ACTIVIDAD", styleHeaders);
        createCell(row, 16, "SALDO ACTUAL", styleHeaders);
        createCell(row, 17, "CUOTAS ATRASADAS", styleHeaders);
        createCell(row, 18, "ESTADO", styleHeaders);
        createCell(row, 19, "CUOTA", styleHeaders);
        createCell(row, 20, "SUELDO", styleHeadersCuotasIC);
        createCell(row, 21, "FDESEMBOLSO", styleHeaders);
        createCell(row, 22, "TIPOOPERACION", styleHeaders);
        createCell(row, 23, "S_INFOCORP", styleHeaders);
        createCell(row, 24, "NVALORIZACION", styleHeaders);
        createCell(row, 25, "V_EDIFICACION", styleHeaders);
        createCell(row, 26, "V_PROPIEDAD", styleHeaders);
        createCell(row, 27, "V_COMERCIAL", styleHeaders);
        createCell(row, 28, "V_REALIZACIONSOL", styleHeaders);
        createCell(row, 29, "V_REALIZACIONDOL", styleHeaders);
        createCell(row, 30, "F_VALORIZACION", styleHeadersCuotasIC);
        createCell(row, 31, "DISTRITO_1", styleHeaders);
        createCell(row, 32, "NCUOTAS_GENERADAS", styleHeadersCuotasIC);
        createCell(row, 33, "CUOTASATRASADAS", styleHeaders);
        createCell(row, 34, "FONDO", styleHeadersCuotasIC);

        setBordersToMergedCells(sheet, mergedRegion1);
        setBordersToMergedCells(sheet, mergedRegion2);
        setBordersToMergedCells(sheet, mergedRegion3);
        setBordersToMergedCells(sheet, mergedRegion4);
        setBordersToMergedCells(sheet, mergedRegion5);
        setBordersToMergedCells(sheet, mergedRegion6);
        setBordersToMergedCells(sheet, mergedRegion7);
        setBordersToMergedCells(sheet, mergedRegion8);
        setBordersToMergedCells(sheet, mergedRegion9);
        setBordersToMergedCells(sheet, mergedRegion10);
        setBordersToMergedCells(sheet, mergedRegion11);
        setBordersToMergedCells(sheet, mergedRegion12);
        setBordersToMergedCells(sheet, mergedRegion13);
        setBordersToMergedCells(sheet, mergedRegion14);
        setBordersToMergedCells(sheet, mergedRegion15);
        setBordersToMergedCells(sheet, mergedRegion16);
        setBordersToMergedCells(sheet, mergedRegion17);
        setBordersToMergedCells(sheet, mergedRegion18);
        setBordersToMergedCells(sheet, mergedRegion19);
        setBordersToMergedCells(sheet, mergedRegion20);
        setBordersToMergedCells(sheet, mergedRegion21);
        setBordersToMergedCells(sheet, mergedRegion22);
        setBordersToMergedCells(sheet, mergedRegion23);
        setBordersToMergedCells(sheet, mergedRegion24);
        setBordersToMergedCells(sheet, mergedRegion25);
        setBordersToMergedCells(sheet, mergedRegion26);
        setBordersToMergedCells(sheet, mergedRegion27);
        setBordersToMergedCells(sheet, mergedRegion28);
        setBordersToMergedCells(sheet, mergedRegion29);
        setBordersToMergedCells(sheet, mergedRegion30);
        setBordersToMergedCells(sheet, mergedRegion31);
        setBordersToMergedCells(sheet, mergedRegion32);
        setBordersToMergedCells(sheet, mergedRegion33);
        setBordersToMergedCells(sheet, mergedRegion34);
        sheet.setColumnWidth(0, PixelUtil.pixel2WidthUnits(35) );
        sheet.setColumnWidth(1, PixelUtil.pixel2WidthUnits(35) );
        sheet.setColumnWidth(2, PixelUtil.pixel2WidthUnits(100) );
        sheet.setColumnWidth(3, PixelUtil.pixel2WidthUnits(50) );
        sheet.setColumnWidth(4, PixelUtil.pixel2WidthUnits(100) );
        sheet.setColumnWidth(5, PixelUtil.pixel2WidthUnits(150) );
        sheet.setColumnWidth(6, PixelUtil.pixel2WidthUnits(150) );
        sheet.setColumnWidth(7, PixelUtil.pixel2WidthUnits(180) );
        sheet.setColumnWidth(8, PixelUtil.pixel2WidthUnits(80) );
        sheet.setColumnWidth(9, PixelUtil.pixel2WidthUnits(250) );
        sheet.setColumnWidth(10, PixelUtil.pixel2WidthUnits(80) );
        sheet.setColumnWidth(11, PixelUtil.pixel2WidthUnits(100) );
        sheet.setColumnWidth(12, PixelUtil.pixel2WidthUnits(150) );
        sheet.setColumnWidth(13, PixelUtil.pixel2WidthUnits(150) );
        sheet.setColumnWidth(14, PixelUtil.pixel2WidthUnits(71) );
        sheet.setColumnWidth(15, PixelUtil.pixel2WidthUnits(66) );
        sheet.setColumnWidth(16, PixelUtil.pixel2WidthUnits(95) );
        sheet.setColumnWidth(17, PixelUtil.pixel2WidthUnits(103) );
        sheet.setColumnWidth(18, PixelUtil.pixel2WidthUnits(103) );
        sheet.setColumnWidth(19, PixelUtil.pixel2WidthUnits(52) );
        sheet.setColumnWidth(20, PixelUtil.pixel2WidthUnits(70) );
        sheet.setColumnWidth(21, PixelUtil.pixel2WidthUnits(70) );
        sheet.setColumnWidth(22, PixelUtil.pixel2WidthUnits(100) );
        sheet.setColumnWidth(23, PixelUtil.pixel2WidthUnits(88) );
        sheet.setColumnWidth(24, PixelUtil.pixel2WidthUnits(70) );
        sheet.setColumnWidth(25, PixelUtil.pixel2WidthUnits(100) );
        sheet.setColumnWidth(26, PixelUtil.pixel2WidthUnits(100) );
        sheet.setColumnWidth(27, PixelUtil.pixel2WidthUnits(100) );
        sheet.setColumnWidth(28, PixelUtil.pixel2WidthUnits(100) );
        sheet.setColumnWidth(29, PixelUtil.pixel2WidthUnits(100) );
        sheet.setColumnWidth(30, PixelUtil.pixel2WidthUnits(80) );
        sheet.setColumnWidth(31, PixelUtil.pixel2WidthUnits(150) );
        sheet.setColumnWidth(32, PixelUtil.pixel2WidthUnits(70) );
        sheet.setColumnWidth(33, PixelUtil.pixel2WidthUnits(70) );
        sheet.setColumnWidth(34, PixelUtil.pixel2WidthUnits(150) );
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        Cell cell = row.createCell(columnCount);

        if(value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if(value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if(value instanceof Date) {
            cell.setCellValue(new Date());
        } else {
            cell.setCellValue((String) value);
        }

        cell.setCellStyle(style);

    }


    private void writeDataLines() {

        int rowCount = 4;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(10);
        style.setFont(font);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.RIGHT);

        CellStyle styleDate = workbook.createCellStyle();
        XSSFCreationHelper createHelper = workbook.getCreationHelper();
        styleDate.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy"));
        styleDate.setBorderTop(BorderStyle.THIN);
        styleDate.setBorderBottom(BorderStyle.THIN);
        styleDate.setBorderLeft(BorderStyle.THIN);
        styleDate.setBorderRight(BorderStyle.THIN);
        styleDate.setAlignment(HorizontalAlignment.CENTER);

        CellStyle styleLeft = workbook.createCellStyle();
        styleLeft.setBorderTop(BorderStyle.THIN);
        styleLeft.setBorderBottom(BorderStyle.THIN);
        styleLeft.setBorderLeft(BorderStyle.THIN);
        styleLeft.setBorderRight(BorderStyle.THIN);
        styleLeft.setAlignment(HorizontalAlignment.LEFT);

        int contadorRegistros=0;
        for( ReporteRiesgo result: reporteRiesgo) {

            Row row = sheet.createRow(rowCount++);
            int columnCount = 1;
            createCell(row, columnCount++, ++contadorRegistros, style);
            createCell(row, columnCount++, result.getCODIGOTCHN(), styleLeft);
            createCell(row, columnCount++, result.getCMONEDA(), styleLeft);
            createCell(row, columnCount++, result.getNdocumento(), style);
            createCell(row, columnCount++, result.getTapaterno(), styleDate);
            createCell(row, columnCount++, result.getTamaterno(), styleDate);
            createCell(row, columnCount++, result.getTnombres(), style);
            createCell(row, columnCount++, result.getDnacimiento(), style);
            createCell(row, columnCount++, result.getTdireccion(), style);
            createCell(row, columnCount++, result.getCubigeo(), style);
            createCell(row, columnCount++, result.getDepartamento(), style);
            createCell(row, columnCount++, result.getProvincia(), style);
            createCell(row, columnCount++, result.getDistrito(), style);
            createCell(row, columnCount++, result.getCinmueble(), style);
            createCell(row, columnCount++, result.getActividad(), style);
            createCell(row, columnCount++, result.getSaldo_actual(), style);
            createCell(row, columnCount++, result.getCuotasatrasdas(), style);
            createCell(row, columnCount++, result.getEstado(), style);
            createCell(row, columnCount++, result.getCuota(), style);
            createCell(row, columnCount++, result.getSueldo(), style);
            createCell(row, columnCount++, result.getFdesembolso(), style);
            createCell(row, columnCount++, result.getTipooperacion(), style);
            createCell(row, columnCount++, result.getS_INFOCORP(), style);
            createCell(row, columnCount++, result.getNVALORIZACION(), style);
            createCell(row, columnCount++, result.getV_EDIFICACION(), style);
            createCell(row, columnCount++, result.getV_PROPIEDAD(), style);
            createCell(row, columnCount++, result.getV_COMERCIAL(), style);
            createCell(row, columnCount++, result.getV_REALIZACIONSOL(), style);
            createCell(row, columnCount++, result.getV_REALIZACIONDOL(), style);
            createCell(row, columnCount++, result.getF_VALORIZACION(), style);
            createCell(row, columnCount++, result.getUbigeo(), style);
            createCell(row, columnCount++, result.getNcuotas_generadas(), style);
            createCell(row, columnCount++, result.getCuotasatrasadas(), style);
            createCell(row, columnCount++, Constantes.SACIF_POP_DESCRIP, style);
        }
    }

    public void export(HttpServletResponse response, String fechaExcel) throws IOException {

        writeHeaderLine(fechaExcel); //write the header
        writeDataLines(); //write the data

        ServletOutputStream servletOutput = response.getOutputStream();
        workbook.write(servletOutput);
        workbook.close();
        servletOutput.close();
    }

    protected void setBordersToMergedCells(Sheet sheet, CellRangeAddress rangeAddress) {
        RegionUtil.setBorderTop(BorderStyle.THIN, rangeAddress, sheet);
        RegionUtil.setBorderLeft(BorderStyle.THIN, rangeAddress, sheet);
        RegionUtil.setBorderRight(BorderStyle.THIN, rangeAddress, sheet);
        RegionUtil.setBorderBottom(BorderStyle.THIN, rangeAddress, sheet);
    }
}