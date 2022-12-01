import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class hackersim extends JFrame {

    private static final String server = "jdbc:mysql://localhost:3306/hackerSimulator";
    private static final String serverLogin = "root";
    private static final String serverPasswd = "";

    static final DecimalFormat formatter = new DecimalFormat("##,###");
    static boolean running = true;

    Long dinheiro;
    int upgrade;

    protected JPanel hacksPro;
    protected JPanel hackear;
    protected JPanel comprar;
    private JPanel mainPanel;
    private JLabel moneyLabel;
    private JTabbedPane tabbedPane;
    private JButton hack1Button;
    private JButton hack2Button;
    private JButton hack3Button;
    private JButton hack4Button;
    private JButton hack5Button;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    private JProgressBar progressBar5;
    private JButton unlock1;
    private JButton unlock2;
    private JButton unlock3;
    private JButton unlock4;
    private JButton unlock5;
    private JLabel unlock5Label;
    private JButton saveButton;
    private JLabel userLabel;
    private JButton startMasterHack1;
    private JButton startMasterHack2;
    private JButton startMasterHack3;

    public hackersim(int idUser,String user, Long dinheiroLogin,int upgradeLogin) {
        super("Hacker Simulator 2");

        dinheiro = dinheiroLogin;
        upgrade = upgradeLogin;

        this.setMinimumSize(new Dimension(800, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);

        moneyLabel.setBorder(new EmptyBorder(5, 3, 3, 3));
        userLabel.setText(user);
        tabbedPane.setEnabledAt(2, false);

        class loading extends Thread {
            public void run() {
                if (upgrade >= 1) {
                    hack2Button.setEnabled(true);
                    hack2Button.setText("Enganar pessoas no calculo");
                    unlock1.setEnabled(false);
                    unlock1.setText("Comprar calculadora (Comprado)");
                    unlock2.setText("Comprar nokia");
                    unlock2.setEnabled(true);
                }
                if (upgrade >= 2) {
                    hack3Button.setEnabled(true);
                    hack3Button.setText("Hackear bicicletas");
                    unlock2.setEnabled(false);
                    unlock2.setText("Comprar nokia (Comprado)");
                    unlock3.setText("Comprar android");
                    unlock3.setEnabled(true);
                }
                if (upgrade >= 3) {
                    hack4Button.setEnabled(true);
                    hack4Button.setText("Hackear contas de Roblox");
                    unlock3.setEnabled(false);
                    unlock3.setText("Comprar android (Comprado)");
                    unlock4.setText("Comprar PC sem placa");
                    unlock4.setEnabled(true);
                }
                if (upgrade >= 4) {
                    hack5Button.setEnabled(true);
                    hack5Button.setText("Hackear contas de Free Fire");
                    unlock4.setEnabled(false);
                    unlock4.setText("Comprar PC sem placa (Comprado)");
                    unlock5.setVisible(true);
                    unlock5Label.setVisible(true);
                }
                if (upgrade >= 5) {
                    tabbedPane.setEnabledAt(2, true);
                    unlock5.setText("Comprar PC com placa de vídeo (Comprado)");
                    unlock5.setEnabled(false);
                    unlock5Label.setVisible(false);
                    tabbedPane.setEnabledAt(2, true);
                }
                if (upgrade >= 6) {
                    startMasterHack1.setEnabled(false);
                    startMasterHack2.setEnabled(false);
                    startMasterHack3.setText("Hackear Banco central");
                    startMasterHack3.setEnabled(true);
                }

            }

        }

        class moneyUpdater extends Thread {
            public void run() {
                while (running) moneyLabel.setText("Dinheiros: R$" + formatter.format(dinheiro));
            }
        }

        new loading().start();
        new moneyUpdater().start();

        class hack1 extends Thread {
            public void run() {
                if (progressBar1.getValue() == 0) {
                    while (progressBar1.getValue() < 100) try {
                        TimeUnit.MILLISECONDS.sleep(50);
                        progressBar1.setValue(progressBar1.getValue() + 1);
                    } catch (InterruptedException ignored) {
                    }
                    dinheiro = dinheiro + 3;
                    progressBar1.setValue(0);
                }
            }
        }
        class hack2 extends Thread {
            public void run() {
                if (progressBar2.getValue() == 0) {
                    while (progressBar2.getValue() < 100) try {
                        TimeUnit.MILLISECONDS.sleep(100);
                        progressBar2.setValue(progressBar2.getValue() + 1);
                    } catch (InterruptedException ignored) {
                    }
                    dinheiro = dinheiro + 10;
                    progressBar2.setValue(0);
                }
            }
        }
        class hack3 extends Thread {
            public void run() {
                if (progressBar3.getValue() == 0) {
                    while (progressBar3.getValue() < 100) try {
                        TimeUnit.MILLISECONDS.sleep(150);
                        progressBar3.setValue(progressBar3.getValue() + 1);
                    } catch (InterruptedException ignored) {
                    }
                    dinheiro = dinheiro + 50;
                    progressBar3.setValue(0);
                }
            }
        }
        class hack4 extends Thread {
            public void run() {
                if (progressBar4.getValue() == 0) {
                    while (progressBar4.getValue() < 100) try {
                        TimeUnit.MILLISECONDS.sleep(200);
                        progressBar4.setValue(progressBar4.getValue() + 1);
                    } catch (InterruptedException ignored) {
                    }
                    dinheiro = dinheiro + 200;
                    progressBar4.setValue(0);
                }
            }
        }
        class hack5 extends Thread {
            public void run() {
                if (progressBar5.getValue() == 0) {
                    while (progressBar5.getValue() < 100) try {
                        TimeUnit.MILLISECONDS.sleep(250);
                        progressBar5.setValue(progressBar5.getValue() + 1);
                    } catch (InterruptedException ignored) {
                    }
                    dinheiro = dinheiro + 500;
                    progressBar5.setValue(0);
                }
            }
        }

        hack1Button.addActionListener(e -> new hack1().start());
        hack2Button.addActionListener(e -> new hack2().start());
        hack3Button.addActionListener(e -> new hack3().start());
        hack4Button.addActionListener(e -> new hack4().start());
        hack5Button.addActionListener(e -> new hack5().start());

        unlock1.addActionListener(e -> {
            if (dinheiro >= 10) {
                dinheiro = dinheiro - 10;
                upgrade = 1;
                new loading().start();
            }
        });
        unlock2.addActionListener(e -> {
            if (dinheiro >= 50) {
                dinheiro = dinheiro - 50;
                upgrade = 2;
                new loading().start();
            }
        });
        unlock3.addActionListener(e -> {
            if (dinheiro >= 200) {
                dinheiro = dinheiro - 200;
                upgrade = 3;
                new loading().start();
            }
        });
        unlock4.addActionListener(e -> {
            if (dinheiro >= 1000) {
                dinheiro = dinheiro - 1000;
                upgrade = 4;
                new loading().start();
            }
        });
        unlock5.addActionListener(e -> {
            if (dinheiro >= 5000) {
                dinheiro = dinheiro - 5000;
                upgrade = 5;
                new loading().start();
            }
        });

        startMasterHack1.addActionListener(e -> new masterHack1());
        startMasterHack2.addActionListener(e -> new masterHack2());
        startMasterHack3.addActionListener(e -> new masterHack3());

        saveButton.addActionListener(e -> {
            try {
                Connection conn = DriverManager.getConnection(server, serverLogin, serverPasswd);
                Statement stmt = conn.createStatement();
                stmt.execute("UPDATE `hackerSimulator`.`users` SET `money` = '" + dinheiro + "', `upgrade` = '" + upgrade + "' " + "WHERE (`idUsers` = '" + idUser + "');");
                stmt.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro de servidor");
            }

        });

    }

    public static class masterHack1 extends JFrame {

        private JPanel mainPanel;
        private JButton button1;

        public masterHack1() {
            super("PC do Presidente");

            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setResizable(false);
            this.pack();
            this.setVisible(true);

            button1.addActionListener(e -> new masterHack1Note());
        }

        public static class masterHack1Note extends JFrame{

            private JPanel mainPanel;

            public masterHack1Note() {
                super("senha-nasa.txt");

                this.setMinimumSize(new Dimension(400, 300));
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                this.setContentPane(mainPanel);
                this.setResizable(false);
                this.setVisible(true);
                this.pack();

            }

        }

    }

    public class masterHack2 extends JFrame {

        private JPanel mainPanel;
        private JButton loginButton;
        private JTextField userField;
        private JTextField passwdField;
        private JCheckBox checkbox;

        public masterHack2() {
            super("nasa.com.br");

            this.setMinimumSize(new Dimension(400, 400));
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setResizable(false);
            this.pack();
            this.setVisible(true);

            userField.addActionListener(e -> passwdField.requestFocus());

            loginButton.addActionListener(e -> {

                if (userField.getText().equals("astronauta") & passwdField.getText().equals("123456") & checkbox.isSelected()) {

                    startMasterHack1.setEnabled(false);
                    startMasterHack2.setEnabled(false);
                    JOptionPane.showMessageDialog(null, "Aprovado");
                    dispose();

                    JOptionPane.showMessageDialog(null, "Hackeado a NASA você conseguiu credenciais do banco central");
                    startMasterHack3.setText("Hackear Banco Central");
                    startMasterHack3.setEnabled(true);
                    upgrade = 6;

                } else {
                    JOptionPane.showMessageDialog(null, "Negado");
                }

            });
        }

    }

    public class masterHack3 extends JFrame {

        private JPanel mainPanel;
        private JTextField transferField;
        private JButton transferButton;
        private JLabel saldoBanco;

        private long dinheiroBanco = 923372036854775807L;

        public masterHack3(){
            super("bancocentral.com");

            this.setMinimumSize(new Dimension(600, 400));
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.setResizable(false);
            this.pack();
            this.setVisible(true);

            startMasterHack3.setEnabled(false);

            transferField.addActionListener(this::transfer);

            transferButton.addActionListener(this::transfer);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    int confirmed = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?\nVocê só terá apenas uma chance de hacker.", "Banco Central", JOptionPane.YES_NO_OPTION);

                    if (confirmed == JOptionPane.YES_OPTION) {
                        dispose();
                    }
                }
            });

        }

        private void transfer(ActionEvent e) {
            try {
                if (Long.parseLong(transferField.getText()) <= dinheiroBanco & Long.parseLong(transferField.getText()) >= 0) {
                    dinheiroBanco = dinheiroBanco - Long.parseLong(transferField.getText());
                    dinheiro = dinheiro + Long.parseLong(transferField.getText());
                    saldoBanco.setText("Saldo: R$ " + formatter.format(dinheiroBanco));
                    JOptionPane.showMessageDialog(null, "R$" + transferField.getText() + " transferidos com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
            }

        }

    }

}