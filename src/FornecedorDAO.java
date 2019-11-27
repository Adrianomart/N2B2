import factory.Conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public static void salvar(Fornecedor fornecedor) throws Exception {
        if (fornecedor.getCodigo() == 0) {
            inserir(fornecedor);
        } else {
            alterar(fornecedor);
        }
    }

    public static void inserir(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO TBFORNECEDOR (NOME, CNPJ) VALUES (?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, fornecedor.getNome());
        ps.setString(2, fornecedor.getCnpj());
        ps.execute();
        c.confirmar();
    }

    public static void alterar(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TBFORNECEDOR SET NOME=?, CNPJ=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, fornecedor.getNome());
        ps.setString(2, fornecedor.getCnpj());
        ps.setInt(3, fornecedor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    public static void excluir(Fornecedor fornecedor) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM TBFORNECEDOR WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, fornecedor.getCodigo());
        ps.execute();
        c.confirmar();
    }


    public static List<Fornecedor> listar() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBFORNECEDOR";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List listaFornecedors = new ArrayList<>();
        while (rs.next()) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setCodigo(rs.getInt("CODIGO"));
            fornecedor.setNome(rs.getString("NOME"));
            fornecedor.setCnpj(rs.getString("CNPJ"));
            listaFornecedors.add(fornecedor);
        }

        return listaFornecedors;
    }

    public static Fornecedor recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBFORNECEDOR WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Fornecedor fornecedor = new Fornecedor();
        if (rs.next()) {
            fornecedor.setCodigo(rs.getInt("CODIGO"));
            fornecedor.setNome(rs.getString("NOME"));
            fornecedor.setCnpj(rs.getString("CNPJ"));
        }

        return fornecedor;
    }
}