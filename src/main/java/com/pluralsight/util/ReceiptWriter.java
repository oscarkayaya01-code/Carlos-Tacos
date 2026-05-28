package com.pluralsight.util;


import com.pluralsight.models.Order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ReceiptWriter {

    private static final String RECEIPTS_DIR = "receipts";
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    public static String writeReceipt(Order order) throws IOException {
        // Create receipts folder if it doesn't exist
        File dir = new File(RECEIPTS_DIR);
        if (!dir.exists()) dir.mkdirs();

        String filename = LocalDateTime.now().format(FORMATTER) + ".txt";
        File file = new File(dir, filename);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(order.toString());
        }

        return file.getPath();
    }
}
