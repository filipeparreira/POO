package ex09;

/*
Exercicio 09
Autor(es): Filipe Augusto Parreira Almeida
Data: 15/06/2023
*/

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex09 extends JFrame{
    private ButtonGroup grupoBotoes;
    private JRadioButton radioMasculino;
    private JRadioButton radioFeminino;
    private JButton botaoCadastrar;
    private JLabel labelNome;
    private JLabel labelCargo;
    private JTextField campoNome;
    private JTextField campoCargo;
    private Genero generoSelecionado;
    
    public class GeneroMasculino implements Genero {
        @Override
        public String getDescricao() {
            return "Masculino";
        }
    }
    public class GeneroFeminino implements Genero {
        @Override
        public String getDescricao() {
            return "Feminino";
        }
    }

    public Ex09() {
        grupoBotoes = new ButtonGroup();

        radioMasculino = new JRadioButton("Masculino");
        radioFeminino = new JRadioButton("Feminino");

        grupoBotoes.add(radioMasculino);
        grupoBotoes.add(radioFeminino);
        
        campoNome = new JTextField("", 20);
        campoCargo = new JTextField("", 20);
        labelNome = new JLabel("Nome: ");
        labelCargo = new JLabel("Cargo: ");

        botaoCadastrar = new JButton("Cadastrar");

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioMasculino.isSelected()) {
                    generoSelecionado = new GeneroMasculino();
                } else if (radioFeminino.isSelected()) {
                    generoSelecionado = new GeneroFeminino();
                }
                cadastrarFuncionario();
            }
        });
        
        add(labelNome);
        add(campoNome);
        add(labelCargo);
        add(campoCargo);
        add(radioMasculino);
        add(radioFeminino);
        add(botaoCadastrar);
    }

    private void cadastrarFuncionario() {
        String nome = campoNome.getText();
        String cargo = campoCargo.getText();
        Funcionario funcionario = new Funcionario(nome, cargo, 0, "", generoSelecionado.getDescricao());
        String mensagem = "Funcionário: " + funcionario.getNome()+ ", cargo: " + funcionario.getCargo() + ", genero: " + funcionario.getGenero() +  ", cadastrado com sucesso.";
        JOptionPane.showMessageDialog(null, mensagem, "Cadastro", JOptionPane.PLAIN_MESSAGE);
        
    }

    public static void main(String[] args) {
        Ex09 principal = new Ex09();
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setSize(300, 150);
        principal.setLayout(new FlowLayout());
        principal.setVisible(true);
    }
    
}
