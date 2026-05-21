import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        JFrame tela = new JFrame("Cadastro para Adoção");
        tela.setSize(600, 520);
        tela.setLayout(null);

        JLabel labelNome = new JLabel("Nome");
        labelNome.setBounds(20, 20, 150, 25);
        tela.add(labelNome);

        JTextField nome = new JTextField();
        nome.setBounds(20, 45, 250, 30);
        tela.add(nome);

        JLabel labelIdade = new JLabel("Idade");
        labelIdade.setBounds(20, 85, 150, 25);
        tela.add(labelIdade);

        JTextField idade = new JTextField();
        idade.setBounds(20, 110, 250, 30);
        tela.add(idade);

        JLabel labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(20, 150, 150, 25);
        tela.add(labelTipo);

        JComboBox<Tipo> textTipo = new JComboBox<>(Tipo.values());
        textTipo.setBounds(20, 175, 250, 30);
        tela.add(textTipo);

        JLabel labelRaca = new JLabel("Raça");
        labelRaca.setBounds(20, 215, 150, 25);
        tela.add(labelRaca);

        JTextField raca = new JTextField();
        raca.setBounds(20, 240, 250, 30);
        tela.add(raca);

        JLabel labelEndereco = new JLabel("Endereço");
        labelEndereco.setBounds(20, 280, 150, 25);
        tela.add(labelEndereco);

        JTextField endereco = new JTextField();
        endereco.setBounds(20, 305, 250, 30);
        tela.add(endereco);

        JLabel labelTelefone = new JLabel("Telefone");
        labelTelefone.setBounds(20, 345, 150, 25);
        tela.add(labelTelefone);

        JTextField telefone = new JTextField();
        telefone.setBounds(20, 370, 250, 30);
        tela.add(telefone);

        JButton enviar = new JButton("Enviar");
        enviar.setBounds(20, 420, 150, 40);
        tela.add(enviar);

        enviar.addActionListener(actionEvent -> {

            String nomeAnimal = nome.getText();
            String idadeAnimal = idade.getText();
            String tipoAnimal = textTipo.getSelectedItem().toString();
            String racaAnimal = raca.getText();
            String enderecoAnimal = endereco.getText();
            String telefoneAnimal = telefone.getText();

            String sql = "INSERT INTO pets(nome, idade, tipo, raca, endereco, telefone) VALUES (?,?,?,?,?,?)";

            try {
                Connection conexao = Conexao.conectar();
                PreparedStatement ps = conexao.prepareStatement(sql);

                ps.setString(1, nomeAnimal);
                ps.setString(2, idadeAnimal);
                ps.setString(3, tipoAnimal);
                ps.setString(4, racaAnimal);
                ps.setString(5, enderecoAnimal);
                ps.setString(6, telefoneAnimal);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Animal salvo com sucesso!");
                ps.close();
                conexao.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        tela.setVisible(true);
    }
}
