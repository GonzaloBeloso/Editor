import sun.text.normalizer.Replaceable;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.*;
public class Ventana extends JFrame implements ItemListener,ActionListener {
    JMenuBar barraMenu;
    JMenu mArchivo, mEdicion,mEstiloFuente;
    JMenuItem mItemNuevo, mItemAbrir, mItemCerrar,mItemGuardar,mItemGuardarComo,mItemImprimir;
    JMenuItem mItemCopiar,mItemCortar,mItemPegar,mItemBold,mItemNormal,mItemCursiva;
    JButton btnNuevo,btnAbrir,btnGuardar,btnImprimir,btnCopiar,btnCortar,btnPegar,btnBold;
    JButton btnCopiar2,btnCortar2,btnPegar2;
    JComboBox comboLetra, comboTamanio;
    DefaultComboBoxModel modeloLetra,modeloTamanio;
    JLabel labelLetra, labelTamanio;
    JPanel panelSuperior,panelCentro;
    JTextArea textArea;
    JPopupMenu popupMenu;
    JFileChooser fileChooser;

    public void initGUI(){
        instancias();
        configurarMenu();
        configurarPanel();
        rellenarTamanio();
        rellenarLetras();
        rellenarPopup();
        configurarMenu();
        acciones();
        this.setSize(new Dimension(900,450));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void rellenarPopup() {
        popupMenu.add(btnCopiar);
        popupMenu.add(btnCortar);
        popupMenu.add(btnPegar);
        textArea.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton()==MouseEvent.BUTTON3){
                    popupMenu.show(textArea,50,50);
                    setVisible(true);
                }
            }
        });
    }

    private void instancias() {
        popupMenu = new JPopupMenu();
        fileChooser = new JFileChooser();
        modeloLetra = new DefaultComboBoxModel();
        modeloTamanio = new DefaultComboBoxModel();
        comboLetra = new JComboBox(modeloLetra);
        comboTamanio = new JComboBox(modeloTamanio);
        labelLetra = new JLabel("Estilo");
        labelTamanio = new JLabel("Tipo");
        barraMenu = new JMenuBar();
        mArchivo = new JMenu("Archivo");
        mEdicion = new JMenu("Edición");
        mEstiloFuente = new JMenu("Estilo de la Fuente");
        mItemNuevo = new JMenuItem("Nuevo");
        mItemNuevo.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        mItemAbrir = new JMenuItem("Abrir");
        mItemAbrir.setIcon(new ImageIcon(getClass().getResource("/recursos/open.png")));
        mItemCerrar = new JMenuItem("Cerrar");
        mItemCerrar.setIcon(new ImageIcon(getClass().getResource("/recursos/close.png")));
        mItemGuardar = new JMenuItem("Guardar");
        mItemGuardar.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));
        mItemGuardarComo = new JMenuItem("Guardar Como");
        mItemImprimir = new JMenuItem("Imprimir");
        mItemImprimir.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        mItemCopiar = new JMenuItem("Copiar");
        mItemCopiar.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        mItemCortar = new JMenuItem("Cortar");
        mItemCortar.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        mItemPegar = new JMenuItem("Pegar");
        mItemPegar.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        mItemBold = new JMenuItem("Bold");
        mItemBold.setIcon(new ImageIcon(getClass().getResource("/recursos/bold.png")));
        mItemNormal = new JMenuItem("Normal");
        mItemNormal.setIcon(new ImageIcon(getClass().getResource("/recursos/normal.png")));
        mItemCursiva = new JMenuItem("Cursiva");
        mItemCursiva.setIcon(new ImageIcon(getClass().getResource("/recursos/italic.png")));
        btnNuevo = new JButton();
        btnNuevo.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        btnAbrir = new JButton();
        btnAbrir.setIcon(new ImageIcon(getClass().getResource("/recursos/open.png")));
        btnGuardar = new JButton();
        btnGuardar.setIcon(new ImageIcon(getClass().getResource("/recursos/save.png")));
        btnImprimir = new JButton();
        btnImprimir.setIcon(new ImageIcon(getClass().getResource("/recursos/new.png")));
        btnCopiar = new JButton();
        btnCopiar.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        btnCopiar2 = new JButton();
        btnCopiar2.setIcon(new ImageIcon(getClass().getResource("/recursos/copy.png")));
        btnCortar2 = new JButton();
        btnCortar2.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        btnCortar = new JButton();
        btnCortar.setIcon(new ImageIcon(getClass().getResource("/recursos/cut.png")));
        btnPegar = new JButton();
        btnPegar.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        btnPegar2 = new JButton();
        btnPegar2.setIcon(new ImageIcon(getClass().getResource("/recursos/paste.png")));
        btnBold = new JButton();
        btnBold.setIcon(new ImageIcon(getClass().getResource("/recursos/bold.png")));
        panelCentro = new JPanel();
        panelSuperior = new JPanel();
        labelLetra = new JLabel("Tipo de Letra");
        labelTamanio = new JLabel("Tamaño de la Letra");
        textArea = new JTextArea();
    }

    private void configurarMenu() {
        barraMenu.add(mArchivo);
        mArchivo.add(mItemNuevo);
        mArchivo.add(mItemAbrir);
        mArchivo.add(mItemCerrar);
        mArchivo.add(mItemGuardar);
        mArchivo.add(mItemGuardarComo);
        mArchivo.addSeparator();
        mArchivo.add(mItemImprimir);
        barraMenu.add(mEdicion);
        mEdicion.add(mItemCopiar);
        mEdicion.add(mItemCortar);
        mEdicion.add(mItemPegar);
        mEdicion.addSeparator();
        mEdicion.add(mEstiloFuente);
        mEstiloFuente.add(mItemNormal);
        mEstiloFuente.add(mItemBold);
        mEstiloFuente.add(mItemCursiva);
        this.setJMenuBar(barraMenu);
    }

    private void configurarPanel() {
        this.setLayout(new BorderLayout());
        this.add(configurarSuperior(),BorderLayout.NORTH);
        this.add(textArea,BorderLayout.CENTER);
    }

    private JPanel configurarSuperior()  {
        panelSuperior.setLayout(new GridBagLayout());
        configurarGridBag(0,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnNuevo);
        configurarGridBag(1,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnAbrir);
        configurarGridBag(2,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnGuardar);
        configurarGridBag(3,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnImprimir);
        configurarGridBag(4,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnCopiar2);
        configurarGridBag(5,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnCortar2);
        configurarGridBag(6,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnPegar2);
        configurarGridBag(7,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,btnBold);
        configurarGridBag(8,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,labelLetra);
        configurarGridBag(9,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,comboLetra);
        configurarGridBag(10,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,labelTamanio);
        configurarGridBag(11,0,1,1,0,0.2, GridBagConstraints.CENTER,
                GridBagConstraints.WEST,comboTamanio);
        return panelSuperior;
    }

    private void rellenarTamanio() {
        for (int i = 8; i <= 100; i++) {
            modeloTamanio.addElement(i);
        }
    }

    private void rellenarLetras() {
        Font[] fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getAllFonts();

        for (Font item : fuentes) {

            modeloLetra.addElement(item.getName());
        }
    }

    private void configurarGridBag(int pX, int pY, int tX, int tY,double peX, double peY, int anc,
                                   int fill, JComponent component) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = pX;
        constraints.gridy = pY;
        constraints.gridwidth = tX;
        constraints.gridheight = tY;
        constraints.weightx = peX;
        constraints.weighty = peY;
        constraints.fill = fill;
        constraints.anchor = anc;
        panelSuperior.add(component,constraints);
    }

    private void acciones() {
        comboLetra.addItemListener(this);
        comboTamanio.addItemListener(this);
        btnNuevo.addActionListener(this);
        mItemNuevo.addActionListener(this);
        mItemGuardar.addActionListener(this);
        btnGuardar.addActionListener(this);
        btnAbrir.addActionListener(this);
        mItemAbrir.addActionListener(this);
        mItemCerrar.addActionListener(this);
        btnBold.addActionListener(this);
        mItemNormal.addActionListener(this);
        mItemBold.addActionListener(this);
        btnCortar.addActionListener(this);
        btnCopiar.addActionListener(this);
        btnPegar.addActionListener(this);
    }

    private void cambiarLetras() {
        Font fuente = new Font((String) modeloLetra.getSelectedItem(),
                comboTamanio.getSelectedIndex(),
                (int) modeloTamanio.getSelectedItem());
        textArea.setFont(fuente);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == comboLetra) {
            cambiarLetras();
        } else if (e.getSource() == comboTamanio) {
            cambiarLetras();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mItemAbrir) {
            fileChooser.showOpenDialog(this);
        }else if (e.getSource()==btnAbrir) {
            fileChooser.showOpenDialog(this);
        }else if (e.getSource()==btnGuardar) {
            fileChooser.showSaveDialog(this);
        }else if (e.getSource()==mItemGuardar){
            fileChooser.showSaveDialog(this);
        }else if (e.getSource()==mItemNuevo){
            textArea.setText("");
        }else if (e.getSource()==btnNuevo){
            textArea.setText("");
        }else if (e.getSource()==mItemCerrar){
            setVisible(false);
        }else if (e.getSource()==btnBold) {
            Font negrita = new Font((String) modeloLetra.getSelectedItem(), Font.BOLD, (int) modeloTamanio.getSelectedItem());
            textArea.setFont(negrita);
        }else if (e.getSource()==mItemBold) {
            Font negrita = new Font((String) modeloLetra.getSelectedItem(), Font.BOLD, (int) modeloTamanio.getSelectedItem());
            textArea.setFont(negrita);
        }else if (e.getSource()==btnCopiar){
            textArea.getSelectedText();
        }else if (e.getSource()==btnPegar){
            textArea.getSelectedText();
        }else if (e.getSource()==btnCortar){
            textArea.getSelectedText();
            textArea.setText("");
        }else if (e.getSource()==mItemGuardarComo){
            fileChooser.showSaveDialog(this);
        }else if (e.getSource()==mItemNormal){
            Font normal = new Font((String) modeloLetra.getSelectedItem(),Font.PLAIN ,(int) modeloTamanio.getSelectedItem());
            textArea.setFont(normal);
        }else if (e.getSource()== mItemCursiva){
            Font normal = new Font((String) modeloLetra.getSelectedItem(),Font.ITALIC ,(int) modeloTamanio.getSelectedItem());
            textArea.setFont(normal);
        }
    }
}