package com.mycompany.practica1compiladores.backend.utilities;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Clase que gestiona los ficheros
 *
 * @author giovanic
 */
public class FilesControl {

    /**
     * Metodo para obtener un file
     *
     * @param filtro la extension predeterminada que se muestra en el
     * filechooser
     * @return File
     */
    private File seleccionarArchivo(FileNameExtensionFilter filtro) throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showOpenDialog(null);
        switch (respuesta) {
            case JFileChooser.APPROVE_OPTION -> {
                return fileChooser.getSelectedFile();
            }
            case JFileChooser.CANCEL_OPTION, JFileChooser.ERROR_OPTION -> {
                return null;
            }
        }
        return null;
    }

    /**
     * Metodo para obtener el contenido de un archivio
     *
     * @param path el path del archivo
     * @return string con el contenido del archivo
     */
    public String getContenido(String path) {
        String cont = "";
        try {
            cont = getArchivo(path);
        } catch (NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return cont;
    }

    public File getFile() {
        File myObj = null;
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", "TXT");
            myObj = seleccionarArchivo(filtro);
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return myObj;
    }

    // -------------------------Se obtiene el contenido del
    // Archivo----------------//
    @SuppressWarnings("null")
    private String getArchivo(String ruta) {
        FileReader fr = null;
        BufferedReader br = null;
        // Cadena de texto donde se guardara el contenido del archivo
        StringBuilder contenido = new StringBuilder();
        try {
            // ruta puede ser de tipo String
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            String linea;
            // Obtenemos el contenido del archivo linea por linea
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }

        } catch (IOException ignored) {
        } // finally se utiliza para que si todo ocurre correctamente o si ocurre
        // algun error se cierre el archivo que anteriormente abrimos
        finally {
            try {
                br.close();
            } catch (IOException ignored) {
            }
        }
        return contenido.toString();
    }

    /**
     * Metodo para crear un archivo, en este caso html
     *
     * @return retornara el archivo creado
     */
    private File crearArchivo(String path) {
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            return myObj;
        } catch (IOException ignored) {
        }
        return null;
    }

    /**
     * Metodo para escribir en un archivo
     *
     * @param contenido cadena de caracteres
     * @param ruta el path del archivo
     */
    public void sobreEscribir(String contenido, String ruta) {
        // antes -> escribirEnFile
        try {
            FileWriter myWriter = new FileWriter(ruta);
            myWriter.write(contenido);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Metodo que sirve para comprobar si el archivo a sido sobreescrito.
     *
     * @param file archivo del cual se obtendra el contenido
     * @param contenido texto a evaluar con el contenido del archivo
     * @return true: si el archivo esta sobreescrito, de lo contrario false
     */
    public boolean estaSobreEscrito(File file, String contenido) {
        return !getContenido(file.getAbsolutePath()).trim().replaceAll("[\r\n]+$", "").equals(contenido);
    }

    public File crear(String extension) {
        String textoPredefinido = "nuevo_archivo." + extension;
        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.setDialogTitle("Guardar Archivo");
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*." + extension, extension.toUpperCase());
        fileChooser.setFileFilter(filtro);
        File predeterminado = new File(textoPredefinido);
        fileChooser.setSelectedFile(predeterminado);
        // abrir el dialog para guardar
        int respuesta = fileChooser.showSaveDialog(null);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            if (fileChooser.getSelectedFile().exists()) {
                return fileChooser.getSelectedFile();
            } else {
                return crearArchivo(fileChooser.getSelectedFile().getAbsolutePath());
            }
        }
        return null;
    }

    public void guardarImagen(int ancho, int alto, JPanel jp) throws IOException {
        // Crear un BufferedImage
        BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        // Pintar el JPanel en el BufferedImage
        jp.paint(g2d);
        // Guardar el BufferedImage como PNG
        File f = crear("png");
        ImageIO.write(image, "PNG", f);
        g2d.dispose();
    }

    public void guardarPDF(File file, int ancho, int alto, JPanel jp) throws IOException, DocumentException {
        BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();

        // Pintar el JPanel en el BufferedImage
        jp.paint(g2d);
        g2d.dispose();

        // Crear un documento PDF
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        // Convertir BufferedImage a PDF
        Image pdfImage = Image.getInstance(image, null);

        // Ajustar la imagen para que se ajuste a la página horizontal
        pdfImage.setAbsolutePosition(0, 0);
        pdfImage.scaleToFit(PageSize.A4.rotate().getWidth(), PageSize.A4.rotate().getHeight());

        PdfContentByte pdfContentByte = writer.getDirectContent();
        pdfContentByte.addImage(pdfImage);

        document.close();
    }
}
