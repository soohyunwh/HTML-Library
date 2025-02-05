package com.example.library.service;

import com.example.library.model.Book;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    public List<Book> getBooksFromExcel() {
        List<Book> books = new ArrayList<>();
        try {
            InputStream excelFile = getClass().getResourceAsStream("/static/book.xlsx");
            Workbook workbook = new XSSFWorkbook(excelFile);

            for (Sheet sheet : workbook) {
                for (Row row : sheet) {
                    if (row.getRowNum() == 0) continue;

                    Cell titleCell = row.getCell(1);
                    Cell authorCell = row.getCell(2);
                    Cell locationCell = row.getCell(5);

                    if (titleCell != null && authorCell != null && locationCell != null) {
                        String title = titleCell.getStringCellValue();
                        String author = authorCell.getStringCellValue();
                        String location = locationCell.getStringCellValue();

                        books.add(new Book(title, author, location));
                    }
                }
            }
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
}
