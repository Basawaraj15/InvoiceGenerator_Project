package com.invoice.InvoiceGenerator;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
public class OAuthCallbackServer {
           public static void main(String[] args) {
	        try {
	            // Create Document
	            Document document = new Document(PageSize.A4);
	            PdfWriter.getInstance(document, new FileOutputStream("invoice.pdf"));
	            document.open();
	            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
	     
                PdfPTable headerTable = new PdfPTable(2);
	            headerTable.setWidthPercentage(100); // Table width is 100% of the page
	            headerTable.setWidths(new float[]{1, 2}); // Set column widths (logo takes less space)

	            // Add company logo to the first cell
	            Image logo = Image.getInstance("amazonIN_logo.jpg");  // Replace with your logo path
	            logo.scaleToFit(180, 60);  // Adjust logo size
	            PdfPCell logoCell = new PdfPCell(logo);
	            logoCell.setBorder(Rectangle.NO_BORDER);  // No border for the logo cell
	            logoCell.setHorizontalAlignment(Element.ALIGN_LEFT);
	            headerTable.addCell(logoCell);

	            // Add the text to the right side in the second cell
	            PdfPCell textCell = new PdfPCell();
	            textCell.setBorder(Rectangle.NO_BORDER);  // No border for the text cell
	            textCell.setHorizontalAlignment(Element.ALIGN_RIGHT);  // Align text to the right
	            

	            // Create the content text
	            
	            
	            Paragraph headerParagraph = new Paragraph();
	            headerParagraph.setAlignment(Element.ALIGN_RIGHT);  // Set paragraph alignment to left
	            headerParagraph.add(new Chunk("Tax Invoice/Bill of Supply/Cash Memo \n", boldFont));
	            headerParagraph.add(new Chunk("(Original for Recipient)\n"));
	            
	            


	            textCell.addElement(headerParagraph);
	            headerTable.addCell(textCell);

	            
	            document.add(headerTable);

	            // Add more content below...
	            document.add(Chunk.NEWLINE);
	            
	            

	            // Create the right-aligned paragraph for billing address (below header)
	            PdfPTable table1 = new PdfPTable(2);
	            table1.setWidthPercentage(100);  // Set table width to 100% of the page
	            table1.setWidths(new float[]{50, 50});  // Equal widths for both columns

	            // Create left-aligned paragraph (Seller Information)
	            Paragraph LeftParagraph = new Paragraph();
	            LeftParagraph.setAlignment(Element.ALIGN_LEFT);
	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(new Chunk("Sold By:\n", boldFont));
	            LeftParagraph.add(new Chunk("Varasiddhi Silk Exports\n"));
	            LeftParagraph.add(new Chunk("75,3rd Cross,Lalbagh Road\n"));
	            LeftParagraph.add(new Chunk("BENGALURU,KARNATAKA, 560027\n"));
	            LeftParagraph.add(new Chunk("IN"));

	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(Chunk.NEWLINE);
	            
	            
	            LeftParagraph.add(new Chunk("PAN No", boldFont));
	            LeftParagraph.add(new Chunk(":AACFV3325K\n", normalFont));
	            LeftParagraph.add(new Chunk("GST Registration No", boldFont));
	            LeftParagraph.add(new Chunk(":29AACFV3325K1ZY\n", normalFont));
	            LeftParagraph.add(Chunk.NEWLINE);  
	            LeftParagraph.add(Chunk.NEWLINE); 
	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(Chunk.NEWLINE);
	            LeftParagraph.add(new Chunk("Order Number: ", boldFont));
	            LeftParagraph.add(new Chunk("403-3225714-7676307\n", normalFont));
	            LeftParagraph.add(new Chunk("Order Date:", boldFont));
	            LeftParagraph.add(new Chunk(" 28.10.2019\n", normalFont));	            


	            // Add the left-aligned paragraph to the left cell
	            PdfPCell leftCell = new PdfPCell();
	            leftCell.addElement(LeftParagraph);
	            leftCell.setBorder(Rectangle.NO_BORDER);  // Remove border for clean look
	              // Align content to the left
	            table1.addCell(leftCell);

	            // Create right-aligned paragraph (Billing Address)
	            Paragraph RightParagraph = new Paragraph();
	            RightParagraph.setAlignment(Element.ALIGN_RIGHT);
	            RightParagraph.add(Chunk.NEWLINE);
	            
	            RightParagraph.add(new Chunk("Billing Address:\n", boldFont));
	            RightParagraph.add(new Chunk("Madhu B\n"));
	            RightParagraph.add(new Chunk("Eurofins IT Solutions India Pvt Ltd, 1st Floor,\n"));
	            RightParagraph.add(new Chunk("Maruti Platinum, Lakshminarayana Pura, AECS\n"));
	            RightParagraph.add(new Chunk("Layout\n"));
	            RightParagraph.add(new Chunk("BENGALURU, KARNATAKA, 560037\n"));
	            RightParagraph.add(new Chunk("IN\n"));
	            RightParagraph.add(new Chunk("State/UT Code: ", boldFont));
	            RightParagraph.add(new Chunk("29\n", normalFont));
	            RightParagraph.add(Chunk.NEWLINE);
	            
	           
	            
	            RightParagraph.add(new Chunk("Shipping Address:\n", boldFont));
	            RightParagraph.add(new Chunk("Madhu B\n"));
	            RightParagraph.add(new Chunk("Madhu B\n"));
	            RightParagraph.add(new Chunk("Eurofins IT Solutions India Pvt Ltd, 1st Floor,\n"));
	            RightParagraph.add(new Chunk("Maruti Platinum, Lakshminarayana Pura, AECS\n"));
	            RightParagraph.add(new Chunk("Layout\n"));
	            RightParagraph.add(new Chunk("BENGALURU, KARNATAKA, 560037\n"));
	            RightParagraph.add(new Chunk("IN\n"));
	            RightParagraph.add(new Chunk("State/UT Code", boldFont));
	            RightParagraph.add(new Chunk(": 29\n", normalFont));
	            RightParagraph.add(new Chunk("Place of supply", boldFont));
	            RightParagraph.add(new Chunk(": KARNATAKA\n", normalFont));
	            RightParagraph.add(new Chunk("Place of delivery", boldFont));
	            		RightParagraph.add(new Chunk(": KARNATAKA\n", normalFont));
	            RightParagraph.add(new Chunk("Invoice Number ", boldFont));
	            RightParagraph.add(new Chunk(": IN-761\n", normalFont));
	            RightParagraph.add(new Chunk("Invoice Details:", boldFont));
	            RightParagraph.add(new Chunk(" KA-310565025-1920\n", normalFont));
	            RightParagraph.add(new Chunk("Invoice Date: ", boldFont));
	            RightParagraph.add(new Chunk("28.10.2019", normalFont));

	            RightParagraph.add(Chunk.NEWLINE);
	           
	           



	            
	            PdfPCell rightCell = new PdfPCell();
	            rightCell.addElement(RightParagraph);
	            rightCell.setBorder(Rectangle.NO_BORDER);  // Remove border for clean look
	             // Align content to the right
	            table1.addCell(rightCell);

	            // Add the table to the document (this will align them side by side)
	            document.add(table1);
	            
	            PdfPTable table = new PdfPTable(9); // 9 columns
	            float[] columnWidths = new float[] {1, 9, 2, 1, 2, 2, 2, 2, 3}; // Adjust column widths
	            table.setWidths(columnWidths);
	            table.setWidthPercentage(100);

	            // Table Headers
	            BaseColor greyColor = new BaseColor(200, 200, 200);

	            // Add cells with grey background
	            PdfPCell cell = new PdfPCell(new Phrase("Sl.\nNo", boldFont));
	            cell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(cell);

	            cell = new PdfPCell(new Phrase("Description", boldFont));
	            cell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(cell);

	            cell = new PdfPCell(new Phrase("Unit\nPrice", boldFont));
	            cell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(cell);

	            cell = new PdfPCell(new Phrase("Qty", boldFont));
	            cell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(cell);

	            cell = new PdfPCell(new Phrase("Net\nAmount", boldFont));
	            cell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(cell);

	            cell = new PdfPCell(new Phrase("Tax\nRate", boldFont));
	            cell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(cell);

	            cell = new PdfPCell(new Phrase("Tax\nType", boldFont));
	            cell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(cell);

	            cell = new PdfPCell(new Phrase("Tax\nAmount", boldFont));
	            cell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(cell);

	            cell = new PdfPCell(new Phrase("Total\nAmount", boldFont));
	            cell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(cell);

	            // Add the table to the document
	            
	            // Add Items (Sl.No 1 and 2)
	            addItemToTable(table, 1, Arrays.asList(
	                new ItemDetail("Varasiddhi Silks Men's Formal Shirt (SH-05-42, Navy Blue, 42) B07KGF3KW8 (SH-05-42)", 538.10, 1, 538.10, Arrays.asList(
	                    new TaxDetail(2.5, "CGST", 13.45),
	                    new TaxDetail(2.5, "SGST", 13.45)
	                )),
	                new ItemDetail("Shipping Charges", 30.96, 1, 30.96, Arrays.asList(
	                    new TaxDetail(2.5, "CGST", 0.77),
	                    new TaxDetail(2.5, "SGST", 0.77)
	                ))
	            ));

	            addItemToTable(table, 2, Arrays.asList(
	                new ItemDetail("Varasiddhi Silks Men's Formal Shirt (SH-05-40, Navy Blue, 40) B07KGCS2X7 (SH-05-40)", 538.10, 1, 538.10, Arrays.asList(
	                    new TaxDetail(2.5, "CGST", 13.45),
	                    new TaxDetail(2.5, "SGST", 13.45)
	                )),
	                new ItemDetail("Shipping Charges", 30.96, 1, 30.96, Arrays.asList(
	                    new TaxDetail(2.5, "CGST", 0.77),
	                    new TaxDetail(2.5, "SGST", 0.77)
	                ))
	            ));

	            // Add the Total row for Tax and Total Amount
	            table.addCell(""); // Empty cell for Serial No
	            table.addCell(new Phrase("Total:", boldFont)); // Total Description
	            table.addCell(""); // Empty Unit Price
	            table.addCell(""); // Empty Qty
	            table.addCell(""); // Empty Net Amount
	            table.addCell(""); // Empty Tax Rate
	            table.addCell(""); // Empty Tax Type
	            PdfPCell totalTaxCell = new PdfPCell(new Phrase("₹56.88", boldFont)); // Total Tax Amount (example value)
	            totalTaxCell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(totalTaxCell);

	            // Add total amount cell with grey background
	            PdfPCell totalAmountCell = new PdfPCell(new Phrase("₹1,195.00", boldFont)); // Total Amount (example value)
	            totalAmountCell.setBackgroundColor(greyColor);  // Set grey background
	            table.addCell(totalAmountCell);
	            // Add the table to the document
	            document.add(table);

	            
	            PdfPTable amountInWordsTable = new PdfPTable(1); // Single column table
	            amountInWordsTable.setWidthPercentage(100); // Full width

	            // Create a cell for the "Amount in Words" content
	            PdfPCell amountInWordsCell = new PdfPCell();
	           
	           // amountInWordsCell.setPadding(10); // Add padding inside the cell

	            // Add the "Amount in Words" content to the cell
	            Paragraph amountInWordsParagraph = new Paragraph();
	            amountInWordsParagraph.add(new Phrase("Amount in Words:", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
	            amountInWordsParagraph.add(Chunk.NEWLINE);
	            amountInWordsParagraph.add(new Phrase("One Thousand One Hundred And Ninety-Five Only", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
	            amountInWordsParagraph.setAlignment(Element.ALIGN_LEFT); // Align to left

	            // Add the paragraph to the cell
	            amountInWordsCell.addElement(amountInWordsParagraph);

	            // Add the cell to the table
	            amountInWordsTable.addCell(amountInWordsCell);

	            // Add the table to the document
	            document.add(amountInWordsTable);

	            // Add the signature section
	            PdfPTable signatureTable = new PdfPTable(1); // Single column table for signature
	            signatureTable.setWidthPercentage(100); // Full width

	            PdfPCell signatureCell = new PdfPCell();
	            signatureCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	          //  signatureCell.setBorder(Rectangle.NO_BORDER); // Remove border

	            Paragraph signatureText = new Paragraph("For Varasiddhi Silk Exports:", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
	            signatureText.setAlignment(Element.ALIGN_RIGHT); // Align to the right
	            signatureCell.addElement(signatureText);

	            try {
	                Image signature = Image.getInstance("set.jpg"); // Replace with your signature path
	                signature.scaleToFit(85, 50); // Adjust image size
	                signature.setAlignment(Element.ALIGN_RIGHT); // Align the image to the right
	                signatureCell.addElement(signature); // Add image to cell
	            } catch (Exception e) {
	                e.printStackTrace();
	            }

	            Paragraph authorizedSignatoryText = new Paragraph("Authorized Signatory", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD));
	            authorizedSignatoryText.setAlignment(Element.ALIGN_RIGHT); // Align to the right
	            signatureCell.addElement(authorizedSignatoryText);

	            // Add the signature cell to the table
	            signatureTable.addCell(signatureCell);

	            // Add the signature table to the document
	            document.add(signatureTable);

	            // Add the "Whether tax is payable under reverse charge" paragraph
	            Paragraph tax = new Paragraph("Whether tax is payable under reverse charge - No");
	            tax.setAlignment(Element.ALIGN_LEFT); // Align to left
	            document.add(tax);

	            // Close the document
	            document.close();


	            System.out.println("Invoice generated successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    private static void addItemToTable(PdfPTable table, int slNo, List<ItemDetail> itemDetails) {
	        // Iterate through each ItemDetail in the list
	        for (ItemDetail item : itemDetails) {
	            double itemTotalAmount = item.getNetAmount();  // Net amount of item
	            double itemTotalTaxAmount = item.getTaxDetails().stream()
	                .mapToDouble(TaxDetail::getTaxAmount)
	                .sum();  // Sum of tax amounts for this item
	            
	            // Calculate total amount (Net Amount + Taxes)
	            double totalAmount = itemTotalAmount + itemTotalTaxAmount;
	            
	            // Add data to the table
	            if (item.getDescription().equals("Shipping Charges")) {
	                // Skip serial number and quantity for Shipping Charges
	                table.addCell("");  // Empty cell for Serial Number
	                table.addCell(item.getDescription());  // Description
	                table.addCell("₹" + String.format("%.2f", item.getUnitPrice()));  // Unit Price
	                table.addCell("");  // Empty cell for Quantity
	                table.addCell("₹" + String.format("%.2f", item.getNetAmount()));  // Net Amount
	                
	                // Tax details
	                String taxRates = item.getTaxDetails().stream()
	                    .map(tax -> String.format("%.2f%%", tax.getTaxRate()))
	                    .collect(Collectors.joining("\n"));
	                table.addCell(taxRates);  // Tax Rate
	                
	                String taxTypes = item.getTaxDetails().stream()
	                    .map(TaxDetail::getTaxType)
	                    .collect(Collectors.joining("\n"));
	                table.addCell(taxTypes);  // Tax Type
	                
	                String taxAmounts = item.getTaxDetails().stream()
	                    .map(tax -> "₹" + String.format("%.2f", tax.getTaxAmount()))
	                    .collect(Collectors.joining("\n"));
	                table.addCell(taxAmounts);  // Tax Amount
	                
	                table.addCell("₹" + String.format("%.2f", totalAmount));  // Total Amount
	            } else {
	                // Add data for other items
	                table.addCell(String.valueOf(slNo));  // Serial Number
	                table.addCell(item.getDescription());  // Description
	                table.addCell("₹" + String.format("%.2f", item.getUnitPrice()));  // Unit Price
	                table.addCell("1");  // Quantity fixed as 1
	                table.addCell("₹" + String.format("%.2f", item.getNetAmount()));  // Net Amount
	                
	                // Tax details
	                String taxRates = item.getTaxDetails().stream()
	                    .map(tax -> String.format("%.2f%%", tax.getTaxRate()))
	                    .collect(Collectors.joining("\n"));
	                table.addCell(taxRates);  // Tax Rate
	                
	                String taxTypes = item.getTaxDetails().stream()
	                    .map(TaxDetail::getTaxType)
	                    .collect(Collectors.joining("\n"));
	                table.addCell(taxTypes);  // Tax Type
	                
	                String taxAmounts = item.getTaxDetails().stream()
	                    .map(tax -> "₹" + String.format("%.2f", tax.getTaxAmount()))
	                    .collect(Collectors.joining("\n"));
	                table.addCell(taxAmounts);  // Tax Amount
	                
	                table.addCell("₹" + String.format("%.2f", totalAmount));  // Total Amount
	            }
	        }
	    }


	    private static class ItemDetail {
	        private String description;
	        private double unitPrice;
	        private int quantity;
	        private double netAmount;
	        private List<TaxDetail> taxDetails;

	        public ItemDetail(String description, double unitPrice, int quantity, double netAmount, List<TaxDetail> taxDetails) {
	            this.description = description;
	            this.unitPrice = unitPrice;
	            this.quantity = quantity;
	            this.netAmount = netAmount;
	            this.taxDetails = taxDetails;
	        }

	        public String getDescription() {
	            return description;
	        }

	        public double getUnitPrice() {
	            return unitPrice;
	        }

	        public int getQuantity() {
	            return quantity;
	        }

	        public double getNetAmount() {
	            return netAmount;
	        }

	        public List<TaxDetail> getTaxDetails() {
	            return taxDetails;
	        }
	    }

	    private static class TaxDetail {
	        private double taxRate;
	        private String taxType;
	        private double taxAmount;

	        public TaxDetail(double taxRate, String taxType, double taxAmount) {
	            this.taxRate = taxRate;
	            this.taxType = taxType;
	            this.taxAmount = taxAmount;
	        }

	        public double getTaxRate() {
	            return taxRate;
	        }

	        public String getTaxType() {
	            return taxType;
	        }

	        public double getTaxAmount() {
	            return taxAmount;
	        }
	    }
	}

