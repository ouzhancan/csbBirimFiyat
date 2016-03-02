package com.ouz.csb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.Connection;

/**
 *
 * @author ouz
 */
public class mainFrame extends javax.swing.JFrame {

    //Sistem sabitleri
    private static String kullaniciAdi = "bayiller8";
    private static String sifre = "11111111";
    private static String detayPozNo = "701-101";
    private static Map<String, String> loginCookies;
    private static Map<String, String> aramaCookies;

    private static final String gonder = "Giri%FE";
    private static final String siteUrl = "http://www.csb.gov.tr/birimfiyat/";
    private static final String logInUrl = "uyeislemleri.php?id=1";
    private static final String cikisUrl = "uyeislemleri.php?id=4";
    private static final String anasayfaUrl = "index.php?Sayfa=ana";
    private static final String aramaUrl = "index.php?Sayfa=arama";
    private static final String aramaDetayUrl = "index.php?Sayfa=aramadetay";
    private static final String kitapUrl = "index.php?Sayfa=kitap";

    // Sistem degiskenleri
    private static String islemMesaj = "";
    private static File okunacakExcel;
    private static File yazilacakExcel;
    private static Boolean oturumAcikMi = false;
    private static String girisYapilanKullaniciAdi = "";
    private static  Map<String, String[]> data ;

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();

        // proxy ayarla.
        setProxySettings();
        
