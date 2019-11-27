

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FornecedoresController
 */
@WebServlet("/Fornecedores")
public class FornecedoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     
	private FornecedorDAO service;
	
    public FornecedoresController() {
        super();
        service = new FornecedorDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	
		
		List<Fornecedor> fornecedores = new ArrayList<>();
		
		try {
			fornecedores = service.listar();
			
			for(int i = 0; i < fornecedores.size(); i++) {
				System.out.print(fornecedores.get(i).getNome());
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("suppliers", fornecedores); // Will be available as ${products} in JSP
        request.getRequestDispatcher("/WEB-INF/suppliers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String cnpj = request.getParameter("cnpj");
		String nome = request.getParameter("nome");
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCnpj(cnpj);
		fornecedor.setNome(nome);
		
		try {
			service.inserir(fornecedor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("OK !", "Fornecedor Cadastrado");
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
