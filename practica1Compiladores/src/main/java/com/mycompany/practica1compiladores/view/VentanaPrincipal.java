package com.mycompany.practica1compiladores.view;

import com.itextpdf.text.DocumentException;
import com.mycompany.practica1compiladores.backend.analisis.Parser;
import com.mycompany.practica1compiladores.backend.analisis.Scan;
import com.mycompany.practica1compiladores.backend.instruccion.Instruccion;
import com.mycompany.practica1compiladores.backend.symbol.Arbol;
import com.mycompany.practica1compiladores.backend.symbol.TablaDeSimbolo;
import com.mycompany.practica1compiladores.backend.utilities.FilesControl;
import com.mycompany.practica1compiladores.backend.utilities.GestionTab;
import com.mycompany.practica1compiladores.view.figura.Figura;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author giovanic
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private final FilesControl control;
    private final GestionTab gestionTab;
    private JPanel fileSave;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();

        setLocationRelativeTo(null);
        this.control = new FilesControl();
        this.gestionTab = new GestionTab(tab, control);
        Image icon = new ImageIcon(getClass().getResource("/logoTransparente.png")).getImage();
        setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tab = new javax.swing.JTabbedPane();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        nuevoMenuItem = new javax.swing.JMenuItem();
        abrirMenuItem = new javax.swing.JMenuItem();
        guardarMenuItem = new javax.swing.JMenuItem();
        eliminarTabMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnExportPNG = new javax.swing.JMenuItem();
        btnExportPDF = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        btnVerReportes = new javax.swing.JMenuItem();
        btnReporteError = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        btnRun = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FIGURAS");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));

        menuArchivo.setText("Accion");

        nuevoMenuItem.setText("Nuevo Archivo");
        nuevoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoMenuItemActionPerformed(evt);
            }
        });
        menuArchivo.add(nuevoMenuItem);

        abrirMenuItem.setText("Abrir Archivo");
        abrirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirMenuItemActionPerformed(evt);
            }
        });
        menuArchivo.add(abrirMenuItem);

        guardarMenuItem.setText("Guardar Archivo");
        guardarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarMenuItemActionPerformed(evt);
            }
        });
        menuArchivo.add(guardarMenuItem);

        eliminarTabMenuItem.setText("Eliminar Pestaña");
        eliminarTabMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarTabMenuItemActionPerformed(evt);
            }
        });
        menuArchivo.add(eliminarTabMenuItem);

        jMenu2.setText("Exportar");

        btnExportPNG.setText("Exportar a PNG");
        btnExportPNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPNGActionPerformed(evt);
            }
        });
        jMenu2.add(btnExportPNG);

        btnExportPDF.setText("Exportar a PDF");
        btnExportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportPDFActionPerformed(evt);
            }
        });
        jMenu2.add(btnExportPDF);

        menuArchivo.add(jMenu2);

        barraMenu.add(menuArchivo);

        menuReport.setText("Reportes");

        btnVerReportes.setText("Ver Reportes");
        btnVerReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReportesActionPerformed(evt);
            }
        });
        menuReport.add(btnVerReportes);

        btnReporteError.setText("Ver Reportes de Error");
        btnReporteError.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteErrorActionPerformed(evt);
            }
        });
        menuReport.add(btnReporteError);

        barraMenu.add(menuReport);

        jMenu1.setText("build");

        btnRun.setText("Run");
        btnRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRunActionPerformed(evt);
            }
        });
        jMenu1.add(btnRun);

        barraMenu.add(jMenu1);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tab, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRunActionPerformed
        if (tab.getSelectedIndex() != -1) {

            int index = tab.getSelectedIndex();
            Tab temp = (Tab) tab.getComponentAt(index);
            String texto = temp.getVistaContenido() + "\n";

            JFrame fr = new JFrame("prueba");
            fr.setSize(500, 300);
            fr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            // Obtener el entorno gráfico y el dispositivo
            fr.setExtendedState(JFrame.MAXIMIZED_BOTH);

            LinkedList<Figura> figuras = new LinkedList<>();
            ListaFiguras lFiguras = new ListaFiguras(figuras);

            System.out.println("\n\n");
            try {
                StringReader stringReader = new StringReader(texto);
                Scan scan = new Scan(stringReader);
                Parser parser = new Parser(scan);
                var resultado = parser.parse();
                var ast = new Arbol((LinkedList<Instruccion>) resultado.value);
                var tabla = new TablaDeSimbolo();
                tabla.setNombre("GLOBAL");

                for (var a : ast.getInstrucciones()) {
                    if (a == null) {
                        continue;
                    }
                    var res = a.interpretar(ast, tabla);
                    if (res instanceof Figura f) {
                        // fr.add((Figura) a.interpretar(ast, tabla));
                        figuras.add(f);
                    }
                    if (res instanceof com.mycompany.practica1compiladores.backend.error.Error r) {
                        System.out.println(r.toString());
                    }
                }
                fr.add(lFiguras);
                fileSave = lFiguras;
                fr.setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {
            System.out.println("------ ERROR -----"
                    + "\n--No HAY ARCHIVO--");
        }
    }//GEN-LAST:event_btnRunActionPerformed

    private void btnExportPNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPNGActionPerformed
        if (!Objects.isNull(fileSave)) {
            try {
                control.guardarImagen(fileSave.getWidth(), fileSave.getHeight(), fileSave);
            } catch (IOException e) {
                System.out.println("\n\tERROR EN ARCHIVO + PNG\n");
            }
        } else {
            System.out.println("\n\tEL ARCHIVO NO EXISTE\n");
        }
    }//GEN-LAST:event_btnExportPNGActionPerformed

    private void btnExportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportPDFActionPerformed
        if (!Objects.isNull(fileSave)) {
            try {
                File fi = control.crear("pdf");
                control.guardarPDF(fi, fileSave.getWidth(), fileSave.getHeight(), fileSave);
            } catch (DocumentException | IOException e) {
                System.out.println("\n\tERROR EN ARCHIVO + PDF\n");
                e.printStackTrace();
            }
        } else {
            System.out.println("\n\tEL ARCHIVO NO EXISTE\n");
        }
    }//GEN-LAST:event_btnExportPDFActionPerformed

    private void nuevoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nuevoMenuItemActionPerformed
        File archivo = control.crear("txt");
        if (!Objects.isNull(archivo)) {
            String contenido = control.getContenido(archivo.getAbsolutePath());
            gestionTab.addTab(archivo, contenido);
        }
    }// GEN-LAST:event_nuevoMenuItemActionPerformed

    private void abrirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_abrirMenuItemActionPerformed
        File archivo = control.getFile();
        if (!Objects.isNull(archivo)) {
            String contenido = control.getContenido(archivo.getAbsolutePath());
            gestionTab.addTab(archivo, contenido);
        }
    }// GEN-LAST:event_abrirMenuItemActionPerformed

    private void guardarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_guardarMenuItemActionPerformed
        if (tab.getSelectedIndex() != -1) {
            gestionTab.sobreEscribir(tab.getSelectedIndex());
        }
    }// GEN-LAST:event_guardarMenuItemActionPerformed

    private void eliminarTabMenuItemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_eliminarTabMenuItemActionPerformed
        if (tab.getSelectedIndex() != -1) {
            gestionTab.deleteTab(tab.getSelectedIndex());
        } else {
            JOptionPane.showMessageDialog(null, "No hay pesañas que cerrar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_eliminarTabMenuItemActionPerformed

    private void btnVerReportesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnVerReportesActionPerformed
        ReporteD rd = new ReporteD(this, true);
        rd.setLocationRelativeTo(null);
        rd.setVisible(true);
    }// GEN-LAST:event_btnVerReportesActionPerformed

    private void btnReporteErrorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnReporteErrorActionPerformed
        ReporteErrorD errorD = new ReporteErrorD(this, true);
        errorD.setLocationRelativeTo(null);
        errorD.setVisible(true);
    }// GEN-LAST:event_btnReporteErrorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem abrirMenuItem;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem btnExportPDF;
    private javax.swing.JMenuItem btnExportPNG;
    private javax.swing.JMenuItem btnReporteError;
    private javax.swing.JMenuItem btnRun;
    private javax.swing.JMenuItem btnVerReportes;
    private javax.swing.JMenuItem eliminarTabMenuItem;
    private javax.swing.JMenuItem guardarMenuItem;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenuItem nuevoMenuItem;
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
