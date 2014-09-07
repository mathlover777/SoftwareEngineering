package code;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GenerateCheque {

	/**
	 * @param args
	 */

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.RED);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);

	private static String name = "";
	private static String id = "";
	private static String account = "";
	private static String filename = "";
	private static String path = "";
	static int amount = 0;
	private Bridge bridge;
	
	/***************Extra Code for unit test********************************/
	
	public static void main(String args[]){
		generate("Sourav","4344","1000","sourav_cheque","D:\\","xxxxxx");
	}
	
	/**********************************************************************/
	
	
	public static void generate(String name, String id, String amount,
			String filename, String path, String account) {
		try {
			GenerateCheque.name = name;
			GenerateCheque.id = id;
			GenerateCheque.amount = Integer.parseInt(amount);
			GenerateCheque.filename = filename;
			GenerateCheque.path = path;
			GenerateCheque.account = account;
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(GenerateCheque.path
					+ GenerateCheque.filename + ".pdf"));
			document.open();
			// System.
			write(document);
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void write(Document document) throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Bank of Unobtainia", catFont));

		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface.add(new Paragraph("Generated at: " + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				smallBold));
		addEmptyLine(preface, 2);

		preface.add(new Paragraph("To Pay : " + name + "  id = " + id
				+ "  account = " + account, catFont));

		addEmptyLine(preface, 1);

		preface.add(new Paragraph("Amount : Rs " + amount + "/- only", redFont));

		document.add(preface);
		// Start a new page
		document.newPage();
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

}