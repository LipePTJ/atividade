import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

void main() {

        JFrame tela = new JFrame("Adoção");
        tela.setSize(500, 400);
        tela.setLayout(null);

        JLabel labelNome = new JLabel("Nome");
        labelNome.setBounds(20, 20, 150, 30);
        tela.add(labelNome);

        JTextField nome = new JTextField();
        nome.setBounds(20, 50, 440, 30);
        tela.add(nome);

        JLabel labelIdade = new JLabel("Idade");
        labelIdade.setBounds(20, 90, 150, 30);
        tela.add(labelIdade);

        JTextField Idade = new JTextField();
        Idade.setBounds(20, 120, 440, 30);
        tela.add(Idade);

        JLabel labelTipo = new JLabel("Tipo");
        labelTipo.setBounds(20, 160, 150, 30);
        tela.add(labelTipo);

        JTextField Tipo = new JTextField();
        Tipo.setBounds(20, 190, 440, 30);
        tela.add(Tipo);

        JLabel labelRaca = new JLabel("Raça");
        labelRaca.setBounds(20, 230, 150, 30);
        tela.add(labelRaca);

        JTextField Raca = new JTextField();
        Raca.setBounds(20, 260, 440, 30);
        tela.add(Raca);

        JLabel labelEndereco = new JLabel("endereço");
        labelEndereco.setBounds(20, 300, 150, 30);
        tela.add(labelEndereco);

        JTextField Endereco = new JTextField();
        Endereco.setBounds(20, 330, 440, 30);
        tela.add(Endereco);

        JLabel labelTelefone = new JLabel("Telefone");
        labelTelefone.setBounds(20, 370, 150, 30);
        tela.add(labelTelefone);

        JTextField Telefone = new JTextField();
        Telefone.setBounds(20, 400, 440, 30);
        tela.add(Telefone);


        JButton enviar = new JButton("enviar");
        enviar.setBounds(175, 470, 150, 40);
        tela.add(enviar);


    enviar.addActionListener(e ->{
        String sql = "INSERT INTO animal(Nome, Idade, Tipo, Raca, Endereco, Telefone) VALUES (?,?,?,?,?,?)";
        String nomeAnimal = nome.getText();
        String idadeAnimal = Idade.getText();
        String tipoAnimal = Tipo.getText();
        String racaAnimal = Raca.getText();
        String enderecoAnimal = Endereco.getText();
        String telefoneAnimal = Telefone.getText();

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

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    });

    tela.setVisible(true);
}