        data = new TreeMap<String, String[]>();
        data.put("1", new String[]{"Poz No", "Konu", "Miktar", "Birim Fiyat", "Montaj"});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtMesaj = new javax.swing.JTextArea();
        btnOturumAc = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnCikisYap = new javax.swing.JButton();
        txtDosyaAdi = new javax.swing.JTextField();
        btnDosyaSec = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtYazilacakDosya = new javax.swing.JTextField();
        btnYazilacakDosyaSec = new javax.swing.JButton();
        btnIslem = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("mainFrame"); // NOI18N
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMesaj.setColumns(20);
        txtMesaj.setRows(5);
        jScrollPane1.setViewportView(txtMesaj);
        txtMesaj.getAccessibleContext().setAccessibleName("txtMesaj");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 218, 581, -1));

        btnOturumAc.setForeground(new java.awt.Color(0, 153, 0));
        btnOturumAc.setText("Oturum A�");
        btnOturumAc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOturumAcActionPerformed(evt);
            }
        });
        getContentPane().add(btnOturumAc, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 6, 126, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Oturum A� :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 11, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("��k�� Yap :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 11, -1, -1));

        btnCikisYap.setForeground(new java.awt.Color(204, 0, 51));
        btnCikisYap.setText("G�venli ��k�� Yap !");
        btnCikisYap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCikisYapActionPerformed(evt);
            }
        });
        getContentPane().add(btnCikisYap, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 6, 146, -1));
        btnCikisYap.getAccessibleContext().setAccessibleName("btnCikisYap");

        txtDosyaAdi.setText("Okunacak Dosya Ad� ...");
        getContentPane().add(txtDosyaAdi, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 67, 240, -1));
        txtDosyaAdi.getAccessibleContext().setAccessibleName("txtDosyaAdi");

        btnDosyaSec.setText("Se�");
        btnDosyaSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosyaSecActionPerformed(evt);
            }
        });
        getContentPane().add(btnDosyaSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 68, 85, -1));
        btnDosyaSec.getAccessibleContext().setAccessibleName("btnDosyaSec");

        jLabel3.setText("Okunacak Excel Dosyas�n� Se�iniz");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 73, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("Bilgilendirme ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 196, -1, -1));

        jLabel5.setText("Yaz�lacak Excel Dosyas�n� Se�iniz ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 120, -1, -1));

        txtYazilacakDosya.setText("Yaz�lacak Dosya Ad� ...");
        getContentPane().add(txtYazilacakDosya, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 114, 240, -1));

        btnYazilacakDosyaSec.setText("Se�");
        btnYazilacakDosyaSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYazilacakDosyaSecActionPerformed(evt);
            }
        });
        getContentPane().add(btnYazilacakDosyaSec, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 115, 85, -1));

        btnIslem.setBackground(new java.awt.Color(0, 0, 153));
        btnIslem.setFont(new java.awt.Font("Malayalam MN", 0, 13)); // NOI18N
        btnIslem.setForeground(new java.awt.Color(204, 255, 255));
        btnIslem.setText("� � L E M �      B A � L A T ");
        btnIslem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIslemActionPerformed(evt);
            }
        });
        getContentPane().add(btnIslem, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 156, 575, -1));

        jMenu1.setText("Ayarlar");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setActionCommand("ayarMenu");
        jMenuItem1.setLabel("Farkl� Bilgilerle Giri� Yap");
        jMenu1.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleName("ayarMenu");
        jMenuItem1.getAccessibleContext().setAccessibleDescription("");

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleName("mainFrame");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Oturum a� butonuna basildiginda sayfada oturum a��lmas� i�in �al��acak
     * olan method.
     *
     * @param evt
     */
    private void btnOturumAcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOturumAcActionPerformed

        String sonuc = "";

        if (girisYapilanKullaniciAdi.length() <= 0 && !oturumAcikMi) {
            try {
                sonuc = logIn();
            } catch (MalformedURLException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            sonuc = girisYapilanKullaniciAdi;
        }

        if (!sonuc.equalsIgnoreCase(kullaniciAdi)) {
            islemMesaj += "Sisteme Giri� Yap�lamad� !\nHata : " + sonuc + "\n";

            JOptionPane.showMessageDialog(null, "Sisteme Giri� Yap�lamad� !\nHata : " + sonuc, " InfoBox: " + " HATA ", JOptionPane.ERROR_MESSAGE);

            oturumAcikMi = false;

        } else {
            System.out.println("Arama i�in haziriz !");

            islemMesaj += "G�R�� BA�ARILI ! : " + sonuc + "\n";
            JOptionPane.showMessageDialog(null, "G�R�� BA�ARILI !: " + sonuc + "\n", " Bilgilendirme ", JOptionPane.INFORMATION_MESSAGE);
            oturumAcikMi = true;
        }

        txtMesaj.setText(islemMesaj);
    }//GEN-LAST:event_btnOturumAcActionPerformed

    private void btnCikisYapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisYapActionPerformed
       // cikisYap();
        oturumAcikMi = false;
    }//GEN-LAST:event_btnCikisYapActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        cikisYap();
        oturumAcikMi = false;
    }//GEN-LAST:event_formWindowClosed

    /**
     * Proje kodlarinin okunacagi excel dosyasini sececek olan method
     *
     * @param evt
     */
    private void btnDosyaSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosyaSecActionPerformed

        final JFileChooser fc = new JFileChooser();
        FileFilter filter = new FileNameExtensionFilter("Excel Dosyalar�", "xlsx", "xls");
        fc.addChoosableFileFilter(filter);

        int dialogResult = fc.showOpenDialog(null);

        if (dialogResult == JFileChooser.OPEN_DIALOG) {
            System.out.println("Dialog acildi !");

            if (dialogResult == JFileChooser.APPROVE_OPTION) {
                okunacakExcel = fc.getSelectedFile();
                txtDosyaAdi.setText(fc.getSelectedFile().getName());
                islemMesaj += "Okunacak Excel dosyas� se�ildi : " + fc.getSelectedFile().getAbsolutePath() + "\n";
                txtMesaj.setText(islemMesaj);
            }
        }

    }//GEN-LAST:event_btnDosyaSecActionPerformed

    /**
     * Yaz�lacak excel dosyasini sececek olan method
     *
     * @param evt
     */
    private void btnYazilacakDosyaSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYazilacakDosyaSecActionPerformed

        if (okunacakExcel != null && okunacakExcel.isFile()) {

            final JFileChooser fc = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("Excel Dosyalar�", "xlsx", "xls");
            fc.addChoosableFileFilter(filter);

            int dialogResult = fc.showOpenDialog(null);

            if (dialogResult == JFileChooser.OPEN_DIALOG) {
                System.out.println("Dialog acildi !");

                if (dialogResult == JFileChooser.APPROVE_OPTION) {
                    yazilacakExcel = fc.getSelectedFile();
                    txtYazilacakDosya.setText(fc.getSelectedFile().getName());
                    islemMesaj += "Yaz�lacak Excel dosyas� se�ildi : " + fc.getSelectedFile().getAbsolutePath() + "\n";
                    txtMesaj.setText(islemMesaj);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "�ncelikle Okunacak Excel Dosyas�n� Girmelisiniz !\n", "UYARI", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnYazilacakDosyaSecActionPerformed

    /**
     * okunacak excel dosyasindan kodlari okuyacak, ilgili proje kodlari i�in
     * arama yapacak ve arama sonu�lar�n� yazilacak olarak se�ilen excele
     * yazacak olan method
     *
     * @param evt
     */
    private void btnIslemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIslemActionPerformed

        if (loginCookies != null && !loginCookies.isEmpty() && girisYapilanKullaniciAdi.equalsIgnoreCase(kullaniciAdi)) {

            //String login = logIn();
            if (okunacakExcel != null && okunacakExcel.isFile() && oturumAcikMi) {

                islemMesaj += "��lem Ba�lad� !\n Biraz zaman alabilir l�tfen bekleyiniz !\n";
                txtMesaj.setText(islemMesaj);

                FileInputStream fis;
                try {
                    fis = new FileInputStream(okunacakExcel);

                    XSSFWorkbook myWorkBook = null;
                    try {
                        myWorkBook = new XSSFWorkbook(fis);
                    } catch (Exception e) {
                        islemMesaj += "Excel Sayfas� Okunamad� !\n";
                    }
// Finds the workbook instance for XLSX file 

// Return first sheet from the XLSX workbook 
                    XSSFSheet mySheet = myWorkBook.getSheetAt(0);
// Get iterator to all the rows in current sheet 
                    Iterator<Row> rowIterator = mySheet.iterator();

                    Row row = rowIterator.next(); // satir basliklari
// Traversing over each row of XLSX file 
                    while (rowIterator.hasNext()) {
                        row = rowIterator.next(); // ilk satir
// For each row, iterate through each columns 
                        // Iterator<Cell> cellIterator = row.cellIterator();
                        Cell pozNoSutun = row.getCell(0);
                        Cell fiyatSutun = row.getCell(3);
                        //while (cellIterator.hasNext()) {
                        //Cell cell = cellIterator.next();
                        switch (pozNoSutun.getCellType()) {
                            case Cell.CELL_TYPE_STRING:

                                System.out.println(pozNoSutun.getStringCellValue() + "\t");

                                //  String birimFiyat = birimFiyatGetir(pozNoSutun.getStringCellValue());
                                String digerBirimFiyat = birimFiyatDetayGetir(pozNoSutun.getStringCellValue());

                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.print(pozNoSutun.getNumericCellValue() + "\t");
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                System.out.print(pozNoSutun.getBooleanCellValue() + "\t");
                                break;
                            default:
                        }
                        // }
                        System.out.println("");
                    }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    islemMesaj += " Excel �al��ma Sayfas� Okunamad� !\n";
                } catch (IOException ex) {

                    islemMesaj += " File IOException  !\n";
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

                txtMesaj.setText(islemMesaj);
            } else {
                JOptionPane.showMessageDialog(null, "Oturum a��k oldu�undan ve okunacak/yaz�lacak excel dosyalar�n� se�ti�inizden emin olunuz ! \n", "HATA", JOptionPane.ERROR_MESSAGE);

                islemMesaj += "Oturum a��k oldu�undan ve okunacak/yaz�lacak excel dosyalar�n� se�ti�inizden emin olunuz ! \n";

                txtMesaj.setText(islemMesaj);
            }

            //cikisYap();
        } else {
            JOptionPane.showMessageDialog(null, "Oturum a�t���n�zdan emin olunuz ! \n", "HATA", JOptionPane.ERROR_MESSAGE);

            islemMesaj += "Oturum a�t���n�zdan emin olunuz ! \n";

            txtMesaj.setText(islemMesaj);
        }
    }//GEN-LAST:event_btnIslemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        cikisYap();
        oturumAcikMi=false;
    }//GEN-LAST:event_formWindowClosing

    /**
     * Get ile istekte bulunup birim ilgili poz numaras�na ait �r�n i�in birim
     * fiyat getirecek.
     *
     * @param pozNo : excelden okunan poz numarasi degeri string
     * @return : poz numaras�na g�re get ile istekten d�nen birim fiyat bilgisi
     * string olarak d�nd�r�l�r.
     */
    public String birimFiyatGetir(String pozNo) {

        String birimFiyat = "-";
        Boolean basariliMi = false;
        String url = siteUrl + aramaUrl;
        String result = " \n";

        try {
            Connection.Response docx = Jsoup.connect(siteUrl + aramaUrl)
                    .method(Connection.Method.GET)
                    .cookies(loginCookies)
                    .execute();

            System.out.println(docx);

            aramaCookies = docx.cookies();
            detayPozNo = pozNo;

            URL obj = new URL(url);

            Document doc = Jsoup.connect(url)
                    .data("cookieexists", "false")
                    .data("DetayPozNo", "")
                    .data("Yil", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)))
                    .data("PozTipi", "-1")
                    .data("PozNo", detayPozNo)
                    .data("Tanim", "")
                    .data("TumAlan", "")
                    .userAgent("Mozilla")
                    .timeout(50000)
                    .cookies(aramaCookies)
                    .post();

            System.out.println(doc);

            if (doc != null) {
                Element table = doc.getElementById("icerik");

                if (table != null && table.text().length() > 0) {

                    Elements sutunlar = table.select("td");

                    for (Element sutun : sutunlar) {
                        if (sutun.text().trim().equalsIgnoreCase(detayPozNo)) {
                            basariliMi = true;
                            break;
                        }
                    }
                    if (basariliMi) {
                        result = "Poz No : " + detayPozNo + " detay bulundu !\n";
                        birimFiyat = birimFiyatDetayGetir(detayPozNo);

                        System.out.println("Arama Ekran� - Poz No : " + detayPozNo + " Birim Fiyat : " + birimFiyat + "\n");
                    } else {
                        result = "Sonu� (Detay) BULUNAMADI ! Poz No : " + detayPozNo + "\n";
                    }
                } else {
                    result = " Birim Fiyat Okunamad� ! Poz No :  " + detayPozNo + "\n";
                }

            } else {
                result = " Birim Fiyat Okunamad� ! Poz No :  " + detayPozNo + "\n";
            }
        } catch (Exception e) {
            result = " HATA(101) - B�R�M F�YAT OKUMA ��LEM� BA�ARISIZ !";
            System.out.println(e.getMessage());
            result += e.getMessage() + "\n";
        } finally {
            islemMesaj += " Birim Fiyat Okuma ��lemi " + result;
            txtMesaj.setText(islemMesaj);
        }

        return birimFiyat;

    }

    public String writeExcel(String[] yazilacakData, File yazilacakDosya) {

        String sonuc = "";

        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");

        //This data needs to be written (Object[])
       
        data.put("2", new String[]{"1", "Amit", "Shukla"});
        data.put("3", new String[]{"2", "Lokesh", "Gupta"});
        data.put("4", new String[]{"3", "John", "Adwards"});
        data.put("5", new String[]{"4", "Brian", "Schultz"});

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                }
            }
        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(yazilacakDosya);
            workbook.write(out);
            out.close();

            sonuc = yazilacakDosya.getAbsolutePath() + " dosyasina basariyla yazildi !\n";
            islemMesaj += sonuc;
            System.out.println(yazilacakDosya.getAbsolutePath() + "   basariyla yazildi !\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtMesaj.setText(islemMesaj);
        return sonuc;

    }

    /**
     * arama sayfasinda gelen sonuuca
     *
     * @param detayPozNo : detay poz numarasi
     * @return birimfiyat
     */
    public String birimFiyatDetayGetir(String detayPozNo) throws IOException {

        String birimFiyat = "-";
        String maxBirimFiyat = "-";
        String konu = "-";
        String miktar = "AD";

        String[] data = new String[4];

        String arananPozNo;
        Boolean basariliMi = false;

        String url = siteUrl + aramaDetayUrl;
        String result = " \n";

        File yeniolustur = new File(okunacakExcel.getParent() + "/yeni_excel.xlsx");

        if (yeniolustur.exists()) {
            System.out.println("Dosya zaten var !\n");
            yazilacakExcel = yeniolustur;
        } else if (yeniolustur.createNewFile()) {
            yazilacakExcel = yeniolustur;
        } else {
            System.out.println("Dosya olusturulamadi !\n");
        }

        FileOutputStream fos = new FileOutputStream(yazilacakExcel);

        try {

            arananPozNo = detayPozNo;

            URL obj = new URL(url);

            Document doc = Jsoup.connect(url)
                    .data("DetayPozNo", arananPozNo)
                    .data("Yil", String.valueOf(Calendar.getInstance().get(Calendar.YEAR)))
                    .data("PozTipi", "-1")
                    .data("PozNo", arananPozNo)
                    .data("Tanim", "")
                    .data("TumAlan", "")
                    .userAgent("Mozilla")
                    .cookies(loginCookies)
                    .post();

            System.out.println(doc);

            if (doc != null) {
                Elements tables = doc.select("table.table.table-striped");

                Elements satirlar = tables.get(1).select("tr");

                int indis = 1;

                for (Element satir : satirlar) {

                    Elements sutunlar = satir.select("td");

                    if (sutunlar.get(0).text().trim().equalsIgnoreCase(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)))) {
                        basariliMi = true;
                        maxBirimFiyat = sutunlar.get(1).text();
                        birimFiyat = sutunlar.get(2).text();

                        data[0] = String.valueOf(indis);
                        data[1] = arananPozNo;
                        data[2] = String.valueOf(maxBirimFiyat);
                        data[3] = String.valueOf(birimFiyat);

                        writeExcel(data, yazilacakExcel);

                        System.out.println("Detay Arama Ekran� - Poz No : " + arananPozNo + " Birim Fiyat : " + birimFiyat + " Max Birim Fiyat : " + maxBirimFiyat + "\n");
                    }
                    if (basariliMi) {
                        break;
                    }
                }
                if (basariliMi) {
                    result = maxBirimFiyat + "#" + birimFiyat;
                } else {
                    result = "Sonu� (Detay) BULUNAMADI ! Poz No : " + arananPozNo + "\n";
                }
            } else {
                result = " Birim Fiyat Okunamad� ! Poz No :  " + arananPozNo + "\n";
            }
        } catch (Exception e) {
            result = " HATA(101) - B�R�M F�YAT OKUMA ��LEM� BA�ARISIZ !";
            System.out.println(e.getMessage());
            result += e.getMessage() + "\n";
        } finally {
            islemMesaj += " Birim Fiyat Okuma ��lemi " + result;
            txtMesaj.setText(islemMesaj);
        }

        return result;
    }

    /**
     * Proxy ayarlarinin yapilaca�i method.
     */
    public void setProxySettings() {
        //System.setProperty("http.proxySet","true");
        System.setProperty("http.proxyHost", "btsproxy");
        System.setProperty("http.proxyPort", "8080");

        islemMesaj += "Proxy ayarlari yap�ld� !\n";

        txtMesaj.setText(islemMesaj);
    }

    /**
     * Sisteme giris yapmak icin giris sayfasina post istekte bulunan method
     *
     * @return 1:BASARILI, 0 HATALI
     */
    public String logIn() throws MalformedURLException {

        String sonuc = "";

        String url = siteUrl + logInUrl;

        URL obj = new URL(url);

        if (!oturumAcikMi && loginCookies == null) {

            try{
            Connection.Response respGet = Jsoup.connect(url)
                    .timeout(5000)
                    .userAgent("Mozilla")
                    // and other hidden fields which are being passed in post request.
                    .method(Connection.Method.GET)
                    .execute();

            loginCookies = respGet.cookies();
            }
            catch(Exception c){
                System.out.println("HATA : "+c.getMessage()+" Trace : "+c.getStackTrace());
            }

            try {

                Connection.Response resp = Jsoup.connect(url)
                        .data("KullaniciAdi", kullaniciAdi)
                        .data("Sifre", sifre)
                        .data("gonder", gonder)
                        .timeout(50000)
                        .userAgent("Mozilla")
                        .cookies(loginCookies)
                        // and other hidden fields which are being passed in post request.
                        .method(Connection.Method.POST)
                        .execute();

                if (loginCookies == null || loginCookies.isEmpty()) {
                    loginCookies = resp.cookies();
                }

                Document doc = resp.parse();

                System.out.println(doc);

                if (doc != null) {
                    Element context = doc.getElementById("menu");

                    Elements links = doc.select("a[href]");

                    Element arananLink = null;

                    for (Element link : links) {
                        System.out.println("Link : " + link);

                        if (link.attr("href").equalsIgnoreCase(anasayfaUrl)) {
                            System.out.println("Kullan�c� Ad� >> " + link.text());
                            arananLink = link;
                            break;
                        }
                    }

                    // sisteme belirledigimiz kullanici adi ile girilmis ise,
                    if (arananLink.text().equalsIgnoreCase(kullaniciAdi)) {
                        sonuc = arananLink.text().trim();
                        girisYapilanKullaniciAdi = sonuc;
                    } else {
                        sonuc = "Kullanici Adi veya �ifre HATALI !";
                        islemMesaj += "Kullanici Adi veya �ifre HATALI !";
                        //cikisYap();
                    }

                    if (context != null) {
                        Elements uller = context.select("ul.navbar-nav");// .getElementsByClass("nav navbar-nav");

                        if (uller != null) {
                            Elements tags = uller.first().getElementsByTag("a");

                            System.out.println("Tags Text : " + tags.text());

                            sonuc = tags.text();
                        }
                    }
                } else {

                   //cikisYap();
                    sonuc = "\nD�k�man okunamad� !\nSisteme ayn� anda giri� yap�lmak isteniyor olabilir !\n";
                    islemMesaj += sonuc;
                    System.out.println("Hata-1 : " + sonuc);
                }

                oturumAcikMi = true;

            } catch (Exception e) {

                //cikisYap();
                System.out.println(e.getMessage());
                sonuc = e.getMessage();
                // hataya duserse sistemden cikis yap !
            }
        }

        return sonuc;
    }

    /**
     * Sistemden g�venli ��k�� yap�lmas�n� sa�lar. Daha sonra tekrar a��ld���nda
     * oturum a�mak icin problem yasanmamasi icin.
     */
    public void cikisYap() {

        String url = siteUrl + cikisUrl;

        String result = " BA�ARILI !\n";

        try {

            URL obj = new URL(url);

            Connection.Response resp = Jsoup.connect(url)
                    .cookies(loginCookies)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .method(Connection.Method.GET)
                    .execute();

            Document doc = resp.parse();

            System.out.println(doc);

            String baseUri = doc.baseUri();

            if (baseUri.equalsIgnoreCase(siteUrl + "index.php")) {
                result = " BA�ARILI !\n";
            }
            oturumAcikMi = false;

        } catch (Exception e) {
            result = " BA�ARISIZ ! \n";
            System.out.println(e.getMessage());
            result += e.getMessage();
        } finally {
            islemMesaj += "��k�� ��lemi " + result;
            txtMesaj.setText(islemMesaj);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCikisYap;
    private javax.swing.JButton btnDosyaSec;
    private javax.swing.JButton btnIslem;
    private javax.swing.JButton btnOturumAc;
    private javax.swing.JButton btnYazilacakDosyaSec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDosyaAdi;
    private javax.swing.JTextArea txtMesaj;
    private javax.swing.JTextField txtYazilacakDosya;
    // End of variables declaration//GEN-END:variables
}
